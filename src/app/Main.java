
package app;

import controller.EmailController;
import factory.MockSenderFactory;
import facade.EmailFacade;
import model.ContentType;
import model.EmailMessage;
import model.EmailSendResult;
import observer.EmailEventPublisher;
import observer.EmailLogObserver;
import observer.EmailNotificationObserver;
import repository.EmailRepository;
import repository.InMemoryEmailRepository;
import strategy.EmailSendingStrategy;
import strategy.IndividualSendingStrategy;
import template.EmailTemplate;
import template.EmailTemplateService;
import validation.EmailValidator;

import java.util.List;

/**
 * Classe principal da aplicação Email Manager.
 *
 * Responsável por inicializar e configurar os componentes do sistema,
 * realizar a integração entre os padrões de projeto implementados e
 * demonstrar as principais funcionalidades de gerenciamento e envio
 * de e-mails.
 *
 * A aplicação utiliza envio simulado para demonstrar o funcionamento
 * do sistema sem depender de um servidor SMTP externo.
 */

public class Main {

  public static void main(String[] args) {

    System.out.println("========================================");
    System.out.println("          EMAIL MANAGER SYSTEM");
    System.out.println("========================================");

    // 1. CONFIGURAÇÃO DO SISTEMA

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

    // 2. ENVIO DE E-MAIL

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

    // 3. UTILIZAÇÃO DE TEMPLATE

    System.out.println("\n[3] Utilizando templates de e-mail...");

    EmailTemplateService templateService =
        new EmailTemplateService();

    EmailTemplate welcomeTemplate = new EmailTemplate(
        "Boas-vindas",
        "Bem-vindo ao Email Manager!",
        "Obrigado por utilizar nosso sistema.",
        ContentType.HTML
    );

    templateService.registerTemplate(welcomeTemplate);

    EmailMessage templateEmail =
        templateService.createEmailMessage(
            "Boas-vindas",
            "sistema@email.com",
            List.of("novo.usuario@email.com"),
            List.of()
        );

    List<EmailSendResult> templateResults =
        controller.sendEmail(templateEmail);

    System.out.println("\nResultado do envio por template:");

    for (EmailSendResult result : templateResults) {
      System.out.println(
          "Status: " + result.getStatus()
      );
    }

    // 4. CONSULTA DO HISTÓRICO

    System.out.println("\n[4] Consultando histórico de envios...");

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

    // 5. CONSULTA DE FALHAS

    System.out.println("\n[5] Consultando envios com falha...");

    List<EmailSendResult> failedEmails =
        repository.findByStatus("FAILED");

    System.out.println(
        "Total de envios com falha: "
            + failedEmails.size()
    );

    // 6. ENCERRAMENTO

    System.out.println("\n========================================");
    System.out.println("       EXECUÇÃO FINALIZADA");
    System.out.println("========================================");
  }
}
