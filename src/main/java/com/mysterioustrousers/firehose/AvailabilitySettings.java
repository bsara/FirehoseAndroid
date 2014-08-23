package com.mysterioustrousers.firehose;



import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.annotations.SerializedName;



public class AvailabilitySettings {

  @SerializedName("dnd_end_hour_utc")
  private int _startHourUTC;

  @SerializedName("dnd_start_hour_utc")
  private int _endHourUTC;

  @SerializedName("dnd_is_manually_turned_on")
  private boolean _manuallyUnavailable;

  @SerializedName("seconds_from_utc")
  private int _secondsFromUTC;

  @SerializedName("time_zone_name")
  private String _timeZoneName;



  public AvailabilitySettings() {
    super();

    this.setStartHourUTC(0);
    this.setEndHourUTC(0);
    this.setManuallyUnavailable(false);
    this.setSecondsFromUTC(-1);
    this.setTimeZoneName(null);
  }



  // region Getters/Setters


  public int getStartHourForTimeZone() {
    return this.getStartHourUTC() + this.getHoursFromUTC();
  }


  public void setStartHourForTimeZone(int startHour) {
    _startHourUTC = startHour - this.getHoursFromUTC();
  }


  public int getStartHourUTC() {
    return _startHourUTC;
  }


  public void setStartHourUTC(int startHourUTC) {
    _startHourUTC = startHourUTC;
  }


  public int getEndHourForTimeZone() {
    return this.getEndHourUTC() + this.getHoursFromUTC();
  }


  public void setEndHourForTimeZone(int endHour) {
    _endHourUTC = endHour - this.getHoursFromUTC();
  }


  public int getEndHourUTC() {
    return _endHourUTC;
  }


  public void setEndHourUTC(int endHourUTC) {
    _endHourUTC = endHourUTC;
  }


  public boolean isManuallyUnavailable() {
    return _manuallyUnavailable;
  }


  public void setManuallyUnavailable(boolean manuallyUnavailable) {
    _manuallyUnavailable = manuallyUnavailable;
  }


  public int getSecondsFromUTC() {
    return _secondsFromUTC;
  }


  public void setSecondsFromUTC(int secondsFromUTC) {
    _secondsFromUTC = secondsFromUTC;
  }


  public int getMinutesFromUTC() {
    return this.getSecondsFromUTC() / 60;
  }


  public int getHoursFromUTC() {
    return this.getMinutesFromUTC() / 60;
  }


  public String getTimeZoneName() {
    return _timeZoneName;
  }


  public void setTimeZoneName(String timeZoneName) {
    _timeZoneName = timeZoneName;
  }


  public void setTimeZone(String timeZoneId) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
    this.setTimeZoneName(timeZone.getDisplayName(Locale.US));
    this.setSecondsFromUTC(timeZone.getOffset(GregorianCalendar.ZONE_OFFSET));
  }


  // endregion
}