
package model;

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
