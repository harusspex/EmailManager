
package strategy;

import adapter.EmailSender;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.List;

public class BatchSendingStrategy implements EmailSendingStrategy {

  @Override
  public List<EmailSendResult> send(EmailSender sender, EmailMessage message) {

    EmailSendResult result = sender.send(message);

    return List.of(result);
  }
}
