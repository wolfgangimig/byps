package com.wilutions.byps.gen.js;

import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesJS extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-genjs.";
	public final static String DEST_FILE = "-genjs.dest";

	public PropertiesJS(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
	
}
