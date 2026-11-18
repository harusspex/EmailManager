
package factory;

import adapter.EmailSender;

/**
 * Classe abstrata responsável por definir o contrato de criação
 * dos mecanismos de envio de e-mails.
 *
 * Implementa o padrão Factory Method, permitindo que subclasses
 * definam qual implementação de EmailSender será instanciada,
 * desacoplando a criação dos objetos de sua utilização.
 */

public abstract class EmailSenderFactory {

  public abstract EmailSender createSender();

}
