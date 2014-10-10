package com.mysterioustrousers.firehose.chat;



import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;



public class ChatSettings {

  @SerializedName("chat_hide_box_when_offline")
  private boolean _boxHiddenWhenOffline;

  @SerializedName("chat_hide_box_when_unavailable")
  private boolean _boxHiddenWhenUnavailable;


  @SerializedName("chat_offline_email_address")
  private String _offlineEmailAddress;

  @SerializedName("chat_offline_header_text")
  private String _offlineTitle;

  @SerializedName("chat_offline_welcome_text")
  private String _offlineWelcomeText;


  @SerializedName("chat_online_header_text")
  private String _onlineTitle;

  @SerializedName("chat_online_welcome_text")
  private String _onlineWelcomeText;


  @SerializedName("chat_appearance")
  private ChatBoxAppearanceType _appearanceType;

  @SerializedName("chat_tab_position")
  private ChatBoxTabPosition _tabPosition;


  @SerializedName("chat_button_css_class")
  private String _popupButtonCSSClass;


  @SerializedName("chat_use_custom_css")
  private boolean _useCustomCSS;

  @SerializedName("chat_css")
  private String _customCSS;


  @SerializedName("chat_placeholder_text")
  private String _inputFieldPlaceholderText;


  @SerializedName("chat_agent_color")
  private long _agentTextColor;

  @SerializedName("chat_background_color")
  private long _backgroundColor;

  @SerializedName("chat_customer_color")
  private long _customerTextColor;

  @SerializedName("chat_field_background_color")
  private long _inputFieldBackgroundColor;

  @SerializedName("chat_response_background_color")
  private long _inputFieldBorderColor;

  @SerializedName("chat_field_text_color")
  private long _inputFieldTextColor;

  @SerializedName("chat_title_background_color")
  private long _titleBackgroundColor;

  @SerializedName("chat_title_text_color")
  private long _titleTextColor;



  public ChatSettings() {
    super();

    this.setBoxHiddenWhenOffline(false);
    this.setBoxHiddenWhenUnavailable(false);

    this.setOfflineEmailAddress(null);
    this.setOfflineTitle(null);
    this.setOfflineWelcomeText(null);

    this.setOnlineTitle(null);
    this.setOnlineWelcomeText(null);

    this.setAppearanceType(null);
    this.setTabPosition(null);

    this.setPopupButtonCSSClass(null);

    this.setUseCustomCSS(false);
    this.setCustomCSS(null);

    this.setInputFieldPlaceholderText(null);

    this.setAgentTextColor(-1);
    this.setBackgroundColor(-1);
    this.setCustomerTextColor(-1);
    this.setInputFieldBackgroundColor(-1);
    this.setInputFieldBorderColor(-1);
    this.setInputFieldTextColor(-1);
    this.setTitleBackgroundColor(-1);
    this.setTitleTextColor(-1);
  }



  // region Getters/Setters


  public boolean isBoxHiddenWhenOffline() {
    return _boxHiddenWhenOffline;
  }


  public void setBoxHiddenWhenOffline(boolean isHidden) {
    _boxHiddenWhenOffline = isHidden;
  }


  public boolean isBoxHiddenWhenUnavailable() {
    return _boxHiddenWhenUnavailable;
  }


  public void setBoxHiddenWhenUnavailable(boolean isHidden) {
    _boxHiddenWhenUnavailable = isHidden;
  }


  public String getOfflineEmailAddress() {
    return _offlineEmailAddress;
  }


  public void setOfflineEmailAddress(String emailAddress) throws IllegalArgumentException {
    if (emailAddress != null && !EmailValidator.getInstance().isValid(emailAddress.trim())) {
      throw new IllegalArgumentException(String.format("emailAddress is not a valid email address: '%s'", emailAddress));
    }
    _offlineEmailAddress = StringUtils.trim(emailAddress);
  }


  public String getOfflineTitle() {
    return _offlineTitle;
  }


  public void setOfflineTitle(String title) {
    _offlineTitle = StringUtils.trim(title);
  }


  public String getOfflineWelcomeText() {
    return _offlineWelcomeText;
  }


  public void setOfflineWelcomeText(String text) {
    _offlineWelcomeText = StringUtils.trim(text);
  }


  public String getOnlineTitle() {
    return _onlineTitle;
  }


  public void setOnlineTitle(String title) {
    _onlineTitle = StringUtils.trim(title);
  }


  public String getOnlineWelcomeText() {
    return _onlineWelcomeText;
  }


  public void setOnlineWelcomeText(String text) {
    _onlineWelcomeText = StringUtils.trim(text);
  }


  public ChatBoxAppearanceType getAppearanceType() {
    return _appearanceType;
  }


  public void setAppearanceType(ChatBoxAppearanceType appearanceType) {
    _appearanceType = appearanceType;
  }


  public ChatBoxTabPosition getTabPosition() {
    return _tabPosition;
  }


  public void setTabPosition(ChatBoxTabPosition tabPosition) {
    _tabPosition = tabPosition;
  }


  public String getPopupButtonCSSClass() {
    return _popupButtonCSSClass;
  }


  public void setPopupButtonCSSClass(String cssClass) {
    _popupButtonCSSClass = cssClass;
  }


  public boolean useCustomCSS() {
    return _useCustomCSS;
  }


  public void setUseCustomCSS(boolean useCustomCSS) {
    _useCustomCSS = useCustomCSS;
  }


  public String getCustomCSS() {
    return _customCSS;
  }


  public void setCustomCSS(String css) {
    _customCSS = css;
  }


  public String getInputFieldPlaceholderText() {
    return _inputFieldPlaceholderText;
  }


  public void setInputFieldPlaceholderText(String text) {
    _inputFieldPlaceholderText = text;
  }



  // region Colors


  public String getAgentTextColorAsString() {
    return this.convertToHexString(this.getAgentTextColor());
  }


  public long getAgentTextColor() {
    return _agentTextColor;
  }


  public void setAgentTextColor(long color) {
    _agentTextColor = color;
  }


  public String getBackgroundColorAsString() {
    return this.convertToHexString(this.getBackgroundColor());
  }


  public long getBackgroundColor() {
    return _backgroundColor;
  }


  public void setBackgroundColor(long color) {
    _backgroundColor = color;
  }


  public String getCustomerTextColorAsString() {
    return this.convertToHexString(this.getCustomerTextColor());
  }


  public long getCustomerTextColor() {
    return _customerTextColor;
  }


  public void setCustomerTextColor(long color) {
    _customerTextColor = color;
  }


  public String getInputFieldBackgroundColorAsString() {
    return this.convertToHexString(this.getInputFieldBackgroundColor());
  }


  public long getInputFieldBackgroundColor() {
    return _inputFieldBackgroundColor;
  }


  public void setInputFieldBackgroundColor(long color) {
    _inputFieldBackgroundColor = color;
  }


  public String getInputFieldBorderColorAsString() {
    return this.convertToHexString(this.getInputFieldBorderColor());
  }


  public long getInputFieldBorderColor() {
    return _inputFieldBorderColor;
  }


  public void setInputFieldBorderColor(long color) {
    _inputFieldBorderColor = color;
  }


  public String getInputFieldTextColorAsString() {
    return this.convertToHexString(this.getInputFieldTextColor());
  }


  public long getInputFieldTextColor() {
    return _inputFieldTextColor;
  }


  public void setInputFieldTextColor(long color) {
    _inputFieldTextColor = color;
  }


  public String getTitleBackgroundColorAsString() {
    return this.convertToHexString(this.getTitleBackgroundColor());
  }


  public long getTitleBackgroundColor() {
    return _titleBackgroundColor;
  }


  public void setTitleBackgroundColor(long color) {
    _titleBackgroundColor = color;
  }


  public String getTitleTextColorAsString() {
    return this.convertToHexString(this.getTitleTextColor());
  }


  public long getTitleTextColor() {
    return _titleTextColor;
  }


  public void setTitleTextColor(long color) {
    _titleTextColor = color;
  }


  private String convertToHexString(long val) {
    return "#" + Long.toHexString(val);
  }


  // endregion



  // endregion
}