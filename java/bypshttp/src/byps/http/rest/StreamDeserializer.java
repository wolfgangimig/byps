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
public class StreamDeserializer implements JsonDeserializer<InputStream> {  
  
  private static final Logger log = LoggerFactory.getLogger(StreamDeserializer.class);
  
  /**
   * Function that returns a stream for a given field name.
   */
  private final Function<String, BContentStream> getStream;
  
  /**
   * Constructor.
   * @param getStream Function that returns the stream for a given field name.
   */
  public StreamDeserializer(Function<String, BContentStream> getStream) {
    this.getStream = getStream;
  }
  
  @Override
  public InputStream deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (log.isDebugEnabled()) log.debug("deserialize({}", json);
    
    String streamId = null;
    
    // Expecting a BStreamReference object as:
    // {
    //   "streamId" : "file[0]"
    // }
    
    if (json.isJsonObject()) {
      JsonObject obj = json.getAsJsonObject();
      JsonElement elm = obj.get("streamId");
      if (elm != null && elm.isJsonPrimitive()) {
        streamId = elm.getAsString();
      }
    }
    
    InputStream ret = streamId != null ? getStream.apply(streamId) : null;
    
    if (log.isDebugEnabled()) log.debug(")deserialize");
    return ret;
  }

  
}
