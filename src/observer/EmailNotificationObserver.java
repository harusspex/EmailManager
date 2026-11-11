
package observer;

import model.EmailEvent;
import model.EmailStatus;
import model.EmailSendResult;

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
