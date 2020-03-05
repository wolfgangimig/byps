package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBinaryModel;
import byps.BRegistry;
import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

public class GenSerStruct {
	static Logger log = LoggerFactory.getLogger(GenSerStruct.class);

	GenSerStruct(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this(pctxt, serInfo, pr, BBinaryModel.MEDIUM);
	}
	
	protected GenSerStruct(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel bmodel) {
		this.serInfo = serInfo;
		this.pr = pr;
		serializerName = pctxt.getSerializerClassName(serInfo, BBinaryModel.MEDIUM);
    baseSerializerName = pctxt.getSerializerQName(serInfo.baseInfo, BBinaryModel.MEDIUM);
		pack = pctxt.getSerializerPackage(serInfo);
		this.pctxt = pctxt;
		this.registry = pctxt.classDB.getRegistry();
		this.members = getMembersWithoutVoids();
		this.bmodel = bmodel; 
	}
	
	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("()");
		pr.beginBlock();
		CodePrinter mpr = pr.print(": base(" + serInfo.typeId);
		if (serInfo.isInline) mpr.print(", true");
		mpr.println(") {}");
		pr.endBlock();
		pr.println();

		pr.print("public ").print(serializerName).println("(int typeId)");
		pr.beginBlock();
		pr.println(": base(typeId) {}");
		pr.endBlock();
		pr.println();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		String kw  ="";
		
		// final class?
		if (serInfo.isInline) {
			// -> cannot have a base class -> do not need new 
			// see ClassDB.verify(SerialInfo)
		}
		else {
			// has base class?
			if (serInfo.baseInfo != null) {
				if (!serInfo.baseInfo.isExceptionType()) {
					kw = "new "; 
				}
			}
		}

		pr.print("public readonly static ").print(kw).print("BSerializer instance = new ").print(serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}

//	protected void printSize() throws IOException {
//		//log.debug(GeneratorJ.class.getName(), "printSize");
//		
//		pr.println("public override int size(Object obj, BBinaryModel bmodel)");
//		pr.println("{");
//		pr.beginBlock();		
//		pctxt.printComputeSize(pr, serInfo, pctxt.bmodel);
//		pr.endBlock();
//		
//		pr.println("}");
//			
//		//log.debug(GeneratorJ.class.getName(), "printSize");
//	}
	
	protected void printVoidMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printVoidMember", minfo);
		pr.print("// void " + minfo.name);
		//log.debug(GeneratorJ.class.getName(), "printVoidMember", minfo);
	}
	
	protected void printPutMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printPutMember", minfo);
		boolean useGetter = !serInfo.isRequestClass() && !serInfo.isResultClass();
		pctxt.printStreamPutMember(pr, BBinaryModel.MEDIUM, "obj.", minfo.name, minfo.name,
				minfo.access == MemberAccess.PRIVATE, minfo.type,
				useGetter);
		//log.debug(GeneratorJ.class.getName(), "printPutMember");
	}

	protected void printGetMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
		boolean useSetter = !serInfo.isRequestClass() && !serInfo.isResultClass();
		pctxt.printStreamGetMember(pr, BBinaryModel.MEDIUM, "obj.", minfo.name, minfo.name, 
				minfo.access == MemberAccess.PRIVATE, minfo.type, useSetter);
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
	}
	
	protected void internalPrintCreateObject() {
		CodePrinter mpr = pr.print(serInfo.name).print(" obj = (").print(serInfo.name).print(")(obj1 != null ? ")
		  .print("obj1 : ");
		if (!serInfo.isInline) mpr.print("bin.onObjectCreated(");
		mpr.print("new ").print(serInfo.name).print("())");
		if (!serInfo.isInline) mpr.print(")");
		mpr.println(";");

	}

	protected void printRead() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printRead");

		pr.println("public override Object read(Object obj1, BInput bin1, long version)");
		pr.println("{");
		pr.beginBlock();
		
		pr.println("BInputBin bin = (BInputBin)bin1;");

		internalPrintCreateObject();
		pr.println();
		
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			pr.print("base.read(obj, bin1, version);");
			pr.println();
		}
		
		pr.println("BBufferBin bbuf = bin.bbuf;");
		
		printPutGetMembers(serInfo.getTypeMembers(), false);
		printPutGetMembers(serInfo.getPointerMembers(), false);

		pr.println();
		pr.println("return obj;");
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printRead");
	}

	protected void printPutGetMembers(List<MemberInfo> members, boolean putNotGet) throws IOException {
		List<Long> sinceStack = new ArrayList<Long>();
		
		for (MemberInfo minfo : members) {
			if (minfo.isStatic) {
				// Konstante
			}
			else if (minfo.isTransient) {
				// printSkipMember(minfo);
			}
			else if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
				// Type void can be used by method return values 
				printVoidMember(minfo);
			}
			else {
				if (minfo.since != 0) {
					if (sinceStack.size() == 0 || sinceStack.get(sinceStack.size()-1) != minfo.since) {
						sinceStack.add(minfo.since);
						pr.print("if (version >= ").print(minfo.since).print("L) {").println();
						pr.beginBlock();
					}
				}

				if (putNotGet) {
					printPutMember(minfo);
				}
				else {
					printGetMember(minfo);
				}
			}
		}
		
		for (int i = 0; i < sinceStack.size(); i++) {
			pr.endBlock();
			pr.println("}");
		}
	}

	protected void printWrite() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printStore");

		pr.println("public override void write(Object obj1, BOutput bout1, long version)");
		pr.println("{");
		pr.beginBlock();
		
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			pr.print("base.write(obj1, bout1, version);");
			pr.println();
		}
		
		pr.print("").print(serInfo.name).print(" obj = (").print(serInfo.name).print(")obj1;");
		pr.println();
		pr.println("BOutputBin bout = (BOutputBin)bout1;");
		pr.println("BBufferBin bbuf = bout.bbuf;");
		
		printPutGetMembers(serInfo.getTypeMembers(), true);
		printPutGetMembers(serInfo.getPointerMembers(), true);
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}

	void generate() throws IOException {
		//log.debug(GenSerStruct.class.getName(), "generateStructSerializer");
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
    pr.print("namespace ").println(pctxt.renamePackage(pack));
		pr.println("{");
		pr.beginBlock();
		pr.println();

		{ 
			CodePrinter mpr = pr.print("public class ").print(serializerName).print(" : ");
			if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
				mpr.print(pctxt.renameClassPackage(baseSerializerName));
			}
			else {
				if (bmodel == BBinaryModel.JSON) {
					mpr.print("JSerializer_Object");
				}
				else {
					mpr.print("BSerializer");
				}
			}
			mpr.println(" {");
		}
		
		pr.beginBlock();
		pr.println();
		
		printSingletonInstance();
		pr.println();
		
		printConstructors();
		pr.println();
		
		if (members.size() != 0) {
			printWrite();
			pr.println();
		}

		printRead();
		pr.println();

		pr.endBlock();
		
		pr.println("}");
	
		pr.endBlock();
		pr.println("} // namespace");

		//log.debug(GenSerStruct.class.getName(), "generateStructSerializer");
	}
	
	protected List<MemberInfo> getMembersWithoutVoids() {
		ArrayList<MemberInfo> arr = new ArrayList<MemberInfo>();
		for (MemberInfo m : serInfo.members) {
			if (m.type.typeId == BRegistry.TYPEID_VOID) continue; 
			arr.add(m);
		}
		return arr;
	}
	
	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	protected String serializerName;
	protected String baseSerializerName;
	final protected String pack;
	final protected PrintContext pctxt;
	final protected BRegistry registry;
	final protected List<MemberInfo> members;
	final protected BBinaryModel bmodel;
}
