package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dan on 6/29/14.
 */
public class Visitor extends FHObject {

     @SerializedName("agent_id")
     public int agentId;

        @SerializedName("box_state")
        public String boxState;

        @SerializedName("connected_at")
        public Date connectedAt;

        @SerializedName("current_url")
        public String currentURL;

        @SerializedName("custom_attributes")
        public String customAttributes;

        @SerializedName("disconnected_at")
        public Date disconnectedAt;

        @SerializedName("display_name")
        public String displayName;

        @SerializedName("email")
        public String email;

        @SerializedName("env")
        public HashMap<String, HashMap<String, HashMap<String, String>>> env;

        @SerializedName("ip")
        public String ip;

        @SerializedName("is_typing")
        public Boolean isTyping;

        @SerializedName("location")
        public List<Double> location;

        @SerializedName("location_string")
        public String locationString;

        @SerializedName("most_recent_chat")
        public String mostRecentChat;

        @SerializedName("most_recent_chat_received_at")
        public Date mostRecentChatReceivedAt;

        @SerializedName("needs_response")
        public Boolean needsResponse;

        @SerializedName("product_token")
        public String productToken;

        @SerializedName("referrer_url")
        public String referrerURL;

        @SerializedName("time_zone")
        public String timeZone;

        @SerializedName("unread_count")
        public int unreadCount;

        @SerializedName("visited_current_url_at")
        public Date visitedCurrentUrlAt;

        @SerializedName("visitor_id")
        public String visitorId;


}
