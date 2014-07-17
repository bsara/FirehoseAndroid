package com.mysterioustrousers.firehose;



import java.util.HashMap;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;



public class Product extends FHObject {

  @SerializedName("kb_custom_domain")
  private String _kbCustomDomain;

  @SerializedName("kb_subdomain")
  private String _kbSubdomain;

  @SerializedName("name")
  private String _name;

  @SerializedName("token")
  private String _token;

  @SerializedName("website")
  private String _websiteURL;



  public Product() {
    super();

    this.setKBCustomDomain(null);
    this.setKBSubdomain(null);
    this.setName(null);
    this.setToken(null);
    this.setWebsiteURL(null);
  }

  public GsonRequest<String> emailForSnippetInstallationHelp(String toEmail, String personalMessage, String agentAccessToken, Response.Listener<String> listener, Response.ErrorListener errorListener) {
    String url = String.format("%s/products/%s/send_snippet_email", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API), _token);

    // TODO not tested
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", agentAccessToken));

    JSONObject jsonObject = new JSONObject();
    JSONObject snippetEmail = new JSONObject();
    try {
      snippetEmail.put("to_email", toEmail);
      snippetEmail.put("message", personalMessage);
      jsonObject.put("snippet_email", snippetEmail);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<String>(Request.Method.POST, url,String.class, jsonObject, listener, errorListener);

  }



  // region Getters & Setters


  public String getKBCustomDomain() {
    return _kbCustomDomain;
  }


  public void setKBCustomDomain(String kbCustomDomain) {
    _kbCustomDomain = kbCustomDomain;
  }


  public String getKBSubdomain() {
    return _kbSubdomain;
  }


  public void setKBSubdomain(String kbSubdomain) {
    _kbSubdomain = kbSubdomain;
  }


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  public String getWebsiteURL() {
    return _websiteURL;
  }


  public void setWebsiteURL(String websiteURL) {
    _websiteURL = websiteURL;
  }


  // endregion
}