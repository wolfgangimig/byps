package byps.gen.test;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.junit.Test;

import byps.gen.db.XmlClassDB;
import byps.gen.doclet.CompileSource;
import byps.gen.xml.XmlGenerator;
import byps.gen.xml.XmlGeneratorBase;

public class TestXmlGenerator {
  
  @Test
  public void runAnnoationProcessor() throws Exception {
     String source = "../bypstest-api/src";
     
     // --------------------------------------------------------------------
     // Compile source and provide access to read constant values.
     String tempDir = System.getProperty("java.io.tmpdir");
     String classpath = System.getProperty("java.class.path");
     String[] sourceDirs = new String[] { source };
     CompileSource compileSource = new CompileSource(tempDir, sourceDirs, classpath);

     
     int options = XmlGeneratorBase.OPT_ALL_REMOTES | XmlGeneratorBase.OPT_ALL_SERIALS;
     XmlGenerator xmlGenerator = new XmlGenerator(options, compileSource);

     Iterable<JavaFileObject> files = getSourceFiles(source);

     JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

     CompilationTask task = compiler.getTask(new PrintWriter(System.out), null, null, null, null, files);
     task.setProcessors(Arrays.asList(xmlGenerator));

     task.call();
     
     File file = new File("../bypstest-api/bapi_new.xml");
     XmlClassDB.write(file, xmlGenerator.getClassDB());
  }

  private Iterable<JavaFileObject> getSourceFiles(String p_path) throws Exception {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager files = compiler.getStandardFileManager(null, null, null);

    files.setLocation(StandardLocation.SOURCE_PATH, Arrays.asList(new File(p_path)));

    Set<Kind> fileKinds = Collections.singleton(Kind.SOURCE);
    return files.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);
  }

}
