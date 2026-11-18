
package observer;

import model.EmailEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por gerenciar os observadores registrados e distribuir
 * notificações sobre eventos de envio de e-mails.
 *
 * Implementa a função de publicador no padrão Observer, permitindo
 * adicionar, remover e notificar observadores sem depender de suas
 * implementações concretas.
 */

public class EmailEventPublisher {

  private final List<EmailObserver> observers = new ArrayList<>();

  public void addObserver(EmailObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(EmailObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers(EmailEvent event) {
    for (EmailObserver observer : observers) {
      observer.update(event);
    }
  }
}
