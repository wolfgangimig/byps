package byps.http.rest;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import byps.BContentStream;

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
   * Map of streams in multipart/form-data request.
   */
  private final Map<String, BContentStream> streamItems;
  
  /**
   * Constructor.
   * @param streamItems Streams provided in the multipart/form-data request.
   */
  StreamDeserializer(Map<String, BContentStream> streamItems) {
    this.streamItems = streamItems;
  }
  
  @Override
  public InputStream deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (log.isDebugEnabled()) log.debug("deserialize({}", json);
    
    InputStream ret = null;
    
    if (json.isJsonObject()) {
      JsonObject obj = json.getAsJsonObject();
      JsonElement elm = obj.get("name");
      if (log.isDebugEnabled()) log.debug("stream name={}", elm);
      if (json.isJsonPrimitive()) {
        String fieldName = elm.getAsString();
        ret = streamItems.get(fieldName);
      }
    }
    
    if (log.isDebugEnabled()) log.debug(")deserialize");
    return ret;
  }

  
}
