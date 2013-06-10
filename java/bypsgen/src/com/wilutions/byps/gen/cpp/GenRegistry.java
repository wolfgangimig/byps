package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenRegistry {
	static Log log = LogFactory.getLog(GenRegistry.class);
	
	static void generate(PrintContext pctxt, Iterable<SerialInfo> serInfos, BBinaryModel pformat) throws IOException {
		log.debug("generate");
		new GenRegistry(pctxt, serInfos, pformat).generate();
		log.debug(")generate");
	}

	private GenRegistry(PrintContext pctxt, Iterable<SerialInfo> serInfos, BBinaryModel pformat) throws IOException {
		this.pctxt = pctxt;
		this.serInfos = serInfos;
		this.registryClassName = pctxt.getRegistryClassName(pformat);
		this.pack = pctxt.getRegistryPackage();
		this.pformat = pformat;
		prH = pctxt.getPrApiAllH();
		prCpp = pctxt.getPrImplCForRegistry();
		regCppInfo = pctxt.getRegistryTypeInfoCpp(pformat);
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		prH.println();
		pctxt.printLine(prH);
		
		prH.print(regCppInfo.namespaceBegin).println();
		prH.println();
		
		prH.print("class ").print(registryClassName).println(" : public BRegistry { ");
		prH.print("public:").println();
		prH.beginBlock();
		
		prH.print(registryClassName).println("();");
		prH.print("virtual ~").print(registryClassName).println("() {}");
		
		printRegisterClasses();
		
		prH.endBlock();
		
		prH.println("};");
		prH.println();
		
		prH.print(regCppInfo.namespaceEnd).println();
		prH.println();
		
		printDeclareSerializer(pctxt.getPrImplAllH());
		
		log.debug(")generate");
	}
	
	private void printRegisterClasses()
			throws BException {
		CodePrinter pr = prCpp;
		
		pctxt.printLine(prCpp);
		pr.print("// Registry ").println();
		pr.println();
		
		String qname = regCppInfo.getQClassName();
		pr.print(qname).print("::").print(registryClassName).println("()");
		
		pr.println("{");
		pr.beginBlock();
		for (SerialInfo serInfo : serInfos) {
			
			if (serInfo.isBuiltInType()) continue;
			if (!serInfo.isPointerType()) continue;
			
			TypeInfoCpp cppSerInfo = new TypeInfoCpp(serInfo);
			
			String qtype = cppSerInfo.getQClassName();
			pr.print("registerClass(typeid(").print(qtype).print(")")
			  .print(", ").print(regCppInfo.namespace).print("::BSerializer_" + serInfo.typeId)
			  .print(", " + serInfo.typeId)
			  .println(");");
			
		}
		
		pr.endBlock();
		pr.println("}");
	}
	
	private void printDeclareSerializer(CodePrinter pr) {
		
		pr.println();
		pr.print(regCppInfo.namespaceBegin).println();
		pr.println();

		for (SerialInfo serInfo : serInfos) {
			
			if (serInfo.isBuiltInType()) continue;
			if (!serInfo.isPointerType()) continue;
			
			pr.print("// Serializer for ").print(serInfo.toString()).println();
			pr.print("void ").print("BSerializer_" + serInfo.typeId)
			.print("(BIO& bio, POBJECT& pObj, void* pBase)").println(";");

		}
		
		pr.println();
		pr.print(regCppInfo.namespaceEnd).println();
		pr.println();
	}

	private Iterable<SerialInfo> serInfos;
	private TypeInfoCpp regCppInfo;
	private CodePrinter prH;
	private CodePrinter prCpp;
	private String pack;
	private String registryClassName;
	private PrintContext pctxt; 
	private final BBinaryModel pformat;
}
