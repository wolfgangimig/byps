package byps.gen.ts;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesTS extends GeneratorProperties {

	public final static String OPT_PREFIX = "-gents.";
	public final static String DEST_FILE = "-gents.dest";
	public static final String SUPPRESS_CONST_CLASSES = "-gents.suppress-const-classes";

	public PropertiesTS(GeneratorProperties defaultProps) {
		super(defaultProps);
	}

	public int addArgs(String[] args, int idx) throws GeneratorException {
		String key = args[idx];
		if (key.equals(SUPPRESS_CONST_CLASSES)) {
			put(key, "true");
			idx++;
		} else {
			idx = super.addArgs(args, idx);
		}
		return idx;
	}


}
