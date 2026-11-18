
package repository;

import model.EmailSendResult;
import model.EmailStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de EmailRepository que armazena os resultados
 * de envio em memória durante a execução da aplicação.
 *
 * Utiliza uma lista para registrar os resultados e disponibiliza
 * operações para recuperar todos os registros ou filtrá-los pelo status.</p>
 *
 * <p>Os dados não são persistidos em arquivos ou banco de dados,
 * sendo perdidos quando a aplicação é encerrada.
 */

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
