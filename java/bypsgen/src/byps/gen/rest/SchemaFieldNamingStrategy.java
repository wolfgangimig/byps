package byps.gen.rest;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;

/**
 * Transformation for enum element in OpenAPI Schema class.
 * Enum constants are stored in Schema._enum. Serialisation should produce "enum" instead of "_enum". 
 * BYPS-75
 * @see io.swagger.v3.oas.models.media.Schema
 *
 */
public class SchemaFieldNamingStrategy implements FieldNamingStrategy {
  
  @Override
  public String translateName(Field f) {
    String ret = f.getName();
    if (ret.contentEquals("_enum")) {
      ret = "enum";
    }
    return ret;
  }

}
