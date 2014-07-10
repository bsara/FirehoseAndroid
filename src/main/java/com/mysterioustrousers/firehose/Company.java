package com.mysterioustrousers.firehose;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;
import com.mysterioustrousers.lang.StringUtils;

import org.json.JSONArray;



public class Company extends FHObject {

  @SerializedName("fetch_automatically")
  private boolean _fetchAutomatically;

  @SerializedName("forwarding_email")
  private String _forwardingEmail;

  @SerializedName("kind")
  private String _type;  // TODO: Change to CompanyType enum instead of String

  @SerializedName("last_fetch_at")
  private Date _lastFetchTime;  // TODO: Change to use Calendar object???

  @SerializedName("title")
  private String _title;

  @SerializedName("token")
  private String _token;

  @SerializedName("unresolved_count")
  private int _unresolvedCount;

  @SerializedName("number_of_accounts")
  private int _numberOfAccounts;

  @SerializedName("is_brand_new")
  private boolean _isBrandNew;

  @SerializedName("is_chat_enabled")
  private boolean _isChatEnabled;

  @SerializedName("is_premium")
  private boolean _isPremium;

  @SerializedName("agents")
  private List<Agent> _agents;  // TODO: Change from List to Set

  @SerializedName("agent_invites")
  private List<AgentInvite> _agentInvites;  // TODO: Change from List to Set

  @SerializedName("products")
  private List<Product> _products;  // TODO: Change from List to Set



  public Company() {
    super();

    this.setFetchAutomatically(false);
    this.setForwardingEmail(null);
    this.setCompanyType("desk");
    this.setLastFetchTime(null);
    this.setTitle(null);
    this.setToken(null);
    this.setUnresolvedCount(0);
    this.setNumberOfAccounts(0);
    this.setIsBrandNew(false);
    this.setIsChatEnabled(false);
    this.setIsPremium(false);
    this.setAgents(new ArrayList<Agent>());
    this.setAgentInvites(new ArrayList<AgentInvite>());
    this.setProducts(new ArrayList<Product>());
  }



  public static GsonArrayRequest fetchOnlineVisitors(String accessToken, final Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    String url = String.format("%s/online_visitors", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.CHAT_SERVER));
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token = %s", accessToken));

    return new GsonArrayRequest(url, headers, listener, errorListener);
  }



  // region Getters & Setters


  public boolean fetchAutomatically() {
    return _fetchAutomatically;
  }


  public void setFetchAutomatically(boolean fetchAutomatically) {
    _fetchAutomatically = fetchAutomatically;
  }


  public String getForwardingEmail() {
    return _forwardingEmail;
  }


  public void setForwardingEmail(String forwardingEmail) {
    _forwardingEmail = forwardingEmail;
  }


  public String getCompanyType() {
    return _type;
  }


  public void setCompanyType(String type) {
    _type = type;
  }


  public Date getLastFetchTime() {
    return _lastFetchTime;
  }


  public void setLastFetchTime(Date lastFetchTime) {
    _lastFetchTime = lastFetchTime;
  }


  public String getTitle() {
    return _title;
  }


  public void setTitle(String title) {
    _title = title;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  public int getUnresolvedCount() {
    return _unresolvedCount;
  }


  public void setUnresolvedCount(int unresolvedCount) {
    _unresolvedCount = unresolvedCount;
  }


  public int getNumberOfAccounts() {
    return _numberOfAccounts;
  }


  public void setNumberOfAccounts(int numberOfAccounts) {
    _numberOfAccounts = numberOfAccounts;
  }


  public boolean isBrandNew() {
    return _isBrandNew;
  }


  public void setIsBrandNew(boolean isBrandNew) {
    _isBrandNew = isBrandNew;
  }


  public boolean isChatEnabled() {
    return _isChatEnabled;
  }


  public void setIsChatEnabled(boolean isChatEnabled) {
    _isChatEnabled = isChatEnabled;
  }


  public boolean isPremium() {
    return _isPremium;
  }


  public void setIsPremium(boolean isPremium) {
    _isPremium = isPremium;
  }


  public List<Agent> getAgents() {
    return _agents;
  }


  public void setAgents(List<Agent> agents) {
    _agents = agents;
  }


  public List<AgentInvite> getAgentInvites() {
    return _agentInvites;
  }


  public void setAgentInvites(List<AgentInvite> invites) {
    _agentInvites = invites;
  }


  public List<Product> getProducts() {
    return _products;
  }


  public void setProducts(List<Product> products) {
    _products = products;
  }


  // endregion



  public enum CompanyType {
    DESK,
    CHAT;


    public static CompanyType fromString(String companyTypeStr) {
      if (StringUtils.isNullOrWhiteSpace(companyTypeStr)) {
        return null;
      }

      String companyTypeStrTemp = companyTypeStr.trim().toLowerCase();
      if (companyTypeStrTemp.equals(CompanyType.DESK.toString())) {
        return CompanyType.DESK;
      }
      if (companyTypeStrTemp.equals(CompanyType.CHAT.toString())) {
        return CompanyType.CHAT;
      }
      return null;
    }


    @Override
    public String toString() {
      switch (this) {
        case DESK:
          return "desk";
        case CHAT:
          return "chat";
      }
      return null;
    }
  }
}