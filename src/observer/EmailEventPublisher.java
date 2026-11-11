
package observer;

import model.EmailEvent;

import java.util.ArrayList;
import java.util.List;

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
