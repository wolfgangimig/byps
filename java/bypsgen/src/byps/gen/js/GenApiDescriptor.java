package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BBinaryModel;
import byps.BVersioning;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

   
public class GenApiDescriptor {
	static Log log = LogFactory.getLog(GenApiDescriptor.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate(");
		CodePrinter pr = pctxt.getPrinter();
		new GenApiDescriptor(pctxt, apiDesc, pr).generate();
		pr.close();
		log.debug(")generate");
	}

	private GenApiDescriptor(PrintContext pctxt, BApiDescriptor apiDesc, CodePrinter pr) {
		this.pctxt = pctxt;
		this.apiDesc = apiDesc;
		this.apiDescClassName = pctxt.getApiDescriptorClassName();
		this.pack = pctxt.getApiDescriptorPackage();
		this.pr = pr;
	}

	private static class PackNode {
		String name = "";
		HashMap<String, PackNode> children = new HashMap<String, PackNode>();
		public String toString() {
			StringBuilder sbuf = new StringBuilder();
			sbuf.append("{").append(name).append(",");
			sbuf.append("[");
			for (PackNode child : children.values()) {
				sbuf.append(child);
			}
			sbuf.append("]}");
			return sbuf.toString();
		}
	}
	
	private void addPackage(String pack, PackNode root) {
		int p = pack.indexOf(".");
		String n = p >= 0 ? pack.substring(0, p) : pack;
		
		while (n.length() != 0) {
			
			PackNode child = root.children.get(n);
			if (child == null) {
				child = new PackNode();
				child.name = n;
				root.children.put(n, child);
			}
			
			if (p < 0) break;
			
			pack = pack.substring(p+1);
			p = pack.indexOf(".");
			n = p >= 0 ? pack.substring(0, p) : pack;
			
			root = child;
		}
	}
	
	private void printPackage(String spack, PackNode root) {
		
		if (root.name.length() != 0) {
			boolean first = spack.length() == 0;  
			if (!first) spack += "."; 
			spack += root.name;
			if (first) pr.print("var ");
			pr.print(spack).print(" = ").print(spack).print(" || {};").println();
		} 
		
		for (PackNode child : root.children.values()) {
			printPackage(spack, child);
		}
		
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		pr.println("/**");
		pr.println(" * ----------------------------------------------");
		pr.println(" * Declare packages.");
		pr.println(" * ----------------------------------------------");
		pr.println("*/");
		
		PackNode root = new PackNode(); 
		for (SerialInfo serInfo : pctxt.classDB.getSerials()) {
			if (serInfo.isCollectionType()) continue;
			if (serInfo.typeId < pctxt.classDB.getRegistry().getMinTypeIdUser()) continue;
			if (serInfo.isArrayType()) continue;
			addPackage(serInfo.pack, root);
		}
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			addPackage(rinfo.pack, root);
		}

		printPackage("", root);
		
		pr.println();
		
		pr.println("/**");
		pr.println(" * ----------------------------------------------");
		pr.println(" * API Descriptor");
		pr.println(" * ----------------------------------------------");
		pr.println("*/");
		
		pr.print(apiDescClassName).print(" = {").println();
		pr.beginBlock();
		
		printStaticMembers();
		printInstance();
		
		pr.endBlock();
		pr.println("};");
		pr.println();
		
		log.debug(")generate");
	}
	
	private void printStaticMembers() {
		log.debug("printStaticMembers");
		
		pr.println("/**");
		pr.print(" * API serialisation version: ").print(BVersioning.longToString(apiDesc.version)).println();
		pr.println(" */");
		pr.print("VERSION : \"" + BVersioning.longToString(apiDesc.version)).println("\",");
		
		pr.println();

		log.debug(")printStaticMembers");
	}

	private void printInstance() {
		log.debug("printInstance");
		
		pr.println("/**");
		pr.println(" * Internal used API Desciptor.");
		pr.println("*/");
		
		pr.print("instance : function() {").println();
		pr.beginBlock();
		pr.println("return new byps.BApiDescriptor(");
		pr.beginBlock();
		pr.println("\"" + apiDesc.name + "\",");
		pr.println("\"" + apiDesc.basePackage + "\",");
		pr.print("\"" + BVersioning.longToString(apiDesc.version)).println("\",");
		pr.println(apiDesc.uniqueObjects + ", // uniqueObjects");
		pr.print("new ").print(pctxt.getRegistryClassName()).println("()");
		pr.endBlock();
		pr.println(");");
		pr.endBlock();
		pr.println("}");

		log.debug(")printInstance");
	}
	
//	private void printCreateRemotes() {
//		log.debug("printCreateRemotes");
//		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
//			printCreateRemote(rinfo);
//			pr.println();
//		}
//		log.debug(")printCreateRemotes");
//	}

//	private void printCreateRemote(RemoteInfo rinfo) {
//		log.debug("printCreateRemote");
//		pr.print("public static ").print(rinfo.toString(pack)).print(" create").print(rinfo.name)
//			.print("(BWire wire) {").println();
//		pr.beginBlock();
//		pr.println("final BTransport trans = new BTransport(instance, wire);");
//		
//		String stubClassName = pctxt.getStubClassQName(rinfo, pack);
//		pr.print("return new ").print(stubClassName).print("(trans);").println();
//		
//		pr.endBlock();
//		pr.println("}");
//		log.debug(")printCreateRemote");
//		
//	}
	
	private CodePrinter pr;
	private BApiDescriptor apiDesc;
	private String pack;
	private String apiDescClassName;
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