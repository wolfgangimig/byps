package byps.gen.rest;

import byps.gen.api.GeneratorProperties;

public class PropertiesRest extends GeneratorProperties {

  private static final long serialVersionUID = -4801873533782890716L;

  public PropertiesRest(GeneratorProperties defaultProps) {
    super(defaultProps);
  }

  /**
	 * Destination directory for openapi.json file.
	 */
	public final static String DEST_DIR = "-genrest.openapi-dir";

	/**
	 * File name for openapi.json. 
	 */
	public final static String OPENAPI_FILENAME = "openapi.json";
}
