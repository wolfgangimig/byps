package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteForward {

  static Logger log = LoggerFactory.getLogger(GenRemoteForward.class);

  static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
    // log.debug(GeneratorJ.class.getName(), "generate");
    log.info("generate " + rinfo.qname);
    
    if (rinfo.qname.contains("RemoteWithAuthentication")) {
      log.info("");
    }

    
    CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, PrintContext.FORWARD_PREFIX, true);
    new GenRemoteForward(pctxt, rinfo, pr).generate();
    pr.close();
    // log.debug(GeneratorJ.class.getName(), "generate");
  }

  private GenRemoteForward(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) throws GeneratorException {
    this.rinfo = pctxt.getBaseRemoteForForward(rinfo);
    this.pr = pr;
    this.className = pctxt.getForwardClassQName(rinfo, rinfo.pack);
    this.pctxt = pctxt;
  }

  private void printMethod(RemoteInfo rinfoImpl, MethodInfo methodInfo) throws IOException {
    // log.debug(GeneratorJ.class.getName(), "printMethod");

    pctxt.printDeclareMethod(pr, rinfoImpl, methodInfo).println(" {");

    pr.beginBlock();
    pr.checkpoint();

    String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfoImpl.pack);
    String asyncResultType = "BSyncResult<" + rtype + ">";
    pr.print("final ").print(asyncResultType).print(" asyncResult = new ").print(asyncResultType).print("();");
    pr.println();

    CodePrinter mpr = pr.print(methodInfo.name).print("(");
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
        String exName = exInfo.toString(rinfoImpl.pack);
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

    // log.debug(GeneratorJ.class.getName(), "printMethod");
  }

  private void printMethodAsync(RemoteInfo rinfoImpl, MethodInfo methodInfo) throws IOException {
    // log.debug(GeneratorJ.class.getName(), "printMethodAsync");

    CodePrinter mpr = pctxt.printDeclareMethodAsync(pr, rinfoImpl, methodInfo);
    mpr.println("{");
    pr.beginBlock();
    pr.checkpoint();

    String requestClass = methodInfo.requestInfo.toString(rinfoImpl.pack);
    pr.print(requestClass).print(" req = new ").print(requestClass).print("();");
    pr.println();

    for (MemberInfo pinfo : methodInfo.requestInfo.members) {
      mpr = pr.print("req.").print(pinfo.name).print(" = ");
      mpr.print(pinfo.name).print(";").println();
    }

    // String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfoImpl.pack);
    // String outerAsyncClass = "BAsyncResultReceiveMethod<" + rtype + ">";
    // pr.print(outerAsyncClass).print(" outerResult = new ").print(outerAsyncClass).print("(asyncResult);").println();

    pr.println("transport.sendMethod(req, asyncResult);");

    pr.endBlock();

    pr.println("}");
    // log.debug(GeneratorJ.class.getName(), "printMethodAsync");
  }

  private void generate() throws IOException {
    // log.debug(GeneratorJ.class.getName(), "generate");

    pr.print("package ").print(rinfo.pack).print(";").println();
    pr.println();

    pctxt.printDoNotModify(pr, getClass());

    pr.println("import byps.*;");
    pr.println();

    RemoteInfo baseRemote = rinfo;

    pr.checkpoint();
    pr.print("public class ").print(className);
    pr.print(" extends BStub implements ").print(baseRemote.name).print(" {");
    pr.println();

    pr.beginBlock();

    pr.println();
    pr.print("protected ").print(className).print("() {").println();
    pr.println("}");
    pr.println();

    pr.print("public ").print(className).print("(final BTransport transport) {").println();
    pr.beginBlock();
    pr.print("super(transport);");
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

  private void printMethods(RemoteInfo rinfo) throws IOException {
    
    RemoteInfo rinfoImpl = rinfo.getRemoteInfoAuthOrAsync();
    
    for (MethodInfo minfo : rinfo.methods) {
      printMethod(rinfoImpl, minfo);
      printMethodAsync(rinfoImpl, minfo);
      pr.println();
    }
  }
  
  private final RemoteInfo rinfo;
  private final CodePrinter pr;
  private final String className;
  private final PrintContext pctxt;


}
