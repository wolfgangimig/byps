package byps.gen.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import byps.BVersioning;
import byps.gen.RestConstants;
import byps.gen.api.CommentInfo;
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;

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
  
  private OpenAPI openApi;
  
  private Map<String, SchemaN> schemas = new TreeMap<>();
  
  private Map<String, PathItem> paths = new TreeMap<>();
  
  @Override
  public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
    
    pctxt = new PrintContext(classDB, props);
    
    openApi = new OpenAPI();
    openApi.info(createInfo(classDB));
    openApi.servers(createServers());
    
    for (SerialInfo serInfo : classDB.getSerials()) {
      toSchema(serInfo);
    }
    openApi.components(new Components().schemas(SchemaN.toComponentSchemas(schemas)));
    
    for (RemoteInfo remoteInfo : classDB.getRemotes()) {
      remoteInfo.methods.forEach(m -> toPath(remoteInfo.name, m));
    }
    Paths oaiPaths = new Paths();
    paths.entrySet().forEach(e -> oaiPaths.addPathItem(e.getKey(), e.getValue()));
    openApi.paths(oaiPaths);
    
    write();
  }
  
  private List<Server> createServers() {
    Server server = new Server();
    server.url("/rest");
    server.description("Production Endpoint");
    return Arrays.asList(server);
  }

  private void toPath(String remoteName, MethodInfo methodInfo) {
    String uri = "/" + remoteName + "/" + methodInfo.name;
    
    PathItem pathItem = new PathItem();
    pathItem.summary(getCommentSummary(methodInfo.comments));
    pathItem.description(getCommentRemarks(methodInfo.comments, () -> "Interface " + remoteName + ", method " + methodInfo.name));
 
    Operation op = new Operation();
    op.operationId(remoteName + "_" + methodInfo.name);
    op.addTagsItem(remoteName);
    
//    SecurityRequirement security = new SecurityRequirement();
//    security.addList("Basic");
//    op.security(Arrays.asList(security));
    
    addRequestBodies(methodInfo, op);
    
    addResponses(methodInfo, op);
    
    pathItem.post(op);
    
    paths.put(uri, pathItem);
  }

  private void addResponses(MethodInfo methodInfo, Operation op) {
    ApiResponses responses = new ApiResponses();
    
    ApiResponse response200 = new ApiResponse();
    response200.description("Success");
    
    Content content = new Content();
    content.addMediaType("application/json", toResponseMediaType(methodInfo));
    response200.content(content);
    
    responses.addApiResponse("200", response200);
    
    op.responses(responses);
  }

  private void addRequestBodies(MethodInfo methodInfo, Operation op) {
    Content content = new Content();
    addRequestBodyMultipartFormData(content, methodInfo);
    
    if (System.getProperty("byps.gen.rest.create-post", "false").equals("true")) {
      addRequestBodyApplicationJson(content, methodInfo);
    }
    
    op.requestBody(new RequestBody().content(content));
  }

  private void addRequestBodyMultipartFormData(Content content, MethodInfo methodInfo) {
    MediaType mediaType = toRequestMediaTypeMultipartFormData(methodInfo);
    content.addMediaType("multipart/form-data", mediaType);
  }

  private void addRequestBodyApplicationJson(Content content, MethodInfo methodInfo) {
    MediaType mediaType = toRequestMediaTypeApplicationJson(methodInfo);
    content.addMediaType("application/json", mediaType);
  }

  private MediaType toRequestMediaTypeApplicationJson(MethodInfo methodInfo) {
    MediaType mediaType = new MediaType();
    SchemaN requestSchema = toSchemaRef(methodInfo.requestInfo);
    mediaType.schema(requestSchema.getSchema());
    return mediaType;
  }

  private MediaType toRequestMediaTypeMultipartFormData(MethodInfo m) {
    MediaType mediaType = new MediaType();
    
    Schema requestSchema = new ObjectSchema();
    for (MemberInfo param : m.requestInfo.members) {
      SchemaN paramSchema = toSchemaRef(param.type);
      requestSchema.addProperties(param.name, paramSchema.getSchema());
    }
    
    ArraySchema streams = new ArraySchema().items(new FileSchema());
    requestSchema.addProperties(RestConstants.UPLOAD_ITEM_NAME, streams);
    
    mediaType.schema(requestSchema);
    return mediaType;
  }

  private MediaType toResponseMediaType(MethodInfo m) {
    MediaType mediaType = new MediaType();
    SchemaN responseSchema = toSchemaRef(m.resultInfo);
    mediaType.schema(responseSchema.getSchema());
    return mediaType;
  }

  private void write() throws IOException {
    File openapiFile = pctxt.getOpenAPIFile();
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(boolean.class, new BooleanSerializer());
    builder.registerTypeAdapter(Boolean.class, new BooleanSerializer());
    builder.registerTypeAdapter(ArraySchema.class, new ArraySchemaSerializer());
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    try (Writer writer = new OutputStreamWriter(new FileOutputStream(openapiFile), StandardCharsets.UTF_8)) {
      gson.toJson(openApi, writer);
    }
  }
  
  private Info createInfo(ClassDB classDB) {
    Info info = new Info();
    info.title(classDB.getApiDescriptor().name);
    info.version(BVersioning.longToString(classDB.getApiDescriptor().version));
    return info;
  }
  
  private String toSchemaName(TypeInfo typeInfo) {
    String name = typeInfo.name;
    
    // It does not make much sense to support interface parameters.
    // However, handle interfaces in such a way that they do not disturb parsing of the resulting OpenAPI document.
    // The SerialInfo object for an interface is prefixed by BStub_, but the reference type in a parameter is not prefixed.
    // That's why the prefix is removed here.
    if (name.startsWith(RestConstants.BSTUB_PREFIX)) {
      name = name.substring(6);
    }
    
    // Replace InputStream with BStreamReference to avoid confusion in generated client code.
    if (name.equals("InputStream")) {
      name = RestConstants.BSTREAM_REFERENCE;
    }
    
    int ndims = typeInfo.dims.length() / 2;
    if (ndims != 0) {
      String sdims = ndims > 1 ? Integer.toString(ndims) : "";
      name = "Array" + sdims + "Of" + typeInfo.name;
    }
    return name;
  }
  
  private SchemaN toSchemaRef(TypeInfo typeInfo) {
    SchemaN ref = null;
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
    else if (typeInfo.isAnyType()) {
      ref = toSchemaForPrimitiveType(typeInfo);    
    }
    else {
      ref = toComponentsSchemaRef(typeInfo);
    }
    return ref;
  }
  
  private SchemaN toComponentsSchemaRef(TypeInfo typeInfo) {
    
    // Make sure that the referenced schema exists.
    SchemaN schema = getSchema(typeInfo);
    if (schema == null) {
      schema = toSchema(typeInfo);
    }
    
    return new SchemaN(schema.getName(), new Schema().$ref("#/components/schemas/" + schema.getName()));
  }
  
  private SchemaN toSchema(TypeInfo typeInfo) {
    
    SchemaN schema = getSchema(typeInfo);
    if (schema != null) return toSchemaRef(typeInfo);
    
    if (typeInfo.isArrayType()) {
      schema = toArraySchema(typeInfo);
    }
    else if (typeInfo.isListType() || typeInfo.isSetType()) {
      schema = toListSchema(typeInfo);
    }
    else if (typeInfo.isMapType()) {
      schema = toMapSchema(typeInfo);
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
    else if (typeInfo instanceof RemoteInfo) {
      RemoteInfo remoteInfo = (RemoteInfo)typeInfo;
      String description = getCommentSummary(remoteInfo.comments);
      schema = new SchemaN(typeInfo.name, new StringSchema().description(description));
    }
    else if (typeInfo instanceof SerialInfo) {
      
      SerialInfo serInfo = (SerialInfo)typeInfo;
      String description = getCommentSummary(serInfo.comments);

      Schema schemaO = new ObjectSchema();
      schemaO.description(description);
      schema = new SchemaN(toSchemaName(typeInfo), schemaO);

      putSchema(schema);

      serInfo.members.stream().filter(member -> !member.type.isVoidType())
        .forEach(member -> schemaO.addProperties(member.name, toSchemaRef(member.type).getSchema()));
      
      if (serInfo.name.startsWith("BResult_")) {
        schemaO.addProperties("exception", new StringSchema().description("Error message"));
      }
      
    }
    else {
      // typeInfo is BRemote
      schema = new SchemaN(typeInfo.name, new StringSchema().description("Unsupported schema"));
      putSchema(schema);
    }
    
    return schema;
  }
  
  private SchemaN toListSchema(TypeInfo typeInfo) {

    SchemaN itemSchemaRef = null;
    if (typeInfo.typeArgs != null && !typeInfo.typeArgs.isEmpty()) {
      TypeInfo itemType = typeInfo.typeArgs.get(0);
      itemSchemaRef = toSchemaRef(itemType);
    }
    else {
      itemSchemaRef = new SchemaN("Object", new StringSchema());
    }

    String schemaName = toSchemaName(typeInfo) + "Of" + itemSchemaRef.getName();
    SchemaN arraySchema = new SchemaN(schemaName, new ArraySchema().items(itemSchemaRef.getSchema()));
    
    schemas.put(schemaName, arraySchema);
    return arraySchema;
  }

  private SchemaN toMapSchema(TypeInfo typeInfo) {

    int nbOfTypeArgs = typeInfo.typeArgs != null ? typeInfo.typeArgs.size() : 0;

    SchemaN valueSchemaRef = null;
    if (nbOfTypeArgs > 1) {
      TypeInfo itemType = typeInfo.typeArgs.get(1);
      valueSchemaRef = toSchemaRef(itemType);
    }
    else {
      valueSchemaRef = new SchemaN("Object", new StringSchema());
    }

    String schemaName = toSchemaName(typeInfo) + "To" + valueSchemaRef.getName();
    SchemaN arraySchema = new SchemaN(schemaName, new MapSchema().additionalProperties(valueSchemaRef.getSchema()));
    
    schemas.put(schemaName, arraySchema);
    return arraySchema;
  }


  private SchemaN toSchemaForStream(TypeInfo typeInfo) {
    Schema schema = new ObjectSchema();
    schema.addProperties("file", new StringSchema());
    schema.addProperties("url", new StringSchema());
    String name = toSchemaName(typeInfo);
    SchemaN schemaN = new SchemaN(name, schema);
    putSchema(schemaN);
    return schemaN;
  }

  private void putSchema(SchemaN schema) {
    schemas.put(schema.getName(), schema);
  }
  
  private SchemaN getSchema(TypeInfo typeInfo) {
    return schemas.get(toSchemaName(typeInfo));
  }
  
  private SchemaN toSchemaForPrimitiveType(TypeInfo typeInfo) {
    Schema schema = null;
    if (typeInfo.isByteArray1dim()) {
      schema = new BinarySchema();
    }
    else if (equalsOneOf(typeInfo.name, "boolean", "Boolean")) {
      schema = new BooleanSchema();
    }
    else if (equalsOneOf(typeInfo.name, "byte", "Byte")) {
      schema = new IntegerSchema();
    }
    else if (equalsOneOf(typeInfo.name, "char", "Character")) {
      schema = new IntegerSchema();
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
    else if (equalsOneOf(typeInfo.name, "Date")) {
      schema = new DateTimeSchema();
    }
    else {
      schema = new StringSchema();
    }
    return new SchemaN(toSchemaName(typeInfo), schema);
  }
  
  private boolean equalsOneOf(String lhs, String ... rhs) {
    for (String r : rhs) {
      if (lhs.equals(r)) return true;
    }
    return false;
  }
  
  private SchemaN toArraySchema(TypeInfo typeInfo) {
    String schemaName = toSchemaName(typeInfo);
    
    TypeInfo itemType = new TypeInfo(typeInfo.name, typeInfo.qname, 
        typeInfo.dims.substring(2), 
        null, typeInfo.isEnum, typeInfo.isFinal, typeInfo.isInline);
    
    SchemaN itemSchema = toSchemaRef(itemType); 
    SchemaN arraySchema = new SchemaN(schemaName, new ArraySchema().items(itemSchema.getSchema()));
    
    schemas.put(schemaName, arraySchema);
    return arraySchema;
  }

  private String getCommentSummary(Collection<CommentInfo> comments) {
    String summary = comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_SUMMARY)).map(c -> c.text).findFirst().orElse("");
    return (summary != null && !summary.isEmpty()) ? summary : null;
  }
  
  private String getCommentRemarks(Collection<CommentInfo> comments, Supplier<String> defaultValue) {
    String value = comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_REMARKS)).map(c -> c.text).findFirst().orElse("");
    return (value != null && !value.isEmpty()) ? value : defaultValue.get();
  }
  
}