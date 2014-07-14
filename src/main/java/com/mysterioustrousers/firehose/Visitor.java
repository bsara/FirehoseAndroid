package com.mysterioustrousers.firehose;



import java.net.MalformedURLException;
import java.net.URL;
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
  private String _boxState; //private BoxState _boxState;

  @SerializedName("connected_at")
  private String _connectedAt;

  @SerializedName("current_url")
  private URL _currentURL;

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
  private Boolean _isTyping;

  @SerializedName("location")
  private List<Double> _location;

  @SerializedName("location_string")
  private String _locationString;

  @SerializedName("most_recent_chat")
  private String _mostRecentChat;

  @SerializedName("most_recent_chat_received_at")
  private String _mostRecentChatReceivedAt;

  @SerializedName("needs_response")
  private Boolean _needsResponse;

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



  public Visitor() {
    super();

    this.setAgentId(-1);
    this.setBoxState("none"); // this.setBoxState(BoxState.NONE);
    this.setConnectedAt(null);
    this.setCurrentURL(null);
    this.setDisconnectedAt(null);
    this.setDisplayName(null);
    this.setEmail(null);
    this.setIPAddress(null);
    this.setIsTyping(null);
    this.setLocation(null);
    this.setLocationString(null);
    this.setMostRecentChat(null);
    this.setMostRecentChatReceivedAt(null);
    this.setNeedsResponse(null);
    this.setProductToken(null);
    this.setReferrerURL(null);
    this.setTimeZone(null);
    this.setUnreadCount(0);
    this.setVisitedCurrentUrlAt(null);
  }



  public static GsonArrayRequest chatInteractions(Agent agent, Visitor visitor, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    String url = String.format("%s/visitors/%s/chat_interactions", EnvironmentManager.getRemoteInstance().getBaseURL(FHApplication.API), visitor.getId());

    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", String.format("Token token=\"%s\"", agent.getAccessToken()));

    return new GsonArrayRequest(url, headers, listener, errorListener);
  }


  // TODO since it's already a json object maybe it can use that to be parcelable, oh well just do this for now.
  //parcel part
  public static final Creator<Visitor> CREATOR = new Creator<Visitor>() {

    @Override
    public Visitor createFromParcel(Parcel source) {
      Visitor visitor = new Visitor();

      visitor.setAgentId(source.readInt());
      visitor.setBoxState(source.readString());//visitor.setBoxState((BoxState)source.readSerializable());
      // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
      //mVisitor._connectedAt = (java.util.Date) source.readSerializable();//_connectedAt);
      try {
        visitor.setCurrentURL(new URL(source.readString()));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
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
    parcel.writeString(this.getBoxState());//parcel.writeSerializable(this.getBoxState());
    // http://stackoverflow.com/questions/21017404/reading-and-writing-java-util-date-from-parcelable-class
    //parcel.writeSerializable(this.getConnectedAt());
    parcel.writeString(this.getCurrentURL().toString());
    //parcel.writeSerializable(this.getDisconnectedAt());
    parcel.writeString(this.getDisplayName());
    parcel.writeString(this.getEmail());
    // TODO env in parcelable
    //public HashMap<String, HashMap<String, HashMap<String, String>>> env;
    parcel.writeString(this.getIPAddress());
    if (this.isTyping() != null) {
      parcel.writeByte((byte)(this.isTyping() ? 1 : 0));
    }
    //parcel.writeList(this.getLocation());
    parcel.writeString(this.getLocationString());
    parcel.writeString(this.getMostRecentChat());
    //parcel.writeSerializable(this.getMostRecentChatReceivedAt());
    if (this.needsResponse() != null) {
      parcel.writeByte((byte)(this.needsResponse() ? 1 : 0));
    }
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


  /*
  public BoxState getBoxState() {
    return _boxState;
  }


  public void setBoxState(BoxState boxState) {
    _boxState = boxState;
  }
  */


  public String getBoxState() {
    return _boxState;
  }


  public void setBoxState(String boxState) {
    _boxState = boxState;
  }


  public String getConnectedAt() {
    return _connectedAt;
  }


  public void setConnectedAt(String connectedAt) {
    _connectedAt = connectedAt;
  }


  public URL getCurrentURL() {
    return _currentURL;
  }


  public void setCurrentURL(URL currentURL) {
    _currentURL = currentURL;
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


  public void setIPAddress(String ipAddress) {
    _ipAddress = ipAddress;
  }


  public Boolean isTyping() {
    return _isTyping;
  }


  public void setIsTyping(Boolean isTyping) {
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


  public void setLocationString(String locationString) {
    _locationString = locationString;
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


  public Boolean needsResponse() {
    return _needsResponse;
  }


  public void setNeedsResponse(Boolean needsResponse) {
    _needsResponse = needsResponse;
  }


  public String getProductToken() {
    return _productToken;
  }


  public void setProductToken(String productToken) {
    _productToken = productToken;
  }


  public String getReferrerURL() {
    return _referrerURL;
  }


  public void setReferrerURL(String referrerURL) {
    _referrerURL = referrerURL;
  }


  public String getTimeZone() {
    return _timeZone;
  }


  public void setTimeZone(String timeZone) {
    _timeZone = timeZone;
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