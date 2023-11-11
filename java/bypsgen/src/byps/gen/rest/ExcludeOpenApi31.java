package byps.gen.rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Exclude OpenAPI 3.1 properties.
 * Currently, Swagger editor at https://editor.swagger.io/ does not support this 
 * properties: types, specVersion
 * BYPS-76
 */
public class ExcludeOpenApi31 implements ExclusionStrategy {
  
  @Override
  public boolean shouldSkipField(FieldAttributes f) {
    boolean isTypesField = f.getName().contentEquals("types");
    boolean isSchemaClass = false;
    if (isTypesField) {
      Class<?> clazz = f.getDeclaringClass();
      isSchemaClass = clazz == Schema.class;
    }
    return isTypesField && isSchemaClass;
  }

  @Override
  public boolean shouldSkipClass(Class<?> clazz) {
    return clazz == SpecVersion.class;
  }

}
