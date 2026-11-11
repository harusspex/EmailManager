
package repository;

import model.EmailSendResult;
import java.util.List;

public interface EmailRepository {

  void save(EmailSendResult result);

  List<EmailSendResult> findAll();

  List<EmailSendResult> findByStatus(String status);

}
