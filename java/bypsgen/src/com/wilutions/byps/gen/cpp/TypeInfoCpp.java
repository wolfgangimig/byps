package com.wilutions.byps.gen.cpp;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.PrintContextBase;


class TypeInfoCpp {
	
	TypeInfo tinfo;
	
	String namespace;
	String namespaceBegin;
	String namespaceEnd;
	
	
	TypeInfoCpp(TypeInfo tinfo) {
		this.tinfo = tinfo;
		this.namespace = makeNamespace(tinfo.pack);
		this.namespaceBegin = makeBeginNamespace(tinfo.pack);
		this.namespaceEnd = makeEndNamespace(tinfo.pack);
	}
	
	static TypeInfoCpp makeSerializerTypeInfoCpp(PrintContextBase pctxt, TypeInfo tinfo) {
		String name = pctxt.getSerializerClassName(tinfo, BBinaryModel.MEDIUM);
		String pack = pctxt.getSerializerPackage(tinfo);
		String qname = pack + "." + name;
		TypeInfo tinfoSerializer = new TypeInfo(name, qname, "", null, false, false, false);
		return new TypeInfoCpp(tinfoSerializer);
	}

	String getClassName(String pack) {
		String name = makeCppName(tinfo, pack, Purpose.CLASS);
		return name;
	}
	
	String getQClassName() {
		return getClassName("...");
	}
	
	String getTypeName(String pack) {
		String name = makeCppName(tinfo, pack, Purpose.TYPE);
		return name;
	}
	
	String getQTypeName() {
		return getTypeName("...");
	}
	
	TypeInfoCpp getBaseInfo() {
		TypeInfoCpp baseInfo = null;
		if (tinfo instanceof SerialInfo) {
			SerialInfo serInfo = (SerialInfo)tinfo;
			if (serInfo.baseInfo != null) {
				baseInfo = new TypeInfoCpp(serInfo.baseInfo);
			}
		}
		return baseInfo;
	}
	
	String toString(String currentPackage) {
		return makeCppName(tinfo, currentPackage, Purpose.TYPE);
	}
	
	public String toString() {
		return toString("...");
	}
	
	private enum Purpose { CLASS, TYPE, PARAM, RETURN }
	
	private static String makeCppName(TypeInfo tinfo, String currentPackage, Purpose purpose) {
		StringBuilder tbuf = new StringBuilder();
		
		if (tinfo.dims.length() != 0) {
			if (purpose == Purpose.PARAM) {
				tbuf.append("const ");
			}
			purpose = Purpose.TYPE;
		}
		
		for (int i = 0; i < tinfo.dims.length(); i+=2) {
			tbuf.append("vector< "); 
		}
		
		if (tinfo.qname.equals("boolean")) tbuf.append("int8_t");
		else if (tinfo.qname.equals("java.lang.Boolean")) tbuf.append("int8_t");
		else if (tinfo.qname.equals("byte")) tbuf.append("int8_t");
		else if (tinfo.qname.equals("java.lang.Byte")) tbuf.append("int8_t");
		else if (tinfo.qname.equals("char")) tbuf.append("wchar_t");
		else if (tinfo.qname.equals("java.lang.Character")) tbuf.append("wchar_t");
		else if (tinfo.qname.equals("short")) tbuf.append("int16_t");
		else if (tinfo.qname.equals("java.lang.Short")) tbuf.append("int16_t");
		else if (tinfo.qname.equals("int")) tbuf.append("int32_t");
		else if (tinfo.qname.equals("java.lang.Integer")) tbuf.append("int32_t");
		else if (tinfo.qname.equals("long")) tbuf.append("int64_t");
		else if (tinfo.qname.equals("java.lang.Long")) tbuf.append("int64_t");
		else if (tinfo.qname.equals("float")) tbuf.append("float");
		else if (tinfo.qname.equals("java.lang.Float")) tbuf.append("float");
		else if (tinfo.qname.equals("double")) tbuf.append("double");
		else if (tinfo.qname.equals("java.lang.Double")) tbuf.append("double");
		else if (tinfo.qname.equals("void")) tbuf.append("void");

		else if (tinfo.qname.equals("java.lang.Object")) tbuf.append("PSerializable");
		
		else if (tinfo.qname.equals("java.lang.String")) {
			if (purpose == Purpose.PARAM) tbuf.append("const ");
			tbuf.append("wstring");
			if (purpose == Purpose.PARAM || purpose == Purpose.RETURN) tbuf.append("&");
		}
		
		else if (tinfo.name.equals("List")) {
			if (purpose == Purpose.PARAM) tbuf.append("const ");
			tbuf.append("vector< ").append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose == Purpose.PARAM || purpose == Purpose.RETURN) tbuf.append("&");
		}
		else if (tinfo.name.equals("Map")) {
			if (purpose == Purpose.PARAM) tbuf.append("const ");
			tbuf.append("map< ")
				.append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" , ")
				.append(makeCppName(tinfo.typeArgs.get(1), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose == Purpose.PARAM || purpose == Purpose.RETURN) tbuf.append("&");
		}
		else if (tinfo.name.equals("Set")) {
			if (purpose == Purpose.PARAM) tbuf.append("const ");
			tbuf.append("set< ").append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose == Purpose.PARAM || purpose == Purpose.RETURN) tbuf.append("&");
		}
		
		else {
			// User def type
			String qname = tinfo.toString(currentPackage);
			qname = qname.replaceAll("\\.", "::");
			if (!tinfo.isInline) {
				int p = qname.lastIndexOf(":");
				String ns = "";
				if (p >= 0) {
					ns = qname.substring(0, p+1);
				}
				qname = ns;
				if (purpose != Purpose.CLASS) qname += POINTER_CLASS_PREFIX;
				qname += tinfo.name;
			}
			tbuf.append(qname);
		}
		
		for (int i = 0; i < tinfo.dims.length(); i+=2) {
			tbuf.append(" >"); // std::vector< 
		}
		
		if (tinfo.dims.length() != 0) {
			if (purpose == Purpose.PARAM || purpose == Purpose.RETURN) tbuf.append("&");
		}

		return tbuf.toString();
	}

	static String makeBeginNamespace(String pack) {
		String ns = pack.replaceAll("\\.", " { namespace ");
		return "namespace " + ns + " { ";
	}
	
	static String makeEndNamespace(String pack) {
		String[] ns = pack.split("\\.");
		StringBuilder sbuf = new StringBuilder();
		for (int i = 0; i < ns.length; i++) sbuf.append("} /* ").append(ns[i]).append(" */ ");
		return sbuf.toString();
	}
	
	static String makeNamespace(String pack) {
		return pack.replaceAll("\\.", "::");
	}

	String getParamType(String pack) {
		return makeCppName(this.tinfo, pack, Purpose.PARAM);
	}
	
	private final static String POINTER_CLASS_PREFIX = "P";
}
