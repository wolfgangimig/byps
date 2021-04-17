package byps.rest;

import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a BContentStream in REST calls.
 * 
 *
 */
public class BStreamReference extends InputStream {
  
  /**
   * Stream ID.
   * ID of a previously uploaded Stream by '.../rest/putstream'.
   * Or the field name in a multipart/form-data request.
   */
  private String streamId;
  
  /**
   * Download URL.
   */
  private String url;
  
  @Override
  public int read() throws IOException {
    throw new UnsupportedOperationException();
  }

  public String getStreamId() {
    return streamId;
  }

  public void setStreamId(String file) {
    this.streamId = file;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
