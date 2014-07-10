package com.mysterioustrousers.firehose;



import java.util.HashMap;
import java.util.Map;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;



public class Device extends FHObject {

  @SerializedName("device_identifier")
  private String _id;

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



  public static GsonRequest<Device> create(Agent agent, String token, String model, String bundleId,
                                           String locale, String language, String timezone,
                                           Listener<Device> listener, ErrorListener errorListener) {
    String url = String.format("%s/devices", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));
    String uuid = FHObject.generatedUUID(); // Just generate a uuid, since android's isn't guaranteed
    String environment = "production"; // dev and prod are the same
    String ipAddress = "0.0.0.0"; // why is this needed?

    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", agent.getAccessToken()));

    JSONObject device = new JSONObject();
    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("token", token);
      jsonObject.put("environment", environment);
      jsonObject.put("name", model);
      jsonObject.put("model", model);
      jsonObject.put("device_identifier", uuid);
      jsonObject.put("bundle_identifier", bundleId);
      jsonObject.put("locale", locale);
      jsonObject.put("language", language);
      jsonObject.put("timezone", timezone);
      jsonObject.put("ip_address", ipAddress);
      jsonObject.put("platform", "google");
      device.put("device", jsonObject);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<Device>(Request.Method.POST, url, Device.class, headers, device, listener, errorListener);
  }



  // region Getters & Setters


  @Override
  public Object getId() {
    return _id;
  }


  @Override
  public void setId(Object id) {
    _id = id.toString();
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
