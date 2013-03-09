package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteSkeleton {
	
	static Log log = LogFactory.getLog(GenRemoteSkeleton.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.SKELETON_PREFIX, true);
		new GenRemoteSkeleton(pctxt, rinfo, pr).generate();
		pr.close();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteSkeleton(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		this.rinfo = rinfo;
		this.pr = pr;
		this.className = pctxt.getSkeletonClassQName(rinfo, rinfo.pack);
		this.interfaceName = rinfo.name + PrintContext.INTERFACE_SUFFIX;
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pr.println("@Override");
		pctxt.printDeclareMethod(pr, rinfo, methodInfo).println(" {");
		
		pr.beginBlock();
		pr.println("throw new BException(BException.UNSUPPORTED_METHOD, \"\");");	// Server does not call synchronous methods
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		pr.println("@Override");
		CodePrinter mpr = pctxt.printDeclareMethodAsync(pr, rinfo, methodInfo);
		mpr.println("{");
		pr.beginBlock();
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		
		pr.println("try {");
		pr.beginBlock();
		
		if (isReturnVoid) {
			mpr = pr;
		}
		else {
			String rtype = returnInfo.type.toString(rinfo.pack);
			mpr = pr.print(rtype).print(" ret = ");
		}
		mpr = mpr.print(methodInfo.name + "(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.name);
		}
		mpr.println(");");
		
		if (isReturnVoid) {
			pr.println("asyncResult.setAsyncResult(null, null);");
		} 
		else {
			pr.println("asyncResult.setAsyncResult(ret, null);");
		}
		
		pr.endBlock();
//		pr.println("} catch (RemoteException e) {");
//		pr.beginBlock();
//		pr.println("asyncResult.setException(e);");
//		pr.endBlock();
		pr.println("} catch (Throwable e) {");
		pr.beginBlock();
		pr.println("asyncResult.setAsyncResult(null, e);");
		pr.endBlock();
//		pr.println("} finally {");
//		pr.beginBlock();
//		pr.endBlock();
		pr.println("}");
		
		pr.endBlock();
		
		pr.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void printSerialVersionUID() {
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
		pr.println("public final static long serialVersionUID = " + rinfo.typeId + "L;");
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
	}
	
	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.print("package ").print(rinfo.pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr);
		
		pr.println("import com.wilutions.byps.*;");
		pr.println();
		
		pr.println("/**");
		pr.println(" * This class provides a skeleton implementation of the interface " + interfaceName + ".");
		pr.println(" * Your interface implementation class has to be derived from this skeleton.");
		pr.println(" * Either provide an asynchronous or a synchronous function in your subclass.");
		pr.println(" * The framework calls only the asynchronous function.");
		pr.println(" */");

		pr.println("@SuppressWarnings(\"all\")");
		pr.print("public class ").print(className)
			.print(" extends BSkeleton")
			.print(" implements " + interfaceName)
			.print(" {"); // implementiert nicht Serializable, sonst will Eclipse auch eine serialVersionUID der Implementierungsklasse.
		pr.println();

		pr.beginBlock();
		pr.println();
		
		printSerialVersionUID();
		pr.println();

//		printConstructor();
//		pr.println();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			printMethodAsync(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

//	private void printConstructor() {
//		pr.print("public ").print(className).print("(BTransport transport) {").println();
//		pr.beginBlock();
//		pr.println("super(transport);");
//		pr.endBlock();
//		pr.println("}");
//	}

	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final String className;
	private final String interfaceName;
	private final PrintContext pctxt;
	
}