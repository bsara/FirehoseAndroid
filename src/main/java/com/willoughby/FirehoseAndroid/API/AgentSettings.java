package com.willoughby.FirehoseAndroid.API;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dan on 6/23/14.
 */
public class AgentSettings extends FHObject {
    @SerializedName("dnd_end_hour_utc")
    public int dndEndHourUTC;

    @SerializedName("dnd_is_manually_turned_on")
    public boolean dndIsManuallyTurnedOn;

    @SerializedName("dnd_start_hour_utc")
    public int dndStartHourUTC;

    @SerializedName("seconds_from_utc")
    public int secondsFromUTC;

    @SerializedName("time_zone_name")
    public String timeZoneName;

    @SerializedName("digest_days")
    public List<Integer> digestDays;

}
