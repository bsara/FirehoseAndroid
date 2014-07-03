package com.mysterioustrousers.firehose.interactions;



import java.util.Date;

import com.mysterioustrousers.firehose.Visitor;



public class ChatInteraction extends Interaction {
  public enum ChatInteractionKind {
    ChatInteractionKindChat,
    ChatInteractionKindNavigation
  };

  public Visitor visitor;

  public Date deliveredAt;

  public Date readAt;

  public Date editedAt;

  public Date failedAt;

  public String senderDisplayName;

  public ChatInteractionKind kind;
}