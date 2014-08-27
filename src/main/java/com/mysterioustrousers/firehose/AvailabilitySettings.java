package com.mysterioustrousers.firehose;



import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.StringUtils;



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
  private String _timeZoneId;



  public AvailabilitySettings() {
    super();

    this.setSecondsFromUTC(0);
    this.setTimeZoneId(null);
    this.setStartHourUTC(0);
    this.setEndHourUTC(0);
    this.setManuallyUnavailable(false);
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


  public String getTimeZoneId() {
    return StringUtils.defaultIfBlank(_timeZoneId, Calendar.getInstance().getTimeZone().getID());
  }


  public void setTimeZoneId(String timeZoneId) {
    _timeZoneId = timeZoneId;
    this.setSecondsFromUTC(StringUtils.isBlank(_timeZoneId) ? 0 : TimeZone.getTimeZone(_timeZoneId).getOffset(GregorianCalendar.ZONE_OFFSET));
  }


  public boolean isAvailable() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeZone(TimeZone.getTimeZone(this.getTimeZoneId()));
    int currentHour = cal.get(Calendar.HOUR_OF_DAY);

    return !(this.isManuallyUnavailable()
             || currentHour < this.getStartHourForTimeZone()
             || currentHour > this.getEndHourForTimeZone());
  }


  // endregion
}