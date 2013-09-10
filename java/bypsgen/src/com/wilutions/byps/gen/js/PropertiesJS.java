package com.wilutions.byps.gen.js;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesJS extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-genjs.";
	public final static String DEST_FILE = "-genjs.dest";
  public static final String SUPPRESS_CONST_CLASSES = "-genjs.suppressConstClasses";

	public PropertiesJS(GeneratorProperties defaultProps) {
		super(defaultProps);
	}

  public int addArgs(String[] args, int idx) throws GeneratorException {
    String key = args[idx];
    if (key.equals(SUPPRESS_CONST_CLASSES)) {
      put(key, "true");
      idx++;
    }
    else {
      idx = super.addArgs(args, idx);
    }
    return idx;
  }

	
}
