
package builder;

import java.util.ArrayList;
import java.util.List;

import model.EmailMessage;
import model.EmailAttachment;
import model.ContentType;

/**
 * Constrói objetos EmailMessage de forma gradual e organizada,
 * utilizando o padrão de projeto Builder.
 *
 * Permite configurar os dados da mensagem, adicionar destinatários
 * e anexos e definir o formato do conteúdo antes de sua criação.
 *
 * Facilita a criação de mensagens sem a necessidade de
 * construtores com muitos parâmetros.
 */

public class EmailMessageBuilder {

  private String sender;
  private String subject;
  private String content;

  private List<String> recipients = new ArrayList<>();
  private List<EmailAttachment> attachments = new ArrayList<>();

  private ContentType type = ContentType.TEXT;

  public EmailMessageBuilder setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public EmailMessageBuilder setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public EmailMessageBuilder setContent(String content) {
    this.content = content;
    return this;
  }

  public EmailMessageBuilder addRecipient(String recipient) {
    this.recipients.add(recipient);
    return this;
  }

  public EmailMessageBuilder addAttachment(EmailAttachment attachment) {
    this.attachments.add(attachment);
    return this;
  }

  public EmailMessageBuilder setContentType(ContentType type) {
    this.type = type;
    return this;
  }

  public EmailMessage build() {
    EmailMessage message = new EmailMessage();

    message.setSender(sender);
    message.setSubject(subject);
    message.setContent(content);
    message.setRecipients(new ArrayList<>(recipients));
    message.setContentType(type);

    for (EmailAttachment attachment : attachments) {
      message.addAttachment(attachment);
    }

    return message;
  }
}
