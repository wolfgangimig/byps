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
			int ndims = tinfo.dims.length() / 2;
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("BArray").append(ndims).append("< ");
			TypeInfo tinfoArg = new TypeInfo(tinfo.name, tinfo.qname, "", null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
			tbuf.append(makeCppName(tinfoArg, currentPackage, Purpose.TYPE));
			tbuf.append(" > ");
			if (purpose != Purpose.CLASS) tbuf.append(">");
			
		}
		else if (tinfo.qname.equals("boolean")) tbuf.append("bool");
		else if (tinfo.qname.equals("java.lang.Boolean")) tbuf.append("bool");
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
			tbuf.append("std::wstring");
			if (purpose == Purpose.PARAM) tbuf.append("&");
		}
		
		else if (tinfo.qname.equals("java.io.InputStream")) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("std::istream");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		
		else if (tinfo.qname.equals("java.lang.Exception") || tinfo.qname.equals("java.lang.Throwable")) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("std::exception");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		
		else if (tinfo.isListType()) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("std::vector< ").append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		else if (tinfo.isMapType()) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("std::map< ")
				.append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" , ")
				.append(makeCppName(tinfo.typeArgs.get(1), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		else if (tinfo.isSetType()) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("std::set< ").append(makeCppName(tinfo.typeArgs.get(0), currentPackage, Purpose.TYPE)).append(" >");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		
		else if (tinfo.isEnum) {
			if (purpose == Purpose.CLASS) {
				tbuf.append(tinfo.name); // Enum wird als namespace definiert
			}
			else {
				tbuf.append("int32_t");
			}
		}
		
		else {
			// User def type
			String qname = tinfo.toString(currentPackage);
			qname = qname.replaceAll("\\.", "::");
			if (!tinfo.isEnum && !tinfo.isInline) {
				int p = qname.lastIndexOf(":");
				String ns = "";
				if (p >= 0) {
					ns = qname.substring(0, p+1);
				}
				qname = ns;
				
				if (purpose != Purpose.CLASS) {
					if (tinfo.name.startsWith("BClient_") || 
						tinfo.name.startsWith("BServer_") ||
						tinfo.name.startsWith("BStub_") || 
						tinfo.name.startsWith("BSkeleton_")) {
						qname += POINTER_CLASS_PREFIX + tinfo.name.substring(1);
					}
					else {
						qname += POINTER_CLASS_PREFIX + tinfo.name;
					}
				}
				else {
					qname += tinfo.name;
				}
			}
			tbuf.append(qname);
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
		for (int i = 0; i < ns.length; i++) sbuf.append("}");
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
