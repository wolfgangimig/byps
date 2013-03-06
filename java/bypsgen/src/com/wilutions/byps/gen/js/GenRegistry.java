package com.wilutions.byps.gen.js;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenRegistry {
	static Log log = LogFactory.getLog(GenRegistry.class);
	
	static void generate(PrintContext pctxt, Iterable<SerialInfo> serInfos) throws IOException {
		log.debug("generate");
		CodePrinter pr = pctxt.getPrinter();
		new GenRegistry(pctxt, serInfos, pr).generate();
		pr.close();
		log.debug(")generate");
	}

	private GenRegistry(PrintContext pctxt, Iterable<SerialInfo> serInfos, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serInfos = serInfos;
		this.registryClassName = pctxt.getRegistryClassName();
		this.pr = pr;
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		pr.print(registryClassName).println(" = function() { ");
		
		pr.beginBlock();
		pr.println();
		
		printGetSerializerByTypeId();
		
		pr.endBlock();
		
		pr.println("};");
		pr.print(registryClassName).println(".prototype = new com.wilutions.byps.BRegistry();");

		log.debug(")generate");
	}

	private void printGetSerializerByTypeId()
			throws BException {
		pr.println("this._serializerMap = {");
		
		pr.beginBlock();
		
		for (SerialInfo serInfo : serInfos) {
			
			if (serInfo.isBuiltInType()) continue;
			if (serInfo.isCollectionType()) continue;
			if (!serInfo.isPointerType()) continue;

			pr.println();

			pr.print("// ").print(serInfo.toString("java.lang")).println();
			if (serInfo.isStubType()) {
				
				pr.print(serInfo.typeId + " : new com.wilutions.byps.BSerializerRemote(").print(serInfo.qname).println("),");
			}
			else if (serInfo.isArrayType()) {
				TypeInfo elmType = pctxt.classDB.getTypeInfo(serInfo.toStringNoDims("")); 
				int nbOfDimensions = serInfo.dims.length() / 2;
				pr.println(serInfo.typeId + " : new com.wilutions.byps.BSerializerArray(");
				pr.beginBlock();
				pr.print(elmType.typeId + ", // Element type: ").println(elmType.toString("java.lang"));
				pr.println(nbOfDimensions + "");
				pr.endBlock();
				pr.println("),");
			}
			else {
				
				pr.println(serInfo.typeId + " : new com.wilutions.byps.BSerializer(");
				pr.beginBlock();
				
				printMembers(serInfo, false);
				
				printMembers(serInfo, true);
				
				pr.print(serInfo.isInline + " // inlineInstance").println();
				
				pr.endBlock();
				pr.println("),");
			}


		}
		
		pr.endBlock();
		pr.println("};");
	}

	protected void printMembers(SerialInfo serInfo, boolean onlyInline) {
		boolean hasMember = false;
		for (int i = 0; i < serInfo.members.size(); i++) {
			MemberInfo minfo = serInfo.members.get(i);
			if (minfo.isTransient) continue;
			if (minfo.isStatic) continue;
			if (onlyInline && !minfo.type.isInline && !minfo.type.isArrayType() && !minfo.type.isCollectionType()) continue;

			if (!hasMember) {
				pr.print("{").println( onlyInline ? "// names of inline elements" : "// names of persistent elements" );
				pr.beginBlock();
			}
			
			CodePrinter mpr = pr.print("\"").print(minfo.name).print("\":").print(minfo.type.typeId);
			if (i != serInfo.members.size()-1) mpr = mpr.print(",");
			mpr.print(" // ").print(minfo.type.toString(new String[] {"java.lang", "java.util", "com.wilutions.byps"}));
			mpr.println();
			
			hasMember = true;
		}
		
		if (hasMember) {
			pr.endBlock();
			pr.println("},");
		}
		else {
			pr.println("null,");
		}
	}
	
	private Iterable<SerialInfo> serInfos;
	private CodePrinter pr;
	private String registryClassName;
	private PrintContext pctxt;
}
