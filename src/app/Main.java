package app;

import controller.EmailController;
import factory.MockSenderFactory;
import facade.EmailFacade;
import model.ContentType;
import model.EmailSendResult;
import observer.EmailEventPublisher;
import observer.EmailLogObserver;
import observer.EmailNotificationObserver;
import repository.EmailRepository;
import repository.InMemoryEmailRepository;
import strategy.EmailSendingStrategy;
import strategy.IndividualSendingStrategy;
import validation.EmailValidator;

import java.util.List;


public class Main {

  public static void main(String[] args) {

    System.out.println("========================================");
    System.out.println("          EMAIL MANAGER SYSTEM");
    System.out.println("========================================");

    System.out.println("\n[1] Inicializando componentes...");

    EmailRepository repository =
        new InMemoryEmailRepository();

    EmailEventPublisher publisher =
        new EmailEventPublisher();

    EmailLogObserver logObserver =
        new EmailLogObserver(repository);

    EmailNotificationObserver notificationObserver =
        new EmailNotificationObserver();

    publisher.addObserver(logObserver);
    publisher.addObserver(notificationObserver);

    EmailSendingStrategy strategy =
        new IndividualSendingStrategy();

    EmailFacade facade = new EmailFacade(
        new MockSenderFactory(),
        strategy,
        new EmailValidator(),
        publisher
    );

    EmailController controller =
        new EmailController(facade);

    System.out.println("Sistema inicializado com sucesso.");

    System.out.println("\n[2] Composição e envio de e-mail...");

    List<String> recipients = List.of(
        "usuario1@email.com",
        "usuario2@email.com"
    );

    List<EmailSendResult> results =
        controller.composeAndSendEmail(
            "sistema@email.com",
            recipients,
            "Apresentação do Email Manager",
            "Este é um teste de envio do sistema Email Manager.",
            ContentType.TEXT,
            List.of()
        );

    System.out.println("\nResultados do primeiro envio:");

    for (EmailSendResult result : results) {
      System.out.println(
          "Status: " + result.getStatus()
      );
    }

    System.out.println("\n[3] Consultando histórico de envios...");

    List<EmailSendResult> history =
        repository.findAll();

    System.out.println(
        "Total de registros: " + history.size()
    );

    for (EmailSendResult result : history) {
      System.out.println("--------------------------------");
      System.out.println(
          "Remetente: "
              + result.getMessage().getSender()
      );
      System.out.println(
          "Destinatários: "
              + result.getMessage().getRecipients()
      );
      System.out.println(
          "Assunto: "
              + result.getMessage().getSubject()
      );
      System.out.println(
          "Status: " + result.getStatus()
      );
      System.out.println(
          "Data: " + result.getSentAt()
      );
    }

    System.out.println("\n[4] Consultando envios com falha...");

    List<EmailSendResult> failedEmails =
        repository.findByStatus("FAILED");

    System.out.println(
        "Total de envios com falha: "
            + failedEmails.size()
    );

    System.out.println("\n========================================");
    System.out.println("       EXECUÇÃO FINALIZADA");
    System.out.println("========================================");
  }
}
