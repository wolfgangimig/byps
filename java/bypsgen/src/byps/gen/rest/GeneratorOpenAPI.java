package byps.gen.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import byps.gen.api.CommentInfo;
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

/**
 * Generates an OpenAPI document.
 * 
 * https://github.com/swagger-api/swagger-core/blob/master/modules/swagger-models/src/test/java/io/swagger/test/SimpleBuilderTest.java
 *
 */
@SuppressWarnings("rawtypes")
public class GeneratorOpenAPI implements Generator {
  
  Logger log = LoggerFactory.getLogger(GeneratorOpenAPI.class);
  
  private PrintContext pctxt;
  
  private String pack;
  
  private OpenAPI openApi;
  
  private Map<String, Schema> schemas = new HashMap<>();
  
  @Override
  public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
    
    pctxt = new PrintContext(classDB, props);
    
    pack = classDB.getApiDescriptor().basePackage;
    
    openApi = new OpenAPI();
    openApi.info(createInfo(classDB));
    
    
    for (SerialInfo serInfo : classDB.getSerials()) {
      toSchema(serInfo);
    }
    openApi.components(new Components().schemas(schemas));
    
    write();
  }
  
  private void write() throws IOException {
    File openapiFile = pctxt.getOpenAPIFile();
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(boolean.class, new BooleanSerializer());
    builder.registerTypeAdapter(Boolean.class, new BooleanSerializer());
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    try (Writer writer = new OutputStreamWriter(new FileOutputStream(openapiFile), StandardCharsets.UTF_8)) {
      gson.toJson(openApi, writer);
    }
  }
  
  private Info createInfo(ClassDB classDB) {
    return new Info().contact(new Contact().name(classDB.getApiDescriptor().name));
  }
  
  private String toSchemaName(TypeInfo typeInfo) {
    String name = typeInfo.name;
    int ndims = typeInfo.dims.length() / 2;
    if (ndims != 0) {
      String sdims = ndims > 1 ? Integer.toString(ndims) : "";
      name = "Array" + sdims + "Of" + typeInfo.name;
    }
    return name;
  }
  
  private Schema toSchemaRef(TypeInfo typeInfo) {
    Schema ref = null;
    if (typeInfo.isArrayType()) {
      if (typeInfo.dims.length() > 2) {
        ref = toComponentsSchemaRef(typeInfo);
      }
      else {
        ref = toArraySchema(typeInfo);
      }
    }
    else if (typeInfo.isPrimitiveType()) {
      ref = toSchemaForPrimitiveType(typeInfo);
    }
    else {
      ref = toComponentsSchemaRef(typeInfo);
    }
    return ref;
  }
  
  private Schema toComponentsSchemaRef(TypeInfo typeInfo) {
    
    // Make sure that the referenced schema exists.
    if (getSchema(typeInfo) == null) {
      toSchema(typeInfo);
    }
    
    return new Schema().$ref("#/components/schemas/" + toSchemaName(typeInfo));
  }
  
  private Schema toSchema(TypeInfo typeInfo) {
    
    System.out.println(typeInfo);
    
    if (typeInfo.name.equals("ArrayTypes4dim")) {
      System.out.println("stop");
    }
    
    Schema schema = getSchema(typeInfo);
    if (schema != null) return toSchemaRef(typeInfo);
    
    if (typeInfo.isArrayType()) {
      schema = toArraySchema(typeInfo);
    }
    else if (typeInfo.isPrimitiveType()) {
      schema = toSchemaForPrimitiveType(typeInfo);    
    }
    else if (typeInfo.isAnyType()) {
      schema = toSchemaForPrimitiveType(typeInfo);    
    }
    else if (typeInfo.isStreamType()) {
      schema = toSchemaForStream(typeInfo);    
    }
    else if (!(typeInfo instanceof SerialInfo)) {
      schema = new StringSchema();
    }
    else {
      
      SerialInfo serInfo = (SerialInfo)typeInfo;
      String description = getSchemaDescription(serInfo);

      schema = new Schema<>();
      schema.description(description);

      putSchema(typeInfo, schema);

      for (MemberInfo member : serInfo.members) {
        schema.addProperties(member.name, toSchemaRef(member.type));
      }
      
    }
    
    return schema;
  }
  
  private Schema toSchemaForStream(TypeInfo typeInfo) {
    Schema schema = new Schema<>();
    schema.addProperties("name", new StringSchema());
    schema.addProperties("url", new StringSchema());
    putSchema(typeInfo, schema);
    return schema;
  }

  private void putSchema(TypeInfo typeInfo, Schema schema) {
    schemas.put(toSchemaName(typeInfo), schema);
  }
  
  private Schema getSchema(TypeInfo typeInfo) {
    return schemas.get(toSchemaName(typeInfo));
  }
  
  private Schema toSchemaForPrimitiveType(TypeInfo typeInfo) {
    Schema schema = null;
    if (typeInfo.isByteArray1dim()) {
      schema = new BinarySchema();
    }
    else if (equalsOneOf(typeInfo.name, "int", "Integer")) {
      schema = new IntegerSchema();
    }
    else if (equalsOneOf(typeInfo.name, "long", "Long")) {
      schema = new IntegerSchema().format("int64");
    }
    else if (equalsOneOf(typeInfo.name, "float", "Float")) {
      schema = new NumberSchema().format("float");
    }
    else if (equalsOneOf(typeInfo.name, "double", "Double")) {
      schema = new NumberSchema().format("double");
    }
    else {
      schema = new StringSchema();
    }
    return schema;
  }
  
  private boolean equalsOneOf(String lhs, String ... rhs) {
    for (String r : rhs) {
      if (lhs.equals(r)) return true;
    }
    return false;
  }
  
  private Schema toArraySchema(TypeInfo typeInfo) {
    String schemaName = toSchemaName(typeInfo);
    
    TypeInfo itemType = new TypeInfo(typeInfo.name, typeInfo.qname, 
        typeInfo.dims.substring(2), 
        null, typeInfo.isEnum, typeInfo.isFinal, typeInfo.isInline);
    
    Schema itemSchema = toSchemaRef(itemType); 
    Schema arraySchema = new ArraySchema().items(itemSchema);
    
    schemas.put(schemaName, arraySchema);
    return arraySchema;
  }

  private String getSchemaDescription(SerialInfo serInfo) {
    String summary = serInfo.comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_SUMMARY)).map(c -> c.text).findFirst().orElse("");
    return (summary != null && !summary.isEmpty()) ? summary : null;
  }
  
}
