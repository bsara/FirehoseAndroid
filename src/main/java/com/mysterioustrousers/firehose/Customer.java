package com.mysterioustrousers.firehose;



import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.mysterioustrousers.firehose.accounts.CustomerAccount;



public class Customer extends FHObject {

  private String  _name;
  private Company _company;
  private Agent   _agentWithDibs;
  //private ??? _location;
  //private ??? _timeZone;
  private int     _newestInteractionId;
  private String  _newestInteractionExcerpt;
  private Date    _newestInteractionReceivedAt;

  private HashSet<CustomerAccount> _customerAccounts;
  private TreeSet<Agent>           _flaggedAgents;

  //private RemoteArray<Interaction> _interactions;



  public Customer() {
    super();

    this.setName(null);
    this.setCompany(null);
    this.setAgentWithDibs(null);
    //this.setLocation(null);
    //this.setTimeZone(null);
    this.setNewestInteractionId(-1);
    this.setNewestInteractionExcerpt(null);
    this.setNewestInteractionReceivedAt(null);

    _customerAccounts = new HashSet<CustomerAccount>();
    _flaggedAgents = new TreeSet<Agent>(new Comparator<Agent>() {
      @Override
      public int compare(Agent lhs, Agent rhs) {
        return lhs.getFirstName().compareTo(rhs.getFirstName());
      }
    });
  }



  // region Getters/Setters


  public String getName() {
    return _name;
  }


  public void setName(String name) {
    _name = name;
  }


  public Company getCompany() {
    return _company;
  }


  public void setCompany(Company company) {
    _company = company;
  }


  public Agent getAgentWithDibs() {
    return _agentWithDibs;
  }


  public void setAgentWithDibs(Agent agent) {
    _agentWithDibs = agent;
  }


  /*
  public ??? getLocation() {
    return _location;
  }


  public void setLocation(??? location) {
    _location = location;
  }


  public ??? getTimeZone() {
    return _timeZone;
  }


  public void setTimeZone(??? timeZone) {
    _timeZone = timeZone;
  }
  */


  public int getNewestInterationId() {
    return _newestInteractionId;
  }


  public void setNewestInteractionId(int newestInteractionId) {
    _newestInteractionId = newestInteractionId;
  }


  public String getNewestInteractionExcerpt() {
    return _newestInteractionExcerpt;
  }


  public void setNewestInteractionExcerpt(String excerpt) {
    _newestInteractionExcerpt = excerpt;
  }


  public Date getNewestInteractionReceivedAt() {
    return _newestInteractionReceivedAt;
  }


  public void setNewestInteractionReceivedAt(Date receivedAt) {
    _newestInteractionReceivedAt = receivedAt;
  }



  // region CustomerAccounts


  public Iterator<CustomerAccount> getCustomerAccountsIterator() {
    return _customerAccounts.iterator();
  }


  public boolean addCustomerAccounts(Collection<CustomerAccount> customerAccounts) {
    if (customerAccounts == null) {
      return false;
    }

    boolean success = true;
    for (CustomerAccount account : customerAccounts) {
      success = success && this.addCustomerAccount(account);
    }
    return success;
  }


  public boolean addCustomerAccount(CustomerAccount customerAccount) {
    if (customerAccount == null) {
      return false;
    }

    if (customerAccount.getCustomer() != this) {
      return customerAccount.setCustomer(this);
    }

    return _customerAccounts.add(customerAccount);
  }


  public boolean clearCustomerAccounts() {
    boolean success = true;
    for (CustomerAccount account : new HashSet<CustomerAccount>(_customerAccounts)) {
      success = success && this.removeCustomerAccount(account);
    }
    return success;
  }


  public boolean removeCustomerAccount(CustomerAccount customerAccount) {
    if (customerAccount == null) {
      return false;
    }

    boolean success = _customerAccounts.remove(customerAccount);

    if (success && customerAccount.getCustomer() == this) {
      return customerAccount.setCustomer(null);
    }

    return success;
  }


  // endregion



  // region FlaggedAgents


  public Iterator<Agent> getFlaggedAgentsIterator() {
    return _flaggedAgents.iterator();
  }


  public boolean addFlaggedAgents(Collection<Agent> flaggedAgents) {
    if (flaggedAgents == null) {
      return false;
    }
    return _flaggedAgents.addAll(flaggedAgents);
  }


  public boolean addFlaggedAgent(Agent agent) {
    return _flaggedAgents.add(agent);
  }


  public void clearFlaggedAgents() {
    _flaggedAgents.clear();
  }


  public boolean removeFlaggedAgent(Agent agent) {
    return _flaggedAgents.remove(agent);
  }


  // endregion


  // endregion
}