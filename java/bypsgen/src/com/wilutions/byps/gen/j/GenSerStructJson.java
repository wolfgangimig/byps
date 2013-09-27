package com.wilutions.byps.gen.j;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.MemberAccess;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

public class GenSerStructJson extends GenSerStruct{
	static Log log = LogFactory.getLog(GenSerStructJson.class);
	
	GenSerStructJson(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		super(pctxt, serInfo, pr, BBinaryModel.JSON);
		serializerName = pctxt.getSerializerClassName(serInfo, BBinaryModel.JSON);
		baseSerializerName = pctxt.getSerializerQName(serInfo.baseInfo, BBinaryModel.JSON);
	}
	
	protected void printPutMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printPutMember", minfo);
		pctxt.printStreamPutMember(pr, BBinaryModel.JSON, "obj.", minfo.name, minfo.name, minfo.access == MemberAccess.PRIVATE, minfo.type);
		//log.debug(GeneratorJ.class.getName(), "printPutMember");
	}

	protected void printGetMember(MemberInfo minfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
		pctxt.printStreamGetMember(pr, BBinaryModel.JSON, "obj.", minfo.name, minfo.name, minfo.access == MemberAccess.PRIVATE, minfo.type);
		//log.debug(GeneratorJ.class.getName(), "printGetMember");
	}
	
	
	protected void printRead() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printRead");

		pr.println("@Override");
		pr.println("public Object internalRead(final Object obj1, final BInputJson bin) throws BException {");
		pr.beginBlock();
		
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
			pr.println("super.internalRead(obj, bin);");
			pr.println();
		}
		
		if (serInfo.members.size() != 0) {
			pr.println("final BJsonObject js = bin.currentObject;");
			
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
		
		for (MemberInfo minfo : members) {
			if (minfo.isTransient) continue;
			
			if (minfo.type.typeId == BRegistry.TYPEID_VOID) {
				// Type void can be used by method return values 
				printVoidMember(minfo);
			}
			else {
				if (putNotGet) {
					printPutMember(minfo);
				}
				else if (!minfo.isStatic) {
					printGetMember(minfo);
				}
			}
		}
		
	}

	protected void printWrite() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printStore");

		pr.println("@Override");
		pr.println("public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {");
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
			pr.print("super.internalWrite(obj1, bout, bbuf);");
			pr.println();
		}
		
		printPutGetMembers(serInfo.getTypeMembers(), true);
		printPutGetMembers(serInfo.getPointerMembers(), true);
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}
	
//	protected void printSize() throws IOException {
//	}
}
