package com.mysterioustrousers.firehose;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.StringUtils;



public class AgentSettings extends FHObject {

  @SerializedName("seconds_from_utc")
  private int _availabilitySecondsFromUTC;

  @SerializedName("time_zone_name")
  private String _availabilityTimeZoneId;

  @SerializedName("dnd_end_hour_utc")
  private int _availabilityStartHourUTC;

  @SerializedName("dnd_start_hour_utc")
  private int _availabilityEndHourUTC;

  @SerializedName("dnd_is_manually_turned_on")
  private boolean _manuallyUnavailable;

  @SerializedName("digest_days")
  private List<Integer> _digestDays; // TODO: private List<DayOfWeek> _digestDays;



  public AgentSettings() {
    super();

    this.setAvailabilitySecondsFromUTC(0);
    this.setAvailabilityTimeZoneId(null);
    this.setAvailabilityStartHourUTC(0);
    this.setAvailabilityEndHourUTC(0);
    this.setManuallyUnavailable(false);
    this.setDigestDays(new ArrayList<Integer>());
  }



  // region Getters & Setters


  public int getAvailabilityStartHourForTimeZone() {
    return this.getAvailabilityStartHourUTC() + this.getAvailabilityHoursFromUTC();
  }


  public void setAvailabilityStartHourForTimeZone(int startHour) {
    _availabilityStartHourUTC = startHour - this.getAvailabilityHoursFromUTC();
  }


  public int getAvailabilityStartHourUTC() {
    return _availabilityStartHourUTC;
  }


  public void setAvailabilityStartHourUTC(int startHourUTC) {
    _availabilityStartHourUTC = startHourUTC;
  }


  public int getAvailabilityEndHourForTimeZone() {
    return this.getAvailabilityEndHourUTC() + this.getAvailabilityHoursFromUTC();
  }


  public void setAvailabilityEndHourForTimeZone(int endHour) {
    _availabilityEndHourUTC = endHour - this.getAvailabilityHoursFromUTC();
  }


  public int getAvailabilityEndHourUTC() {
    return _availabilityEndHourUTC;
  }


  public void setAvailabilityEndHourUTC(int endHourUTC) {
    _availabilityEndHourUTC = endHourUTC;
  }


  public boolean isManuallyUnavailable() {
    return _manuallyUnavailable;
  }


  public void setManuallyUnavailable(boolean manuallyUnavailable) {
    _manuallyUnavailable = manuallyUnavailable;
  }


  public int getAvailabilitySecondsFromUTC() {
    return _availabilitySecondsFromUTC;
  }


  public void setAvailabilitySecondsFromUTC(int secondsFromUTC) {
    _availabilitySecondsFromUTC = secondsFromUTC;
  }


  public int getAvailabilityMinutesFromUTC() {
    return this.getAvailabilitySecondsFromUTC() / 60;
  }


  public int getAvailabilityHoursFromUTC() {
    return this.getAvailabilityMinutesFromUTC() / 60;
  }


  public String getAvailabilityTimeZoneId() {
    return StringUtils.defaultIfBlank(_availabilityTimeZoneId, Calendar.getInstance().getTimeZone().getID());
  }


  public void setAvailabilityTimeZoneId(String timeZoneId) {
    _availabilityTimeZoneId = timeZoneId;
    this.setAvailabilitySecondsFromUTC(StringUtils.isBlank(_availabilityTimeZoneId) ? 0 : TimeZone.getTimeZone(_availabilityTimeZoneId).getOffset(GregorianCalendar.ZONE_OFFSET));
  }


  public boolean isAvailable() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeZone(TimeZone.getTimeZone(this.getAvailabilityTimeZoneId()));
    int currentHour = cal.get(Calendar.HOUR_OF_DAY);

    return !(this.isManuallyUnavailable()
             || currentHour < this.getAvailabilityStartHourForTimeZone()
             || currentHour > this.getAvailabilityEndHourForTimeZone());
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