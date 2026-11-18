
package observer;

import model.EmailEvent;

/**
 * Define o contrato para os observadores interessados nos eventos
 * relacionados ao envio de e-mails.
 *
 * As classes que implementam essa interface devem definir como
 * reagirão quando receberem uma notificação do sistema.
 */

public interface EmailObserver {

  void update(EmailEvent event);
}
