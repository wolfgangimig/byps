package byps.gen.rest;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

public class SecuritySchemeTypeSerializer extends TypeAdapter<SecurityScheme.Type> {

  @Override
  public void write(JsonWriter out, Type value) throws IOException {
    String str = value.toString();
    out.value(str);
  }

  @Override
  public Type read(JsonReader in) throws IOException {
    String str = in.nextString();
    try {
      return Type.valueOf(str);
    }
    catch (Exception ignored) {
      return Type.valueOf(str.toUpperCase());
    }
  }

}
