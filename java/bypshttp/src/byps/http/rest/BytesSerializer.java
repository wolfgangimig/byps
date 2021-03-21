package byps.http.rest;

import java.lang.reflect.Type;
import java.util.Base64;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Serialize byte array to Base64 String. 
 * BYPS-51
 */
public class BytesSerializer implements JsonSerializer<byte[]> {

  @Override
  public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
    String base64 = Base64.getEncoder().encodeToString(src);
    return new JsonPrimitive(base64);
  }

}
