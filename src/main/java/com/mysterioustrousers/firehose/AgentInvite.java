package com.mysterioustrousers.firehose;



import java.util.Comparator;

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


  public static Comparator<AgentInvite> getDefaultComparator() {
    return new Comparator<AgentInvite>() {
      @Override
      public int compare(AgentInvite lhs, AgentInvite rhs) {
        return FHObject.getDefaultComparator().compare(lhs, rhs);
      }
    };
  }


  public static Comparator<AgentInvite> getSortByEmailComparator() {
    return new Comparator<AgentInvite>() {
      @Override
      public int compare(AgentInvite lhs, AgentInvite rhs) {
        int commonCompareOpersResult = FHObject.runCommonCompareOperations(lhs, rhs);

        if (commonCompareOpersResult != -2) {
          return commonCompareOpersResult;
        }

        int emailComparisonResult = lhs.getEmail().compareToIgnoreCase(rhs.getEmail());

        if (emailComparisonResult == 0) {
          return lhs.getCreatedAt().compareTo(rhs.getCreatedAt());
        }
        return emailComparisonResult;
      }
    };
  }


  // endregion
}