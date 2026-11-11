
package model;

import java.time.LocalDateTime;

public class EmailSendResult {

  private EmailMessage message;
  private EmailStatus status;
  private LocalDateTime sentAt;

  public EmailSendResult(EmailMessage message, EmailStatus status) {
    this.message = message;
    this.status = status;

    if (status == EmailStatus.SENT) {
      this.sentAt = LocalDateTime.now();
    }
  }

  public EmailMessage getMessage() {
    return message;
  }

  public EmailStatus getStatus() {
    return status;
  }

  public LocalDateTime getSentAt() {
    return sentAt;
  }
}
