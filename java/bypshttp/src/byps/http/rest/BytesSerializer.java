package byps.http.rest;

import java.lang.reflect.Type;
import java.util.Base64;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Serialize byte array to Base64 String. 
 * BYPS-51
 */
public class BytesSerializer implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

  @Override
  public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
    String base64 = Base64.getEncoder().encodeToString(src);
    return new JsonPrimitive(base64);
  }

  @Override
  public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    String base64 = json.getAsString();
    return Base64.getDecoder().decode(base64);
  }

}
