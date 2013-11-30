package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;

@SuppressWarnings("serial")
public class PropertiesCS extends GeneratorProperties {
	
	public final static String OPT_PREFIX = "-gencs.";
	public final static String DEST_DIR_API = "-gencs.dir-api";
	public final static String DEST_DIR_SER_BIN = "-gencs.dir-ser-bin";
	public final static String DEST_DIR_SER_Json = "-gencs.dir-ser-json";
	public static final String DEST_DIR_SER = "-gencs.dir-ser";
	public static final String UPPER_CASE_FIRST_LETTER = "-gencs.upfirst";
  public static final String DOTNET_VERSION = "-gencs.dot-net-version";
  public static final String RENAME_PACKAGES = "-gencs.rename-packages";

	public PropertiesCS(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
		
	public boolean isUppercaseFirstLetter() throws GeneratorException
	{
		return getOptionalPropertyBoolean(UPPER_CASE_FIRST_LETTER, true);
	}

  public float dotnetVersion() throws GeneratorException {
    String ver = this.getOptionalPropertyString(DOTNET_VERSION, "2.0");
    return Float.parseFloat(ver);
  }
}
