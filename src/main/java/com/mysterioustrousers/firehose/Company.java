package com.mysterioustrousers.firehose;



import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

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
  private SortedSet<Agent> _agents;

  @SerializedName("agent_invites")
  private SortedSet<AgentInvite> _agentInvites;

  @SerializedName("products")
  private SortedSet<Product> _products;


  private Product _currentProduct;



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
    this.setAgents(new TreeSet<Agent>(Agent.getDefaultComparator()));
    this.setAgentInvites(new TreeSet<AgentInvite>(AgentInvite.getDefaultComparator()));
    this.setProducts(new TreeSet<Product>(Product.getDefaultComparator()));

    try {
      this.setCurrentProduct(null);
    } catch (ProductNotFoundException e) {
      e.printStackTrace();
    }
  }



  public static GsonArrayRequest fetchOnlineVisitors(String accessToken, final Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    String url = String.format("%s/online_visitors", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.CHAT_SERVER));
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token = %s", accessToken));

    return new GsonArrayRequest(url, headers, listener, errorListener);
  }



  // region Agents Interface


  public SortedSet<Agent> getAgents() {
    return _agents;
  }


  public void setAgents(SortedSet<Agent> agents) {
    _agents = agents;
  }


  // endregion



  // region Agent Invites Interface


  public SortedSet<AgentInvite> getAgentInvites() {
    return _agentInvites;
  }


  public void setAgentInvites(SortedSet<AgentInvite> invites) {
    _agentInvites = invites;
  }


  // endregion



  // region Products Interface


  public SortedSet<Product> getProducts() {
    return _products;
  }


  public void setProducts(SortedSet<Product> products) {
    _products = products;
  }


  public void clearProducts() {
    this.getProducts().clear();
  }


  public boolean hasProduct(Product product) {
    return this.getProducts().contains(product);
  }


  public boolean addProduct(Product product) {
    return this.getProducts().add(product);
  }


  public boolean removeProduct(Product product) {
    return this.getProducts().remove(product);
  }


  public Product getCurrentProduct() {
    return _currentProduct;
  }


  public void setCurrentProductAsOldest() {
    _currentProduct = this.getProducts().first();
  }


  public void setCurrentProduct(Object productId) throws ProductNotFoundException {
    Product product = new Product();
    product.setId(productId);

    this.setCurrentProduct(product);
  }


  public void setCurrentProduct(Product product) throws ProductNotFoundException {
    if (product == null || product.getId() == null) {
      _currentProduct = null;
      return;
    }

    if (this.getCurrentProduct().equals(product)) {
      return;
    }

    for (Product companyProduct : this.getProducts()) {
      if (companyProduct == _currentProduct) {
        continue;
      }
      if (companyProduct.equals(product)) {
        _currentProduct = product;
        return;
      }
    }

    throw new ProductNotFoundException(product);
  }


  // endregion



  // region Getters/Setters


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


  // endregion



  // region Comparator Getters


  public static Comparator<Product> getDefaultComparator() {
    return new Comparator<Product>() {
      @Override
      public int compare(Product lhs, Product rhs) {
        // TODO: Finish Implementing
        return FHObject.getDefaultComparator().compare(lhs, rhs);
      }
    };
  }


  // endregion
}