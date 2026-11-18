
package factory;

import adapter.EmailSender;
import adapter.MockEmailAdapter;
import service.MockMailService;

/**
 * Fábrica concreta responsável por criar o mecanismo de envio simulado.
 *
 * Implementa o método de criação definido por EmailSenderFactory,
 * instanciando o MockMailService e encapsulando-o no MockEmailAdapter.=
 *
 * Permite utilizar o sistema sem depender de um servidor SMTP,
 * facilitando testes e demonstrações das funcionalidades.<
 */

public class MockSenderFactory extends EmailSenderFactory {

  @Override
  public EmailSender createSender() {

    MockMailService mailService = new MockMailService();

    return new MockEmailAdapter(mailService);
  }
}
