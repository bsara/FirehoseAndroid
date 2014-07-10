package com.mysterioustrousers.firehose.interactions;



import com.google.gson.annotations.SerializedName;
import com.mysterioustrousers.firehose.FHObject;



public class CannedResponse extends FHObject {

  @SerializedName("name")
  private String _name;

  @SerializedName("shortcut")
  private String _shortcut;

  @SerializedName("text")
  private String _text;



  public CannedResponse() {
    super();

    this.setName(null);
    this.setShortcut(null);
    this.setText(null);
  }



  // region Getters & Setters


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public String getShortcut() {
    return _shortcut;
  }


  public void setShortcut(String shortcut) {
    _shortcut = shortcut;
  }


  public String getText() {
    return _text;
  }


  public void setText(String text) {
    _text = text;
  }


  // endregion
}