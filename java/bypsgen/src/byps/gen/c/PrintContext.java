package byps.gen.c;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import byps.BApiDescriptor;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.SplitFileOutputStream;
import byps.gen.utils.Utils;

class PrintContext {
	
	CodePrinter prImplC;

	CodePrinter prApiAllH;
	
	CodePrinter prImplAllH;

	public final ClassDB classDB;

	PrintContext(ClassDB classDB, GeneratorProperties props) throws IOException {
		BApiDescriptor apiDesc = classDB.getApiDescriptor();
		
		this.classDB = classDB;
		dirApi = props.getMandatoryPropertyFile(PropertiesC.DEST_DIR_API);
		dirImplC = props.getOptionalPropertyFile(PropertiesC.DEST_DIR_IMPL_C, dirApi);
		dirImplH = props.getOptionalPropertyFile(PropertiesC.DEST_DIR_IMPL_H, dirImplC);
		packageAliasMap = props.getPropertyAsMap(PropertiesC.PACK_ALIAS, null);
		apiName = apiDesc.name;
		maxFileSize = props.getOptionalPropertyInt(PropertiesC.MAX_FILE_SIZE, 100 * 1000);
		
		dirApi.mkdirs();
		dirImplC.mkdirs();
		dirImplH.mkdirs();

		File fileApiAllH = new File(dirApi, apiName + "-api.h");
		prApiAllH = new CodePrinter(new FileOutputStream(fileApiAllH));
		prApiAllH.print("#ifndef __{0}__", apiName + "_api_H"); prApiAllH.println();
		prApiAllH.print("#define __{0}__", apiName + "_api_H"); prApiAllH.println();
		prApiAllH.println();
		prApiAllH.println("#include <byps.h>");
		prApiAllH.println("#pragma pack(push, 8)");
		
		File fileImplAllH = new File(dirImplH, apiName + "-impl.h");
		prImplAllH = new CodePrinter(new FileOutputStream(fileImplAllH));
		prImplAllH.print("#ifndef __{0}__", apiName + "_impl_H"); prImplAllH.println();
		prImplAllH.print("#define __{0}__", apiName + "_impl_H"); prImplAllH.println();
		prImplAllH.println();
		prImplAllH.print("#include <{0}>", apiName + "-api.h");
		prImplAllH.println();
		prImplAllH.println();

		//OutputStream osApiH = new SplitFileOutputStreamHeader(prApiAllH, dirApi, apiName + "-api-{0}.h", maxFileSize);
		//prApiH = new CodePrinter(osApiH);

		//OutputStream osImplH = new SplitFileOutputStreamHeader(prImplAllH, dirImplH, apiName + "-impl-{0}.h", maxFileSize);
		//prImplH = new CodePrinter(osImplH);

		OutputStream osImplC = new SplitFileOutputStreamSource(null, dirImplC, apiName + "-impl-{0}.c", maxFileSize);
		prImplC = new CodePrinter(osImplC);
		prImplC.print("#include \"{0}\"", 
				getDirRelative(dirImplC.getAbsolutePath(), dirImplH.getAbsolutePath()) + apiName + "-impl.h");
		prImplC.println(); 
		prImplC.println();
		
	}
	
	void close() throws IOException {
		prImplC.close();

		prApiAllH.println("##pragma pack(pop)");
		prApiAllH.println("#endif");
		prApiAllH.close();
		
		prImplAllH.println("#endif");
		prImplAllH.close();
	}
	
	/**
	 * C type name of pointer.
	 * If no package alias is defined, the returned pointer name is equal to tinfo.name.
	 * Otherwise the pointer name is computed as: [alias]_[tinfo.name].
	 * @param tinfo Type descriptor 
	 * @param dims if not empty, array dimensions
	 * @return Pointer name
	 */
	String getPointerName(SerialInfo tinfo, String dims) {
		return internalGetPointerName(tinfo, dims, false);
	}
	
	/**
	 * C type name of structure.
	 * The structure name is built by _[pointer-name]. 
	 * @param tinfo Type descriptor
	 * @param dims if not empty, array dimensions
	 * @return Pointer name
	 */
	String getStructName(SerialInfo tinfo, String dims) {
		return "_" + getPointerName(tinfo, dims);
	}
	
	/**
	 * Generates the #define symbol for the type ID.
	 * The symbol is computed by [pointer-name]_TypeId
	 * @param tinfo Type descriptor
	 * @return Type ID symbol
	 */
	String getTypeIdSymbol(SerialInfo tinfo) {
		return getPointerName(tinfo, "") + "_TypeId";
	}
	
	/**
	 * Union type name of R-pointer.
	 * Returns R[pointer-name].
	 * @param tinfo Type descriptor
	 * @param dims if not empty, array dimensions
	 * @return Type ID symbol
	 */
	String getRPointerName(SerialInfo tinfo, String dims) {
		return internalGetPointerName(tinfo, dims, true);
	}
	
	String getTypeC(TypeInfo tinfo, int dims) {
		String tname = "";
		if (tinfo.name.equals("boolean")) tname = "BBOOL";
		else if (tinfo.name.equals("byte")) tname = "BBYTE";
		else if (tinfo.name.equals("char")) tname = "BWCHAR";
		else if (tinfo.name.equals("int")) tname = "BINT32";
		else if (tinfo.name.equals("long")) tname = "BINT64";
		else if (tinfo.name.equals("float")) tname = "BFLOAT";
		else if (tinfo.name.equals("double")) tname = "BDOUBLE";
		else if (tinfo.name.equals("String")) tname = "RSTRING_UTF16";
		else if (tinfo.name.equals("Object")) tname = "RObject";
		return tname;
	}
	
//	private static class SplitFileOutputStreamHeader extends SplitFileOutputStream {
//		private CodePrinter prAll;
//		public SplitFileOutputStreamHeader(CodePrinter prAll, File dir, String fileNameFormat, int maxFileSize) {
//			super(dir, fileNameFormat, maxFileSize);
//			this.prAll = prAll;
//		}
//		@Override
//		public void onClosedSplitFile(File closedFile) {
//			prAll.print("#include \"");
//			prAll.print(closedFile.getName());
//			prAll.println("\"");
//		}
//		@Override
//		public void onOpenedSplitFile(File openedFile) {
//		}
//	};

	private static class SplitFileOutputStreamSource extends SplitFileOutputStream {
		public SplitFileOutputStreamSource(CodePrinter prAll, File dir, String fileNameFormat, int maxFileSize) throws IOException {
			super(dir, fileNameFormat, maxFileSize);
		}
		@Override
		public void onClosedSplitFile(File closedFile) {
		}
		@Override
		public void onOpenedSplitFile() {
		}
	};

	/**
	 * Return the directory dirAbs relative to dirBase
	 * @param dirBase Base directory
	 * @param dirAbs Absolute directory
	 * @return Relative directory
	 */
	private static String getDirRelative(String dirBase, String dirAbs) {
		StringBuilder dirRel = new StringBuilder();
		
		// Example 1
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/impl/header
		// dirRel=../header/
		
		// Example 2
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/impl/source/header
		// dirRel=header/

		// Example 3
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/header-impl
		// dirRel=../../header/

		String[] dirsBase = dirBase.split("\\" + File.separator);
		String[] dirsAbs = dirAbs.split("\\" + File.separator);
		int i = 0;
		while (i < dirsBase.length && i < dirsAbs.length && 
				dirsBase[i].equalsIgnoreCase(dirsAbs[i])) {
			i++;
		}
		
		// Example 1, i=6, dirsBase[i..] = {source}, dirsAbs[i...] = {header}
		// Example 2, i=7, dirsBase[i..] = {}, dirsAbs[i...] = {header}
		// Example 3, i=5, dirsBase[i..] = {impl, source}, dirsAbs[i...] = {header-impl}
		
		for (int j = i; j < dirsAbs.length; j++) {
			dirRel.append("..").append(File.separator);
		}
		for (int j = i; j < dirsAbs.length; j++) {
			dirRel.append(dirsAbs[j]).append(File.separator);
		}

		return dirRel.toString();
	}
	
	private String internalGetPointerName(SerialInfo tinfo, String dims, boolean isRPointer) {
		String palias = packageAliasMap.get(tinfo.pack);
		String r = tinfo.name;

		int dimCount = Utils.getDimCount(dims);
		if (dimCount == 0) {
			
		} else if (dimCount == 1) {
			r = "Array_" + r; 
		}
		else {
			r = "Array" + dimCount + "_" + r;
		}

		if (isRPointer) {
			r = "R" + r;
		}
		
		if (palias != null) {
			r = palias + "_" + r;
		}
		
		return r;
	}
	
	private String apiName;
	private File dirApi;
	private File dirImplH;
	private File dirImplC;
	private int maxFileSize;
	private Map<String,String> packageAliasMap;
}

