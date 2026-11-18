
package strategy;

import adapter.EmailSender;
import builder.EmailMessageBuilder;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa a estratégia de envio individual de e-mails.
 *
 * Cria uma mensagem separada para cada destinatário, preservando
 * as informações originais, como remetente, assunto, conteúdo,
 * formato e anexos.
 *
 * Cada mensagem é enviada individualmente pelo mecanismo
 * disponibilizado através da interface EmailSender.
 */

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
