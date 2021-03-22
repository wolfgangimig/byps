package byps.gen.rest;

import java.io.File;
import java.io.FileNotFoundException;
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
import io.swagger.v3.oas.models.media.Schema;

/**
 * Generates an OpenAPI document.
 * 
 * https://github.com/swagger-api/swagger-core/blob/master/modules/swagger-models/src/test/java/io/swagger/test/SimpleBuilderTest.java
 *
 */
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
  
  private void write() throws FileNotFoundException, IOException {
    File openapiFile = pctxt.getOpenAPIFile();
    GsonBuilder builder = new GsonBuilder();
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
    return typeInfo.name;
  }
  
  private Schema toSchemaRef(TypeInfo typeInfo) {
    if (typeInfo.isPrimitiveType()) {
      return toSchemaForPrimitiveType(typeInfo);
    }
    else {
      return new Schema().$ref("#/components/schemas/" + toSchemaName(typeInfo));
    }
  }
  
  private Schema toSchema(TypeInfo typeInfo) {
    
    System.out.println(typeInfo);
    
    String schemaName = typeInfo.name;
    Schema schema = schemas.get(schemaName);
    if (schema != null) return toSchemaRef(typeInfo);
    
    if (typeInfo.isPrimitiveType()) {
      schema = toSchemaForPrimitiveType(typeInfo);    
    }
    else {
      
      SerialInfo serInfo = (SerialInfo)typeInfo;
      String description = getSchemaDescription(serInfo);

      schema = new Schema<>();
      schema.description(description);

      schemas.put(schemaName, schema);

      for (MemberInfo member : serInfo.members) {
        schema.addProperties(member.name, toSchemaRef(member.type));
      }
      
    }
    
    return schema;
  }
  
  private Schema toSchemaForPrimitiveType(TypeInfo typeInfo) {
    Schema schema = null;
    if (typeInfo.isByteArray1dim()) {
      schema = new BinarySchema();
    }
    else if (typeInfo.isArrayType()) {
      schema = toArraySchema(typeInfo); 
    }
    return schema;
  }
  
  private Schema toArraySchema(TypeInfo typeInfo) {
    TypeInfo itemType = new TypeInfo(typeInfo.name, typeInfo.qname, "", 
        null, typeInfo.isEnum, typeInfo.isFinal, typeInfo.isInline);
    Schema itemSchema = toSchema(itemType); 
    return new ArraySchema().items(itemSchema);
  }

  private String getSchemaDescription(SerialInfo serInfo) {
    String summary = serInfo.comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_SUMMARY)).map(c -> c.text).findFirst().orElse("");
    return (summary != null && !summary.isEmpty()) ? summary : null;
  }
  
}
