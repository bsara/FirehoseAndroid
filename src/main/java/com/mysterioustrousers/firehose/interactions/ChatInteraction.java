package com.mysterioustrousers.firehose.interactions;



import java.util.Date;

import com.google.gson.annotations.SerializedName;

import com.mysterioustrousers.firehose.Agent;
import com.mysterioustrousers.firehose.FHObject;
import com.mysterioustrousers.firehose.Visitor;



public class ChatInteraction extends Interaction {

  public enum ChatInteractionKind {
    ChatInteractionKindChat,
    ChatInteractionKindNavigation
  }


  private Visitor _visitor;



  @SerializedName("message_id")
  private String _messageId;

  @SerializedName("product_token")
  private String _productToken;

  @SerializedName("delivered_at")
  private String _deliveredAt;

  @SerializedName("read_at")
  private String _readAt;

  @SerializedName("edited_at")
  private String _editedAt;

  @SerializedName("failed_at")
  private String _failedAt;

  private String _senderDisplayName;

  private ChatInteractionKind _kind;



  public ChatInteraction() {
    super();

    // TODO: Implement
  }



  public static ChatInteraction chatInteractionWithBody(String body, Agent agent, Visitor visitor) {
    //ChatInteraction interaction  = ChatInteraction.chatInteractionWithIdentifier(this.generatedUUID()));
    ChatInteraction interaction = new ChatInteraction();
    interaction.setId(FHObject.generatedUUID());
    interaction.agent = agent;
    interaction.body = body;
    interaction.setVisitor(visitor);
    interaction.setCreatedAt(new Date().toString());
    interaction.isOutgoing = true;
    if (agent != null && agent.getFirstName() != null) {
      String firstName = agent.getFirstName();
      interaction.setSenderDisplayName(!firstName.isEmpty() ? agent.getFirstName() : "Unknown");
    }
    return interaction;
  }

  /*
  public static ChatInteraction chatInteractionWithIdentifier(Object identifier) {
    if (identifier==null) throw new AssertionError("You cannot create a chat interaction without an identifier.");
    return (ChatInteraction)this.objectWithIdentifier:identifier];
  }
  */


  // region Getter & Setters


  @Override
  public void setId(Object messageId) {
    this._messageId = messageId.toString();
  }


  @Override
  public Object getId() {
    return _messageId;
  }


  public String getMessageId() {
    return _messageId;
  }


  public void setMessageId(String _messageId) {
    this._messageId = _messageId;
  }


  public ChatInteractionKind getKind() {
    return _kind;
  }


  public void setKind(ChatInteractionKind kind) {
    this._kind = kind;
  }


  public Visitor getVisitor() {
    return _visitor;
  }


  public void setVisitor(Visitor visitor) {
    this._visitor = visitor;
  }


  public String getProductToken() {
    return _productToken;
  }


  public void setProductToken(String productToken) {
    this._productToken = productToken;
  }


  public String getDeliveredAt() {
    return _deliveredAt;
  }


  public void setDeliveredAt(String deliveredAt) {
    this._deliveredAt = deliveredAt;
  }


  public String getReadAt() {
    return _readAt;
  }


  public void setReadAt(String readAt) {
    this._readAt = readAt;
  }


  public String getEditedAt() {
    return _editedAt;
  }


  public void setEditedAt(String editedAt) {
    this._editedAt = editedAt;
  }


  public String getFailedAt() {
    return _failedAt;
  }


  public void setFailedAt(String failedAt) {
    this._failedAt = failedAt;
  }


  public String getSenderDisplayName() {
    return _senderDisplayName;
  }


  public void setSenderDisplayName(String senderDisplayName) {
    this._senderDisplayName = senderDisplayName;
  }

  // endregion
}