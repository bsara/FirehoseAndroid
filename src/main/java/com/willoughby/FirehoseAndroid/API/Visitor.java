package com.willoughby.FirehoseAndroid.API;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dan on 6/29/14.
 */
public class Visitor extends FHObject implements Parcelable {

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


    // TODO since it's already a json object maybe it can use that to be parcelable, oh well just do this for now.
    //parcel part

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(agentId);
        parcel.writeString(boxState);
        // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
        parcel.writeSerializable(connectedAt);
        parcel.writeString(currentURL);
        parcel.writeString(customAttributes);
        parcel.writeSerializable(disconnectedAt);
        parcel.writeString(displayName);
        parcel.writeString(email);
        // TODO env in parcelable
        //public HashMap<String, HashMap<String, HashMap<String, String>>> env;
        parcel.writeString(ip);
        // http://stackoverflow.com/questions/6201311/how-to-read-write-a-boolean-when-implementing-the-parcelable-interface
        if (isTyping != null)
            parcel.writeByte((byte) (isTyping ? 1 : 0));
        parcel.writeList(location);
        parcel.writeString(locationString);
        parcel.writeString(mostRecentChat);
        parcel.writeSerializable(mostRecentChatReceivedAt);
        if (needsResponse != null)
            parcel.writeByte((byte) (needsResponse ? 1 : 0));
        parcel.writeString(productToken);
        parcel.writeString(referrerURL);
        parcel.writeString(timeZone);
        parcel.writeInt(unreadCount);
        parcel.writeSerializable(visitedCurrentUrlAt);
        parcel.writeString(visitorId);
    }

    public static final Creator<Visitor> CREATOR = new Creator<Visitor>() {

        @Override
        public Visitor createFromParcel(Parcel source) {
            Visitor mVisitor = new Visitor();
            mVisitor.agentId = source.readInt();//agentId);
            mVisitor.boxState = source.readString();//boxState);
            // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
            mVisitor.connectedAt = (java.util.Date) source.readSerializable();//connectedAt);
            mVisitor.currentURL = source.readString();//currentURL);
            mVisitor.customAttributes = source.readString();//customAttributes);
            mVisitor.disconnectedAt = (java.util.Date) source.readSerializable();//disconnectedAt);
            mVisitor.displayName = source.readString();//displayName);
            mVisitor.email = source.readString();//email);
            // TODO env in parcelable
            //public HashMap<String, HashMap<String, HashMap<String, String>>> env;
            mVisitor.ip = source.readString();//ip);
            // http://stackoverflow.com/questions/6201311/how-to-read-write-a-boolean-when-implementing-the-parcelable-interface
            mVisitor.isTyping = source.readByte() != 0;//(byte) (isTyping ? 1 : 0));
            // TODO location
            //mVisitor.location = new ArrayList<Double>();
            //mVisitor.location = source.readList(mVisitor.location, null);
            mVisitor.locationString = source.readString();
            mVisitor.mostRecentChat = source.readString();
            mVisitor.mostRecentChatReceivedAt = (java.util.Date) source.readSerializable();
            mVisitor.needsResponse = source.readByte() != 0;
            mVisitor.productToken = source.readString();
            mVisitor.referrerURL = source.readString();
            mVisitor.timeZone = source.readString();
            mVisitor.unreadCount = source.readInt();
            mVisitor.visitedCurrentUrlAt = (java.util.Date) source.readSerializable();
            mVisitor.visitorId = source.readString();
            return mVisitor;
        }

        @Override
        public Visitor[] newArray(int size) {
            return new Visitor[size];
        }
    };
}
