package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesCpp extends GeneratorProperties {
	public final static String OPT_PREFIX = "-gencpp.";
	public final static String DEST_DIR_API = "-gencpp.dir-api";
	public final static String DEST_DIR_IMPL_H = "-gencpp.dir-impl.h";
	public final static String DEST_DIR_IMPL_C = "-gencpp.dir-impl.c";
	public final static String DEST_DIR_IMPL = "-gencpp.dir-impl";
	public final static String PACK_ALIAS = "-gencpp.pack.alias";
	public final static String MAX_FILE_SIZE = "-gencpp.max-fsize";
	
	/**
	 * API name.
	 * Used as file prefix and symbol prefix.
	 */
	public final static String API_NAME = "-gencpp.api.name";
	
	/**
	 * Compiler suppots C++11 lambdas.
	 * This value must be set.
	 */
	public static final String LAMBDA = "-gencpp.lambda";
	
	public PropertiesCpp(GeneratorProperties defaultProps) {
		super(defaultProps);
	}

	public boolean isUppercaseFirstLetter() {
		return false;
	}
	
}
