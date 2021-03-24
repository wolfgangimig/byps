package byps.gen.rest;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import io.swagger.v3.oas.models.media.ArraySchema;

/**
 * Serialize an array schema.
 *
 * The items member is not serialized by the default serializer. Do not know why it skips this member.
 * 
 */
public class ArraySchemaSerializer implements JsonSerializer<ArraySchema> {

  @Override
  public JsonElement serialize(ArraySchema src, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject ret = new JsonObject();
    ret.add("type", new JsonPrimitive(src.getType()));
    ret.add("items", context.serialize(src.getItems()));
    return ret;
  }

}
