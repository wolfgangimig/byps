package com.wilutions.byps.gen.cpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;


public class GenSerClass {
	static Log log = LogFactory.getLog(GenSerClass.class);
	
	static void generate(PrintContext pctxt, SerialInfo serInfo) throws IOException {
		////log.debug(GenSerClass.class.getName(), "generate");
		//log.info("Generate type " + serInfo.typeId + ": " + serInfo);
		
		CodePrinter prH = null;
		CodePrinter prC = null;

		if (serInfo.isBuiltInType()) {
		}
		else if (serInfo.isCollectionType()) {
		}
		else if (serInfo.isArrayType()) {
			prH = pctxt.prImplAllH;
			prC = pctxt.prImplC;
		}
		else {
			prH = pctxt.prImplAllH;
			prC = pctxt.prImplC;
		}

		if (prH != null && prC != null) {
			new GenSerClass(prH, prC, pctxt, serInfo).generate();
		}
		
		//log.exiting(GenSerClass.class.getName(), "generate");
	}	
	
	private GenSerClass(CodePrinter prH, CodePrinter prC, PrintContext pctxt, SerialInfo serInfo) {
		////log.debug(GenSerClass.class.getName(), "generate");
		
		this.prH = prH;
		this.prC = prC;
		this.pctxt = pctxt;
		this.serInfo = serInfo;
		this.cppInfo = new TypeInfoCpp(serInfo);
		this.cppInfoBase = this.cppInfo.getBaseInfo();
		
		this.serializerName = pctxt.getSerializerClassName(serInfo, BBinaryModel.MEDIUM);
		this.baseSerializerName = serInfo.baseInfo != null ? pctxt.getSerializerClassName(serInfo.baseInfo, BBinaryModel.MEDIUM) : "";
		this.pack = pctxt.getSerializerPackage(serInfo);
		this.basePack = serInfo.baseInfo != null ? pctxt.getSerializerPackage(serInfo.baseInfo) : ""; 
		
		this.registry = pctxt.classDB.getRegistry();

		//log.exiting(GenSerClass.class.getName(), "generate");
	}
	
	private void generate() throws IOException {
		////log.debug(GenSerClass.class.getName(), "generate");
		
		generateClassDef();
		
		generateClassImpl();
		
		//log.exiting(GenSerClass.class.getName(), "generate");
	}
	
	private void generateClassDef() {
		////log.debug(GenSerClass.class.getName(), "generateClassDef");
		
		printCommentSerializerClass(prH);
		prH.println(TypeInfoCpp.makeBeginNamespace(pack));
		
		prH.println("using namespace com::wilutions::byps;");
		
		prH.print("class ").print(serializerName).print(" : public BSerializer {").println();
		prH.println("public:");
		prH.beginBlock();
		prH.print(serializerName).println("();");
		prH.print("virtual ~").print(serializerName).println("();");
		prH.print("virtual BLENGTH Size(void* pObj, const BBinaryModel& bmodel);").println();
		prH.print("virtual void Serialize(void* pObj, BIO& bio, int32_t version);").println();
		prH.print("virtual void* Create(BIO& bio);").println();
		prH.endBlock();
		prH.println("};");
		
		prH.println(TypeInfoCpp.makeEndNamespace(pack));
		
		//log.exiting(GenSerClass.class.getName(), "generateClassDef");
	}
	
	private void printCommentSerializerClass(CodePrinter pr) {
		pr.println();
		pctxt.printLine(pr);
		pr.print("// Serializer for ").println(cppInfo.getClassName("..."));
		pr.println();
	}
	
	private void generateClassImpl() throws IOException {
		////log.debug(GenSerClass.class.getName(), "generateClassImpl");
		
		printCommentSerializerClass(prC);
		prC.println(TypeInfoCpp.makeBeginNamespace(pack));
		prC.println();
		
		prC.print(inline).print(serializerName).print("::").print(serializerName).print("() ");
		prC.print(": BSerializer(").print(serInfo.typeId).println(") {");
		prC.println("}");
		
		prC.print(inline).print(serializerName).print("::~").print(serializerName).println("() {");
		prC.println("}");

		printSize();
		
		printSerialize();
		
		printCreate();
				
		prC.println();
		prC.println(TypeInfoCpp.makeEndNamespace(pack));
		
		//log.exiting(GenSerClass.class.getName(), "generateClassImpl");
	}
	
	private void printSize() throws IOException {
		prC.print(inline).print("BLENGTH ").print(serializerName)
			.println("::Size(void* pObj, const BBinaryModel& bmodel) {");
		prC.beginBlock();
		pctxt.printComputeSize(prC, serInfo, pctxt.bmodel);
		prC.endBlock();
		prC.println("}");
	}
	
	private void printCreate() throws IOException {
		prC.print(inline).print("void* ").print(serializerName)
			.println("::Create(BIO& bio) {");
		prC.beginBlock();
		prC.print("return new ").print(cppInfo.getClassName(pack)).println("();");
		prC.endBlock();
		prC.println("}");
	}

	private void printSerialize() {
		prC.print(inline).print("void ").print(serializerName)
			.println("::Serialize(void* pObj1, BIO& bio, int32_t version) {");
		prC.beginBlock();
		
		if (serInfo.baseInfo != null) {
			prC.print(baseSerializerName).print("::Serialize(pObj1, bio, version);").println();
		}
		
		String className = cppInfo.getClassName(pack);
		prC.print(className).print("* pObj = static_cast<").print(className).print("*>(pObj1);");
		prC.println();
		
		printSerializeMembers(serInfo.getTypeMembers());
		printSerializeMembers(serInfo.getPointerMembers());
		
		prC.endBlock();
		prC.println("}");
	}
	
	private void printSerializeMembers(List<MemberInfo> members) {
		List<Integer> sinceStack = new ArrayList<Integer>();

		for (MemberInfo minfo : members) {
			if (minfo.isTransient) {
				prC.print("// skip transient member ").print(minfo.name);
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
		
		prC.print("bio.Serialize(pObj->").print(minfo.name).print(", ").print(minfo.since).print(");")
			.println();
	}

	private final CodePrinter prH;
	private final CodePrinter prC;
	private final SerialInfo serInfo;
	private final TypeInfoCpp cppInfo;
	private final TypeInfoCpp cppInfoBase;
	private final PrintContext pctxt;
	private final BRegistry registry;
	private final String serializerName;
	private final String baseSerializerName;
	private final String pack;
	private final String basePack;
	private final String inline = "";
}
