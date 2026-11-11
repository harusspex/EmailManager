
package controller;

import builder.EmailMessageBuilder;
import facade.EmailFacade;
import model.EmailAttachment;
import model.EmailMessage;
import model.EmailSendResult;
import model.ContentType;

import java.util.List;

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
