package adapter;

import model.EmailMessage;
import model.EmailSendResult;

/**
 * Define o contrato para os mecanismos de envio de e-mails.
 *
 * Permite que diferentes implementações de envio sejam utilizadas
 * de maneira independente, reduzindo o acoplamento entre o sistema
 * e os serviços responsáveis pela entrega das mensagens.
 */

public interface EmailSender {

  EmailSendResult send(EmailMessage message);

}
