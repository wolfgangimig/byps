package byps.http;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BApiDescriptor;
import byps.BAsyncResult;
import byps.BBuffer;
import byps.BBufferJson;
import byps.BClient;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BHashMap;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BProtocol;
import byps.BServer;
import byps.BServerRegistry;
import byps.BSyncResult;
import byps.BTargetId;
import byps.BTransport;
import byps.BWire;
import byps.RemoteException;
import byps.http.rest.HRestExecutor;
import byps.log.LogConfigurator;
import byps.rest.RestOperations;
import byps.ureq.BRegistry_BUtilityRequests;
import byps.ureq.BSkeleton_BUtilityRequests;
import byps.ureq.JRegistry_BUtilityRequests;

public abstract class HHttpServlet extends HttpServlet implements
    HServerContext {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HHttpServlet() {
    if (log.isDebugEnabled()) log.debug("BHttpServlet()");
    
    // Get Keep-Alive header value.
    httpHeaderkeepAliveTimeout = getBypsHeaderKeepAliveFromSystemProperty();
  }

  private static Integer getBypsHeaderKeepAliveFromSystemProperty() {
    Integer httpHeaderkeepAliveTimeout = null;
    String prop = System.getProperty(HConstants.RESPONSE_HEADER_KEEP_ALIVE_TIMEOUT);
    if (prop != null && prop.length() != 0) {
      try {
        httpHeaderkeepAliveTimeout = Integer.parseInt(prop); 
        if (httpHeaderkeepAliveTimeout < 0) {
          throw new IllegalStateException();
        }
      }
      catch (Exception e) {
        log.error("Property must be a positive integer: " + HConstants.RESPONSE_HEADER_KEEP_ALIVE_TIMEOUT + "=" + prop);
      }
    }
    return httpHeaderkeepAliveTimeout;
  }

  /**
   * Create a session.
   * 
   * @param hsess
   *          HttpSession
   * @param remoteUser
   *          Request attribute REMOTE_USER.
   * @return HSession object
   * @throws BExeption
   *           with code=BExceptionC.FORBIDDEN if authentication has failed.
   */
  protected abstract HSession createSession(HttpSession hsess, String remoteUser)
      throws BException;

  /**
   * Return the API descriptor
   * 
   * @return API descriptor
   */
  protected abstract BApiDescriptor getApiDescriptor();
  
  /**
   * Get REST operations.
   * 
   * BYPS-50
   * @return Map of REST operations
   */
  protected RestOperations getRestOperations() {
    return RestOperations.EMPTY;
  }

  // /////////////////////////////////////////////////
  // Begin implementation of HServerContext

  /**
   * Get configuration object.
   * 
   * @return Configuration object.
   */
  public abstract HConfig getConfig();

  @Override
  public BServerRegistry getServerRegistry() {
    return serverRegistry_use_getServerRegistry;
  }

  @Override
  public HServerListener getListener() {
    return defaultListener;
  }

  @Override
  public HActiveMessages getActiveMessages() {
    return activeMessages_use_getActiveMessages;
  }

  // End implementation of HServerContext
  // /////////////////////////////////////////////////

  /**
   * This function is called after initialization has finished.
   */
  protected void initializationFinished() {
  }

  protected HTargetIdFactory getTargetIdFactory() {
    return targetIdFact_use_getTargetIdFactory;
  }

  @Override
  public void init() throws ServletException {
    if (log.isDebugEnabled()) log.debug("init(");
    super.init();

    // Initialize in Background.
    // Tomcat should not hang during startup if initialization takes some time
    // or if it connects other servlets running on the same tomcat.
    ServletConfig servletConfig = getServletConfig();
    (new InitThread(servletConfig)).start();

    if (log.isDebugEnabled()) log.debug(")init");
  }

  /**
   * Initialization thread
   */
  private class InitThread extends Thread {
    ServletConfig servletConfig;

    InitThread(ServletConfig servletConfig) {
      super("eloix-binit");
      this.servletConfig = servletConfig;
    }

    public void run() {

      // Configuration entries from web.xml
      try {
        HConfig config = getConfig();
        config.init(servletConfig);

        initLogger(config);

        int serverId = config.getMyServerId();
        targetIdFact_use_getTargetIdFactory = new HTargetIdFactory(serverId);

        serverRegistry_use_getServerRegistry = new HRemoteRegistry(config,
            targetIdFact_use_getTargetIdFactory) {

          @Override
          protected BClient createForwardClientToOtherServer(
              BTransport transport) throws BException {
            return HHttpServlet.this
                .createForwardClientToOtherServer(transport);
          }

          @Override
          protected BApiDescriptor getApiDescriptor() {
            return HHttpServlet.this.getApiDescriptor();
          }

        };

        activeMessages_use_getActiveMessages = new HActiveMessages(
            config.getTempDir());

        cleanupThread = new HCleanupResources(
            HSessionListener.getAllSessions(), HHttpServlet.this);

        initializationFinished();

        isInitialized.set(true);

      }
      catch (ServletException e) {
        log.error("Initialization failed.", e);
      }

    }


    private void initLogger(HConfig config) {

      String logLevel = config.getValue("bypshttp.log.level", null);

      if (logLevel != null) {
        LogConfigurator.setLevel(logLevel);

        if (log.isDebugEnabled()) log.debug("Logger opened.");
      }

    }
  }

  @Override
  public void destroy() {
    if (log.isDebugEnabled()) log.debug("done(");
    if (cleanupThread != null) {
      cleanupThread.done();
    }
    if (serverRegistry_use_getServerRegistry != null) {
      serverRegistry_use_getServerRegistry.done();
    }
    if (log.isDebugEnabled()) log.debug(")done");
  }
  
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Execute if REST call.
    // A REST call follows the URI format .../rest/interface-name/function-name.
    // BYPS-51
    if (isRestCall(request)) {
      doRest(request, response);
      return;
    }
    
    super.doDelete(request, response);
  }

  /**
   * Streams are sent by HTTP PUT.
   * 
   * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPut(");

    // Wird ein Stream gesendet?
    String messageIdStr = request.getParameter("messageid");
    String streamIdStr = request.getParameter("streamid");

    if (log.isDebugEnabled()) log.debug("messageId=" + messageIdStr
        + ", streamId=" + streamIdStr);

    if (messageIdStr != null && messageIdStr.length() != 0
        && streamIdStr != null && streamIdStr.length() != 0) {

      final long messageId = BBufferJson.parseLong(messageIdStr);
      final long streamId = BBufferJson.parseLong(streamIdStr);

      doPutStream(messageId, streamId, request, response);
    }
    else {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    if (log.isDebugEnabled()) log.debug(")put");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPost(");

    if (request.getParameter(BContentStream.URL_PARAM_UPLOAD_HANDLER) != null) {
      doHtmlUpload(request, response);
    }
    else if (request.getParameter("putstream") != null) {
      doPut(request, response);
    }
    // Execute if REST call.
    // A REST call follows the URI format .../rest/interface-name/function-name.
    // BYPS-50
    else if (isRestCall(request)) {
      doRest(request, response);
    }
    // If the URI is like .../rest/putstream, a stream should be uploaded.
    // BYPS-51
    else if (isRestUpload(request)) {
      doRestUpload(request, response);
    }
    else {
      doPostMessage(request, response);
    }
    if (log.isDebugEnabled()) log.debug(")doPost");
  }
  
  /**
   * Execute as REST call if request URI contains 'rest'.
   * BYPS-51
   * @param request Request
   * @param response Response
   */
  protected void doRest(HttpServletRequest request, HttpServletResponse response) {
    
    // Check for valid session.
    BMessageHeader header = null;
    HSession sess = getSessionFromMessageHeaderOrHttpRequest(header, request);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }
    
    // Execute REST call.
    HRestExecutor rest = createRestExecutor();
    rest.doRest(sess, request, response);
  }
  
  /**
   * Handle a stream upload for REST.
   * @param request
   * @param response
   * @throws IOException
   */
  protected void doRestUpload(HttpServletRequest request, HttpServletResponse response) {
    if (log.isDebugEnabled()) log.debug("doRestUpload(");
    
    // The request must include a valid session.
    BMessageHeader header = null;
    final HSession sess = getSessionFromMessageHeaderOrHttpRequest(header, request);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }
    
    HRestExecutor rest = createRestExecutor();
    rest.doRestUpload(sess, request, response);

    if (log.isDebugEnabled()) log.debug(")doRestUpload");
  }

  /**
   * Check whether the request is a REST call.
   * BYPS-50
   * @param request Request
   * @return true, if REST call
   */
  protected boolean isRestCall(HttpServletRequest request) {
    String requestUri = request.getRequestURI();
    return requestUri.contains("/rest")
        && !requestUri.contains("/rest/getstream")
        && !requestUri.contains("/rest/BUtility/upload");
  }
  
  /**
   * Check whether the request is a REST call that uploads a stream.
   * BYPS-50
   * @param request Request
   * @return true, if REST call
   */
  protected boolean isRestUpload(HttpServletRequest request) {
    String requestUri = request.getRequestURI();
    return requestUri.contains("/rest/BUtility/upload");
  }
  
  /**
   * Create helper object to execute REST calls.
   * @return {@link HRestExecutor}
   */
  protected HRestExecutor createRestExecutor() {
    return new HRestExecutor(getConfig(), getRestOperations(), getHtmlUploadMaxSize());
  }
  
  private void sendOutgoingStream(BContentStream is, HttpServletResponse response, HRangeRequest rangeRequest) throws IOException {
    if (log.isDebugEnabled()) log.debug("sendOutgoingStream(stream=" + is);

    OutputStream os = null;
    byte[] buf = new byte[HConstants.DEFAULT_BYTE_BUFFER_SIZE];
    int len = 0;
    final long BYTES_WRITTEN_GRANULARITY = 100*1000*1000;
    final long BYTES_WRITTEN_MB = 1000*1000;
    
    try {
      
      // Evaluate offset, length, etc.
      rangeRequest.evaluateByteRange(is);
      if (log.isDebugEnabled()) log.debug("rangeRequest=" + rangeRequest);
      
      // Position the stream to the given offset
      if (rangeRequest.isValid()) {
        is.position(rangeRequest.getOffset());
      }

      // Before setting headers, read the first bytes to return. 
      // This makes sure that the stream can be read before the response code is set to 200 or 206.
      // Furthermore, if the stream is a BContentStreamWrapper, it calls ensureStream() which initializes the stream properties (contentLength, ....)
      len = is.read(buf);
      
      // Always return Content-Type and Content-Disposition 
      final String contentType = is.getContentType();
      response.setContentType(contentType);

      final String contentDisposition = is.getContentDisposition();
      if (contentDisposition != null && contentDisposition.length() != 0) {
        response.setHeader("Content-Disposition", contentDisposition);
      }

      // Set headers Accept-Ranges, Content-Range, ETAG, Content-Length,...
      rangeRequest.setResponseHeaders(response);
      
      // Copy bytes to socket -------------
      long bytesWritten = 0;
      os = response.getOutputStream();
      while (len != -1) {
        
        // Browsers use to send a "Range: 123-" header only with an start offset but without an end offset. 
        // If the user e.g. changes the play position of a video, the browser resets the socket and 
        // requests the stream with another "Range: 234-" header again. 
        // Resetting the socket causes at this point (os.write) a 
        // "ClientAbortException:  java.net.SocketException: Connection reset by peer: socket write error"
        os.write(buf, 0, len);
        
        bytesWritten += len;
        if (log.isDebugEnabled()) {
          if (bytesWritten != 0 && (bytesWritten % BYTES_WRITTEN_GRANULARITY == 0)) {
            if (log.isDebugEnabled()) log.debug("bytesWritten=" + (bytesWritten / BYTES_WRITTEN_MB) + "MB");
          }
        }

        int bytesToRead = buf.length;
        if (rangeRequest.getLength() != -1) {
          bytesToRead = (int)Math.min(rangeRequest.getLength() - bytesWritten, buf.length);
        }
        
        if (bytesToRead == 0) break;
        len = is.read(buf, 0, bytesToRead);
      }

      if (log.isDebugEnabled()) {
        long totalMB = bytesWritten / BYTES_WRITTEN_MB;
        if (totalMB != 0) {
          if (log.isDebugEnabled()) log.debug("total bytesWritten=" + totalMB + "MB");
        }
      }

    }
    catch (BException e) {
      log.debug("Read stream failed", e);
      throw e;
    }
    catch (IOException e) {
      log.debug("Read stream failed", e);
      throw e;
    }
    catch (Throwable e) {
      log.debug("Read stream failed", e);
      throw new IOException("Read stream failed.", e);
    }
    finally {
      
      if (rangeRequest.isValid()) {
        // Keep the stream open until BContentStream.isExpired 
      }
      else {
        if (log.isDebugEnabled()) log.debug("close response of outgoing stream, stream=" + is);
        if (is != null) try {
          is.close();
        }
        catch (IOException ignored) {
        }
      }
      
      if (os != null) try {
        os.close();
      }
      catch (IOException ignored) {
      }
    }

    if (log.isDebugEnabled()) log.debug(")sendOutgoingStream");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doGet(");

    // Test adapter function?
    final String testAdapterStr = request.getParameter(HTestAdapter.KEY_PARAM);
    if (testAdapterStr != null && testAdapterStr.length() != 0) {
      doTestAdapter(request, response);
      if (log.isDebugEnabled()) log.debug(")doGet");
      return;
    }

    // Negotiate?
    final String negoStr = request.getParameter("negotiate");
    if (log.isDebugEnabled()) log.debug("negotiate=" + negoStr);
    if (negoStr != null && negoStr.length() != 0) {
      ByteBuffer ibuf = ByteBuffer.allocate(negoStr.length() * 3);
      ibuf.put(negoStr.getBytes("UTF-8"));
      ibuf.flip();
      doNegotiate(request, response, ibuf);
      return;
    }

    // Execute if REST call.
    // A REST call follows the URI format .../rest/interface-name/function-name.
    // BYPS-51
    if (isRestCall(request)) {
      doRest(request, response);
      return;
    }
    
    // Get stream or old utility request

    // Parameter messageid
    final String messageIdStr = request.getParameter("messageid");
    if (log.isDebugEnabled()) log.debug("messageId=" + messageIdStr);
    if (messageIdStr == null || messageIdStr.length() == 0) {
      // response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().println("HHttpServlet running.");
      return;
    }

    // Paremter streamid is set, if a stream is to be read
    final String streamIdStr = request.getParameter("streamid");
    if (log.isDebugEnabled()) log.debug("streamId=" + streamIdStr);

    // Parameter cancel is set, if the message given by messageid must be
    // canceled. For newer clients, this functionality is replaced by the
    // UtilityRequest interface.
    // To support older clients, it is still handled here.
    final String cancelStr = request.getParameter("cancel");
    if (log.isDebugEnabled()) log.debug("cancel=" + cancelStr);
    if (cancelStr != null && cancelStr.length() != 0) {

      final HSession sess = getSessionFromMessageHeaderOrHttpRequest(null,
          request);
      if (sess != null) {

        long messageId = BBufferJson.parseLong(messageIdStr);

        if (messageId == HWireClient.MESSAGEID_CANCEL_ALL_REQUESTS) {
          if (log.isDebugEnabled()) log.debug("activeMessages.cleanup");
          sess.wireServer.cancelAllMessages();
        }
        else if (messageId == HWireClient.MESSAGEID_DISCONNECT) {
          if (log.isDebugEnabled()) log.debug("sess.done");
          sess.done();
        }
        else {
          if (log.isDebugEnabled()) log.debug("activeMessages.cancelMessage");
          sess.wireServer.cancelMessage(messageId);
        }

      }

      response.setStatus(HttpServletResponse.SC_OK);
      response.getOutputStream().close();

    }

    // Read a stream
    else if (streamIdStr != null && streamIdStr.length() != 0) {
      if (log.isDebugEnabled()) log.debug("sendOutgoingStream");

      final String serverIdStr = request.getParameter("serverid");

      // Byte-Range request?
      // http://stackoverflow.com/questions/8293687/sample-http-range-request-session
      // Range: bytes=0-
      // Range: bytes=64312833-64657026

      final BContentStream stream = doGetStream(serverIdStr, messageIdStr, streamIdStr);

      HRangeRequest rangeRequest = new HRangeRequest(request);
      
      sendOutgoingStream(stream, response, rangeRequest);
    }

    // Bad request
    else {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getOutputStream().close();
    }

    if (log.isDebugEnabled()) log.debug(")doGet");
  }
  
  private BContentStream doGetStream(final String serverIdStr,
      final String messageIdStr, final String streamIdStr)
      throws RemoteException, IOException {
    final long messageId = BBufferJson.parseLong(messageIdStr);
    final long streamId = BBufferJson.parseLong(streamIdStr);
    final long trackingId = messageId;
    final int serverId = serverIdStr != null && serverIdStr.length() != 0 ? Integer
        .valueOf(serverIdStr) : getConfig().getMyServerId();

    final BServerRegistry serverRegistry = getServerRegistry();
    final BTargetId targetIdEncr = new BTargetId(serverId, messageId, streamId);
    final BTargetId targetId = serverRegistry.encryptTargetId(targetIdEncr,
        false);

    final BClient forwardClient = serverId != 0 ? serverRegistry
        .getForwardClientIfForeignTargetId(targetId) : null;

    final BContentStream stream = forwardClient != null ? forwardClient
        .getTransport().getWire().getStream(trackingId, targetId) : getActiveMessages()
        .getOutgoingStream(targetId);

    // Session verl�ngern. Wichtig f�r den Download sehr gro�er Dateien.
    final HActiveMessage msg = getActiveMessages().getActiveMessage(messageId);
    final String sessionId = msg != null ? msg.getSessionId() : null;
    final HSession sess = sessionId != null ? HSessionListener.getAllSessions()
        .get(sessionId) : null;
    if (sess != null) {
      sess.touch();
    }
    return stream;
  }

  protected void doPostMessage(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPostMessage(");

    if (log.isDebugEnabled()) {
      String contentType = request.getContentType();
      String contentLength = request.getHeader("Content-Length");
      log.debug("contentType=" + contentType + ", contentLength=" + contentLength);
    }

    InputStream is = request.getInputStream();
    ByteBuffer ibuf = BWire.bufferFromStream(is);

    if (log.isDebugEnabled()) {
      log.debug(BBuffer.toDetailString(ibuf));
    }

    doMessage(request, response, ibuf);

    if (log.isDebugEnabled()) log.debug(")doPostMessage");
  }

  protected HSession getSessionFromMessageHeaderOrHttpRequest(BMessageHeader header, HttpServletRequest request) {
    if (log.isDebugEnabled()) log.debug("getSessionFromMessageHeaderOrHttpRequest(");

    // Accept BYPS session only in conjunction with HTTP session.
    // The HTTP session is sent as cookie and can be declared as HttpOnly.
    // However, it is not sufficient to use only the HTTP session. The same HTTP session 
    // could be used by different clients: e.g. a Java client application with an integrated web view
    // so binary and JSON communication is used.
    // BYPS-19
    
    HttpSession httpSession = request.getSession();
    Optional<HSession> bypsSessionOpt = getBypsSessionFromHttpSession(httpSession, header);

    bypsSessionOpt.ifPresent(bypsSession -> {
      
      if (bypsSession.isExpired()) {
        if (log.isDebugEnabled()) log.debug("bypsSession is expired");
        bypsSession.done(); 
      }
      else {
        bypsSession.touch();
      }
      
    });
    
    return bypsSessionOpt.orElse(null);
  }

  public void doMessage(final HttpServletRequest request,
      final HttpServletResponse response, final ByteBuffer ibuf)
      throws IOException {
    if (log.isDebugEnabled()) log.debug("doMessage(");

    HRequestContext rctxt = null;

    try {
      // NDC.push(hsess.getId());

      if (log.isDebugEnabled()) log.debug("read header");
      final BMessageHeader header = new BMessageHeader();
      header.read(ibuf);

      // Get HSession.
      // Newer clients: header.sessionId
      // Older clients: request.getSession()
      final HSession sess = getSessionFromMessageHeaderOrHttpRequest(header,
          request);
      if (sess == null) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return;
      }

      final boolean isClientR = (header.flags & BMessageHeader.FLAG_LONGPOLL) != 0;

      if (log.isDebugEnabled()) log.debug("longpoll=" + isClientR);

      final BMessage msg = new BMessage(header, ibuf, null);

      if (isClientR) {
        rctxt = createRequestContext(request, response, true);

        long timeout = (header.flags & BMessageHeader.FLAG_TIMEOUT) != 0 ? (header.timeoutSeconds * 1000)
            : HConstants.TIMEOUT_LONGPOLL_MILLIS;
        if (log.isDebugEnabled()) log.debug("set timeout=" + timeout);
        rctxt.setTimeout(timeout);

        final BAsyncResult<BMessage> asyncResponse = sess.wireServer
            .addMessage(header, rctxt, null);

        // Message already canceled?
        if (asyncResponse != null) {
          sess.wireClientR.recvLongPoll(msg, asyncResponse);
        }

      }
      else {
        final HRequestContext rctxt2 = rctxt = createRequestContext(request, response, HConstants.PROCESS_MESSAGE_ASYNC);

        // Set request timeout.
        // If a timeout occurs, we return a BExceptionC#PROCESSING exception. The client will
        // sent a follow-up message (BMessageHeader.FLAG_POLL_PROCESSING) with the same message ID and the server will use its HRequestContext
        // to return the result to the client.
        final long timeout = (header.flags & BMessageHeader.FLAG_TIMEOUT) != 0 
            ? (header.timeoutSeconds * 1000) : getDefaultRequestProcessingTimeout();
        if (log.isDebugEnabled()) log.debug("set timeout=" + timeout);
        rctxt.setTimeout(timeout);
        
        final Runnable run = new Runnable() {
          public void run() {

            // Prepare message for execution.
            // Either a new HActiveMessage is created. 
            // Or, if this is a follow-up message (BMessageHeader#FLAG_POLL_PROCESSING) 
            // for a long running process, add the HRequestContext to an existing message.
            final BAsyncResult<BMessage> asyncResponse = sess.wireServer.addMessage(header, rctxt2, Thread.currentThread());

            // Nothing has to be done, if a message with header.messageId is already cancelled, 
            // finished or a follow-up message is received.
            if (asyncResponse == null) return;

            try {

              // ---------- execute Message ------------------
              final BServer server = sess.getServer();
              final BTransport transport = server.getTransport();

              if (HConstants.PROCESS_MESSAGE_ASYNC) {
                
                // Since 5.28, messages are always processed asynchronously to handle
                // long-running requests by messages with BMessageHeader#FLAG_POLL_PROCESSING
                // and BExceptionC#PROCESSING
                
                executeMessageInRequestContext(msg, rctxt2, asyncResponse, server, transport);
                
              }
              else {

                final BSyncResult<BMessage> syncResponse = new BSyncResult<BMessage>();

                executeMessageInRequestContext(msg, rctxt2, syncResponse, server, transport);

                if (log.isDebugEnabled()) log.debug("wait for result");
                try {
                  BMessage omsg = syncResponse.getResult(timeout);
                  if (log.isDebugEnabled()) log.debug("received result=" + omsg);
                  asyncResponse.setAsyncResult(omsg, null);
                }
                catch (Throwable e) {
                  if (log.isDebugEnabled()) log.debug("Failed to execute.", e);
                  asyncResponse.setAsyncResult(null, e);
                }
              }

            }
            catch (Throwable e) {
              if (log.isDebugEnabled()) log.debug("Failed to execute.", e);
              try {
                asyncResponse.setAsyncResult(null, e);
              }
              catch (Exception ignored) {
                // setAsyncResult might fail when it writes to the HttpServletResponse.
                // This happens e.g. in testRemoteStreamsThrowExceptionOnRead when all requests
                // are cancelled. The cancel method has already closed the HttpServletResponse objects.
              }
            }
            finally {

              getActiveMessages().removeWorker(header.messageId);

            }

          }
        };

        // Start request
        if (log.isDebugEnabled()) log.debug("start sync/async");
        rctxt.start(run);
      }

    }
    catch (Throwable e) {

      HttpServletResponse resp = rctxt != null ? (HttpServletResponse) rctxt.getResponse() : response;
      if (!resp.isCommitted()) {
        
        final String lineSeparator = System.getProperty("line.separator", "\n");
        StringBuilder headers = new StringBuilder();
        for (Enumeration<String> en = request.getHeaderNames(); en.hasMoreElements(); ) {
          String name = en.nextElement();
          headers.append(name).append(": ").append(request.getHeader(name)).append(lineSeparator);
        }
        
        String body = BBuffer.toDetailString(ibuf);
        
        log.warn("Failed to process message.", e);

        if (log.isInfoEnabled()) {
          log.info("remote-address={}, remote-host={}", request.getRemoteAddr(), request.getRemoteHost());
          log.info("Headers:{}{}", lineSeparator, headers);
          log.info("Body:{}{}", lineSeparator, body);
        }
        
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.getWriter().print(e.toString());
        resp.getWriter().close();
        if (rctxt != null) {
          rctxt.complete();
        }
      }
    }
    finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doMessage");
  }

  /**
   * Deserialize and execute message.
   * @param msg BMessage
   * @param requestContext HRequestContext
   * @param asyncResponse Response.
   * @param server BServer
   * @param transport BTransport
   */
  protected void executeMessageInRequestContext(final BMessage msg, final HRequestContext requestContext, final BAsyncResult<BMessage> asyncResponse,
      final BServer server, final BTransport transport) {
    HThreadRequestContext.set(requestContext);
    try {
      transport.recv(server, msg, asyncResponse);
    }
    finally {
      HThreadRequestContext.remove();
    }
  }

  private long getDefaultRequestProcessingTimeout() {
    return testAdapterRequestTimeoutMillis != 0 ? testAdapterRequestTimeoutMillis : HConstants.REQUEST_TIMEOUT_MILLIS;
  }

  protected void doNegotiate(final HttpServletRequest request,
      final HttpServletResponse response, final ByteBuffer ibuf)
      throws ServletException, BException {
    if (log.isDebugEnabled()) log.debug("doNegotiate(");

    // Initialization finished?
    if (!isInitialized.get()) {
      int httpStatus = HttpServletResponse.SC_SERVICE_UNAVAILABLE;
      if (log.isInfoEnabled()) log.info("HHttpServlet not initialized. Return "
          + httpStatus);
      response.setStatus(httpStatus);
      return;
    }

    final HSession sess = doCreateSession(request);

    // Process Negotiate message

    final HRequestContext rctxt = createRequestContext(request, response,
        HConstants.PROCESS_MESSAGE_ASYNC);

    final BAsyncResult<ByteBuffer> asyncResponse = new BAsyncResult<ByteBuffer>() {

      @Override
      public void setAsyncResult(ByteBuffer obuf, Throwable e) {
        if (log.isDebugEnabled()) log.debug("setAsyncResult(");
        final HttpServletResponse resp = (HttpServletResponse) rctxt
            .getResponse();
        try {
          if (e != null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(resp.getWriter());
          }
          else {
            resp.setContentType("application/json");
            OutputStream os = resp.getOutputStream();
            BWire.bufferToStream(obuf, false, os);
          }

        }
        catch (Throwable ex) {
          if (log.isInfoEnabled()) log.info("Failed to write negotiate result", e);
          try {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(resp.getWriter());
          }
          catch (IOException ignored) {
          }
        }
        finally {
          rctxt.complete();
        }
        if (log.isDebugEnabled()) log.debug(")setAsyncResult");
      }

    };

    final Runnable run = new Runnable() {
      public void run() {
        if (log.isDebugEnabled()) log.debug("run(");
        try {
          BServer server = sess.getServer();

          BProtocol protocol = server.negotiate(server.getTransport()
              .getTargetId(), ibuf, asyncResponse);

          // Teile dem Reverse-Client das ausgehandelte Protokoll mit.
          // Server und ClientR m�ssen dasselbe Protokoll verwenden, andernfalls
          // br�uchten sie separate Sessions

          BClient clientR = sess.getClientR();
          if (clientR != null) {
            if (log.isDebugEnabled()) log.debug("clientR=" + clientR
                + ", set negotiated protocol=" + protocol);
            clientR.getTransport().setProtocol(protocol);
          }

        }
        catch (Throwable e) {
          asyncResponse.setAsyncResult(null, e);
        }
        if (log.isDebugEnabled()) log.debug(")run");
      }
    };

    rctxt.start(run);
    if (log.isDebugEnabled()) log.debug(")doNegotiate");
  }

  protected HSession doCreateSession(final HttpServletRequest request)
      throws BException {
    // Create new JSESSIONID to support load balancing.
    // For newer clients, we do not rely on the JSESSIONID to identify the BYPS
    // session in incoming requests.
    // Otherwise two JSON connections in a browser window could not be
    // distinguished.
    // Older clients still need to reach their HSession by the JSESSIONID.
    HttpSession hsess = request.getSession(true);
    if (log.isDebugEnabled()) log.debug("JSESSIONID=" + hsess.getId());

    // Create new BYPS session
    final HTargetIdFactory targetIdFactory = getTargetIdFactory();
    final BTargetId targetId = targetIdFactory.createTargetId();
    final HSession sess = createSession(hsess, request.getRemoteUser());
    sess.setTargetId(targetId);
    if (log.isDebugEnabled()) log.debug("targetId=" + targetId);

    // Add session to session map
    final BHashMap<String, HSession> sessions = HSessionListener.getAllSessions();
    final String bsessionId = targetId.toSessionId();
    sessions.put(bsessionId, sess);

    // Add BRemote for utility requests.
    addUtilityRequestsInterface(sess);
    return sess;
  }

  protected HRequestContext createRequestContext(HttpServletRequest request,
      HttpServletResponse response, boolean async) {
    final HRequestContext rctxt = async ? new HAsyncContext(request.startAsync(
        request, response)) : new HSyncContext(request, response);
    return rctxt;
  }

  private void doPutStream(final long messageId, final long streamId,
      HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    if (log.isDebugEnabled()) log.debug("doPutStream(");

    try {
      // NDC.push(hsess.getId());

      if (log.isDebugEnabled()) log.debug("start async, timeout="
          + HConstants.REQUEST_TIMEOUT_MILLIS);

      final HRequestContext rctxt = createRequestContext(request, response,
          HConstants.PROCESS_PUT_STREAM_ASYNC);
      rctxt.setTimeout(HConstants.REQUEST_TIMEOUT_MILLIS);

      try {
        final BTargetId targetId = new BTargetId(getConfig().getMyServerId(),
            messageId, streamId);
        final HActiveMessage msg = getActiveMessages().addIncomingStream(
            targetId, rctxt);

        // Extend session lifetime to allow to upload large files.
        final String sessionId = msg.getSessionId();
        final HSession sess = sessionId != null ? HSessionListener
            .getAllSessions().get(sessionId) : null;
        if (sess != null) {
          sess.touch();
        }

      }
      catch (BException e) {
        if (log.isInfoEnabled()) log.info("putStream failed.", e);
        
        // BYPS-39: Avoid multiple completions of async request.
        if (!rctxt.isCompleted()) {
          int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
          if (e.code == BExceptionC.CANCELLED) {
            status = HttpServletResponse.SC_NOT_ACCEPTABLE;
          }
          ((HttpServletResponse) rctxt.getResponse()).setStatus(status);
          rctxt.complete();
        }
      }
    }
    finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doPutStream");
  }

  /**
   * This function helps to check the internal state of the server. This
   * function is for testing purposes only. The servlet init-parameter
   * testAdapterEnabled must be true in order to use this function.
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  protected void doTestAdapter(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    if (!getConfig().isTestAdapterEnabled()) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    final String testAdapter = request.getParameter(HTestAdapter.KEY_PARAM);
    if (testAdapter == null) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    }
    if (log.isDebugEnabled()) log.debug("check testAdapter=" + testAdapter);

    // Return the active messages.
    if (testAdapter.equals(HTestAdapter.ACTIVE_MESSAGES)) {

      String inclLongPollsStr = request
          .getParameter(HTestAdapter.INCL_LONG_POLLS);
      boolean inclLongPolls = (inclLongPollsStr != null && inclLongPollsStr
          .length() != 0) ? Boolean.parseBoolean(inclLongPollsStr) : true;

      List<Long> messageIds = getActiveMessages().getActiveMessageIds(
          inclLongPolls, Thread.currentThread());
      if (log.isDebugEnabled()) log.debug("active messageIds=" + messageIds);
      PrintWriter wr = response.getWriter();
      for (Long messageId : messageIds) {
        wr.println(messageId);
      }
      wr.close();
      return;
    }

    // Print a line into the servers log file.
    if (testAdapter.equals(HTestAdapter.PRINT_LOG)) {
      String line = request.getParameter(HTestAdapter.PRINT_LOG_LINE);
      log.info(line);
      return;
    }

    // Return the file names in the temporary directory.
    if (testAdapter.equals(HTestAdapter.TEMP_FILES)) {
      File[] files = getConfig().getTempDir().listFiles();
      PrintWriter wr = response.getWriter();
      for (File file : files) {
        wr.println(file.getName());
      }
      wr.close();
      
      // Delete all temp files
      for (File file : files) {
        file.delete();
      }

      return;
    }
    
    // Invalidate HTTP session
    // BYPS-33: negotiate have to be called after a 401 
    if (testAdapter.equals(HTestAdapter.INVALIDATE_HTTP_SESSION)) {
      HttpSession sess = request.getSession(false);
      if (sess != null) {
        sess.invalidate();
      }
      return;
    }

    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

  }

  protected void doHtmlUpload(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    if (log.isDebugEnabled()) log.debug("doHtmlUpload(");

    try {
      // NDC.push(hsess.getId());

      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      if (!isMultipart) {
        throw new IllegalStateException(
            "File upload must be sent as multipart/form-data.");
      }

      // Create a factory for disk-based file items
      DiskFileItemFactory factory = new DiskFileItemFactory(
          HConstants.INCOMING_STREAM_BUFFER, getConfig().getTempDir());

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);

      // Set overall request size constraint
      long maxSize = getHtmlUploadMaxSize();
      if (log.isDebugEnabled()) log
          .debug("set max upload file size=" + maxSize);
      upload.setSizeMax(maxSize);

      // Parse the request
      List<FileItem> items = upload.parseRequest(request);
      if (log.isDebugEnabled()) log.debug("received #items=" + items.size());

      ArrayList<HFileUploadItem> uploadItems = new ArrayList<HFileUploadItem>();
      for (FileItem item : items) {

        String fieldName = item.getFieldName();
        if (log.isDebugEnabled()) log.debug("fieldName=" + fieldName);
        String fileName = item.getName();
        if (log.isDebugEnabled()) log.debug("fileName=" + fileName);
        boolean formField = item.isFormField();
        if (log.isDebugEnabled()) log.debug("formField=" + formField);
        if (!formField && fileName.length() == 0) continue;
        long streamId = formField ? 0L
            : (System.currentTimeMillis() ^ ((((long) fileName.hashCode()) << 16L) | (long) System
                .identityHashCode(this))); // used as pseudo random number

        HFileUploadItem uploadItem = new HFileUploadItem(formField, fieldName,
            fileName, item.getContentType(), item.getSize(),
            Long.toString(streamId));
        uploadItems.add(uploadItem);
        if (log.isDebugEnabled()) log.debug("uploadItem=" + uploadItem);

        if (item.isFormField()) continue;

        final BTargetId targetId = new BTargetId(getConfig().getMyServerId(),
            0, streamId);
        getActiveMessages().addIncomingUploadStream(
            new HFileUploadIncomingStream(item, targetId, getConfig()
                .getTempDir()));

      }

      makeHtmlUploadResult(request, response, uploadItems);

    }
    catch (Throwable e) {
      if (!response.isCommitted()) {
        if (log.isInfoEnabled()) log.info("Failed to process message.", e);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print(e.toString());
        response.getWriter().close();
      }
    }
    finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doHtmlUpload");
  }

  protected void makeHtmlUploadResult(HttpServletRequest request,
      HttpServletResponse response, Collection<HFileUploadItem> items)
      throws IOException {
    response.setContentType("text/html");
    PrintWriter wr = response.getWriter();
    String uploadHandler = request.getParameter(BContentStream.URL_PARAM_UPLOAD_HANDLER);
    
    boolean wrapIntoHTML = uploadHandler != null && uploadHandler.equals(BContentStream.UPLOAD_HANDLER_HTML_FORM);
    if (wrapIntoHTML) {
      wr.print("<html><body>");
    }
    wr.print("[");
    boolean first = true;
    for (HFileUploadItem item : items) {
      if (first) first = !first;
      else wr.print(",");
      wr.print("\"");
      wr.print(item.streamId);
      wr.print("\"");
    }
    wr.print("]");
    if (wrapIntoHTML) {
      wr.print("</body></html>");
    }
    response.getWriter().close();
  }

  protected long getHtmlUploadMaxSize() {
    return -1L;
  }

  protected BClient createForwardClientToOtherServer(BTransport transport)
      throws BException {
    BClient clientR = null;
    BApiDescriptor apiDesc = getApiDescriptor();
    String clientClassName = apiDesc.basePackage + ".BClient_" + apiDesc.name;

    try {
      Class<?> clazz = Class.forName(clientClassName);
      Method m = clazz.getDeclaredMethod("createClientR", BTransport.class);
      clientR = (BClient) m.invoke(null, transport);
    }
    catch (Throwable e) {
      throw new BException(BExceptionC.INTERNAL,
          "Failed to create forward client", e);
    }

    return clientR;
  }

  @Override
  protected void service(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("service(");
    if (log.isDebugEnabled()) {
      log.debug("method=" + request.getMethod());
      log.debug("params= " + request.getParameterMap());
    }

    int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    Throwable ex = null;

    try {
      
      if (httpHeaderkeepAliveTimeout != null) {
        response.addHeader("Connection", "Keep-Alive");
        response.addHeader("Keep-Alive", "timeout=" + httpHeaderkeepAliveTimeout);
      }

      super.service(request, response);
      status = response.getStatus();

    }
    catch (FileNotFoundException e) {
      ex = e;
      status = HttpServletResponse.SC_NOT_FOUND;
      sendResponseErrorNoEx(response, status);
    }
    catch (Exception e) {
      ex = e;
      status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
      
      // Ignore error, if client has closed the connection.
      // Check as string to be able to run the code on Undertow.
      if (!e.toString().contains("ClientAbortException")) { 
        sendResponseErrorNoEx(response, status);
      }
    }
    finally {

      switch (status) {
      case HttpServletResponse.SC_OK:
      case BExceptionC.RESEND_LONG_POLL:
      case BExceptionC.UNAUTHORIZED:
      case BExceptionC.SESSION_CLOSED:
        if (log.isDebugEnabled()) log.debug(makeLogRequest(request, status));
        break;
      case BExceptionC.FORBIDDEN:
      case BExceptionC.TIMEOUT:
        if (log.isInfoEnabled()) log.info(makeLogRequest(request, status));
        break;
      default:
        if (log.isInfoEnabled()) log.info(makeLogRequest(request, status), ex);
        break;
      }
    }

    if (log.isDebugEnabled()) log.debug(")service");
  }

  private void sendResponseErrorNoEx(HttpServletResponse response, int status) {
    if (!response.isCommitted()) {
      try {
        response.sendError(status);
      }
      catch (Exception e2) {
        log.debug("response.sendError failed", e2);
      }
    }
  }

  private String makeLogRequest(HttpServletRequest request, int status) {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("Request: ").append(request.getMethod()).append(" ")
        .append(" ").append(request.getRequestURI()).append(" (");
    for (Enumeration<String> en = request.getParameterNames(); en
        .hasMoreElements();) {
      String paramName = en.nextElement();
      String[] paramValues = request.getParameterValues(paramName);
      sbuf.append(paramName).append("=").append(Arrays.toString(paramValues));
      if (en.hasMoreElements()) sbuf.append(", ");
    }
    sbuf.append(") = ").append(status);
    return sbuf.toString();
  }

  private void addUtilityRequestsInterface(final HSession sess) {
    BTransport transport = sess.getServer().getTransport();
    BApiDescriptor apiDesc = transport.getApiDesc();
    apiDesc.addRegistry(new BRegistry_BUtilityRequests());
    apiDesc.addRegistry(new JRegistry_BUtilityRequests());

    sess.getServer().addRemote(
        (int) BSkeleton_BUtilityRequests.serialVersionUID,
        new BSkeleton_BUtilityRequests() {

          @Override
          public Map<String, String> testAdapter(String functionName,
              Map<String, String> params) throws RemoteException {
            if (log.isDebugEnabled()) log.debug("testAdapter(" + functionName
                + ", " + params);

            Map<String, String> ret = new HashMap<String, String>();

            if (!getConfig().isTestAdapterEnabled()) {
              throw new BException(HttpServletResponse.SC_FORBIDDEN,
                  "testAdapter failed.");
            }

            // Return the active messages.
            if (functionName.equals(HTestAdapter.ACTIVE_MESSAGES)) {

              String inclLongPollsStr = params
                  .get(HTestAdapter.INCL_LONG_POLLS);
              boolean inclLongPolls = inclLongPollsStr != null ? Boolean
                  .parseBoolean(inclLongPollsStr) : false;

              getActiveMessages().cleanup(false);

              List<Long> messageIds = getActiveMessages().getActiveMessageIds(
                  inclLongPolls, Thread.currentThread());
              if (log.isDebugEnabled()) log.debug("active messageIds="
                  + messageIds);
              StringBuilder wr = new StringBuilder();
              for (Long messageId : messageIds) {
                wr.append(messageId).append("\r\n");
              }
              ret.put("return", wr.toString());
            }

            // Print a line into the servers log file.
            else if (functionName.equals(HTestAdapter.PRINT_LOG)) {
              String line = params.get(HTestAdapter.PRINT_LOG_LINE);
              log.info(line);
            }

            // Return the file names in the temporary directory.
            else if (functionName.equals(HTestAdapter.TEMP_FILES)) {
              File[] files = getConfig().getTempDir().listFiles();
              StringBuilder wr = new StringBuilder();
              for (File file : files) {
                // Skip e.g. .DS_Store file created by Mac Finder
                if (file.getName().startsWith(".")) continue;
                wr.append(file.getName()).append("\r\n");
              }
              ret.put("return", wr.toString());
              
              // Delete all temp files
              for (File file : files) {
                file.delete();
              }
            }
            
            else if (functionName.equals(HTestAdapter.TIMEOUT_FOR_PROCESSING)) {
              String timeoutSecondsStr = params.values().iterator().next();
              int timeoutSeconds = Integer.parseInt(timeoutSecondsStr);
              testAdapterRequestTimeoutMillis = (long)timeoutSeconds * 1000L;
            }

            if (log.isDebugEnabled()) log.debug(")testAdapter=" + ret);
            return ret;
          }

          @Override
          public Map<String, String> execute(String functionName,
              Map<String, String> params) throws RemoteException {
            return super.execute(functionName, params);
          }

          @Override
          public void cancelMessage(long messageId) throws RemoteException {
            if (log.isDebugEnabled()) log.debug("cancelMessage(" + messageId);
            if (messageId == HWireClient.MESSAGEID_CANCEL_ALL_REQUESTS) {
              if (log.isDebugEnabled()) log.debug("activeMessages.cleanup");
              sess.wireServer.cancelAllMessages();
            }
            else if (messageId == HWireClient.MESSAGEID_DISCONNECT) {
              if (log.isDebugEnabled()) log.debug("sess.done");
              sess.done();
            }
            else {
              if (log.isDebugEnabled()) log
                  .debug("activeMessages.cancelMessage");
              sess.wireServer.cancelMessage(messageId);
            }
            if (log.isDebugEnabled()) log.debug(")cancelMessage");
          }
        });
  }

  /**
   * Get BYPS session from application server's session. Old client
   * applications do not send the session ID in the BMessageHeader. For this
   * clients, the BYPS session is found in the application server's session.
   * 
   * @param httpSession Application server's session.
   * @param header BYPS message header.
   * @return BYPS session, or null
   */
  protected synchronized Optional<HSession> getBypsSessionFromHttpSession(HttpSession httpSession, BMessageHeader header) {
    if (log.isDebugEnabled()) log.debug("getBypsSessionFromHttpSession(request.session={}, header={}", httpSession, header);
    Optional<HSession> ret = Optional.empty();
    
    try {
      if (HConstants.HTTP_SESSION_COOKIE_REQUIRED
          || header == null) { // BYPS-28: NPE in Upload example of ELOix
        
        // BYPS-19: Obtain BYPS session from Tomcat session 
        HHttpSessionObject sessObj = (HHttpSessionObject) httpSession.getAttribute(HConstants.HTTP_SESSION_BYPS_SESSIONS);
        if (sessObj != null) {
          ret = header != null ? sessObj.getSession(header.sessionId) : sessObj.getFirstSession();
        }
        
      }
      else {
        
        // BYPS-26: Node.js does not supply a session cookie. 
        
        HSession bypsSession = HSessionListener.getAllSessions().get(header.sessionId);
        ret = Optional.ofNullable(bypsSession);
        
      }
      
      // Do not invalidate the HTTP session, if no BYPS session could be found.
      // Otherwise, IX manager page looses it's authentication objects.
    }
    catch (IllegalStateException e) {
      // HttpSession could be already invalidated.
      if (log.isDebugEnabled()) log.debug("HTTP session might be invalidated.", e);
    }
    
    if (log.isDebugEnabled()) log.debug(")getBypsSessionFromHttpSession={}", ret);
    return ret;
  }

  private static Logger log = LoggerFactory.getLogger(HHttpServlet.class);
  private volatile BServerRegistry serverRegistry_use_getServerRegistry;
  private volatile HTargetIdFactory targetIdFact_use_getTargetIdFactory;
  private volatile HActiveMessages activeMessages_use_getActiveMessages;
  private HCleanupResources cleanupThread;
  private AtomicBoolean isInitialized = new AtomicBoolean();
  private final Integer httpHeaderkeepAliveTimeout;
  private long testAdapterRequestTimeoutMillis;

  private final static HServerListener defaultListener = new HServerListener() {
    @Override
    public boolean onBeforeWriteHttpResponse(ByteBuffer obuf, Throwable e,
        HttpServletResponse resp, boolean isAsync) throws IOException {
      return false;
    }

    @Override
    public void onAfterWriteHttpResponse(int nbOfBytesWritten) {
    }
  };

}
