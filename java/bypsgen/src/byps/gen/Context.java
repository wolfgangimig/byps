package byps.gen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;
import byps.gen.cpp.PropertiesCpp;
import byps.gen.cs.PropertiesCS;
import byps.gen.doclet.CompileSource;
import byps.gen.j.PropertiesJ;
import byps.gen.js.PropertiesJS;
import byps.gen.utils.AssignUniqueSerialVersionUID;
import byps.gen.utils.Utils;
import byps.gen.xml.XmlGeneratorBase;
import byps.log.LogConfigurator;

public class Context {
  
  private static Logger log = LoggerFactory.getLogger(Context.class);
  
  /**
   * API definition file with the new classes. The API classes found by this run
   * are written into this file.
   */
  private File fileClassDBNew = new File("bapi_new.xml");

  /**
   * API definition file with the reference classes.
   */
  private File fileClassDB = new File("bapi.xml");

  /**
   * Generator properties for C# code generator.
   */
  private PropertiesCS propsCS;

  /**
   * Generator properties for C++ code generator.
   */
  private PropertiesCpp propsCpp;

  /**
   * Generator properties for Java code generator.
   */
  private PropertiesJ propsJ;

  /**
   * Generator properties for JavaScript code generator.
   */
  private PropertiesJS propsJS;

  /**
   * Directories with the source files of the API.
   */
  private String[] sourceDirs;

  /**
   * Classpath for compiler and javadoc.
   */
  private String classpath = "";

  /**
   * Options to convert from javadoc objects to XML definition.
   */
  private int convertOptions = 0;

  /**
   * Temporary directory used to store the compiled classes.
   */
  private String tempDir;

  /**
   * Object that invokes the Java compiler.
   */
  private CompileSource compileSource;
  
  /**
   * Exit code of main function.
   * If generator fails, exitCode is set to a non zero value.
   */
  private int exitCode = 0;
  
  /**
   * Javadoc packages from optional command line option --packages.
   */
  private Collection<String> javadocPacks;
  
  /**
   * Javadoc packages found in the source directories.
   * This packages are used, if --packages is not defined.
   */
  private Collection<String> javadocPacksInSourceDirs;

  /**
   *  Params passed to javadoc tool
   */
  private List<String> javadocParams = new ArrayList<>();

  public void parseArgs(String[] args) throws IOException {
    
    // -------------------------------------------------------------
    // Default properties for code generators.

    GeneratorProperties defaultProps = new GeneratorProperties();
    defaultProps.put(PropertiesCS.UPPER_CASE_FIRST_LETTER, "true");

    int argIdx = 0;
    while (argIdx < args.length) {

      // logging
      String arg = args[argIdx];
      if (arg.startsWith("-verbose")) {
        LogConfigurator.initConsole("INFO");
        argIdx++;
      }
      else if (arg.startsWith("-debug")) {
        LogConfigurator.initConsole("DEBUG");
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
        convertOptions |= XmlGeneratorBase.OPT_ALL_SERIALS;
        argIdx++;
      }

      // If this option is set, subs and skeletons for remote procedure calls
      // are generated for all interfaces.
      else if (arg.equalsIgnoreCase("-allremotes")) {
        convertOptions |= XmlGeneratorBase.OPT_ALL_REMOTES;
        argIdx++;
      }
      
      // Only generate remote procedure calls for interfaces tagged with @BRemote
      else if (arg.equalsIgnoreCase("-onlyBRemotes")) {
        convertOptions |= XmlGeneratorBase.OPT_ONLY_BREMOTES;
        argIdx++;
      }
      
      // Only generate serialization code for classes tagged with @BSerializable
      else if (arg.equalsIgnoreCase("-onlyBSerials")) {
        convertOptions |= XmlGeneratorBase.OPT_ONLY_BSERIALS;
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

  public File getFileClassDBNew() {
    return fileClassDBNew;
  }

  public File getFileClassDB() {
    return fileClassDB.getAbsoluteFile();
  }

  public PropertiesCS getPropsCS() {
    return propsCS;
  }

  public PropertiesCpp getPropsCpp() {
    return propsCpp;
  }

  public PropertiesJ getPropsJ() {
    return propsJ;
  }

  public PropertiesJS getPropsJS() {
    return propsJS;
  }

  public String[] getSourceDirs() {
    return sourceDirs;
  }

  public String getClasspath() {
    return classpath;
  }

  public int getConvertOptions() {
    return convertOptions;
  }

  public String getTempDir() {
    return tempDir;
  }

  public CompileSource getCompileSource() {
    return compileSource;
  }

  public int getExitCode() {
    return exitCode;
  }

  public Collection<String> getJavadocPacks() {
    return javadocPacks != null ? javadocPacks : Collections.emptyList();
  }

  public Collection<String> getJavadocPacksInSourceDirs() {
    return javadocPacksInSourceDirs != null ? javadocPacksInSourceDirs : Collections.emptyList();
  }

  public List<String> getJavadocParams() {
    return javadocParams;
  }

  public void setExitCode(int exitCode) {
    this.exitCode = exitCode;
  }

  
}
