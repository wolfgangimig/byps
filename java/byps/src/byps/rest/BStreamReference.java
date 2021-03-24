package byps.rest;

import java.io.IOException;
import java.io.InputStream;

public class BStreamReference extends InputStream {
  
  private String file;
  
  private String url;
  
  @Override
  public int read() throws IOException {
    throw new UnsupportedOperationException();
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
