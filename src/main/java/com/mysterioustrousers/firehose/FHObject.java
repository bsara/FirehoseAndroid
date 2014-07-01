package com.mysterioustrousers.firehose;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FHObject {

    @SerializedName("created_at")
    public Date createdAt;

    @SerializedName("id")
    public int id;
}