package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BBinaryModel;
import byps.BRemote;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.PrintContextBase;
import byps.gen.utils.Utils;


class TypeInfoCpp {
	
  final TypeInfo tinfo;
	
	final String namespace;
	final String namespaceBegin;
	final String namespaceEnd;
	final String apiPack;
	
	TypeInfoCpp(TypeInfo tinfo, String apiPack) {
		this.tinfo = tinfo;
		this.namespace = makeNamespace(tinfo.pack);
		this.namespaceBegin = makeBeginNamespace(tinfo.pack);
		this.namespaceEnd = makeEndNamespace(tinfo.pack);
		this.apiPack = apiPack;
	}
	
	static TypeInfoCpp makeSerializerTypeInfoCpp(PrintContextBase pctxt, TypeInfo tinfo, String apiPack) {
		String name = pctxt.getSerializerClassName(tinfo, BBinaryModel.MEDIUM);
		String pack = pctxt.getSerializerPackage(tinfo);
		String qname = pack + "." + name;
		TypeInfo tinfoSerializer = new TypeInfo(name, qname, "", null, false, false, false);
		return new TypeInfoCpp(tinfoSerializer, apiPack);
	}

	String getClassName(String pack) {
		String name = makeCppName(pack, Purpose.CLASS);
		return name;
	}
	
	String getQClassName() {
		return getClassName("...");
	}
	
	String getTypeName(String pack) {
		String name = makeCppName(pack, Purpose.TYPE);
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
				baseInfo = new TypeInfoCpp(serInfo.baseInfo, apiPack);
			}
		}
		return baseInfo;
	}
	
	String toString(String currentPackage) {
		return makeCppName(currentPackage, Purpose.TYPE);
	}
	
	public String toString() {
		return toString("...");
	}
	
	private enum Purpose { CLASS, TYPE, PARAM, RETURN }
	
	private String makeCppName(String currentPackage, Purpose purpose) {
		StringBuilder tbuf = new StringBuilder();

		if (tinfo.isByteArray1dim()) {
			if (purpose == Purpose.CLASS) {
				tbuf.append("BBytes");
			}
			else {
				tbuf.append("PBytes");
			}
		}
		else if (tinfo.dims.length() != 0) {
			
			if (purpose == Purpose.CLASS) {
			  tbuf.append(makeComplexCollectionName(currentPackage, false));
			}
			else {
        tbuf.append(makeSimpleCollectionPointer( currentPackage));
			}
			
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
		else if (tinfo.qname.equals("java.util.Date")) tbuf.append("BDateTime");

		else if (tinfo.qname.equals(BRemote.class.getName())) {
			if (purpose == Purpose.CLASS) {
				tbuf.append("BRemote");
			}
			else {
				tbuf.append("PRemote");
			}
		}
		else if (tinfo.qname.equals("java.lang.Object")) {
			if (purpose == Purpose.CLASS) {
				tbuf.append("BSerializable");
			}
			else {
				tbuf.append("PSerializable");
			}
		}
		
		else if (tinfo.qname.equals("java.lang.String")) {
			if (purpose == Purpose.PARAM) tbuf.append("const ");
			tbuf.append("::std::wstring");
			if (purpose == Purpose.PARAM) tbuf.append("&");
		}
		
		else if (tinfo.qname.equals("java.io.InputStream")) {
			tbuf.append(purpose == Purpose.CLASS ? "BContentStream" : "PContentStream");
		}
		
		else if (tinfo.qname.equals("java.lang.Exception") || tinfo.qname.equals("java.lang.Throwable")) {
			if (purpose != Purpose.CLASS) tbuf.append("byps_ptr< ");
			tbuf.append("::std::exception");
			if (purpose != Purpose.CLASS) tbuf.append(" >");
		}
		
		else if (tinfo.isListType()) {
			if (purpose == Purpose.CLASS) {
        tbuf.append(makeComplexCollectionName( currentPackage, false));
			}
			else {
        tbuf.append(makeSimpleCollectionPointer( currentPackage));
			}
		}
		else if (tinfo.isMapType()) {
			if (purpose == Purpose.CLASS) {
        tbuf.append(makeComplexCollectionName( currentPackage, false));
			}
			else {
        tbuf.append(makeSimpleCollectionPointer( currentPackage));
			}
		}
		else if (tinfo.isSetType()) {
			if (purpose == Purpose.CLASS) {
        tbuf.append(makeComplexCollectionName( currentPackage, false));
			}
      else {
        tbuf.append(makeSimpleCollectionPointer( currentPackage));
      }
		}
		
//		else if (tinfo.isEnum) {
//			if (purpose == Purpose.CLASS) {
//				tbuf.append(tinfo.name); // Enum wird als namespace definiert
//			}
//			else {
//				tbuf.append("int32_t");
//			}
//		}
		
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

	public static String makeBeginNamespace(String pack) {
		String ns = pack.replaceAll("\\.", " { namespace ");
		return "namespace " + ns + " { ";
	}
	
	public static String makeEndNamespace(String pack) {
		String[] ns = pack.split("\\.");
		StringBuilder sbuf = new StringBuilder();
		for (int i = 0; i < ns.length; i++) sbuf.append("}");
		return sbuf.toString();
	}
	
	static String makeNamespace(String pack) {
		return pack.replaceAll("\\.", "::");
	}

	String getParamType(String pack) {
		return makeCppName(pack, Purpose.PARAM);
	}
	
	public String getCppPackage() {
    String pack = tinfo.pack;
    if (tinfo.isListType()) pack = tinfo.typeArgs.get(0).pack;
    else if (tinfo.isSetType()) pack = tinfo.typeArgs.get(0).pack;
    else if (tinfo.isMapType()) pack = tinfo.typeArgs.get(1).pack; // Value type
    if (pack.startsWith("java.")) pack = "byps";
    if (pack.length() == 0) pack = apiPack;
    return pack;
	}

  private String makeSimpleCollectionName(String currentPackage, boolean ptr) {
    StringBuilder tbuf = new StringBuilder();

    if (currentPackage != null) {
      String pack = getCppPackage();
      if (!currentPackage.equals(pack) && !tinfo.isPrimitiveType()) {
        tbuf.append(pack.replaceAll("\\.", "::")).append("::");
      }
    }
    
    tbuf.append(ptr ? 'P' : 'B');
    
    if (tinfo.isListType()) {
      tbuf.append("Vector");
      tbuf.append(Utils.firstCharToUpper(tinfo.typeArgs.get(0).name));
    }
    else if (tinfo.isSetType()) {
      tbuf.append("Set");
      tbuf.append(Utils.firstCharToUpper(tinfo.typeArgs.get(0).name));
    }
    else if (tinfo.isMapType()) {
      tbuf.append("Map");
      tbuf.append(Utils.firstCharToUpper(tinfo.typeArgs.get(0).name));
      tbuf.append(Utils.firstCharToUpper(tinfo.typeArgs.get(1).name));
    }
    else {
      tbuf.append("Array");
      int ndims = tinfo.dims.length() / 2;
      String sdims = ndims > 1 ? Integer.toString(ndims) : "";
      tbuf.append(sdims);
      tbuf.append(Utils.firstCharToUpper(tinfo.name));
    }

    return tbuf.toString();
  }
  
  public boolean isSimpleNameAvailable() {
    boolean ret = false;
    
    if (tinfo.isListType()) {
      // Forward typedef is generated for vector of simple types. 
      TypeInfo targ = tinfo.typeArgs.get(0); 
      if (!targ.isArrayType() && !targ.isCollectionType()) {
        ret = true;
      }
    }
    else if (tinfo.isSetType()) {
      // Forward typedef is generated for vector of primitive types. 
      TypeInfo targ = tinfo.typeArgs.get(0); 
      if (!targ.isArrayType() && targ.isPrimitiveType()) {
        ret = true;
      }
    }
    else if (tinfo.isMapType()) {
      // Forward typedef is generated for map of simple value types. 
      // (Key type can only be a primitive type.)
      TypeInfo targ = tinfo.typeArgs.get(1); 
      if (!targ.isArrayType() && !targ.isCollectionType()) {
        ret = true;
      }
    }
    else if (tinfo.isArrayType()) {
      ret = true;
    }
    
    return ret;
  }
  
  public String makeSimpleCollectionPointer(String currentPackage) {
    if (isSimpleNameAvailable()) {
      return makeSimpleCollectionName(currentPackage,true);
    }
    else {
      return makeComplexCollectionName(currentPackage, true);
    }
  }
  
  public String makeSimpleCollectionClass() {
    if (isSimpleNameAvailable()) {
      return makeSimpleCollectionName(null, false);
    }
    else {
      return makeComplexCollectionName("", false);
    }
  }
  
  private String makeComplexCollectionName(String currentPackage, boolean ptr) {
    StringBuilder tbuf = new StringBuilder();
    
    if (tinfo.isListType()) {
      if (ptr) tbuf.append("byps_ptr< ");
      TypeInfoCpp tinfoArg = new TypeInfoCpp(tinfo.typeArgs.get(0), apiPack);
      tbuf.append("::std::vector< ").append(tinfoArg.makeCppName(currentPackage, Purpose.TYPE)).append(" >");
      if (ptr) tbuf.append(" >");
    }
    else if (tinfo.isSetType()) {
      if (ptr) tbuf.append("byps_ptr< ");
      TypeInfoCpp tinfoArg = new TypeInfoCpp(tinfo.typeArgs.get(0), apiPack);
      tbuf.append("::std::set< ").append(tinfoArg.makeCppName(currentPackage, Purpose.TYPE)).append(" >");    
      if (ptr) tbuf.append(" >");
    }
    else if (tinfo.isMapType()) {
      if (ptr) tbuf.append("byps_ptr< ");
      TypeInfoCpp tinfoArg0 = new TypeInfoCpp(tinfo.typeArgs.get(0), apiPack);
      TypeInfoCpp tinfoArg1 = new TypeInfoCpp(tinfo.typeArgs.get(1), apiPack);
      tbuf.append("::std::map< ")
      .append(tinfoArg0.makeCppName(currentPackage, Purpose.TYPE)).append(" , ")
      .append(tinfoArg1.makeCppName(currentPackage, Purpose.TYPE)).append(" >");
      if (ptr) tbuf.append(" >");
    }
    else {
      if (ptr) tbuf.append("byps_ptr< ");
      int ndims = tinfo.dims.length() / 2;
      tbuf.append("::byps::BArray").append(ndims).append("< ");
      TypeInfo tinfoArg = new TypeInfo(tinfo.name, tinfo.qname, "", null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
      TypeInfoCpp tinfoArgCpp = new TypeInfoCpp(tinfoArg, apiPack);
      tbuf.append(tinfoArgCpp.makeCppName(currentPackage, Purpose.TYPE));
      tbuf.append(" > ");
      if (ptr) tbuf.append(" >");
    }
    
    return tbuf.toString();
  }
	
	private final static String POINTER_CLASS_PREFIX = "P";


}
