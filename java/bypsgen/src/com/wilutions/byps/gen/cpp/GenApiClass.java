package com.wilutions.byps.gen.cpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BJsonObject;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberAccess;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;
import com.wilutions.byps.gen.utils.Utils;

class GenApiClass {
	
	static Log log = LogFactory.getLog(GenApiClass.class);
	
	static void generate(PrintContext pctxt, SerialInfo serInfo) throws IOException {
		
		log.info("Generate type " + serInfo.typeId + ": " + serInfo);
		CodePrinter prH = null;
		CodePrinter prCpp = null;

		if (serInfo.isBuiltInType()) {
			
		}
		else if (serInfo.isStubType()) {
			// GenRemoteStub
		}
		else if (serInfo.isCollectionType() || serInfo.isArrayType() || 
				serInfo.isResultClass() || serInfo.isRequestClass() ||
				serInfo.isStubType()) {
			prH = pctxt.getPrImplAllH();
			prCpp = pctxt.getPrImplC();
		}
		else {
			prH = pctxt.getPrApiAllH();
			prCpp = pctxt.getPrImplC();
		}

		if (prH != null && prCpp != null) {
			new GenApiClass(pctxt, serInfo, prH, prCpp).generate();
		}
		
	}

	private GenApiClass(PrintContext pctxt, SerialInfo serInfo, CodePrinter prH, CodePrinter prCpp) {
		this.pctxt = pctxt;
		this.serInfo = serInfo;
		this.cppInfo = new TypeInfoCpp(serInfo);
		this.baseCppInfo = cppInfo.getBaseInfo();
		this.prH = prH;
		this.prC = prCpp;
		this.methodInfo = serInfo.methodInfo;
	}
	
	private String accessToString(MemberAccess a) {
		if (a == MemberAccess.PUBLIC) return "public: ";
		if (a == MemberAccess.PRIVATE)return "private: ";
		return "protected: ";
	}
	
	private boolean canInitializeConstantInline(TypeInfo tinfo) {
		if (tinfo.isArrayType()) return false;
		String qname = tinfo.toString();
		return false 
			||  qname.equals("boolean")
			||  qname.equals("java.lang.Boolean")
			||  qname.equals("byte")
			||  qname.equals("java.lang.Byte")
			||  qname.equals("char")
			||  qname.equals("java.lang.Character")
			||  qname.equals("short")
			||  qname.equals("java.lang.Short")
			||  qname.equals("int")
			||  qname.equals("java.lang.Integer")
			||  qname.equals("long")
			||  qname.equals("java.lang.Long")
			;
	}
	
	private boolean canInitializeConstantByAssignmentInCpp(TypeInfo tinfo) {
		if (tinfo.isArrayType()) return false;
		String qname = tinfo.toString();
		return false 
				||  qname.equals("float")
				||  qname.equals("java.lang.Float")
				||  qname.equals("double")
				||  qname.equals("java.lang.Double")
				||  qname.equals("java.lang.String");
	}
	
	private void printMember(MemberInfo minfo) throws IOException {
		
		if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
			// Type void can be used by method return values 
		}
		else {
			pctxt.printComments(prH, minfo.comments);
			
			String access = accessToString(minfo.access);
			String f = minfo.isFinal ? "const " : "";
			String s = minfo.isStatic ? "static " : "";
			String t = ""; // minfo.isTransient is unsupported by C++
			
			TypeInfoCpp cppMInfo = new TypeInfoCpp(minfo.type);
			String typeName = cppMInfo.getTypeName(serInfo.pack);
	
			CodePrinter mpr = prH.print(access).print(f).print(s).print(t)
			  .print(typeName).print(" ").print(minfo.name);
			
			
			String value = minfo.value;
			if (value != null) {
				if (value.startsWith("\"")) value = value.substring(1, value.length()-1);
				
				if (canInitializeConstantInline(minfo.type)) {
					mpr = mpr.print(" = ");
					printConstantValueInline(mpr, minfo.type, value);
				}
				else if (canInitializeConstantByAssignmentInCpp(minfo.type)) {
					CodePrinter mprC = prC.print(f).print(t)
							  			.print(cppMInfo.toString(serInfo.pack)).print(" ")
							  			.print(cppInfo.getClassName(serInfo.pack)).print("::")
							  			.print(minfo.name)
							  			.print(" = ");
				
					printConstValue(mprC, "", minfo.type, value);
					
					mprC.println(";");
					prC.println();
				}
				else {
//					String initFnct = makeInitFunctionName();
//					prC.print("static ").print(cppMInfo.toString(serInfo.pack)).print(" ").print(initFnct).println("() {");
//					prC.beginBlock();
//					CodePrinter mprC = prC.print(cppMInfo.toString(serInfo.pack)).print(" ");
//					mprC = printConstValue(mprC, "ret", minfo.type, value);
//					prC.println("return ret;");
//					prC.endBlock();
//					prC.println("}");
					
					CodePrinter mprC = prC.print(f).print(t)
			  			.print(cppMInfo.toString(serInfo.pack)).print(" ")
			  			.print(cppInfo.getClassName(serInfo.pack)).print("::")
			  			.print(minfo.name)
			  			.print(" = ");
					mprC = printConstValue(mprC, "", minfo.type, value);
					mprC.println(";");
					prC.println();
				}
				
			}
			
			mpr.print(";");
			if (minfo.isTransient) mpr.print(" // transient");
			mpr.println();
		}		
		
	}
	
	static int initFnctCount = 0;
	String makeInitFunctionName() {
		return "init_" + (++initFnctCount);
	}
	
	CodePrinter printConstantValueInline(CodePrinter mpr, TypeInfo tinfo, Object value) {
		
		if (tinfo.qname.equals("char")) {
			String s = (String)value;
			mpr = mpr.print("L\'");
			mpr = mpr.print( pctxt.printStringChar(s.charAt(0)) );
			mpr = mpr.print("\'");
		}
		else if (tinfo.qname.equals("boolean")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			mpr = mpr.print(""+value);
		}
		else if (tinfo.qname.equals("byte")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			mpr = mpr.print("(int8_t)" + value);
		}
		else if (tinfo.qname.equals("short")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			mpr = mpr.print("(int16_t)" + value);
		}
		else if (tinfo.qname.equals("int")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			mpr = mpr.print(""+value);
		}
		else if (tinfo.qname.equals("long")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			mpr = mpr.print(value + "LL");
		}
	
		return mpr;
	}
	
//	private void printRemoteId() throws IOException {
//		prH.println("public: virtual BTYPEID getRemoteId();");
//		prH.println();
//		
//		prC.println("const char* " + this.cppInfo.getQClassName() + "::getRemoteName() {");
//		prC.beginBlock();
//		prC.print("return \"").print(methodInfo.remoteInfo.toString()).println("\";");
//		prC.endBlock();
//		prC.println("}");
//		prC.println();
//		
//	}
	
	private CodePrinter printConstValue(CodePrinter mpr, String path, TypeInfo tinfo, Object value) throws BException, GeneratorException {
		
		if (tinfo.dims.length() != 0) {
			BJsonObject js = BJsonObject.fromString((String)value);
			mpr = makeNewArrayInstance(mpr, path, tinfo, js);
		}
		else {
			if (canInitializeConstantInline(tinfo)) {
				mpr = mpr.print(path);
				mpr = printConstantValueInline(mpr, tinfo, value);
			}
			else if (tinfo.qname.equals("java.lang.String")) {
				String s = (String)value;
				mpr = mpr.print(path).print("L\"");
				for (int i = 0; i < s.length(); i++) {
					mpr = mpr.print( pctxt.printStringChar(s.charAt(i)) );
				}
				mpr = mpr.print("\"");
			}
			else if (tinfo.qname.equals("double")) {
				mpr = mpr.print(path).print(""+value);
			}
			else if (tinfo.qname.equals("float")) {
				mpr = mpr.print(path).print(value + "f");
			}
			else if (tinfo.isPointerType() && (value instanceof BJsonObject)) {
				mpr = makeNewInstance(mpr, path, tinfo, (BJsonObject)value);
			}
			else {
				BJsonObject js = BJsonObject.fromString((String)value);
				mpr = makeNewInstance(mpr, path, tinfo, js);
			}
		}
		
		return mpr;
	}
	
	private int makeArrayInitList(TypeInfo elmType, BJsonObject arr, int dim, String idx, int totalCount) throws BException, GeneratorException {
		if (dim == 1) {
			for (int i = 0; i < arr.size(); i++) {
				CodePrinter mpr = prC;
				mpr = printConstValue(mpr, "", elmType, arr.get(i));
				if (--totalCount > 0) mpr.print(", ");
				mpr.print(" // " + idx + "[" + i + "]");
				prC.println();
			}
		}
		else {
			for (int i = 0; i < arr.size(); i++) {
				totalCount = makeArrayInitList( elmType, 
						(BJsonObject)arr.get(i), 
						dim-1, 
						idx + "[" + i + "]", 
						totalCount);
			}			
		}
		return totalCount;
    }
	
	private CodePrinter makeNewArrayInstance(CodePrinter mpr, String path, TypeInfo tinfo, BJsonObject js) throws BException, GeneratorException {
		
		TypeInfoCpp tinfoCpp = new TypeInfoCpp(tinfo);
		
		if (js == null) {
			mpr = mpr.print(tinfoCpp.getTypeName(serInfo.pack)).print("()");
			return mpr;
		}
		
		int dims = tinfo.dims.length() / 2;
		
		mpr = mpr.print(path).print(tinfoCpp.getTypeName(serInfo.pack))
			.print("(");
		if (tinfo.isByteArray1dim()) {
			mpr = mpr.print("BBytes::create");
		}
		else { 
			mpr = mpr.print("new ").print(tinfoCpp.getClassName(""));
		}
		mpr.println("(");
		
		mpr = prC;

		prC.beginBlock();

		String dimsComment = "";
		int totalCount = 1;
		BJsonObject arr = js;
		for (int i = 0; i < dims; i++) {
			int size = 0;
			if (arr != null) {
				size = arr.size();
			}
			
			totalCount *= size;
			dimsComment += "[" + size + "]";
			mpr = mpr.print(""+size).print(", ");
			arr = (i < dims-1) && (size != 0) ? (BJsonObject)arr.get(0) : null;
		}
		mpr.print("// dims=").println(dimsComment);
		
		TypeInfo elmType = pctxt.classDB.getTypeInfo(tinfo.qname);
		makeArrayInitList(elmType, js, dims, "", totalCount);
		
		prC.endBlock();
		
		prC.print("))");
		
		return mpr;
	}
	
	
	private CodePrinter makeNewInstance(CodePrinter mpr, String path, TypeInfo tinfo, BJsonObject params) throws GeneratorException, BException {
		// Lookup full SerialInfo of given tinfo
		SerialInfo sinfo = pctxt.classDB.getSerInfo(tinfo.toString());
		if (sinfo == null) {
			throw new GeneratorException("Internal error, typeId=" + tinfo.typeId + " not found in list of serials.");
		}
		
		TypeInfoCpp cppMInfo = new TypeInfoCpp(sinfo);
		
		if (params == null) {
			mpr = mpr.print(cppMInfo.getTypeName(serInfo.pack)).print("()");
			return mpr;
		}
		
		mpr.print(path)
			.print(cppMInfo.toString(serInfo.pack))
			.print("(new ").print(sinfo.toString(serInfo.pack)).println("(");
		
		prC.beginBlock();
		
		boolean first = true;
		for (MemberInfo minfo : sinfo.members) {
			if (minfo.isStatic) continue;
			
			if (first) first = false; else mpr.println(",");
			mpr = prC;
	
			Object mvalue = params.get(minfo.name);
			if (minfo.type.dims.length() != 0) {
				mpr = makeNewArrayInstance(mpr, "", minfo.type, (BJsonObject)mvalue);
			} else if (minfo.type.isPointerType()) {
				mpr = makeNewInstance(mpr, "", minfo.type, (BJsonObject)mvalue);
			}
			else {
				mpr = printConstValue(mpr, "", minfo.type, mvalue);
			}
			
		}
		
		mpr.print("))");
		prC.endBlock();
		
		return mpr;
	}
	
	private void printGetSet(MemberInfo minfo) throws IOException {
		
		String staticDecl = minfo.isStatic ? "static " : " ";

		if (minfo.access != MemberAccess.PUBLIC) {
			
			TypeInfoCpp typeCpp = new TypeInfoCpp(minfo.type);
			String memberType = typeCpp.toString(serInfo.pack);
			
			if (!memberType.equals("void")) {
				prH.print("public: ").print(staticDecl)
				  .print(memberType).print(" ")
				  .print("get").print(Utils.firstCharToUpper(minfo.name)).print("() {").println();
				prH.beginBlock();
				prH.print("return ").print(minfo.name).println(";");
				prH.endBlock();
				prH.println("}");
			}
			
			if (!minfo.isFinal) { 
				if (memberType.equals("void")) {
					prH.print("public: void ")		  
					  .print("set").print(Utils.firstCharToUpper(minfo.name))
					  .print("() {").println();
					prH.beginBlock();
				}
				else {
					
					prH.print("public: void ")		  
					  .print("set").print(Utils.firstCharToUpper(minfo.name))
					  .print("(").print(memberType).print(" v) {").println();
					prH.beginBlock();
					prH.print(minfo.name).println(" = v;");
					pctxt.printSetChangedMember(prH, serInfo, minfo);				
				}
			
				if (serInfo.isResultClass()) {
					prH.println("if (resp != null) resp.ready(this);");
				}
				
				prH.endBlock();
				prH.println("}");
				prH.println();
			}
		}

	}
	
	String getDefaultValue(TypeInfo tinfo) {
		if (tinfo.isPointerType()) return null;
		else if (tinfo.isStringType()) return null;
		else if (tinfo.isEnum) {
			SerialInfo enumInfo = pctxt.classDB.getSerInfo(tinfo.toString());
			if (enumInfo != null && enumInfo.members.size() != 0) {
				MemberInfo minfo = enumInfo.members.get(0);
				TypeInfoCpp mtinfoCpp = new TypeInfoCpp(minfo.type);
				return mtinfoCpp.namespace + "::" + enumInfo.name + "::" + minfo.name;
			}
		}
		else if (tinfo.qname.equals("boolean")) return "false";
		else if (tinfo.qname.equals("java.lang.Boolean")) return "false";
		else if (tinfo.qname.equals("char")) return "'\\0'";
		else if (tinfo.qname.equals("java.lang.Character")) return "'\0'";
		return "0";
//		else if (tinfo.qname.equals("float")) return "0";
//		else if (tinfo.qname.equals("java.lang.Float")) return "0";
//		else if (tinfo.qname.equals("double")) return "0";
//		else if (tinfo.qname.equals("java.lang.Double")) return "0";
	}
	
	private void printConstructors() throws IOException {
		
		String qname = cppInfo.getQClassName();
		
		if (serInfo.isResultClass() ) {
			String rtypeName = pctxt.getReturnTypeName(serInfo.methodInfo);
			prH.print("public: ").print(serInfo.name).print("(")
			   .print(rtypeName).print(" result = ").print(rtypeName).print("())")
			   .print(" : result(result) {}");
		}
		else {
		
			if (serInfo.isStubType()) {
				prH.print("public: ").print(serInfo.name).println("(PTransport transport);");
				prC.print(qname).print("::").print(serInfo.name).println("(PTransport transport) : BStub(transport) {");
			}
			else {
				prH.print("public: ").print(serInfo.name).println("();");
				
				CodePrinter mpr = prC.print(qname).print("::").print(serInfo.name).print("() ");
				
				if (serInfo.isRequestClass()) {
					int remoteId = methodInfo.remoteInfo.typeId;
					mpr.print(": BMethodRequest(").print(remoteId).print(") ");
				}
				
				mpr.println("{");
			}
			
			prC.beginBlock();
			for (MemberInfo minfo : serInfo.members) {
				if (minfo.isStatic) continue; 
				String defaultValue = getDefaultValue(minfo.type);
				if (defaultValue == null) continue;
				prC.print(minfo.name).print(" = ").print(defaultValue).println(";");
			}
			prC.endBlock();
			prC.println("}");
			
			printInitConstructor();
			
		}	
	}

	protected void printInitConstructor() {
		
		boolean allMembersStatic = true;
		for (MemberInfo minfo : serInfo.members) {
			if (!minfo.isStatic) {
				allMembersStatic = false;
				break;
			}
		}
		
		if (allMembersStatic) return;
		
		String qname = cppInfo.getQClassName();

		String constrDecl = makeInitConstructorDecl();
		
		prH.print("public: ").print(constrDecl).print(";");
		prC.print(qname).print("::").print(constrDecl);
	
		prC.println();
		prC.beginBlock();
		boolean first = true;
		
		if (serInfo.isRequestClass()) {
			int remoteId = methodInfo.remoteInfo.typeId;
			prC.print(": BMethodRequest(").print(remoteId).println(") ");
			first = false;
		}
		
		for (MemberInfo minfo : serInfo.members) {
			if (minfo.isStatic) continue;
			prC.print( first ? ": " : ", " ).print(minfo.name).print("(").print(minfo.name).println(")");
			first = false;
		}
		prC.println("{}");
		prC.endBlock();
		
	}

	protected String makeInitConstructorDecl() {
		StringBuilder constr = new StringBuilder();
		constr.append(serInfo.name).append("(");
		
		boolean first = true;
		for (MemberInfo minfo : serInfo.members) {
			if (first) first = false; else constr.append(", ");
			TypeInfoCpp tinfoCpp = new TypeInfoCpp(minfo.type);
			constr.append(tinfoCpp.getQTypeName()).append(" ").append(minfo.name);
		}
		
		constr.append(")");
		
		String constrDecl = constr.toString();
		return constrDecl;
	}

	
//	private void printDestructor() throws IOException {
//		prH.print("public: virtual ~").print(serInfo.name).println("() throw() {}");
//	}
	
	private void generateEnum() throws IOException
	{
		String className = cppInfo.getClassName(serInfo.pack);
		
		beginClass(prH, className, serInfo.typeId);
		prH.println();

		pctxt.printComments(prH, serInfo.comments);
		
		CodePrinter mpr = prH.print("enum ").print(className);
		mpr.print(" : int32_t ");
		mpr.println(" {");
		
		prH.beginBlock();
		
		for (int i = 0; i < serInfo.members.size(); i++) {
			MemberInfo minfo = serInfo.members.get(i);
			pctxt.printComments(prH, minfo.comments);
			mpr = prH;
			//mpr.print("const int32_t ");
			mpr = mpr.print(minfo.name).print(" = ").print(minfo.value);
			mpr.println(",");
		}
		
		prH.println();
		
		prH.endBlock();
		prH.println("};");
		prH.println();
		
		prH.print("void operator & (BIO& ar, ").print(className).print("& e);");
		prH.println();
		
		endClass(prH);
		
		
		// Implementiernung von operator& 
		prC.println();
		prC.print(cppInfo.namespaceBegin).println();
		prC.println();
		
		prC.print("void operator & (BIO& ar, ").print(className).println("& e) {");
	
		prC.beginBlock();
		prC.println("int32_t v = static_cast<int32_t>(e);");
		prC.println("ar & v;");
		prC.print("if (ar.is_loading) e = static_cast<").print(className).println(">(v);");
		prC.endBlock();
		prC.println("}");

		prC.println();
		prC.println(cppInfo.namespaceEnd);
		prC.println();

		
	}
	
	private void beginClass(CodePrinter pr, String className, int typeId) throws IOException {
		pr.println();
		pctxt.printLine(pr);
		pr.print("// ").println(className);
		pr.print("// typeId=" + typeId).println();
		pr.println();

		pr.print(cppInfo.namespaceBegin).println();
		pr.println();
	}
	
	private void endClass(CodePrinter pr) throws IOException {
		pr.println();
		pr.println(cppInfo.namespaceEnd);
	}
	
	private void generate() throws IOException {
		if (serInfo.isByteArray1dim()) {
			printSerializerByteArray();
		}
		else if (serInfo.isCollectionType() || serInfo.isArrayType()) {
			printSerializer();
			
		}
		else {
			if (serInfo.isEnum) {
				generateEnum();
			}
			else {
				generateClass();
				printSerializer();
			}
		}


	}
	
	private void generateClass() throws IOException {
		
		String className = cppInfo.getClassName(serInfo.pack);
		
		beginClass(prH, className, serInfo.typeId);
		prC.println(cppInfo.namespaceBegin);
		
		prH.println("using namespace com::wilutions::byps;");
		prH.println();

		pctxt.printComments(prH, serInfo.comments);
		
		prC.println();
		pctxt.printLine(prC);
		prC.println("// Implementation of class " + className);
		prC.println();
		
		//pr.println("@SuppressWarnings(\"serial\")");

		{
			CodePrinter mpr = prH;
			
			if (serInfo.isResultClass()) {
				mpr = mpr.print("class ").print(className);
				mpr.print(" : public BSerializable");
//				TypeInfoCpp rtype = pctxt.getReturnType(serInfo.methodInfo);
//				String rtypeName = rtype.getQTypeName();
//				if (rtypeName.equals("void")) rtypeName = "bool";
//				mpr.print(" : public BMethodResult<" + rtypeName + " >");
			}
			else if (serInfo.isRequestClass()) {
				mpr = mpr.print("class ").print(className);
				mpr.print(" : public BMethodRequest");
			}
			else 
			{
				mpr = mpr.print("class ").print(className);
				if (baseCppInfo != null) {
					mpr.print(" : public ").print(baseCppInfo.getClassName(serInfo.pack));
				}
				else {
					mpr.print(" : public BSerializable");
				}
			}
			
			mpr.println(" {");
		}
		
		prH.beginBlock();
		
		if (serInfo.isResultClass()) {
			String rtypeName = pctxt.getReturnTypeName(serInfo.methodInfo);
			prH.print("public: ").print(rtypeName).println(" result;");
		}
		else {
			for (MemberInfo minfo : serInfo.members) {
				printMember(minfo);
			}
			prH.println();
		}
				
		printConstructors();
		prH.println();
		
		pctxt.print_BSerializable_getTypeId(serInfo, prH);
		
		//printDestructor();

		for (MemberInfo minfo : serInfo.members) {
			printGetSet(minfo);
		}

		
		printSerialize();
		
		
		if (serInfo.isRequestClass()) {
			printExecute();
		}
		
		prH.endBlock();
		prH.println("};");
		
		endClass(prH);
		prC.println(cppInfo.namespaceEnd);
		
		prC.println();

	}

	private void printExecute() {
		prH.println("public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);");
		
		prC.print("void ")
		   .print(cppInfo.getClassName(""))
		   .print("::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {");
		prC.println();
		prC.beginBlock();
		
		String remoteName = methodInfo.remoteInfo.toString(serInfo.pack);
		prC.print("P").print(remoteName)
		   .print(" __byps__remoteT = byps_ptr_cast<").print(remoteName).print(">(__byps__remote)")
		   .println(";");
		
		CodePrinter mpr = prC.print("__byps__remoteT->async_").print(methodInfo.name).print("(");
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr = mpr.print(pinfo.name);
		}		
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type);
		String rtype = tinfoCpp.toString(serInfo.pack);
		if (rtype.equals("void")) rtype = "bool";
		if (!first) mpr.print(", ");
		
		String resultClassName = methodInfo.resultInfo.name;

		if (pctxt.lambdaSupported) {
			mpr.print("[__byps__asyncResult](").print(rtype).print(" __byps__result, BException __byps__ex) {").println();
			prC.beginBlock();
			prC.println("if (__byps__ex) {");
			prC.beginBlock();
			prC.println("__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));");
			prC.endBlock();
			prC.println("}");
			prC.println("else {");
			prC.beginBlock();
			prC.print("PSerializable __byps__methodResult(new ").print(resultClassName).print("(__byps__result));").println();
			prC.println("__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));");
			prC.endBlock();
			prC.println("}");
			prC.endBlock();
			prC.println("});");
		}
		else {
			// Geringe Prio: execute() ohne Lambda erg�nzen 
			
			throw new IllegalStateException("!lambdasupported");
		}

		prC.endBlock();
		prC.println("}");
	}
	
	private void printSerialize() {		

		prH.print("public: void ")
		.print("serialize(BIO& ar, const unsigned int version")
		.println(");");

		prC.print("void ")
			.print(cppInfo.getClassName(""))
			.print("::serialize(BIO& ").print("ar")
			.print(", const unsigned int ").print("version")
			.println(") {");
		prC.beginBlock();
		
		if (serInfo.isResultClass()) {
			printSerializeMember("result", serInfo.methodInfo.resultInfo.members.get(0).type);
		}
		else {
			if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
				prC.print(serInfo.baseInfo.name).print("::serialize(ar, version);").println();
			}
			
			printSerializeMembers(serInfo.getTypeMembers());
			printSerializeMembers(serInfo.getPointerMembers());
		}
		
		prC.endBlock();
		prC.println("}");
	}
	
	private void printSerializerByteArray() {		
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		prC.print("void ").print("BSerializer_" + serInfo.typeId)
			.print("(BIO& bio, POBJECT& pObj, PSerializable&, void* )").println("{");
		prC.beginBlock();
		
		prC.println("PBytes p = byps_static_ptr_cast<BBytes>(pObj);");
		
		prC.println("if (bio.is_loading) {");
		prC.beginBlock();
		prC.println("if (p) return;");
		prC.println("bio.serialize(p);");
		prC.println("pObj = p;");
		prC.endBlock();
		prC.println("}");
		prC.println("else {");
		prC.beginBlock();
		prC.println("bio.serialize(p);");
		prC.endBlock();
		prC.println("}");
		
		prC.endBlock();
		prC.println("}");
		
		prC.println(regCppInfo.namespaceEnd);
	}
	
	
	private void printSerializer() {		
		String className = cppInfo.getClassName("");
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		CodePrinter mpr = prC.print("void ")
			.print("BSerializer_" + serInfo.typeId);
		if (serInfo.isInheritable()) {
			mpr.print("(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase)");
		}
		else {
			mpr.print("(BIO& bio, POBJECT& pObj, PSerializable& , void* )");
		}			
		mpr.println(" {");
		
		prC.beginBlock();
		
		String cast = "";
		if (serInfo.isInheritable()) {
			prC.println("BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();");
			cast = "dynamic_cast";
		}
		else {
			prC.println("void* p = pObj.get();");
			cast = "reinterpret_cast";
		}
		
		prC.println("if (p) { ");
		prC.beginBlock();
		prC.print(className).print("& r = * ").print(cast).print("<").print(className).print("*>(p);").println();
		prC.print("bio & r;").println();
		prC.endBlock();
		prC.println("} else {");
		prC.beginBlock();
		if (serInfo.isInheritable()) {
			prC.print("pObjS = PSerializable(new ").print(className).println("());");
		}
		else {
			prC.print("pObj = POBJECT(new ").print(className).println("());");
		}
		prC.endBlock();
		prC.println("}");
		
		prC.endBlock();
		prC.println("}");
		
		prC.println(regCppInfo.namespaceEnd);
	}
	

	private void printSerializeMembers(List<MemberInfo> members) {
		List<Integer> sinceStack = new ArrayList<Integer>();

		for (MemberInfo minfo : members) {
			if (minfo.isFinal || minfo.isStatic) {  
			}
			else if (minfo.isTransient) {
				prC.print("// skip transient member ").print(minfo.name).println();
			}
			else if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
				// Type void can be used by method return values 
			}
			else {
				printSerializeMember(minfo, sinceStack);
			}
		}
		
		for (int i = 0; i < sinceStack.size(); i++) {
			prC.endBlock();
			prC.println("}");
		}
	}

	private void printSerializeMember(MemberInfo minfo, List<Integer> sinceStack) {
		if (minfo.since != 0) {
			if (sinceStack.size() == 0 || sinceStack.get(sinceStack.size()-1) != minfo.since) {
				sinceStack.add(minfo.since);
				prC.print("if (version >= ").print(minfo.since).print(") {").println();
				prC.beginBlock();
			}
		}
		
		String memberName = minfo.name;
		TypeInfo tinfo = minfo.type;
		printSerializeMember(memberName, tinfo);
	}

	protected void printSerializeMember(String memberName, TypeInfo tinfo) {
		if (tinfo.isEnum){
//			prC.print("{ int32_t v = this->").print(minfo.name).print("; ")
//			   .print("ar & v; ")
//			   .print("this->").print(minfo.name).print(" = v; }")
//			   .println();
			prC.print("ar & ").print(memberName).print(";")
			   .println();
		}
		else if (tinfo.isInheritable()) {
			prC.print("ar & ").print(memberName).println(";");
//			TypeInfoCpp tinfoCpp = new TypeInfoCpp(tinfo);
//			prC.println("{");
//			prC.beginBlock();
//			prC.print("PSerializable p = ").print(memberName).println(";");
//			prC.println("ar | p;");
//			prC.print("if (ar.is_loading) ")
//			   .print(memberName).print(" = byps_ptr_cast<").print(tinfoCpp.getQClassName()).print(">(p)").println(";");
//			prC.endBlock();
//			prC.println("}");
		}
		else { 
			prC.print("ar & ").print(memberName).print(";")
			   .println();
		}
	}

	
	private final SerialInfo serInfo;
	private final TypeInfoCpp cppInfo;
	private final TypeInfoCpp baseCppInfo;
	private final CodePrinter prH;
	private final CodePrinter prC;
	
	private final MethodInfo methodInfo;
	private final PrintContext pctxt;
}
