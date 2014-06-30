package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

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
}
