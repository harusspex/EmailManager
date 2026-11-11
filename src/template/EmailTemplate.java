
package template;

import model.ContentType;

public class EmailTemplate {

    private final String name;
    private final String subject;
    private final String content;
    private final ContentType contentType;

    public EmailTemplate(
            String name,
            String subject,
            String content,
            ContentType contentType) {

        this.name = name;
        this.subject = subject;
        this.content = content;
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public ContentType getContentType() {
        return contentType;
    }
}
