package com.wilutions.byps.gen.doclet;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.tools.javac.Main;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.ConstFieldReader;

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
		
		String jhome = System.getProperty("java.home");
		params.add("-bootclasspath");
		params.add(jhome + "\\lib\\rt.jar");
		
		params.add("-source");
		params.add("1.5");
		
		params.add("-target");
		params.add("1.5");
		
		params.add("-d");
		params.add(foutDir.getAbsolutePath());
		
		compile(params.toArray(new String[0]), sourceDirs);

		
		// -classpath erlaubt mir, zus. JARs einzubinden. so kann ich die IX-Klassen übersetzen.
		// Wenn ich die Testklassen übersetzen will, ist aber BRemote nicht mehr bekannt. Wie das?
		
		try {
			ArrayList<URL> urls = new ArrayList<URL>();
			urls.add(foutDir.toURI().toURL());
			for (String f : classpath.split(";")) {
				urls.add(new File(f).toURI().toURL());
			}
			classLoader = new URLClassLoader(urls.toArray(new URL[0]));
		} catch (MalformedURLException e) {
			throw new GeneratorException("Initialize ClassLoader with directory=\"" + foutDir + "\" failed: " + e);
		}
	    
	}
	
	@Override
	public long getSerialVersionUID(TypeInfo typeInfo) throws GeneratorException {
		log.debug("readSerialVersionUID(" + typeInfo);
		Object valueObj = getValue(typeInfo, "serialVersionUID");
		long value = valueObj != null ? (Long)valueObj : 0;
		log.debug(")readSerialVersionUID=" + value);
		return value;
	}
	
	@Override
	public Object getValue(TypeInfo typeInfo, String fieldName) throws GeneratorException {
		Object value = null;
		try {
		    Class<?> c = classLoader.loadClass( typeInfo.qname );
		    Field f = c.getDeclaredField(fieldName);
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
			throw new GeneratorException("Failed to read serialVersionUID, " + e);
		}
		return value;
	}

	public int compile(String[] opts, String[] sourceDirs) throws GeneratorException {
		
		List<File> files = findSourceFiles(sourceDirs);
		
		List<String> params = new ArrayList<String>();
		for (String opt : opts) params.add(opt);
		for (File file : files) params.add(file.getAbsolutePath());
		
		StringWriter sw = new StringWriter();
		PrintWriter pr = new PrintWriter(sw);
		
		int status = Main.compile(params.toArray(new String[0]), pr);
		
		String msg = sw.toString();
		if (status != 0) {
			if (msg.length() != 0) log.error(msg);
			throw new GeneratorException("Compile failed.");
		}
		else {
			log.info("Sources successfully compiled.");
			if (msg.length() != 0) log.info(msg);
		}
		
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
