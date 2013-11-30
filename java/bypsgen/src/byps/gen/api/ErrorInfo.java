package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
public class ErrorInfo {
	public String className;
	public String methodName;
	public String paramName;
	public String fieldName;
	public String typeArg;
	public String msg;
	
	public ErrorInfo() {}
	
	
	public ErrorInfo(ErrorInfo rhs) {
		this.className = rhs.className;
		this.methodName = rhs.methodName;
		this.paramName = rhs.paramName;
		this.fieldName = rhs.fieldName;
		this.typeArg = rhs.typeArg;
		this.msg = rhs.msg;
	}

	public ErrorInfo copy() { return new ErrorInfo(this); }

	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[class=");
		sbuf.append(className);
		
//		int p = className.lastIndexOf('.');
//		if (p >= 0) {
//		  sbuf.append("(").append(className.substring(p+1)).append(".java)");
//		}
		
		if (methodName != null) {
			sbuf.append(", method=").append(methodName);
			if (paramName != null) {
				sbuf.append(", param=").append(paramName);
			}
		}
		if (fieldName != null) {
			sbuf.append(", field=").append(fieldName);
		}
		if (typeArg != null) {
			sbuf.append(", arg=").append(typeArg);
		}
		if (msg != null) {
			sbuf.append(": ").append(msg);
		}
		sbuf.append("]");
		return sbuf.toString();
	}
}
