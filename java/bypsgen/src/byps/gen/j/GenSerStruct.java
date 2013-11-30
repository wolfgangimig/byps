package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.BRegistry;
import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

public class GenSerStruct {
	static Log log = LogFactory.getLog(GenSerStruct.class);

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
		
		pr.print("public ").print(serializerName).println("() {");
		pr.beginBlock();
		CodePrinter mpr = pr.print("super(" + serInfo.typeId);
		if (serInfo.isInline) mpr.print(", true");
		mpr.println(");");
		pr.endBlock();
		pr.println("}");
		pr.println();

		pr.print("public ").print(serializerName).println("(int typeId) {");
		pr.beginBlock();
		pr.println("super(typeId);");
		pr.endBlock();
		pr.println("}");
		pr.println();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		pr.print("public final static BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}

//	private void printSize() throws IOException {
//		//log.debug(GeneratorJ.class.getName(), "printSize");
//		
//		pr.println("public int size(final Object obj, final BBinaryModel bmodel) throws BException {");
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
	
	@SuppressWarnings("unused")
	private void printSkipMember(MemberInfo minfo, boolean putNotGet) throws IOException {
		
		//log.debug(GeneratorJ.class.getName(), "printSkipMember", minfo);
		String params = "";
		if (registry.isPointerTypeId(minfo.type.typeId)) {
			params = Integer.toString(pctxt.bmodel.pointerSize);
		}
		else {
			if (minfo.type.typeId == BRegistry.TYPEID_INT8   ) params = "1"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_INT16  ) params = "2"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_INT32  ) params = "4"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_INT64  ) params = "8"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_FLOAT  ) params = "4"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_DOUBLE ) params = "8"; 
			else if (minfo.type.typeId == BRegistry.TYPEID_BOOL   ) params = "1"; 
			else {
				String msg = "Unknown tpyeId=" + minfo.type.typeId;
				log.error(msg);
				throw new IllegalStateException(msg);
			}				
		}
		
		String bbuf = putNotGet ? "bout.bbuf" : "bin.bbuf";
		
		pr.print(bbuf).print(".skip(").print(params)
			.print("); // Skip transient member ").print(minfo.name)
			.println();
		//log.debug(GeneratorJ.class.getName(), "printSkipMember");
	}
	
	protected void printPutMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printPutMember", minfo);
		pctxt.printStreamPutMember(pr, BBinaryModel.MEDIUM, "obj.", minfo.name, minfo.name, minfo.access == MemberAccess.PRIVATE, minfo.type);
		//log.debug(GeneratorJ.class.getName(), "printPutMember");
	}

	protected void printGetMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
		pctxt.printStreamGetMember(pr, BBinaryModel.MEDIUM, "obj.", minfo.name, minfo.name, minfo.access == MemberAccess.PRIVATE, minfo.type);
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
	}
	
	protected void internalPrintCreateObject() {
		CodePrinter mpr = pr.print("final ").print(serInfo.name).print(" obj = (").print(serInfo.name).print(")(obj1 != null ? ")
		  .print("obj1 : ");
		if (!serInfo.isInline) mpr.print("bin.onObjectCreated(");
		mpr.print("new ").print(serInfo.name).print("())");
		if (!serInfo.isInline) mpr.print(")");
		mpr.println(";");

	}
	
	protected void printRead() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printRead");

		pr.println("@Override");
		pr.println("public Object read(final Object obj1, final BInput bin1, final long version) throws BException {");
		pr.beginBlock();
		pr.println("final BInputBin bin = (BInputBin)bin1;");
	
		internalPrintCreateObject();
		pr.println();

		// If BSerializer.write finds a null value for an inline object,
		// it calls BSerializer.read(null,null,0) in order to create a
		// default value. Inline objects must not be null.
		if (serInfo.isInline) { 
			pr.println("if (bin != null) {");
			pr.beginBlock();
		}
			
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			pr.println("// Read base class members");
			pr.println("super.read(obj, bin, version);");
			pr.println();
		}

		if (serInfo.members.size() != 0) {
			pr.println("final BBufferBin bbuf = bin.bbuf;");
			pr.println();
			
			printPutGetMembers(serInfo.getTypeMembers(), false);
			printPutGetMembers(serInfo.getPointerMembers(), false);
			pr.println();
		}

		if (serInfo.isInline) {
			pr.endBlock();
			pr.println("}");
		}
		
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
				// printSkipMember(minfo, putNotGet);
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

		pr.println("@Override");
		pr.println("public void write(final Object obj1, final BOutput bout1, final long version) throws BException {");
		pr.beginBlock();
				
		// see comment in printRead()
		if (serInfo.isInline) {
			pr.print("final ").print(serInfo.name).print(" obj = ")
				.print("(").print(serInfo.name).print(")(obj1 != null ? obj1 : read(null, null, 0));");
		}
		else {
			pr.print("final ").print(serInfo.name).print(" obj = (").print(serInfo.name).print(")obj1;");
		}
		pr.println();
			
		if (serInfo.baseInfo != null && !serInfo.baseInfo.isExceptionType()) {
			pr.print("super.write(obj, bout1, version);");
			pr.println();
		}
		
		pr.println("final BOutputBin bout = (BOutputBin)bout1;");
		pr.println("final BBufferBin bbuf = bout.bbuf;");
		
		printPutGetMembers(serInfo.getTypeMembers(), true);
		printPutGetMembers(serInfo.getPointerMembers(), true);
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}

	void generate() throws IOException {
		//log.debug(GenSerStruct.class.getName(), "generateStructSerializer");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass(), "Serializer for " + serInfo);

		pr.println("import byps.*;");
		//pr.println("import " + pctxt.apiPack + ".*;");
		pr.println();
		pr.println("// DEBUG");
		pr.println("// isEnum=" + serInfo.isEnum);
		pr.println("// isFinal=" + serInfo.isFinal);
		pr.println("// isInline=" + serInfo.isInline);
		pr.println("// #members=" + serInfo.members.size());
		pr.println();
		
		pr.checkpoint();
		
		pr.println("@SuppressWarnings(\"all\")");
		{ 
			CodePrinter mpr = pr.print("public class ").print(serializerName).print(" extends ");
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
		
		if (members.size() != 0) {
			printWrite();
			pr.println();
		}
		
		printRead();
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

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
