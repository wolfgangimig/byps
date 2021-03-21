package byps.http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BTargetId;

/**
 * Incoming stream as wrapper for Apache Commons File Upload.
 *
 */
public class HFileUploadIncomingStream extends BContentStreamWrapper {

  /**
   * Apache file upload item.
   */
  private final FileItem fileItem;
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
  public HFileUploadIncomingStream(FileItem fileItem, BTargetId targetId, File tempDir) {
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
    if (!fileItem.isInMemory()) {
      inner = new BufferedInputStream(inner);
    }
    return inner;
  }

  @Override
  public synchronized void close() throws IOException {
    super.close();
    fileItem.delete();
  }

  @Override
  public synchronized BContentStream materialize() throws IOException {
    HIncomingStreamSync incomingStream = null;
    if (this.fileItem.isInMemory()) {
      incomingStream = new HIncomingStreamSync(targetId, fileItem.getContentType(), fileItem.getSize(), "", lifetimeMillis, tempDir);
      incomingStream.assignBytes(fileItem.get(), (int)fileItem.getSize());
    }
    else {
      HTempFile tempFile = null;
      try {
        incomingStream = new HIncomingStreamSync(targetId, fileItem.getContentType(), fileItem.getSize(), "", lifetimeMillis, tempDir);
        tempFile = HTempFile.createTemp(tempDir, targetId.getStreamId());
        tempFile.getFile().delete(); // FileItem.write will move the file.
        fileItem.write(tempFile.getFile());
        incomingStream.assignFile(tempFile);
      } catch (IOException e) {
        throw e;
      } catch (Exception e) {
        throw new IOException(e);
      } finally {
        if (tempFile != null) {
          tempFile.release();
        }
      }
    }
    incomingStream.setContentDisposition(fileItem.getName(), false);
    
    this.close();
    
    return incomingStream;
  }
}

