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

  private ChatInteractionType _type;



  public ChatInteraction() {
    super();

    // TODO: Implement
  }



  public static ChatInteraction getChatInteraction(String visitorId, Agent agent, String messageBody, ChatInteractionType type) {
    //ChatInteraction interaction  = ChatInteraction.chatInteractionWithIdentifier(this.generatedUUID()));
    ChatInteraction interaction = new ChatInteraction();
    interaction.setId(FHObject.generatedUUID());
    interaction.setType(type);
    interaction.setAgent(agent);
    interaction.setBody(messageBody);
    interaction.setVisitorId(visitorId);
    interaction.setCreatedAt(new Date());
    interaction.setReceivedAt(new Date());
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
           && Agent.getLoggedInAgent().getId().equals(this.getAgent().getId());
  }


  @Override
  public void setId(Object messageId) {
    _messageId = messageId.toString();
  }


  @Override
  public Object getId() {
    return _messageId;
  }


  public String getMessageId() {
    return _messageId;
  }


  public void setMessageId(String messageId) {
    _messageId = messageId;
  }


  public ChatInteractionType getType() {
    return _type;
  }


  public void setType(ChatInteractionType type) {
    _type = type;
  }


  public String getVisitorId() {
    return _visitorId;
  }


  public void setVisitorId(String visitorId) {
    _visitorId = visitorId;
  }


  public String getProductToken() {
    return _productToken;
  }


  public void setProductToken(String productToken) {
    _productToken = productToken;
  }


  public String getDeliveredAt() {
    return _deliveredAt;
  }


  public void setDeliveredAt(String deliveredAt) {
    _deliveredAt = deliveredAt;
  }


  public String getReadAt() {
    return _readAt;
  }


  public void setReadAt(String readAt) {
    _readAt = readAt;
  }


  public String getEditedAt() {
    return _editedAt;
  }


  public void setEditedAt(String editedAt) {
    _editedAt = editedAt;
  }


  public String getFailedAt() {
    return _failedAt;
  }


  public void setFailedAt(String failedAt) {
    _failedAt = failedAt;
  }


  public String getSenderDisplayName() {
    return this.isSenderAnAgent() ? this.getAgent().getDisplayName() : _senderDisplayName;
  }


  public void setSenderDisplayName(String senderDisplayName) {
    _senderDisplayName = senderDisplayName;
  }


  // endregion
}