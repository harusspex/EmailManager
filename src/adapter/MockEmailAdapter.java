
package adapter;

import model.EmailMessage;
import model.EmailSendResult;
import model.EmailStatus;
import service.MockMailService;

/**
 esponsável por integrar o serviço de envio simulado * Adaptador r
 * ao contrato definido pela interface EmailSender.
 *
 * Utiliza o padrão Adapter para converter os dados de EmailMessage
 * nos parâmetros aceitos pelo MockMailService e transformar o retorno
 * da operação em um EmailSendResult.
 */

public class MockEmailAdapter implements EmailSender {

  private MockMailService mailService;

  public MockEmailAdapter(MockMailService mailService) {
    this.mailService = mailService;
  }

  @Override
  public EmailSendResult send(EmailMessage message) {

    boolean success = mailService.sendMail(
        message.getSender(),
        message.getRecipients(),
        message.getSubject(),
        message.getContent(),
        message.getContentType().name()
    );

    EmailStatus status = success
        ? EmailStatus.SENT
        : EmailStatus.FAILED;

    return new EmailSendResult(message, status);
  }
}
