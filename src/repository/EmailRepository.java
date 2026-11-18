
package repository;

import model.EmailSendResult;
import java.util.List;

/**
 * Define o contrato para o armazenamento e a consulta do histórico
 * de operações de envio de e-mails.
 *
 * Abstrai as operações de acesso aos dados, permitindo que diferentes
 * implementações de armazenamento sejam utilizadas sem alterar os
 * componentes que dependem do repositório.
 */

public interface EmailRepository {

  void save(EmailSendResult result);

  List<EmailSendResult> findAll();

  List<EmailSendResult> findByStatus(String status);

}
