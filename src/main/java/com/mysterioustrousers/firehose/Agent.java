package com.mysterioustrousers.firehose;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mysterioustrousers.firehose.net.FHClient;
import com.mysterioustrousers.firehose.net.FHClientOptions;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;



public class Agent extends FHObject {

  public enum UpdateType {
    AGENT_INFO,
    AGENT_SETTINGS
  }


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


  private Company _currentCompany;



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

    try {
      this.setCurrentCompany(null);
    } catch (CompanyNotFoundException e) {
      e.printStackTrace();
    }
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


  public static GsonRequest<Agent> create(String accessToken, Listener<Agent> listener, ErrorListener errorListener) {
    String url = String.format("%s/agents", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));

    JSONObject jsonObject = new JSONObject();
    JSONObject agent = new JSONObject();
    try {
      agent.put("access_token", accessToken);
      jsonObject.put("agent", agent);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<Agent>(Request.Method.POST, url, Agent.class, jsonObject, listener, errorListener);
  }


  public void update() throws JSONException {
    this.update(null, null);
  }


  public void update(Listener<String> onNoErrorListener) throws JSONException {
    this.update(onNoErrorListener, null);
  }


  public void update(ErrorListener onErrorListener) throws JSONException {
    this.update(null, onErrorListener);
  }


  public void update(Listener<String> onNoErrorListener, ErrorListener onErrorListener) throws JSONException {
    JSONObject agentJSON = new JSONObject();
    agentJSON.put("agent_settings_attributes", new JSONObject(new Gson().toJson(this.getAgentSettings())));
    agentJSON.put("first_name", getFirstName());
    agentJSON.put("last_name", getLastName());
    agentJSON.put("email", getEmail());
    /*
    if (getPassword() != null) {
      agent.put("password", getPassword());
    }
    */

    JSONObject json = new JSONObject();
    json.put("agent", agentJSON);


    FHClientOptions options = new FHClientOptions(FHApplication.API, "/agents/" + this.getId(), true);
    options.addHeader("Authorization", String.format("Token token=\"%s\"", getAccessToken()));
    options.setJSON(json);
    options.setResponseNoErrorListener(onNoErrorListener);
    options.setResponseErrorListener(onErrorListener);


    FHClient.getInstance().jsonPut(options);
  }


  public static GsonRequest<String> requestPasswordReset(String email, Listener<String> listener, ErrorListener errorListener) {
    String url = String.format("%s/request_reset_password", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API));
    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("email", email);
    } catch (Exception e) {
      errorListener.onErrorResponse(new ParseError(e));
    }

    return new GsonRequest<String>(Request.Method.POST, url, String.class, jsonObject, listener, errorListener);
  }


  public String getShortName() {
    String lastInitial = (!this.getLastName().isEmpty()) ? String.format(" %s.", this.getLastName().substring(0, 1)) : StringUtils.EMPTY;
    return String.format("%s %s", this.getFirstName(), lastInitial);
  }



  // region Companies Interface



  public List<Company> getCompanies() {
    return _companies;
  }


  public void setCompanies(List<Company> companies) {
    _companies = companies;
  }


  public void clearCompanies() {
    this.getCompanies().clear();
  }


  public boolean isInCompany(Company company) {
    return (company != null && this.isInCompany(company.getId()));
  }


  public boolean isInCompany(Object companyId) {
    return (companyId != null && this.getCompany(companyId) != null);
  }


  public Company getCompany(Object companyId) {
    if (companyId != null) {
      for (Company company : this.getCompanies()) {
        if (companyId.equals(company.getId())) {
          return company;
        }
      }
    }
    return null;
  }


  public boolean addCompany(Company company) {
    // TODO: Add functionality to add agent to company agents list
    return (!this.isInCompany(company) && this.getCompanies().add(company));
  }


  public boolean removeCompany(Product company) {
    // TODO: Add functionality to remove agent to company agents list
    return this.getCompanies().remove(company);
  }


  public Company getCurrentCompany() {
    return _currentCompany;
  }


  public void setCurrentCompanyAsOldest() {
    ArrayList<Company> tempList = new ArrayList<Company>(this.getCompanies());
    Collections.sort(tempList);

    _currentCompany = tempList.get(0);
  }


  public void setCurrentCompany(Object companyId) throws CompanyNotFoundException {
    Company company = new Company();
    company.setId(companyId);

    this.setCurrentCompany(company);
  }


  public void setCurrentCompany(Company company) throws CompanyNotFoundException {
    if (company == null || company.getId() == null) {
      _currentCompany = null;
      return;
    }

    if (this.getCurrentCompany().equals(company)) {
      return;
    }

    if (this.isInCompany(company)) {
      _currentCompany = this.getCompany(company.getId());
      return;
    }

    throw new CompanyNotFoundException(company);
  }


  // endregion



  // region Devices Interface


  public List<Device> getDevices() {
    return _devices;
  }


  public void setDevices(List<Device> devices) {
    _devices = devices;
  }


  // endregion



  // region Getters/Setters


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


  public void setNewPassword(String password) {
    // TODO: DO NOT store password! this needs to be persisted to the API immediately and then discarded from memory!!!
  }


  // endregion



  @Override
  public int compareTo(FHObject obj) {
    if (obj instanceof Agent) {
      int commonComparisonsResult = this.runCommonComparisons(obj);
      if (commonComparisonsResult != -2) {
        return commonComparisonsResult;
      }

      Agent otherAgent = (Agent)obj;

      int displayNameComparisonResult = this.getDisplayName().compareTo(otherAgent.getDisplayName());
      if (displayNameComparisonResult != 0) {
        return displayNameComparisonResult;
      }

      int emailComparisonResult = this.getEmail().compareTo(otherAgent.getEmail());
      if (emailComparisonResult != 0) {
        return emailComparisonResult;
      }
    }

    return super.compareTo(obj);
  }
}