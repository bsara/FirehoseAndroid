package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



public class AgentInvite extends FHObject<Integer> {

  @SerializedName("email")
  private String _email;

  @SerializedName("token")
  private String _token;



  public AgentInvite() {
    super();

    this.setEmail(null);
    this.setToken(null);
  }



  // region Getters/Setters


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



  // region Comparator Getters


  @Override
  public int compareTo(FHObject obj) {
    if (obj instanceof AgentInvite) {
      int commonComparisonsResult = this.runCommonComparisons(obj);
      if (commonComparisonsResult != -2) {
        return commonComparisonsResult;
      }

      AgentInvite otherInvite = (AgentInvite)obj;

      int emailComparisonResult = this.getEmail().compareTo(otherInvite.getEmail());
      if (emailComparisonResult != 0) {
        return emailComparisonResult;
      }
    }

    return super.compareTo(obj);
  }


  // endregion
}