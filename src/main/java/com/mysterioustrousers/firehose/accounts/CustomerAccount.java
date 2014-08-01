package com.mysterioustrousers.firehose.accounts;



import com.mysterioustrousers.firehose.Customer;



public class CustomerAccount extends Account {

  private Customer _customer;
  private String   _desc;
  private String   _channel;
  private boolean  _isFollowingUs;
  private int      _followersCount;



  public CustomerAccount() {
    super();

    this.setCustomer(null);
    this.setDescription(null);
    this.setChannel(null);
    this.setIsFollowingUs(false);
    this.setFollowersCount(0);
  }



  // region Getters/Setters


  public Customer getCustomer() {
    return _customer;
  }


  public boolean setCustomer(Customer customer) {
    if (_customer == customer) {
      return true;
    }


    boolean success = true;

    if (_customer != null) {
      success = _customer.removeCustomerAccount(this);
    }

    _customer = customer;

    if (_customer != null) {
      success = success && _customer.addCustomerAccount(this);
    }

    return success;
  }


  public String getDescription() {
    return _desc;
  }


  public void setDescription(String desc) {
    _desc = desc;
  }


  public String getChannel() {
    return _channel;
  }


  public void setChannel(String channel) {
    _channel = channel;
  }


  public boolean isFollowingUs() {
    return _isFollowingUs;
  }


  public void setIsFollowingUs(boolean isFollowingUs) {
    _isFollowingUs = isFollowingUs;
  }


  public int getFollowersCount() {
    return _followersCount;
  }


  public void setFollowersCount(int followersCount) {
    _followersCount = followersCount;
  }


  // endregion
}