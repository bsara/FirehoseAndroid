package com.mysterioustrousers.firehose;



public class CompanyNotFoundException extends Exception {

  private Company _company;



  public CompanyNotFoundException(Company company) {
    super();

    if (company == null) {
      throw new IllegalArgumentException("company cannot be null!");
    }

    _company = company;
  }


  public Company getCompany() {
    return _company;
  }


  @Override
  public String getMessage() {
    return String.format("The company '%s' with ID of '%d' could not be found!", _company.getTitle(), _company.getId());
  }
}