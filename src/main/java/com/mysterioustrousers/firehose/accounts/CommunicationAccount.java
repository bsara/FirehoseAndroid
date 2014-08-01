package com.mysterioustrousers.firehose.accounts;



import com.mysterioustrousers.firehose.Company;



public abstract class CommunicationAccount extends Account {

  private Company _company;



  protected CommunicationAccount() {
    super();

    this.setCompany(null);
  }



  // region Getters/Setters


  public Company getCompany() {
    return _company;
  }


  public void setCompany(Company company) {
    _company = company;
  }


  // endregion
}