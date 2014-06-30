package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dan on 6/23/14.
 */
public class CannedResponse extends FHObject {

    @SerializedName("name")
    public String name;

    @SerializedName("shortcut")
    public String shortcut;

    @SerializedName("text")
    public String text;
}
