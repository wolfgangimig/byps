package byps.gen.rest;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import io.swagger.v3.oas.models.security.SecurityScheme;

public class SecuritySchemeInSerializer extends TypeAdapter<SecurityScheme.In> {

  @Override
  public void write(JsonWriter out, SecurityScheme.In value) throws IOException {
    if (value != null) {
      String str = value.toString();
      out.value(str);
    }
    else {
      out.nullValue();
    }
  }

  @Override
  public SecurityScheme.In read(JsonReader in) throws IOException {
    String str = in.nextString();
    try {
      return SecurityScheme.In.valueOf(str);
    }
    catch (Exception ignored) {
      return SecurityScheme.In.valueOf(str.toUpperCase());
    }
  }

}
