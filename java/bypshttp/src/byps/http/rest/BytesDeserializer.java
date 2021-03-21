package byps.http.rest;

import java.lang.reflect.Type;
import java.util.Base64;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Deserialize byte array from Base64 String. 
 * BYPS-51
 */
public class BytesDeserializer implements JsonDeserializer<byte[]> {

  @Override
  public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    
    byte[] ret = null;
    
    if (json.isJsonPrimitive()) {
      String base64 = json.getAsString();
      ret = Base64.getDecoder().decode(base64);
    }
    
    return ret;
  }


}
