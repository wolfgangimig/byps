package com.wilutions.byps.gen.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberAccess;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

public class GenSerStruct {
	static Log log = LogFactory.getLog(GenSerStruct.class);

	GenSerStruct(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this(pctxt, serInfo, pr, BBinaryModel.MEDIUM);
	}
	
	protected GenSerStruct(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel bmodel) {
		this.serInfo = serInfo;
		this.pr = pr;
		serializerName = pctxt.getSerializerClassName(serInfo, BBinaryModel.MEDIUM);
		baseSerializerName = serInfo.baseInfo != null ? pctxt.getSerializerClassName(serInfo.baseInfo, BBinaryModel.MEDIUM) : "";
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
				kw = "new "; 
			}
		}

		pr.print("public readonly static ").print(kw).print("BSerializer instance = new ").print(serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}

	protected void printSize() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSize");
		
		pr.println("public override int size(Object obj, BBinaryModel bmodel)");
		pr.println("{");
		pr.beginBlock();		
		pctxt.printComputeSize(pr, serInfo, pctxt.bmodel);
		pr.endBlock();
		
		pr.println("}");
			
		//log.debug(GeneratorJ.class.getName(), "printSize");
	}
	
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

		pr.println("public override Object read(Object obj1, BInput bin1, int version)");
		pr.println("{");
		pr.beginBlock();
		
		pr.println("BInputBin bin = (BInputBin)bin1;");

		internalPrintCreateObject();
		pr.println();
		
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			pr.print("base.read(obj1, bin1, version);");
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
		List<Integer> sinceStack = new ArrayList<Integer>();
		
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
						pr.print("if (version >= ").print(minfo.since).print(") {").println();
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

		pr.println("public override void write(Object obj1, BOutput bout1, int version)");
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
		pr.println("using com.wilutions.byps;");
		pr.println();
		pr.println("namespace " + pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();

		{ 
			CodePrinter mpr = pr.print("public class ").print(serializerName).print(" : ");
			if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
				mpr.print(baseSerializerName);
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
		
		printSize();
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
