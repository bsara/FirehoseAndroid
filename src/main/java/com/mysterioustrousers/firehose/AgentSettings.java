package com.mysterioustrousers.firehose;



import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;



public class AgentSettings extends FHObject {

  private AvailabilitySettings _availabilitySettings;

  @SerializedName("digest_days")
  private List<Integer> _digestDays; // TODO: private List<DayOfWeek> _digestDays;



  public AgentSettings() {
    super();

    this.setAvailabilitySettings(new AvailabilitySettings());
    this.setDigestDays(new ArrayList<Integer>());
  }



  // region Getters & Setters


  public AvailabilitySettings getAvailabilitySettings() {
    return _availabilitySettings;
  }


  public void setAvailabilitySettings(AvailabilitySettings settings) {
    _availabilitySettings = settings;
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