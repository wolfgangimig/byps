package byps;

public class BContentStreamProperties {
  
  private String contentType;
  private long contentLength = -1L;
  private String fileName;
  private int attachmentCode;

  BContentStreamProperties() {
  }

  public BContentStreamProperties(String contentType, long contentLength, String fileName, int attachmentCode) {
    super();
    this.contentType = contentType;
    this.contentLength = contentLength;
    this.fileName = fileName;
    this.attachmentCode = attachmentCode;
  }

  public String getContentType() {
    return contentType != null ? contentType : "";
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public long getContentLength() {
    return contentLength;
  }

  public void setContentLength(long contentLength) {
    this.contentLength = contentLength;
  }

  public String getFileName() {
    return fileName != null ? fileName : "";
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getAttachmentCode() {
    return attachmentCode;
  }

  public void setAttachmentCode(int attachmentCode) {
    this.attachmentCode = attachmentCode;
  }

  @Override
  public String toString() {
    return "[contentType=" + contentType + ", #" + contentLength + "]";
  }

  
}
