package byps.gen.rest;

import java.io.File;

import byps.gen.api.GeneratorProperties;
import byps.gen.db.ClassDB;
import byps.gen.utils.PrintContextBase;

/**
 * Helper functions for printing an OpenAPI document.
 * 
 *
 */
class PrintContext extends PrintContextBase {

  public PrintContext(ClassDB classDB, GeneratorProperties props) {
    super(classDB, props);
  }
  
  public File getOpenAPIFile() {
	  String sdir = props.getProperty(PropertiesRest.DEST_DIR, System.getProperty("java.io.tmpdir"));
	  File dir = new File(sdir);
	  dir.mkdirs();
	  return new File(dir, PropertiesRest.OPENAPI_FILENAME);
  }

}
