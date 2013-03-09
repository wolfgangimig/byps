package com.wilutions.byps.gen.doclet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.c.GeneratorC;
import com.wilutions.byps.gen.c.PropertiesC;
import com.wilutions.byps.gen.cpp.GeneratorCpp;
import com.wilutions.byps.gen.cpp.PropertiesCpp;
import com.wilutions.byps.gen.cs.GeneratorCS;
import com.wilutions.byps.gen.cs.PropertiesCS;
import com.wilutions.byps.gen.db.ClassDB;
import com.wilutions.byps.gen.db.CompatibleClassDB;
import com.wilutions.byps.gen.db.XmlClassDB;
import com.wilutions.byps.gen.j.GeneratorJ;
import com.wilutions.byps.gen.j.PropertiesJ;
import com.wilutions.byps.gen.js.GeneratorJS;
import com.wilutions.byps.gen.js.PropertiesJS;


/**
 * TODO verbiete Elementname _typeId
 * @author Wolfgang
 *
 */
public class BDoclet extends Doclet {
	
	private static File fileClassDB = new File("classdb.xml");
	private static File fileClassDB_P = new File("classdbP.xml");
	private static PropertiesC propsC;
	private static PropertiesCS propsCS;
	private static PropertiesCpp propsCpp;
	private static PropertiesJ propsJ;
	private static PropertiesJS propsJS;
	private static String[] sourceDirs = null;
	private static String classpath = ".";
	private static int convertOptions = 0;
	private static String tempDir;
	private static CompileSource compileSource;
	private static Log log = LogFactory.getLog(BDoclet.class);

	public static boolean start(RootDoc root) {
		log.debug("start(");
		try {
			
			ClassDB prevClassDB = null;
			if (fileClassDB_P != null) {
				log.info("Read previous API definitions from ClassDB file ==============");
				log.info(fileClassDB_P.getAbsolutePath());
				prevClassDB = XmlClassDB.read(fileClassDB_P, false);
				log.info("");
			}
			
			log.info("Analyze classes in source directories ==============");
			ClassDB jdocClassDB = BConvert.makeClassDB( 
					prevClassDB, root, 
					compileSource,
					convertOptions);
			log.info("");
			
			if (prevClassDB != null) {
				log.info("Check compatibility ==============");
				CompatibleClassDB compClassDB = new CompatibleClassDB(prevClassDB, jdocClassDB);
				if (!compClassDB.ensureCompatible()) {
					return false;
				}
				log.info("");
			}
			
			log.info("Write new API definitions into ClassDB file ==============");
			log.info(fileClassDB.getAbsolutePath());
			XmlClassDB.write(fileClassDB, jdocClassDB);
			log.info("");
			
			log.info("Read API definitions from ClassDB file ==============");
			log.info(fileClassDB.getAbsolutePath());
			jdocClassDB = XmlClassDB.read(fileClassDB, true);
			log.info("");
			
			log.info("Validate API definitions ==============");
			jdocClassDB.validate();
			log.info("");
			
			// generate
			if (propsC != null) {
				log.info("Generate C code ==============");
				propsC.dump(log);
				GeneratorC gen = new GeneratorC();
				gen.build(jdocClassDB, propsC);
				log.info("");
			}
			
			// generate
			if (propsCpp != null) {
				log.info("Generate Cpp code ==============");
				GeneratorCpp gen = new GeneratorCpp();
				gen.build(jdocClassDB, propsCpp);
				log.info("");
			}

			// generate
			if (propsJ != null) {
				log.info("Generate Java code ==============");
				GeneratorJ gen = new GeneratorJ();
				gen.build(jdocClassDB, propsJ);
				log.info("");
			}	
			
			// generate
			if (propsCS != null) {
				log.info("Generate C# code ==============");
				GeneratorCS gen = new GeneratorCS();
				gen.build(jdocClassDB, propsCS);
				log.info("");
			}			

			// generate
			if (propsJS != null) {
				log.info("Generate JavaScript code ==============");
				GeneratorJS gen = new GeneratorJS();
				gen.build(jdocClassDB, propsJS);
				log.info("");
			}			
			
		} catch (Exception e) {
			log.error("Failed", e);
			return false;
		}
	
		log.info("Success ==============");
		log.debug(")start");
		return true;
	}
	
	private static String[] bypsexample = new String[] {
		
		"-gencpp.dir-api", "d:\\dev\\BYPS2\\cpp-msvc\\byps\\byps-example\\Example-api",
		"-gencpp.dir-impl.c", "d:\\dev\\BYPS2\\cpp-msvc\\byps\\byps-example\\Example-impl",
		"-gencpp.dir-impl.h", "d:\\dev\\BYPS2\\cpp-msvc\\byps\\byps-example\\Example-impl",
		//"-genc.pack.alias", "com.wilutions.byps.sample1=IX",
		"-gencpp.max-fsize", "10000",

		"-genj.dir-api", "..\\bypsexample2\\src-api",
		"-genj.dir-ser", "..\\bypsexample2\\src-ser",
		"-genj.dir-ser-bin", "..\\bypsexample2\\src-ser-bin",
		"-genj.dir-ser-json", "..\\bypsexample2\\src-ser-json",
		
		"-verbose",
		
		"--packages",
		"com.wilutions.byps.example.api",
		"com.wilutions.byps.sample1and2",
		"com.wilutions.byps.example.api.list",
//		"com.wilutions.byps.example.api.set",
//		"com.wilutions.byps.example.api.map",
//		"com.wilutions.byps.sample1.sets",
//		"com.wilutions.byps.sample1.maps",
//		"com.wilutions.byps.sample2",
		
		"--sourcepath", 
		"../bypsexample/src;../bypsexample/src-prototype",
	};
	
	private static String[] bypstest_ser = new String[] {
		
		"-genj.dir-api", "..\\bypstest-ser\\src-api",
		"-genj.dir-ser", "..\\bypstest-ser\\src-ser",
		"-genj.dir-ser-bin", "..\\bypstest-ser\\src-ser-bin",
		"-genj.dir-ser-json", "..\\bypstest-ser-json\\src",

		"-gencs.dir-api",     "D:\\dev\\BYPS2\\csharp\\byps\\bypstest-ser\\src-api",
		"-gencs.dir-ser",     "D:\\dev\\BYPS2\\csharp\\byps\\bypstest-ser\\src-ser",
		"-gencs.dir-ser-bin", "D:\\dev\\BYPS2\\csharp\\byps\\bypstest-ser\\src-ser-bin",
		"-gencs.upfirst",     "true",
		
		"-genjs.dest", "..\\bypstest-srv\\WebContent\\testser.js",
		
		"-verbose",
		
		"--packages",
		"com.wilutions.byps.test.api",
		"com.wilutions.byps.test.api.prim",
		"com.wilutions.byps.test.api.arr",
		"com.wilutions.byps.test.api.list",
		"com.wilutions.byps.test.api.map",
		"com.wilutions.byps.test.api.set",
		"com.wilutions.byps.test.api.inherit",
		"com.wilutions.byps.test.api.priv",
		"com.wilutions.byps.test.api.cons",
		"com.wilutions.byps.test.api.remote",
		"com.wilutions.byps.test.api.refs",
		"com.wilutions.byps.test.api.enu",
		"com.wilutions.byps.test.api.inl",
		"com.wilutions.byps.test.api.strm",
		"com.wilutions.byps.test.api.srvr",
		"com.wilutions.byps.test.api.ver",
		
		"--sourcepath", 
		"../bypstest-api/src",
	};
	
	private static String[] byps_ix_ser = new String[] {
		
		"-genj.dir-api", "..\\byps-ix-ser\\src-api",
		"-genj.dir-ser", "..\\byps-ix-ser\\src-ser",
		"-genj.dir-ser-bin", "..\\byps-ix-ser\\src-ser-bin",
		"-genj.dir-ser-json", "..\\byps-ix-ser\\src-ser-json",

		"-gencs.dir-api",     "D:\\dev\\BYPS2\\csharp\\byps\\byps-ix-ser\\src-api",
		"-gencs.dir-ser",     "D:\\dev\\BYPS2\\csharp\\byps\\byps-ix-ser\\src-ser",
		"-gencs.dir-ser-bin", "D:\\dev\\BYPS2\\csharp\\byps\\byps-ix-ser\\src-ser-bin",
		"-gencs.upfirst",     "true",
		
		"-allserials",
		"-allremotes",
		
		"-verbose",
		
		"--packages",
		"de.elo.ix.client",
		
		"--sourcepath", 
		"d:\\java\\workspace\\Eloix-api\\src;d:\\java\\workspace\\Eloix-api\\src-gen",
		
		"--classpath",
		"d:\\java\\lib\\EloixClient\\EloixClient.jar;d:\\java\\lib\\EloixClient\\javautils.jar"
	};
	

	
	public static void main(String[] args) {

		if (args == null || args.length == 0) {
			args = bypstest_ser;
		}
		
		try {
			List<String> javadocParams = new ArrayList<String>();
			
			for (int argIdx = 0; argIdx < args.length; ) {
				
				String arg = args[argIdx];
				if (arg.startsWith(PropertiesC.OPT_PREFIX)) {
					if (propsC == null) propsC = new PropertiesC(); 
					argIdx = propsC.addArgs(args, argIdx);
				}
				else if (arg.startsWith(PropertiesCpp.OPT_PREFIX)) {
					if (propsCpp == null) propsCpp = new PropertiesCpp();
					argIdx = propsCpp.addArgs(args, argIdx);
				}
				else if (arg.startsWith(PropertiesJ.OPT_PREFIX)) {
					if (propsJ == null) propsJ = new PropertiesJ();
					argIdx = propsJ.addArgs(args, argIdx);
				}
				else if (arg.startsWith(PropertiesCS.OPT_PREFIX)) {
					if (propsCS == null) propsCS = new PropertiesCS();
					argIdx = propsCS.addArgs(args, argIdx);
				}
				else if (arg.startsWith(PropertiesJS.OPT_PREFIX)) {
					if (propsJS == null) propsJS = new PropertiesJS();
					argIdx = propsJS.addArgs(args, argIdx);
				}
				else if (arg.equals("-allserials")) {
					convertOptions |= BConvert.OPT_ALL_CLASSES_ARE_SERIALS;
					argIdx++;
				}
				else if (arg.equals("-allremotes")) {
					convertOptions |= BConvert.OPT_ALL_INTERFACES_ARE_REMOTES;
					argIdx++;
				}
				else if (arg.equals("--packages")) {
					argIdx++;
					for (; argIdx < args.length; argIdx++) {
						arg = args[argIdx];
						if (arg.startsWith("-")) break; 
						javadocParams.add(arg);
					}
				}
				else if (arg.startsWith("--")) {
					boolean isSourcePath = arg.startsWith("--sourcepath");
					boolean isClassPath = arg.startsWith("--classpath");
					int idx = 0;
					javadocParams.add(idx++, arg.substring(1));
					argIdx++;
					for (; argIdx < args.length; argIdx++) {
						arg = args[argIdx];
						if (arg.startsWith("-")) break; 
						javadocParams.add(idx++, arg);
						if (isSourcePath) {
							sourceDirs = arg.split(";");
							for (int i = 0; i < sourceDirs.length; i++) {
								File dir = new File(sourceDirs[i]);
								if (!dir.exists()) {
									throw new IOException("sourcepath=" + dir.getAbsolutePath() + " does not exist");
								}
							}
						}
						else if (isClassPath) {
							classpath = ".";
							String[] elms = arg.split(";");
							for (int i = 0; i < elms.length; i++) {
								File dir = new File(elms[i]);
								if (!dir.exists()) {
									throw new IOException("classpath=" + dir.getAbsolutePath() + " does not exist");
								}
								classpath += ";" + dir.getAbsolutePath();
							}
						}
					}
				}
				else {
					argIdx++;
				}
			}
			
			if (tempDir == null) {
				tempDir = System.getProperty("java.io.tmpdir");
				File dir = new File(tempDir);
				if (!dir.exists()) {
					if (!dir.mkdirs()) {
						throw new GeneratorException("Invalid temporary directory=\"" + dir + "\".");
					}
				}
				dir = new File(dir, "byps-gen");
				if (!dir.exists()) {
					if (!dir.mkdirs()) {
						throw new GeneratorException("Invalid temporary directory=\"" + dir + "\".");
					}
				}
				tempDir = dir.getAbsolutePath();
			}
			
			
			log.info("Compile source files ==============");
			log.info(Arrays.toString(sourceDirs));
			compileSource = new CompileSource(tempDir, sourceDirs, classpath);

			
			javadocParams.add(0, "-private");
			javadocParams.add(1, "-doclet");
			javadocParams.add(2, BDoclet.class.getName());

			String[] javadocArgs = javadocParams.toArray(new String[javadocParams.size()]);
			
			com.sun.tools.javadoc.Main.execute(javadocArgs);  

			System.out.println("Finished");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}



   /**
    * NOTE: Without this method present and returning LanguageVersion.JAVA_1_5,
    *       Javadoc will not process generics because it assumes LanguageVersion.JAVA_1_1
    * @return language version (hard coded to LanguageVersion.JAVA_1_5)
    */
   public static LanguageVersion languageVersion() {
      return LanguageVersion.JAVA_1_5;
   }
}