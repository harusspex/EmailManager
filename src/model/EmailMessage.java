
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma mensagem de e-mail e suas informações.
 *
 * Armazena remetente, destinatários, assunto, conteúdo,
 * formato da mensagem e anexos.
 *
 * É utilizada pelos componentes responsáveis pela composição,
 * validação e processamento dos e-mails.
 */

public class EmailMessage {

  private String sender;
  private String subject;
  private String content;

  private List<String> recipients = new ArrayList<>();
  private List<EmailAttachment> attachments = new ArrayList<>();

  private ContentType type = ContentType.TEXT ;

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<String> getRecipients() {
    return recipients;
  }

  public void addRecipient(String recipient) {
    recipients.add(recipient);
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = new ArrayList<>(recipients);
  }

  public List<EmailAttachment> getAttachments() {
    return attachments;
  }

  public void addAttachment(EmailAttachment attachment) {
    attachments.add(attachment);
  }

  public ContentType getContentType() {
    return type;
  }

  public void setContentType(ContentType type) {
    this.type = type;
  }



}
