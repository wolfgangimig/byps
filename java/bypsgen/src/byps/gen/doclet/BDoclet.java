package byps.gen.doclet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import javax.tools.DiagnosticListener;
import javax.tools.DocumentationTool;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;

import byps.BException;
import byps.gen.Context;
import byps.gen.Main;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.cpp.GeneratorCpp;
import byps.gen.cs.GeneratorCS;
import byps.gen.db.ClassDB;
import byps.gen.db.CompatibleClassDB;
import byps.gen.db.ConstFieldReader;
import byps.gen.db.XmlClassDB;
import byps.gen.j.GeneratorJ;
import byps.gen.js.GeneratorJS;
import byps.gen.utils.CodePrinter;

/**
 * This class reads the API definition and generates the serialization classes.
 * The main function starts the javadoc tool of the JDK which calls the start
 * function and passes the javadoc objects of the analyzed classes. The code
 * generators loop through the javadoc objects and create the serialization
 * code. <br/>
 * In order to read constant values or expressions used in the API definition,
 * the classes are compiled before javadoc starts. Using javadoc and the Java
 * compiler the tools.jar file is required from the JDK in the CLASSPATH. <br/>
 * The generator also checks whether the current API version is compatible to a
 * previous one. Therefore it reads a reference definition from an XML file. The
 * current definition is written into a new XML file and if the new API is
 * accepted and checked in into the Version Control System, the new XML file can
 * become the reference file. <br/>
 * The parameters for the code generation are passed over command line arguments
 * of the main function. Some parameters are directed to the javadoc tool,
 * others are private to the generators. A list of all parameters can be found
 * in the manual.
 * 
 * This program produces the following warnings under Java 10 caused by JAXB:   
 * WARNING: An illegal reflective access operation has occurred
 * WARNING: Illegal reflective access by com.sun.xml.bind.v2.runtime.reflect.opt.Injector (file:/C:/Users/Imig/.gradle/caches/modules-2/files-2.1/com.sun.xml.bind/jaxb-impl/2.3.0.1/2e979dabb3e5e74a0686115075956391a14dece8/jaxb-impl-2.3.0.1.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int)
 * WARNING: Please consider reporting this to the maintainers of com.sun.xml.bind.v2.runtime.reflect.opt.Injector
 * WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
 * WARNING: All illegal access operations will be denied in a future release
 * 
 * 
 * Meine Erweiterungen:
 * 
 * @BSessionParamType Klassenname f�r Session-Parameter
 * @BClientRemote Remote-Interface, dass auf der Clientseite implementiert wird
 */
public class BDoclet extends Doclet {
  
  /**
   * Program parameters.
   */
  private static Context context;

  /**
   * Logger
   */
  private static Log log = LogFactory.getLog(BDoclet.class);

  /**
   * Javadoc start function.
   * 
   * @param root
   *          javadoc root object.
   * @return true
   */
  public static boolean start(RootDoc root) {
    log.debug("start(");
    
    // Enable printing checkpoints
    CodePrinter.enableCheckpoints(true);
    
    try {

      // -----------------------------------------------
      // Read XML file with reference definition

      ClassDB prevClassDB = Main.readReferenceClassDB(context);

      // --------------------------------------------------------------------
      // Compile source and provide access to read constant values.
      
      ConstFieldReader compileSource = Main.buildConstFieldReader(context);

      // ------------------------------------------------
      // Convert javadoc objects to internal representation

      log.info("Analyze classes in source directories ==============");
      ClassDB newClassDB = BConvert.makeClassDB(root, compileSource, context.getConvertOptions());
      log.info("");

      // ------------------------------------------------
      // Write current definition into XML file

      log.info("Write new API definitions into ClassDB file ==============");
      log.info(context.getFileClassDBNew().getAbsolutePath());
      XmlClassDB.write(context.getFileClassDBNew(), newClassDB);
      log.info("");

      // ------------------------------------------------
      // Compare reference definition with current definition.
      // Is the current definition compatible?

      Main.checkCompatibility(context, prevClassDB, newClassDB);

      // -------------------------------------------------
      // Generate the API.

      generateAPI(context.getFileClassDBNew());


    } catch (Exception e) {
      log.error("Failed", e);
      context.setExitCode(1);
      return false;
    }

    log.info("Success ==============");
    log.debug(")start");
    return true;
  }

  /**
   * Generate the API based on the API definitions in the passed XML file.
   * 
   * @param fileClassDBNew
   *          XML file with the API classes.
   * @throws GeneratorException
   * @throws BException
   * @throws IOException
   */
  protected static void generateAPI(File fileClassDBNew) throws GeneratorException, BException, IOException {

    // -------------------------------------------------
    // Read current API definitions from the XML file.

    log.info("Read API definitions from ClassDB file ==============");
    log.info(fileClassDBNew.getAbsolutePath());
    ClassDB jdocClassDB = XmlClassDB.read(fileClassDBNew, true);
    log.info("");

    // --------------------------------------------------
    // Some checks before the generators run.

    log.info("Validate API definitions ==============");
    jdocClassDB.validate();
    log.info("");

    // generate C++
    if (context.getPropsCpp() != null) {
      log.info("Generate Cpp code ==============");
      GeneratorCpp gen = new GeneratorCpp();
      gen.build(jdocClassDB, context.getPropsCpp());
      log.info("");
    }

    // generate Java
    if (context.getPropsJ() != null) {
      log.info("Generate Java code ==============");
      GeneratorJ gen = new GeneratorJ();
      gen.build(jdocClassDB, context.getPropsJ());
      log.info("");
    }

    // generate C#
    if (context.getPropsCS() != null) {
      log.info("Generate C# code ==============");
      GeneratorCS gen = new GeneratorCS();
      gen.build(jdocClassDB, context.getPropsCS());
      log.info("");
    }

    // generate JavaScript
    if (context.getPropsJS() != null) {
      log.info("Generate JavaScript code ==============");
      GeneratorJS gen = new GeneratorJS();
      gen.build(jdocClassDB, context.getPropsJS());
      log.info("");
    }
  }

  /**
   * Entry point for generator.
   * @param context 
   * 
   */
  public static void run(Context context) {
    
    setContext(context);
    
    try {
      
      // ---------------------------------------------------------------------
      // Call the javadoc tool.
      List<String> javadocParams = context.getJavadocParams();
      javadocParams.add(0, "-private");
      javadocParams.add(1, "-doclet");
      javadocParams.add(2, BDoclet.class.getName());

      if (!javadocParams.contains("-sourcepath")) {
        ErrorInfo errInfo = new ErrorInfo();
        errInfo.msg = "Missing argument --sourcepath.";
        throw new GeneratorException(errInfo);
      }

      if (!context.getClasspath().isEmpty()) {
        javadocParams.add("-classpath");
        javadocParams.add(context.getClasspath());
      }

      javadocParams.addAll(context.getJavadocPacks());
      javadocParams.addAll(context.getJavadocPacksInSourceDirs());

      String[] javadocArgs = javadocParams.toArray(new String[javadocParams.size()]);

      log.info("Generate serialisation layer ==============");
      doJavaDoc(javadocArgs);

      System.out.println("Finished");
      
    } catch (Exception e) {
      if (context.getExitCode() == 0) context.setExitCode(1);
      e.printStackTrace();
    }

  }
  
  private static void doJavaDoc(String[] javadocArgs) {
    ServiceLoader<DocumentationTool> toolService = ServiceLoader.load(DocumentationTool.class);
    
    Iterator<DocumentationTool> it = toolService.iterator(); 

    if (it.hasNext()) {
      
      // Java 11, ...
      
      DocumentationTool javadocTool = toolService.iterator().next();
      
      Writer out = null;
      JavaFileManager fileManager = null;
      DiagnosticListener<? super JavaFileObject> diagnosticListener = null;
      Class<?> docletClass = BDoclet.class;
      Iterable<String> options = Arrays.asList(javadocArgs);
      Iterable<? extends JavaFileObject> compilationUnits = null;
      
      DocumentationTool.DocumentationTask javadocTask = javadocTool.getTask(out,
          fileManager,
          diagnosticListener,
          docletClass,
          options,
          compilationUnits);
  
      javadocTask.call();
      
    }
    else {
      // Java 8
      com.sun.tools.javadoc.Main.execute(javadocArgs);
    }
    
  }

  /**
   * Find all java packages in the given directory.
   * The functions searches recursively for directories with .java files.
   * @param javadocPackages Found packages
   * @param src Source directory
   * @param pack Current package name.
   */
  private static void findPackages(Collection<String> javadocPackages, File src, String pack) {
    File[] files = src.listFiles();
    boolean foundFile = false;
    for (File f : files) {
      if (f.isDirectory()) {
        String pack1 = pack.length() != 0 ? (pack + ".") : "";
        findPackages(javadocPackages, f, pack1 + f.getName());
      }
      else {
        if (!foundFile) {
          if (f.getName().endsWith(".java")) {
            foundFile = true;
            javadocPackages.add(pack);
          }
        }
      }
    }
  }

  /**
   * NOTE: Without this method present and returning LanguageVersion.JAVA_1_5,
   * Javadoc will not process generics because it assumes
   * LanguageVersion.JAVA_1_1
   * 
   * @return language version (hard coded to LanguageVersion.JAVA_1_5)
   */
  public static LanguageVersion languageVersion() {
    return LanguageVersion.JAVA_1_5;
  }
  
  public static Context getContext() {
    return context;
  }

  public static void setContext(Context context) {
    BDoclet.context = context;
  }

}
