package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;
import byps.BExceptionC;
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;

public class GeneratorJS implements Generator {
	
	Log log = LogFactory.getLog(GeneratorJS.class);

	public GeneratorJS() {
	}

	private void printSeparator(String line) throws IOException {
		
		CodePrinter pr = pctxt.getPrinter();
		pr.println();
		pr.println("/**");
		pr.println(" * ----------------------------------------------");
		pr.print(" * ").println(line);
		pr.println(" * ----------------------------------------------");
		pr.println("*/");
		pr.println();
		pr.close();
		
	}
	
	protected CustomControl createClassFactory(ClassDB classDB, GeneratorProperties props) {
	  return new CustomControl();
	}

	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		log.debug("build(");

		pctxt = new PrintContext(classDB, props);
		pctxt.destFile.delete();
		
		CustomControl fact = createClassFactory(classDB, props);

		GenApiDescriptor.generate(pctxt, classDB.getApiDescriptor());

		printSeparator("Client class");
		
		GenClient.generate(pctxt, classDB.getApiDescriptor());

		buildSerials(fact, classDB);
		
		buildRemotes(fact, classDB);

		printSeparator("Server class");
		
		GenServer.generate(pctxt, classDB.getApiDescriptor());
		
		printSeparator("Registry");
		
		GenRegistry.generate(pctxt, classDB.getSerials());
		
		compressJavaScript(pctxt.destFile);
		
		log.debug(")build");
	}
	
	private void buildSerials(CustomControl fact, ClassDB classDB) throws IOException {
		
		Collection<SerialInfo> serials = classDB.getSerials();

		printSeparator("API value classes");
		for (SerialInfo serInfo : serials) {
			GenApiClass.generate(fact, pctxt, serInfo);
		}
		
		printSeparator("API constant types");
		for (SerialInfo serInfo : serials) {
			GenConstClass.generate(fact, pctxt, serInfo);
		}

		printSeparator("API constants");
		for (SerialInfo serInfo : serials) {
			GenConstObject.generate(fact, pctxt, serInfo);
		}
  		
	}

	private void buildRemotes(CustomControl fact, ClassDB classDB) throws IOException {
		
		printSeparator("Skeleton classes");
		Collection<RemoteInfo> remotes = classDB.getRemotes();
		for (RemoteInfo rinfo : remotes) {
			GenRemoteSkeleton.generate(pctxt, rinfo);
		}
		
		printSeparator("Stub classes");
		for (RemoteInfo rinfo : remotes) {
			GenRemoteStub.generate(pctxt, rinfo);
		}
		
	}

	private void compressJavaScript(File fileApiJS) throws BException {

	  // Optional: compress JS file using yui-compressor 
	  // https://github.com/yui/yuicompressor/releases
	  
//		String fname = fileApiJS.getName();
//		int p = fname.lastIndexOf('.');
//		if (p >= 0) fname = fname.substring(0, p);
//
//		File fileApiJSmin = new File(fileApiJS.getParentFile(), fname + "-min.js");
//
//		String[] args = new String[] {
//				// "--nomunge",
//				"--preserve-semi", 
//				"--charset", 
//				"UTF-8", 
//				"--line-break", "1000", 
//				"-o", fileApiJSmin.getAbsolutePath(),
//				fileApiJS.getAbsolutePath() };
//
//		try {
//			com.yahoo.platform.yui.compressor.YUICompressor.main(args);
//		} catch (Exception e) {
//			throw new BException(BExceptionC.GENERATOR_EXCEPTION, "Cannot compress JS file", e);
//		}
//		
//		log.info("Created compressed JSON API file. Original file #bytes=" + fileApiJS.length() + ", compressed file #bytes=" + fileApiJSmin.length());
	}
	
	private PrintContext pctxt;
}
