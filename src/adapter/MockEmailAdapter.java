
package adapter;

import model.EmailMessage;
import model.EmailSendResult;
import model.EmailStatus;
import service.MockMailService;

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
