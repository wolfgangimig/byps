package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.MemberAccess;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;
import com.wilutions.byps.gen.utils.Utils;

class GenApiClass {
	
	static Log log = LogFactory.getLog(GenApiClass.class);
	
	static void generate(PrintContext pctxt, SerialInfo serInfo) throws IOException {
		
		log.info("Generate type " + serInfo.typeId + ": " + serInfo);
		CodePrinter prH = null;
		CodePrinter prCpp = null;

		if (serInfo.isBuiltInType()) {
			// Für int, long, java.lang.String, java.lang.Object, java.util.Map, usw.
			// werden keine Forward-Decl benötigt
		}
		else if (serInfo.isCollectionType()) {
			// keine Forward-Decl für vector, set, map
		}
		else if (serInfo.isArrayType()) {
			// keine Forward-Decl für int[] usw. -> wird zu vector<int>
		}
		else if (isResultClass(serInfo) || isRequestClass(serInfo)) {
			prH = pctxt.prImplAllH;
			prCpp = pctxt.prImplC;
		}
		else {
			prH = pctxt.prApiAllH;
			prCpp = pctxt.prImplC;
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
	
	private void printComments(Iterable<CommentInfo> comments) throws IOException {
		
		if (comments != null) {
			prH.println("/**");
			for (CommentInfo cmt : comments) {
				String t = cmt.text.trim().replace("\r", "\n"); 
				for (String line : t.split("\n")) {
					CodePrinter mpr = prH.print(" * ");
					if (!cmt.kind.equals(CommentInfo.KIND_REMARKS) && !cmt.kind.equals(CommentInfo.KIND_SUMMARY)) {
						mpr.print(cmt.kind).print(" ");
					}
					mpr.println(line.trim());
				}
			}
			prH.println("*/");
		}
		
	}
	
	private String accessToString(MemberAccess a) {
		if (a == MemberAccess.PUBLIC) return "public: ";
		if (a == MemberAccess.PROTECTED) return "protected: ";
		if (a == MemberAccess.PRIVATE)return "private: ";
		return "";
	}
	
	private void printMember(MemberInfo minfo) throws IOException {
		
		if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
			// Type void can be used by method return values 
		}
		else {
			printComments(minfo.comments);
			
			String access = accessToString(minfo.access);
			String f = minfo.isFinal ? "final " : "";
			String s = minfo.isStatic ? "static " : "";
			String t = minfo.isTransient ? "transient " : "";
			
			TypeInfoCpp cppMInfo = new TypeInfoCpp(minfo.type);
			String typeName = cppMInfo.toString(serInfo.pack);
	
			prH.print(access).print(f).print(s).print(t)
			  .print(typeName).print(" ").print(minfo.name)
			  .println(";");
		}		
		
	}
	
	private void printRemoteId() throws IOException {
		prH.println("public: virtual INT32 getRemoteId();");
		prH.println();
		
		prC.println("const char* " + this.cppInfo.getQClassName() + "::getRemoteName() {");
		prC.beginBlock();
		prC.print("return \"").print(methodInfo.remoteInfo.toString()).println("\";");
		prC.endBlock();
		prC.println("}");
		prC.println();
		
	}
	
	private void printGetSet(MemberInfo minfo) throws IOException {

		if (minfo.access != MemberAccess.PUBLIC) {
			
			String memberType = minfo.type.toString(serInfo.pack);
			
			if (!memberType.equals("void")) {
				prH.print("public: ")
				  .print(memberType).print(" ")
				  .print("get").print(Utils.firstCharToUpper(minfo.name)).print("() {").println();
				prH.beginBlock();
				prH.print("return ").print(minfo.name).println(";");
				prH.endBlock();
				prH.println("}");
				prH.println();
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
			
			if (isResultClass()) {
				prH.println("if (resp != null) resp.ready(this);");
			}
			
			prH.endBlock();
			prH.println("}");
			prH.println();
			prH.println();
		}

	}
	
	private void printConstructors() throws IOException {
		
		String qname = cppInfo.getQClassName();
		
		prH.print("public: ").print(serInfo.name).println("();");
		
		prC.print(qname).print("::").print(serInfo.name).println("() {");
		prC.println("}");

//		if (isValueClass()) {
//			if (serInfo.members.size() != 0) {
//				CodePrinter mprH = prH.print("public: ").print(serInfo.name).print("(");
//				CodePrinter mprC = prC.print(qname).print("::").print(serInfo.name).print("(");
//				boolean first = true;
//				for (MemberInfo minfo : serInfo.members) {
//					if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
//					if (!first) {mprH.print(", "); mprC.print(", "); } else first = false; 
//					TypeInfoCpp cppMinfo = new TypeInfoCpp(minfo.type);
//					 mprH.print(cppMinfo.getParamType(serInfo.pack)).print(" ").print(minfo.name);
//					 mprC.print(cppMinfo.getParamType(serInfo.pack)).print(" ").print(minfo.name);
//				}
//				mprH.println(");");
//				
//				mprC.print(") {").println();
//				prC.beginBlock();
//				for (MemberInfo minfo : serInfo.members) {
//					if (minfo.type.typeId == BRegistry.TYPEID_VOID) continue;
//					prC.print("this->").print(minfo.name).print(" = ").print(minfo.name).println(";");
//				}
//				prC.endBlock();
//				prC.println("}");
//				prC.println();
//
//			}
//		}
		
	}

	private void printDestructors() throws IOException {
		String qname = cppInfo.getQClassName();
		prH.print("public: virtual ~").print(serInfo.name).println("();");
		prC.print(qname).print("::~").print(serInfo.name).println("() {");
		prC.println("}");
	}
	
	private void generateForwardDecl() throws IOException {

		CodePrinter pr = null;
		
		if (isResultClass(serInfo) || isRequestClass(serInfo)) {
			pr = pctxt.prImplAllH;
		}
		else {
			pr = pctxt.prApiFwdH;
		}
		
		if (pr != null) {
			
			String className = cppInfo.getClassName(serInfo.pack);
			String pclassName = cppInfo.getTypeName(serInfo.pack);

			pr.println();
			pctxt.printLine(pr);
			pr.print("// Forward Declaration of class ").println(className);
			pr.println();
			
			pr.println(cppInfo.namespaceBegin);
			pr.println();
			pr.print("class ").print(className).println("; ");
			pr.print("typedef byps_ptr< ").print(className).print(" > ").print(pclassName).println("; ");
			pr.println();
			pr.print(cppInfo.namespaceEnd);
			pr.println();
		}
		
	}
	
	private void beginClass(CodePrinter pr, String className) throws IOException {
		pr.println();
		pctxt.printLine(pr);
		pr.print("// Class ").println(className);
		pr.println();

		pr.print(cppInfo.namespaceBegin).println();
		pr.println();
	}
	
	private void endClass(CodePrinter pr) throws IOException {
		pr.println();
		pr.println(cppInfo.namespaceEnd);
	}
	
	private void generate() throws IOException {
		
		generateForwardDecl();
		
		String className = cppInfo.getClassName(serInfo.pack);
		
		beginClass(prH, className);
		prH.println("using namespace std;");
		prH.println("using namespace com::wilutions::byps;");
		prH.println();

		beginClass(prC, className);

		printComments(serInfo.comments);
		
		//pr.println("@SuppressWarnings(\"serial\")");

		{
			CodePrinter mpr = prH.print("class ").print(className);
			if (isResultClass()) {
				String rtype = pctxt.getReturnType(methodInfo, serInfo.pack);
				if (!rtype.equals("void")) {
					String baseClass = "BMethodResult< " + rtype + ", " + serInfo.typeId + " >";
					mpr.print(" : public ").print(baseClass);
				}
			}
			else if (isRequestClass()) {
				mpr.print(" : public BMethodRequest< " + serInfo.typeId + " >");
			}
			else 
			{
				if (baseCppInfo != null) {
					mpr.print(" : public ").print(baseCppInfo.getClassName(serInfo.pack));
				}
				else {
					mpr.print(" : public BSerializableT<" + serInfo.typeId + ">");
				}
			}
			
			mpr.println(" {");
			prH.println();
		}
		
		prH.beginBlock();
		
		if (!isResultClass()) {
			for (MemberInfo minfo : serInfo.members) {
				printMember(minfo);
			}
			prH.println();
		}
		else {} // Result Klasse erbt Element result von BMethodResult
		
		if (!isResultClass() && !isRequestClass()) {
			printConstructors();
		}
		
		printDestructors();

		if (isRequestClass()) {
			printRemoteId();
		}
		
		for (MemberInfo minfo : serInfo.members) {
			printGetSet(minfo);
		}
		
		TypeInfoCpp stinfoCpp = TypeInfoCpp.makeSerializerTypeInfoCpp(pctxt, serInfo);
		prH.print("private: friend class ").print(stinfoCpp.getClassName(serInfo.pack)).println(";");
		
		prH.endBlock();
		prH.println("};");

		endClass(prH);
		endClass(prC);

	}

	private static boolean isResultClass(SerialInfo serInfo) {
		return serInfo.name.startsWith(MethodInfo.METHOD_RESULT_NAME_PREFIX);
	}

	private static boolean isRequestClass(SerialInfo serInfo) {
		return serInfo.name.startsWith(MethodInfo.METHOD_REQUEST_NAME_PREFIX);
	}

	private boolean isResultClass() {
		return isResultClass(serInfo);
	}

	private boolean isRequestClass() {
		return isRequestClass(serInfo);
	}

	private final SerialInfo serInfo;
	private final TypeInfoCpp cppInfo;
	private final TypeInfoCpp baseCppInfo;
	private final CodePrinter prH;
	private final CodePrinter prC;
	
	private final MethodInfo methodInfo;
	private final PrintContext pctxt;
}
