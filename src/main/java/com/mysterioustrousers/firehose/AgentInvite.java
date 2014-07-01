package com.mysterioustrousers.firehose;

import com.google.gson.annotations.SerializedName;

public class AgentInvite extends FHObject {

    @SerializedName("email")
    public String email;

    @SerializedName("token")
    public String token;
}