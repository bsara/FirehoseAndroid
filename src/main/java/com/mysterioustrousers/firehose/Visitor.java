package com.mysterioustrousers.firehose;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;



public class Visitor extends FHObject implements Parcelable {

  @SerializedName("visitor_id")
  private String _id;

  @SerializedName("agent_id")
  private int _agentId;

  @SerializedName("box_state")
  private BoxState _boxState;

  @SerializedName("connected_at")
  private String _connectedAt;

  @SerializedName("current_url")
  private String _currentURL;

  @SerializedName("disconnected_at")
  private String _disconnectedAt;

  @SerializedName("display_name")
  private String _displayName;

  @SerializedName("email")
  private String _email;

  //@SerializedName("env")
  //private HashMap<String, HashMap<String, HashMap<String, String>>> env;

  @SerializedName("ip")
  private String _ipAddress;

  @SerializedName("is_typing")
  private boolean _isTyping;

  @SerializedName("location")
  private List<Double> _location;

  @SerializedName("location_string")
  private String _locationString;

  @SerializedName("most_recent_chat")
  private String _mostRecentChat;

  @SerializedName("most_recent_chat_received_at")
  private String _mostRecentChatReceivedAt;

  @SerializedName("needs_response")
  private boolean _needsResponse;

  @SerializedName("product_token")
  private String _productToken;

  @SerializedName("referrer_url")
  private String _referrerURL;

  @SerializedName("time_zone")
  private String _timeZone;

  @SerializedName("unread_count")
  private int _unreadCount;

  @SerializedName("visited_current_url_at")
  private String _visitedCurrentUrlAt;



  public static GsonArrayRequest chatInteractions(Agent agent, Visitor visitor, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    String url = String.format("%s/visitors/%s/chat_interactions", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API), visitor.getId());

    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", agent.accessToken));

    return new GsonArrayRequest(url, headers, listener, errorListener);
  }


  // TODO since it's already a json object maybe it can use that to be parcelable, oh well just do this for now.
  //parcel part
  public static final Creator<Visitor> CREATOR = new Creator<Visitor>() {

    @Override
    public Visitor createFromParcel(Parcel source) {
      Visitor visitor = new Visitor();

      visitor.setAgentId(source.readInt());
      visitor.setBoxState(BoxState.parse(source.readString()));
      // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
      //mVisitor._connectedAt = (java.util.Date) source.readSerializable();//_connectedAt);
      visitor.setCurrentURL(source.readString());
      visitor.setCustomAttributes(source.readString());
      //mVisitor._disconnectedAt = (java.util.Date) source.readSerializable();//_disconnectedAt);
      visitor.setDisplayName(source.readString());
      visitor.setEmail(source.readString());
      // TODO env in parcelable
      //public HashMap<String, HashMap<String, HashMap<String, String>>> env;
      visitor.setIPAddress(source.readString());
      // http://stackoverflow.com/questions/6201311/how-to-read-write-a-boolean-when-implementing-the-parcelable-interface
      visitor.setIsTyping(source.readByte() != 0);//(byte) (_isTyping ? 1 : 0));
      // TODO _location
      //mVisitor._location = new ArrayList<Double>();
      //mVisitor._location = source.readList(mVisitor._location, null);
      visitor.setLocationString(source.readString());
      visitor.setMostRecentChat(source.readString());
      //mVisitor._mostRecentChatReceivedAt = (java.util.Date) source.readSerializable();
      visitor.setNeedsResponse(source.readByte() != 0);
      visitor.setProductToken(source.readString());
      visitor.setReferrerURL(source.readString());
      visitor.setTimeZone(source.readString());
      visitor.setUnreadCount(source.readInt());
      //mVisitor._visitedCurrentUrlAt = (java.util.Date) source.readSerializable();
      visitor.setId(source.readString());

      return visitor;
    }


    @Override
    public Visitor[] newArray(int size) {
      return new Visitor[ size ];
    }
  };


  @Override
  public int describeContents() {
    return 0;
  }


  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(this.getAgentId());
    parcel.writeString(this.getBoxState().toString());
    // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
    //parcel.writeSerializable(this.getConnectedAt());
    parcel.writeString(this.getCurrentURL());
    parcel.writeString(this.getCustomAttributes());
    //parcel.writeSerializable(this.getDisconnectedAt());
    parcel.writeString(this.getDisplayName());
    parcel.writeString(this.getEmail());
    // TODO env in parcelable
    //public HashMap<String, HashMap<String, HashMap<String, String>>> env;
    parcel.writeString(this.getIPAddress());
    parcel.writeByte((byte)(this.isTyping() ? 1 : 0));
    //parcel.writeList(this.getLocation());
    parcel.writeString(this.getLocationString());
    parcel.writeString(this.getMostRecentChat());
    //parcel.writeSerializable(this.getMostRecentChatReceivedAt());
    parcel.writeByte((byte)(this.needsResponse() ? 1 : 0));
    parcel.writeString(this.getProductToken());
    parcel.writeString(this.getReferrerURL());
    parcel.writeString(this.getTimeZone());
    parcel.writeInt(this.getUnreadCount());
    //parcel.writeSerializable(this.getVisitedCurrentUrlAt());
    parcel.writeString((String)this.getId());
  }



  // region Getters & Setters


  @Override
  public Object getId() {
    return _id;
  }


  @Override
  public void setId(Object id) {
    _id = id.toString();
  }


  public int getAgentId() {
    return _agentId;
  }


  public void setAgentId(int agentId) {
    _agentId = agentId;
  }


  public BoxState getBoxState() {
    return _boxState;
  }


  public void setBoxState(BoxState boxState) {
    _boxState = boxState;
  }


  public String getConnectedAt() {
    return _connectedAt;
  }


  public void setConnectedAt(String _connectedAt) {
    _connectedAt = _connectedAt;
  }


  public String getCurrentURL() {
    return _currentURL;
  }


  public void setCurrentURL(String currentURL) {
    _currentURL = currentURL;
  }


  public String getCustomAttributes() {
    return _customAttributes;
  }


  public void setCustomAttributes(String _customAttributes) {
    _customAttributes = _customAttributes;
  }


  public String getDisconnectedAt() {
    return _disconnectedAt;
  }


  public void setDisconnectedAt(String disconnectedAt) {
    _disconnectedAt = disconnectedAt;
  }


  public String getDisplayName() {
    return _displayName;
  }


  public void setDisplayName(String displayName) {
    _displayName = displayName;
  }


  public String getEmail() {
    return _email;
  }


  public void setEmail(String email) {
    _email = email;
  }


  public String getIPAddress() {
    return _ipAddress;
  }


  public void setIPAddress(String _ipAddress) {
    _ipAddress = _ipAddress;
  }


  public boolean isTyping() {
    return _isTyping;
  }


  public void setIsTyping(boolean isTyping) {
    _isTyping = isTyping;
  }


  public List<Double> getLocation() {
    return _location;
  }


  public void setLocation(List<Double> location) {
    _location = location;
  }


  public String getLocationString() {
    return _locationString;
  }


  public void setLocationString(String _locationString) {
    _locationString = _locationString;
  }


  public String getMostRecentChat() {
    return _mostRecentChat;
  }


  public void setMostRecentChat(String mostRecentChat) {
    _mostRecentChat = mostRecentChat;
  }


  public String getMostRecentChatReceivedAt() {
    return _mostRecentChatReceivedAt;
  }


  public void setMostRecentChatReceivedAt(String mostRecentChatReceivedAt) {
    _mostRecentChatReceivedAt = mostRecentChatReceivedAt;
  }


  public boolean needsResponse() {
    return _needsResponse;
  }


  public void setNeedsResponse(boolean _needsResponse) {
    _needsResponse = _needsResponse;
  }


  public String getProductToken() {
    return _productToken;
  }


  public void setProductToken(String _productToken) {
    _productToken = _productToken;
  }


  public String getReferrerURL() {
    return _referrerURL;
  }


  public void setReferrerURL(String _referrerURL) {
    _referrerURL = _referrerURL;
  }


  public String getTimeZone() {
    return _timeZone;
  }


  public void setTimeZone(String _timeZone) {
    _timeZone = _timeZone;
  }


  public int getUnreadCount() {
    return _unreadCount;
  }


  public void setUnreadCount(int unreadCount) {
    _unreadCount = unreadCount;
  }


  public String getVisitedCurrentUrlAt() {
    return _visitedCurrentUrlAt;
  }


  public void setVisitedCurrentUrlAt(String visitedCurrentUrlAt) {
    _visitedCurrentUrlAt = visitedCurrentUrlAt;
  }


  // endregion
}