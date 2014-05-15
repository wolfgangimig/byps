package byps.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BTargetId;

class HFileUploadItemIncomingStream extends BContentStreamWrapper {

  private final FileItem fileItem;
  private final File tempDir;
  private InputStream is;

  HFileUploadItemIncomingStream(FileItem fileItem, BTargetId targetId, File tempDir) throws IOException {
    super(null, fileItem.getContentType(), fileItem.getSize(), HConstants.REQUEST_TIMEOUT_MILLIS);
    this.fileItem = fileItem;
    this.targetId = targetId;
    this.tempDir = tempDir;
    this.setFileName(fileItem.getName());
  }

  @Override
  protected synchronized InputStream openStream() throws IOException {
    return is = fileItem.getInputStream();
  }

  @Override
  public synchronized void close() throws IOException {
    if (is != null) {
      try {
        is.close();
      } catch (IOException ignored) {
      }
    }
    fileItem.delete();
    super.close();
  }

  @Override
  public synchronized BContentStream materialize() throws IOException {
    HIncomingStreamSync incomingStream = null;
    if (this.fileItem.isInMemory()) {
      incomingStream = new HIncomingStreamSync(targetId, fileItem.getContentType(), fileItem.getSize(), "", lifetimeMillis, tempDir);
      incomingStream.assignBytes(fileItem.get());
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

