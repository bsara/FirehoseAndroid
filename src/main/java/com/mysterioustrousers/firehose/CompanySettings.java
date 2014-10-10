package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



public class CompanySettings extends FHObject<Integer> {

  @SerializedName("fetch_automatically")
  private boolean _fetchAutomatically;

  @SerializedName("kb_custom_domain")
  private String _kbCustomDomain;

  @SerializedName("kb_subdomain")
  private String _kbSubdomain;



  public CompanySettings() {
    super();

    this.setFetchAutomatically(false);
    this.setKBCustomDomain(null);
    this.setKBSubdomain(null);
  }



  // region Getters & Setters


  public boolean fetchAutomatically() {
    return _fetchAutomatically;
  }


  public void setFetchAutomatically(boolean fetchAutomatically) {
    _fetchAutomatically = fetchAutomatically;
  }


  public String getKBCustomDomain() {
    return _kbCustomDomain;
  }


  public void setKBCustomDomain(String kbCustomDomain) {
    _kbCustomDomain = kbCustomDomain;
  }


  public String getKBSubdomain() {
    return _kbSubdomain;
  }


  public void setKBSubdomain(String kbSubdomain) {
    _kbSubdomain = kbSubdomain;
  }


  // endregion
}