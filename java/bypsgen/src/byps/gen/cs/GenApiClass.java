package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BDefaultValue;
import byps.BException;
import byps.BJsonObject;
import byps.BRegistry;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.js.PrintHelper;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.Utils;

class GenApiClass {
	
	static Logger log = LoggerFactory.getLogger(GenApiClass.class);
	
	static void generate(PrintContext pctxt, SerialInfo serInfo) throws IOException {
		log.debug("generate(" + serInfo);
		if (serInfo.isCollectionType()) {
			// No API class for List<>...
		}
		else if (serInfo.isArrayType()) {
			// No API class for int[]...
		}
		else if (serInfo.isStubType()) {
			// Stub API class is generated by GenRemoteStub
		}
		else if (serInfo.typeId < pctxt.classDB.getRegistry().getMinTypeIdUser()){
			// No API class for RemoteException ...
		}
		else  {
			log.info("Generate API class for type " + serInfo.typeId + ": " + serInfo);
			CodePrinter pr = pctxt.getPrinterForApiClass(serInfo, "",
					serInfo.isResultClass() || serInfo.isRequestClass());
			new GenApiClass(pctxt, serInfo, pr).generate();
			pr.close();
		}
		log.debug(")generate");
	}
	
	private GenApiClass(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serInfo = serInfo;
		this.pr = pr;
		this.methodInfo = serInfo.methodInfo;
	}
	
	private void printMember(MemberInfo minfo) throws IOException {
		log.debug("printMember");
		
		if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
			// Type void can be used by method return values 
		}
		else {
			// For final static members, we do not generate properties,
			// we make the field definition public. So the comment lines
			// are printed before the field definition.
			if (minfo.isStatic) {
				pctxt.printComments(pr, minfo.comments);
			}
			
			// Members are is usually declared with protected access.
			// But for sealed classes - which cannot have sub-classes and
			// thus protected does not make sense - members are declared private.
			String access = "protected ";
			if (serInfo.isInline) {
				access = "private ";
			}
			else if (serInfo.isRequestClass() || serInfo.isResultClass()){
				access = "internal ";
			}
			else if (minfo.isStatic) {
				access = "public ";
			}
			
			String finalKeyword = ""; 
			if (minfo.isFinal) {
			  if (minfo.type.isPointerType()) {
			    finalKeyword = "readonly static ";
			  }
			  else {
			    finalKeyword = "const ";
			  }
			}

			String newKeyword = "";
      if (serInfo.baseInfo != null && serInfo.baseInfo.findMember(minfo.name, null) != null) {
        newKeyword = "new ";
      }
      
      String memberName = "";
			if (minfo.isStatic) {
				memberName = pctxt.makePublicMemberName(minfo.name);
			}
			else {
				memberName = pctxt.makeDataMemberName(minfo.name);
			}
			
			String typeName = pctxt.toCSharp(minfo.type).toString(serInfo.pack);
			CodePrinter mpr = pr.print(access).print(newKeyword).print(finalKeyword).print(typeName).print(" ").print(memberName);
			
			String value = minfo.value;
			if (value != null) {
        
			  // Anführungszeichen entfernen - long-Werte werden hier als Strings geliefert.
			  if (value.startsWith("\"")) value = value.substring(1, value.length()-1);
			  
			  // BYPS-61: Konstantenwert ermitteln. Wenn es ein @BDefaultValue ist, kommt ein Leerstring zurück.
			  String constValue =  printConstValue(minfo.type, value);
			  			  
			  if (constValue != null && !constValue.isEmpty()) {
  				mpr.print(" = ");
  				mpr.print(constValue);
			  }
			}
			
			mpr.print(";");
			if (minfo.isTransient) mpr.print(" // transient");
			mpr.println();
			mpr.println();

		}		
		
		log.debug(")printMember");
	}
	
	private String printConstValue(TypeInfo tinfo, Object value) throws BException, GeneratorException {
		StringBuilder sbuf = new StringBuilder();
		
		if (tinfo.dims.length() != 0) {
			BJsonObject js = BJsonObject.fromString((String)value);
			sbuf.append(makeNewArrayInstance(tinfo, js));
		}
		else if (tinfo.qname.equals("java.lang.String")) {
			String s = (String)value;
			sbuf.append("\"");
			for (int i = 0; i < s.length(); i++) {
				sbuf.append( pctxt.printStringChar(s.charAt(i)) );
			}
			sbuf.append("\"");
		}
		else if (tinfo.qname.equals("char")) {
			String s = (String)value;
			sbuf.append("\'");
			sbuf.append( pctxt.printStringChar(s.charAt(0)) );
			sbuf.append("\'");
		}
		else if (tinfo.qname.equals("boolean")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("byte")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append("(byte)").append(value);
		}
		else if (tinfo.qname.equals("short")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append("(short)").append(value);
		}
		else if (tinfo.qname.equals("int")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("long")) {
			if (value instanceof Number) {
			  value = ((Number)value).longValue();
			}
			else if (value instanceof String) {
		     String svalue = (String)value;
		     if (svalue.endsWith(".")) svalue = svalue.substring(0, svalue.length()-1);
		     value = Long.parseLong(svalue);
			}
			sbuf.append(value).append("L");
		}
		else if (tinfo.qname.equals("double")) {
			sbuf.append(value);
		}
    else if (tinfo.qname.equals("float")) {
      sbuf.append(value).append("f");
    }
    else if (tinfo.isEnum) {
      // BYPS-57: Behandlung von Enum-Werten in Konstantenobjekten. 
      sbuf.append(tinfo.name).append(".").append(value);
    }
		else if (tinfo.isPointerType() && (value instanceof BJsonObject)) {
			sbuf.append(makeNewInstance(tinfo, (BJsonObject)value));
		}
		else if (value instanceof String && ((String)value).trim().startsWith("{")) {
			BJsonObject js = BJsonObject.fromString((String)value);
			sbuf.append(makeNewInstance(tinfo, js));
		}
		
		return sbuf.toString();
	}
	
	private String makeNewArrayInstance(TypeInfo tinfo, BJsonObject js) throws BException, GeneratorException {
		if (js == null) return "null";
		StringBuilder sbuf = new StringBuilder();
		String cstype = pctxt.toCSharp(tinfo).toString(serInfo.pack);
		sbuf.append("new ").append(cstype);
		sbuf.append(makeArrayLevel(tinfo, 1, js));
		return sbuf.toString();
	}
	
	private String makeArrayLevel(TypeInfo tinfo, int dim, BJsonObject js) throws BException, GeneratorException {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("{");
		for (int i = 0; i < js.size(); i++) {
			if (i != 0) sbuf.append(",");
			if (dim < tinfo.dims.length()/2) {
				BJsonObject jsElm = (BJsonObject)js.get(i);
				sbuf.append(makeArrayLevel(tinfo, dim+1, jsElm));
			}
			else {
				Object value = js.get(i);
				TypeInfo elmInfo = new TypeInfo(tinfo.name, tinfo.qname, "", null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
				sbuf.append(printConstValue(elmInfo, value));
			}
		}
		sbuf.append("}");
		return sbuf.toString();
	}

	private String makeNewInstance(TypeInfo tinfo, BJsonObject params) throws GeneratorException, BException {
		if (params == null) return "null";
		
		StringBuilder sbuf = new StringBuilder();
		
		// Lookup full SerialInfo of given tinfo
		SerialInfo sinfo = null;
		for (SerialInfo s : pctxt.classDB.getSerials()) {
			if (s.toString().equals(tinfo.toString())) {
				sinfo = s; break;
			}
		}
		if (sinfo == null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = tinfo.toString();
			errInfo.msg = "Internal error, typeId=" + tinfo.typeId + " not found in list of serials.";
			throw new GeneratorException(errInfo);
		}
		
		boolean first = true;
		sbuf.append("new ").append(sinfo.toString(serInfo.pack)).append("(");
		for (MemberInfo minfo : sinfo.members) {
		  Object value = params.get(minfo.name);
			if (minfo.isStatic) continue;
			if (!first) sbuf.append(", "); else first = false; 
			if (minfo.type.dims.length() != 0) {
				sbuf.append(makeNewArrayInstance(minfo.type, (BJsonObject)value));
			} else if (value instanceof BJsonObject) {
				sbuf.append(makeNewInstance(minfo.type, (BJsonObject)value));
      } else if (value == null) {
        sbuf.append("null");
			}
			else {
				sbuf.append(printConstValue(minfo.type, value));
			}
		}
		sbuf.append(")");
		
		return sbuf.toString();
	}
	
	private void printGetSet(MemberInfo minfo) throws IOException {
		
		if (minfo.isStatic) return; 
		
		log.debug("printGetSet");

		pctxt.printComments(pr, minfo.comments);
			
		String memberType = pctxt.toCSharp(minfo.type).toString(serInfo.pack);
		String memberName = pctxt.makeDataMemberName(minfo.name);
		
		if (!memberType.equals("void")) {
			CodePrinter mpr = pr.print("public ");
			if (minfo.isStatic) mpr.print("static ");
			mpr.print(memberType).print(" ")
			  .println(pctxt.getterForMember(minfo.name, true, minfo.type, true));
			pr.print("{").println();
			pr.beginBlock();
			pr.println("get");
			pr.println("{");
			pr.beginBlock();
			if (memberType.equals("java.lang.String")) {
				pr.print("if (").print(memberName).print(" == null) ")
					.print("_").print(minfo.name).print(" = \"\";")
					.println();
			}
			pr.print("return ").print(memberName).println(";");
			pr.endBlock();
			pr.println("}"); // end get
			
			if (!minfo.isFinal) {
				pr.println("set");
				pr.println("{");
				pr.beginBlock();
				pr.print("this.").print(memberName).println(" = value;");
				
				pctxt.printSetChangedMembers(pr, serInfo, minfo);
				
				if (serInfo.isResultClass()) {
					pr.println("if (resp != null) resp.ready(this);");
				}
				pr.endBlock();
				pr.println("}");   // end set
			}
			pr.endBlock();
			pr.println("}");  // end member
			pr.println();

		}
		else if (serInfo.isResultClass()) {
			pr.print("public void ")		  
			  .print("set").print(Utils.firstCharToUpper(minfo.name))
			  .println("()");
			pr.println("{");
			pr.beginBlock();
			pr.println("if (resp != null) resp.ready(this);");
			pr.endBlock();
			pr.println("}");
		}
		
		
		pr.println();

		log.debug(")printGetSet");
	}
	
	private void printConstructors() throws IOException {
		log.debug("printConstructors");
		
		pr.print("public ").print(serInfo.name).println("() {");
		pr.print("}");
		pr.println();
		pr.println();
		
		if (isValueClass()) {

			List<MemberInfo> constrMembers = new ArrayList<MemberInfo>();
			for (MemberInfo minfo : serInfo.members) {
				if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
				if (minfo.isStatic) continue;
				constrMembers.add(minfo);
			}
			
			if (constrMembers.size() != 0) {
			  
			  // Construtor with initializer list
			  
				CodePrinter mpr = pr.print("public ").print(serInfo.name).print("(");
				boolean first = true;
				for (MemberInfo minfo : constrMembers) {
					if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
					if (minfo.isStatic) continue;
					if (!first) mpr.print(", "); else first = false; 
			
					String typeName = pctxt.toCSharp(minfo.type).toString(serInfo.pack);
					  mpr.print(typeName).print(" @").print(minfo.name);
				}
				mpr.println(") {");
	
				pr.beginBlock();
				for (MemberInfo minfo : constrMembers) {
					if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
					if (minfo.isStatic) continue;
					String memberName = pctxt.makeDataMemberName(minfo.name);
					pr.print("this.").print(memberName).print(" = @").print(minfo.name).println(";");
				}
				pr.endBlock();
				
				pr.print("}");
        pr.println();
        pr.println();
      }
			
      // Copy-Construtor 
			{
        CodePrinter mpr = pr.print("public ").print(serInfo.name).print("(").print(serInfo.name).print(" rhs)");
        if (serInfo.baseInfo != null) {
          mpr.print(" : base(rhs)");
        }
        mpr.println();
        
        pr.println("{");
        pr.beginBlock();
        for (MemberInfo minfo : constrMembers) {
          if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
          if (minfo.isStatic) continue;
          String memberName = pctxt.makeDataMemberName(minfo.name);
          pr.print("this.").print(memberName).print(" = rhs.").print(memberName).println(";");
        }
        pr.endBlock();
        
        pr.print("}");
        pr.println();
			}			
		}
		
		log.debug(")printConstructors");
	}

	private boolean isValueClass() {
		return true;
	}

	private void printRemoteId() throws IOException {
		log.debug("printRemoteId");
		pr.print("public override int getRemoteId() { return ").print(methodInfo.remoteInfo.typeId).println("; }");
		log.debug(")printRemoteId");
	}
	
	private void printExecuteAsync() throws GeneratorException {
	  pr.checkpoint();
	  
		pr.println("try {");
		pr.beginBlock();
		
		String methodName = pctxt.makePublicMemberName(methodInfo.name);
		
		String remoteType = methodInfo.remoteInfo.toString(serInfo.pack);
		pr.print("").print(remoteType).print(" __byps__remoteT = (").print(remoteType).print(")__byps__remote;");
		pr.println();

		String rtype = pctxt.getReturnTypeAsObjType(methodInfo, serInfo.pack);
		String outerResultType = "BAsyncResultSendMethod<" + rtype + ">";
		
		String bresultClass = pctxt.renameClassPackage(methodInfo.resultInfo.toString(serInfo.pack));
		
		pr.print(outerResultType).print(" __byps__outerResult = new ").print(outerResultType)
			.print("(__byps__asyncResult, new ").print(bresultClass)
			.print("());");
		pr.println();
		
		CodePrinter mpr = pr.print("__byps__remoteT.").print(methodName).print("").print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
      String memberName = pctxt.makeDataMemberName(pinfo.name);
			mpr.print(memberName);
		}
		if (!first) mpr.print(", ");
		mpr.print("BAsyncResultHelper.ToDelegate(__byps__outerResult)");
		mpr.println(");");
		
		pr.endBlock();
		pr.println("} catch (Exception e) {");
		pr.beginBlock();
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		String nullValue = PrintHelper.getDefaultValueForType(returnInfo.type);
		pr.println("__byps__asyncResult.setAsyncResult(" + nullValue + ", e);");
		pr.endBlock();
		pr.println("}");
	}
	
	private void printExecute() throws IOException {
		log.debug("printExecute");

		pr.print("public override void ").print("execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) ").println("{");
		pr.beginBlock();
		
		printExecuteAsync();
		
		pr.endBlock();
		pr.print("}");
		pr.println();
		
		log.debug(")printExecute");
	}
	
  private void printSetSession() throws IOException {
    if (methodInfo == null) return;
  
    RemoteInfo rinfo = methodInfo.remoteInfo;
    for (MemberInfo pinfo : methodInfo.requestInfo.members) {
      
      // Supply authentication parameter
      if (pctxt.isSessionParam(rinfo, pinfo)) {
        pr.checkpoint();
        
        pr.println("public override void setSession(Object __byps__sess) {");
        pr.beginBlock();
        String memberName = pctxt.makeDataMemberName(pinfo.name);
        String authClassName = pctxt.renameClassPackage(rinfo.authParamClassName);
        pr.print(memberName).print(" = (").print(authClassName).println(")__byps__sess;");
        pr.endBlock();
        pr.println("}");
        pr.println();
        
        break;
      }
    }
     
  }
  	
	private void printHashCode() throws IOException {
		log.debug("printHashCode(");
		pr.println("public override int GetHashCode() {");
		pr.beginBlock();				
		
		if (serInfo.members.size() == 0) {
			pr.println("return 0;");
		}
		else {

			boolean moreThanOneMember = serInfo.members.size() > 1;
			
			// print temporary variables for double values
			int countDoubles = 0;
			for (MemberInfo minfo : serInfo.members) {
				if (!minfo.type.isArrayType() && minfo.type.name.equals("double")) {
					String varName = "temp" + (++countDoubles);
					pr.print("final long ").print(varName).print(" = Double.doubleToLongBits(").print(minfo.name).println(");");
				}
			}
			
			// compute hash
			
			// print line 31*(31*(31* ...
			CodePrinter mpr = pr.print("return ");
			for (int i = 0; i < serInfo.members.size()-1; i++) {
				mpr.print("31*(");
			}
			
			if (moreThanOneMember) pr.beginBlock();
			
			// print hash values for doubles - use the temporary variables created above
			for (int i = 0; i < countDoubles; i++) {
				if (i != 0) mpr.print(" )");
				if (moreThanOneMember) { 
					pr.println();   
					mpr = pr.print(i != 0 ? " + " : "   ");
				}
				String varName = "temp" + (i + 1);
				mpr.print("(int)(").print(varName).print(" ^ (").print(varName).print(" >>> 32))");
			}
	
			// print hash values for non-double members
			for (int i = 0; i < serInfo.members.size(); i++) {
				MemberInfo minfo = serInfo.members.get(i);
				if (minfo.type.isArrayType() || !minfo.type.name.equals("double")) {
					boolean notFirst = (countDoubles != 0 || i != 0);
					if (notFirst) mpr.print(" )");
					if (moreThanOneMember) { 
						pr.println();  
						mpr = pr.print(notFirst ? " + " : "   ");
					}
					printHashMember(mpr, minfo);
				}
			}
			mpr.println(";");
			
			if (moreThanOneMember) pr.endBlock();
		}
		
		pr.endBlock();
		pr.println("}");
		log.debug("printHashCode");
	}
	
	private void printHashMember(CodePrinter pr, MemberInfo minfo) {
		TypeInfo tinfo = minfo.type;
		if (tinfo.isArrayType()) {
			pr.print("java.util.Arrays.hashCode(").print(minfo.name).print(")");
		}
		else if (tinfo.isPointerType()) {
			pr.print("(").print(minfo.name).print("==null ? 0 : ").print(minfo.name).print(".hashCode())");
		}
		else if (tinfo.name.equals("boolean")) {
			pr.print("(").print(minfo.name).print(" ? 1231 : 1237)");
		}
		else if (tinfo.name.equals("byte") ||
				 tinfo.name.equals("char") ||
				 tinfo.name.equals("short") ||
				 tinfo.name.equals("int")) {
			pr.print(minfo.name);
		}
		else if (tinfo.name.equals("long")) {
			pr.print("(int)(").print(minfo.name).print(" ^ ").print("(").print(minfo.name).print(" >>> 32))");
		}
		else if (tinfo.name.equals("float")) {
			pr.print("Float.floatToIntBits(").print(minfo.name).print(")");
		}
		else if (tinfo.name.equals("void")) {
			// Type void can be used by methods
			pr.print("0");
		}
		else {
			throw new IllegalStateException("printHashMember called for unexpected type: " + minfo.type.toString());
		}
	}

	private void printEquals() throws IOException {
		log.debug("printEquals");

		pr.println("public override boolean Equals(Object obj) {");
		pr.beginBlock();
		pr.println("if (this==obj) return true;");
		pr.println("if (obj==null) return false;");
		pr.println("if (getClass() != obj.getClass()) return false;");
		
		if (serInfo.members.size() == 0) {
			pr.println("return true;");
		}
		else {

			pr.println();
			pr.print("final ").print(serInfo.name).print(" rhs = (").print(serInfo.name).print(")obj;").println();

			CodePrinter mpr = pr.print("return ");
			for (int i = 0; i < serInfo.members.size(); i++) {
				MemberInfo minfo = serInfo.members.get(i);
				if (i != 0) {
					mpr.println(" &&");
					mpr = pr.print("  ");
				}
				if (minfo.type.isArrayType()) {
					// Arrays.equals(arrayStruct2, other.arrayStruct2) &&
					if (minfo.type.dims.length() == 2) {
						mpr.print("java.util.Arrays.equals(").print(minfo.name).print(", rhs.").print(minfo.name).print(")");
					}
					else {
						mpr.print("java.util.Arrays.deepEquals(").print(minfo.name).print(", rhs.").print(minfo.name).print(")");
					}
				}
				else if (minfo.type.isPointerType()) {
					// (listStruct1 == other.listStruct1 || (listStruct1 != null && listStruct1.equals(other.listStruct1)))
					String lhs = minfo.name;
					String rhs = "rhs." + minfo.name;
					mpr.print("(").print(lhs).print("==").print(rhs).print(" || ")
					   .print("(").print(lhs).print("!=null && ").print(lhs).print(".equals(").print(rhs).print(")))");
				}
				else if (minfo.type.name.equals("double")) {
					String lhs = "Double.doubleToLongBits(" + minfo.name + ")";
					String rhs = "Double.doubleToLongBits(rhs." + minfo.name + ")";
					mpr.print(lhs).print("==").print(rhs);
				}
				else if (minfo.type.name.equals("float")) {
					String lhs = "Float.floatToIntBits(" + minfo.name + ")";
					String rhs = "Float.floatToIntBits(rhs." + minfo.name + ")";
					mpr.print(lhs).print("==").print(rhs);
				}
				else if (minfo.type.name.equals("void")) {
					// Type void can be used by methods
					mpr.print("true");
				}
				else {
					mpr.print(minfo.name).print("==rhs.").print(minfo.name);
				}
			}
			mpr.println(";");
		}
		
		pr.endBlock();
		pr.println("}");
		
		log.debug(")printEquals");
	}
	
	private void printSerialVersionUID() {
		log.debug("printSerialVersionUID");
		String kw = "";
		
		// final class?
		if (serInfo.isInline) {
			// -> cannot have a base class -> do not need new 
			// see ClassDB.verify(SerialInfo)
		}
		else {
			// has base class?
  		if (serInfo.baseInfo != null) {
				kw = "new "; 
			}
		}
		
		pr.print("public static readonly ").print(kw).print("long serialVersionUID = " + serInfo.typeId + "L;");
		log.debug(")printSerialVersionUID");
	}
	
	private void generate() throws IOException {
		pctxt.printDoNotModify(pr);

		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
		pr.print("namespace ").println(pctxt.renamePackage(serInfo.pack));
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		pctxt.printComments(pr, serInfo.comments);

		if (serInfo.isEnum){
			generateEnum();
		}
		else {
			generateClass();
		}
		
		pr.endBlock();
		pr.println("}  // end namespace");
	}
	
	private ArrayList<MemberInfo> sortEnumMembersByOrdinal(List<MemberInfo> members) {
		ArrayList<MemberInfo> m = new ArrayList<MemberInfo>(members);

		Collections.sort(m, new Comparator<MemberInfo>() {
			@Override
			public int compare(MemberInfo o1, MemberInfo o2) {
				int v1 = Integer.parseInt(o1.value);
				int v2 = Integer.parseInt(o2.value);
				return v1 - v2;
			}
		});
		
		return m;
	}
	
	private void generateEnum() throws IOException {

		pr.print("public enum ").print(serInfo.name).println();
		pr.println("{");
		pr.beginBlock();
		
		ArrayList<MemberInfo> membersByOrdinal = sortEnumMembersByOrdinal(serInfo.members);
		for (MemberInfo minfo : membersByOrdinal) {
			pctxt.printComments(pr, minfo.comments);
			pr.print(minfo.name).print(", // ordinal=").print(minfo.value).println();
		}
		
		pr.endBlock();
		pr.println("}  // end enum");
	}
	
	private void generateClass() throws IOException {
		log.debug("generate");

		
		
		String sfinal = serInfo.isFinal ? "sealed " : "";
		CodePrinter mpr = pr.print("public ").print(sfinal).print("class ").print(serInfo.name);
		if (serInfo.isResultClass()) {
			String rtype = pctxt.getReturnTypeAsObjType(methodInfo, serInfo.pack);
			String baseClass = "BMethodResult<" + rtype + ">";
			mpr.print(" : ").print(baseClass).print(", BSerializable");
		}
		else if (serInfo.isRequestClass()) {
			mpr.print(" : BMethodRequest, BSerializable");
		}
		else {
			if (serInfo.baseInfo != null) {
				TypeInfo csinfo = pctxt.toCSharp(serInfo.baseInfo);
				String baseName = csinfo.toString(serInfo.pack);
				mpr.print(" : ").print(baseName).print(", BSerializable");
			}
			else {
	       mpr.print(" : BSerializable");
			}
		}
		
		mpr.println();
		pr.println("{");
		pr.println();
		
		pr.beginBlock();
		
		if (!serInfo.isResultClass() && !serInfo.isRequestClass()) {
			pr.println("#region Constructors");
			pr.println();
			
			printConstructors();
			pr.println();
			pr.println("#endregion");
			pr.println();
		}
		
		if (!serInfo.isResultClass() && !serInfo.isRequestClass()) {
			pr.println("#region Properties");
			pr.println();

			for (MemberInfo minfo : serInfo.members) {
				printGetSet(minfo);
			}
			pr.println("#endregion");
			pr.println();
		}
		else {
			// Result Klasse erbt beide Elemente (result, exception) von BMethodResult
		} 

		if (serInfo.isRequestClass()) {
			
			pr.println("#region Execute");
			pr.println();

			printRemoteId();
			pr.println();
			
			printSetSession();

			printExecute();
			pr.println();
			pr.println("#endregion");
			pr.println();
		}
		
		// Generate hashCode() and equals() 
		if (pctxt.isGenerateHashCodeAndEquals() && methodInfo == null) {
			printHashCode();
			pr.println();
			
			printEquals();
			pr.println();
		}
		
		if (!serInfo.isResultClass()) {
			pr.println("#region Fields");
			pr.println();
			
			for (MemberInfo minfo : serInfo.members) {
				printMember(minfo);
			}
			pr.println("#endregion");
			pr.println();
		}
		else {
			// Result Klasse erbt beide Elemente (result, exception) von BMethodResult
		} 
		
		pr.println();
		printSerialVersionUID();
		pr.println();
		
		pr.endBlock();
		pr.println("} // end class");

		
		log.debug(")generate");
	}

	private final SerialInfo serInfo;
	private final CodePrinter pr;
	private final MethodInfo methodInfo;
	private final PrintContext pctxt;
}
