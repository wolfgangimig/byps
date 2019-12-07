package byps.gen;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;
import byps.BVersioning;
import byps.gen.api.GeneratorException;
import byps.gen.cpp.GeneratorCpp;
import byps.gen.cs.GeneratorCS;
import byps.gen.db.ClassDB;
import byps.gen.db.CompatibleClassDB;
import byps.gen.db.ConstFieldReader;
import byps.gen.db.XmlClassDB;
import byps.gen.doclet.BDoclet;
import byps.gen.doclet.CompileSource;
import byps.gen.j.GeneratorJ;
import byps.gen.js.GeneratorJS;
import byps.gen.utils.AssignUniqueSerialVersionUID;
import byps.gen.utils.CodePrinter;

public class Main {

  private static Log log = LogFactory.getLog(Main.class);
  
  public enum EMode {
    DETECT,
    ANNOTATION_PROCESSOR,
    JAVADOC,
  }
  
  private static EMode mode = EMode.DETECT;
  
  public static void main(String[] args) {
    
    // Enable printing checkpoints
    CodePrinter.enableCheckpoints(true);

    Context context = new Context();
    try {
      context.parseArgs(args);
  
      // -------------------------------------------------------------------
      // Ensure that serializable classes have a unique serialVersionUID (type ID).
      
      ensureSerialVersionUID(context);
      
      // -------------------------------------------------------------------

      boolean useAnnotationProcessor = isUseAnnotationProcessor();
      if (useAnnotationProcessor) {
        new MainAP(context).run();
      }
      else {
        BDoclet.run(context);
      }
      
    }
    catch (Exception ex) {
      log.error("Code generation failed", ex);
      if (context.getExitCode() == 0) {
        context.setExitCode(1);
      }
    }
    
    System.out.println("Finished, exit code=" + context.getExitCode());
    
    if (context.getExitCode() != 0) {
      System.exit(context.getExitCode());
    }

  }

  public static EMode getMode() {
    return mode;
  }

  public static void setMode(EMode mode) {
    Main.mode = mode;
  }

  private static boolean isUseAnnotationProcessor() {
    boolean useAnnotationProcessor = false;
    
    if (mode == EMode.DETECT) {
      String[] javaVersion = System.getProperty("java.version").split("\\.");
      int major = Integer.parseInt(javaVersion[0]);
      int minor = javaVersion.length > 1 ? Integer.parseInt(javaVersion[1]) : 0;
      useAnnotationProcessor = major > 1 || minor >= 6;
    }
    else {
      useAnnotationProcessor = mode == EMode.ANNOTATION_PROCESSOR;
    }
    return useAnnotationProcessor;
  }

  private static void ensureSerialVersionUID(Context context) throws IOException {
    log.info("Ensure having serialVersionUIDs ==============");
    log.info("source dirs=" + Arrays.toString(context.getSourceDirs()));
    new AssignUniqueSerialVersionUID(context.getSourceDirs(), true).processFiles();
  }
  
  public static ConstFieldReader buildConstFieldReader(Context context) {
    
    String tempDir = System.getProperty("java.io.tmpdir");
    String classpath = System.getProperty("java.class.path");
    String[] sourceDirs = context.getSourceDirs();
    return new CompileSource(tempDir, sourceDirs, classpath);
  }
  
  public static ClassDB readReferenceClassDB(Context context) {
    ClassDB prevClassDB = null;
    File fileClassDB = context.getFileClassDB();
    if (fileClassDB != null) {
      log.info("Read previous API definitions from ClassDB file ==============");
      log.info(fileClassDB);
      prevClassDB = XmlClassDB.read(fileClassDB, false);
      log.info("");
    }
    return prevClassDB;
  }
  
  public static void checkCompatibility(Context context, ClassDB prevClassDB, ClassDB newClassDB) {
    if (prevClassDB != null) {
      log.info("Check compatibility ==============");
      CompatibleClassDB compClassDB = new CompatibleClassDB(prevClassDB, newClassDB);
      if (!compClassDB.ensureCompatible()) {
        context.setExitCode(2);
      }
      log.info("");
    }
  }

  /**
   * Generate the API based on the API definitions in the passed XML file.
   * 
   */
  public static void generateAPI(Context context) throws IOException {
    
    System.out.println("Generate serialisation classes.");

    File fileClassDBNew = context.getFileClassDBNew();
    
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
  


}
