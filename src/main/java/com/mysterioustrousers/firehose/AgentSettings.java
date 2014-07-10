package com.mysterioustrousers.firehose;



import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;



public class AgentSettings extends FHObject {

  // TODO: Change DND stuff to use DNDSettings object

  @SerializedName("dnd_start_hour_utc")
  private int _dndStartHourUTC;

  @SerializedName("dnd_end_hour_utc")
  private int _dndEndHourUTC;

  @SerializedName("dnd_is_manually_turned_on")
  private boolean _isDNDManuallyTurnedOn;

  @SerializedName("seconds_from_utc")
  private int _secondsFromUTC;

  @SerializedName("time_zone_name")
  private String _timeZoneName;

  @SerializedName("digest_days")
  private List<Integer> _digestDays; // TODO: private List<DayOfWeek> _digestDays;



  public AgentSettings() {
    super();

    this.setDNDStartHourUTC(-1);
    this.setDNDEndHourUTC(-1);
    this.setIsDNDManuallyTurnedOn(false);
    this.setSecondsFromUTC(-1);
    this.setTimeZoneName(null);
    this.setDigestDays(new ArrayList<Integer>());
  }



  // region Getters & Setters


  public int getDNDStartHourUTC() {
    return _dndStartHourUTC;
  }


  public void setDNDStartHourUTC(int dndStartHourUTC) {
    _dndStartHourUTC = dndStartHourUTC;
  }


  public int getDNDEndHourUTC() {
    return _dndEndHourUTC;
  }


  public void setDNDEndHourUTC(int dndEndHourUTC) {
    _dndEndHourUTC = dndEndHourUTC;
  }


  public boolean isDNDManuallyTurnedOn() {
    return _isDNDManuallyTurnedOn;
  }


  public void setIsDNDManuallyTurnedOn(boolean isDNDManuallyTurnedOn) {
    _isDNDManuallyTurnedOn = isDNDManuallyTurnedOn;
  }


  public int getSecondsFromUTC() {
    return _secondsFromUTC;
  }


  public void setSecondsFromUTC(int secondsFromUTC) {
    _secondsFromUTC = secondsFromUTC;
  }


  public String getTimeZoneName() {
    return _timeZoneName;
  }


  public void setTimeZoneName(String timeZoneName) {
    _timeZoneName = timeZoneName;
  }


  public List<Integer> getDigestDays() {
    return _digestDays;
  }


  public void setDigestDays(List<Integer> digestDays) {
    _digestDays = digestDays;
  }


  /*
  public List<DayOfWeek> getDigestDays() {
    return _digestDays;
  }


  public void setDigestDays(List<DayOfWeek> digestDays) {
    _digestDays = digestDays;
  }


  public void setDigestDays(DayOfWeek... digestDays) {
    // TODO: Implement
  }
   */


  // endregion
}