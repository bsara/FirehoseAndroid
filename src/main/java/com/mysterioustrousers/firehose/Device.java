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

  @SerializedName("token")
  public String token;

  @SerializedName("environment")
  public String environment;

  @SerializedName("name")
  public String name;

  @SerializedName("model")
  public String model;

  @SerializedName("device_identifier")
  public String deviceIdentifier;

  @SerializedName("bundle_identifier")
  public String bundleIndentifier;

  @SerializedName("locale")
  public String locale;

  @SerializedName("language")
  public String language;

  @SerializedName("timezone")
  public String timezone;

  @SerializedName("ip_address")
  public String ipAddress;


  public static GsonRequest<Device> create(Agent agent, String token, String model, String bundleIndentifier,
                                           String locale, String language, String timezone,
                                           Listener<Device> listener, ErrorListener errorListener) {
    String url = String.format("/devices", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));
    String uuid = FHObject.generatedUUID(); // Just generate a uuid, since android's isn't garenteed
    String environment = "production"; // dev and prod are the same
    String ipAddress = "0.0.0.0"; // why is this needed?

    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", agent.accessToken));

    JSONObject device = new JSONObject();
    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("token", token);
      jsonObject.put("environment", environment);
      jsonObject.put("name", model);
      jsonObject.put("model", model);
      jsonObject.put("device_identifier", uuid);
      jsonObject.put("bundle_identifier", bundleIndentifier);
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
}
