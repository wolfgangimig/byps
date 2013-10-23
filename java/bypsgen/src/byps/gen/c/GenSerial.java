package byps.gen.c;

import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.Utils;

class GenSerial {
	
	GenSerial(SerialInfo serial, PrintContext pctxt) {
		this.pctxt = pctxt;
		this.serial = serial;
	}
	
	
	void printForwardDecl(String dims) {

		int dimCount = Utils.getDimCount(dims);

		CodePrinter pr = pctxt.prApiAllH;
		CodePrinter prC = pctxt.prImplC;
		
		String typeIdSymbol = pctxt.getTypeIdSymbol(serial);
		String structName = pctxt.getStructName(serial,dims);
		String pointerName = pctxt.getPointerName(serial,dims);
		String rpointerName = pctxt.getRPointerName(serial,dims);

		pr.println("/*");
		pr.line();
		pr.print("  Forward declaration of {0}", pointerName); pr.println();
		pr.println();
		pr.print("  Structure type name:  {0}", structName); pr.println();
		pr.print("  Pointer type name  :  {0}", pointerName); pr.println();
		pr.print("  RPointer type name :  {0}", rpointerName); pr.println();
		pr.print("  Type ID            :  {0}", typeIdSymbol); pr.println();
		pr.line();

		pr.println("*/");
		pr.println();
		pr.println(dims.length() == 0 ? "/*FWD_DECL_SERIAL_BEGIN*/" : "/*FWD_DECL_SERIAL_ARRAY_BEGIN*/");
		pr.println();
		
		if (dims.length() == 0) {

			// #define Person_TypeId ((BTYPEID)1234L)
			pr.print("#define {0} ((BTYPEID){1}L)", typeIdSymbol, serial.typeId); 
			pr.println(); pr.println();
			
			// struct _Person;
			pr.print("struct {0};", structName); pr.println();
		}
		else {
			// struct _Array_Person { struct _BObject __typeInfo; BUINT32 length[2]; BUINT32 __padding; RPerson *data; };
			pr.print("struct {0} '{' struct _BObject __typeInfo; BUINT32 length{2}; {3}{1} *items; '}';", 
					structName, 
					pctxt.getRPointerName(serial, ""),
					dimCount > 1 ? "[" + dims + "]" : "",
					(dimCount & 1) != 0 ? "BUINT32 __padding; " : ""); 
			pr.println();
		}

		// typedef struct _Person *Person;
		pr.print("typedef struct {0} *{1};", structName, pointerName); pr.println();

		// typedef union { Person p; BOBJECTID __id; } RPerson;
		pr.print("typedef union '{' {0} p; BOBJECTID __id; '}' {1};", pointerName, rpointerName); pr.println();
		
		// RPerson BAPI Person_Init(Person v);
		pr.println();
		printRPointerInit(pr, prC, rpointerName, pointerName, typeIdSymbol, dimCount);
		pr.println();
		
		pr.println(); 
		pr.println(dimCount == 0 ? "/*FWD_DECL_SERIAL_END*/" : "/*FWD_DECL_SERIAL_ARRAY_END*/");
		pr.println();	
	}

	void printStructDecl() {

		CodePrinter pr = pctxt.prApiAllH;
		CodePrinter prC = pctxt.prImplC;
		
		String typeIdSymbol = pctxt.getTypeIdSymbol(serial);
		String structName = pctxt.getStructName(serial,"");
		String pointerName = pctxt.getPointerName(serial,"");
		String rpointerName = pctxt.getRPointerName(serial,"");

		pr.println("/*");
		pr.line();
		pr.print("  Declaration of {0}", pointerName); pr.println();
		pr.line();
		pr.println("*/");
		
		pr.println();
		pr.println("/*DECL_SERIAL_BEGIN*/");
		pr.println();
				
		pr.print("struct {0} '{'", structName); pr.println();
		pr.println();
		pr.beginBlock();
		pr.println("struct _BObject __typeInfo;");
		
		pr.endBlock();
		
		pr.println(); 
		pr.println("/*DECL_SERIAL_END*/");
		pr.println();	
	}


	/**
	 * Print RPointer initialization funtion.
	 * <pre>
	 * {@code
	 * RPerson BAPI Person_Init(Person v) {
     *   RPerson ret;
     *   ret.__id = BObject_Init(&v->__typeInfo, Person_TypeId, sizeof(struct _Person)).__id;
     *   return ret;
     * }
     * }
	 * </pre>
	 * @param prH Printer for header file
	 * @param prC Printer for source file
	 * @param rpointerName RPointer type name
	 * @param pointerName Pointer type name
	 * @param dimCount If > 0, array dimensions
	 */
	private void printRPointerInit(CodePrinter prH, CodePrinter prC, String rpointerName, String pointerName, String typeIdSymbol, int dimCount) {
		
		PrintFunction pf = new PrintFunction(null, rpointerName, pointerName + "_Init", "BAPI", 
				new String[][] {{pointerName, "v"}});
		pf.printDecl(prH);

		pf.beginImpl(prC);

		if (dimCount == 0) {
			prC.print(rpointerName); prC.println(" ret;"); 
			prC.print("ret.__id = BObject_Init(&v->__typeInfo, {0}, sizeof(struct {1})).__id;", typeIdSymbol, pointerName); prC.println();
			prC.println("return ret;");
		}
		else {
			prC.print("RArray ret = BArray_Init((BObject)v, {0});", typeIdSymbol); prC.println();
		    prC.print("return BObject_RCast({0}, ret);", rpointerName); prC.println();
		}
		pf.endImpl(prC);
	}
	
	private final PrintContext pctxt;
	private final SerialInfo serial;
}
