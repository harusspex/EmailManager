
package validation;

import model.EmailMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por validar os dados de uma mensagem de e-mail
 * antes que ela seja encaminhada para o processo de envio.
 *
 * Verifica a presença das informações obrigatórias, como remetente,
 * destinatários, assunto, conteúdo e tipo de conteúdo.
 *
 * Retorna uma lista com as mensagens de erro encontradas,
 * permitindo identificar os problemas sem interromper a validação
 * na primeira inconsistência.
 */

public class EmailValidator {

    public List<String> validate(EmailMessage email) {
        List<String> errors = new ArrayList<>();

        if (email == null) {
            errors.add("A mensagem não pode ser nula.");
            return errors;
        }

        if (email.getSender() == null || email.getSender().isBlank()) {
            errors.add("O remetente é obrigatório.");
        }

        if (email.getRecipients() == null || email.getRecipients().isEmpty()) {
            errors.add("É necessário informar pelo menos um destinatário.");
        } else {
            for (String recipient : email.getRecipients()) {
                if (recipient == null || recipient.isBlank()) {
                    errors.add("Existe um destinatário inválido.");
                    break;
                }
            }
        }

        if (email.getSubject() == null || email.getSubject().isBlank()) {
            errors.add("O assunto é obrigatório.");
        }

        if (email.getContent() == null || email.getContent().isBlank()) {
            errors.add("O conteúdo do e-mail é obrigatório.");
        }

        if (email.getContentType() == null) {
            errors.add("O tipo de conteúdo é obrigatório.");
        }

        return errors;
    }
}
