package byps.http.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import byps.BContentStream;
import byps.BMethodRequest;
import byps.BRemote;
import byps.BServer;
import byps.BSyncResult;
import byps.BTargetId;
import byps.gen.RestConstants;
import byps.http.HActiveMessages;
import byps.http.HConfig;
import byps.http.HConstants;
import byps.http.HFileUploadIncomingStream;
import byps.http.HIncomingStreamSync;
import byps.http.HServerContext;
import byps.http.HSession;
import byps.io.ByteArrayOutputStream;
import byps.rest.BStreamReference;
import byps.rest.RestOperations;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Execute REST call.
 * 
 * A REST call must invoke the URI .../rest/interface-name/function-name as a POST request.
 * 
 * BYPS-51
 */
public class HRestExecutor {
  
  private static final Logger log = LoggerFactory.getLogger(HRestExecutor.class);
  
  /**
   * Server configuration.
   * Provides temp directory and server ID.
   */
  protected final HConfig config;
  
  /**
   * Limit of upload file size.
   * Value -1 means no limit.
   */
  protected final long maxUploadFileSize;
  
  /**
   * Map of REST operations.
   */
  protected final RestOperations operations;
  
  /**
   * BYPS session.
   */
  protected final HSession sess;
  
  /**
   * HTTP Request.
   */
  protected final HttpServletRequest request;
  
  /**
   * HTTP Response.
   */
  protected final HttpServletResponse response;
  
  /**
   * Constructor.
   * @param config Server configuration
   * @param operations Map of Path to Operation
   * @param maxUploadFileSize Limit of upload file size, -1 means no limit.
   * @param sess Session
   * @param request Request
   * @param response Response
   */
  public HRestExecutor(HConfig config, RestOperations operations, long maxUploadFileSize,
      HSession sess, HttpServletRequest request, HttpServletResponse response) {
    this.config = config;
    this.operations = operations;
    this.maxUploadFileSize = maxUploadFileSize;
    this.sess = sess;
    this.request = request;
    this.response = response;
  }

  /**
   * Execute the REST call.
   */
  public void doRest() {
    if (log.isDebugEnabled()) log.debug("doRest({}", request.getRequestURI());
    
    // Find /rest in URI 
    String requestUri = request.getRequestURI();
    int indexRest = requestUri.indexOf("/rest");
    if (indexRest == -1) return;
    
    // Find operation associated to REST path
    String restPath = requestUri.substring(indexRest + "/rest".length());
    RestOperations.Operation operation = operations.getOperation(request.getMethod(), restPath);
    if (operation == null) {
      log.warn("No REST operation associated to path={}", restPath);
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    
    // Get interface and function name from operation
    String interfaceName = operation.interfaceName;
    String functionName = operation.functionName;
    if (log.isDebugEnabled()) log.debug("interfaceName={}, functionName={}", interfaceName, functionName);
    
    // Find the interface implementation registered with the BServer.
    BServer.FindRemoteResult findResult = sess.getServer().findRemote(interfaceName);
    if (findResult == null) {
      log.warn("Inteface={} is not implemented. Be aware of the case-sensitive search used to lookup the implementation.", requestUri);
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    BRemote remote = findResult.remoteImpl;
    
    // Find the request class used to (de-)serialize the function.
    String remotePackage = findResult.remoteIntefaceClass.getPackage().getName();
    String requestClassName = "BRequest_" + interfaceName + "_" + functionName;
    Class<?> requestClass;
    try {
      if (log.isDebugEnabled()) log.debug("lookup serialization class={}", requestClassName);
      requestClass = Class.forName(remotePackage + "." + requestClassName);
    }
    catch (ClassNotFoundException e) {
      log.warn("Function={} is not a member of interface={}. Be aware of the case-sensitive search used to find the function.", functionName, requestClassName);
      response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
      return;
    }
    
    // Create an instance of the request class and assign its parameters.
    BMethodRequest method = null;
    try {
      if (request.getMethod().equalsIgnoreCase("post")) {
        String contentType = request.getContentType();
        boolean isMultipart = contentType != null && contentType.toLowerCase().startsWith("multipart/");
        if (log.isDebugEnabled()) log.debug("contentType={}, isMultipart={}", request.getContentType(), isMultipart);
        if (isMultipart) {
          method = buildMethodFromMultiPart(requestClass);
        }
        else {
          method = buildMethodFromJsonBody(requestClass);
        }
      }
      else {
        method = buildMethodFromQueryParams(requestClass); 
      }
    }
    catch (Exception e) {
      log.error("Cannot instantiate method object for request={}", requestClass, e);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
      return;
    }
    
    // Execute the request object and write the response.
    response.setContentType("application/json");
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    try (Writer writer = response.getWriter()) {
      executeMethod(remote, method, writer);
    }
    catch (IOException e) {
      log.error("Failed to write response.", e);
    }
    
    if (log.isDebugEnabled()) log.debug(")doRest");
  }
  
  /**
   * Upload stream into temporary storage.
   */
  public void doRestUpload() {
    BServer server = sess.getServer();
    HServerContext serverContext = sess.getServerContext();
    HConfig config = serverContext.getConfig();
    
    try {
      // Generate a random streamId and assign a BTargetId to the stream.
      long messageId = 0;
      long streamId = server.getTransport().getWire().makeMessageId();
      BTargetId targetId = new BTargetId(config.getMyServerId(), messageId, streamId);
      
      // Wrap stream into a BContentStream
      long contentLength = request.getContentLengthLong();
      String contentType = request.getContentType();
      String contentDisposition = request.getHeader("Content-Disposition");
      File tempDir = config.getTempDir();
      log.info("Add uploaded stream, targetId={}, contentLength={}, contentType={}", targetId, contentLength, contentType);
      
      HIncomingStreamSync stream = new HIncomingStreamSync(targetId, contentType, contentLength, contentDisposition, HConstants.INCOMING_STREAM_TIMEOUT_MILLIS, tempDir);
      stream.assignStream(request.getInputStream());
      
      // Add the stream to the map of streams.
      serverContext.getActiveMessages().addIncomingUploadStream(stream);
      
      // Return the streamId as BStreamReference.file the response body.
      response.setStatus(HttpServletResponse.SC_OK);
      response.setContentType(MediaType.APPLICATION_JSON);
      
      BResult_BUtility_upload result = new BResult_BUtility_upload(streamId);
      GsonBuilder builder = createSerializationBuilder();
      Gson gson = builder.create();
      try (Writer writer = response.getWriter()) {
        gson.toJson(result, result.getClass(), writer);
      }
    }
    catch (IOException e) {
      log.warn("Failed to add uploaded stream.", e);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
  
  private static class BResult_BUtility_upload {
    BStreamReference result;
    BResult_BUtility_upload(long streamId) {
      result = new BStreamReference();
      result.setStreamId(Long.toString(streamId));
    }
  }
  
  /**
   * Wrap an Apache file upload item into a BYPS stream.
   * @param sess BYPS session
   * @param item Upload item
   * @return BYPS stream
   */
  protected BContentStream toBypsStream(HSession sess, Part item) {
    if (log.isDebugEnabled()) log.debug("toBypsStream(fieldName={}, fileName={}", item.getName(), item.getSubmittedFileName());
    long streamId = sess.getServer().getTransport().getWire().makeMessageId();
    final BTargetId targetId = new BTargetId(config.getMyServerId(), 0, streamId);
    BContentStream stream = HFileUploadIncomingStream.create(item, targetId, config.getTempDir());
    if (log.isDebugEnabled()) log.debug(")toBypsStream={}", stream);
    return stream;
  }
  
  /**
   * Create GsonBuilder to serialize response.
   * @return GsonBuilder
   */
  protected GsonBuilder createSerializationBuilder() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(byte[].class, new BytesSerializer());
    builder.registerTypeAdapter(long.class, new Int64Serializer());
    builder.registerTypeAdapter(Long.class, new Int64Serializer());
    return builder;
  }

  /**
   * Create GsonBuilder to deserialize request.
   * @param context
   * @param getStream  
   * @return GsonBuilder
   */
  protected GsonBuilder createDeserializationBuilder(Function<String, BContentStream> getStream) {
    GsonBuilder builder = new GsonBuilder();
    
    builder.registerTypeAdapter(InputStream.class, new StreamDeserializer(getStream));
    builder.registerTypeAdapter(byte[].class, new BytesSerializer());
    builder.registerTypeAdapter(long.class, new Int64Serializer());
    builder.registerTypeAdapter(Long.class, new Int64Serializer());
    return builder;
  }
  
  
  protected TransformObjectBeforeSerialization getTransformObjectBeforeSerialization() {
    return new TransformObjectBeforeSerialization(this, Collections.emptySet());
  }

  /**
   * Execute the call and write the response.
   * @param context Context
   * @param remote Interface implementation
   * @param method Method object
   * @param writer Response is printed into this Writer
   * @throws IOException 
   */
  protected void executeMethod(BRemote remote, BMethodRequest method, Writer writer) throws IOException {
    if (log.isDebugEnabled()) log.debug("executeMethod(");
    
    // Initialize builder for JSON response.
    GsonBuilder builder = createSerializationBuilder();
    if (log.isDebugEnabled()) builder.setPrettyPrinting();
    
    // The response must not been written into the output (writer) directly
    // to be able to send a different response in case of an error during 
    // JSON serialization.
    Writer innerWriter = new StringWriter();
    
    try {
      // Execute
      if (log.isDebugEnabled()) log.debug("executeMethod {}", method);
      BSyncResult<Object> syncResult = new BSyncResult<>();
      method.execute(remote, syncResult);
      
      // Wait for result and replace InputStreams with BStreamReference
      if (log.isDebugEnabled()) log.debug("get result and serialize");
      Object result = syncResult.getResult();
      
      TransformObjectBeforeSerialization trafo = getTransformObjectBeforeSerialization();
      trafo.transformObject(result);
      
      // Serialize to JSON
      Gson gson = builder.create();
      gson.toJson(result, innerWriter);
    }
    catch (Throwable e) {
      // Serialize error result
      log.error("serialize error result", e);
      ExceptionResult result = new ExceptionResult(e);
      Gson gson = builder.create();
      gson.toJson(result, innerWriter);
    }

    // Print JSON into provided Writer
    String jsonResponse = innerWriter.toString();
    writer.append(jsonResponse);

    // For debug logging, print the JSON response into the log and copy the response to the provided Writer.
    if (log.isDebugEnabled()) {
      log.debug("jsonResponse={}", jsonResponse);
    }

    if (log.isDebugEnabled()) log.debug(")executeMethod");
  }

  /**
   * Exception result.
   * 
   * An object of this class is serialized to JSON and returned if a method execution fails.
   */
  protected static class ExceptionResult {
    
    /**
     * Exception message.
     */
    protected String exception;
    
    protected ExceptionResult(Throwable e) {
      this.exception = e.toString();
    }
  }

  /**
   * Read the request into an object of the given request class. 
   * The request body must be text (JSON) and cannot contain streams. 
   * @param requestClass Request class
   * @return Request object
   * @throws IOException
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException
   * @throws NoSuchMethodException
   * @throws SecurityException
   */
  protected BMethodRequest buildMethodFromJsonBody(Class<?> requestClass) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    if (log.isDebugEnabled()) log.debug("buildMethodFromJsonBody(");
    BMethodRequest method = null;
    
    try (Reader reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8)) {
      
      // For debug logging, print the request into the log file. 
      Reader innerReader = reader;
      if (log.isDebugEnabled()) {
        StringBuilder sbuf = new StringBuilder();
        char[] buf = new char[10000];
        int len = 0;
        while ((len = reader.read(buf)) != -1) {
          sbuf.append(buf, 0, len);
        }
        
        // Provide Reader for deserialization
        String jsonRequest = sbuf.toString();
        if (log.isDebugEnabled()) log.debug("jsonRequest={}", jsonRequest);
        innerReader = new StringReader(jsonRequest);
      }
      
      // Function that returns the stream associated to a streamId
      Function<String, BContentStream> getStream = makeProviderForUploadedStream();

      // Deserialize
      GsonBuilder builder = createDeserializationBuilder(getStream);
      Gson gson = builder.create();
      method = (BMethodRequest)gson.fromJson(innerReader, requestClass);
    }
    
    // If the body is empty (function does not have parameters), create an empty request object.
    if (method == null) {
      method = (BMethodRequest)requestClass.getConstructor().newInstance();
    }
    
    if (log.isDebugEnabled()) log.debug(")buildMethodFromJsonBody={}", method);
    return method;
  }
  
  /**
   * Create a function object that returns a stream for a given streamId.
   * The stream must have been uploaded via HHttpServlet.doRestPutStream
   * @return Function
   */
  private Function<String, BContentStream> makeProviderForUploadedStream() {
    return streamId -> 
    {
      try {
        if (log.isDebugEnabled()) log.debug("makeProviderForUploadedStream.apply(streamId={}", streamId);
        HActiveMessages activeMessages = sess.getServerContext().getActiveMessages();
        BContentStream stream = activeMessages.getIncomingOrOutgoingStream(Long.parseLong(streamId), HConstants.INCOMING_STREAM_TIMEOUT_MILLIS);
        if (log.isDebugEnabled()) log.debug(")makeProviderForUploadedStream.apply={}", stream);
        return stream;
      }
      catch (IOException e) {
        throw new UncheckedIOException("Failed to get incoming stream, streamId=" + streamId, e);
      }
    };
  }
  
  /**
   * Read the request into an object of the given request class. 
   * The request body must be multipart/form-data and might contain streams.
   * @param context Context
   * @param requestClass Request class
   * @return Request object
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException
   * @throws NoSuchMethodException
   * @throws SecurityException
   * @throws FileUploadException
   * @throws NoSuchFieldException
   * @throws ServletException 
   * @throws IOException 
   */
  protected BMethodRequest buildMethodFromMultiPart(Class<?> requestClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ServletException {
    if (log.isDebugEnabled()) log.debug("buildMethodForMultiPart(");
    
    // Parse the request
    Collection<Part> items = request.getParts();
    if (log.isDebugEnabled()) log.debug("received items={}", items.stream().map(Part::getName).collect(Collectors.toList()));
    
    // Collect the streams provided in the request and map them to "file==file[0], file[1], ...".
    // This map is used during deserialization to assign the stream objects referenced in the method parameters.
    Map<String, BContentStream> streams = mapFieldNamesToStreams(items);
    if (log.isDebugEnabled()) log.debug("streams={}", streams.keySet());
    Function<String, BContentStream> getStream = streamId -> streams.get(streamId);
    
    // Initialize deserialization
    GsonBuilder builder = createDeserializationBuilder(getStream);
    
    List<Part> formFields = items.stream().filter(item -> item.getSubmittedFileName() == null).collect(Collectors.toList());
    String jsonData = "";
    
    // Field "data" contains the parameters as JSON object.
    // If using the browser's FormData.append("data", blob), it is recognized as stream field 
    // not as form field.
    Optional<Part> dataField = items.stream().filter(item -> item.getName().equals(RestConstants.MULTIPART_DATA_PARAM_NAME)).findAny();
    
    if (dataField.isPresent()) {
      
      // Only one form field with BRequest_ object
      // See GeneratorOpenAPI.toRequestMediaTypeMultipartFormData
      jsonData = fieldContentToString(dataField.get());
      
      if (log.isDebugEnabled()) log.debug("jsonData={}", jsonData);
    }
    else if (formFields.isEmpty()) {
      // Bad request
      throw new IllegalStateException("Missing form fields in multipart/form-data. At least field " + RestConstants.MULTIPART_DATA_PARAM_NAME + " must be available.");
    }
    else {
      // For each parameter one form field.
      // See GeneratorOpenAPI.toRequestMediaTypeMultipartFormData
      
      // Construct a JSON string for the BMethodRequest with the given form fields.
      // Gson does not deserialize a generic class in gson.fromJson if the class is given as Class<?> object.
      // Hence, deserialization field by field does not allow to use generic method parameters.
      // The BMethodRequest class is not a generic class and therefore it is correctly deserialized by Gson. 
      // Event its generic members are correctly deserialized - magic. 
      StringBuilder sbuf = new StringBuilder();
      sbuf.append("{");
      boolean addComma = false;
      for (Part item : items) {
        if (item.getSubmittedFileName() == null) {
          // Print the field and its value into the buffer
          addComma = appendFieldToJsonString(requestClass, item, addComma, sbuf);
        }
      }
      sbuf.append("}");
      jsonData = sbuf.toString();
      if (log.isDebugEnabled()) log.debug("jsonData={}", jsonData);
    }
    
    // Deserialize the BMethodRequest
    Gson gson = builder.create();
    BMethodRequest brequest = (BMethodRequest)gson.fromJson(jsonData, requestClass);

    if (log.isDebugEnabled()) log.debug(")buildMethodForMultiPart={}", brequest);
    return brequest;
  }

  /**
   * Read multipart/form-data field into String.
   * @param dataField Field
   * @return String
   * @throws IOException
   */
  private String fieldContentToString(Part dataField) throws IOException {
    String jsonData = null;
    try (InputStream istream = dataField.getInputStream();
        ByteArrayOutputStream ostream = new ByteArrayOutputStream()) {
      if (istream != null) {
        istream.transferTo(ostream);
        byte[] bytes = ostream.toByteArray();
        jsonData = new String(bytes, StandardCharsets.UTF_8);
      }
    }
    return jsonData;
  }
  
  /**
   * Build method object for GET request.
   * @param requestClass
   * @return Method object
   * @throws NoSuchFieldException
   */
  private BMethodRequest buildMethodFromQueryParams(Class<?> requestClass) throws NoSuchFieldException {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("{");
    boolean addComma = false;

    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String paramValue = request.getParameter(paramName);
      addComma = addFieldValueToJsonString(requestClass, addComma, sbuf, paramName, paramValue);
    }
  
    sbuf.append("}");
    String jsonData = sbuf.toString();
  
    // Deserialize the BMethodRequest
    // Initialize deserialization
    GsonBuilder builder = createDeserializationBuilder(streamId -> null);
    Gson gson = builder.create();
    BMethodRequest brequest = (BMethodRequest)gson.fromJson(jsonData, requestClass);

    return brequest;
  }

  /**
   * Print multipart field and its value into the string buffer.
   * @param requestClass BMethodRequest class
   * @param item 
   * @param addComma
   * @param sbuf
   * @return
   * @throws NoSuchFieldException
   * @throws IOException 
   */
  private boolean appendFieldToJsonString(Class<?> requestClass, Part item, boolean addComma,
      StringBuilder sbuf) throws NoSuchFieldException, IOException {
    if (log.isDebugEnabled()) log.debug("appendFieldToJsonString(requestClass={}, field.name={}", requestClass, item.getName());

    String fieldName = item.getName();
    
    // An unassigned stream item (upload item with no file) is interpreted by 
    // Apache FileUpload as FileItem.isFormField()=true. This item must be skipped
    // here because there is no corresponding field in the request class.
    String itemString = fieldContentToString(item);
    if (log.isDebugEnabled()) log.debug("fieldAsString={}", itemString);
    if (itemString == null || itemString.isEmpty()) return addComma;
    
    addComma = addFieldValueToJsonString(requestClass, addComma, sbuf, fieldName, itemString);
    
    if (log.isDebugEnabled()) log.debug(")appendFieldToJsonString={}", addComma);
    return addComma;
  }

  private boolean addFieldValueToJsonString(Class<?> requestClass, boolean addComma, StringBuilder sbuf, String fieldName, String itemString)
      throws NoSuchFieldException {
    final String BS = "\"";

    if (addComma) sbuf.append(","); else addComma = true;
    sbuf.append(BS).append(fieldName).append(BS).append(":");
    
    if (log.isDebugEnabled()) log.debug("get field via reflection, field={}", fieldName);
    Field field = requestClass.getDeclaredField(fieldName);
    Class<?> fieldType = field.getType();
    if (log.isDebugEnabled()) log.debug("fieldType={}", fieldType);
    
    if (fieldType == String.class) {
      sbuf.append(BS).append(itemString).append(BS);
    }
    else if (fieldType == boolean.class || fieldType == Boolean.class) {
      sbuf.append(itemString);
    }
    else if (fieldType == int.class || fieldType == long.class || fieldType == float.class || fieldType == double.class || Number.class.isAssignableFrom(fieldType)) {
      sbuf.append(itemString);
    }
    else {
      sbuf.append(itemString);
    }
    return addComma;
  }

  /**
   * Build a map of field names to upload streams.
   * 
   * If field names are repeatedly used, the mapping is as 'file', 'file[0]', 'file[1]', ...
   * The value of InputStream objects in the message have to reference the streams by this names, see {@link StreamDeserializer}.
   * 
   * @param items
   * @return
   */
  private Map<String, BContentStream> mapFieldNamesToStreams(Collection<Part> items) {
    Map<String, BContentStream> streams = new HashMap<>();
    
    // Map for field names and how often they are repeated.
    Map<String, Integer> nameAndCount = new HashMap<>();
    
    // Loop over stream items (non-form-field items)
    items.stream().filter(item -> item.getSubmittedFileName() != null).forEach(item -> {
      
      // Field name is usually 'file'
      String name = item.getName();
      Integer count = nameAndCount.get(name);
      
      if (count == null) {
        // First use of 'file' -> map 'file' to stream and 'file[0]' to stream
        count = 0;
        BContentStream bstream = toBypsStream(sess, item);
        streams.put(name, bstream);
        streams.put(name + "[0]", bstream);
      }
      else {
        // Additional use of 'file', increment usage count, map 'file[count]' to stream
        count++;
        BContentStream bstream = toBypsStream(sess, item);
        streams.put(name + "[" + count + "]", bstream);
      }
      
      nameAndCount.put(name, count);
      
    });
    
    return streams;
  }

  public HSession getSession() {
    return sess;
  }

}
