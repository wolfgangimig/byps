package byps.gen.xml;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import byps.BApiDescriptor;
import byps.BVersioning;

public class XmlGenerator extends AbstractProcessor {

  private Messager messager;
  private Elements elements;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    messager = processingEnv.getMessager();
    elements = processingEnv.getElementUtils();
    super.init(processingEnv);
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    try {
      processBApiDescriptor(roundEnv);

    } catch (XmlGeneratorException e) {
      messager.printMessage(Diagnostic.Kind.ERROR, String.format(e.getMessage(), e.getArgs()), e.getElement());
    }
    return false;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> ret = new HashSet<>();
    return ret;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latest();
  }

  private BApiDescriptor apiDesc;
  private static final String BAPI_DESCRIPTOR_CLASS_NAME = "BApi";

  private void processBApiDescriptor(RoundEnvironment roundEnv) {
    
    Optional<? extends Element> apiDescElementOpt = roundEnv.getRootElements().stream()
      .filter(e -> e.getSimpleName().toString().equals(BAPI_DESCRIPTOR_CLASS_NAME))
      .findAny();

    apiDescElementOpt.ifPresent(e -> {
      String pack = getPackage(e);

      Optional<String> apiNameOpt = getConstantValueOfField(e, "NAME");
      String name = apiNameOpt.orElseThrow(() -> new XmlGeneratorException(e, "Missing NAME element in API descriptor."));
      
      Optional<String> apiVersionOpt = getConstantValueOfField(e, "VERSION");
      String version = apiVersionOpt.orElseThrow(() -> new XmlGeneratorException(e, "Missing VERSION element in API descriptor."));
      
      apiDesc = new BApiDescriptor(name, pack, BVersioning.stringToLong(version), false);
    });
  }

  private Optional<String> getConstantValueOfField(Element e, String fieldName) {
    TypeElement element = (TypeElement) e;
    return elements.getAllMembers(element).stream()
      .filter(el -> el.getKind() == ElementKind.FIELD)
      .filter(el -> el.getSimpleName().toString().equals(fieldName))
      .map(el -> (VariableElement)el)
      .map(el -> (String)el.getConstantValue())
      .findAny();
  }

  private String getPackage(Element element) {
    Element enclosing = element;
    while (enclosing.getKind() != ElementKind.PACKAGE) {
      enclosing = enclosing.getEnclosingElement();
    }
    PackageElement packageElement = (PackageElement) enclosing;
    return packageElement.getQualifiedName().toString();
  }

}
