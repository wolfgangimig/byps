package com.wilutions.byps.gen.cs;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesCS extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-gencs.";
	public final static String DEST_DIR_API = "-gencs.dir-api";
	public final static String DEST_DIR_SER_BIN = "-gencs.dir-ser-bin";
	public final static String DEST_DIR_SER_Json = "-gencs.dir-ser-json";
	public static final String DEST_DIR_SER = "-gencs.dir-ser";
	public static final String UPPER_CASE_FIRST_LETTER = "-gencs.upfirst";

	public PropertiesCS(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
		
	public boolean isUppercaseFirstLetter() throws GeneratorException
	{
		return getOptionalPropertyBoolean(UPPER_CASE_FIRST_LETTER, true);
	}
}
