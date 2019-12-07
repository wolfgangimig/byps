package byps.gen;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BVersioning;
import byps.gen.db.ClassDB;
import byps.gen.db.CompatibleClassDB;
import byps.gen.db.ConstFieldReader;
import byps.gen.db.XmlClassDB;
import byps.gen.doclet.BDoclet;
import byps.gen.doclet.CompileSource;
import byps.gen.utils.AssignUniqueSerialVersionUID;

public class Main {

  private static Log log = LogFactory.getLog(Main.class);
  
  public enum EMode {
    DETECT,
    ANNOTATION_PROCESSOR,
    JAVADOC,
  }
  
  private static EMode mode = EMode.DETECT;
  
  public static void main(String[] args) {
    
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
      useAnnotationProcessor = Integer.valueOf(javaVersion[0]) > 1;
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
    if (context.getFileClassDB() != null) {
      log.info("Read previous API definitions from ClassDB file ==============");
      log.info(context.getFileClassDB().getAbsolutePath());
      prevClassDB = XmlClassDB.read(context.getFileClassDB(), false);
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



}
