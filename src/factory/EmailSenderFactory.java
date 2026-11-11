
package factory;

import adapter.EmailSender;

public abstract class EmailSenderFactory {

  public abstract EmailSender createSender();

}
