package byps.gen.api;

import java.util.ArrayList;
import java.util.List;

import byps.BBinaryModel;

public class TypeInfo {
	
	public final String name;
	public final String qname;
	public final String pack;
	public final String dims;
	
	public boolean isEnum;
	public boolean isFinal;
	
	
	// Strukturen, die ohne vorangestellte typeId in den Stream geschrieben werden.
	// Objekte dürfen nicht null sein.
	// Objekte müssen feste Größe haben (z.B nicht String oder ArrayList)
	// Z.B. 3x3-Matrix
	public boolean isInline;
	
	public int typeId;
	
	public List<TypeInfo> typeArgs;
		
	public TypeInfo(String name, String qname, String dims, List<TypeInfo> typeArgs, 
			boolean isEnum, boolean isFinal, boolean isInline)  {
		this.name = name;
		this.qname = qname;
		this.dims = dims;
		this.pack = getPackageFromQName(qname);
		this.typeArgs = typeArgs != null ? typeArgs : new ArrayList<TypeInfo>(0);
		this.isInline = isInline;
		this.isEnum = isEnum;
		this.isFinal = isFinal;
		
		
//		if (qname.equals("java.lang.Character") || qname.equals("char")) {
//			
//			throw new IllegalStateException("char is unsupported");
//		}
	}
	
	public TypeInfo() {
		this(null,null,null,null,false,false,false);
	}
	
	public static String getPackageFromQName(String qname) {
		if (qname == null) return null;
		String pack = "";
		int p = qname.lastIndexOf('.');
		if (p >= 0) pack = qname.substring(0, p);
		return pack;
	}
	
	public String toString(String currentPackage) {
		return toStringNoDims(new String[] {currentPackage, "byps"}) + getDimsAsString();
	}
	
	public String toString(String[] importedPackages) {
		return toStringNoDims(importedPackages) + getDimsAsString();
	}
	
	protected String getDimsAsString() {
		return dims;
	}
	
	public String getTypeCast(String currentPackage) {
		String ret = "";
//		if (pack.equals(currentPackage)) {
//			ret = name;
//		}
//		else {
//			ret = qname;
//		}
//		return ret + getDimsAsString();
		
		ret = toString(currentPackage);
		return ret;
	}
	
	public String toString() {
		return toString(new String[] {});
	}

	public String getTypeCast() {
		return getTypeCast("...");
	}
	
	public static String getXmlTypeName(String fullName) {
		return fullName.replace('<', '{').replace('>', '}');
	}
	
	public static String getInfoTypeName(String xmlTypeName) {
		return xmlTypeName.replace('{', '<').replace('}', '>');
	}
	
	public String toXmlTypeName() {
		String fullName = toString();
		return getXmlTypeName(fullName);
	}
	
	private static class ParseContext {
		int lastIdx;
	}

	private static TypeInfo parseOneType(String s, ParseContext pctxt) {
		int idx = pctxt.lastIdx;
		
		String qname;
		ArrayList<TypeInfo> typeArgs;

		int b = s.indexOf('{', idx);
		if (b < 0) b = s.length();
		int k = s.indexOf(',', idx);
		if (k < 0) k = s.length();
		int e = s.indexOf('}', idx);
		if (e < 0) e = s.length();

		// Typ durch "," beendet oder s.length erreicht: Integer,
		if (k <= b && k <= e) {
			qname = s.substring(idx, k);
			typeArgs = new ArrayList<TypeInfo>(0);
			idx = k;
		}
		// Typ durch "}" beendet: Double}
		else if (e < b) {
			qname = s.substring(idx, e);
			typeArgs = new ArrayList<TypeInfo>(0);
			idx = e;
		}
		// Es beginnt ein neuer Typ: ...{java.u...
		else {
			qname = s.substring(idx, b);
			typeArgs = new ArrayList<TypeInfo>();
			pctxt.lastIdx = b;
			do {
				pctxt.lastIdx++;
				TypeInfo a = parseOneType(s, pctxt);
				typeArgs.add(a);
			} while (s.charAt(pctxt.lastIdx) == ',');
			idx = pctxt.lastIdx + 1;
		}
		
		String dims = "";
		int p = qname.indexOf("[");
		if (p >= 0) {
			dims = qname.substring(p);
			qname = qname.substring(0, p);
		}

		String name = qname;
		p = qname.lastIndexOf('.');
		if (p >= 0) name = qname.substring(p+1);
		
		pctxt.lastIdx = idx;
		return new TypeInfo(name, qname, dims, typeArgs, false, false, false);
	}
	
	// fullName = java.util.HashMap{Long,Map{Integer,Double}}
	public static TypeInfo fromXmlFullName(String fullName) {
		return parseOneType(fullName, new ParseContext());
	}

	public String toStringNoDims(String currentPackage) {
		return toStringNoDims(new String[] {currentPackage});
	}
	
	public String toStringNoDims(String[] importedPackages) {
		StringBuilder sbuf = new StringBuilder();
		
		boolean withQName = true;
		if (importedPackages != null) {
			for (String imppack : importedPackages) {
				withQName = !pack.equals(imppack);
				if (!withQName) break;
			}
		}		
		
		if (withQName) {
			sbuf.append(qname);
		}
		else {
			sbuf.append(name);
		}
		
		if (typeArgs != null && typeArgs.size() != 0) {
			sbuf.append("<");
			boolean first = true;
			for (TypeInfo argInfo : typeArgs) {
				if (!first) sbuf.append(","); 
				sbuf.append(argInfo.toString(importedPackages));
				first = false;
			}
			sbuf.append(">");
		}
		return sbuf.toString();
	}

	public boolean isCollectionType() {
		if (isArrayType()) return false;
		return isListType() || isMapType() || isSetType();
	}
	
	public boolean isListType() {
		return qname.startsWith("java.util.List") ||
			qname.startsWith("java.util.ArrayList") || 
			qname.startsWith("java.util.LinkedList");
	}
	
	public boolean isMapType() {
		return qname.startsWith("java.util.Map") ||
			qname.startsWith("java.util.HashMap") || 
			qname.startsWith("java.util.TreeMap");
	}
	
	public boolean isSetType() {
		return qname.startsWith("java.util.Set") ||
			qname.startsWith("java.util.HashSet") || 
			qname.startsWith("java.util.TreeSet");
	}
	
	public boolean isUnique() {
		return qname.equals("java.lang.String");
	}
	
	public boolean isPrimitiveType() {
		return  false 
				||  qname.equals("boolean")
				||  qname.equals("java.lang.Boolean")
				||  qname.equals("byte")
				||  qname.equals("java.lang.Byte")
				||  qname.equals("char")
				||  qname.equals("java.lang.Character")
				||  qname.equals("short")
				||  qname.equals("java.lang.Short")
				||  qname.equals("int")
				||  qname.equals("java.lang.Integer")
				||  qname.equals("long")
				||  qname.equals("java.lang.Long")
				||  qname.equals("float")
				||  qname.equals("java.lang.Float")
				||  qname.equals("double")
				||  qname.equals("java.lang.Double")
				||  qname.equals("void")
				||  qname.equals("java.lang.String")
				||  qname.equals("java.util.Date")
				;
	}
	
	public boolean isBuiltInType() {
		if (isArrayType()) return false;
		if (isListType() && typeArgs.get(0).isAnyType()) return true;
		if (isSetType() && typeArgs.get(0).isAnyType()) return true;
		if (isMapType() && typeArgs.get(0).isAnyType() && typeArgs.get(1).isAnyType()) return true;
		if (isPrimitiveType()) return true;
		if (isExceptionType()) return true;
		return qname.equals("java.lang.Object") 
				|| qname.equals("java.lang.String")
				|| qname.equals("byps.BValueClass");
	}
	
	public boolean isPointerType() {
		if (isArrayType()) return true;
		if (isCollectionType()) return true;
		if (isPrimitiveType()) return false;
		if (isEnum) return false;
		return true; 
	}
	
	public boolean isAnyType() {
		return qname.equals("java.lang.Object") && dims.length() == 0;
	}

	public boolean isStringType() {
		return qname.equals("java.lang.String");
	}

	public boolean isVoidType() {
		return qname.equals("void") || qname.equals("java.lang.Void");
	}

	public boolean isArrayType() {
		return dims.length() != 0;
	}
	
	public boolean isByteArray1dim() {
		return toString().equals("byte[]");
	}

	public boolean isExceptionType() {
		if (qname.equals("java.lang.Exception")) return true;
		if (qname.equals("java.lang.Throwable")) return true;
		return false;
	}
	
	public boolean isInheritable() {
		if (isInline) return false;
		if (isEnum) return false;
		if (isCollectionType()) return false;
		if (isPrimitiveType()) return false;
		if (isArrayType()) return false;
		return true;
	}
	
	public boolean isDateType() {
	  return qname.equals("java.util.Date");
	}

	public int getMemberSize(BBinaryModel bmodel) {
		int size = bmodel.pointerSize;
		if (dims.length() == 0) {
			if (qname.equals("boolean")) size = 4;
			else if (qname.equals("java.lang.Boolean")) size = 4;
			else if (qname.equals("byte")) size = 1;
			else if (qname.equals("java.lang.Byte")) size = 1;
			else if (qname.equals("char")) size = 2;
			else if (qname.equals("java.lang.Character")) size = 2;
			else if (qname.equals("short")) size = 2;
			else if (qname.equals("java.lang.Short")) size = 2;
			else if (qname.equals("int")) size = 4;
			else if (qname.equals("java.lang.Integer")) size = 4;
			else if (qname.equals("long")) size = 8;
			else if (qname.equals("java.lang.Long")) size = 8;
			else if (qname.equals("float")) size = 4;
			else if (qname.equals("java.lang.Float")) size = 4;
			else if (qname.equals("double")) size = 8;
			else if (qname.equals("java.lang.Double")) size = 8;
		}
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dims == null) ? 0 : dims.hashCode());
		result = prime * result + ((qname == null) ? 0 : qname.hashCode());
		result = prime * result
				+ ((typeArgs == null) ? 0 : typeArgs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeInfo other = (TypeInfo) obj;
		if (dims == null) {
			if (other.dims != null)
				return false;
		} else if (!dims.equals(other.dims))
			return false;
		if (qname == null) {
			if (other.qname != null)
				return false;
		} else if (!qname.equals(other.qname))
			return false;
		if (typeArgs == null) {
			if (other.typeArgs != null)
				return false;
		} else if (!typeArgs.equals(other.typeArgs))
			return false;
		return true;
	}


}
