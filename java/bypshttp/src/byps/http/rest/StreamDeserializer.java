package byps.http.rest;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import byps.BContentStream;
import byps.gen.RestConstants;

/**
 * Gson deserializer class for InputStream.
 * 
 * The JSON data of a REST request can reference a stream by specifying an object as
 * <pre><code>
 * { 
 *   "name" : "...multipart/form-data field name ..."
 * }
 * </code></pre>
 * Hence, if the deserialization expects an InputStream, it reads the 'name' member of the object and 
 * replaces it by the stream found in the provided map.
 */
class StreamDeserializer implements JsonDeserializer<InputStream> {  
  
  private static final Logger log = LoggerFactory.getLogger(StreamDeserializer.class);
  
  /**
   * Function that returns a stream for a given field name.
   */
  private final Function<String, BContentStream> getStream;
  
  /**
   * Constructor.
   * @param getStream Function that returns the stream for a given field name.
   */
  StreamDeserializer(Function<String, BContentStream> getStream) {
    this.getStream = getStream;
  }
  
  @Override
  public InputStream deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (log.isDebugEnabled()) log.debug("deserialize({}", json);
    
    InputStream ret = null;
    
    // Expecting a JSON object as:
    // {
    //   "file" : "file[0]"
    // }
    
    if (json.isJsonObject()) {
      JsonObject obj = json.getAsJsonObject();
      JsonElement elm = obj.get(RestConstants.UPLOAD_ITEM_NAME);
      if (log.isDebugEnabled()) log.debug("stream.{}={}", RestConstants.UPLOAD_ITEM_NAME, elm);
      if (elm != null && elm.isJsonPrimitive()) {
        String fieldName = elm.getAsString();
        ret = getStream.apply(fieldName);
      }
    }
    
    if (log.isDebugEnabled()) log.debug(")deserialize");
    return ret;
  }

  
}
