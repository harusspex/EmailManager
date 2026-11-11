
package observer;

import model.EmailEvent;
import model.EmailSendResult;
import repository.EmailRepository;

import java.util.List;

public class EmailLogObserver implements EmailObserver {

  private final EmailRepository repository;

  public EmailLogObserver(EmailRepository repository) {
    this.repository = repository;
  }

  @Override
  public void update(EmailEvent event) {
    repository.save(event.getResult());
    System.out.println("Log de envio registrado.");
  }

  public List<EmailSendResult> getEmailLogs() {
    return repository.findAll();
  }
}
