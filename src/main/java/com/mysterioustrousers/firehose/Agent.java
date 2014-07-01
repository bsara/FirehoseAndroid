package com.mysterioustrousers.firehose;

import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

public class Agent extends FHObject  {

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("browser_token")
    public String browserToken;

    @SerializedName("email")
    public String email;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("url_token")
    public String urlToken;

    @SerializedName("display_name")
    public String displayName;

    @SerializedName("avatar_url")
    public String avatarURL;

    @SerializedName("agent_settings")
    public AgentSettings agentSettings;

    @SerializedName("companies")
    public List<Company> companies;


    public static GsonRequest<Agent> login(String email, String password, Listener<Agent> listener, ErrorListener errorListener) {
        String url = "https://api.firehoseapp.com/login";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", email);
            jsonObject.put("password", password);
        }
        catch (Exception e) {
            errorListener.onErrorResponse(new ParseError(e));
        }

        GsonRequest<Agent> gsonRequest = new GsonRequest<Agent>(Request.Method.POST, url, Agent.class , jsonObject , listener, errorListener);
        return gsonRequest;
    }
}