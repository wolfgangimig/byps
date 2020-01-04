package byps.test.api.enu;

import java.io.Serializable;

/**
 * 
 * @since 794.0.0.0
 *
 */
public enum MyEncoding implements Serializable {

  UTF8("UTF-8"),
  
  UTF16("UTF-16"),
  
  UTF16LE("UTF-16LE");
  
  private String encoding;
  
  MyEncoding(String encoding) {
    this.encoding = encoding;
  }
  
  public String get() {
    return this.encoding;
  }

}
