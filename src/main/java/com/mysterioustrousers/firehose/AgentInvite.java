package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



public class AgentInvite extends FHObject {

  @SerializedName("email")
  private String _email;

  @SerializedName("token")
  private String _token;



  public AgentInvite() {
    super();

    this.setEmail(null);
    this.setToken(null);
  }



  // region Getters & Setters


  public String getEmail() {
    return _email;
  }


  public void setEmail(String email) {
    _email = email;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  // endregion
}