package byps.gen.c;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.SerialInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;

public class GeneratorC implements Generator {
	
	public GeneratorC() {
	}
	
	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		
		pctxt = new PrintContext(classDB, props);
		printForwardDeclSerials(classDB.getSerials());
		
		pctxt.close();
	}
	
	protected void printForwardDecls(ClassDB classDB) {
		
		
	}
	
	protected void printForwardDeclSerials(Iterable<SerialInfo> serials) {
		CodePrinter pr = pctxt.prApiAllH;
		
		pr.println();
		pr.println("/*FWD_DECL_SERIALS_BEGIN*/");
		pr.println();
		pr.println();
		
		for (SerialInfo serial : serials) {
			pr.println();
			printForwardDeclSerial(serial);
			pr.println();
		}
		
		pr.println();
		pr.println("/*FWD_DECL_SERIALS_END*/");
		pr.println();
		pr.println();
	}
	
	protected void printForwardDeclSerial(SerialInfo serial) {
		GenSerial genser = new GenSerial(serial,pctxt);
		genser.printForwardDecl("");
		genser.printForwardDecl("[]");
	}
	
	private PrintContext pctxt;
}
