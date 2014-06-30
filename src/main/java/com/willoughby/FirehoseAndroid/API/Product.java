package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dan on 6/23/14.
 */
public class Product extends FHObject {
    @SerializedName("kb_custom_domain")
    public String kbCustomDomain;

    @SerializedName("kb_subdomain")
    public String kbSubdomain;

    @SerializedName("name")
    public String name;

    @SerializedName("token")
    public String token;

    @SerializedName("website")
    public String website;
}
