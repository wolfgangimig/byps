package byps.gen;

/**
 * Constants related to the REST interface and OpenAPI generator. 
 *
 */
public class RestConstants {

  /**
   * Prefix for stub classes to be removed in generation of OpenAPI.
   */
  public static final String BSTUB_PREFIX = "BStub_";
  
  /**
   * Name of multipart/form-data field for files to upload.
   *
   * If this field is not named 'file', SwaggerEditor will send a 'file' anyway which causes a warning in the log file.
   */
  public static final String UPLOAD_ITEM_NAME = "file";
  
  public static final String MULTIPART_DATA_PARAM_NAME = "data";
  
  /**
   * InputStream fields are replaced by this class name in the OpenAPI document.
   */
  public static final String BSTREAM_REFERENCE = "BStreamReference";
  
  
  private RestConstants() {
    // make sonarlint happy
  }
}
