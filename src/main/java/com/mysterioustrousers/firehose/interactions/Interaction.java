package com.mysterioustrousers.firehose.interactions;



import java.net.URL;
import java.util.Date;

import com.mysterioustrousers.firehose.Agent;
import com.mysterioustrousers.firehose.Customer;
import com.mysterioustrousers.firehose.FHObject;
import com.mysterioustrousers.firehose.accounts.CustomerAccount;



public abstract class Interaction extends FHObject {

  public enum InteractionChannel {
    InteractionChannelEmail,
    InteractionChannelTwitter,
    InteractionChannelFacebook,
    InteractionChannelChat
  }


  public enum InteractionHappiness {
    InteractionHappinessUnknown,
    InteractionHappinessUpset,
    InteractionHappinessSatisfied,
    InteractionHappinessHappy
  }


  public Customer customer;

  public String               token;
  public String               responseDraft;
  public InteractionHappiness happiness;
  public boolean              resolved;
  public boolean              isOutgoing;
  public String               subject;
  public String               body;
  public URL                  privateURL;
  public InteractionChannel   channel;
  public Date                 receivedAt;
  public CustomerAccount      customerAccount;
  public Agent                agent;

  //public Set responseInteractions;
  //public Set notes;
  //public Set tags;
  //public Set flaggedAgents;



  protected Interaction() {
    super();

    // TODO: Implement
  }
}