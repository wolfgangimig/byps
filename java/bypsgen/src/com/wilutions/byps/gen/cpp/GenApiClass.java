package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
			pctxt.printComments(prH, minfo.comments);
			
			String access = accessToString(minfo.access);
			String f = minfo.isFinal ? "final " : "";
			String s = minfo.isStatic ? "static " : "";
			String t = ""; // minfo.isTransient is unsupported by C++
			
			TypeInfoCpp cppMInfo = new TypeInfoCpp(minfo.type);
			String typeName = cppMInfo.toString(serInfo.pack);
	
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
			
			if (isResultClass(serInfo)) {
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
				return mtinfoCpp.namespace + "::" + enumInfo.members.get(0).name;
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
		
		prH.print("public: ").print(serInfo.name).println("();");
		
		// Default constructor
		prC.print(qname).print("::").print(serInfo.name).println("() {");
		prC.beginBlock();
		for (MemberInfo minfo : serInfo.members) {
			String defaultValue = getDefaultValue(minfo.type);
			if (defaultValue == null) continue;
			prC.print(minfo.name).print(" = ").print(defaultValue).println(";");
		}
		prC.endBlock();
		prC.println("}");

		// Constructor with initializer list
		if (serInfo.members.size() != 0) {
			boolean first = true;
			StringBuilder sbuf = new StringBuilder();
			sbuf.append(serInfo.name).append("(");
			for (MemberInfo minfo : serInfo.members) {
				if (first) first = false; else sbuf.append(", ");
				TypeInfoCpp mtinfoCpp = new TypeInfoCpp(minfo.type);
				sbuf.append(mtinfoCpp.toString(serInfo.pack)).append(" ").append(minfo.name);
			}
			sbuf.append(")");
			
			prH.print("public: ").print(sbuf.toString()).println(";");
			prC.print(qname).print("::").print(sbuf.toString()).println(" {");
			
			prC.beginBlock();
			for (MemberInfo minfo : serInfo.members) {
				prC.print("this->").print(minfo.name).print(" = ").print(minfo.name).println(";");
			}
			prC.endBlock();
			prC.println("}");
		}
		
	}

	private void printDestructor() throws IOException {
		String qname = cppInfo.getQClassName();
		prH.print("public: virtual ~").print(serInfo.name).println("() throw();");
		prC.print(qname).print("::~").print(serInfo.name).println("() throw() {");
		prC.println("}");
	}
	
	private void generateEnum() throws IOException
	{
		String className = cppInfo.getClassName(serInfo.pack);
		
		beginClass(prH, className);
		prH.println();

		pctxt.printComments(prH, serInfo.comments);
		
		prH.print("enum ").print(className).println(" {");
		
		prH.beginBlock();
		
		for (MemberInfo minfo : serInfo.members) {
			pctxt.printComments(prH, minfo.comments);
			prH.print(minfo.name).print(" = ").print(minfo.value).println(",");
		}
		
		prH.println();
		
		prH.endBlock();
		prH.println("};");

		endClass(prH);
	}
	
	private void beginClass(CodePrinter pr, String className) throws IOException {
		pr.println();
		pctxt.printLine(pr);
		pr.print("// ").println(className);
		pr.println();

		pr.print(cppInfo.namespaceBegin).println();
		pr.println();
	}
	
	private void endClass(CodePrinter pr) throws IOException {
		pr.println();
		pr.println(cppInfo.namespaceEnd);
	}
	
	private void generate() throws IOException {
		if (serInfo.isEnum) {
			generateEnum();
		}
		else {
			generateClass();
		}
	}
	
	private void generateClass() throws IOException {
		
		String className = cppInfo.getClassName(serInfo.pack);
		
		beginClass(prH, className);
		prH.println("using namespace com::wilutions::byps;");
		prH.println();

		pctxt.printComments(prH, serInfo.comments);
		
		//pr.println("@SuppressWarnings(\"serial\")");

		{
			CodePrinter mpr = prH.print("class ").print(className);
			if (isResultClass(serInfo)) {
				String rtype = pctxt.getReturnType(methodInfo, serInfo.pack);
				if (rtype.equals("void")) rtype = "bool";
				String baseClass = "BMethodResult< " + rtype + ", " + serInfo.typeId + " >";
				mpr.print(" : public ").print(baseClass);
			}
			else if (isRequestClass(serInfo)) {
				int remoteId = methodInfo.remoteInfo.typeId;
				mpr.print(" : public BMethodRequestT< " + serInfo.typeId + ", " + remoteId + " >");
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
		}
		
		prH.beginBlock();
		
		if (!isResultClass(serInfo)) {
			for (MemberInfo minfo : serInfo.members) {
				printMember(minfo);
			}
		}
		else {} // Result Klasse erbt Element result von BMethodResult
		
		if (!isResultClass(serInfo) && !isRequestClass(serInfo)) {
			printConstructors();
		}
		
		printDestructor();

		for (MemberInfo minfo : serInfo.members) {
			printGetSet(minfo);
		}
		
		TypeInfoCpp stinfoCpp = TypeInfoCpp.makeSerializerTypeInfoCpp(pctxt, serInfo);
		prH.print("private: friend class ").print(stinfoCpp.getClassName(serInfo.pack)).println(";");
		
		prH.endBlock();
		prH.println("};");

		endClass(prH);
		
	}

	public static boolean isResultClass(TypeInfo serInfo) {
		return serInfo.name.startsWith(MethodInfo.METHOD_RESULT_NAME_PREFIX);
	}

	public static boolean isRequestClass(TypeInfo serInfo) {
		return serInfo.name.startsWith(MethodInfo.METHOD_REQUEST_NAME_PREFIX);
	}

	private final SerialInfo serInfo;
	private final TypeInfoCpp cppInfo;
	private final TypeInfoCpp baseCppInfo;
	private final CodePrinter prH;
	private final CodePrinter prC;
	
	private final MethodInfo methodInfo;
	private final PrintContext pctxt;
}
