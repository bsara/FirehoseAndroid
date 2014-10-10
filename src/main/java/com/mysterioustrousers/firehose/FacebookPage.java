package com.mysterioustrousers.firehose;



import com.mysterioustrousers.firehose.accounts.FacebookAccount;



public class FacebookPage extends FHObject<Integer> {

  private FacebookAccount _account;
  private String          _name;
  private String          _category;
  private String          _pageId;
  private boolean         _isActive;



  public FacebookPage() {
    super();

    this.setFacebookAccount(null);
    this.setName(null);
    this.setCategory(null);
    this.setPageId(null);
    this.setActive(false);
  }



  // region Getters/Setters


  public FacebookAccount getFacebookAccount() {
    return _account;
  }


  public boolean setFacebookAccount(FacebookAccount account) {
    if (_account == account) {
      return true;
    }


    boolean success = true;

    if (_account != null) {
      success = _account.removeFacebookPage(this);
    }

    _account = account;

    if (_account != null) {
      success = success && _account.addFacebookPage(this);
    }

    return success;
  }


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public String getCategory() {
    return _category;
  }


  public void setCategory(String category) {
    _category = category;
  }


  public String getPageId() {
    return _pageId;
  }


  public void setPageId(String id) {
    _pageId = id;
  }


  public boolean isActive() {
    return _isActive;
  }


  public void setActive(boolean isActive) {
    _isActive = isActive;
  }


  // endregion
}