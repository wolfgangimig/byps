package byps.gen.j;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

public class GenTestClass {

  static Log log = LogFactory.getLog(GenTestClass.class);

  public static void generate(PrintContext pctxt,
      Collection<SerialInfo> serials, Collection<RemoteInfo> remotes)
      throws IOException {
    CodePrinter pr = pctxt.getPrinterForTestClass();
    if (pr != null) {
      new GenTestClass(pctxt, pr, serials, remotes).generate();
      pr.close();
    }
  }

  private GenTestClass(PrintContext pctxt, CodePrinter pr, Collection<SerialInfo> serials, Collection<RemoteInfo> remotes) {
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
    pr.println();

    String className = pctxt.getTestClassName();

    pr.print("public class ").print(className).println("{");
    pr.println();

    pr.beginBlock();
    
    pr.println("public ArrayList<Object> objs = new ArrayList<Object>();");

    pr.print(className).println("() {");
    pr.beginBlock();
    
    for (SerialInfo sinfo : serials) {
      if (sinfo.isEnum || sinfo.isBuiltInType() || sinfo.isCollectionType() || sinfo.isArrayType()) continue;
      if (sinfo.name.startsWith("BStub_")) continue;
      generateTestObject(sinfo);
    }

    pr.endBlock();
    pr.println("}");

    pr.println();

    pr.endBlock();

    pr.println("}");

  }
  
  private void generateTestObject(SerialInfo sinfo) {
    pr.println("{");
    pr.beginBlock();

    String varName = makeTempVariableName();
    pr.print(sinfo.qname).print(" ").print(varName).print(" = new ").print(sinfo.qname).println("();");
    
    for (MemberInfo minfo : sinfo.members) {
      if (minfo.isStatic || minfo.isFinal || minfo.isTransient) continue;
      generateMember(varName, minfo, RECURSIVE);
    }
    
    pr.print("objs.add(").print(varName).println(");");

    pr.endBlock();
    pr.println("}");
  }
  
  private void generateObjectMember(String outerName, MemberInfo outerMinfo) {
    pr.println("{");
    pr.beginBlock();
    pr.checkpoint();
    
    SerialInfo sinfo = (SerialInfo)outerMinfo.type;

    String varName = makeTempVariableName();
    pr.print(sinfo.qname).print(" ").print(varName).print(" = new ").print(sinfo.qname).println("();");
    
    for (MemberInfo minfo : sinfo.members) {
      if (minfo.isStatic || minfo.isFinal || minfo.isTransient) continue;
      generateMember(varName, minfo, NOT_RECURSIVE);
    }
    
    boolean isPrivate = outerMinfo.access != MemberAccess.PUBLIC;
    String s = pctxt.setterForMember(outerMinfo.name, isPrivate, varName);
    pr.print(outerName).print(".").print(s).println(";");

    pr.endBlock();
    pr.println("}");
  }
  
  private void generateMember(String varName, MemberInfo minfo, boolean recursive) {
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
    //pr.checkpoint();
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
    pr.print(varName).print(".").print(s).println(";");
  }

  private void generateEnumMember(String varName, MemberInfo minfo) {
    //pr.checkpoint();
    boolean isPrivate = minfo.access != MemberAccess.PUBLIC;
    String value = minfo.type.toString() + ".values()[0]";
    String s = pctxt.setterForMember(minfo.name, isPrivate, value);
    pr.print(varName).print(".").print(s).println(";");
  }

  private void generatePrimitiveMember(String varName, MemberInfo minfo) {
    //pr.checkpoint();
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
      pr.print(varName).print(".").print(s).println(";");
    }
  }
  
  private void generateTestArray(String varName, MemberInfo minfo) {
    //pr.checkpoint();
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
    pr.print(varName).print(".").print(s).println(";");
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
