
package strategy;

import adapter.EmailSender;
import model.EmailMessage;
import model.EmailSendResult;

import java.util.List;

public interface EmailSendingStrategy {

  List<EmailSendResult> send(EmailSender sender, EmailMessage message);
}
