package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;
import com.wilutions.byps.gen.utils.Utils;

   
public class GenClient {
	static Log log = LogFactory.getLog(GenClient.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		new GenClient(pctxt, apiDesc).generate();
		log.debug(")generate");
	}


	private GenClient(PrintContext pctxt, BApiDescriptor apiDesc) {
		this.pctxt = pctxt;
		this.clientCppInfo = pctxt.getClientTypeInfoCpp();
		this.pack = pctxt.getApiDescriptorPackage();
		this.prH = pctxt.getPrApiAllH();
		this.prC = pctxt.getPrImplC();
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		String className = clientCppInfo.getClassName(pack);
		
		prH.print(clientCppInfo.namespaceBegin).println();
		prH.println();
		prC.print(clientCppInfo.namespaceBegin).println();
		prC.println();
		
		prH.println("using namespace ::com::wilutions::byps;");
		prH.println();
		
		prH.print("class ").print(className).println(";");
		prH.print("typedef byps_ptr<").print(className).print("> ")
		   .print(clientCppInfo.getTypeName(pack)).println(";");
		prH.println();
		
		prH.print("class ").print(className).println(" : public BClient { ");
		prH.println();
		
		prH.beginBlock();
		
		printCreate(true);
		prH.println();
		
		printCreate(false);
		prH.println();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			printAddRemote(rinfo);
			prH.println();
		}
		
		printConstructorWithServerImpl();
		prH.println();
		
		printConstructorWithoutServerR();
		prH.println();
		
		printGetStub();
		prH.println();
		
		printDefineStubs();
		prH.println();
		
		prH.endBlock();
		prH.println("};");
		prH.println();
		
		prH.print(clientCppInfo.namespaceEnd).println();
		prH.println();
		prC.print(clientCppInfo.namespaceEnd).println();
		prC.println();

		log.debug(")generate");
	}

	private void printCreate(boolean withServerR) {
		String className = clientCppInfo.getClassName(pack);
		String typeName = clientCppInfo.getTypeName(pack);
		
		if (withServerR) {
			prH.print("public: static ").print(typeName).println(" createClient(PTransportFactory transportFactory);");
			
			prC.print(typeName).print(" ").print(className).print("::").println("createClient(PTransportFactory transportFactory) {");
			prC.beginBlock();
			prC.print("return ").print(typeName).print("(new ").print(className).println("(transportFactory));");
			prC.endBlock();
			prC.println("}");
		}
		else {
			prH.print("public: static ").print(typeName).println(" createClientR(PTransport transport);");
			
			prC.print(typeName).print(" ").print(className).print("::").println("createClientR(PTransport transport) {");
			prC.beginBlock();
			prC.print("return ").print(typeName).print("(new ").print(className).println("(transport));");
			prC.endBlock();
			prC.println("}");
		}

	}

	private void printConstructorWithoutServerR() {
		String className = clientCppInfo.getClassName(pack);

		prH.print("protected: ").print(className).println("(PTransport transport); ");
		
		prC.print(className).print("::").print(className).println("(PTransport transport) ");
		prC.beginBlock();
		prC.println(": BClient(transport, NULL)");
		
		printInitStubMembers();
		
		prC.println("{");
		
		prC.endBlock();
		prC.println("}");
	}
	
	private void printInitStubMembers() {
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			TypeInfoCpp stubInfoCpp = pctxt.getStubTypeInfoCpp(rinfo);
			String stubClassName  = stubInfoCpp.getClassName(pack);
			String varName = Utils.firstCharToLower(rinfo.name);
			prC.print(", ").print(varName).print("(new ").print(stubClassName).println("(transport))");
		}
	}
	
	private void printConstructorWithServerImpl() {
		
		String className = clientCppInfo.getClassName(pack);
		String serverClassName = pctxt.getServerTypeInfoCpp().getClassName(pack);

		prH.print("protected: ").print(className).println("(PTransportFactory transportFactory); ");
		
		prC.print(className).print("::").print(className).println("(PTransportFactory transportFactory) ");
		prC.beginBlock();
		prC.println(": BClient(");
		prC.beginBlock();
		prC.println("transportFactory->createClientTransport(), ");
		prC.println("transportFactory->createServerR(");
		prC.beginBlock();
		prC.println(serverClassName + "::createServerR(transportFactory->createServerTransport())");
	
		prC.endBlock();
		prC.println(")");
		prC.endBlock();
		prC.println(")");

		printInitStubMembers();
		
		prC.println("{");
		
		prC.endBlock();
		prC.println("}");

	}
	
	private void printDefineStubs() {
		log.debug("printDefineStubs");
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			TypeInfoCpp rinfoCpp = new TypeInfoCpp(rinfo);
			String varName = Utils.firstCharToLower(rinfo.name);
			String rinfoName = rinfoCpp.getQTypeName();
			prH.print("public: const ").print(rinfoName).print(" ").print(varName).println(";");
		}
		log.debug(")printDefineStubs");
	}

	private void printAddRemote(RemoteInfo rinfo) {
		TypeInfoCpp skeletonInfoCpp = pctxt.getSkeletonTypeInfoCpp(rinfo);
		String typeName = skeletonInfoCpp.getTypeName(pack);
		prH.print("public: void ").print("addRemote(").print(typeName).println(" remoteSkeleton);");
		
		prC.print("void ").print(clientCppInfo.getClassName(pack)).print("::addRemote(").print(typeName).println(" remoteSkeleton) {");
		prC.beginBlock();
		prC.println("if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L\"No reverse connections.\");");
		prC.println("serverR->server->addRemote(" + rinfo.typeId + ", remoteSkeleton);");
		prC.endBlock();
		prC.println("}");
	}


	private void printGetStub() {
		
		prH.println("public: virtual PRemote getStub(int remoteId);");
		
		prC.print("PRemote ").print(clientCppInfo.getClassName(pack)).println("::getStub(int remoteId) {");
		prC.beginBlock();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			String varName = Utils.firstCharToLower(rinfo.name);
			prC.println("if (remoteId == " + rinfo.typeId + ") return " + varName + ";");
		}
		
		prC.println("return PRemote();");
		prC.endBlock();
		prC.println("}");
	}

	private CodePrinter prH;
	private CodePrinter prC;
	private String pack;
	private PrintContext pctxt; 
	private TypeInfoCpp clientCppInfo;
	
}


/*
public BSerializer getByClassName(Object obj) {
Class<?> clazz = obj.getClass();
if (clazz == Alpha.class) return com.wilutions.byps.example.api.BSerializer_132.instance;
if (clazz == int[].class)return  

return null;
}
*/