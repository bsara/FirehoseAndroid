package com.mysterioustrousers.firehose.interactions;



import java.net.URL;
import java.util.Date;

import com.mysterioustrousers.firehose.Agent;
import com.mysterioustrousers.firehose.Customer;
import com.mysterioustrousers.firehose.FHObject;
import com.mysterioustrousers.firehose.accounts.CustomerAccount;



public abstract class Interaction extends FHObject {

  private Agent                _agent;
  private Customer             _customer;
  private CustomerAccount      _customerAccount;
  private String               _token;
  private String               _responseDraft;
  private String               _subject;
  private String               _body;
  private URL                  _privateURL;
  private Date                 _receivedAt;
  private InteractionHappiness _happiness;
  private boolean              _isResolved;
  private boolean              _isOutgoing;

  //private Set responseInteractions;
  //private Set notes;
  //private Set tags;
  //private Set flaggedAgents;



  protected Interaction() {
    super();

    this.setAgent(null);
    this.setCustomer(null);
    this.setCustomerAccount(null);
    this.setToken(null);
    this.setResponseDraft(null);
    this.setSubject(null);
    this.setBody(null);
    this.setPrivateURL(null);
    this.setReceivedAt(null);
    this.setHappiness(InteractionHappiness.UNKNOWN);
    this.setResolved(false);
    this.setOutgoing(false);
  }



  // region Getters/Setters


  public Agent getAgent() {
    return _agent;
  }


  public void setAgent(Agent agent) {
    _agent = agent;
  }


  public Customer getCustomer() {
    return _customer;
  }


  public void setCustomer(Customer customer) {
    _customer = customer;
  }


  public CustomerAccount getCustomerAccount() {
    return _customerAccount;
  }


  public void setCustomerAccount(CustomerAccount customerAccount) {
    _customerAccount = customerAccount;
  }


  public String getToken() {
    return _token;
  }


  public void setToken(String token) {
    _token = token;
  }


  public String getResponseDraft() {
    return _responseDraft;
  }


  public void setResponseDraft(String responseDraft) {
    _responseDraft = responseDraft;
  }


  public String getSubject() {
    return _subject;
  }


  public void setSubject(String subject) {
    _subject = subject;
  }


  public String getBody() {
    return _body;
  }


  public void setBody(String body) {
    _body = body;
  }


  public URL getPrivateURL() {
    return _privateURL;
  }


  public void setPrivateURL(URL privateURL) {
    _privateURL = privateURL;
  }


  public Date getReceivedAt() {
    return _receivedAt;
  }


  public void setReceivedAt(Date receivedAt) {
    _receivedAt = receivedAt;
  }


  public InteractionHappiness getHappiness() {
    return _happiness;
  }


  public void setHappiness(InteractionHappiness happiness) {
    _happiness = happiness;
  }


  public boolean isResolved() {
    return _isResolved;
  }


  public void setResolved(boolean isResolved) {
    _isResolved = isResolved;
  }


  public boolean isOutgoing() {
    return _isOutgoing;
  }


  public void setOutgoing(boolean isOutgoing) {
    _isOutgoing = isOutgoing;
  }


  // endregion
}