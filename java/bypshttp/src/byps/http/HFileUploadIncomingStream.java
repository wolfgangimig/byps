package byps.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BTargetId;
import jakarta.servlet.http.Part;

/**
 * Incoming stream as wrapper for Apache Commons File Upload.
 *
 */
public class HFileUploadIncomingStream {
  private static Logger log = LoggerFactory.getLogger(HFileUploadIncomingStream.class);

  private HFileUploadIncomingStream() {}

  /**
   * 
   * @param fileItem Apache file item
   * @param targetId BTargetId to allow management in {@link HActiveMessages#addIncomingStream(BTargetId, HRequestContext)}.
   * @param tempDir Directory for temporary files
   */
  public static BContentStream create(Part fileItem, BTargetId targetId, File tempDir) {
    if (log.isDebugEnabled()) log.debug("create(fileItem={}, targetId={}, tempDir={}", fileItem, targetId, tempDir);
    try {
      HIncomingStreamSync incomingStream = new HIncomingStreamSync(targetId, fileItem.getContentType(), fileItem.getSize(), "", HConstants.REQUEST_TIMEOUT_MILLIS, tempDir);
      incomingStream.setContentDisposition(fileItem.getSubmittedFileName(), false);
  
      HTempFile tempFile = HTempFile.createTemp(tempDir, targetId.getStreamId());
      if (log.isDebugEnabled()) log.debug("tempFile={}", tempFile);
      try (OutputStream ostream = new FileOutputStream(tempFile.getFile()); 
          InputStream istream = fileItem.getInputStream()) {
        istream.transferTo(ostream);
      }
      incomingStream.assignFile(tempFile);
  
      if (log.isDebugEnabled()) log.debug(")create={}", incomingStream);
      return incomingStream;
    }
    catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}

