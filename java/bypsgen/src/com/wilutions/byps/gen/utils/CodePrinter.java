package com.wilutions.byps.gen.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;

public class CodePrinter {
	
	public CodePrinter(CodePrinter pr) {
		this.pr = pr.pr;
	}
	
	public CodePrinter(PrintWriter pr) {
		this.pr = pr;
	}
	
	public CodePrinter(PrintWriter pr, String indent) {
		this.pr = pr;
		this.indent = indent;
	}
	
	public CodePrinter(OutputStream os, boolean utf8) throws IOException {
		if (utf8) {
			os.write((byte)0xEF);
			os.write((byte)0xBB);
			os.write((byte)0xBF);
		}
		OutputStreamWriter wr = utf8 ? new OutputStreamWriter(os, "UTF-8") : new OutputStreamWriter(os); 
		this.pr = new PrintWriter(wr);
	}
	
	public CodePrinter(OutputStream os) throws IOException {
		this(os, true);
	}
	
	public CodePrinter print(String s) {
		pr.print(indent);
		pr.print(s);
		return new CodePrinter(pr, "");
	}
	
	public CodePrinter print(int n) {
		pr.print(indent);
		pr.print(n);
		return new CodePrinter(pr, "");
	}
	
	public CodePrinter print(long n) {
		pr.print(indent);
		pr.print(n);
		return new CodePrinter(pr, "");
	}
	
	public CodePrinter print(String fmt, Object ... args) {
		pr.print(indent);
		String s = MessageFormat.format(fmt, args);
		pr.print(s);
		return new CodePrinter(pr, "");
	}
	public void println(String s) {
		pr.print(indent);
		pr.println(s);
	}
	public void println() {
		pr.print(indent);
		pr.println();
	}
	public void beginBlock() {
		indent += "\t";
	}
	public void endBlock() {
		if (indent.length() >= 1) {
			indent = indent.substring(1);
		}
	}
	public void line() {
		pr.println(sepline);
	}

	public void close() {
		pr.close();
	}
	
	public void flush() {
		pr.flush();
	}
	
	public void printWhereIAm(Class<?> clazz) {
	    int lineNumber = 0;
	    StackTraceElement[] stackTraceElement = Thread.currentThread()
	            .getStackTrace();
	    int currentIndex = -1;
	    for (int i = 0; i < stackTraceElement.length; i++) {
	        if (stackTraceElement[i].getMethodName().compareTo("printWhereIAm") == 0)
	        {
	            currentIndex = i + 1;
	            break;
	        }
	    }
	    lineNumber = stackTraceElement[currentIndex].getLineNumber();
	    
	    println("// generated at " + clazz.toString() + ":" + lineNumber);
	}
	
	
	private PrintWriter pr;
	private String indent = "";
	private String sepline = "--------------------------------------------------------";
}
