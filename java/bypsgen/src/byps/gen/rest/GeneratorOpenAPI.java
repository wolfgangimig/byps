package byps.gen.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import byps.BValueClass;
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
import byps.gen.api.rest.RestInfo;
import byps.gen.api.rest.RestMethod;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;
import byps.rest.BStreamReference;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.ByteArraySchema;
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
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
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
  
  private Map<String, SecurityScheme> securitySchemes = new TreeMap<>();
  
  /**
   * Map full type name to SerialInfo.
   * This map is used to provide SerialInfo objects which are referenced in schema objects.
   * BYPS-73
   */
  private Map<String, SerialInfo> serials = new HashMap<>();
   
  /**
   * This base classes must not be added as "allOf" property to a component schema.
   * BYPS-76
   */
  private Set<String> ignoreBaseClasses = new HashSet<>();

  @Override
  public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
    
    pctxt = new PrintContext(classDB, props);
    
    openApi = new OpenAPI();
    openApi.info(createInfo(classDB));
    openApi.servers(createServers());
    
    // This base classes must not be added as "allOf" property to a component schema.
    // BYPS-76
    String ignoreBaseClassesStr = props.getOptionalPropertyString(PropertiesRest.IGNORE_BASE_CLASS, "");
    Stream.of(ignoreBaseClassesStr.split(",")).map(String::trim).forEach(ignoreBaseClasses::add);
    ignoreBaseClasses.add(BValueClass.class.getName());
    
    // Map full type name to SerialInfo.
    // BYPS_73
    for (SerialInfo serInfo : classDB.getSerials()) {
      String fullName = serInfo.toString();
      serials.put(fullName, serInfo);
    }
    
    // Create OpenAPI schema definition.
    for (SerialInfo serInfo : classDB.getSerials()) {
      toSchema(serInfo);
    }
    
    toSchema(createSerialInfoForUploadResult());
    
    openApi.components(new Components().securitySchemes(createSecuritySchemes()).schemas(SchemaN.toComponentSchemas(schemas)));

    for (RemoteInfo remoteInfo : classDB.getRemotes()) {
      remoteInfo.methods.forEach(m -> toPath(m));
    }
    
    createPathItemForUpload();
    
    Paths oaiPaths = new Paths();
    paths.entrySet().forEach(e -> oaiPaths.addPathItem(e.getKey(), e.getValue()));
    openApi.paths(oaiPaths);
    
    write();
    writeRestOperationsClass();
  }
  
  private PathItem createPathItemForUpload() {
    PathItem pathItem = new PathItem();
    pathItem.summary("Upload file.");
    
    String uri = "/BUtility/upload";
    
    Operation op = new Operation();
    op.operationId("BUtility_upload");
    op.addTagsItem("BUtility");
    
    op.security(getSecurityRequirements());
    
    {
      ApiResponses responses = new ApiResponses();
      ApiResponse response200 = new ApiResponse();
      response200.description("Success");
      
      Content content = new Content();
      MediaType mediaType = new MediaType();
      Schema responseSchema = new Schema().$ref("#/components/schemas/BResult_BUtility_upload");
      mediaType.schema(responseSchema);
      content.addMediaType("application/json", mediaType);
      response200.content(content);
      
      responses.addApiResponse("200", response200);
    
      op.responses(responses);
    }
    
    {
      Content content = new Content();
      MediaType mediaType = new MediaType();
      mediaType.schema(new BinarySchema());
      content.addMediaType("application/octet-stream", mediaType);
      op.requestBody(new RequestBody().content(content));
    }
    
    pathItem.post(op); 
    
    paths.put(uri, pathItem);
    
    return pathItem;
  }
  
  private SerialInfo createSerialInfoForUploadResult() {
    String name = "BResult_BUtility_upload";
    String qname = "byps." + name;
    String baseFullName = "";
    String dims = "";
    List<TypeInfo> typeArgs = Collections.emptyList();
    List<MemberInfo> members = new ArrayList<MemberInfo>();
    boolean isEnum = false;
    boolean isFinal = false;
    boolean isInline = false;
    long since = 0;
    
    TypeInfo streamRefType = new TypeInfo(BStreamReference.class.getSimpleName(), 
        BStreamReference.class.getCanonicalName(), "", null, false, false, false);
    MemberInfo streamRefMember = new MemberInfo("result", streamRefType);
    members.add(streamRefMember);
    
    Collection<CommentInfo> comments = Arrays.asList();
    SerialInfo uploadResult = new SerialInfo(name, 
        comments, qname, baseFullName, 
        dims, typeArgs, members,
        isEnum, isFinal, isInline, since);
    return uploadResult;
  }
  
  
  
  private Map<String, SecurityScheme> createSecuritySchemes() {
    if (pctxt.props.containsKey(PropertiesRest.AUTHENTICATION_SCHEME_BASIC)) { 
      securitySchemes.put("basic", new SecurityScheme().type(Type.HTTP).scheme("basic"));
    }
    if (pctxt.props.containsKey(PropertiesRest.AUTHENTICATION_SCHEME_BEARER)) {
      securitySchemes.put("bearer", new SecurityScheme().type(Type.HTTP).scheme("bearer"));
    }
    if (pctxt.props.containsKey(PropertiesRest.AUTHENTICATION_SCHEME_API_KEY)) {
      String apiKey = pctxt.props.getProperty(PropertiesRest.AUTHENTICATION_SCHEME_API_KEY, "header:X-API-KEY");
      String[] values = apiKey.split("\\:"); 
      String keyIn = values[0];
      String keyName = values[1];
      SecurityScheme.In in = SecurityScheme.In.valueOf(keyIn.toUpperCase());
      securitySchemes.put("apiKey", new SecurityScheme().type(Type.APIKEY).in(in).name(keyName));
    }
    return securitySchemes.isEmpty() ? null : securitySchemes;
  }

  private List<Server> createServers() {
    Server server = new Server();
    String url = pctxt.getServerUrl();
    server.url(url);
    server.description("Production Endpoint");
    return Arrays.asList(server);
  }

  private void toPath(MethodInfo methodInfo) {
    
    RemoteInfo remoteInfo = methodInfo.remoteInfo;
    String remotePath = remoteInfo.name;
    if (remoteInfo.restInfo != null && remoteInfo.restInfo.getPath() != null) {
      remotePath = remoteInfo.restInfo.getPath();
    }
    
    String methodPath = methodInfo.name;
    if (methodInfo.restInfo != null && methodInfo.restInfo.getPath() != null) {
      methodPath = methodInfo.restInfo.getPath();
    }
    
    if (methodPath == null) {
      System.out.println("methodpath");
    }
    
    String uri = "/" + remotePath + "/" + methodPath;
    
    PathItem pathItem = paths.get(uri);
    if (pathItem == null) {
      pathItem = new PathItem();
      pathItem.summary(getCommentSummary(methodInfo.comments));
      pathItem.description(getCommentRemarks(methodInfo.comments, () -> "Interface " + remoteInfo + ", method " + methodInfo.name));
    }
 
    toOperation(remoteInfo, methodInfo, remotePath, pathItem);
    
    paths.put(uri, pathItem);
  }

  private void toOperation(RemoteInfo remoteInfo, MethodInfo methodInfo, String tag, PathItem pathItem) {
    Operation op = new Operation();
    op.operationId(remoteInfo.name + "_" + methodInfo.name);
    op.addTagsItem(tag);
    
    op.security(getSecurityRequirements());
    
    addResponses(methodInfo, op);
    
    RestMethod restMethod = methodInfo.restInfo != null && methodInfo.restInfo.getMethod() != null ? methodInfo.restInfo.getMethod() : RestMethod.POST;
    switch (restMethod) {
      case GET: 
        pathItem.get(op); 
        addRequestParams(methodInfo, op);
      break;
      case DELETE: 
        pathItem.delete(op); 
        addRequestParams(methodInfo, op);
      break;
      default: {
        pathItem.post(op); 
        addRequestBodies(methodInfo, op);
        break;
      }
    }
  }
  
  private List<SecurityRequirement> getSecurityRequirements() {
    if (securitySchemes.isEmpty()) return null;
    SecurityRequirement security = new SecurityRequirement();
    securitySchemes.keySet().forEach(security::addList);
    return Arrays.asList(security);
  }

  private void addResponses(MethodInfo methodInfo, Operation op) {
    ApiResponses responses = new ApiResponses();
    
    ApiResponse response200 = new ApiResponse();
    response200.description("Success");
    
    Content content = new Content();
    String contentType = RestInfo.getProducesOrDefault(methodInfo.restInfo);
    content.addMediaType(contentType, toResponseMediaType(methodInfo));
    response200.content(content);
    
    responses.addApiResponse("200", response200);
    
    op.responses(responses);
  }

  private void addRequestBodies(MethodInfo methodInfo, Operation op) {
    Content content = new Content();
    
    String contentType = RestInfo.getConsumesOrDefault(methodInfo.restInfo);
    if (contentType.equalsIgnoreCase(javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA)) {
      addRequestBodyMultipartFormData(content, methodInfo);
      op.requestBody(new RequestBody().content(content));
    }
    
    if (!methodInfo.requestInfo.members.isEmpty()) {
      addRequestBodyApplicationJson(content, methodInfo);
      op.requestBody(new RequestBody().content(content));
    }
    
  }

  private void addRequestBodyMultipartFormData(Content content, MethodInfo methodInfo) {
    MediaType mediaType = toRequestMediaTypeMultipartFormData(methodInfo);
    content.addMediaType("multipart/form-data", mediaType);
  }

  private void addRequestBodyApplicationJson(Content content, MethodInfo methodInfo) {
    MediaType mediaType = toRequestMediaTypeApplicationJson(methodInfo);
    content.addMediaType("application/json", mediaType);
  }

  private final boolean requestClassAsSchema = true;

  private Schema toRequestSchemaMediaType(MethodInfo methodInfo) {
    Schema requestSchema = new ObjectSchema();
    if (requestClassAsSchema) {
      SchemaN paramsSchema = toSchemaRef(methodInfo.requestInfo);
      requestSchema.addProperty(RestConstants.MULTIPART_DATA_PARAM_NAME, paramsSchema.getSchema());
    }
    else {
      for (MemberInfo param : methodInfo.requestInfo.members) {
        SchemaN paramSchema = toSchemaRef(param.type);
        requestSchema.addProperty(param.name, paramSchema.getSchema());
      }
    }
    return requestSchema;
  }

  private MediaType toRequestMediaTypeApplicationJson(MethodInfo methodInfo) {
    MediaType mediaType = new MediaType();
    
    SchemaN paramsSchema = toSchemaRef(methodInfo.requestInfo);
    Schema requestSchema = paramsSchema.getSchema();
    
    mediaType.schema(requestSchema);
    return mediaType;
  }
  
  private MediaType toRequestMediaTypeMultipartFormData(MethodInfo methodInfo) {
    MediaType mediaType = new MediaType();
    
    Schema requestSchema = new ObjectSchema();
    
    SchemaN paramsSchema = toSchemaRef(methodInfo.requestInfo);
    requestSchema.addProperty(RestConstants.MULTIPART_DATA_PARAM_NAME, paramsSchema.getSchema());

    ArraySchema streams = new ArraySchema().items(new FileSchema());
    requestSchema.addProperty(RestConstants.UPLOAD_ITEM_NAME, streams);
    
    mediaType.schema(requestSchema);
    return mediaType;
  }

  private MediaType toResponseMediaType(MethodInfo m) {
    MediaType mediaType = new MediaType();
    SchemaN responseSchema = toSchemaRef(m.resultInfo);
    mediaType.schema(responseSchema.getSchema());
    return mediaType;
  }
  
  private void addRequestParams(MethodInfo m, Operation op) {
    for (MemberInfo param : m.requestInfo.members) {
      SchemaN paramSchema = toSchemaRef(param.type);
      Parameter paramItem = new Parameter();
      paramItem.name(param.name);
      if (param.comments != null) paramItem.description(param.comments.stream().map(c -> c.text).collect(Collectors.joining()));
      paramItem.schema(paramSchema.getSchema());
      paramItem.in("query");
      op.addParametersItem(paramItem);
    }
  }

  private void write() throws IOException {
    File openapiFile = pctxt.getOpenAPIFile();
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(boolean.class, new BooleanSerializer());
    builder.registerTypeAdapter(Boolean.class, new BooleanSerializer());
    builder.registerTypeAdapter(ArraySchema.class, new ArraySchemaSerializer());
    builder.registerTypeAdapter(SecurityScheme.Type.class, new SecuritySchemeTypeSerializer());
    builder.registerTypeAdapter(SecurityScheme.In.class, new SecuritySchemeInSerializer());
    builder.setFieldNamingStrategy(new SchemaFieldNamingStrategy());
    builder.setExclusionStrategies(new ExcludeOpenApi31()); // BYPS-76
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    try (Writer writer = new OutputStreamWriter(new FileOutputStream(openapiFile), StandardCharsets.UTF_8)) {
      gson.toJson(openApi, writer);
    }
  }

  private void writeRestOperationsClass() throws IOException {
    String simpleClassName = "RestOperations_" + pctxt.classDB.getApiDescriptor().name;
    File restOperationsClass = pctxt.getRestOperationsFile(simpleClassName);
    try (OutputStream fos = new FileOutputStream(restOperationsClass)) {
      CodePrinter pr = new CodePrinter(fos, false);
      
      String pack = pctxt.classDB.getApiDescriptor().basePackage;
      pr.print("package ").print(pack).print(";").println();
      
      pr.println("// GENERATED code, do not modify");
      
      pr.println("import java.util.*;");
      pr.println("import byps.*;");
      pr.println("import byps.rest.*;");
      pr.println();
      
      pr.println("@SuppressWarnings({\"all\", \"deprecation\", \"unchecked\"})");

      pr.print("public class ").print(simpleClassName).println(" extends RestOperations {");
      pr.beginBlock();
      
      pr.println("public static RestOperations instance() {");
      pr.beginBlock();
      pr.println("return instance;");
      pr.endBlock();
      pr.println("}");
      
      pr.print("private static final RestOperations instance = new ").print(simpleClassName).println("();");
      
      pr.print("private ").print(simpleClassName).println("() {");
      
      pr.beginBlock();
      openApi.getPaths().entrySet().forEach(e -> printOperationRequest(pr, e.getKey(), e.getValue()));
      pr.endBlock();
      
      pr.println("}");
      pr.endBlock();
      
      pr.println("}");
      pr.close();
    }
  }
  
  private void printOperationRequest(CodePrinter pr, String path, PathItem item) {
    printAddOperation(pr, path, item.getGet(), "get");
    printAddOperation(pr, path, item.getPost(), "post");
    printAddOperation(pr, path, item.getDelete(), "delete");
  }

  private void printAddOperation(CodePrinter pr, String path, Operation op, String method) {
    if (op == null) return;
    String operationId = op.getOperationId();
    pr.print("add(\"").print(method).print("\", \"").print(path)
      .print("\", new Operation(\"").print(operationId).print("\"));")
      .println();
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
    else if (typeInfo.isAnyType()) {
      schema = toSchemaForPrimitiveType(typeInfo);    
    }
    else if (typeInfo.isStreamType()) {
      schema = toSchemaForStream(typeInfo);    
    }
    else if (typeInfo.isPrimitiveType()) {
      schema = toSchemaForPrimitiveType(typeInfo);    
    }
    else if (typeInfo instanceof RemoteInfo) {
      RemoteInfo remoteInfo = (RemoteInfo)typeInfo;
      String description = getDescription(remoteInfo.comments);
      schema = new SchemaN(typeInfo.name, new StringSchema().description(description));
    }
    else if (typeInfo.isEnum) {
      // BYPS-75: support enum constants
      schema = toEnumSchema(typeInfo);
      putSchema(schema);
    }
    else if (typeInfo instanceof SerialInfo) {
      
      SerialInfo serInfo = (SerialInfo)typeInfo;
      String description = getDescription(serInfo.comments);

      Schema schemaO = new ObjectSchema();
      schemaO.description(description);
      schema = new SchemaN(toSchemaName(typeInfo), schemaO);

      putSchema(schema);

      serInfo.members.stream().filter(member -> !member.type.isVoidType())
        .forEach(member -> {
          Schema memberSchema = toSchemaRef(member.type).getSchema();
          String memberDescription = getDescription(member.comments);
          schemaO.addProperty(member.name, memberSchema.description(memberDescription));
        });
      
      // BYPS-76: handle inheritance
      if (serInfo.baseInfo != null && !ignoreBaseClasses .contains(serInfo.baseInfo.qname)) {
        Schema baseSchema = toSchemaRef(serInfo.baseInfo).getSchema();
        schemaO.addAllOfItem(baseSchema);
      }
      
      if (serInfo.name.startsWith("BResult_")) {
        schemaO.addProperty("exception", new StringSchema().description("Error message"));
      }
      
    }
    else {
      // typeInfo is BRemote
      schema = new SchemaN(typeInfo.name, new StringSchema().description("Unsupported schema"));
      putSchema(schema);
    }
    
    return schema;
  }
  
  /**
   * Generate SchemaN object for Java enumeration class.
   * BYPS-75
   * @param typeInfo type information
   * @return schema object 
   */ 
  private SchemaN toEnumSchema(TypeInfo typeInfo) {
    StringSchema sschema = new StringSchema();
    if (typeInfo instanceof SerialInfo) {
      SerialInfo serInfo = (SerialInfo)typeInfo;
      if (serInfo.members != null) {
        serInfo.members.forEach(minfo -> sschema.addEnumItem(minfo.name));
      }
      String description = getDescription(serInfo.comments);
      sschema.setDescription(description);
    }
    return new SchemaN(toSchemaName(typeInfo), sschema);
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
    schema.addProperty("streamId", new StringSchema());
    schema.addProperty("url", new StringSchema());
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
    if (equalsOneOf(typeInfo.name, "boolean", "Boolean")) {
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
      //schema = new IntegerSchema().format("int64");
      
      // 64bit Integers loose Bit 53 to 63 in JavaScript's JSON.parse.
      // That's why Long-Values have to be serialized as Strings.
      schema = new StringSchema();
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

    // BYPS-73: byte[] is type=string, format=byte
    if (typeInfo.isByteArray1dim()) {
      return new SchemaN(schemaName, new ByteArraySchema());
    }

    // Provisional item type to build the full SerialInfo name which is used in the map 'serials'.
    TypeInfo itemType = new TypeInfo(typeInfo.name, typeInfo.qname, 
      typeInfo.dims.substring(2), typeInfo.typeArgs,
      typeInfo.isEnum, typeInfo.isFinal, typeInfo.isInline);
      
    // If itemType is not a primitive type, a SerialInfo object must be found in the map 'serials'.
    // The SerialInfo object has the full type information and must be used here to be able to create a Schema object
    // in toSchemaRef if necessary.
    // BYPS-73
    if (!typeInfo.isPrimitiveType()) {
      String itemTypeName = itemType.toString();
      itemType = serials.get(itemTypeName);
      if (itemType == null) throw new IllegalStateException("Missing " + itemTypeName + " as item type of " + typeInfo);
    }
    
    SchemaN itemSchema = toSchemaRef(itemType); 
    SchemaN arraySchema = new SchemaN(schemaName, new ArraySchema().items(itemSchema.getSchema()));
    
    schemas.put(schemaName, arraySchema);
    return arraySchema;
  }

  private String getCommentSummary(Collection<CommentInfo> comments) {
    if (comments == null) return null;
    String summary = comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_SUMMARY)).map(c -> c.text).findFirst().orElse("");
    return (summary != null && !summary.isEmpty()) ? summary : null;
  }
  
  private String getCommentRemarks(Collection<CommentInfo> comments, Supplier<String> defaultValue) {
    if (comments == null) return null;
    String value = comments.stream().filter(c -> c.kind.equals(CommentInfo.KIND_REMARKS)).map(c -> c.text).findFirst().orElse("");
    return (value != null && !value.isEmpty()) ? value : defaultValue.get();
  }
  
  private String getDescription(Collection<CommentInfo> comments) {
    String summary = getCommentSummary(comments);
    String remarks = getCommentRemarks(comments, () -> null);
    if (summary == null && remarks == null) return null;
    StringBuilder sbuf = new StringBuilder();
    if (summary != null) {
      sbuf.append(summary);
    }
    if (remarks != null) {
      if (sbuf.length() != 0) sbuf.append("\n");
      sbuf.append(remarks);
    }
    return sbuf.toString();
  }
  
}
