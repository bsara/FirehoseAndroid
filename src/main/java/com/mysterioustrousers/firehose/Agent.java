package com.mysterioustrousers.firehose;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;



public class Agent extends FHObject {

  private static transient Agent s_loggedInAgent = null;


  @SerializedName("access_token")
  private String _accessToken;

  @SerializedName("browser_token")
  private String _browserToken;

  @SerializedName("email")
  private String _email;

  @SerializedName("first_name")
  private String _firstName;

  @SerializedName("last_name")
  private String _lastName;

  @SerializedName("url_token")
  private String _urlToken;

  @SerializedName("display_name")
  private String _displayName;

  @SerializedName("avatar_url")
  private String _avatarURL;

  @SerializedName("agent_settings")
  private AgentSettings _agentSettings;

  @SerializedName("companies")
  private List<Company> _companies;  // TODO: Change from List to Set

  @SerializedName("devices")
  private List<Device> _devices;  // TODO: Change from List to Set



  public Agent() {
    super();

    this.setAccessToken(null);
    this.setBrowserToken(null);
    this.setEmail(null);
    this.setFirstName(null);
    this.setLastName(null);
    this.setURLToken(null);
    this.setDisplayName(null);
    this.setAvatarURL(null);
    this.setAgentSettings(new AgentSettings());
    this.setCompanies(new ArrayList<Company>());
    this.setDevices(new ArrayList<Device>());
  }



  public static GsonRequest<Agent> login(String email, String password, Listener<Agent> listener, ErrorListener errorListener) {
    String url = String.format("%s/login", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));

    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("email", email);
      jsonObject.put("password", password);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<Agent>(Request.Method.POST, url, Agent.class, jsonObject, listener, errorListener);
  }


  public static GsonRequest<Agent> login(String accessToken, Listener<Agent> listener, ErrorListener errorListener) {
    String url = String.format("%s/login", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));

    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", accessToken));

    return new GsonRequest<Agent>(Request.Method.POST, url, Agent.class, headers, null, listener, errorListener);
  }


  public static GsonRequest<Agent> create(String email, String password, String firstName, String lastName, Listener<Agent> listener, ErrorListener errorListener) {
    String url = String.format("%s/agents", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));

    JSONObject jsonObject = new JSONObject();
    JSONObject agent = new JSONObject();
    try {
      agent.put("email", email);
      agent.put("first_name", firstName);
      agent.put("last_name", lastName);
      agent.put("password", password);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
      agent.put("last_request_at", sdf.format(new Date()));
      jsonObject.put("agent", agent);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<Agent>(Request.Method.POST, url, Agent.class, jsonObject, listener, errorListener);
  }


  public String getShortName() {
    String lastInitial = (!this.getLastName().isEmpty()) ? String.format(" %s.", this.getLastName().substring(0, 1)) : StringUtils.EMPTY;
    return String.format("%s %s", this.getFirstName(), lastInitial);
  }



  // region Getters & Setters


  public static Agent getLoggedInAgent() {
    return s_loggedInAgent;
  }


  public static void setLoggedInAgent(Agent agent) {
    s_loggedInAgent = agent;
  }


  public String getAccessToken() {
    return _accessToken;
  }


  public void setAccessToken(String accessToken) {
    _accessToken = accessToken;
  }


  public String getBrowserToken() {
    return _browserToken;
  }


  public void setBrowserToken(String browserToken) {
    _browserToken = browserToken;
  }


  public String getEmail() {
    return _email;
  }


  public void setEmail(String email) {
    _email = email;
  }


  public String getFirstName() {
    return _firstName;
  }


  public void setFirstName(String firstName) {
    _firstName = firstName;
  }


  public String getLastName() {
    return _lastName;
  }


  public void setLastName(String lastName) {
    _lastName = lastName;
  }


  public String getURLToken() {
    return _urlToken;
  }


  public void setURLToken(String urlToken) {
    _urlToken = urlToken;
  }


  public String getDisplayName() {
    return _displayName;
  }


  public void setDisplayName(String displayName) {
    _displayName = displayName;
  }


  public String getAvatarURL() {
    return _avatarURL;
  }


  public void setAvatarURL(String avatarURL) {
    _avatarURL = avatarURL;
  }


  public AgentSettings getAgentSettings() {
    return _agentSettings;
  }


  public void setAgentSettings(AgentSettings agentSettings) {
    _agentSettings = agentSettings;
  }


  public List<Company> getCompanies() {
    return _companies;
  }


  public void setCompanies(List<Company> companies) {
    _companies = companies;
  }


  public List<Device> getDevices() {
    return _devices;
  }


  public void setDevices(List<Device> devices) {
    _devices = devices;
  }


  // endregion
}