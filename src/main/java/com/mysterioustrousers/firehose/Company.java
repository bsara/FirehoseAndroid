package com.mysterioustrousers.firehose;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;



public class Company extends FHObject<Integer> {

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
    this.setAgents(new ArrayList<Agent>());
    this.setAgentInvites(new ArrayList<AgentInvite>());
    this.setProducts(new ArrayList<Product>());

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


  public List<Agent> getAgents() {
    return _agents;
  }


  public void setAgents(List<Agent> agents) {
    _agents = agents;
  }


  // endregion



  // region Agent Invites Interface


  public List<AgentInvite> getAgentInvites() {
    return _agentInvites;
  }


  public void setAgentInvites(List<AgentInvite> invites) {
    _agentInvites = invites;
  }


  // endregion



  // region Products Interface


  public List<Product> getProducts() {
    return _products;
  }


  public void setProducts(List<Product> products) {
    _products = products;
  }


  public void clearProducts() {
    this.getProducts().clear();
  }


  public boolean hasProduct(Product product) {
    return (product != null && this.hasProduct(product.getId()));
  }


  /*

  public boolean hasProduct(Object productId) {
    return this.getProducts().containsKey(productId);
  }

  */

  public boolean hasProduct(Object productId) {
    return (this.getProduct(productId) != null);
  }


  /*

  public Product getProduct(Object productId) {
    return this.getProducts().get(productId);
  }

  */

  public Product getProduct(Object productId) {
    if (productId != null) {
      for (Product product : this.getProducts()) {
        if (productId.equals(product.getId())) {
          return product;
        }
      }
    }
    return null;
  }


  /*

  public Product addProduct(Product product) {
    return this.getProducts().put(product.getId(), product);
  }

  */

  public boolean addProduct(Product product) {
    return (!this.hasProduct(product) && this.getProducts().add(product));
  }


  /*

  public Product removeProduct(Product product) {
    return this.getProducts().remove(product.getId());
  }

  */

  public boolean removeProduct(Product product) {
    return this.getProducts().remove(product);
  }


  public Product getCurrentProduct() {
    return _currentProduct;
  }


  /*

  public void setCurrentProductAsOldest() {
    _currentProduct = this.getProducts().get(this.getProducts().firstKey());
  }

  */

  public void setCurrentProductAsOldest() {
    ArrayList<Product> tempList = new ArrayList<Product>(this.getProducts());
    Collections.sort(tempList);

    _currentProduct = tempList.get(0);
  }


  public void setCurrentProduct(int productId) throws ProductNotFoundException {
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

    if (this.hasProduct(product)) {
      _currentProduct = this.getProduct(product.getId());
      return;
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
}