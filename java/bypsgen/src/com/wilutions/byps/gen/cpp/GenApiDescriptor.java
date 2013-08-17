package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenApiDescriptor {
	static Log log = LogFactory.getLog(GenApiDescriptor.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		new GenApiDescriptor(pctxt, apiDesc).generate();
		log.debug(")generate");
	}

	private GenApiDescriptor(PrintContext pctxt, BApiDescriptor apiDesc) {
		this.pctxt = pctxt;
		this.apiDesc = apiDesc;
	
		String className  = pctxt.getApiDescriptorClassName();
		TypeInfo tinfo = new TypeInfo(className, pctxt.apiPack + "." + className, "", null, false, false, false);
		this.cppInfo = new TypeInfoCpp(tinfo);
		
		this.prH = pctxt.getPrApiAllH();
		this.prC = pctxt.getPrImplC();
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		prH.println(cppInfo.namespaceBegin);
		prC.println(cppInfo.namespaceBegin);
		
		prH.println("using namespace ::com::wilutions::byps;");
		prH.println();
		prC.println();
		
		prH.print("class ").print(cppInfo.tinfo.name).print(" { ").println();
		prH.beginBlock();
		
		printStaticMembers();
		
		printInstance();
		
		prH.endBlock();
		
		prH.println("};");
		prH.println();

		prH.println(cppInfo.namespaceEnd);
		prC.println(cppInfo.namespaceEnd);
		prH.println();
		prC.println();
		
		log.debug(")generate");
	}
	
	private void printStaticMembers() {
		log.debug("printStaticMembers");
		
		prH.print("public: const static int32_t VERSION = " + apiDesc.version + ";").println();

		log.debug(")printStaticMembers");
	}

	private void printInstance() {
		log.debug("printInstance");
		
		prH.print("public: static PApiDescriptor instance();").println();
		
		String className = cppInfo.tinfo.name;
		prC.print("PApiDescriptor ").print(className).print("::instance() {").println();
		prC.beginBlock();
		prC.println("return PApiDescriptor((new BApiDescriptor(");
		prC.println("\"" + apiDesc.name + "\",");
		prC.println("\"" + apiDesc.basePackage + "\",");
		prC.println("VERSION,");
		prC.println(apiDesc.uniqueObjects + ")) // uniqueObjects");
		prC.print("->addRegistry(PRegistry(new ").print(pctxt.getRegistryClassName(BBinaryModel.MEDIUM)).println("()))");
		prC.println(");");
		prC.endBlock();
		prC.println("};");
		prC.println();

		log.debug(")printInstance");
	}
	
//	private void printCreateRemotes() {
//		log.debug("printCreateRemotes");
//		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
//			printCreateRemote(rinfo);
//			pr.println();
//		}
//		log.debug(")printCreateRemotes");
//	}

//	private void printCreateRemote(RemoteInfo rinfo) {
//		log.debug("printCreateRemote");
//		pr.print("public static ").print(rinfo.toString(pack)).print(" create").print(rinfo.name)
//			.print("(BWire wire) {").println();
//		pr.beginBlock();
//		pr.println("final BTransport trans = new BTransport(instance, wire);");
//		
//		String stubClassName = pctxt.getStubClassQName(rinfo, pack);
//		pr.print("return new ").print(stubClassName).print("(trans);").println();
//		
//		pr.endBlock();
//		pr.println("}");
//		log.debug(")printCreateRemote");
//		
//	}
	
	private CodePrinter prH;
	private CodePrinter prC;
	private BApiDescriptor apiDesc;
	private PrintContext pctxt; 
	private TypeInfoCpp cppInfo;

	
}


/*
public BSerializer getByClassName(Object obj) {
Class<?> clazz = obj.getClass();
if (clazz == Alpha.class) return com.wilutions.byps.example.api.BSerializer_132.instance;
if (clazz == int[].class)return  

return null;
}
*/