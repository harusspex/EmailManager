
package service;

import java.util.List;

/**
 * Serviço responsável por simular o envio de mensagens de e-mail.
 *
 * Apresenta no console as informações da mensagem, incluindo
 * remetente, destinatários, assunto, formato e conteúdo.
 *
 * É utilizado para testar e demonstrar o funcionamento do sistema
 * sem a necessidade de conexão com um servidor SMTP externo.
 */

public class MockMailService {

  public boolean sendMail(
      String from,
      List<String> to,
      String subject,
      String body,
      String format) {

    System.out.println("\n========== MOCK EMAIL SERVICE ==========");
    System.out.println("Remetente: " + from);
    System.out.println("Destinatários: " + to);
    System.out.println("Assunto: " + subject);
    System.out.println("Formato: " + format);
    System.out.println("Conteúdo: " + body);
    System.out.println("========================================");

    System.out.println("E-mail enviado com sucesso (simulação).");

    return true;
  }
}
