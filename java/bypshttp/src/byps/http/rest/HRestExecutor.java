package byps.http.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
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
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import byps.BContentStream;
import byps.BMethodRequest;
import byps.BRemote;
import byps.BServer;
import byps.BSyncResult;
import byps.BTargetId;
import byps.http.HConfig;
import byps.http.HConstants;
import byps.http.HFileUploadIncomingStream;
import byps.http.HSession;

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
   * Constructor.
   * @param config Server configuration
   * @param maxUploadFileSize Limit of upload file size, -1 means no limit.
   */
  public HRestExecutor(HConfig config, long maxUploadFileSize) {
    this.config = config;
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
    
    // Find index of interface name in URI
    int indexInterfaceName = requestUri.indexOf('/', indexRest + 1);
    if (indexInterfaceName == -1) {
      log.info("Missing interface name in REST request={}, use .../rest/interface-name/function-name.", requestUri);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    
    // Find index of function name in URI
    int indexFunctionName = requestUri.indexOf('/', indexInterfaceName + 1);
    if (indexFunctionName == -1) {
      log.info("Missing function name in REST request={}, use .../rest/interface-name/function-name.", requestUri);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    
    // Extract interface and function name from URI
    String interfaceName = requestUri.substring(indexInterfaceName+1, indexFunctionName);
    String functionName = requestUri.substring(indexFunctionName+1);
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
      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      if (isMultipart) {
        method = buildMethodFromMultiPart(sess, request, requestClass);
      }
      else {
        method = buildMethodFromJsonBody(request, requestClass);
      }
    }
    catch (Exception e) {
      log.error("Cannot instantiate method object for request={}", requestClass, e);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
    }
    
    // Execute the request object and write the response.
    response.setContentType("application/json");
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
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(InputStream.class, new StreamSerializer(sess));
    builder.registerTypeAdapter(byte[].class, new BytesSerializer());
    if (log.isDebugEnabled()) builder.setPrettyPrinting();
    Gson gson = builder.create();
    
    // For debug logging, write into a StringWriter.
    Writer innerWriter = writer;
    if (log.isDebugEnabled()) {
      innerWriter = new StringWriter();
    }

    try {
      // Execute
      if (log.isDebugEnabled()) log.debug("executeMethod {}", method);
      BSyncResult<Object> syncResult = new BSyncResult<>();
      method.execute(remote, syncResult);
      
      // Wait for result and serialize it
      if (log.isDebugEnabled()) log.debug("get result and serialize");
      Object result = syncResult.getResult();
      gson.toJson(result, innerWriter);
    }
    catch (Throwable e) {
      // Serialize error result
      if (log.isDebugEnabled()) log.debug("serialize error result", e);
      ExceptionResult result = new ExceptionResult(e);
      gson.toJson(result, innerWriter);
    }
    
    // For debug logging, print the JSON response into the log and copy the response to the provided Writer.
    if (log.isDebugEnabled()) {
      String jsonResponse = innerWriter.toString();
      log.debug("jsonResponse={}", jsonResponse);
      
      // Print JSON into provided Writer
      writer.append(jsonResponse);
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

    // Construct an empty request object
    Object brequest = requestClass.getConstructor().newInstance();
    
    // Parse the request
    List<FileItem> items = upload.parseRequest(request);
    if (log.isDebugEnabled()) log.debug("received #items={}", items.size());
    
    // Collect the streams provided in the request.
    // This map is used during deserialization to assign the stream objects referenced in the method parameters.
    Map<String, BContentStream> streamItems = items.stream().filter(item -> !item.isFormField())
        .collect(Collectors.toMap(FileItem::getFieldName, item -> toBypsStream(sess, item)));
    if (log.isDebugEnabled()) log.debug("#streams={}", streamItems.size());
    
    // Initialize deserialization
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(InputStream.class, new StreamDeserializer(streamItems));
    builder.registerTypeAdapter(byte[].class, new BytesDeserializer());
    
    // Assign the multipart fields to the method parameters 
    for (FileItem item : items) {
      assignFieldToMethodParam(requestClass, brequest, streamItems, builder, item);
    }

    if (log.isDebugEnabled()) log.debug(")buildMethodForMultiPart={}", brequest);
    return (BMethodRequest)brequest;
  }

  /**
   * Assign field to method object.
   * @param requestClass Method class
   * @param brequest Method object 
   * @param streamItems Streams provided in multipart/form-data request
   * @param builder GsonBuilder to serialize field value
   * @param item Field
   * @throws NoSuchFieldException
   * @throws IllegalAccessException
   */
  private void assignFieldToMethodParam(Class<?> requestClass, Object brequest, Map<String, BContentStream> streamItems,
      GsonBuilder builder, FileItem item) throws NoSuchFieldException, IllegalAccessException {
    
    // Provide reflection object to assign the method field
    String fieldName = item.getFieldName();
    Field field = requestClass.getDeclaredField(fieldName);
    Class<?> fieldClass = field.getType();
    if (log.isDebugEnabled()) log.debug("provide fieldName={}, fieldClass={}", fieldName, fieldClass);
    
    if (item.isFormField()) {
      // Non-streams can be JSON objects and have to be deserialized
      Gson gson = builder.create();
      String json = item.getString();
      if (log.isDebugEnabled()) log.debug("deserialize json={}", json);
      Object fieldValue = gson.fromJson(json, fieldClass);
      if (log.isDebugEnabled()) log.debug("assign fieldName={}, value={}", fieldName, fieldValue);
      field.set(brequest, fieldValue);
    }
    else {
      BContentStream stream = streamItems.get(fieldName);
      if (log.isDebugEnabled()) log.debug("assign fieldName={}, value={}", fieldName, stream);
      field.set(brequest, stream);
    }
  }
  

}
