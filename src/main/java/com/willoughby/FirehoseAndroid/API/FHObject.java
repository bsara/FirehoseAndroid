package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dan on 6/25/14.
 */
public class FHObject {

    @SerializedName("created_at")
    public Date createdAt;

    @SerializedName("id")
    public int id;
}
