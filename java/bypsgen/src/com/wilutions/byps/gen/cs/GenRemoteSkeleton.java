package com.wilutions.byps.gen.cs;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.js.PrintHelper;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteSkeleton {
	
	static Log log = LogFactory.getLog(GenRemoteSkeleton.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
	  if (rinfo.isClientRemote) {
  		log.info("generate " + rinfo.qname);
  		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.SKELETON_PREFIX, true);
  		new GenRemoteSkeleton(pctxt, rinfo, pr).generate();
  		pr.close();
	  }
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteSkeleton(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) throws GeneratorException {
    RemoteInfo rinfoImpl = rinfo.getRemoteNoAuth();
		this.rinfo = rinfoImpl;
		this.pr = pr;
		this.className = pctxt.getSkeletonClassQName(rinfo, rinfo.pack);
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		CodePrinter mpr = pr.print("public virtual ");
		pctxt.printDeclareMethod(mpr, rinfo, methodInfo).println(" {");
		
		pr.beginBlock();
		pr.println("throw new BException(BExceptionC.UNSUPPORTED_METHOD, \"\");");
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pr.print("public virtual ");
		mpr = pctxt.printDeclareMethodAsync(mpr, rinfo, methodInfo);
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
			TypeInfo cstype = pctxt.toCSharp(returnInfo.type);
			String rtype = cstype.toString(rinfo.pack);
			mpr = pr.print(rtype).print(" ret = ");
		}
		
		String methodName = pctxt.makePublicMemberName(methodInfo.name);
		mpr = mpr.print(methodName + "(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			String mname = pctxt.makeValidMemberName(pinfo.name);
			mpr.print(mname);
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
		pr.println("} catch (Exception e) {");
		pr.beginBlock();
		String nullValue = PrintHelper.getDefaultValueForType(returnInfo.type);
		pr.println("asyncResult.setAsyncResult(" + nullValue + ", e);");
		pr.endBlock();
//		pr.println("} finally {");
//		pr.beginBlock();
//		pr.endBlock();
		pr.println("}");
		
		pr.endBlock();
		
		pr.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}
	
	private void printMethodBeginAsync(MethodInfo methodInfo) throws GeneratorException {
		CodePrinter mpr = pr.print("public ");
		mpr = pctxt.printDeclareMethodBeginAsync(mpr, rinfo, methodInfo);
		mpr.println(" {");
		pr.beginBlock();
		pr.println("throw new BException(BExceptionC.INTERNAL, \"\");");
		pr.endBlock();
		pr.println("}");
	}
	
	private void printMethodEndAsync(MethodInfo methodInfo) throws GeneratorException {
		CodePrinter mpr = pr.print("public ");
		mpr = pctxt.printDeclareMethodEndAsync(mpr, rinfo, methodInfo);
		mpr.println(" {");
		pr.beginBlock();
		pr.println("throw new BException(BExceptionC.INTERNAL, \"\");");
		pr.endBlock();
		pr.println("}");
		
	}

	private void printSerialVersionUID() {
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
		pr.println("public readonly static long serialVersionUID = " + rinfo.typeId + "L;");
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
	}
	
	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using com.wilutions.byps;");
		pr.println();
		pr.println("namespace " + rinfo.pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		pr.println("/// <summary>");
		pr.println("/// This class provides a skeleton implementation of the interface " + rinfo.name + ".");
		pr.println("/// </summary>");
		pr.println("/// <remark>");
		pr.println("/// Your interface implementation class has to be derived from this skeleton.");
		pr.println("/// Either provide an asynchronous or a synchronous function in your subclass.");
		pr.println("/// The framework calls only the asynchronous function.");
		pr.println("/// </remark>");

		pr.print("public class ").print(className)
			.print(" : BSkeleton, ").print(rinfo.name)
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
			printMethodBeginAsync(minfo);
			printMethodEndAsync(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");
		
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
	private final PrintContext pctxt;
	
}
