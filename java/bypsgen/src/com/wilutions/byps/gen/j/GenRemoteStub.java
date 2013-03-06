package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteStub {
	
	static Log log = LogFactory.getLog(GenRemoteStub.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.STUB_PREFIX, true);
		new GenRemoteStub(pctxt, rinfo, pr).generate();
		pr.close();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteStub(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		this.rinfo = rinfo;
		this.pr = pr;
		this.className = pctxt.getStubClassQName(rinfo, rinfo.pack);
		this.interfaceName = rinfo.name + PrintContext.INTERFACE_SUFFIX;
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pctxt.printDeclareMethod(pr, rinfo, methodInfo).println(" {");
		
		pr.beginBlock();
		
		String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfo.pack);
		String asyncResultType = "BSyncResult<" + rtype + ">";
		pr.print("final ").print(asyncResultType).print(" asyncResult = new ").print(asyncResultType).print("();");
		pr.println();

		CodePrinter mpr = pr.print("async_").print(methodInfo.name).print("(");
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.name);
		}
		if (!first) mpr.print(", ");
		mpr.print("asyncResult");
		mpr.println(");");

		boolean hasOwnExceptions = methodInfo.exceptions.size() != 0;
		if (hasOwnExceptions) {
			pr.println("try {");
			pr.beginBlock();
		}
		
		mpr = pr;
		if (!methodInfo.resultInfo.members.get(0).type.isVoidType()) {
			mpr = pr.print("return ");
		}
		mpr.print("asyncResult.getResult();");
		pr.println();

		if (hasOwnExceptions) {
			pr.endBlock();
			pr.println("} ");
			pr.println("catch (BException e) {");
			pr.beginBlock();
			pr.println("Throwable cause = e.getCause();");
			pr.println("if (cause != null) {");
			pr.beginBlock();
			for (TypeInfo exInfo : methodInfo.exceptions) {
				String exName = exInfo.toString(rinfo.pack);
				pr.print("if (cause instanceof ").print(exName).print(") throw (").print(exName).print(")cause;").println();
			}
			pr.endBlock();
			pr.println("}");
			pr.println("throw e;");
			pr.endBlock();
			pr.println("}");
		}
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pctxt.printDeclareMethodAsync(pr, rinfo, methodInfo);
		mpr.println("{");
		pr.beginBlock();
		
		String requestClass = methodInfo.requestInfo.toString(rinfo.pack);
		pr.print(requestClass).print(" req = new ").print(requestClass).print("();");
		pr.println();
		
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			pr.print("req.").print(pinfo.name).print(" = ").print(pinfo.name).print(";").println();
		}
		
		String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfo.pack);
		String outerAsyncClass = "BAsyncResultReceiveMethod<" + rtype + ">";
		pr.print(outerAsyncClass).print(" outerResult = new ").print(outerAsyncClass).print("(asyncResult);").println();
		
		pr.println("transport.send(req, outerResult);");

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

		pr.print("public class ").print(className)
		.print(" extends BStub implements " + interfaceName)
		.print(", java.io.Serializable {");
		pr.println();
		
		pr.beginBlock();
		
		pr.println();
		printSerialVersionUID();
		pr.println();
		
//		String apiDescClassName = pctxt.getApiDescriptorClassName();
//		String apiDescPack = pctxt.getApiDescriptorPackage();
//		String apiDescQName = apiDescPack + "." + apiDescClassName;
		
		pr.print("public ").print(className).print("(final BTransport transport) {").println();
		pr.beginBlock();
		pr.print("super(transport);");
		pr.println();
		pr.endBlock();
		pr.println("}");
		pr.println();

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

	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final String className;
	private final String interfaceName;
	private final PrintContext pctxt;
	
}
