
package observer;

import model.EmailEvent;

public interface EmailObserver {

  void update(EmailEvent event);
}
