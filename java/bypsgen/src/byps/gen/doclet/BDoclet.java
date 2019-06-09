package byps.gen.doclet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

import javax.tools.DiagnosticListener;
import javax.tools.DocumentationTool;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;

import byps.BException;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;
import byps.gen.cpp.GeneratorCpp;
import byps.gen.cpp.PropertiesCpp;
import byps.gen.cs.GeneratorCS;
import byps.gen.cs.PropertiesCS;
import byps.gen.db.ClassDB;
import byps.gen.db.CompatibleClassDB;
import byps.gen.db.XmlClassDB;
import byps.gen.j.GeneratorJ;
import byps.gen.j.PropertiesJ;
import byps.gen.js.GeneratorJS;
import byps.gen.js.PropertiesJS;
import byps.gen.utils.AssignUniqueSerialVersionUID;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.Utils;

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
   * API definition file with the new classes. The API classes found by this run
   * are written into this file.
   */
  private static File fileClassDB_New = new File("bapi_new.xml");

  /**
   * API definition file with the reference classes.
   */
  private static File fileClassDB = new File("bapi.xml");

  /**
   * Generator properties for C# code generator.
   */
  private static PropertiesCS propsCS;

  /**
   * Generator properties for C++ code generator.
   */
  private static PropertiesCpp propsCpp;

  /**
   * Generator properties for Java code generator.
   */
  private static PropertiesJ propsJ;

  /**
   * Generator properties for JavaScript code generator.
   */
  private static PropertiesJS propsJS;

  /**
   * Directories with the source files of the API.
   */
  private static String[] sourceDirs = null;

  /**
   * Classpath for compiler and javadoc.
   */
  private static String classpath = "";

  /**
   * Options to convert from javadoc objects to XML definition.
   */
  private static int convertOptions = 0;

  /**
   * Temporary directory used to store the compiled classes.
   */
  private static String tempDir;

  /**
   * Object that invokes the Java compiler.
   */
  private static CompileSource compileSource;
  
  /**
   * Exit code of main function.
   * If generator fails, exitCode is set to a non zero value.
   */
  private static int exitCode = 0;

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

      ClassDB prevClassDB = null;
      if (fileClassDB != null) {
        log.info("Read previous API definitions from ClassDB file ==============");
        log.info(fileClassDB.getAbsolutePath());
        prevClassDB = XmlClassDB.read(fileClassDB, false);
        log.info("");
      }

      // ------------------------------------------------
      // Convert javadoc objects to internal representation

      log.info("Analyze classes in source directories ==============");
      ClassDB jdocClassDB = BConvert.makeClassDB(root, compileSource, convertOptions);
      log.info("");

      // ------------------------------------------------
      // Write current definition into XML file

      log.info("Write new API definitions into ClassDB file ==============");
      log.info(fileClassDB_New.getAbsolutePath());
      XmlClassDB.write(fileClassDB_New, jdocClassDB);
      log.info("");

      // ------------------------------------------------
      // Compare reference definition with current definition.
      // Is the current definition compatible?

      if (prevClassDB != null) {
        log.info("Check compatibility ==============");
        CompatibleClassDB compClassDB = new CompatibleClassDB(prevClassDB, jdocClassDB);
        if (!compClassDB.ensureCompatible()) {
          exitCode = 2;
          return false;
        }
        log.info("");
      }

      // -------------------------------------------------
      // Generate the API.

      generateAPI(fileClassDB_New);

      // Rename new classdb.xml - this should happen, when sources are checked
      // in into the VCS.
      // log.info("Write " + fileClassDB);
      // if (fileClassDB.exists()) {
      // fileClassDB.delete();
      // }
      // fileClassDB_New.renameTo(fileClassDB);

    } catch (Exception e) {
      log.error("Failed", e);
      exitCode = 1;
      return false;
    }

    log.info("Success ==============");
    log.debug(")start");
    return true;
  }

  /**
   * Generate the API based on the API definitions in the passed XML file.
   * 
   * @param fileClassDB_New
   *          XML file with the API classes.
   * @throws GeneratorException
   * @throws BException
   * @throws IOException
   */
  protected static void generateAPI(File fileClassDB_New) throws GeneratorException, BException, IOException {

    // -------------------------------------------------
    // Read current API definitions from the XML file.

    log.info("Read API definitions from ClassDB file ==============");
    log.info(fileClassDB_New.getAbsolutePath());
    ClassDB jdocClassDB = XmlClassDB.read(fileClassDB_New, true);
    log.info("");

    // --------------------------------------------------
    // Some checks before the generators run.

    log.info("Validate API definitions ==============");
    jdocClassDB.validate();
    log.info("");

    // generate C++
    if (propsCpp != null) {
      log.info("Generate Cpp code ==============");
      GeneratorCpp gen = new GeneratorCpp();
      gen.build(jdocClassDB, propsCpp);
      log.info("");
    }

    // generate Java
    if (propsJ != null) {
      log.info("Generate Java code ==============");
      GeneratorJ gen = new GeneratorJ();
      gen.build(jdocClassDB, propsJ);
      log.info("");
    }

    // generate C#
    if (propsCS != null) {
      log.info("Generate C# code ==============");
      GeneratorCS gen = new GeneratorCS();
      gen.build(jdocClassDB, propsCS);
      log.info("");
    }

    // generate JavaScript
    if (propsJS != null) {
      log.info("Generate JavaScript code ==============");
      GeneratorJS gen = new GeneratorJS();
      gen.build(jdocClassDB, propsJS);
      log.info("");
    }
  }

  /**
   * Entry point for generator.
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    
    
    
    configureLog4j("WARN");

    // DEBUG
    if (args == null || args.length == 0) {
      args = bypstest_ser;
    }

    // -------------------------------------------------------------
    // Default properties fro code generators.

    GeneratorProperties defaultProps = new GeneratorProperties();
    defaultProps.put(PropertiesCS.UPPER_CASE_FIRST_LETTER, "true");

    try {

      // Params passed to javadoc tool
      List<String> javadocParams = new ArrayList<String>();
      
      // Javadoc packages from optional command line option --packages
      Collection<String> javadocPacks = null;
      
      // Javadoc packages found in the source directories.
      // This packages are used, if --packages is not defined.
      Collection<String> javadocPacksInSourceDirs = null;

      for (int argIdx = 0; argIdx < args.length;) {

        // logging
        String arg = args[argIdx];
        if (arg.startsWith("-verbose")) {
          configureLog4j("INFO");
          argIdx++;
        }
        else if (arg.startsWith("-debug")) {
          configureLog4j("DEBUG");
          argIdx++;
        }

        // C++ generator option?
        else if (arg.startsWith(PropertiesCpp.OPT_PREFIX)) {
          if (propsCpp == null) propsCpp = new PropertiesCpp(defaultProps);
          argIdx = propsCpp.addArgs(args, argIdx);
        }

        // Java generator option?
        else if (arg.startsWith(PropertiesJ.OPT_PREFIX)) {
          if (propsJ == null) propsJ = new PropertiesJ(defaultProps);
          argIdx = propsJ.addArgs(args, argIdx);
        }

        // C# generator option?
        else if (arg.startsWith(PropertiesCS.OPT_PREFIX)) {
          if (propsCS == null) propsCS = new PropertiesCS(defaultProps);
          argIdx = propsCS.addArgs(args, argIdx);
        }

        // JavaScript generator option?
        else if (arg.startsWith(PropertiesJS.OPT_PREFIX)) {
          if (propsJS == null) propsJS = new PropertiesJS(defaultProps);
          argIdx = propsJS.addArgs(args, argIdx);
        }

        // reserved
        else if (arg.equals(GeneratorProperties.CHANGED_MEMBERS)) {
          defaultProps.put(GeneratorProperties.CHANGED_MEMBERS, "true");
          argIdx++;
        }

        // Assume all classes are to be serialized.
        else if (arg.equalsIgnoreCase("-allserials")) {
          convertOptions |= BConvert.OPT_ALL_SERIALS;
          argIdx++;
        }

        // If this option is set, subs and skeletons for remote procedure calls
        // are generated for all interfaces.
        else if (arg.equalsIgnoreCase("-allremotes")) {
          convertOptions |= BConvert.OPT_ALL_REMOTES;
          argIdx++;
        }
        
        // Only generate remote procedure calls for interfaces tagged with @BRemote
        else if (arg.equalsIgnoreCase("-onlyBRemotes")) {
          convertOptions |= BConvert.OPT_ONLY_BREMOTES;
          argIdx++;
        }
        
        // Only generate serialization code for classes tagged with @BSerializable
        else if (arg.equalsIgnoreCase("-onlyBSerials")) {
          convertOptions |= BConvert.OPT_ONLY_BSERIALS;
          argIdx++;
        }
        
        // Options starting with -- are passed to the javadoc tool.
        else if (arg.startsWith("--")) {
          boolean isSourcePath = arg.startsWith("--sourcepath");
          boolean isClassPath = arg.startsWith("--classpath");
          boolean isPackages = arg.startsWith("--packages");
          int idx = 0;

          if (isClassPath) {
          }
          else if (isSourcePath) javadocParams.add(idx++, "-sourcepath");
          else if (isPackages) {
          }
          else
            javadocParams.add(idx++, arg.substring(1));

          argIdx++;
          for (; argIdx < args.length; argIdx++) {
            arg = args[argIdx];
            if (arg.startsWith("-")) break;

            if (isPackages) {
              javadocPacks = Arrays.asList(arg.split(File.pathSeparator));
            }
            else if (isSourcePath) {

              javadocParams.add(idx++, arg);

              javadocPacksInSourceDirs = new HashSet<String>();

              sourceDirs = arg.split(File.pathSeparator);
              for (int i = 0; i < sourceDirs.length; i++) {
                File dir = new File(sourceDirs[i]);
                if (!dir.exists()) {
                  throw new IOException("sourcepath=" + dir.getAbsolutePath() + " does not exist");
                }
                findPackages(javadocPacksInSourceDirs, dir, "");
              }
            }
            else if (isClassPath) {

              classpath = System.getProperty("java.class.path");
              String[] elms = arg.split(File.pathSeparator);
              for (int i = 0; i < elms.length; i++) {
                File file = new File(elms[i]);
                if (!file.exists()) {
                  throw new IOException("classpath=" + file.getAbsolutePath() + " does not exist");
                }
                classpath += File.pathSeparator + file.getAbsolutePath();
              }
            }
            else {
              javadocParams.add(idx++, arg);
            }
          }
        }
        else {
          argIdx++;
        }
      }

      // Set the temporary directory. There is currently no program option for this.
      if (tempDir == null) {
        tempDir = System.getProperty("java.io.tmpdir");
        File dir = new File(tempDir);
        if (!dir.exists()) {
          if (!dir.mkdirs()) {
            ErrorInfo errInfo = new ErrorInfo();
            errInfo.msg = "Invalid temporary directory=\"" + dir + "\".";
            throw new GeneratorException(errInfo);
          }
        }
        
        // Create a sub-directory under the temporary directory for the compiler output.
        dir = new File(dir, "byps-gen");
        if (dir.exists()) {
          Utils.purgeDir(dir, null);
        }
        else if (!dir.mkdirs()) {
          ErrorInfo errInfo = new ErrorInfo();
          errInfo.msg = "Invalid temporary directory=\"" + dir + "\".";
          throw new GeneratorException(errInfo);
        }
        
        tempDir = dir.getAbsolutePath();
      }

      // -------------------------------------------------------------------
      // Ensure that serializable classes have a unique serialVersionUID (type ID).
      
      log.info("Ensure having serialVersionUIDs ==============");
      log.info("source dirs=" + Arrays.toString(sourceDirs));
      new AssignUniqueSerialVersionUID(sourceDirs, true).processFiles();
      
      // --------------------------------------------------------------------
      // Compile source and provide access to read constant values.

      log.info("Compile source files ==============");
      log.info("source dirs=" + Arrays.toString(sourceDirs) + ", classpath=" + classpath);
      compileSource = new CompileSource(tempDir, sourceDirs, classpath);
      
      
      // ---------------------------------------------------------------------
      // Call the javadoc tool.

      javadocParams.add(0, "-private");
      javadocParams.add(1, "-doclet");
      javadocParams.add(2, BDoclet.class.getName());

      if (!javadocParams.contains("-sourcepath")) {
        ErrorInfo errInfo = new ErrorInfo();
        errInfo.msg = "Missing argument --sourcepath.";
        throw new GeneratorException(errInfo);
      }

      if (classpath != null && classpath.length() != 0) {
        javadocParams.add("-classpath");
        javadocParams.add(classpath);
      }

      // String jhome = System.getProperty("java.home");
      // javadocParams.add("-bootclasspath");
      // javadocParams.add(jhome + "\\lib\\rt.jar;"+classpath);

      javadocParams.addAll(javadocPacks != null ? javadocPacks : javadocPacksInSourceDirs);

      String[] javadocArgs = javadocParams.toArray(new String[javadocParams.size()]);

      log.info("Generate serialisation layer ==============");
      //com.sun.tools.javadoc.Main.execute(javadocArgs);
      doJavaDoc(javadocArgs);

      System.out.println("Finished");
      
    } catch (Exception e) {
      if (exitCode == 0) exitCode = 1;
      e.printStackTrace();
    }

    if (exitCode != 0) {
      System.exit(exitCode);
    }
  }
  
  private static void doJavaDoc(String[] javadocArgs) {
    ServiceLoader<DocumentationTool> toolService = ServiceLoader.load(DocumentationTool.class);
    
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

  private static void configureLog4j(String level) {
    Properties props = new Properties();

    props.put("log4j.rootLogger", level + ", stdout");
    props.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
    props.put("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
    props.put("log4j.appender.stdout.layout.ConversionPattern", "%d{ABSOLUTE} %t %1x %-5p (%F:%L) - %m%n");
//
    
//    props.put("log4j.rootLogger", "debug, FI");
//    props.put("log4j.appender.FI", "org.apache.log4j.DailyRollingFileAppender");
//    props.put("log4j.appender.FI.File", "D:/temp/log/bypsgen.log");
//    props.put("log4j.appender.FI.DatePattern", "'.'yyyy-MM-dd'.txt'");
//    props.put("log4j.appender.FI.layout", "org.apache.log4j.PatternLayout");
//    props.put("log4j.appender.FI.layout.ConversionPattern", "%d{ABSOLUTE} %1x %-5p (%F:%L) - %m%n");
//    props.put("log4j.appender.FI.append", "true");
    
    PropertyConfigurator.configure(props);
  }

  // /////////////////////////////////////////////////////////////
  // DEBUG
  //

  @SuppressWarnings("unused")
  private static String[] bypstest_ser = new String[] {

  "-genj.dir-ser", "../bypstest-ser/src-ser", "-genj.dir-ser-bin", "../bypstest-ser/src-ser-bin", "-genj.dir-ser-json", "../bypstest-ser-json/src",
  "-genj.dir-test", "../bypstest-ser/src-test",

  "-gencs.dir-ser", "../../csharp/bypstest-ser/src-ser", "-gencs.upfirst", "true",

  "-genjs.dest", "../bypstest-srv/WebContent/testser.js",

  "-gencpp.dir-api", "../../cpp/common/bypstest/bypstest-gen/api", "-gencpp.dir-impl", "../../cpp/common/bypstest/bypstest-gen/impl",
  "-gencs.dot-net-version", "4.5",

      // "-genc.pack.alias", "byps.sample1=IX",
      "-gencpp.max-fsize", "50000",

      // "-verbose",

      // "--packages",
      // "byps.test.api",
      // "byps.test.api.prim",
      // "byps.test.api.arr",
      // "byps.test.api.list",
      // "byps.test.api.map",
      // "byps.test.api.set",
      // "byps.test.api.inherit",
      // "byps.test.api.priv",
      // "byps.test.api.cons",
      // "byps.test.api.remote",
      // "byps.test.api.refs",
      // "byps.test.api.enu",
      // "byps.test.api.inl",
      // "byps.test.api.strm",
      // "byps.test.api.srvr",
      // "byps.test.api.ver",

      "--sourcepath", "../bypstest-api/src",

  // "-gen.changedmembers",
  };

  private static String[] byps_ix_serAll = new String[] {

      //"-genj.dir-ser", "d:\\java\\workspace_git\\Eloix-byps\\src",

      // "-genj.dir-ser-bin", "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-bin",
      // "-genj.dir-ser-json",
      // "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-json",
      //
      // "-gencs.dir-ser", "D:\\dev\\BYPS2\\csharp\\byps\\byps_ix_ser\\src-ser",
      // "-gencs.upfirst", "false",
      //

      "-gencpp.dir-api", "d:\\git\\ELOixclientcpp\\src-ser\\api", "-gencpp.dir-impl", "d:\\git\\ELOixclientcpp\\src-ser\\impl", "-gencpp.max-fsize", "50000",

      //"-genjs.dest", "d:\\git\\ELOindexserver\\EloixWar\\json-api\\ixbyps.js", "-genjs.suppressConstClasses",

      "-allserials", "-onlyBRemotes", "-gen.changedmembers",

      // "-verbose",

      "-ensureUIDs",

      "--packages", "de.elo.ix.client;de.elo.ix.client.feed;de.elo.ix.client.compatibility;de.elo.ix.client.notify",

      "--sourcepath", "d:\\git\\ELOindexserver\\Eloix-api\\src;d:\\git\\ELOindexserver\\Eloix-api\\src-gen",

      "--classpath", "d:\\java\\lib\\EloixClient\\EloixClient.jar;d:\\java\\lib\\EloixClient\\javautils.jar" };

  private static String[] byps_ix_ser_eventbus = new String[] {

  "-genj.dir-ser", "d:\\java\\workspace_git\\Eloix-byps\\src",

      // "-genj.dir-ser-bin", "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-bin",
      // "-genj.dir-ser-json",
      // "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-json",
      //
      // "-gencs.dir-ser", "D:\\dev\\BYPS2\\csharp\\byps\\byps_ix_ser\\src-ser",
      // "-gencs.upfirst", "false",
      //
      // "-gencpp.dir-api",
      // "d:\\dev\\BYPS2\\cpp-msvc\\byps\\bypstest\\byps_ix_ser\\api",
      // "-gencpp.dir-impl",
      // "d:\\dev\\BYPS2\\cpp-msvc\\byps\\bypstest\\byps_ix_ser\\impl",
      // //"-genc.pack.alias", "byps.sample1=IX",
      // "-gencpp.max-fsize", "50000",

      //"-genjs.dest", "d:\\git\\ELOindexserver\\EloixWar\\json-api\\ixbyps.js",

      // "-verbose",

      "-ensureUIDs", "-onlyBRemotes", "-allserials",

      "--packages", "de.elo.ix.client",

      "--sourcepath", "d:\\git\\ELOindexserver\\Eloix-api\\src-eventbus;d:\\git\\ELOindexserver\\Eloix-api\\src;d:\\git\\ELOindexserver\\Eloix-api\\src-gen",

      "--classpath", "d:\\java\\lib\\EloixClient\\EloixClient.jar;d:\\java\\lib\\EloixClient\\javautils.jar" };

}
