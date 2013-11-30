package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;

@SuppressWarnings("serial")
public class GeneratorProperties extends Properties {
	
	public final static String BINARY_MODEL = "-bmodel";
	
	public final static String CHANGED_MEMBERS  = "-gen.changedmembers";
	
	public GeneratorProperties(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
	
	public GeneratorProperties() {
		super();
	}
	
	public int addArgs(String[] args, int idx) throws GeneratorException {
		String key = args[idx++];
		String value = "";
		if (idx >= args.length) throw new GeneratorException("Missing value for argument " + args[idx]);  
		value = args[idx++];
		put(key, value);
		return idx;
	}

	public String getProperty(String key, String defaultValue, boolean mandatory) throws GeneratorException {
		String s = getProperty(key);
		if (s == null || s.length() == 0) {
			if (mandatory) throw new GeneratorException("Missing mandatory property " + key);
			s = defaultValue;
		}
		return s;
	}
	
	public int getProperty(String key, int defaultValue, boolean mandatory) throws GeneratorException {
		String s = getProperty(key);
		int ret = 0;
		if (s == null || s.length() == 0) {
			if (mandatory) throw new GeneratorException("Missing mandatory property " + key);
			ret = defaultValue;
		}
		else {
			try {
				ret = Integer.parseInt(s);
			}
			catch (NumberFormatException e) {
				throw new GeneratorException("Property " + key + " must be a number");
			}
		}
		return ret;
	}
	
	public boolean getProperty(String key, boolean defaultValue, boolean mandatory) throws GeneratorException {
		String s = getProperty(key);
		boolean ret = false;
		if (s == null || s.length() == 0) {
			if (mandatory) throw new GeneratorException("Missing mandatory property " + key);
			ret = defaultValue;
		}
		else {
			try {
				ret = Boolean.parseBoolean(s);
			}
			catch (NumberFormatException e) {
				throw new GeneratorException("Property " + key + " must be a number");
			}
		}
		return ret;
	}
	
	public File getProperty(String key, File defaultValue, boolean mandatory) throws GeneratorException {
		File ret = null;
		String s = getProperty(key);
		if (s == null || s.length() == 0) {
			if (mandatory) throw new GeneratorException("Missing mandatory property " + key);
			ret = defaultValue;
		}
		else {
			ret = new File(s);
			ret = ret.getAbsoluteFile();
		}
		return ret;
	}
	
	public String getOptionalPropertyString(String key, String defaultValue) throws GeneratorException {
		return getProperty(key, defaultValue, false);
	}

	public String getMandatoryPropertyString(String key) throws GeneratorException {
		return getProperty(key, "", true);
	}
	
	public int getOptionalPropertyInt(String key, int defaultValue) throws GeneratorException {
		return getProperty(key, defaultValue, false);
	}

	public int getMandatoryPropertyInt(String key) throws GeneratorException {
		return getProperty(key, 0, true);
	}
	
	public boolean getOptionalPropertyBoolean(String key, boolean defaultValue) throws GeneratorException {
		return getProperty(key, defaultValue, false);
	}

	public boolean getMandatoryPropertyBoolean(String key) throws GeneratorException {
		return getProperty(key, false, true);
	}
	
	public File getMandatoryPropertyFile(String key) throws GeneratorException {
		return getProperty(key, new File(""), true);
	}
	
	public File getOptionalPropertyFile(String key, File defaultValue) throws GeneratorException {
		return getProperty(key, defaultValue, false);
	}

	public Map<String,String> getPropertyAsMap(String key, String defaultValue) throws GeneratorException {
		Map<String,String> map = new HashMap<String,String>();
		String propValue = getOptionalPropertyString(key, defaultValue);
		if (propValue != null && propValue.length() != 0) {
			String[] pairs = propValue.split(";");
			for (String pair : pairs) {
				String[] kv = pair.split("=");
				if (kv.length != 2) throw new GeneratorException("Key-value pair \"" + pair + "\" for " + key + " must be separated with \"=\"");
				map.put(kv[0], kv[1]);
			}
		}
		return map;
	}
	
	public void dump(Log log) {
		ArrayList<String> keys = new ArrayList<String>();
		for (Object key : this.keySet()) keys.add((String)key);
		Collections.sort(keys);
		for (String key : keys) {
			log.info(key + "=" + getProperty(key));
		}
	}
}
