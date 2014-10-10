package com.mysterioustrousers.firehose;



import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.annotations.SerializedName;
import com.mysterioustrousers.firehose.net.FHClient;
import com.mysterioustrousers.firehose.net.FHClientOptions;

import org.json.JSONException;
import org.json.JSONObject;



public class Device extends FHObject<Double> { // FIXME: Why id a Double? Why not an Integer???


  @SerializedName("device_identifier")
  private String _deviceIdentifier;

  @SerializedName("token")
  private String _token;

  @SerializedName("environment")
  private String _env;

  @SerializedName("name")
  private String _name;

  @SerializedName("model")
  private String _model;

  @SerializedName("bundle_identifier")
  private String _bundleId;

  @SerializedName("locale")
  private String _locale;

  @SerializedName("language")
  private String _language;

  @SerializedName("timezone")
  private String _timeZone;

  @SerializedName("ip_address")
  private String _ipAddress;



  public Device() {
    super();

    this.setDeviceIdentifier(null);
    this.setToken(null);
    this.setEnvironment(null);
    this.setName(null);
    this.setModel(null);
    this.setBundleId(null);
    this.setLocale(null);
    this.setLanguage(null);
    this.setTimeZone(null);
    this.setIPAddress(null);
  }



  // region Static Server Action: create


  // TODO: Should this crate method just be made non-static? Then you would just have to set up a Device object instead of passing a billion parameters.
  //       You would also be able to just take a gson of the object instead of manually placing everything in JSON! Why are we using gson if we aren't taking full advantage of it?!!!


  public static void create(Agent agent, String token, String model, String bundleId, String locale, String language, String timezone) throws JSONException {
    Device.create(agent, token, model, bundleId, locale, language, timezone, null, null);
  }


  public static void create(Agent agent, String token, String model, String bundleId, String locale, String language, String timezone, Listener<Device> onSuccessListener) throws JSONException {
    Device.create(agent, token, model, bundleId, locale, language, timezone, onSuccessListener, null);
  }


  public static void create(Agent agent, String token, String model, String bundleId, String locale, String language, String timezone, ErrorListener onErrorListener) throws JSONException {
    Device.create(agent, token, model, bundleId, locale, language, timezone, null, onErrorListener);
  }


  public static void create(Agent agent, String token, String model, String bundleId, String locale, String language, String timezone, Listener<Device> onSuccessListener, ErrorListener onErrorListener) throws JSONException {
    // FIXME: change to set environment according to whatever is et in EnvironmentManager
    String environment = "production"; // dev and prod are the same

    JSONObject deviceJSON = new JSONObject();
    deviceJSON.put("token", token);
    deviceJSON.put("environment", environment);
    deviceJSON.put("name", model);
    deviceJSON.put("model", model);
    deviceJSON.put("device_identifier", FHObject.generateUUID());
    deviceJSON.put("bundle_identifier", bundleId);
    deviceJSON.put("locale", locale);
    deviceJSON.put("language", language);
    deviceJSON.put("timezone", timezone);
    deviceJSON.put("ip_address", "0.0.0.0"); // TODO: Why is this needed?
    deviceJSON.put("platform", "google");

    FHClientOptions options = new FHClientOptions(FHApplication.API, "/devices", true);
    options.addHeader("Authorization", String.format("Token token=\"%s\"", agent.getAccessToken()));
    options.setJSON(new JSONObject().put("device", deviceJSON));
    options.setResponseSuccessListener(onSuccessListener);
    options.setResponseErrorListener(onErrorListener);

    FHClient.getInstance().jsonPost(options, Device.class);
  }


  // endregion



  // region Getters/Setters


  public String getDeviceIdentifier() {
    return _deviceIdentifier;
  }


  public void setDeviceIdentifier(String deviceIdentifier) {
    _deviceIdentifier = deviceIdentifier;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  public String getEnvironment() {
    return _env;
  }


  public void setEnvironment(String env) {
    _env = env;
  }


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public String getModel() {
    return _model;
  }


  public void setModel(String model) {
    _model = model;
  }


  public String getBundleId() {
    return _bundleId;
  }


  public void setBundleId(String bundleId) {
    _bundleId = bundleId;
  }


  public String getLocale() {
    return _locale;
  }


  public void setLocale(String locale) {
    _locale = locale;
  }


  public String getLanguage() {
    return _language;
  }


  public void setLanguage(String language) {
    _language = language;
  }


  public String getTimeZone() {
    return _timeZone;
  }


  public void setTimeZone(String timeZone) {
    _timeZone = timeZone;
  }


  public String getIPAddress() {
    return _ipAddress;
  }


  public void setIPAddress(String ipAddress) {
    _ipAddress = ipAddress;
  }


  // endregion
}