
package strategy;

import adapter.EmailSender;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.List;

/**
 * Implementa a estratégia de envio de e-mails em lote.
 *
 * Encaminha a mensagem original ao mecanismo de envio em uma única
 * operação, mantendo todos os destinatários na mesma mensagem.
 */

public class BatchSendingStrategy implements EmailSendingStrategy {

  @Override
  public List<EmailSendResult> send(EmailSender sender, EmailMessage message) {

    EmailSendResult result = sender.send(message);

    return List.of(result);
  }
}
