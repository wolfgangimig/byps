package byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

class GenApiClassFwd {
	
	static Log log = LogFactory.getLog(GenApiClassFwd.class);
	
	static void generate(PrintContext pctxt, TypeInfo tinfo) throws IOException {
		if (tinfo == null) return;
		
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
//    else if (tinfo.isArrayType()) {
//      
//    }
		else if (tinfo.isCollectionType()) {
			// keine Forward-Decl für vector, set, map
		}
		else if (serInfo != null && serInfo.isResultClass()) {
			// kein shared_ptr benötigt 
		}
		else if (serInfo != null && serInfo.isRequestClass()) {
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
			
			boolean declPtrClass = true;
			if ((tinfo instanceof SerialInfo)) {
				declPtrClass = !((SerialInfo)tinfo).isRequestClass();
			}
			
			if (declPtrClass) {
			  if (tinfo.dims.length() > 2) {
			    String arrayName = className + "Array" + tinfo.dims.length() / 2;
			    pclassName = "P" + arrayName;
			    pr.print("typedef ").print(className).print(" ").print(arrayName);
			    pr.print("typedef byps_ptr< ").print(arrayName).print(" > ").print(pclassName).println("; ");
			  }
			  else {
			    pr.print("typedef byps_ptr< ").print(className).print(" > ").print(pclassName).println("; ");
			  }
			}
			
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
