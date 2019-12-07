package byps.gen.xml;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;

public class ClassH extends TypeH {
  
  private Map<String, Object> constantFields;

  public static ClassH fromValue(ProcessingEnvironment penv, Element element) {
    return new ClassH(penv, (TypeElement)element);
  }
  
  public Map<String, Object> getConstantValuesOfFields() {
    if (constantFields == null) {
      constantFields = penv.getElementUtils().getAllMembers(element).stream()
        .filter(el -> el.getKind().isField())
        .filter(el -> el.getModifiers().contains(Modifier.FINAL))
        .filter(el -> el.getModifiers().contains(Modifier.STATIC))
        .map(el -> (VariableElement)el)
        .collect(Collectors.toMap(el -> el.getSimpleName().toString(), VariableElement::getConstantValue));
    } 
    return constantFields;
  }
  
  public <T> T getMandatoryConstant(String fieldName) {
    return getConstantValue(fieldName, null, true, false);
  }

  public <T> T getMandatoryConstantThrowEx(String fieldName) {
    return getConstantValue(fieldName, null, true, true);
  }

  public <T> T getConstant(String fieldName, T defaultValue) {
    return getConstantValue(fieldName, defaultValue, false, false);
  }

  @SuppressWarnings("unchecked")
  private <T> T getConstantValue(String fieldName, T defaultValue, boolean mandatory, boolean throwEx) {
    Map<String, Object> map = getConstantValuesOfFields();
    if (mandatory && !map.containsKey(fieldName)) {
      String msg = "Missing static final field " + fieldName;
      if (throwEx) {
        throw new XmlGeneratorException(element, msg);
      }
      else {
        penv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Missing static final field " + fieldName, element);
      }
    }
    return (T)map.getOrDefault(fieldName, defaultValue);
  }
  
  private ClassH(ProcessingEnvironment penv, TypeElement element) {
    super(penv, element);
  }
}
