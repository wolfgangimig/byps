package com.wilutions.byps.gen.js;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesJS extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-genjs.";
	public final static String DEST_FILE = "-genjs.dest";

	public int addArgs(String[] args, int idx) throws GeneratorException {
		String key = args[idx++];
		String value = "";
		if (idx >= args.length) throw new GeneratorException("Missing value for argument " + args[idx]);  
		value = args[idx++];
		super.put(key, value);
		return idx;
	}
}
