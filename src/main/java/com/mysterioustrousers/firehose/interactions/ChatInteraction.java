package com.mysterioustrousers.firehose.interactions;



import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.mysterioustrousers.firehose.Agent;
import com.mysterioustrousers.firehose.FHObject;



public class ChatInteraction extends Interaction {

  @SerializedName("visitor_id")
  private String _visitorId;

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



  public static ChatInteraction chatInteractionWithBody(String body, Agent agent, String visitorId, ChatInteractionKind kind) {
    //ChatInteraction interaction  = ChatInteraction.chatInteractionWithIdentifier(this.generatedUUID()));
    ChatInteraction interaction = new ChatInteraction();
    interaction.setId(FHObject.generatedUUID());
    interaction.setKind(kind);
    interaction.setAgent(agent);
    interaction.setBody(body);
    interaction.setVisitorId(visitorId);
    interaction.setCreatedAt(new Date());
    interaction.setOutgoing(true);
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


  public boolean isSenderAnAgent() {
    return this.getAgent() != null;
  }


  public boolean isSenderCurrentAgent() {
    return this.isSenderAnAgent()
           && Agent.getLoggedInAgent() != null
           && Agent.getLoggedInAgent().getId() == this.getAgent().getId();
  }


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


  public String getVisitorId() {
    return _visitorId;
  }


  public void setVisitorId(String visitorId) {
    this._visitorId = visitorId;
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