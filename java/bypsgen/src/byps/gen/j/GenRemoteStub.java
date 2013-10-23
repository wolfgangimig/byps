package byps.gen.j;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.TypeInfo;
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

      // Skip authentication parameter
      if (pctxt.isSessionParam(rinfoImpl, pinfo)) continue;

      if (first) first = false;
      else
        mpr.print(", ");
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

      // Supply authentication parameter
      if (pctxt.isSessionParam(rinfoImpl, pinfo)) {
        // Session is set in BTransport by a call to BMethodRequest.setSession()
      }
      else {
        mpr = pr.print("req.").print(pinfo.name).print(" = ");
        mpr.print(pinfo.name).print(";").println();
      }
    }

    // String rtype = pctxt.getReturnTypeAsObjType(methodInfo, rinfoImpl.pack);
    // String outerAsyncClass = "BAsyncResultReceiveMethod<" + rtype + ">";
    // pr.print(outerAsyncClass).print(" outerResult = new ").print(outerAsyncClass).print("(asyncResult);").println();

    pr.println("transport.sendMethod(req, asyncResult);");

    pr.endBlock();

    pr.println("}");
    // log.debug(GeneratorJ.class.getName(), "printMethodAsync");
  }

  private void printSerialVersionUID() {
    // log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
    pr.checkpoint();
    pr.println("public final static long serialVersionUID = " + rinfo.typeId + "L;");
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
    pr.println();

    // String apiDescClassName = pctxt.getApiDescriptorClassName();
    // String apiDescPack = pctxt.getApiDescriptorPackage();
    // String apiDescQName = apiDescPack + "." + apiDescClassName;

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
