
package strategy;

import adapter.EmailSender;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.List;

/**
 * Define o contrato para as diferentes estratégias de envio de e-mails.
 *
 * Permite que diferentes formas de distribuição de mensagens sejam
 * implementadas de maneira independente, possibilitando a substituição
 * da estratégia sem alterar os componentes que a utilizam.
 */

public interface EmailSendingStrategy {

  List<EmailSendResult> send(EmailSender sender, EmailMessage message);
}
