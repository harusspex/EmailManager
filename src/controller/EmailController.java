
package controller;

import builder.EmailMessageBuilder;
import facade.EmailFacade;
import model.EmailAttachment;
import model.EmailMessage;
import model.EmailSendResult;
import model.ContentType;

import java.util.List;

/**
 * Controlador responsável por coordenar as operações de composição
 * e envio de mensagens de e-mail.
 *
 * Utiliza o EmailMessageBuilder para construir mensagens e a
 * EmailFacade para encaminhar as operações de envio, mantendo
 * a separação entre a camada de controle e as regras de negócio.
 */

public class EmailController {

  private final EmailFacade emailFacade;

  public EmailController(EmailFacade emailFacade) {
    this.emailFacade = emailFacade;
  }

  public EmailMessage composeEmail(
      String sender,
      List<String> recipients,
      String subject,
      String content,
      ContentType contentType,
      List<EmailAttachment> attachments) {

    EmailMessageBuilder builder = new EmailMessageBuilder()
        .setSender(sender)
        .setSubject(subject)
        .setContent(content)
        .setContentType(contentType);

    if (recipients != null) {
      for (String recipient : recipients) {
        builder.addRecipient(recipient);
      }
    }

    if (attachments != null) {
      for (EmailAttachment attachment : attachments) {
        builder.addAttachment(attachment);
      }
    }

    return builder.build();
  }

  public List<EmailSendResult> sendEmail(EmailMessage email) {
    return emailFacade.sendEmail(email);
  }

  public List<EmailSendResult> composeAndSendEmail(
      String sender,
      List<String> recipients,
      String subject,
      String content,
      ContentType contentType,
      List<EmailAttachment> attachments) {

    EmailMessage email = composeEmail(
        sender,
        recipients,
        subject,
        content,
        contentType,
        attachments
    );

    return sendEmail(email);
  }
}
