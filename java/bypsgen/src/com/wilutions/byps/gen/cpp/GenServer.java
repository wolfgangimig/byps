package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenServer {
	static Log log = LogFactory.getLog(GenServer.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		new GenServer(pctxt, apiDesc).generate();
		log.debug(")generate");
	}


	private GenServer(PrintContext pctxt, BApiDescriptor apiDesc) {
		this.pctxt = pctxt;
		this.clientCppInfo = pctxt.getServerTypeInfoCpp();
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
		
		prH.print("class ").print(className).println(" : public BServer { ");
		prH.println();
		
		prH.beginBlock();
		
		printCreate(true);
		prH.println();
		
		printCreate(false);
		prH.println();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			printAddRemote(rinfo);
		}
		
		printConstructorWithClientR();
		prH.println();
		
		printConstructorWithoutClientR();
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
			prH.print("public: static ").print(typeName).println(" createServer(PTransportFactory transportFactory);");
			
			prC.print(typeName).print(" ").print(className).print("::").println("createServer(PTransportFactory transportFactory) {");
			prC.beginBlock();
			prC.print("return ").print(typeName).print("(new ").print(className).println("(transportFactory));");
			prC.endBlock();
			prC.println("}");
		}
		else {
			prH.print("public: static ").print(typeName).println(" createServerR(PTransport transport);");
			
			prC.print(typeName).print(" ").print(className).print("::").println("createServerR(PTransport transport) {");
			prC.beginBlock();
			prC.print("return ").print(typeName).print("(new ").print(className).println("(transport));");
			prC.endBlock();
			prC.println("}");
		}

	}

	private void printConstructorWithoutClientR() {
		String className = clientCppInfo.getClassName(pack);

		prH.print("protected: ").print(className).println("(PTransport transport); ");
		
		prC.print(className).print("::").print(className).println("(PTransport transport) ");
		prC.beginBlock();
		prC.println(": BServer(transport, NULL)");
		
		prC.println("{");
		
		prC.endBlock();
		prC.println("}");
	}
	
	private void printConstructorWithClientR() {
		
		String className = clientCppInfo.getClassName(pack);
		String clientClassName = pctxt.getClientTypeInfoCpp().getClassName(pack);

		prH.print("protected: ").print(className).println("(PTransportFactory transportFactory); ");
		
		prC.print(className).print("::").print(className).println("(PTransportFactory transportFactory) ");
		prC.beginBlock();
		prC.println(": BServer(");
		prC.beginBlock();
		prC.println("transportFactory->createServerTransport(), ");
		prC.println("transportFactory->createClientR(");
		prC.beginBlock();
		prC.println(clientClassName + "::createClientR(transportFactory->createClientTransport())");
	
		prC.endBlock();
		prC.println(")");
		prC.endBlock();
		prC.println(")");

		prC.println("{");
		
		prC.endBlock();
		prC.println("}");

	}
	
	private void printAddRemote(RemoteInfo rinfo) {
	  if (rinfo.isClientRemote) {
  		TypeInfoCpp skeletonInfoCpp = pctxt.getSkeletonTypeInfoCpp(rinfo);
  		String typeName = skeletonInfoCpp.getTypeName(pack);
  		prH.print("public: void ").print("addRemote(").print(typeName).println(" remoteSkeleton);");
  		prH.println();
  		
  		prC.print("void ").print(clientCppInfo.getClassName(pack)).print("::addRemote(").print(typeName).println(" remoteSkeleton) {");
  		prC.beginBlock();
  		prC.println("BServer::addRemote(" + rinfo.typeId + ", remoteSkeleton);");
  		prC.endBlock();
  		prC.println("}");
  		prC.println();
	  }
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