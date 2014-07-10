package com.mysterioustrousers.firehose;



import com.google.gson.annotations.SerializedName;



public class DNDSettings {

  @SerializedName("dnd_start_hour_utc")
  private int _startHourUTC; // TODO: change to use Calendar object

  @SerializedName("dnd_end_hour_utc")
  private int _endHourUTC; // TODO: change to use Calendar object

  @SerializedName("dnd_is_manually_turned_on")
  private boolean _isManuallyTurnedOn;



  public DNDSettings() {
    super();
  }



  // region Getters & Setters


  public int getStartHourUTC() {
    return _startHourUTC;
  }


  public void setStartHourUTC(int startHourUTC) {
    _startHourUTC = startHourUTC;
  }


  public int getEndHourUTC() {
    return _endHourUTC;
  }


  public void setEndHourUTC(int endHourUTC) {
    _endHourUTC = endHourUTC;
  }


  public boolean isManuallyTurnedOn() {
    return _isManuallyTurnedOn;
  }


  public void setIsManuallyTurnedOn(boolean isManuallyTurnedOn) {
    _isManuallyTurnedOn = isManuallyTurnedOn;
  }


  // endregion
}
