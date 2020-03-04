package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BRegistry;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteProxy {
	
	static Log log = LogFactory.getLog(GenRemoteProxy.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		log.info("generate " + rinfo.qname);
		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.PROXY_PREFIX, true);
		new GenRemoteProxy(pctxt, rinfo, pr).generate();
		pr.close();
	}
	
	private GenRemoteProxy(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) throws GeneratorException {
		this.rinfo = pctxt.getBaseRemoteForProxy(rinfo);
		this.pr = pr;
		this.className = pctxt.getProxyClassQName(rinfo, rinfo.pack);
		this.skeletonClassName = pctxt.getSkeletonClassQName(rinfo, rinfo.pack);
		this.forwardClassName = pctxt.getForwardClassQName(rinfo, rinfo.pack);
		this.interfaceName = rinfo.name;
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo, boolean isAsyncMethod) throws IOException {
		
    MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
    boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		CodePrinter mpr = null;
		
    if (isAsyncMethod) {
      mpr = pctxt.printDeclareMethodAsync(pr, rinfo, methodInfo);
    }
    else {
      mpr = pctxt.printDeclareMethod(pr, rinfo, methodInfo);      
    }
    
		mpr.println("{");
		mpr.beginBlock();
		
		mpr = mpr.print("  ");
		
		if (!isAsyncMethod && !isReturnVoid) {
		  mpr = mpr.print("return ");
		}
		
		mpr = mpr.print("forwardTo.").print(methodInfo.name).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.name);
		}

		if (isAsyncMethod) {
  		if (!first) mpr.print(", ");
  		mpr.print("asyncResult");
		}
		else {
		  
		}
		
		mpr.println(");");
		
		mpr.endBlock();
		pr.println("}");
	}

	private void generate() throws IOException {

		pr.print("package ").print(rinfo.pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass());
		
		pr.println("import byps.*;");
		pr.println();
		
		pr.println("/**");
		pr.println(" * This class provides a proxy implementation of the interface " + interfaceName + ".");
  	pr.println(" */");

		pr.println("@SuppressWarnings(\"all\")");
		pr.print("public class ").print(className)
			.print(" extends ").print(skeletonClassName)
			.print(" implements ").print(rinfo.name)
			.print(" {"); // implementiert nicht Serializable, sonst will Eclipse auch eine serialVersionUID der Implementierungsklasse.
		pr.println();

		pr.beginBlock();
		pr.println();
		
		printSerialVersionUID();
		pr.println();
		
		printForwardTo();
		pr.println();

		printConstructor();
		pr.println();
		
		printForwardConstructor();
    pr.println();
		
    HashMap<String, RemoteInfo> remotes = new HashMap<>();
    pctxt.collectAllRemotesForStubOrSkeleton(rinfo, remotes);
    for (RemoteInfo r : remotes.values()) {
      printMethods(r);
    }

		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

	}

  private void printSerialVersionUID() {
    pr.println("public static final long serialVersionUID = " + rinfo.typeId + "L;");
  }
  
  private void printForwardTo() {
    pr.print("protected final ").print(rinfo.qname).println(" forwardTo;");
  }

  private void printMethods(RemoteInfo rinfo) throws IOException {
    for (MethodInfo minfo : rinfo.methods) {
      printMethod(minfo, false);
      printMethod(minfo, true);
      pr.println();
    }
  }

  private void printConstructor() {
    pr.print("public ").print(className).print("(").print(rinfo.name).print(" forwardTo").print(") {").println();
    pr.beginBlock();
    pr.println("this.forwardTo = forwardTo;");
    pr.endBlock();
    pr.println("}");
  }

  private void printForwardConstructor() {
    pr.print("public ").print(className).print("(BTransport transport) {").println();
    pr.beginBlock();
    pr.print("this(new ").print(forwardClassName).println("(transport));");
    pr.endBlock();
    pr.println("}");
  }

	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final String className;
	private final String skeletonClassName;
	private final String forwardClassName;
	private final String interfaceName;
	private final PrintContext pctxt;
	
}
