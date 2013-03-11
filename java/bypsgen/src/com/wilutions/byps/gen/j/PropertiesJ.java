package com.wilutions.byps.gen.j;

import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesJ extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-genj.";
	public final static String DEST_DIR_API = "-genj.dir-api";
	public final static String DEST_DIR_SER_BIN = "-genj.dir-ser-bin";
	public final static String DEST_DIR_SER_Json = "-genj.dir-ser-json";
	public static final String DEST_DIR_SER = "-genj.dir-ser";

	/**
	 * Generate functions hashCode and equals.
	 */
	public final static String HASHCODE_AND_EQUALS = "-genj.hasheq";
	
	public PropertiesJ(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
	

}
