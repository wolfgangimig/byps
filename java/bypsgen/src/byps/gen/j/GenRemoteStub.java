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

class GenRemoteStub {

  static Log log = LogFactory.getLog(GenRemoteStub.class);

  static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
    // log.debug(GeneratorJ.class.getName(), "generate");
    log.info("generate " + rinfo.qname);
    
    CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.STUB_PREFIX, true);
    new GenRemoteStub(pctxt, rinfo, pr).generate();
    pr.close();
    // log.debug(GeneratorJ.class.getName(), "generate");
  }

  private GenRemoteStub(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) throws GeneratorException {

    RemoteInfo rinfoImpl = rinfo.getRemoteAuth();
    if (rinfoImpl == null) rinfoImpl = rinfo.getRemoteAsync();

    this.rinfo = rinfo;
    this.pr = pr;
    this.className = pctxt.getStubClassQName(rinfo, rinfo.pack);
    this.forwardClassName = pctxt.getForwardClassQName(rinfo, rinfo.pack);
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
      if (pctxt.isSessionParam(rinfo, pinfo)) {
        mpr.print("null");
      }
      else {
        mpr.print(pinfo.name);
      }
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

  private void printSerialVersionUID() {
    // log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
    pr.checkpoint();
    pr.println("public static final long serialVersionUID = " + rinfo.typeId + "L;");
    // log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
  }

  private void generate() throws IOException {
    // log.debug(GeneratorJ.class.getName(), "generate");

    pr.print("package ").print(rinfo.pack).print(";").println();
    pr.println();

    pctxt.printDoNotModify(pr, getClass());

    pr.println("import byps.*;");
    pr.println();

    RemoteInfo baseRemote = rinfo.getRemoteAuth();
    if (baseRemote == null) baseRemote = rinfo.getRemoteAsync();

    pr.checkpoint();
    pr.print("public class ").print(className);
    pr.print(" extends BStub implements ").print(baseRemote.name).print(", java.io.Serializable {");
    pr.println();

    pr.beginBlock();

    pr.println();
    printSerialVersionUID();
    printForwardTo(pctxt);
    pr.println();

    pr.println();
    pr.print("@SuppressWarnings(\"unused\") private ").print(className).print("() {").println();
    pr.beginBlock();
    pr.print("this.forwardTo = new ").print(forwardClassName).println("();");
    pr.endBlock();
    pr.println("}");
    pr.println();

    pr.print("public ").print(className).print("(final BTransport transport) {").println();
    pr.beginBlock();
    pr.println("super(transport);");
    pr.print("this.forwardTo = new ").print(forwardClassName).println("(transport);");
    pr.println();
    pr.endBlock();
    pr.println("}");
    pr.println();

    HashMap<String, RemoteInfo> remotes = new HashMap<String, RemoteInfo>();
    pctxt.collectAllRemotesForStubOrSkeleton(rinfo, remotes);
    for (RemoteInfo r : remotes.values()) {
      printMethods(r);
    }

    pr.println();

    pr.endBlock();

    pr.println("}");

    // log.debug(GeneratorJ.class.getName(), "generate");
  }

  private void printForwardTo(PrintContext pctxt) {
    pr.print("protected final ").print(forwardClassName).print(" forwardTo;");
  }

  private void printMethods(RemoteInfo rinfo) throws IOException {
    for (MethodInfo minfo : rinfo.methods) {
      printMethod(minfo, false);
      printMethod(minfo, true);
      pr.println();
    }
  }
  
  private final RemoteInfo rinfo;
  private final CodePrinter pr;
  private final String className;
  private final String forwardClassName;
  private final PrintContext pctxt;


}
