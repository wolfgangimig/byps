package com.wilutions.byps.gen.cpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
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
	
	private void printMember(MemberInfo minfo) throws IOException {
		
		if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
			// Type void can be used by method return values 
		}
		else {
			pctxt.printComments(prH, minfo.comments);
			
			String access = accessToString(minfo.access);
			String f = minfo.isFinal ? "final " : "";
			String s = minfo.isStatic ? "static " : "";
			String t = ""; // minfo.isTransient is unsupported by C++
			
			TypeInfoCpp cppMInfo = new TypeInfoCpp(minfo.type);
			String typeName = cppMInfo.getTypeName(serInfo.pack);
	
			prH.print(access).print(f).print(s).print(t)
			  .print(typeName).print(" ").print(minfo.name)
			  .println(";");
		}		
		
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
	
	private void printGetSet(MemberInfo minfo) throws IOException {

		if (minfo.access != MemberAccess.PUBLIC) {
			
			TypeInfoCpp typeCpp = new TypeInfoCpp(minfo.type);
			String memberType = typeCpp.toString(serInfo.pack);
			
			if (!memberType.equals("void")) {
				prH.print("public: ")
				  .print(memberType).print(" ")
				  .print("get").print(Utils.firstCharToUpper(minfo.name)).print("() {").println();
				prH.beginBlock();
				prH.print("return ").print(minfo.name).println(";");
				prH.endBlock();
				prH.println("}");
			}
			
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
			}
			
			if (serInfo.isResultClass()) {
				prH.println("if (resp != null) resp.ready(this);");
			}
			
			prH.endBlock();
			prH.println("}");
			prH.println();
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
		
		if (serInfo.isRequestClass()) {
			
		}
		else if (serInfo.isResultClass() ) {
			TypeInfoCpp rtype = pctxt.getReturnType(serInfo.methodInfo);
			int rtypeId = rtype.tinfo.typeId;
			prH.print("public: ").print(serInfo.name).println("();");
			prC.print(qname).print("::").print(serInfo.name).println("()");
			prC.beginBlock();
			prC.print(": BMethodResult(").print(rtypeId).println(") {");
			prC.endBlock();
			prC.println("}");
		}
		else {
		
			if (serInfo.isStubType()) {
				prH.print("public: ").print(serInfo.name).println("(PTransport transport);");
				prC.print(qname).print("::").print(serInfo.name).println("(PTransport transport) : BStub(transport) {");
			}
			else {
				prH.print("public: ").print(serInfo.name).println("();");
				prC.print(qname).print("::").print(serInfo.name).println("() {");
			}
			
			prC.beginBlock();
			for (MemberInfo minfo : serInfo.members) {
				String defaultValue = getDefaultValue(minfo.type);
				if (defaultValue == null) continue;
				prC.print(minfo.name).print(" = ").print(defaultValue).println(";");
			}
			prC.endBlock();
			prC.println("}");
		}	
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
		
		prH.print("namespace ").print(className).println(" {");
		
		prH.beginBlock();
		
		for (int i = 0; i < serInfo.members.size(); i++) {
			MemberInfo minfo = serInfo.members.get(i);
			pctxt.printComments(prH, minfo.comments);
			prH.print("const int32_t ").print(minfo.name).print(" = ").print(minfo.value)
			   .println(";");
		}
		
		prH.println();
		
		prH.endBlock();
		prH.println("}");

		endClass(prH);
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
		if (serInfo.isCollectionType() || serInfo.isArrayType()) {
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
		prH.println("using namespace com::wilutions::byps;");
		prH.println();

		pctxt.printComments(prH, serInfo.comments);
		
		prC.println();
		pctxt.printLine(prC);
		prC.println("// Implementation of class " + className);
		prC.println();
		
		//pr.println("@SuppressWarnings(\"serial\")");

		{
			CodePrinter mpr = prH.print("class ").print(className);
			if (serInfo.isResultClass()) {
				mpr.print(" : public BMethodResult");
			}
			else if (serInfo.isRequestClass()) {
				int remoteId = methodInfo.remoteInfo.typeId;
				mpr.print(" : public BMethodRequestT< " + remoteId + " >");
			}
			else 
			{
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
		
		if (!serInfo.isResultClass()) {
			for (MemberInfo minfo : serInfo.members) {
				printMember(minfo);
			}
			prH.println();
		}
		else {} // Result Klasse erbt Element result von BMethodResult
		
		printConstructors();
		prH.println();
		
		//printDestructor();

		for (MemberInfo minfo : serInfo.members) {
			printGetSet(minfo);
		}

		
		if (!serInfo.isResultClass()) {
			printSerialize();
		}
		
		if (serInfo.isRequestClass()) {
			printExecute();
		}
		
		prH.endBlock();
		prH.println("};");
		
		endClass(prH);
		
		prC.println();

	}
	
	private void printExecute() {
		prH.println("public: virtual void execute(PRemote remote, PAsyncResult asyncResult);");
		
		prC.print("void ")
		   .print(cppInfo.getClassName(""))
		   .print("::execute(PRemote remote, PAsyncResult asyncResult) {");
		prC.println();
		prC.beginBlock();
		
		String remoteName = methodInfo.remoteInfo.toString(serInfo.pack);
		prC.print("P").print(remoteName)
		   .print(" r = byps_ptr_cast<").print(remoteName).print(">(remote)")
		   .println(";");
		
		CodePrinter mpr = prC.print("r->async_").print(methodInfo.name).print("(");
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
			mpr.print("[=](").print(rtype).print(" result, BException ex) {").println();
			prC.beginBlock();
			prC.println("if (ex) {");
			prC.beginBlock();
			prC.println("asyncResult->setAsyncResult(BVariant(ex));");
			prC.endBlock();
			prC.println("}");
			prC.println("else {");
			prC.beginBlock();
			prC.print("PMethodResult methodResult(new ").print(resultClassName).print("());").println();
			prC.println("methodResult->result = BVariant(result);");
			prC.println("asyncResult->setAsyncResult(BVariant(methodResult));");
			prC.endBlock();
			prC.println("}");
			prC.endBlock();
			prC.println("});");
		}
		else {
			// Geringe Prio: execute() ohne Lambda ergänzen 
			
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
		
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			prC.print(serInfo.baseInfo.name).print("::serialize(ar, version);").println();
		}
		
		printSerializeMembers(serInfo.getTypeMembers());
		printSerializeMembers(serInfo.getPointerMembers());
		
		prC.endBlock();
		prC.println("}");
	}
	
	private void printSerializer() {		
		String className = cppInfo.getClassName("");
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		prC.print("void ").print("BSerializer_" + serInfo.typeId)
			.print("(BIO& bio, POBJECT& pObj, void* pBase)").println("{");
		prC.beginBlock();
		
		prC.println("void* p = pBase ? pBase : pObj.get();");
		prC.println("if (p) { ");
		prC.beginBlock();
		prC.print(className).print("& r = * ").print("reinterpret_cast<").print(className).print("*>(p);").println();
		prC.println("bio & r;");
		prC.endBlock();
		prC.println("} else {");
		prC.beginBlock();
		prC.print("pObj = POBJECT(new ").print(className).println("());");
		prC.endBlock();
		prC.println("}");
		
		prC.endBlock();
		prC.println("}");
		
		prC.println(regCppInfo.namespaceEnd);
	}
	

	private void printSerializeMembers(List<MemberInfo> members) {
		List<Integer> sinceStack = new ArrayList<Integer>();

		for (MemberInfo minfo : members) {
			if (minfo.isTransient) {
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
		
		if (serInfo.typeId == 839369882) {
			serInfo.typeId = 839369882;
		}
		
		TypeInfo tinfo = minfo.type;
		if (tinfo.isEnum){
//			prC.print("{ int32_t v = this->").print(minfo.name).print("; ")
//			   .print("ar & v; ")
//			   .print("this->").print(minfo.name).print(" = v; }")
//			   .println();
			prC.print("ar & ").print(minfo.name).print(";")
			   .println();
		}
		else {
			prC.print("ar & ").print(minfo.name).print(";")
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
