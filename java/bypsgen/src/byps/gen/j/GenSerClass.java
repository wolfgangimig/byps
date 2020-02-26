package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBinaryModel;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

public class GenSerClass {
	static Logger log = LoggerFactory.getLogger(GenSerClass.class);
	
	static void generate(PrintContext pctxt, SerialInfo serInfo, BBinaryModel pformat) throws IOException {
		//log.debug(GenSerClass.class.getName(), "generate");
		
		CodePrinter pr = null;
		try {
			if (serInfo.isBuiltInType() || !serInfo.isPointerType()) {
				// No Serializer class for int, long, Exception, Enum ...
				return;
			}
			
			if (pformat == BBinaryModel.MEDIUM) { // print info only one time for each class
				log.info("Generate serializer class for type " + serInfo.typeId + ": " + serInfo);
			}

			if (serInfo.isArrayType()) {
				pr = pctxt.getPrinterForSerClass(serInfo, pformat);
				if (pformat == BBinaryModel.JSON) {
					new GenSerArrayJson(pctxt, serInfo, pr).generate();
				}
				else {
					new GenSerArray(pctxt, serInfo, pr).generate();
				}
			}
			else if (serInfo.isListType() || serInfo.isSetType()) {
				pr = pctxt.getPrinterForSerClass(serInfo, pformat);
				if (pformat == BBinaryModel.JSON) {
					new GenSerListJson(pctxt, serInfo, pr).generate();
				}
				else {
					new GenSerList(pctxt, serInfo, pr).generate();
				}
			}
			else if (serInfo.isMapType()) {
				pr = pctxt.getPrinterForSerClass(serInfo, pformat);
				if (pformat == BBinaryModel.JSON) {
					new GenSerMapJson(pctxt, serInfo, pr).generate();
				}
				else {
					new GenSerMap(pctxt, serInfo, pr).generate();
				}
			}
			else if (serInfo.isStubType()) {
				pr = pctxt.getPrinterForSerClass(serInfo, pformat);
				new GenSerStub(pctxt, serInfo, pr, pformat).generate();
			}
			else {
				pr = pctxt.getPrinterForSerClass(serInfo, pformat);
				if (pformat == BBinaryModel.JSON) {
					new GenSerStructJson(pctxt, serInfo, pr).generate();
				}
				else {
					new GenSerStruct(pctxt, serInfo, pr).generate();
				}
			}
		}
		finally {
			if (pr != null) pr.close();
		}
		
		//log.debug(GenSerClass.class.getName(), "generate");
	}
	
}
