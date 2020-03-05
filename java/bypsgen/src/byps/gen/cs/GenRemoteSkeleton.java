package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BRegistry;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.TypeInfo;
import byps.gen.js.PrintHelper;
import byps.gen.utils.CodePrinter;

class GenRemoteSkeleton {
	
	static Logger log = LoggerFactory.getLogger(GenRemoteSkeleton.class);
	
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
    RemoteInfo rinfoImpl = pctxt.getBaseRemoteForSkeleton(rinfo);
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
		if (pctxt.isAwaitSupported()) {
	    pr.println("throw new NotImplementedException();");
		}
		else {
	    pr.println("throw new BException(BExceptionC.UNSUPPORTED_METHOD, \"\");");
		}
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
  private void printMethodAsync(MethodInfo methodInfo) throws IOException {
    pctxt.printComments(pr, methodInfo.comments);
    
    CodePrinter mpr = pr.print("public virtual ");
    mpr = pctxt.printDeclareMethodAsync(mpr, rinfo, methodInfo);
    mpr.println("{");
    pr.beginBlock();
    
    String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfo.pack);

    pr.print("return BTaskConstants<").print(rtype).println(">.NotImplemented;");
    pr.endBlock();
    pr.println("}");
    
  }
  
	private void printMethodDelegate(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pr.print("public virtual ");
		if (pctxt.isAwaitSupported()) {
		  mpr.print("async ");
		}
		
		mpr = pctxt.printDeclareMethodDelegate(mpr, rinfo, methodInfo);
		mpr.println("{");
		pr.beginBlock();

    String methodName = pctxt.makePublicMemberName(methodInfo.name);

		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		
		String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfo.pack);
    pr.print(rtype).print(" __byps__ret = default(").print(rtype).println(");");
    
    pr.println("Exception __byps__ex = null;");
    
    if (pctxt.isAwaitSupported()) {
      pr.println("bool __byps__callAsync = false;");
    }
    
		pr.println("try {");
		pr.beginBlock();
		
		
    mpr = pr;
		if (!isReturnVoid) mpr = mpr.print("__byps__ret = ");
		mpr = mpr.print(methodName + "(");
		
		mpr = printPassParameters(methodInfo, mpr);
		mpr.println(");");
		
		pr.endBlock();
    pr.println("}");
		
		if (pctxt.isAwaitSupported()) {
		  pr.println("catch (NotImplementedException) { __byps__callAsync = true; }");
		}

		pr.println("catch (Exception e) { __byps__ex = e; }");
		
		if (pctxt.isAwaitSupported()) {
		  pr.println("if (__byps__callAsync) try {");
		  
		  pr.beginBlock();
		  
	    mpr = pr;
	    if (!isReturnVoid) mpr = mpr.print("__byps__ret = ");
	    mpr = mpr.print("await ").print(methodName).print("Async(");
	    
	    mpr = printPassParameters(methodInfo, mpr);
	    mpr.println(");");
	    
	    pr.endBlock();
	    
	    pr.println("}");
	    pr.println("catch (NotImplementedException) { __byps__ex = new BException(BExceptionC.UNSUPPORTED_METHOD, \"\"); }");

	    pr.println("catch (Exception e) { __byps__ex = e; }");
	    
		}
		
    pr.println("asyncResult(__byps__ret, __byps__ex);");

		pr.endBlock();
		
		pr.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

  protected CodePrinter printPassParameters(MethodInfo methodInfo, CodePrinter mpr) {
    boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			String mname = pctxt.makeValidParamName(pinfo.name);
			mpr = mpr.print(mname);
		}
		return mpr;
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
		
    if (pctxt.isAwaitSupported()) {
      pr.println("using System.Threading.Tasks;");
    }

		pr.println("using byps;");
		pr.println();
    pr.print("namespace ").println(pctxt.renamePackage(rinfo.pack));
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
		
    HashMap<String, RemoteInfo> remotes = new HashMap<String, RemoteInfo>();
    pctxt.collectAllRemotesForStubOrSkeleton(rinfo, remotes);
    for (RemoteInfo r : remotes.values()) {
      printMethods(r);
    }
    
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

  private void printMethods(RemoteInfo rinfoImpl) throws IOException {
    
    for (MethodInfo minfo : rinfoImpl.methods) {
      printMethod(minfo);
      printMethodDelegate(minfo);
      if (pctxt.isAwaitSupported()) {
        printMethodAsync(minfo);
      }
//      printMethodBeginAsync(minfo);
//      printMethodEndAsync(minfo);
      pr.println();
    }
    

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
