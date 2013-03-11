package com.wilutions.byps.gen.cpp;

import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesCpp extends GeneratorProperties {
	public final static String OPT_PREFIX = "-gencpp.";
	public final static String DEST_DIR_API = "-gencpp.dir-api";
	public final static String DEST_DIR_IMPL_H = "-gencpp.dir-impl.h";
	public final static String DEST_DIR_IMPL_C = "-gencpp.dir-impl.c";
	public final static String PACK_ALIAS = "-gencpp.pack.alias";
	public final static String MAX_FILE_SIZE = "-gencpp.max-fsize";
	
	/**
	 * Bildet Example_getRegistryFactory, Example_typeDescs,
	 * Dateinamen Example-Api.h, Example-Impl.h usw.
	 */
	public final static String API_NAME = "-gencpp.api.name";
	
	public PropertiesCpp(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
	
}
