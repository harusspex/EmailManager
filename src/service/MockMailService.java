
package service;

import java.util.List;

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
