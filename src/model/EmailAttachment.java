
package model;

/**
 * Representa um arquivo anexado a uma mensagem de e-mail.
 *
 * Armazena o nome do arquivo, seu caminho de localização
 * e o tipo de conteúdo utilizado para identificá-lo.
 *
 */



public class EmailAttachment {

  private String fileName;
  private String filePath;
  private String mimeType;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }
}
