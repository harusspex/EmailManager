
package repository;

import model.EmailSendResult;
import model.EmailStatus;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmailRepository implements EmailRepository {

  private final List<EmailSendResult> emailResults = new ArrayList<>();

  @Override
  public void save(EmailSendResult result) {
    emailResults.add(result);
  }

  @Override
  public List<EmailSendResult> findAll() {
    return new ArrayList<>(emailResults);
  }

  @Override
  public List<EmailSendResult> findByStatus(String status) {
    List<EmailSendResult> filteredResults = new ArrayList<>();

    for (EmailSendResult result : emailResults) {
      if (result.getStatus().name().equalsIgnoreCase(status)) {
        filteredResults.add(result);
      }
    }

    return filteredResults;
  }
}
