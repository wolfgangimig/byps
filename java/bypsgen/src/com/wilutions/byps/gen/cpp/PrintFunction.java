package com.wilutions.byps.gen.cpp;

import com.wilutions.byps.gen.utils.CodePrinter;

class PrintFunction {
	
	protected final String staticTag;
	protected final String name; 
	protected final String callTag;
	protected final String rtype; 
	protected final String[][] args;
	
	PrintFunction(String staticTag, String rtype, String name, String callTag, 
			String[][] args) {
		this.staticTag = staticTag;
		this.name = name;
		this.callTag = callTag;
		this.rtype = rtype;
		this.args = args;
	}

	protected String getDecl() {
		StringBuilder sbuf = new StringBuilder();
		if (staticTag != null && staticTag.length() != 0) {
			sbuf.append(staticTag).append(" ");
		}
		sbuf.append(rtype).append(" ");
		if (callTag != null & callTag.length() != 0) {
			sbuf.append(callTag).append(" ");
		}
		sbuf.append(name).append("(");
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				if (i != 0) sbuf.append(", ");
				sbuf.append(args[i][0]).append(" ").append(args[i][1]);
			}
		}
		sbuf.append(")");
		return sbuf.toString();
	}
	
	protected void printDecl(CodePrinter pr) {
		pr.print(getDecl()).println(";"); 
	}
	
	protected void beginImpl(CodePrinter pr) {
		pr.print(getDecl()).println(" {");
		pr.beginBlock();
	}
	
	protected void endImpl(CodePrinter pr) {
		pr.endBlock();
		pr.println("}");
	}
	
}
