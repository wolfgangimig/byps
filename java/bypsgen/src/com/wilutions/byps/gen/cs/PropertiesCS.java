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

	/**
	 * Generate functions hashCode and equals.
	 */
	public final static String HASHCODE_AND_EQUALS = "-genj.hasheq";
	
	
	public int addArgs(String[] args, int idx) throws GeneratorException {
		String key = args[idx++];
		String value = "";
		if (key.equals(HASHCODE_AND_EQUALS)) {
			value = "1";
		}
		else {
			if (idx >= args.length) throw new GeneratorException("Missing value for argument " + args[idx]);  
			value = args[idx++];
		}
		super.put(key, value);
		return idx;
	}
	
	
	public boolean isUppercaseFirstLetter() throws GeneratorException
	{
		return getOptionalPropertyBoolean(UPPER_CASE_FIRST_LETTER, true);
	}
}
