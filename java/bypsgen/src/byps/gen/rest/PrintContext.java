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
	  File file = props.getMandatoryPropertyFile(PropertiesRest.OPENAPI_PATH);
	  file.getParentFile().mkdirs();
	  return file;
  }

  public File getRestOperationsFile(String simpleClassName) {
    File dir = props.getMandatoryPropertyFile(PropertiesRest.SRC_DIR);
    String subDir = classDB.getApiDescriptor().basePackage.replace('.', File.separatorChar);
    dir = new File(dir, subDir);
    dir.mkdirs();
    return new File(dir, simpleClassName + ".java");
  }

  public String getServerUrl() {
    String url = props.getOptionalPropertyString(PropertiesRest.SERVER_URL, "/rest");
    return url;
  }
  
}
