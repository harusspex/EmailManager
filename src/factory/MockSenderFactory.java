
package factory;

import adapter.EmailSender;
import adapter.MockEmailAdapter;
import service.MockMailService;

public class MockSenderFactory extends EmailSenderFactory {

  @Override
  public EmailSender createSender() {

    MockMailService mailService = new MockMailService();

    return new MockEmailAdapter(mailService);
  }
}
