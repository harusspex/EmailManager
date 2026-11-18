
package observer;

import model.EmailEvent;
import model.EmailStatus;
import model.EmailSendResult;

/**
 * Observador responsável por exibir notificações sobre os resultados
 * das operações de envio de e-mails.
 *
 * Ao receber um evento, verifica o status da operação e apresenta
 * uma mensagem informando se o envio foi realizado com sucesso
 * ou se ocorreu uma falha.
 */

public class EmailNotificationObserver implements EmailObserver {

  @Override
  public void update(EmailEvent event) {

    EmailSendResult result = event.getResult();

    if (result.getStatus() == EmailStatus.SENT) {
      System.out.println(
          "NOTIFICAÇÃO: E-mail enviado com sucesso para "
              + result.getMessage().getRecipients()
      );
    } else {
      System.out.println(
          "NOTIFICAÇÃO: Falha ao enviar e-mail para "
              + result.getMessage().getRecipients()
      );
    }
  }
}
