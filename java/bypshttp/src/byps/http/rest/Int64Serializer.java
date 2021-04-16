package byps.http.rest;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Serialize Long as String.
 * 
 * Otherwise it is converted to Double and looses bits 53 to 63.
 * BYPS-51
 */
public class Int64Serializer implements JsonSerializer<Long>, JsonDeserializer<Long> {

  @Override
  public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
    String str = Long.toString(src);
    return new JsonPrimitive(str);
  }

  @Override
  public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    String str = json.getAsString();
    return Long.valueOf(str);
  }

//  static class Class1 {
//    long[] longValues;
//  }
//
//  public static void main(String[] args) {
//    
//    Class1 class1 = new Class1();
//    class1.longValues = new long[] {Long.MAX_VALUE, Long.MIN_VALUE, 1L << 53, 1L << 54, 1L << 63 };
//    
//    for (long v : class1.longValues) {
//      System.out.println(v);
//    }
//  
//    for (int i = 0; i < 2; i++) {
//      GsonBuilder builder = new GsonBuilder();
//      builder.setPrettyPrinting();
//      if (i == 1) {
//        builder.registerTypeAdapter(long.class, new Int64Serializer());
//        builder.registerTypeAdapter(Long.class, new Int64Serializer());
//      }
//    
//      Gson gson = builder.create();
//      String json = gson.toJson(class1);
//      System.out.println("json=" + json);
//    }
//    
////    Gson gsonR = builder.create();
////    Class1 classR = gsonR.fromJson(json, Class1.class);
//    
//  }
//  
}
