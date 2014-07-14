package com.mysterioustrousers.firehose.interactions;



import java.util.Date;

import com.mysterioustrousers.firehose.Agent;
import com.mysterioustrousers.firehose.FHObject;
import com.mysterioustrousers.firehose.Visitor;



public class ChatInteraction extends Interaction {

  public enum ChatInteractionKind {
    ChatInteractionKindChat,
    ChatInteractionKindNavigation
  }


  public Visitor visitor;

  public String deliveredAt;

  public String readAt;

  public String editedAt;

  public String failedAt;

  public String senderDisplayName;

  public ChatInteractionKind kind;



  public ChatInteraction() {
    super();

    // TODO: Implement
  }



  public static ChatInteraction chatInteractionWithBody(String body, Agent agent, Visitor visitor) {
    // TODO some way of caching
    //ChatInteraction interaction  = ChatInteraction.chatInteractionWithIdentifier(this.generatedUUID()));
    ChatInteraction interaction = new ChatInteraction();
    interaction.setId(FHObject.generatedUUID());
    interaction.agent = agent;
    interaction.body = body;
    interaction.visitor = visitor;
    interaction.setCreatedAt(new Date().toString());
    interaction.isOutgoing = true;
    if (agent != null && agent.getFirstName() != null) {
      String firstName = agent.getFirstName();
      interaction.senderDisplayName = !firstName.isEmpty() ? agent.getFirstName() : "Unknown";
    }
    return interaction;
  }

  /*
  public static ChatInteraction chatInteractionWithIdentifier(Object identifier) {
    if (identifier==null) throw new AssertionError("You cannot create a chat interaction without an identifier.");
    return (ChatInteraction)this.objectWithIdentifier:identifier];
  }
  */
}