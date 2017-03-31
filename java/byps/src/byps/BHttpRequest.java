package byps;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class BHttpRequest implements Serializable {

  private static final long serialVersionUID = 24L;
  
  protected Map<String, String> headers;
  
  protected String url;
  
  protected ByteBuffer body;
  
  protected long offset;
  
  protected long length;

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public ByteBuffer getBody() {
    return body;
  }

  public void setBody(ByteBuffer body) {
    this.body = body;
  }

  public long getOffset() {
    return offset;
  }

  public void setOffset(long offset) {
    this.offset = offset;
  }

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void init() {
    if (headers != null) {
      headers.clear();
    }
    else {
      headers = new HashMap<String,String>();
    }
    url = "";
    body = null;
    offset = 0;
    length = 0;
  }
  
}
