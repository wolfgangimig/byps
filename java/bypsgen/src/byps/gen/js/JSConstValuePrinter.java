package byps.gen.js;

import byps.BException;
import byps.BJsonObject;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.ts.PrintContext;
import byps.gen.utils.PrintContextBase;

import java.io.IOException;
import java.util.Base64;

public class JSConstValuePrinter {

	private PrintContextBase printContext;

	public JSConstValuePrinter(PrintContextBase printContext) {
		this.printContext = printContext;
	}

	public String printConstValue(TypeInfo tinfo, Object value) {
		try {
			return internalPrint(tinfo, value);
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	private String internalPrint(TypeInfo tinfo, Object value)
		throws BException, GeneratorException {
		StringBuilder sbuf = new StringBuilder();

		if (tinfo.dims.length() != 0) {
			BJsonObject js = BJsonObject.fromString((String) value);
			sbuf.append(makeNewArrayInstance(tinfo, js));
		} else if (tinfo.qname.equals("java.lang.String")) {
			String s = (String) value;
			sbuf.append("\"");
			for (int i = 0; i < s.length(); i++) {
				sbuf.append(printStringChar(s.charAt(i)));
			}
			sbuf.append("\"");
		} else if (tinfo.qname.equals("char")) {
			String s = (String) value;
			sbuf.append("\'");
			sbuf.append(printStringChar(s.charAt(0)));
			sbuf.append("\'");
		} else if (tinfo.qname.equals("boolean")) {
			if (value instanceof Number) {
				value = ((Number) value).longValue();
			}
			sbuf.append(value);
		} else if (tinfo.qname.equals("byte")) {
			if (value instanceof Number) {
				value = ((Number) value).longValue();
			}
			sbuf.append(value);
		} else if (tinfo.qname.equals("short")) {
			if (value instanceof Number) {
				value = ((Number) value).longValue();
			}
			sbuf.append(value);
		} else if (tinfo.qname.equals("int")) {
			if (value instanceof Number) {
				value = ((Number) value).longValue();
			}
			sbuf.append(value);
		} else if (tinfo.qname.equals("long")) {
			if (value instanceof Number) {
				value = ((Number) value).longValue();
			}
			// Values may come as long or as string in the format "number.".
			// Appending another . would disallow working with the value as number.
			String stringValue = "" + value;
			if (!stringValue.endsWith(".")) {
				stringValue += ".";
			}
			sbuf.append("\"").append(stringValue).append("\"");
		} else if (tinfo.qname.equals("double")) {
			sbuf.append(value);
		} else if (tinfo.qname.equals("float")) {
			sbuf.append(value);
		} else if (value instanceof BJsonObject) {
			sbuf.append(makeNewInstance(tinfo, (BJsonObject) value));
		} else if (tinfo.isEnum) {
			// BYPS-57: Behandlung von Enum-Werten in Konstantenobjekten.
			sbuf.append(tinfo.qname).append(".").append(value);
		} else {
			BJsonObject js = BJsonObject.fromString((String) value);
			sbuf.append(makeNewInstance(tinfo, js));
		}

		return sbuf.toString();
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

	private String makeNewInstance(TypeInfo tinfo, BJsonObject params) throws GeneratorException, BException {
		if (params == null) return "null";

		StringBuilder sbuf = new StringBuilder();
		SerialInfo sinfo = null;
		for (SerialInfo s : printContext.classDB.getSerials()) {
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


	private String makeNewArrayInstance(TypeInfo tinfo, BJsonObject js) throws BException, GeneratorException {
		if (js == null) return "null";
		StringBuilder sbuf = new StringBuilder();
		if (tinfo.isByteArray1dim()) {
			byte[] binaryData = new byte[js.size()];
			for (int i = 0; i < js.size(); i++) {
				binaryData[i] = js.getByte(i);
			}
			String s = Base64.getEncoder().encodeToString(binaryData);
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
}
