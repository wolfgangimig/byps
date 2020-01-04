package byps.gen.xml;

import javax.lang.model.element.Element;

public class XmlGeneratorException extends RuntimeException {
 
  private static final long serialVersionUID = 1L;
  private final transient Element element;
  private final transient Object[] args;
  
  public XmlGeneratorException(Element element, String msg, Object... args) {
    super(msg);
    this.element = element;
    this.args = args;
  }
  
  public XmlGeneratorException(String msg, Object... args) {
    super(msg);
    this.element = null;
    this.args = args;
  }


  public Element getElement() {
    return element;
  }

  public Object[] getArgs() {
    return args;
  }

}
