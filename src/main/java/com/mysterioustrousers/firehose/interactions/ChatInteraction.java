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


  public static ChatInteraction chatInteractionWithBody(String body, Agent agent) {
    // TODO some way of caching
    //ChatInteraction interaction  = ChatInteraction.chatInteractionWithIdentifier(this.generatedUUID()));
    ChatInteraction interaction = new ChatInteraction();
    interaction.id = FHObject.generatedUUID();
    interaction.agent = agent;
    interaction.body = body;
    interaction.createdAt = new Date().toString();
    interaction.isOutgoing = true;
    interaction.senderDisplayName = agent.shortName();
    return interaction;
  }

  /*
  public static ChatInteraction chatInteractionWithIdentifier(Object identifier) {
    if (identifier==null) throw new AssertionError("You cannot create a chat interaction without an identifier.");
    return (ChatInteraction)this.objectWithIdentifier:identifier];
  }
*/
}