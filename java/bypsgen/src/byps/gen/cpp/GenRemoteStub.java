package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.BRegistry;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteStub {
	
	static Log log = LogFactory.getLog(GenRemoteStub.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		new GenRemoteStub(pctxt, rinfo).generate();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	private GenRemoteStub(PrintContext pctxt, RemoteInfo rinfo) throws GeneratorException {
		this.pctxt = pctxt;
		this.cppInfo = pctxt.getStubTypeInfoCpp(rinfo);
		this.baseCppInfo = cppInfo.getBaseInfo();
		this.prH = pctxt.getPrApiAllH();
		this.prC = pctxt.getPrImplC();
		
    this.rinfo = pctxt.getBaseRemoteForStub(rinfo);
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pctxt.printDeclareMethod(prH, null, rinfo, methodInfo).println(";");
		
		pctxt.printDeclareMethod(prC, cppInfo.getClassName(rinfo.pack), rinfo, methodInfo).println(" {");
		
		prC.beginBlock();
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		TypeInfoCpp returnTypeInfoCpp = new TypeInfoCpp(returnInfo.type, pctxt.apiPack);
		String rtype = returnTypeInfoCpp.getTypeName(rinfo.pack);
		if (returnTypeInfoCpp.tinfo.isVoidType()) rtype = "bool";
		
		String syncResultType = "BSyncResultT< " + rtype + " >";
		//prC.print("byps_ptr<").print(syncResultType).print(" > asyncResult(new ")
//		prC.print(syncResultType).print("* asyncResult(new ")
//		   .print(syncResultType).print("());");^
		prC.print(syncResultType).print(" syncResult;");
		prC.println();

		String methodName = pctxt.makePublicMemberName(methodInfo.name);
		CodePrinter mpr = prC.print(methodName).print("(");
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
		  
      // Skip authentication parameter
      if (pctxt.isSessionParam(rinfo, pinfo)) continue;
		  
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
		
		pctxt.printDeclareMethodAsync(prH, null, rinfo, methodInfo).println(";");
	
		pctxt.printDeclareMethodAsync(prC, cppInfo.getClassName(rinfo.pack), rinfo, methodInfo).println(" {");
		prC.beginBlock();
		
		TypeInfoCpp requestCppInfo = new TypeInfoCpp(methodInfo.requestInfo, pctxt.apiPack);
		String requestClass = requestCppInfo.getClassName(rinfo.pack);
		
		CodePrinter mpr = prC.print("PMethodRequest req(new ").print(requestClass).print("(");
		
		if (methodInfo.requestInfo.members.size() != 0) {
			boolean first = true;
			for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			  
	      // Skip authentication parameter
	      if (pctxt.isSessionParam(rinfo, pinfo)) continue;
			  
				if (first) first = false; else mpr = mpr.print(", ");
				mpr = mpr.print(pinfo.name);
			}
		}
		
		mpr.println("));");
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		
		if (pctxt.lambdaSupported) {

			TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type, pctxt.apiPack);
			String outerAsyncClass = "";
			String rtype = "bool";
			if (!isReturnVoid) {
				rtype = tinfoCpp.toString(rinfo.pack);
			}
			
			TypeInfoCpp resultClassCpp = new TypeInfoCpp(methodInfo.resultInfo, pctxt.apiPack);
			String resultClassName = resultClassCpp.getClassName(rinfo.pack);
			//MethodInfo.METHOD_RESULT_NAME_PREFIX + tinfoCpp.tinfo.typeId;
			
			outerAsyncClass = "BAsyncResultReceiveMethodL< " + rtype + ", " + resultClassName + " >";
						
			prC.print("PAsyncResult outerResult( new ")
			   .print(outerAsyncClass).print("(asyncResult) );").println();
			
			prC.println("transport->sendMethod(req, outerResult);");
		}
		else {
			String outerAsyncClass = "BAsyncResultReceiveMethod";
			prC.print("PAsyncResult outerResult( new ")
			   .print(outerAsyncClass).print("(asyncResult) );").println();
			
			prC.println("transport->sendMethod(req, outerResult);");
		}
		
		prC.endBlock();
		
		prC.println("}");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void printSerializer() {		
	  prC.checkpoint();
	  
		String className = cppInfo.getQClassName();
		
		TypeInfoCpp regCppInfo = pctxt.getRegistryTypeInfoCpp(BBinaryModel.MEDIUM);
		prC.println(regCppInfo.namespaceBegin);
		
		prC.print("void ").print("BSerializer_" + rinfo.typeId)
			.print("(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved)").println("{");
		prC.beginBlock();
		
		prC.print("BSerializer_16_Template<").print(className)
		  .print(", " + rinfo.typeId)
		  .println(">(bio, pObj, pObjS, reserved);");

		prC.endBlock();
		prC.println("}");
		
		prC.println(regCppInfo.namespaceEnd);
		prC.println();
    prC.flush();
	}

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		String className = cppInfo.getClassName(rinfo.pack);
		
		pctxt.printLine(prH);
		prH.print("// Stub class ").println(className);
		prH.println();
		prC.println();
		prH.println(cppInfo.namespaceBegin);
		prH.println();
		prC.println();
		prH.println("using namespace ::byps;");
		prH.println();
		
		prH.print("class ").print(className).println(";");
		prH.print("typedef byps_ptr<").print(className).print("> ").print(cppInfo.getTypeName(rinfo.pack)).println(";");
		prH.println();
		
		prH.print("class ").print(className)
			.print(" : public BStub, public virtual ").print(rinfo.name)
			.print(" {");
		prH.println();
		
		prH.beginBlock();
		prH.println();
		
		printConstructor();
		
		pctxt.print_BSerializable_getTypeId(rinfo, prH);
		
    HashMap<String, RemoteInfo> remotes = new HashMap<String, RemoteInfo>();
    pctxt.collectAllRemotesForStubOrSkeleton(rinfo, remotes);
    for (RemoteInfo r : remotes.values()) {
      printMethods(r);
    }
		
		prH.println();
		
		prH.endBlock();
		
		prH.println("};");
		
		prH.println(cppInfo.namespaceEnd);
		prH.println();

		
		printSerializer();
		
		//log.debug(GeneratorJ.class.getName(), "generate");
	}

  private void printMethods(RemoteInfo rinfoImpl) throws IOException {
    
    for (MethodInfo minfo : rinfoImpl.methods) {

      prC.println(cppInfo.namespaceBegin);

      printMethod(minfo);
      printMethodAsync(minfo);
      
      prC.println(cppInfo.namespaceEnd);
      prC.println();

      prC.flush();
    }
  }

	private void printConstructor() {
		String className = cppInfo.getClassName(rinfo.pack);

    prC.println(cppInfo.namespaceBegin);
		
		prH.print("public: ").print(className).print("(PTransport transport);");
		prH.println();
		prH.println();
		
		prC.print(className).print("::").print(className).println("(PTransport transport) ");
		prC.beginBlock();
		prC.print(": BStub(transport)").println(" {}");
		prC.endBlock();

    prC.println(cppInfo.namespaceEnd);
		prC.println();
		
		prC.flush();
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
