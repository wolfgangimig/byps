package byps.http.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import byps.http.HConfig;
import byps.http.HConstants;
import byps.http.HFileUploadIncomingStream;
import byps.http.HSession;
import byps.rest.RestOperations;

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
  private final HConfig config;
  
  /**
   * Limit of upload file size.
   * Value -1 means no limit.
   */
  private final long maxUploadFileSize;
  
  /**
   * Map of REST operations.
   */
  private final RestOperations operations;
  
  /**
   * Constructor.
   * @param config Server configuration
   * @param maxUploadFileSize Limit of upload file size, -1 means no limit.
   */
  public HRestExecutor(HConfig config, RestOperations operations, long maxUploadFileSize) {
    this.config = config;
    this.operations = operations;
    this.maxUploadFileSize = maxUploadFileSize;
  }

  /**
   * Execute the REST call.
   * @param sess Session
   * @param request Request
   * @param response Response
   */
  public void doRest(HSession sess, HttpServletRequest request, HttpServletResponse response) {
    if (log.isDebugEnabled()) log.debug("doRest({}", request.getRequestURI());
    
    // Find /rest in URI 
    String requestUri = request.getRequestURI();
    int indexRest = requestUri.indexOf("/rest");
    if (indexRest == -1) return;
    
    // Find operation associated to REST path
    String restPath = requestUri.substring(indexRest + "/rest".length());
    RestOperations.Operation operation = operations.getOperation(request.getMethod(), restPath);
    if (operation == null) {
      log.info("No REST operation associated to path={}", restPath);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    
    // Get interface and function name from operation
    String interfaceName = operation.interfaceName;
    String functionName = operation.functionName;
    if (log.isDebugEnabled()) log.debug("interfaceName={}, functionName={}", interfaceName, functionName);
    
    // Find the interface implementation registered with the BServer.
    BServer.FindRemoteResult findResult = sess.getServer().findRemote(interfaceName);
    if (findResult == null) {
      log.info("Inteface={} is not implemented. Be aware of the case-sensitive search used to lookup the implementation.", requestUri);
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
      log.info("Function={} is not a member of interface={}. Be aware of the case-sensitive search used to find the function.", functionName, requestClassName);
      response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
      return;
    }
    
    // Create an instance of the request class and assign its parameters.
    BMethodRequest method = null;
    try {
      if (request.getMethod().equalsIgnoreCase("post")) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (log.isDebugEnabled()) log.debug("contentType={}, isMultipart={}", request.getContentType(), isMultipart);
        if (isMultipart) {
          method = buildMethodFromMultiPart(sess, request, requestClass);
        }
        else {
          method = buildMethodFromJsonBody(request, requestClass);
        }
      }
      else {
        method = buildMethodFromQueryParams(request, requestClass); 
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
      executeMethod(sess, remote, method, writer);
    }
    catch (IOException e) {
      log.error("Failed to write response.", e);
    }
    
    if (log.isDebugEnabled()) log.debug(")doRest");
  }
  
  /**
   * Wrap an Apache file upload item into a BYPS stream.
   * @param sess BYPS session
   * @param item Upload item
   * @return BYPS stream
   */
  protected BContentStream toBypsStream(HSession sess, FileItem item) {
    if (log.isDebugEnabled()) log.debug("toBypsStream(fieldName={}, fileName={}", item.getFieldName(), item.getName());
    long streamId = sess.getServer().getTransport().getWire().makeMessageId();
    final BTargetId targetId = new BTargetId(config.getMyServerId(), 0, streamId);
    BContentStream stream = new HFileUploadIncomingStream(item, targetId, config.getTempDir());
    if (log.isDebugEnabled()) log.debug(")toBypsStream={}", stream);
    return stream;
  }
  
  /**
   * Create GsonBuilder to serialize response.
   * @return GsonBuilder
   */
  protected GsonBuilder createResponseBuilder() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(byte[].class, new BytesSerializer());
    return builder;
  }
  
  /**
   * Execute the call and write the response.
   * @param sess BYPS session
   * @param remote Interface implementation
   * @param method Method object
   * @param writer Response is printed into this Writer
   * @throws IOException 
   */
  protected void executeMethod(HSession sess, BRemote remote, BMethodRequest method, Writer writer) throws IOException {
    if (log.isDebugEnabled()) log.debug("executeMethod(");
    
    // Initialize builder for JSON response.
    GsonBuilder builder = createResponseBuilder();
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
      TransformObject.transformBeforeSerializeToJson(sess, result);
      
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
   * @param request HTTP request
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
  protected BMethodRequest buildMethodFromJsonBody(HttpServletRequest request, Class<?> requestClass) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    if (log.isDebugEnabled()) log.debug("buildMethodFromJsonBody(");
    BMethodRequest method = null;
    
    try (Reader reader = request.getReader()) {
      
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
      
      // Deserialize
      GsonBuilder builder = new GsonBuilder();
      builder.registerTypeAdapter(InputStream.class, new StreamDeserializer(Collections.emptyMap()));
      builder.registerTypeAdapter(byte[].class, new BytesDeserializer());
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
   * Read the request into an object of the given request class. 
   * The request body must be multipart/form-data and might contain streams.
   * @param sess BYPS session
   * @param request HTTP request
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
   */
  protected BMethodRequest buildMethodFromMultiPart(HSession sess, HttpServletRequest request, Class<?> requestClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, FileUploadException, NoSuchFieldException {
    if (log.isDebugEnabled()) log.debug("buildMethodForMultiPart(");
    
    // Create a factory for disk-based file items
    DiskFileItemFactory factory = new DiskFileItemFactory(HConstants.INCOMING_STREAM_BUFFER, config.getTempDir());

    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);

    // Set overall request size constraint
    upload.setSizeMax(maxUploadFileSize);

    // Parse the request
    List<FileItem> items = upload.parseRequest(request);
    if (log.isDebugEnabled()) log.debug("received #items={}", items.size());
    
    // Collect the streams provided in the request and map them to "file==file[0], file[1], ...".
    // This map is used during deserialization to assign the stream objects referenced in the method parameters.
    Map<String, BContentStream> streams = mapFieldNamesToStreams(sess, items);
    if (log.isDebugEnabled()) log.debug("#streams={}", streams.size());
    
    // Initialize deserialization
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(InputStream.class, new StreamDeserializer(streams));
    builder.registerTypeAdapter(byte[].class, new BytesDeserializer());
    
    List<FileItem> formFields = items.stream().filter(item -> item.isFormField()).collect(Collectors.toList());
    String jsonData = "";
    Optional<FileItem> dataField = formFields.stream().filter(item -> item.getFieldName().equals(RestConstants.MULTIPART_DATA_PARAM_NAME)).findAny();
    
    if (formFields.isEmpty()) {
      // Bad request
      throw new IllegalStateException("Missing form fields in multipart/form-data. At least field " + RestConstants.MULTIPART_DATA_PARAM_NAME + " must be available.");
    }
    else if (dataField.isPresent()) {
      // Only one form field with BRequest_ object
      // See GeneratorOpenAPI.toRequestMediaTypeMultipartFormData
      jsonData = dataField.get().getString();
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
      for (FileItem item : items) {
        if (item.isFormField()) {
          // Print the field and its value into the buffer
          addComma = appendFieldToJsonString(requestClass, item, addComma, sbuf);
        }
      }
      sbuf.append("}");
      jsonData = sbuf.toString();
    }
    
    // Deserialize the BMethodRequest
    Gson gson = builder.create();
    BMethodRequest brequest = (BMethodRequest)gson.fromJson(jsonData, requestClass);

    if (log.isDebugEnabled()) log.debug(")buildMethodForMultiPart={}", brequest);
    return brequest;
  }
  
  private BMethodRequest buildMethodFromQueryParams(HttpServletRequest request, Class<?> requestClass) throws NoSuchFieldException {
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
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(byte[].class, new BytesDeserializer());
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
   */
  private boolean appendFieldToJsonString(Class<?> requestClass, FileItem item, boolean addComma,
      StringBuilder sbuf) throws NoSuchFieldException {
    if (log.isDebugEnabled()) log.debug("appendFieldToJsonString(requestClass={}, field.name={}", requestClass, item.getFieldName());

    String fieldName = item.getFieldName();
    
    // An unassigned stream item (upload item with no file) is interpreted by 
    // Apache FileUpload as FileItem.isFormField()=true. This item must be skipped
    // here because there is no corresponding field in the request class.
    String itemString = item.getString();
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
   * @param sess
   * @param items
   * @return
   */
  private Map<String, BContentStream> mapFieldNamesToStreams(HSession sess, List<FileItem> items) {
    Map<String, BContentStream> streams = new HashMap<>();
    
    // Map for field names and how often they are repeated.
    Map<String, Integer> nameAndCount = new HashMap<>();
    
    // Loop over stream items (non-form-field items)
    items.stream().filter(item -> !item.isFormField()).forEach(item -> {
      
      // Field name is usually 'file'
      String name = item.getFieldName();
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

}
