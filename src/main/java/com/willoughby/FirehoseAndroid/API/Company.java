package com.willoughby.FirehoseAndroid.API;

import android.util.Log;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 6/23/14.
 */
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

    public static JsonArrayRequest fetchOnlineVisitors(String accessToken, final Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = "https://chat.firehoseapp.com/online_visitors";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Authorization", String.format("Token token = %s", accessToken));
        }
        catch (Exception e) {
            errorListener.onErrorResponse(new ParseError(e));
        }
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, listener , errorListener);

        return jsonArrayRequest;

        //GsonRequest<Visitors> gsonRequest = new GsonRequest<Visitor>(Request.Method.POST, url,Visitors.class, jsonObject , listener, errorListener);
        //return gsonRequest;
    }
}
