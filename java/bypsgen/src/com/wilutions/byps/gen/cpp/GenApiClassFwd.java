package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenApiClassFwd {
	
	static Log log = LogFactory.getLog(GenApiClassFwd.class);
	
	static void generate(PrintContext pctxt, TypeInfo tinfo) throws IOException {
		
		log.info("Generate type " + tinfo.typeId + ": " + tinfo);
		CodePrinter prH = null;
		CodePrinter prCpp = null;
		
		SerialInfo serInfo = (tinfo instanceof SerialInfo) ? (SerialInfo)tinfo : null;
		
		if (tinfo.isBuiltInType()) {
			// Für int, long, java.lang.String, java.lang.Object, java.util.Map, usw.
			// werden keine Forward-Decl benötigt
		}
		else if (tinfo.isInline || tinfo.isEnum) {
			
		}
		else if (tinfo.isExceptionType()) {
			
		}
		else if (tinfo.isAnyType()) {
			
		}
		else if (tinfo.isCollectionType()) {
			// keine Forward-Decl für vector, set, map
		}
		else if (tinfo.isArrayType()) {
			// keine Forward-Decl für int[] usw. -> wird zu vector<int>
		}
		else if (serInfo != null && 
				(serInfo.isResultClass() || serInfo.isRequestClass())) {
			prH = pctxt.getPrImplAllH();
			prCpp = pctxt.getPrImplC();
		}
		else {
			prH = pctxt.getPrApiAllH();
			prCpp = pctxt.getPrImplC();
		}

		if (prH != null && prCpp != null) {
			new GenApiClassFwd(pctxt, tinfo, prH, prCpp).generate();
		}
		
	}

	private GenApiClassFwd(PrintContext pctxt, TypeInfo tinfo, CodePrinter prH, CodePrinter prCpp) {
		this.pctxt = pctxt;
		this.tinfo = tinfo;
		this.cppInfo = new TypeInfoCpp(tinfo);
		this.prH = prH;
	}
	
	private void generate() throws IOException {

		CodePrinter pr = prH;
		if (pr != null) {
			
			String className = cppInfo.getClassName(tinfo.pack);
			String pclassName = cppInfo.getTypeName(tinfo.pack);

			pr.println();
			pctxt.printLine(pr);
			pr.print("// Forward Declaration of class ").println(className);
			pr.println();
			
			pr.println(cppInfo.namespaceBegin);
			pr.println();
			pr.print("class ").print(className).println("; ");
			pr.print("typedef byps_ptr< ").print(className).print(" > ").print(pclassName).println("; ");
			pr.println();
			pr.print(cppInfo.namespaceEnd);
			pr.println();
		}
		
	}

	private final TypeInfo tinfo;
	private final TypeInfoCpp cppInfo;
	private final CodePrinter prH;
	
	private final PrintContext pctxt;
}
