package com.wilutions.byps.gen.js;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenConstObject {
	
	static Log log = LogFactory.getLog(GenConstObject.class);
	
	static void generate(CustomControl fact, PrintContext pctxt, SerialInfo serInfo) throws IOException {
		log.debug("generate(" + serInfo);
		if (serInfo.isCollectionType()) {
			// No API class for List<>...
		}
		else if (serInfo.isArrayType()) {
			// No API class for int[]...
		}
		else if (serInfo.isStubType()) {
			// Stub API class is generated by GenRemoteStub
		}
		else if (serInfo.typeId < pctxt.classDB.getRegistry().getMinTypeIdUser()){
			// No API class for RemoteException ...
		}
		else if (serInfo.isResultClass() || serInfo.isRequestClass()) {
			// JSON API does not need a class for results or requests 
		}
		else if (serInfo.isEnum) {
			// Enum objects are created in GenConstClass
		}
		else  {
			log.info("Generate API class for type " + serInfo.typeId + ": " + serInfo);
			CodePrinter pr = pctxt.getPrinter();
			fact.createGenConstObject(pctxt, serInfo, pr).generate();
			pr.close();
		}
		log.debug(")generate");
	}
	
	protected GenConstObject(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serInfo = serInfo;
		this.pr = pr;
	}
	
	
	private void generate() throws IOException {
		log.debug("generate");

		String objName = pctxt.getConstObjectName(serInfo);
		
		if (objName != null) {
			
			pctxt.printComments(pr, serInfo.comments);
		
			pr.print(objName).print(" = new ").print(objName).print("_Type();");
			pr.println();
			pr.println();

		}
		
		log.debug(")generate");
	}
	
	private final SerialInfo serInfo;
	private final CodePrinter pr;
	private final PrintContext pctxt;
}
