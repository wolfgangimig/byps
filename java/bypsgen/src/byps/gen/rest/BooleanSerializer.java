package byps.gen.rest;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class BooleanSerializer implements JsonSerializer<Boolean> {

  @Override
  public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context) {
    JsonPrimitive ret = null;
    if (src != null && src) {
      ret = new JsonPrimitive(true);
    }
    else {
      // skip
      ret = null;
    }
    return ret;
  }

}
