package byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.gen.api.GeneratorException;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

   
public class GenClient {
	static Log log = LogFactory.getLog(GenClient.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		CodePrinter pr = pctxt.getPrinterForClient();
		new GenClient(pctxt, apiDesc, pr).generate();
		pr.close();
		log.debug(")generate");
	}

	private GenClient(PrintContext pctxt, BApiDescriptor apiDesc, CodePrinter pr) {
		this.pctxt = pctxt;
		this.clientClassName = pctxt.getClientClassName();
		this.pack = pctxt.getApiDescriptorPackage();
		this.pr = pr;
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass());

		pr.println("import byps.*;");
		pr.println();
		
		pr.print("public class ").print(clientClassName).println(" extends BClient { ");
		pr.println();
		
		pr.beginBlock();
		
		printCreate(true);
		pr.println();
		
		printCreate(false);
		pr.println();
		
		printConstructorWithServerImpl();
		pr.println();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			printAddRemote(rinfo);
			pr.println();
		}
		
		printConstructorWithoutServerR();
		pr.println();
		
		printGetStub();
		pr.println();
		
		printDefineStubs();
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		log.debug(")generate");
	}

	private String getRemoteVariableName(RemoteInfo rinfo) {
		String varName = rinfo.name.substring(0,1).toLowerCase() + rinfo.name.substring(1);
		return varName;
	}

	private void printCreate(boolean withServerR) {
		
		CodePrinter mpr = pr.print("public static ").print(clientClassName);
		if (withServerR) {
			mpr.println(" createClient(BTransportFactory transportFactory) {");
		}
		else {
			mpr.println(" createClientR(BTransport transport) {");
		}

		pr.beginBlock();

		if (withServerR) {
			pr.print("return new ").print(clientClassName).println("(transportFactory);");
		}
		else {
			pr.print("return new ").print(clientClassName).println("(transport);");
		}

		pr.endBlock();
		pr.println("}");
	}


	private void printConstructorWithoutServerR() {
		pr.print("protected ").print(clientClassName).println("(BTransport transport) {");
		pr.beginBlock();
		pr.println("super(transport, null);");
		printInitStubMembers();
		pr.endBlock();
		pr.println("}");
	}
	
	private void printInitStubMembers() {
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			String stubClassName  = pctxt.getStubClassQName(rinfo, pack);
			String varName = getRemoteVariableName(rinfo);
			pr.print(varName).print(" = new ").print(stubClassName).println("(transport);");
		}
	}
	
	private void printConstructorWithServerImpl() {
		pr.print("protected ").print(clientClassName).println("(BTransportFactory transportFactory) {");
		pr.beginBlock();
	
		String serverClassName = pctxt.getServerClassName();
		pr.println("super(");
		pr.beginBlock();
		pr.println("transportFactory.createClientTransport(), ");
		pr.println("transportFactory.createServerR(");
		pr.beginBlock();
		pr.println(serverClassName + ".createServerR(transportFactory.createServerTransport())");

		pr.endBlock();
		pr.println(")");
		pr.endBlock();
		pr.println(");");
		
		printInitStubMembers();

		pr.endBlock();
		pr.println("}");
	}
	
	private void printAddRemote(RemoteInfo rinfo) {
		String typeName = pctxt.getSkeletonClassQName(rinfo, pack);
		pr.print("public ").print(clientClassName).print(" addRemote(").print(typeName).println(" remoteSkeleton) throws BException {");
		pr.beginBlock();
		pr.println("if (serverR == null) throw new BException(BExceptionC.NO_REVERSE_CONNECTIONS, \"No reverse connections.\");");
		pr.println("serverR.server.addRemote(" + rinfo.typeId + ", remoteSkeleton);");
		pr.println("return this;");
		pr.endBlock();
		pr.println("}");
	}

	private void printDefineStubs() throws GeneratorException {
		log.debug("printDefineStubs");
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			String varName = getRemoteVariableName(rinfo);
			
	    RemoteInfo baseRemote = rinfo.getRemoteAuth();
	    if (baseRemote == null) baseRemote = rinfo.getRemoteAsync();
			String remoteName = baseRemote.toString(pack);
			
			pr.print("public final ").print(remoteName).print(" ").print(varName).println(";");
		}
		log.debug(")printDefineStubs");
	}

	private void printGetStub() {
		pr.println("@Override");
		pr.println("public BRemote getStub(int remoteId) {");
		pr.beginBlock();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			String varName = getRemoteVariableName(rinfo);
			pr.println("if (remoteId == " + rinfo.typeId + ") return " + varName + ";");
		}
		
		pr.println("return null;");
		pr.endBlock();
		pr.println("}");
	}

	private CodePrinter pr;
	private String pack;
	private String clientClassName;
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