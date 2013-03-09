package com.wilutions.byps.gen.c;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesC extends GeneratorProperties {
	public final static String OPT_PREFIX = "-genc.";
	public final static String DEST_DIR_API = "-genc.dir-api";
	public final static String DEST_DIR_IMPL_H = "-genc.dir-impl.h";
	public final static String DEST_DIR_IMPL_C = "-genc.dir-impl.c";
	public final static String PACK_ALIAS = "-genc.pack.alias";
	public final static String MAX_FILE_SIZE = "-genc.max-fsize";
	
	/**
	 * Bildet Example_getRegistryFactory, Example_typeDescs,
	 * Dateinamen Example-Api.h, Example-Impl.h usw.
	 */
	public final static String API_NAME = "-genc.api.name";
	

	public int addArgs(String[] args, int idx) throws GeneratorException {
		String key = args[idx++];
		String value = "";
		if (idx >= args.length) throw new GeneratorException("Missing value for argument " + args[idx]);  
		value = args[idx++];
		super.put(key, value);
		return idx;
	}
}