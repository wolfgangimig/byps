package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

   
public class GenServer {
	static Log log = LogFactory.getLog(GenServer.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		//log.debug(GenServer.class.getName(), "generate");
		CodePrinter pr = pctxt.getPrinterForServer();
		new GenServer(pctxt, apiDesc, pr).generate();
		pr.close();
		//log.debug(GenServer.class.getName(), "generate");
	}

	private GenServer(PrintContext pctxt, BApiDescriptor apiDesc, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serverClassName = pctxt.getServerClassName();
		this.pack = pctxt.getApiDescriptorPackage();
		this.pr = pr;
	}
	
	private void generate() throws IOException {
		//log.debug(GenServer.class.getName(), "generate");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass());

    pr.println("import byps.*;");
    pr.println("import java.util.Arrays;");
    pr.println("import java.util.Collections;");
    pr.println("import java.util.List;");
		pr.println();

		pr.println("@SuppressWarnings(\"all\")");
		
		pr.print("public class ").print(serverClassName).println(" extends BServer { ");
		pr.println();
		
		pr.beginBlock();
		
		printCreate(true);
		pr.println();
		
		printCreate(false);
		pr.println();
		
		printConstructor(false);
		pr.println();
		
		printConstructor(true);
		pr.println();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			printAddRemote(rinfo);
			pr.println();
		}
		
		printAllInterfaces();
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GenServer.class.getName(), "generate");
	}
	
	private void printConstructor(boolean withClientR) {
		
		CodePrinter mpr = pr.print("public ").print(serverClassName);
		if (withClientR) {
			mpr.println("(BTransportFactory transportFactory) {");
		}
		else {
			mpr.println("(BTransport transport) {");
		}

		pr.beginBlock();

		if (withClientR) {
			String clientClassName = pctxt.getClientClassName();
			pr.println("super(");
			pr.beginBlock();
			pr.println("transportFactory.createServerTransport(),");
			pr.println("transportFactory.createClientR(");
			pr.beginBlock();
			pr.println(clientClassName + ".createClientR(");
			pr.beginBlock();
			pr.println("transportFactory.createClientTransport()");
			pr.endBlock();
			pr.println(")");
			pr.endBlock();
			pr.println(")");
			pr.endBlock();
			pr.println(");");

		}
		else {
			pr.println("super(transport, null);");
		}
		
		pr.endBlock();
		pr.println("}");
	}
	
	private void printCreate(boolean withClientR) {
		
		CodePrinter mpr = pr.print("public static ").print(serverClassName);
		if (withClientR) {
			mpr.println(" createServer(BTransportFactory transportFactory) {");
		}
		else {
			mpr.println(" createServerR(BTransport transport) {");
		}

		pr.beginBlock();

		if (withClientR) {
			pr.print("return new ").print(serverClassName).println("(transportFactory);");
		}
		else {
			pr.print("return new ").print(serverClassName).println("(transport);");
		}

		pr.endBlock();
		pr.println("}");
	}

	protected void printAddRemote(RemoteInfo rinfo) {
		String typeName = pctxt.getSkeletonClassQName(rinfo, pack);
		pr.print("public ").print(serverClassName).print(" addRemote(").print(typeName).println(" remoteSkeleton) {");
		pr.beginBlock();
		pr.println("addRemote(" + rinfo.typeId + ", remoteSkeleton);");
		pr.println("return this;");
		pr.endBlock();
		pr.println("}");
	}
	
	/**
	 * Print a constant member that lists all BRemote interfaces.
	 */
	protected void printAllInterfaces() {
	  pr.println("/**");
	  pr.println(" * Readonly list of all API interfaces.");
	  pr.println(" */");
	  pr.println("public final static List<Class> allRemotes = Collections.unmodifiableList(Arrays.asList(new Class[] {");
	  pr.beginBlock();
	  for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
	    
	    pr.print(rinfo.qname).println(".class,");
      
	    RemoteInfo rinfoAsync = rinfo.getRemoteAsync();
      if (rinfoAsync != null) pr.print(rinfoAsync.qname).println(".class,");
      
      RemoteInfo rinfoAuth = rinfo.getRemoteAuth();
      if (rinfoAuth != null) pr.print(rinfoAuth.qname).println(".class,");
	  }
	  pr.println("String.class // This last entry simplifies the generator code.");
	  pr.println();
	  pr.endBlock();
	  pr.println("}));");
	}

	private CodePrinter pr;
	private String pack;
	private String serverClassName;
	private PrintContext pctxt; 
	
}


/*
public BSerializer getByClassName(Object obj) {
Class<?> clazz = obj.getClass();
if (clazz == Alpha.class) return byps.example.api.BSerializer_132.instance;
if (clazz == int[].class)return  

return null;
}
*/