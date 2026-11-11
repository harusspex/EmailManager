package adapter;

import model.EmailMessage;
import model.EmailSendResult;

public interface EmailSender {

  EmailSendResult send(EmailMessage message);

}
