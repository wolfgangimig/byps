package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
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
		TypeInfoCpp returnTypeInfoCpp = new TypeInfoCpp(returnInfo.type);
		String rtype = returnTypeInfoCpp.getTypeName(rinfo.pack);
		if (returnTypeInfoCpp.tinfo.isVoidType()) rtype = "bool";
		
		String syncResultType = "BSyncResultT<" + rtype + " >";
		//prC.print("byps_ptr<").print(syncResultType).print(" > asyncResult(new ")
//		prC.print(syncResultType).print("* asyncResult(new ")
//		   .print(syncResultType).print("());");^
		prC.print(syncResultType).print(" syncResult;");
		prC.println();

		String methodName = pctxt.makePublicMemberName(methodInfo.name);
		CodePrinter mpr = prC.print("async_").print(methodName).print("(");
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.name);
		}
		if (!first) mpr.print(", ");
		
		if (pctxt.lambdaSupported) {
			mpr.print("[&syncResult](").print(rtype).println(" v, BException ex) {");
			prC.beginBlock();
			prC.println("syncResult.setAsyncResult(v, ex);");
			prC.endBlock();
			prC.println("});");
		}
		else {
			mpr.println("&syncResult);");
		}

		boolean hasOwnExceptions = methodInfo.exceptions.size() != 0;
		if (hasOwnExceptions) {
			prC.println("try {");
			prC.beginBlock();
		}
	

		if (returnInfo.type.isVoidType()) {
			prC.println("syncResult.getResult();");
		}
		else {
			prC.println("return syncResult.getResult();");

//			prC.println("const BVariant& result = asyncResult->getResult();");
//			String rclass = returnTypeInfoCpp.getClassName(rinfo.pack);
//			if (returnInfo.type.isInheritable()) {
//				prC.println("PSerializable sret;");
//				prC.println("result.get(sret);");
//				prC.print(rtype).print(" ret = byps_ptr_cast<").print(rclass).println(">(sret);");
//			}
//			else if (returnInfo.type.isPointerType()) {
//				prC.println("POBJECT oret;");
//				prC.println("result.get(oret);");
//				prC.print(rtype).print(" ret = byps_static_ptr_cast<").print(rclass).println(">(oret);");
//			}
//			else {
//				prC.print(rtype).print(" ret = ").print(rtype).println("();");
//				prC.println("result.get(ret);");
//			}
//			prC.println("return ret;");
		}
		
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
	
//	private void printMethodAsyncResult(MethodInfo methodInfo) throws IOException {
//		String className = "BAsyncResult_" + rinfo.name + "_" + methodInfo.name;
//		String resultClassName = pctxt.ge
//		String rtypeName = pctxt.getReturnTypeName(methodInfo);
//		String rfnctType = "std::function< void (" + rtypeName + " >, BException ex) >";
//		prC.print("class ").print(className).print(" : public BAsyncResult").println(" {");
//		prC.beginBlock();
//		prC.print(rfnctType).print(" innerResult;").println();
//		prC.print("public: ").print(className).print("(").print(rfnctType).print(" innerResult) : innerResult(innerResult) {}").println();
//		prC.print("public: virtual void setAsyncResult(const BVariant& methodResult) {").println();
//		prC.beginBlock();
//		prC.print(rtypeName).print(" v = ").print(rtypeName).println("();");
//		prC.print("if (!methodResult.isException()) {");
//		prC.beginBlock();
//		prC.println("PSerializable sobj;");
//		prC.println("methodResult.get(sobj);");
//		
//	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		pctxt.printDeclareMethodAsync(prH, rinfo, methodInfo, EMethodDecl.Header).println(";");
	
		pctxt.printDeclareMethodAsync(prC, rinfo, methodInfo, EMethodDecl.StubImpl).println(" {");
		prC.beginBlock();
		
		TypeInfoCpp requestCppInfo = new TypeInfoCpp(methodInfo.requestInfo);
		String requestClass = requestCppInfo.getClassName(rinfo.pack);
		
		CodePrinter mpr = prC.print("PSerializable req(new ").print(requestClass).print("(");
		
		if (methodInfo.requestInfo.members.size() != 0) {
			boolean first = true;
			for (MemberInfo pinfo : methodInfo.requestInfo.members) {
				if (first) first = false; else mpr = mpr.print(", ");
				mpr = mpr.print(pinfo.name);
			}
		}
		
		mpr.println("));");
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		
		if (pctxt.lambdaSupported) {

			TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type);
			String outerAsyncClass = "";
			String rtype = "bool";
			if (!isReturnVoid) {
				rtype = tinfoCpp.toString(rinfo.pack);
			}
			
			String resultClassName = MethodInfo.METHOD_RESULT_NAME_PREFIX + tinfoCpp.tinfo.typeId;
			
			outerAsyncClass = "BAsyncResultReceiveMethodL< " + rtype + ", " + resultClassName + " >";
						
			prC.print("PAsyncResult outerResult( new ")
			   .print(outerAsyncClass).print("(asyncResult) );").println();
			
			prC.println("transport->send(req, outerResult);");
		}
		else {
			String outerAsyncClass = "BAsyncResultReceiveMethod";
			prC.print("PAsyncResult outerResult( new ")
			   .print(outerAsyncClass).print("(asyncResult) );").println();
			
			prC.println("transport->send(req, outerResult);");
		}
		
		prC.endBlock();
		
		prC.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void printSerializer() {		
		String className = pctxt.getStubTypeInfoCpp(rinfo).getQClassName();
		String remoteClassName = new TypeInfoCpp(rinfo).getQClassName();
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		prC.print("void ").print("BSerializer_" + rinfo.typeId)
			.print("(BIO& bio, POBJECT& , PSerializable& pObjS, void* )").println("{");
		prC.beginBlock();
		
		prC.println("BSerializable* p = pObjS.get();");
		
		prC.println("if (bio.is_loading) {");
		prC.beginBlock();
		prC.println("if (p) return;");
		prC.println("BTargetId targetId;");
		prC.println("bio & targetId;");
		prC.println("PTransport transport(new BTransport(*bio.transport, targetId));");
		prC.print("pObjS = PSerializable(new ").print(className).print("(transport));").println();
		prC.endBlock();
		prC.println("}");
		prC.println("else {");
		prC.beginBlock();
		prC.print(remoteClassName).print("* r = ").print("dynamic_cast<").print(remoteClassName).print("*>(p);").println();
		prC.println("BTargetId targetId = r->BRemote_getTargetId();");
		prC.println("bio & targetId;");
		prC.endBlock();
		prC.println("}");
		
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
		prH.println("using namespace ::com::wilutions::byps;");
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
		
		pctxt.print_BSerializable_getTypeId(rinfo, prH);
		
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
