
package facade;

import factory.EmailSenderFactory;
import adapter.EmailSender;
import model.EmailMessage;
import model.EmailSendResult;
import model.EmailEvent;
import strategy.EmailSendingStrategy;
import observer.EmailEventPublisher;
import validation.EmailValidator;

import java.util.List;

/**
 * Fachada responsável por centralizar e coordenar as operações
 * de envio de e-mails.
 *
 * Utiliza o padrão Facade para simplificar a interação entre os
 * diferentes componentes do sistema, integrando validação, criação
 * do mecanismo de envio, estratégia de distribuição e notificação
 * dos eventos gerados.
 *
 * Também permite alterar a estratégia de envio durante a execução
 * da aplicação.
 */

public class EmailFacade {

    private final EmailSenderFactory senderFactory;
    private EmailSendingStrategy strategy;
    private final EmailValidator validator;
    private final EmailEventPublisher publisher;

    public EmailFacade(
            EmailSenderFactory senderFactory,
            EmailSendingStrategy strategy,
            EmailValidator validator,
            EmailEventPublisher publisher) {

        this.senderFactory = senderFactory;
        this.strategy = strategy;
        this.validator = validator;
        this.publisher = publisher;
    }

    public List<EmailSendResult> sendEmail(EmailMessage email) {

        if (!validator.validate(email).isEmpty()) {
            throw new IllegalArgumentException(
                    "A mensagem possui dados inválidos."
            );
        }

        EmailSender sender = senderFactory.createSender();

        List<EmailSendResult> results = strategy.send(sender, email);

        for (EmailSendResult result : results) {
            EmailEvent event = new EmailEvent(email, result);
            publisher.notifyObservers(event);
        }

        return results;
    }

    public void setStrategy(EmailSendingStrategy strategy) {
        this.strategy = strategy;
    }
}
