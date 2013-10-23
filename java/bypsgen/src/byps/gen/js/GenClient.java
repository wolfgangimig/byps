package byps.gen.js;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

   
public class GenClient {
	static Log log = LogFactory.getLog(GenClient.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		CodePrinter pr = pctxt.getPrinter();
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
		
		pr.print(pack).print(".createClient_").print(pctxt.classDB.getApiDescriptor().name).println(" = function(transportFactory) {");
		pr.beginBlock();
		pr.print("return new ").print(clientClassName).println("(transportFactory);");
		pr.endBlock();
		pr.println("};");
		pr.println();
		
		pr.print(clientClassName).println(" = function(transportFactory) { ");
		pr.println();
				
		pr.beginBlock();
		
		pr.println("this.transport = transportFactory.createClientTransport();");
		pr.println();
		
		printServerR();
		pr.println();
		
		printInitStubMembers();
		
		pr.endBlock();
		
		pr.println("};");
		
		pr.print(clientClassName).println(".prototype = new byps.BClient();");
		pr.println();

		log.debug(")generate");
	}

	private String getRemoteVariableName(RemoteInfo rinfo) {
		String varName = rinfo.name.substring(0,1).toLowerCase() + rinfo.name.substring(1);
		return varName;
	}

	private void printInitStubMembers() {
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			String stubClassName  = pctxt.getStubClassQName(rinfo, pack);
			String varName = getRemoteVariableName(rinfo);
			pr.print("this.").print(varName).print(" = new ").print(stubClassName).println("(this.transport);");
		}
	}
	
	private void printServerR() {
		String serverClassName = pctxt.getServerClassName();
		pr.println("this._serverR = transportFactory.createServerR(");
		pr.beginBlock();
		pr.print("new ").print(serverClassName).println("(transportFactory.createServerTransport())");
		pr.endBlock();
		pr.println(");");
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