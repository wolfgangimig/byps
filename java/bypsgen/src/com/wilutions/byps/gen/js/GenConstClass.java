package com.wilutions.byps.gen.js;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.wilutions.byps.BException;
import com.wilutions.byps.BJsonObject;
import com.wilutions.byps.gen.api.ErrorInfo;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenConstClass {
	
	static Log log = LogFactory.getLog(GenConstClass.class);
	
	static void generate(CustomControl fact, PrintContext pctxt, SerialInfo serInfo) throws IOException {
		log.debug("generate(" + serInfo);
		if (serInfo.isCollectionType()) {
			// No API class for List<>...
		}
		else if (serInfo.isArrayType()) {
			// No API class for int[]...
		}
		else if (serInfo.isStubType()) {
			// Stub API class is generated by GenRemoteStub
		}
		else if (serInfo.typeId < pctxt.classDB.getRegistry().getMinTypeIdUser()){
			// No API class for RemoteException ...
		}
		else if (serInfo.isResultClass() || serInfo.isRequestClass()) {
			// JSON API does not need a class for results or requests 
		}
		else  {
			log.info("Generate API class for type " + serInfo.typeId + ": " + serInfo);
			CodePrinter pr = pctxt.getPrinter();
			fact.createGenConstClass(pctxt, serInfo, pr).generate();
			pr.close();
		}
		log.debug(")generate");
	}
	
	protected GenConstClass(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serInfo = serInfo;
		this.pr = pr;
	}
	
	private void printMember(MemberInfo minfo) throws IOException {
		log.debug("printMember");
		
		pctxt.printComments(pr, minfo.comments);

		String value = minfo.value;
		if (value != null) {
			if (value.startsWith("\"")) value = value.substring(1, value.length()-1);
			String cvalue = printConstValue(minfo.type, value);
			pr.print("this.").print(minfo.name).print(" = ").print(cvalue).println(";");
		}
		else {
			pr.print("// ").print(minfo.name).print(" // ").print(minfo.type.toString(serInfo.pack)).println();
		}
		
		log.debug(")printMember");
	}
	
	private String printStringChar(char c) {
		StringBuilder sbuf= new StringBuilder();
		if (c == '\\') sbuf.append("\\\\");
		else if (c == '\t') sbuf.append("\\t");
		else if (c == '\r') sbuf.append("\\r");
		else if (c == '\n') sbuf.append("\\n");
		else if (c == '\b') sbuf.append("\\b");
		else if (c == '\"') sbuf.append("\\\"");
		else if (c == '\'') sbuf.append("\\\'");
		else if (c >= 0x20 && c <= 0x7F) sbuf.append(c);
		else {
			sbuf.append("\\u");			
			String s = Integer.toHexString((int)c);
			for (int i = s.length(); i < 4; i++) sbuf.append("0");
			sbuf.append(s);
		}
		return sbuf.toString();
	}
	
	private String printConstValue(TypeInfo tinfo, Object value) throws BException, GeneratorException {
		StringBuilder sbuf = new StringBuilder();
		
		if (tinfo.dims.length() != 0) {
			BJsonObject js = BJsonObject.fromString((String)value);
			sbuf.append(makeNewArrayInstance(tinfo, js));
		}
		else if (tinfo.qname.equals("java.lang.String")) {
			String s = (String)value;
			sbuf.append("\"");
			for (int i = 0; i < s.length(); i++) {
				sbuf.append( printStringChar(s.charAt(i)) );
			}
			sbuf.append("\"");
		}
		else if (tinfo.qname.equals("char")) {
			String s = (String)value;
			sbuf.append("\'");
			sbuf.append( printStringChar(s.charAt(0)) );
			sbuf.append("\'");
		}
		else if (tinfo.qname.equals("boolean")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("byte")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("short")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("int")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("long")) {
			if (value instanceof Number) value = ((Number)value).longValue();
			sbuf.append("\"").append(value).append("\"");
		}
		else if (tinfo.qname.equals("double")) {
			sbuf.append(value);
		}
		else if (tinfo.qname.equals("float")) {
			sbuf.append(value);
		}
		else if (tinfo.isPointerType() && (value instanceof BJsonObject)) {
			sbuf.append(makeNewInstance(tinfo, (BJsonObject)value));
		}
		else {
			BJsonObject js = BJsonObject.fromString((String)value);
			sbuf.append(makeNewInstance(tinfo, js));
		}
		
		return sbuf.toString();
	}
	
	private String makeNewArrayInstance(TypeInfo tinfo, BJsonObject js) throws BException, GeneratorException {
		if (js == null) return "null";
		StringBuilder sbuf = new StringBuilder();
		if (tinfo.isByteArray1dim()) {
			byte[] binaryData = new byte[js.size()];
			for (int i = 0; i < js.size(); i++) {
				binaryData[i] = js.getByte(i);
			}
			String s = Base64.encode(binaryData);
			sbuf.append("\"").append(s).append("\"");
		}
		else {
			sbuf.append(makeArrayLevel(tinfo, 1, js));
		}
		return sbuf.toString();
	}
	
	private String makeArrayLevel(TypeInfo tinfo, int dim, BJsonObject js) throws BException, GeneratorException {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[");
		for (int i = 0; i < js.size(); i++) {
			if (i != 0) sbuf.append(",");
			if (dim < tinfo.dims.length()/2) {
				BJsonObject jsElm = (BJsonObject)js.get(i);
				sbuf.append(makeArrayLevel(tinfo, dim+1, jsElm));
			}
			else {
				Object value = js.get(i);
				TypeInfo elmInfo = new TypeInfo(tinfo.name, tinfo.qname, "", null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
				sbuf.append(printConstValue(elmInfo, value));
			}
		}
		sbuf.append("]");
		return sbuf.toString();
	}

	private String makeNewInstance(TypeInfo tinfo, BJsonObject params) throws GeneratorException, BException {
		if (params == null) return "null";

		StringBuilder sbuf = new StringBuilder();
		SerialInfo sinfo = null;
		for (SerialInfo s : pctxt.classDB.getSerials()) {
			if (s.toString().equals(tinfo.toString())) {
				sinfo = s; break;
			}
		}
		if (sinfo == null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = tinfo.toString();
			errInfo.msg = "Internal error, typeId=" + tinfo.typeId + " not found in list of serials.";
			throw new GeneratorException(errInfo);
		}
		
		boolean first = true;
		sbuf.append("new ").append(sinfo.toString("")).append("(");
		for (MemberInfo minfo : sinfo.members) {
			if (minfo.isStatic) continue;
			
			if (!first) sbuf.append(", "); else first = false; 
			
			if (minfo.type.dims.length() != 0) {
				sbuf.append(makeNewArrayInstance(minfo.type, (BJsonObject)params.get(minfo.name)));
			} else if (minfo.type.isPointerType()) {
				sbuf.append(makeNewInstance(minfo.type, (BJsonObject)params.get(minfo.name)));
			}
			else {
				sbuf.append(printConstValue(minfo.type, params.get(minfo.name)));
			}
		}
		sbuf.append(")");
		
		return sbuf.toString();
	}
	
	private void generate() throws IOException {
		if (serInfo.isEnum){
			generateEnum();
		}
		else {
			generateClass();
		}
	}
	
	private ArrayList<MemberInfo> sortEnumMembersByOrdinal(List<MemberInfo> members) {
		ArrayList<MemberInfo> m = new ArrayList<MemberInfo>(members);

		Collections.sort(m, new Comparator<MemberInfo>() {
			@Override
			public int compare(MemberInfo o1, MemberInfo o2) {
				int v1 = Integer.parseInt(o1.value);
				int v2 = Integer.parseInt(o2.value);
				return v1 - v2;
			}
		});
		
		return m;
	}
	
	private void generateEnum() throws IOException {
		log.debug("generateEnum(");
		pr.print(serInfo.pack).print(".").print(serInfo.name).println(" = {");
		pr.beginBlock();
		
		ArrayList<MemberInfo> membersByOrdinal = sortEnumMembersByOrdinal(serInfo.members);
		for (int i = 0; i < membersByOrdinal.size(); i++) {
			MemberInfo minfo = membersByOrdinal.get(i);
			pctxt.printComments(pr, minfo.comments);
			CodePrinter mpr = pr.print(minfo.name).print(" : ").print(minfo.value);
			boolean lastRow = (i == membersByOrdinal.size()-1); 
			mpr.println(lastRow ? "" : ",");
		}
		
		pr.endBlock();
		pr.println("};");
		pr.println();
		log.debug(")generateEnum");
	}
	
	private void generateClassForConstants(ArrayList<MemberInfo> members, String classSuffix) throws IOException {
		log.debug("generateClassForConstants(");

		String className = serInfo.pack + "." + serInfo.name + classSuffix;
		
		pr.print(className).println("_Type = function() {");
		pr.beginBlock();

		for (MemberInfo minfo : serInfo.members) {
			printMember(minfo);
		}

		pr.endBlock();
		pr.println("};");

		log.debug(")generateClassForConstants");
	}
	
	private void generateClass() throws IOException {
		log.debug("generate");

		// Separate constant members from normal members  
		ArrayList<MemberInfo> valueMembers = new ArrayList<MemberInfo>();
		ArrayList<MemberInfo> constMembers = new ArrayList<MemberInfo>();
		PrintHelper.collectAllMembers(serInfo, valueMembers, constMembers);

		if (constMembers.size() != 0) {
			generateClassForConstants(constMembers, valueMembers.size() != 0 ? "C" : "");
			pr.println();
		}
		
		log.debug(")generate");
	}

	private final SerialInfo serInfo;
	private final CodePrinter pr;
	private final PrintContext pctxt;
}
