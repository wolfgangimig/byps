package byps.gen.j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BRegistry;
import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.Utils;

public class GenTestCompatibleApi {

  static Log log = LogFactory.getLog(GenTestCompatibleApi.class);

  public static void generate(PrintContext pctxt,
      Collection<SerialInfo> serials, Collection<RemoteInfo> remotes)
      throws IOException {
    CodePrinter pr = pctxt.getPrinterForTestClass();
    if (pr != null) {
      new GenTestCompatibleApi(pctxt, pr, serials, remotes).generate();
      pr.close();
    }
  }

  private GenTestCompatibleApi(PrintContext pctxt, CodePrinter pr, Collection<SerialInfo> serials, Collection<RemoteInfo> remotes) {
    this.pctxt = pctxt;
    this.pr = pr;
    this.serials = serials;
    this.remotes = remotes;
  }

  private void generate() {
    pr.print("package ").print(pctxt.apiPack).print(";").println();
    pr.println();

    pctxt.printDoNotModify(pr, getClass());

    pr.println("import byps.*;");
    pr.println("import java.util.*;");
    pr.println("import org.apache.commons.logging.*;");
    pr.println();

    String className = pctxt.getTestClassName();

    pr.println("@SuppressWarnings(\"all\")");
    pr.print("public class ").print(className).println(" {");
    pr.println();
    
    pr.beginBlock();

    pr.print("private final static Log log = LogFactory.getLog(\"").print(className).println(".class\");");
    pr.println();
    
    generatePublicTestMethod();
    pr.println();

    for (RemoteInfo rinfo : remotes) {
      generateTestRemoteImpl(rinfo);
      pr.println();
    }

    pr.println("public static void addRemotes(BServer server) {");
    pr.beginBlock();
    for (RemoteInfo rinfo : remotes) {
      rinfo = rinfo.getRemoteNoAuth();
      generateRemoteImpl(rinfo);
      pr.println();
    }
    pr.endBlock();
    pr.println("}");


    pr.println();

    pr.endBlock();

    pr.println("}");

  }

  private void generatePublicTestMethod() {
    pr.println("public static void test(BClient bclient) throws Exception {");
    pr.beginBlock();

    pr.println("BProtocol protocol = bclient.getTransport().getProtocol();");
    //pr.println("boolean isBinaryProtocol = (protocol instanceof BProtocolS);");
    pr.println("long negotiatedVersion = protocol.negotiatedVersion;");
    
    pr.println("log.info(\"test(\");");
    for (RemoteInfo rinfo : remotes) {
      generateCallTestMethods(rinfo);
    }
    
    pr.println("log.info(\")test\");");
    pr.endBlock();
    pr.println("}");
  }
  
  private void generateCallTestMethods(RemoteInfo rinfo) {
    pr.print("// ").print(rinfo.toString()).println();
    pr.print("if (negotiatedVersion >= ").print(rinfo.since).println("L) {");
    pr.beginBlock();
    printGetRemote(rinfo);
    for (MethodInfo minfo : rinfo.methods){
      printCallTestMethod(rinfo, minfo);
    }
    pr.endBlock();
    pr.println("}");
    pr.println();
  }

  private void printCallTestMethod(RemoteInfo rinfo, MethodInfo minfo) {
    boolean exceptionExpected = false;
    String testFunctionName = getTestFunctionName(rinfo,minfo);

    // Tried to verify that incompatible API changes causes exceptions. 
    // But cancelled it because some changes do not result in serialization errors, e.g. int to String.
    // Thus, exceptionExpected is always false.
    
    pr.print("if (negotiatedVersion >= ").print(minfo.since).println("L) {");
    pr.beginBlock();
    
    if (exceptionExpected) {
      pr.println("if (isBinaryProtocol) {");
      pr.beginBlock();
      pr.println("try {");
      pr.beginBlock();
    }
    pr.print(testFunctionName).println("(remote);");
    if (exceptionExpected) {
      pr.println("throw new IllegalStateException(\"Exception expected.\");");
      pr.endBlock();
      pr.println("}");
      pr.println("catch(ClassCastException ex) {");
      pr.beginBlock();
      pr.println("log.info(\"OK: \", ex);");
      pr.endBlock();
      pr.println("}");
      pr.println("catch(RemoteException ex) {");
      pr.beginBlock();
      pr.println("log.info(\"OK: \", ex);");
      pr.endBlock();
      pr.println("}");
      pr.endBlock();
      pr.println("}");
    }
    
    pr.endBlock();
    pr.println("}");
  }

  private void generateTestRemoteImpl(RemoteInfo rinfo) {
    for (MethodInfo minfo : rinfo.methods){
      printTestMethod(rinfo, minfo);
      pr.println();
    }
  }
  
  private String getTestFunctionName(RemoteInfo rinfo, MethodInfo minfo) {
    return "internalTest_" + rinfo.qname.replace('.', '_') + "_" + minfo.name;
  }
  
  private void printGetRemote(RemoteInfo rinfo) {
    String stubName = pctxt.getStubClassQName(rinfo, pctxt.apiPack);
    pr.print(stubName).print(" remote = (").print(stubName).print(")")
      .print("bclient.getClass().getDeclaredMethod(\"get").print(Utils.firstCharToUpper(rinfo.name)).println("\").invoke(bclient);");
  }

  private void printTestMethod(RemoteInfo rinfo, MethodInfo minfo) {
    String stubName = pctxt.getStubClassQName(rinfo, pctxt.apiPack);
    String testFunctionName = getTestFunctionName(rinfo,minfo);
    pr.print("public static void ").print(testFunctionName).print("(")
      .print(stubName).println(" remote) throws RemoteException {");
    
    pr.beginBlock();

    pr.print("log.info(\"").print(testFunctionName).println("()\");");

    ArrayList<String> varNames = new ArrayList<String>();
    for (MemberInfo pinfo : minfo.requestInfo.members) {
      if (pctxt.isSessionParam(rinfo, pinfo)) continue;
      String varName = generateValue(pinfo.type);
      varNames.add(varName);
    }
    
    CodePrinter mrp = pr.print("remote.").print(minfo.name).print("(");
    boolean first = true;
    for (String varName : varNames) {
      if (first) first = false; else mrp.print(", ");
      mrp.print(varName);
    }
    mrp.println(");");

    
    pr.endBlock();
    pr.println("}");
  }

  private void generateRemoteImpl(RemoteInfo rinfo) {
    pr.print("server.addRemote(").print(rinfo.typeId).print(", new ").print(pctxt.getSkeletonClassQName(rinfo, pctxt.apiPack)).println("() {");
    pr.beginBlock();
    for (MethodInfo minfo : rinfo.methods){
      printMethod(rinfo, minfo);
    }
    pr.endBlock();
    pr.println("});");
  }
  
  private void printMethod(RemoteInfo rinfo, MethodInfo methodInfo) {
    
    pr.println("@Override");
    pctxt.printDeclareMethod(pr, rinfo, methodInfo, pctxt.apiPack).println(" {");
    pr.beginBlock();

    pr.print("log.info(\"").print(rinfo.name).print(".").print(methodInfo.name).println("()\");");
    
    MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
    boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;

    if (!isReturnVoid) {
      generateReturnValue(returnInfo.type);
    }
    
    pr.endBlock();
    pr.println("}");
  }

  private void generateReturnValue(TypeInfo type) {
    String varName = generateValue(type);
    pr.print("return ").print(varName).println(";");
  }

  private String generateValue(TypeInfo type) {
    String varName = makeTempVariableName();
    if (type.qname.equals("java.lang.Object")) {
      pr.print(type.toString(pctxt.apiPack)).print(" ").print(varName).println(" = null;");
    }
    else if (type.isArrayType() || type.isPrimitiveType() || type.isEnum || type.isCollectionType() || type.isBuiltInType()) {
      //pr.checkpoint();
      MemberInfo minfo = new MemberInfo(varName, type);
      pr.print(type.toString(pctxt.apiPack));
      generateMember("", minfo, RECURSIVE);
    }
    else if (type instanceof SerialInfo) {
      //pr.checkpoint();
      varName = generateTestObject((SerialInfo)type);
    }
    else {
      pr.print(type.toString(pctxt.apiPack)).print(" ").print(varName).println(" = null;");
    }
    return varName;
  }

  private String generateTestObject(SerialInfo sinfo) {
    String varName = makeTempVariableName();
    pr.print(sinfo.qname).print(" ").print(varName).print(" = new ").print(sinfo.qname).println("();");
    
    for (MemberInfo minfo : sinfo.members) {
      if (minfo.isStatic || minfo.isFinal || minfo.isTransient) continue;
      generateMember(varName, minfo, RECURSIVE);
    }
    return varName;
  }
  
  private void generateObjectMember(String outerName, MemberInfo outerMinfo) {
    //pr.checkpoint();
    pr.println("{");
    pr.beginBlock();
    //pr.checkpoint();
    
    SerialInfo sinfo = (SerialInfo)outerMinfo.type;

    String varName = makeTempVariableName();
    pr.print(sinfo.qname).print(" ").print(varName).print(" = new ").print(sinfo.qname).println("();");
    
    for (MemberInfo minfo : sinfo.members) {
      if (minfo.isStatic || minfo.isFinal || minfo.isTransient) continue;
      generateMember(varName, minfo, NOT_RECURSIVE);
    }
    
    boolean isPrivate = outerMinfo.access != MemberAccess.PUBLIC;
    String s = pctxt.setterForMember(outerMinfo.name, isPrivate, varName);

    CodePrinter mpr = pr;
    if (!outerName.isEmpty()) mpr = mpr.print(outerName).print(".");
    mpr.print(s).println(";");

    pr.endBlock();
    pr.println("}");
  }
  
  private void generateMember(String varName, MemberInfo minfo, boolean recursive) {
    //pr.checkpoint();
    if (minfo.type.isArrayType()) {
      generateTestArray(varName, minfo);
    }
    else if (minfo.type.isPrimitiveType()) {
      generatePrimitiveMember(varName, minfo);
    }
    else if (minfo.type.isEnum){
      generateEnumMember(varName, minfo);
    }
    else if (minfo.type.isCollectionType()){
      generateCollectionMember(varName, minfo);
    }
    else if (minfo.type instanceof SerialInfo) {
      if (recursive) {
        generateObjectMember(varName, minfo);
      }
    }
  }
  
  private void generateCollectionMember(String varName, MemberInfo minfo) {
    ////pr.checkpoint();
    TypeInfo tinfo = minfo.type;
    String value = "";
    if (tinfo.qname.equals("java.util.List")) {
      value = "new ArrayList<" + tinfo.typeArgs.get(0).toString()  + ">()";
    }
    else if (tinfo.qname.equals("java.util.Set")) {
      value = "new HashSet<" + tinfo.typeArgs.get(0).toString()  + ">()";
    }
    else if (tinfo.qname.equals("java.util.Map")) {
      value = "new HashMap<" + tinfo.typeArgs.get(0).toString() + "," + tinfo.typeArgs.get(1).toString() + ">()";
    }
    else {
      value = "new " + tinfo.toString() + "()";
    }
    
    boolean isPrivate = minfo.access != MemberAccess.PUBLIC;
    String s = pctxt.setterForMember(minfo.name, isPrivate, value);
    
    CodePrinter mpr = pr;
    if (!varName.isEmpty()) mpr = mpr.print(varName).print(".");
    mpr.print(s).println(";");

  }

  private void generateEnumMember(String varName, MemberInfo minfo) {
    ////pr.checkpoint();
    boolean isPrivate = minfo.access != MemberAccess.PUBLIC;
    String value = minfo.type.toString() + ".values()[0]";
    String s = pctxt.setterForMember(minfo.name, isPrivate, value);

    CodePrinter mpr = pr;
    if (!varName.isEmpty()) mpr = mpr.print(varName).print(".");
    mpr.print(s).println(";");
  }

  private void generatePrimitiveMember(String varName, MemberInfo minfo) {
    ////pr.checkpoint();
    String qname = minfo.type.qname;
    String value = null; 
    if (qname.equals("boolean")) value = "true";
    if (qname.equals("java.lang.Boolean")) value = "Boolean.TRUE";
    if (qname.equals("byte")) value = "(byte)1";
    if (qname.equals("java.lang.Byte")) value = "(byte)1";
    if (qname.equals("char")) value = "'a'";
    if (qname.equals("java.lang.Character")) value = "'A'";
    if (qname.equals("short")) value = "(short)123";
    if (qname.equals("java.lang.Short")) value = "(short)1230";
    if (qname.equals("int")) value = "9876543";
    if (qname.equals("java.lang.Integer")) value = "98765430";
    if (qname.equals("long")) value = "987654321012345L";
    if (qname.equals("java.lang.Long")) value = "9876543210123450L";
    if (qname.equals("float")) value = "1.23f";
    if (qname.equals("java.lang.Float")) value = "0.123f";
    if (qname.equals("double")) value = "9.876";
    if (qname.equals("java.lang.Double")) value = "0.9876";
    if (qname.equals("java.lang.String")) value = "\"STRING\"";
    if (qname.equals("java.util.Date")) value = "new Date(System.currentTimeMillis())";
    if (value != null) {
      boolean isPrivate = minfo.access != MemberAccess.PUBLIC;
      String s = pctxt.setterForMember(minfo.name, isPrivate, value);

      CodePrinter mpr = pr;
      if (!varName.isEmpty()) mpr = mpr.print(varName).print(".");
      mpr.print(s).println(";");
    }
  }
  
  private void generateTestArray(String varName, MemberInfo minfo) {
    ////pr.checkpoint();
    TypeInfo tinfo = minfo.type;
    
    StringBuilder sbuf = new StringBuilder();
    int ndims = tinfo.dims.length() / 2;
    sbuf.append("new ").append(tinfo.toStringNoDims(pctxt.apiPack));
    for (int i = 0; i < ndims; i++) {
      sbuf.append("[0]");
    }
    
    String value = sbuf.toString();
    
    boolean isPrivate = minfo.access != MemberAccess.PUBLIC;
    String s = pctxt.setterForMember(minfo.name, isPrivate, value);
    
    CodePrinter mpr = pr;
    if (!varName.isEmpty()) mpr = mpr.print(varName).print(".");
    mpr.print(s).println(";");
  }

  private String makeTempVariableName() {
    return "obj" + (++tempVarCount);
  }
  
  private static int tempVarCount = 0;
  private final PrintContext pctxt;
  private final CodePrinter pr;
  Collection<SerialInfo> serials;
  Collection<RemoteInfo> remotes;
  private final static boolean RECURSIVE = true;
  private final static boolean NOT_RECURSIVE = false;
}
