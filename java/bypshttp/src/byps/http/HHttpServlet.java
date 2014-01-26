package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import byps.BApiDescriptor;
import byps.BAsyncResult;
import byps.BBuffer;
import byps.BBufferJson;
import byps.BClient;
import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BProtocol;
import byps.BServer;
import byps.BServerRegistry;
import byps.BSyncResult;
import byps.BTransport;
import byps.BWire;

public abstract class HHttpServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private HCleanupResources cleanupThread;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HHttpServlet() {
    if (log.isDebugEnabled()) log.debug("BHttpServlet()");
  }

  protected abstract HSession createSession(HttpServletRequest request, HttpServletResponse response, HttpSession hsess, BServerRegistry serverRegistry);

  protected abstract BClient createForwardClientToOtherServer(BTransport transport) throws BException;

  protected abstract BApiDescriptor getApiDescriptor();

  protected abstract HConfig getConfig();

  /**
   * This function is called after initialization has finished.
   */
  protected abstract void initializationFinished();

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

  private void initLogger(HConfig config) {

    String logLevel = config.getValue("bypshttp.log.level", "WARN");
    String logFile = config.getValue("bypshttp.log.file", null);

    if (logFile != null) {
      logFile = logFile.replace('/', File.separatorChar);

       Logger rootLogger = Logger.getRootLogger();
       Appender ap = rootLogger.getAppender("FI");
       if (ap != null) {
       FileAppender fap = (FileAppender) ap;
       fap.setFile(logFile);
       fap.activateOptions();
       }
      
       if (logLevel.equalsIgnoreCase("DEBUG"))
       rootLogger.setLevel(Level.DEBUG);
       if (logLevel.equalsIgnoreCase("INFO")) rootLogger.setLevel(Level.INFO);
       if (logLevel.equalsIgnoreCase("WARN")) rootLogger.setLevel(Level.WARN);
       if (logLevel.equalsIgnoreCase("ERROR"))
       rootLogger.setLevel(Level.ERROR);

      if (log.isDebugEnabled()) log.debug("Logger opened.");
    }

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

        serverRegistry = new HRemoteRegistry(config) {

          @Override
          protected BClient createForwardClientToOtherServer(BTransport transport) throws BException {
            return HHttpServlet.this.createForwardClientToOtherServer(transport);
          }

          @Override
          protected BApiDescriptor getApiDescriptor() {
            return HHttpServlet.this.getApiDescriptor();
          }

        };

        cleanupThread = new HCleanupResources(HSessionListener.getAllSessions());

        initializationFinished();

      } catch (ServletException e) {
        log.error("Initialization failed.", e);
      }

    }
  }

  @Override
  public void destroy() {
    if (log.isDebugEnabled()) log.debug("done(");
    if (cleanupThread != null) {
      cleanupThread.done();
    }
    if (log.isDebugEnabled()) log.debug(")done");
  }

  /**
   * Streams are sent by HTTP PUT.
   * 
   * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPut(");

    // Wird ein Stream gesendet?
    String messageIdStr = request.getParameter("messageid");
    String streamIdStr = request.getParameter("streamid");

    if (log.isDebugEnabled()) log.debug("messageId=" + messageIdStr + ", streamId=" + streamIdStr);

    if (messageIdStr != null && messageIdStr.length() != 0 && streamIdStr != null && streamIdStr.length() != 0) {

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
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPost(");

    if (request.getParameter("uploadHandler") != null) {
      doHtmlUpload(request, response);
    }
    else {
      doPostMessage(request, response);
    }
    if (log.isDebugEnabled()) log.debug(")doPost");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doGet(");

    final String testAdapterStr = request.getParameter(HTestAdapter.KEY_PARAM);
    if (testAdapterStr != null && testAdapterStr.length() != 0) {
      doTestAdapter(request, response);
      if (log.isDebugEnabled()) log.debug(")doGet");
      return;
    }

    final String negoStr = request.getParameter("negotiate");
    if (log.isDebugEnabled()) log.debug("negotiate=" + negoStr);
    if (negoStr != null && negoStr.length() != 0) {
      ByteBuffer ibuf = ByteBuffer.allocate(negoStr.length() * 3);
      ibuf.put(negoStr.getBytes("UTF-8"));
      ibuf.flip();
      doNegotiate(request, response, ibuf);
      return;
    }

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
    // canceled.
    final String cancelStr = request.getParameter("cancel");
    if (log.isDebugEnabled()) log.debug("cancel=" + cancelStr);

    final HSession sess = getSessionFromRequest(request, response, false);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    try {
      // NDC.push(hsess.getId());

      if (streamIdStr != null && streamIdStr.length() != 0) {
        if (log.isDebugEnabled()) log.debug("sendOutgoingStream");
        sess.wireServer.sendOutgoingStream(BBufferJson.parseLong(messageIdStr), BBufferJson.parseLong(streamIdStr), response);
      }
      else if (cancelStr != null && cancelStr.length() != 0) {

        long messageId = BBufferJson.parseLong(messageIdStr);

        if (messageId == HWireClient.MESSAGEID_CANCEL_ALL_REQUESTS) {
          if (log.isDebugEnabled()) log.debug("activeMessages.cleanup");
          sess.wireServer.activeMessages.cleanup(true);
        }
        else if (messageId == HWireClient.MESSAGEID_DISCONNECT) {
          if (log.isDebugEnabled()) log.debug("sess.done");
          sess.done();
        }
        else {
          if (log.isDebugEnabled()) log.debug("activeMessages.cancelMessage");
          sess.wireServer.activeMessages.cancelMessage(messageId);
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().close();

      }
      else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getOutputStream().close();
      }
    } catch (Throwable e) {
      log.error("GET failed, messageId=" + messageIdStr + ", streamId=" + streamIdStr + ", cancel=" + cancelStr, e);

      int status = HttpServletResponse.SC_BAD_REQUEST;
      if (e instanceof FileNotFoundException) {
        status = HttpServletResponse.SC_NOT_FOUND;
      }
      response.sendError(status, e.toString());
      // response.setHeader("Content-Length", "0");
      // response.getOutputStream().close();

    } finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doGet");
  }

  protected void doPostMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("doPostMessage(");

    if (log.isDebugEnabled()) log.debug("read message");
    String contentType = request.getContentType();
    String contentLength = request.getHeader("Content-Length");
    if (log.isDebugEnabled()) log.debug("contentType=" + contentType + ", contentLength=" + contentLength);

    InputStream is = request.getInputStream();
    ByteBuffer ibuf = BWire.bufferFromStream(is);

    if (log.isDebugEnabled()) {
      log.debug(BBuffer.toDetailString(ibuf));
    }

    doMessage(request, response, ibuf);

    if (log.isDebugEnabled()) log.debug(")doPostMessage");
  }

  protected void doMessage(final HttpServletRequest request, final HttpServletResponse response, final ByteBuffer ibuf) throws IOException {
    if (log.isDebugEnabled()) log.debug("doMessage(");

    HRequestContext rctxt = null;

    final HSession sess = getSessionFromRequest(request, response, false);
    if (log.isDebugEnabled()) log.debug("byps session=" + sess);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    try {
      // NDC.push(hsess.getId());

      if (log.isDebugEnabled()) log.debug("read header");
      final BMessageHeader header = new BMessageHeader();
      header.read(ibuf);

      final boolean isClientR = (header.flags & BMessageHeader.FLAG_RESPONSE) != 0;

      if (log.isDebugEnabled()) log.debug("longpoll=" + isClientR);

      final BMessage msg = new BMessage(header, ibuf, null);

      if (isClientR) {
        rctxt = createRequestContext(request, response, HConstants.PROCESS_LONGPOLL_ASYNC);
        final BAsyncResult<BMessage> asyncResponse = sess.wireServer.addMessage(header, rctxt, null);
        sess.wireClientR.recvLongPoll(msg, asyncResponse);
      }
      else {
        final HRequestContext rctxt2 = rctxt = createRequestContext(request, response, HConstants.PROCESS_MESSAGE_ASYNC);
        final Runnable run = new Runnable() {
          public void run() {

            final BAsyncResult<BMessage> asyncResponse = sess.wireServer.addMessage(header, rctxt2, Thread.currentThread());

            // Message already canceled?
            if (asyncResponse == null) return;

            try {
              if (HConstants.PROCESS_MESSAGE_ASYNC) {
                // NDC.push(hsess.getId());
              }

              // ---------- execute Message ------------------
              final BServer server = sess.getServer();
              final BTransport transport = server.transport;

              if (HConstants.PROCESS_MESSAGE_ASYNC) {
                transport.recv(server, msg, asyncResponse);
              }
              else {

                final BSyncResult<BMessage> syncResponse = new BSyncResult<BMessage>();

                transport.recv(server, msg, syncResponse);

                if (log.isDebugEnabled()) log.debug("wait for result");
                try {
                  BMessage omsg = syncResponse.getResult(HConstants.REQUEST_TIMEOUT_MILLIS);
                  if (log.isDebugEnabled()) log.debug("received result=" + omsg);
                  asyncResponse.setAsyncResult(omsg, null);
                } catch (Throwable e) {
                  if (log.isDebugEnabled()) log.debug("Failed to execute.", e);
                  asyncResponse.setAsyncResult(null, e);
                }
              }

            } catch (Throwable e) {
              if (log.isDebugEnabled()) log.debug("Failed to execute.", e);
              asyncResponse.setAsyncResult(null, e);
            } finally {

              sess.wireServer.activeMessages.removeWorker(header.messageId);

              if (HConstants.PROCESS_MESSAGE_ASYNC) {
                // NDC.pop();
              }
            }

          }
        };

        if (log.isDebugEnabled()) log.debug("start async");
        rctxt.start(run);
      }

    } catch (Throwable e) {
      if (log.isInfoEnabled()) log.info("Failed to process message.", e);
      HttpServletResponse resp = rctxt != null ? (HttpServletResponse) rctxt.getResponse() : response;
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      resp.getWriter().print(e.toString());
      resp.getWriter().close();
      if (rctxt != null) {
        rctxt.complete();
      }
    } finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doMessage");
  }

  protected void doNegotiate(final HttpServletRequest request, final HttpServletResponse response, final ByteBuffer ibuf) throws ServletException {
    if (log.isDebugEnabled()) log.debug("doNegotiate(");

    // Erstelle neue JSESSIONID für Lastverteilung

    final HSession sess = getSessionFromRequest(request, response, true);
    if (log.isDebugEnabled()) log.debug("byps session=" + sess);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    final HRequestContext rctxt = createRequestContext(request, response, HConstants.PROCESS_MESSAGE_ASYNC);

    final BAsyncResult<ByteBuffer> asyncResponse = new BAsyncResult<ByteBuffer>() {

      @Override
      public void setAsyncResult(ByteBuffer obuf, Throwable e) {
        if (log.isDebugEnabled()) log.debug("setAsyncResult(");
        final HttpServletResponse resp = (HttpServletResponse) rctxt.getResponse();
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

        } catch (Throwable ex) {
          if (log.isInfoEnabled()) log.info("Failed to write negotiate result", e);
          try {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(resp.getWriter());
          } catch (IOException ignored) {
          }
        } finally {
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

          BProtocol protocol = server.negotiate(server.transport.getTargetId(), ibuf, asyncResponse);

          // Teile dem Reverse-Client das ausgehandelte Protokoll mit.
          // Server und ClientR müssen dasselbe Protokoll verwenden, andernfalls
          // bräuchten sie separate Sessions

          BClient clientR = sess.getClientR();
          if (clientR != null) {
            if (log.isDebugEnabled()) log.debug("clientR=" + clientR + ", set negotiated protocol=" + protocol);
            clientR.getTransport().setProtocol(protocol);
          }

        } catch (Throwable e) {
          asyncResponse.setAsyncResult(null, e);
        }
        if (log.isDebugEnabled()) log.debug(")run");
      }
    };

    rctxt.start(run);
    if (log.isDebugEnabled()) log.debug(")doNegotiate");
  }

  private HRequestContext createRequestContext(HttpServletRequest request, HttpServletResponse response, boolean async) {
    final HRequestContext rctxt = async ? new HAsyncContext(request.startAsync(request, response)) : new HSyncContext(request, response);

    // Asynchronous requests are only used for reverse HTTP calls.
    // They are under control of the HWireClientR object of the session.
    // This object stores the request context in a map for the next reverse
    // request.
    // If no reverse request is made for a certain time (timeout time),
    // the HWireClientR object has to release the context.
    // Killing the context by a timeout would not remove it from
    // the HWireClientR object.
    // Thus, set the request timeout for Tomcat to a large value.
    // The request timeout for long-polls is HConstants.TIMEOUT_LONGPOLL_MILLIS
    // which should be
    // less than HConstants.REQUEST_TIMEOUT_MILLIS.

    rctxt.setTimeout(HConstants.REQUEST_TIMEOUT_MILLIS);

    return rctxt;
  }

  private void doPutStream(final long messageId, final long streamId, HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (log.isDebugEnabled()) log.debug("doPutStream(");

    final HSession sess = getSessionFromRequest(request, response, false);
    if (log.isDebugEnabled()) log.debug("byps session=" + sess);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    try {
      // NDC.push(hsess.getId());

      if (log.isDebugEnabled()) log.debug("start async, timeout=" + HConstants.REQUEST_TIMEOUT_MILLIS);

      final HRequestContext rctxt = createRequestContext(request, response, HConstants.PROCESS_PUT_STREAM_ASYNC);

      try {
        sess.wireServer.activeMessages.addIncomingStream(messageId, streamId, rctxt);
      } catch (BException e) {
        int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        if (e.code == BExceptionC.CANCELLED) {
          status = HttpServletResponse.SC_NOT_ACCEPTABLE;
        }
        ((HttpServletResponse) rctxt.getResponse()).setStatus(status);
        rctxt.complete();
      }
    } finally {
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
  protected void doTestAdapter(HttpServletRequest request, HttpServletResponse response) throws IOException {

    if (!getConfig().isTestAdapterEnabled()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    final HSession sess = getSessionFromRequest(request, response, false);
    if (log.isDebugEnabled()) log.debug("byps session=" + sess);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    final String testAdapter = request.getParameter(HTestAdapter.KEY_PARAM);
    if (testAdapter == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }
    if (log.isDebugEnabled()) log.debug("check testAdapter=" + testAdapter);

    // Return the active messages.
    if (testAdapter.equals(HTestAdapter.ACTIVE_MESSAGES)) {

      String inclLongPollsStr = request.getParameter(HTestAdapter.INCL_LONG_POLLS);
      boolean inclLongPolls = (inclLongPollsStr != null && inclLongPollsStr.length() != 0) ? Boolean.parseBoolean(inclLongPollsStr) : true;

      List<Long> messageIds = sess.wireServer.activeMessages.getActiveMessageIds(inclLongPolls);
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
      File[] files = sess.wireServer.getTempDir().listFiles();
      PrintWriter wr = response.getWriter();
      for (File file : files) {
        wr.println(file.getName());
      }
      wr.close();
    }

    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

  }

  private static class FileUploadItemIncomingStream extends BContentStreamWrapper {

    private final FileItem fileItem;
    private final long streamId;
    private final File tempDir;
    private InputStream is;

    FileUploadItemIncomingStream(FileItem fileItem, long streamId, File tempDir) throws IOException {
      super(null, fileItem.getContentType(), fileItem.getSize(), HConstants.REQUEST_TIMEOUT_MILLIS);
      this.fileItem = fileItem;
      this.streamId = streamId;
      this.tempDir = tempDir;
    }

    @Override
    protected synchronized InputStream openStream() throws IOException {
      return is = fileItem.getInputStream();
    }

    @Override
    public boolean isExpired() {
      boolean ex = super.isExpired();
      if (ex) {
        fileItem.delete();
      }
      return ex;
    }

    @Override
    public synchronized void close() throws IOException {
      if (is != null) {
        try {
          is.close();
        } catch (IOException ignored) {
        }
      }
      fileItem.delete();
    }

    @Override
    public synchronized BContentStream cloneInputStream() throws IOException {
      HIncomingStreamSync incomingStream = null;
      if (this.fileItem.isInMemory()) {
        incomingStream = new HIncomingStreamSync(fileItem.getContentType(), fileItem.getSize(), streamId, lifetimeMillis, tempDir);
        incomingStream.assignBytes(fileItem.get());
      }
      else {
        HTempFile tempFile = null;
        try {
          incomingStream = new HIncomingStreamSync(fileItem.getContentType(), fileItem.getSize(), streamId, lifetimeMillis, tempDir);
          tempFile = HTempFile.createTemp(tempDir, streamId);
          tempFile.getFile().delete(); // FileItem.write will move the file.
          fileItem.write(tempFile.getFile());
          incomingStream.assignFile(tempFile);
        } catch (IOException e) {
          throw e;
        } catch (Exception e) {
          throw new IOException(e);
        } finally {
          if (tempFile != null) {
            tempFile.release();
          }
        }
      }
      return incomingStream;
    }
  }

  protected void doHtmlUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Log log = LogFactory.getLog(HFileUploadItem.class);
    if (log.isDebugEnabled()) log.debug("doHtmlUpload(");

    final HSession sess = getSessionFromRequest(request, response, false);
    if (log.isDebugEnabled()) log.debug("byps session=" + sess);
    if (sess == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    try {
      // NDC.push(hsess.getId());

      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      if (!isMultipart) {
        throw new IllegalStateException("File upload must be sent as multipart/form-data.");
      }

      // Create a factory for disk-based file items
      DiskFileItemFactory factory = new DiskFileItemFactory(HConstants.INCOMING_STREAM_BUFFER, sess.wireServer.getTempDir());

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);

      // Set overall request size constraint
      long maxSize = getHtmlUploadMaxSize();
      if (log.isDebugEnabled()) log.debug("set max upload file size=" + maxSize);
      upload.setSizeMax(maxSize);

      // Parse the request
      @SuppressWarnings("unchecked")
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
        Long streamId = formField ? 0L : sess.wireServer.makeMessageId();

        HFileUploadItem uploadItem = new HFileUploadItem(formField, fieldName, fileName, item.getContentType(), item.getSize(), Long.toString(streamId));
        uploadItems.add(uploadItem);
        if (log.isDebugEnabled()) log.debug("uploadItem=" + uploadItem);

        if (item.isFormField()) continue;

        sess.wireServer.activeMessages.addIncomingStream(streamId.longValue(), new FileUploadItemIncomingStream(item, streamId, sess.wireServer.getTempDir()));

      }

      makeHtmlUploadResult(request, response, uploadItems);

    } catch (Throwable e) {
      if (log.isInfoEnabled()) log.info("Failed to process message.", e);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().print(e.toString());
      response.getWriter().close();
    } finally {
      // NDC.pop();
    }

    if (log.isDebugEnabled()) log.debug(")doHtmlUpload");
  }

  protected void makeHtmlUploadResult(HttpServletRequest request, HttpServletResponse response, Collection<HFileUploadItem> items) throws IOException {
    response.setContentType("text/html");
    PrintWriter wr = response.getWriter();
    wr.print("<html><body>[");
    boolean first = true;
    for (HFileUploadItem item : items) {
      if (first) first = !first;
      else
        wr.print(",");
      wr.print("\"");
      wr.print(item.streamId);
      wr.print("\"");
    }
    wr.print("]</body></html>");
    response.getWriter().close();
  }

  protected long getHtmlUploadMaxSize() {
    return -1L;
  }

  protected BServerRegistry getServerRegistry() {
    return serverRegistry;
  }

  protected HSession getSessionFromRequest(HttpServletRequest request, HttpServletResponse response, boolean createNewIfNotEx) {
    HSession sess = null;
    int httpStatus = HttpServletResponse.SC_UNAUTHORIZED;

    HttpSession hsess = request.getSession(false);
    if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
    if (hsess == null) {
      if (createNewIfNotEx) {
        hsess = request.getSession(true);
        if (log.isDebugEnabled()) log.debug("new http session=" + hsess.getId());
      }
    }

    if (hsess != null) {
      try {
        sess = (HSession) hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
        if (log.isDebugEnabled()) log.debug("byps session=" + sess);
        if (sess == null) {

          if (createNewIfNotEx) {

            HTargetIdFactory targetIdFactory = getTargetIdFactory();

            // Initialized?
            if (log.isDebugEnabled()) log.debug("targetIdFactory=" + targetIdFactory);
            if (targetIdFactory != null) {
              sess = createSession(request, response, hsess, serverRegistry);
              if (log.isDebugEnabled()) log.debug("new byps session=" + sess);

              sess.setTargetId(targetIdFactory.createTargetId());

              HSessionListener.attachBSession(hsess, sess);
            }
            else {
              if (log.isInfoEnabled()) log.info("Service unavailable or still initializing.");
              httpStatus = HttpServletResponse.SC_SERVICE_UNAVAILABLE;
            }
          }
        }
      } catch (Exception e) {
        log.info("Cannot get/create session", e);
      }
    }

    if (sess == null) {
      response.setStatus(httpStatus);
    }

    return sess;
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (log.isDebugEnabled()) log.debug("service(");
    if (log.isDebugEnabled()) {
      log.debug("method=" + request.getMethod());
      log.debug("params= " + request.getParameterMap());
    }
    try {

      super.service(request, response);

      int status = response.getStatus();
      if (status != HttpServletResponse.SC_OK) {
        if (log.isDebugEnabled()) log.debug("Request failed with HTTP status " + status);
      }

    } catch (ServletException e) {
      if (log.isDebugEnabled()) log.debug("Request failed with exception.", e);
      throw e;
    } catch (IOException e) {
      if (log.isDebugEnabled()) log.debug("Request failed with exception.", e);
      throw e;
    } catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("Request failed with exception.", e);
      throw new ServletException(e);
    }
    if (log.isDebugEnabled()) log.debug(")service");
  }

  private Log log = LogFactory.getLog(HHttpServlet.class);
  private volatile BServerRegistry serverRegistry;
  private volatile HTargetIdFactory targetIdFact_use_getTargetIdFactory;

}
