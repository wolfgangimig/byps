package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.cpp.PrintContext.EMethodDecl;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteStub {
	
	static Log log = LogFactory.getLog(GenRemoteStub.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		new GenRemoteStub(pctxt, rinfo).generate();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	private GenRemoteStub(PrintContext pctxt, RemoteInfo rinfo) {
		this.pctxt = pctxt;
		this.cppInfo = new TypeInfoCpp(rinfo);
		this.baseCppInfo = cppInfo.getBaseInfo();
		this.prH = pctxt.getPrApiAllH();
		this.prC = pctxt.getPrImplC();
		this.rinfo = rinfo;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pctxt.printDeclareMethod(prH, rinfo, methodInfo, EMethodDecl.Header).println(";");
		
		pctxt.printDeclareMethod(prC, rinfo, methodInfo, EMethodDecl.StubImpl).println(" {");
		
		prC.beginBlock();
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		String rtype = null;
		if (isReturnVoid) {
			rtype = "bool";
		}
		else {
			TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type);
			rtype = tinfoCpp.toString(rinfo.pack);
		}
		
		String asyncResultType = "byps_ptr< BSyncResult<" + rtype + " > >";
		prC.print(asyncResultType).print(" asyncResult(new BSyncResult<" + rtype + " >());");
		prC.println();

		String methodName = pctxt.makePublicMemberName(methodInfo.name);
		CodePrinter mpr = prC.print("async_").print(methodName).print("(");
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
			prC.println("try {");
			prC.beginBlock();
		}
		
		mpr = prC;
		if (!methodInfo.resultInfo.members.get(0).type.isVoidType()) {
			mpr = prC.print("return ");
		}
		mpr.print("asyncResult->getResult();");
		prC.println();

		if (hasOwnExceptions) {
			prC.endBlock();
			prC.println("} ");
			prC.println("catch (const BException& e) {");
			prC.beginBlock();
//			prC.println("Exception cause = e.GetBaseException();");
//			prC.println("if (cause != null) {");
//			prC.beginBlock();
//			for (TypeInfo exInfo : methodInfo.exceptions) {
//				String exName = exInfo.toString(rinfo.pack);
//				prC.print("if (cause is ").print(exName).print(") throw (").print(exName).print(")cause;").println();
//			}
//			prC.endBlock();
//			prC.println("}");
			prC.println("throw e;");
			prC.endBlock();
			prC.println("}");
		}
		
		prC.endBlock();
		prC.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		pctxt.printDeclareMethodAsync(prH, rinfo, methodInfo, EMethodDecl.Header).println(";");
		
		pctxt.printDeclareMethodAsync(prC, rinfo, methodInfo, EMethodDecl.StubImpl).println(" {");
		prC.beginBlock();
		
		TypeInfoCpp requestCppInfo = new TypeInfoCpp(methodInfo.requestInfo);
		String requestClass = requestCppInfo.getClassName(rinfo.pack);
		String requestType = requestCppInfo.getTypeName(rinfo.pack);
		prC.print(requestType).print(" req(new ").print(requestClass).print("());");
		prC.println();
		
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			prC.print("req->").print(pinfo.name).print(" = ").print(pinfo.name).print(";").println();
		}
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		String rtype = null;
		if (isReturnVoid) {
			rtype = "bool";
		}
		else {
			TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type);
			rtype = tinfoCpp.toString(rinfo.pack);
		}
		
		String outerAsyncClass = "BAsyncResultReceiveMethod<" + rtype + " >";
		prC.print("PAsyncResult_PSerializable outerResult( new ")
		   .print(outerAsyncClass).print("(asyncResult) );").println();
		
		prC.println("transport->send(req, outerResult);");

		prC.endBlock();
		
		prC.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void printSerializer() {		
		String className = pctxt.getStubTypeInfoCpp(rinfo).getQClassName();
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		prC.print("POBJECT ").print("BSerializer_" + rinfo.typeId)
			.print("(BIO& bio, void* pObj)").println("{");
		prC.beginBlock();
		
		prC.print(className).print("* pStub = ").print("reinterpret_cast<").print(className).print("*>(pObj);").println();
		prC.print("return com::wilutions::byps::BSERIALIZER_BStub(bio, pStub, " + rinfo.typeId).println(");");
			
		prC.endBlock();
		prC.println("}");
		
		prC.println(regCppInfo.namespaceEnd);
	}

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		TypeInfoCpp stubCppType = pctxt.getStubTypeInfoCpp(rinfo);
		String className = stubCppType.getClassName(rinfo.pack);
		
		pctxt.printLine(prH);
		prH.print("// Stub class ").println(className);
		prH.println();
		prC.println();
		prH.println(cppInfo.namespaceBegin);
		prC.println(cppInfo.namespaceBegin);
		prH.println();
		prC.println();
		prH.println("using namespace com::wilutions::byps;");
		prH.println();
		
		prH.print("class ").print(className).println(";");
		prH.print("typedef byps_ptr<").print(className).print("> ").print(stubCppType.getTypeName(rinfo.pack)).println(";");
		prH.println();
		
		prH.print("class ").print(className)
			.print(" : public BStub, public ").print(rinfo.name)
			.print(" {");
		prH.println();
		
		prH.beginBlock();
		prH.println();
		
		printConstructor();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			printMethodAsync(minfo);
			prH.println();
		}
		
		prH.println();
		
		prH.endBlock();
		
		prH.println("};");
		
		prH.println(cppInfo.namespaceEnd);
		prH.println();
		prC.println(cppInfo.namespaceEnd);
		prC.println();
		
		printSerializer();
		
		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	private void printConstructor() {
		TypeInfoCpp stubCppType = pctxt.getStubTypeInfoCpp(rinfo);
		String className = stubCppType.getClassName(rinfo.pack);
		
		prH.print("public: ").print(className).print("(PTransport transport);");
		prH.println();
		prH.println();
		
		prC.print(className).print("::").print(className).println("(PTransport transport) ");
		prC.beginBlock();
		prC.print(": BStub(transport)").println(" {}");
		prC.endBlock();
		prC.println();
		
	}

	private final RemoteInfo rinfo;
	private final PrintContext pctxt;
	private TypeInfoCpp cppInfo;
	private TypeInfoCpp baseCppInfo;
	private CodePrinter prH;
	private CodePrinter prC;

	
}

/*
 * 
 *         public IAsyncResult BeginAdd(int a, int b, AsyncCallback callback, object state)
        {
            BAsyncProgModel<int> ret = new BAsyncProgModel<int>(callback, state);
            async_Add(a, b, ret);
            return ret;
        }

        public int EndAdd(IAsyncResult asyncResult)
        {
            return ((BAsyncProgModel<int>)asyncResult).Result;
        }

*/
