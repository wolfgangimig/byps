package byps.gen.xml;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

public class TypeH {

  protected final ProcessingEnvironment penv;
  protected final TypeElement element;
  
  
  public String getPackage() {
    Element enclosing = element;
    while (enclosing.getKind() != ElementKind.PACKAGE) {
      enclosing = enclosing.getEnclosingElement();
    }
    PackageElement packageElement = (PackageElement) enclosing;
    return packageElement.getQualifiedName().toString();
  }

  
  protected TypeH(ProcessingEnvironment penv, TypeElement element) {
    super();
    this.penv = penv;
    this.element = element;
  }

  
}
