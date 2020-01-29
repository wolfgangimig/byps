package byps.gen.doclet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.TypeInfo;
import byps.gen.db.ConstFieldReader;

public class CompileSource implements ConstFieldReader {
	
	private final URLClassLoader classLoader; 

	public CompileSource(String tempDir, String[] sourceDirs, String classpath) throws GeneratorException {
		
		
		File foutDir = new File(tempDir, "bin");
		foutDir.mkdirs();
		
		ArrayList<String> params = new ArrayList<String>();
		
		params.add("-g:none");
		
		if (classpath != null && classpath.length() != 0) {
			params.add("-classpath");
			params.add(classpath);
		}

		// Änderung für Java 10: kein bootclasspath übergeben.
		// Damit läuft BDoclet im Eclipse. Aber leider nicht mit dem bypstest-api/ant-build.xml.
		// Warum, werde ich später untersuchen. 
//		String jhome = System.getProperty("java.home");
//		params.add("-bootclasspath");
//		params.add(jhome + File.separator + "lib" + File.separator + "rt.jar");
				
		// BYPS-1: keine Vorgaben für Source-Code-Versionen.
		// Die erlaubten Werte ändern sich scheinbar mit jeder JDK-Version.
		
		params.add("-d");
		params.add(foutDir.getAbsolutePath());
		
		compile(params.toArray(new String[0]), sourceDirs);

		
		// -classpath erlaubt mir, zus. JARs einzubinden. so kann ich die IX-Klassen �bersetzen.
		// Wenn ich die Testklassen �bersetzen will, ist aber BRemote nicht mehr bekannt. Wie das?
		
		try {
			ArrayList<URL> urls = new ArrayList<URL>();
			urls.add(foutDir.toURI().toURL());
			for (String f : classpath.split(";")) {
				urls.add(new File(f).toURI().toURL());
			}
			classLoader = new URLClassLoader(urls.toArray(new URL[0]));
		} catch (MalformedURLException e) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "Initialize ClassLoader with directory=\"" + foutDir + "\" failed.";
			throw new GeneratorException(errInfo, e);
		}
	    
	}
	
	@Override
	public long getSerialVersionUID(TypeInfo typeInfo) throws GeneratorException {
		if (log.isDebugEnabled()) log.debug("readSerialVersionUID(" + typeInfo);
		Object valueObj = getValue(typeInfo, "serialVersionUID");
		long value = valueObj != null ? (Long)valueObj : 0;
		if (log.isDebugEnabled()) log.debug(")readSerialVersionUID=" + value);
		return value;
	}
	
	@Override
	public Object getValue(TypeInfo typeInfo, String fieldName) throws GeneratorException {
    if (log.isDebugEnabled()) log.debug("getValue(" + fieldName);
		Object value = null;
		try {
		    Class<?> c = classLoader.loadClass( typeInfo.qname );
        if (log.isDebugEnabled()) log.debug("loaded class " + c);
		    Field f = c.getDeclaredField(fieldName);
        if (log.isDebugEnabled()) log.debug("declared field " + f);
		    f.setAccessible(true);
		    value = f.get(null);
		}
		catch (ClassNotFoundException e) {
			log.debug("OK, " + e);
		}
		catch (NoSuchFieldException e) {
			log.debug("OK, " + e);
		}
		catch (Throwable e) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "Failed to read " + fieldName;
			throw new GeneratorException(errInfo, e);
		}
    if (log.isDebugEnabled()) log.debug(")getValue=" + value);
		return value;
	}

	public int compile(String[] opts, String[] sourceDirs) throws GeneratorException {
		if (log.isDebugEnabled()) log.debug("compile(opts=" + Arrays.toString(opts) + ", sourceDirs=" + Arrays.toString(sourceDirs));
		
		System.out.println("Read constants.");

		List<File> files = findSourceFiles(sourceDirs);
		if (log.isDebugEnabled()) log.debug("files=" + files);
		
		StringWriter sw = new StringWriter();
		PrintWriter pr = new PrintWriter(sw);
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
		  String classpath = System.getProperty("java.class.path");
		  boolean hasToolsJar = classpath.contains("tools.jar");
		  String msg = "Cannot find Java compiler ";
		  if (hasToolsJar) {
		    msg += "in classpath=" + classpath;
		  }
		  else {
		    msg += ", missing tools.jar in classpath=" + classpath;
		  }
		  throw new GeneratorException(msg);
		}
		
		int status = 1;
		try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null)) {
      Iterable<? extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(files);
      Boolean succ = compiler.getTask(pr, fileManager, null, Arrays.asList(opts), null, compilationUnits1).call();
      status = (succ != null && succ) ? 0 : 1;
		}
		catch (IOException e) {
		  ErrorInfo errorInfo = new ErrorInfo();
		  throw new GeneratorException(errorInfo, e);
		}
		
		String msg = sw.toString();
		if (status != 0) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "Compile failed. " + msg;
			throw new GeneratorException(errInfo);
		}
		else {
			log.info("Sources successfully compiled.");
			if (msg.length() != 0) log.info(msg);
		}
		
    if (log.isDebugEnabled()) log.debug(")compile=" + status);
		return status;
	}
	
	public List<File> findSourceFiles(String[] sourceDirs) {
		List<File> files = new ArrayList<File>();
		for (String dir : sourceDirs) {
			File fdir = new File(dir);
			findSourceFiles(files, fdir);
		}
		return files;
	}

	protected void findSourceFiles(List<File> files, File fdir) {
		for (File f : fdir.listFiles()) {
			if (f.isFile()) {
				if (f.getName().endsWith(".java")) {
					files.add(f);
				}
			}
			else {
				findSourceFiles(files, f);
			}
		}
	}
	
	private static Log log = LogFactory.getLog(CompileSource.class);
}
