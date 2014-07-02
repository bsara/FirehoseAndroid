package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



/**
 * Created by dan on 6/23/14.
 */
public class CompanySettings extends FHObject {

  @SerializedName("fetch_automatically")
  public boolean fetchAutomatically;

  @SerializedName("kb_custom_domain")
  public String kbCustomDomain;

  @SerializedName("kb_subdomain")
  public String kbSubdomain;
}
