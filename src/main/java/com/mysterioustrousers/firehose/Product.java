package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



public class Product extends FHObject {

  @SerializedName("kb_custom_domain")
  private String _kbCustomDomain;

  @SerializedName("kb_subdomain")
  private String _kbSubdomain;

  @SerializedName("name")
  private String _name;

  @SerializedName("token")
  private String _token;

  @SerializedName("website")
  private String _websiteURL;



  public Product() {
    super();

    this.setKBCustomDomain(null);
    this.setKBSubdomain(null);
    this.setName(null);
    this.setToken(null);
    this.setWebsiteURL(null);
  }



  // region Getters & Setters


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


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  public String getWebsiteURL() {
    return _websiteURL;
  }


  public void setWebsiteURL(String websiteURL) {
    _websiteURL = websiteURL;
  }


  // endregion
}