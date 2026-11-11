
package strategy;

import adapter.EmailSender;
import builder.EmailMessageBuilder;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.ArrayList;
import java.util.List;

public class IndividualSendingStrategy implements EmailSendingStrategy {

  @Override
  public List<EmailSendResult> send(EmailSender sender, EmailMessage message) {

    List<EmailSendResult> results = new ArrayList<>();

    for (String recipient : message.getRecipients()) {

      EmailMessage individualMessage = new EmailMessageBuilder()
          .setSender(message.getSender())
          .setSubject(message.getSubject())
          .setContent(message.getContent())
          .setContentType(message.getContentType())
          .addRecipient(recipient)
          .build();

      for (var attachment : message.getAttachments()) {

        individualMessage.addAttachment(attachment);
      }

      EmailSendResult result = sender.send(individualMessage);
      results.add(result);
    }

    return results;
  }
}
