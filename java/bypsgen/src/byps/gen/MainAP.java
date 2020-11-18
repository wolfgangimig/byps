package byps.gen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.gen.api.GeneratorException;
import byps.gen.db.ClassDB;
import byps.gen.db.ConstFieldReader;
import byps.gen.db.XmlClassDB;
import byps.gen.xml.XmlGenerator;

public class MainAP extends Main {
  
  private static Logger log = LoggerFactory.getLogger(MainAP.class);
  
  private Context context;
  
  public MainAP(Context context) {
    this.context = context;
  }
  
  public void run() throws IOException {
    
    // -----------------------------------------------
    // Read XML file with reference definition

    ClassDB prevClassDB = readReferenceClassDB(context);
    
    // --------------------------------------------------------------------
    // Compile source and provide access to read constant values.

    ConstFieldReader constFieldReader = buildConstFieldReader(context);
    
    // ------------------------------------------------
    // Convert javadoc objects to internal representation

    ClassDB newClassDB = processApiClasses(context, constFieldReader);
    
    // ------------------------------------------------
    // Write current definition into XML file

    File file = context.getFileClassDBNew();
    XmlClassDB.write(file, newClassDB);
    
    // ------------------------------------------------
    // Compare reference definition with current definition.
    // Is the current definition compatible?

    checkCompatibility(context, prevClassDB, newClassDB);
    
    // -------------------------------------------------
    // Generate the API.

    generateAPI(context);

  }

  private ClassDB processApiClasses(Context context, ConstFieldReader constFieldReader) throws IOException {

    System.out.println("Process API classes.");
    
    Path outDir = Paths.get(System.getProperty("java.io.tmpdir"), "byps-", new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format (new Date()));
    File foutDir= Files.createDirectories(outDir).toFile();

    int options = context.getConvertOptions(); // BYPS-22: take OPT_ values from argument list.
    XmlGenerator xmlGenerator = new XmlGenerator(options, constFieldReader);

    List<File> sourceDirs = Arrays.asList(context.getSourceDirs()).stream()
        .map(File::new).map(File::getAbsoluteFile).collect(Collectors.toList());

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null)) {
      
      fileManager.setLocation(StandardLocation.SOURCE_PATH, sourceDirs);

      // BYPS-31: Ausgabeverzeichnis angeben.
      fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(foutDir.getAbsoluteFile()));

      Set<Kind> fileKinds = Collections.singleton(Kind.SOURCE);
      Iterable<JavaFileObject> files = fileManager.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);

      CompilationTask task = compiler.getTask(new PrintWriter(System.out), null, null, null, null, files);
      task.setProcessors(Arrays.asList(xmlGenerator));

      task.call();

      // BYPS-31: class-Dateien löschen. Weiß nicht, warum die hier im source-Verzeichnis erstellt werden.
      Iterator<JavaFileObject> it = files.iterator();
      while (it.hasNext()) {
        File file = new File(it.next().toUri());
        String fpath = file.getAbsolutePath();
        int p = fpath.lastIndexOf('.');
        if (p >= 0) {
          String classFileName = fpath.substring(0, p) + ".class";
          File classFile = new File(classFileName);
          classFile.delete();
        }
      }
    }


    return xmlGenerator.getClassDB();
  }
  

}
