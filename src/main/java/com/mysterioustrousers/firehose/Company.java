package com.mysterioustrousers.firehose;



import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;



public class Company extends FHObject {

  @SerializedName("fetch_automatically")
  public boolean fetchAutomatically;

  @SerializedName("forwarding_email")
  public String forwardingEmail;

  @SerializedName("kind")
  public String kind;

  @SerializedName("last_fetch_at")
  public Date lastFetchAt;

  @SerializedName("title")
  public String title;

  @SerializedName("token")
  public String token;

  @SerializedName("unresolved_count")
  public int unresolvedCount;

  @SerializedName("number_of_accounts")
  public int numberOfAccounts;

  @SerializedName("is_brand_new")
  public boolean isBrandNew;

  @SerializedName("is_chat_enabled")
  public boolean isChatEnabled;

  @SerializedName("is_premium")
  public boolean isPremium;

  @SerializedName("agents")
  public List<Agent> agents;

  @SerializedName("agent_invites")
  public List<AgentInvite> agentInvites;

  @SerializedName("products")
  public List<Product> products;


  public static GsonArrayRequest fetchOnlineVisitors(String accessToken, final Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    //String url = "https://chat.firehoseapp.com/online_visitors";
    //String url = "http://10.0.2.2:8080/online_visitors";
    String url = String.format("http://%s:8080/online_visitors", EnvironmentManager.localIP);
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token = %s", accessToken));

    GsonArrayRequest gsonArrayRequest = new GsonArrayRequest(url, headers, listener, errorListener);

    return gsonArrayRequest;
  }
}