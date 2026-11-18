
package model;

/**
 * Representa um evento gerado após uma operação de envio de e-mail.
 *
 * Transporta a mensagem processada e seu resultado para os
 * observadores registrados no sistema, permitindo que sejam
 * realizadas ações como registro de logs e notificações.
 */

public class EmailEvent {

  private EmailMessage message;
  private EmailSendResult result;

  public EmailEvent(EmailMessage message, EmailSendResult result) {
    this.message = message;
    this.result = result;
  }

  public EmailMessage getMessage() {
    return message;
  }

  public EmailSendResult getResult() {
    return result;
  }
}
