package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BException;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

   
public class GenRegistry {
	static Logger log = LoggerFactory.getLogger(GenRegistry.class);
	
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
		pr.print(registryClassName).println(".prototype = new byps.BRegistry();");

		log.debug(")generate");
	}

	private void printGetSerializerByTypeId()
			throws BException {
		pr.println("this._serializerMap = {");
		
		pr.beginBlock();
		
		for (SerialInfo serInfo : serInfos) {
			
			if (serInfo.isBuiltInType()) continue;
			if (!serInfo.isPointerType()) continue;

			pr.println();

			pr.print("// ").print(serInfo.toString("java.lang")).println();
			if (serInfo.isStubType()) {
				
				pr.print(serInfo.typeId + " : new byps.BSerializer_16(").print(serInfo.qname).println("),");
			}
			else if (serInfo.isArrayType()) {
				TypeInfo elmType = pctxt.classDB.getTypeInfo(serInfo.toStringNoDims("")); 
				int nbOfDimensions = serInfo.dims.length() / 2;
				pr.println(serInfo.typeId + " : new byps.BSerializerArray(");
				pr.beginBlock();
				pr.print(elmType.typeId + ", // Element type: ").println(elmType.toString("java.lang"));
				pr.println(nbOfDimensions + "");
				pr.endBlock();
				pr.println("),");
			}
			else if (serInfo.isListType() || serInfo.isSetType()) {
				TypeInfo elmType = serInfo.typeArgs.get(0); 
				pr.println(serInfo.typeId + " : new byps.BSerializerArray(");
				pr.beginBlock();
				pr.print(elmType.typeId + ", // Element type: ").println(elmType.toString("java.lang"));
				pr.println("1");
				pr.endBlock();
				pr.println("),");				
			}
			else if (serInfo.isMapType()) {
				TypeInfo elmType = serInfo.typeArgs.get(1); 
				pr.println(serInfo.typeId + " : new byps.BSerializerMap(");
				pr.beginBlock();
				pr.print(elmType.typeId + " // Element type: ").println(elmType.toString("java.lang"));
				pr.endBlock();
				pr.println("),");				
			
			}
			else {
				
				pr.println(serInfo.typeId + " : new byps.BSerializer(");
				pr.beginBlock();
				
				printMembers(serInfo, false);
				
				printMembers(serInfo, true);
				
				pr.println("// inlineInstance");
				pr.println(serInfo.isInline + "");
				
//        pr.println("// prototype");
//				String proto = "null";
//				if (hasStaticMember(serInfo)) {
//				  proto = pctxt.getConstObjectName(serInfo);
//				}
//				pr.println(proto);
				
				pr.endBlock();
				pr.println("),");
			}


		}
		
		pr.endBlock();
		pr.println("};");
	}
	
	protected boolean hasStaticMember(SerialInfo serInfo) {
	   for (int i = 0; i < serInfo.members.size(); i++) {
	      MemberInfo minfo = serInfo.members.get(i);
	      if (minfo.isStatic) return true; 
	   }
	   return false;
	}
	
	private void collectMembersInclusiveInheritedMembers(SerialInfo serInfo, ArrayList<MemberInfo> allMembers) {
		if (serInfo != null) {
			allMembers.addAll(serInfo.members);
			collectMembersInclusiveInheritedMembers(serInfo.baseInfo, allMembers);
		}
	}

	protected void printMembers(SerialInfo serInfo, boolean onlyInline) {
		boolean hasMember = false;
		
		pr.checkpoint();
		
		ArrayList<MemberInfo> allMembers = new ArrayList<MemberInfo>();
		collectMembersInclusiveInheritedMembers(serInfo, allMembers);

		for (int i = 0; i < allMembers.size(); i++) {
			MemberInfo minfo = allMembers.get(i);
			
			if (minfo.isTransient) continue;
      //if (minfo.isStatic) continue; 
			
			if (onlyInline && 
			    !minfo.type.isInline && 
			    !minfo.type.isArrayType() && 
			    !minfo.type.isCollectionType() &&
			    !minfo.type.isDateType()) continue;

			if (!hasMember) {
		    pr.println( onlyInline ? "// names of inline elements" : "// names of persistent elements" );
				pr.println("{");
				pr.beginBlock();
			}
			
			CodePrinter mpr = pr.print("\"").print(minfo.name).print("\":").print(minfo.type.typeId);
			if (i != allMembers.size()-1) mpr = mpr.print(",");
			mpr.print(" // ").print(minfo.type.toString());
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
