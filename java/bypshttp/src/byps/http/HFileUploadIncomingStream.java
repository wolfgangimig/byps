package byps.http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BTargetId;
import jakarta.servlet.http.Part;

/**
 * Incoming stream as wrapper for Apache Commons File Upload.
 *
 */
public class HFileUploadIncomingStream extends BContentStreamWrapper {

  /**
   * Apache file upload item.
   */
  private final Part fileItem;
  /**
   * Directory used to backup a DiskFileItem if the stream is materialized.
   */
  private final File tempDir;

  /**
   * Constructor.
   * @param fileItem Apache file item
   * @param targetId BTargetId to allow management in {@link HActiveMessages#addIncomingStream(BTargetId, HRequestContext)}.
   * @param tempDir Directory for temporary files
   */
  public HFileUploadIncomingStream(Part fileItem, BTargetId targetId, File tempDir) {
    super(HConstants.REQUEST_TIMEOUT_MILLIS);
    this.fileItem = fileItem;
    this.targetId = targetId;
    this.tempDir = tempDir;
    this.setFileName(fileItem.getName());
    this.setContentType(fileItem.getContentType());
    this.setContentLength(fileItem.getSize());
  }
  
  @Override
  protected InputStream openStream() throws IOException {
    InputStream inner = fileItem.getInputStream();
    return new BufferedInputStream(inner);
  }

  @Override
  public synchronized void close() throws IOException {
    super.close();
    fileItem.delete();
  }

  @Override
  public synchronized BContentStream materialize() throws IOException {
    HIncomingStreamSync incomingStream = new HIncomingStreamSync(targetId, fileItem.getContentType(), fileItem.getSize(), "", lifetimeMillis, tempDir);
    incomingStream.setContentDisposition(fileItem.getName(), false);

    HTempFile tempFile = HTempFile.createTemp(tempDir, targetId.getStreamId());
    try (OutputStream ostream = new FileOutputStream(tempFile.getFile()); 
        InputStream istream = fileItem.getInputStream()) {
      istream.transferTo(ostream);
    }
    incomingStream.assignFile(tempFile);
    
    this.close();
    return incomingStream;
  }
}

