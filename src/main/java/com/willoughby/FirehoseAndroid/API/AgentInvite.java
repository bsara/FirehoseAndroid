package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by dan on 6/23/14.
 */
public class AgentInvite extends FHObject {

    @SerializedName("email")
    public String email;

    @SerializedName("token")
    public String token;
}
