package com.wilutions.byps.http;

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
import org.apache.log4j.NDC;

import com.wilutions.byps.BAsyncResult;
import com.wilutions.byps.BBuffer;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BContentStreamWrapper;
import com.wilutions.byps.BException;
import com.wilutions.byps.BMessage;
import com.wilutions.byps.BMessageHeader;
import com.wilutions.byps.BNegotiate;
import com.wilutions.byps.BProtocol;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.BRemoteRegistry;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BSyncResult;
import com.wilutions.byps.BTargetId;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BWire;

public abstract class HHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HCleanupResources cleanupThread; 
	
	protected boolean testAdapterEnabled = false;
	
     /**
     * @see HttpServlet#HttpServlet()
     */
    public HHttpServlet() {
    	if (log.isDebugEnabled()) log.debug("BHttpServlet()");
    	
    	stubRegistry = new BRemoteRegistry() {

			@Override
			public BRemote getRemote(BTargetId targetId, int remoteId) throws BException {
				if (log.isDebugEnabled()) log.debug("getRemote(targetId=" + targetId + ", remoteId=" + remoteId);

				// Check 
				int serverId = getTargetIdFactory().getServerId(targetId); 
				if (serverId != 1) {
					throw new BException(BException.CLIENT_DIED, "Cannot reach server for targetId=" + targetId); 
				}
				
				// Get client session
				HSession sess = HSession.getSession(targetId);
				if (sess == null) {
					throw new BException(BException.CLIENT_DIED, "Client is not connected, targetId=" + targetId); 
				}
				
				BRemote remote = sess.getClientR().getStub(remoteId);
				if (log.isDebugEnabled()) log.debug(")getRemote=" + remote);
				return remote;
			}
    		
    	};
    	
    	targetIdFact_use_getTargetIdFactory = new HTargetIdFactory(1);
    	
    	cleanupThread = new HCleanupResources(HSessionListener.getAllSessions());
    }
    
    
    protected abstract HSession createSession(HttpServletRequest request, HttpServletResponse response, HttpSession hsess, BRemoteRegistry stubRegistry);
    
    protected HTargetIdFactory getTargetIdFactory() {
    	return targetIdFact_use_getTargetIdFactory;
    }
    
    @Override
    public void init() throws ServletException {
		if (log.isDebugEnabled()) log.debug("init(");
    	super.init();
    	
    	ServletConfig config = getServletConfig();
    	String testAdapterEnabledStr = config.getInitParameter("testAdapterEnabled");
    	testAdapterEnabled = testAdapterEnabledStr != null && Boolean.parseBoolean(testAdapterEnabledStr);
    	
 		if (log.isDebugEnabled()) log.debug(")init");
   }
    
    @Override
    public void destroy() {
		if (log.isDebugEnabled()) log.debug("done(");
    	cleanupThread.done();
		if (log.isDebugEnabled()) log.debug(")done");
    }
    
 	/**
 	 * Streams are sent by HTTP PUT.
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (log.isDebugEnabled()) log.debug("doPut(");

		// Wird ein Stream gesendet?
		String messageIdStr = request.getParameter("messageid");
		String streamIdStr = request.getParameter("streamid");
		
		if (log.isDebugEnabled()) log.debug("messageId=" + messageIdStr + ", streamId=" + streamIdStr);
		
        if (messageIdStr != null && messageIdStr.length() != 0 && 
        	streamIdStr != null && streamIdStr.length() != 0) {
        	
    		final long messageId = Long.parseLong(messageIdStr);
        	final long streamId = Long.parseLong(streamIdStr);

        	doPutStream(messageId, streamId, request, response);
        	
        	return;
        }

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        
		if (log.isDebugEnabled()) log.debug(")put");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (log.isDebugEnabled()) log.debug("doGet(");
		
		final String testAdapterStr = request.getParameter(HTestAdapter.KEY_PARAM);
		if (testAdapterStr != null && testAdapterStr.length() != 0) {
			doTestAdapter(request, response);
			if (log.isDebugEnabled()) log.debug(")doGet");
			return;
		}
		
		final String messageIdStr = request.getParameter("messageid");
		if (log.isDebugEnabled()) log.debug("messageId=" + messageIdStr);
		if (messageIdStr == null || messageIdStr.length() == 0) {
           	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}
		
		// Paremter streamid is set, if a stream is to be read
		final String streamIdStr = request.getParameter("streamid");
		if (log.isDebugEnabled()) log.debug("streamId=" + streamIdStr);
		
		// Parameter cancel is set, if the message given by messageid must be canceled.
		final String cancelStr = request.getParameter("cancel");
		if (log.isDebugEnabled()) log.debug("cancel=" + cancelStr);

		final HttpSession hsess = request.getSession(false);
		if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
		if (hsess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			return;
		}
		
		final HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
		if (log.isDebugEnabled()) log.debug("byps session=" + sess);
		if (sess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
        try {
        	NDC.push(hsess.getId());
        
            if (streamIdStr != null && streamIdStr.length() != 0) {
            	if (log.isDebugEnabled()) log.debug("sendOutgoingStream");
				sess.wireServer.sendOutgoingStream(
						Long.parseLong(messageIdStr), 
						Long.parseLong(streamIdStr), response);
            }
            else if (cancelStr != null && cancelStr.length() != 0) {
            	
            	// If messageId==-1 the client is about to disconnect. 
            	
            	if (messageIdStr.equals("-1")) {
                	if (log.isDebugEnabled()) log.debug("activeMessages.cleanup");
            		sess.wireServer.activeMessages.cleanup(true);
            	}
            	else if (messageIdStr.equals("-2")) {
                	if (log.isDebugEnabled()) log.debug("sess.done");
            		sess.done();
            	}
            	else {
                	if (log.isDebugEnabled()) log.debug("activeMessages.cancelMessage");
            		sess.wireServer.activeMessages.cancelMessage(Long.parseLong(messageIdStr));
            	}
            	response.setStatus(HttpServletResponse.SC_OK);
            	response.getOutputStream().close();
            	
            }
            else {
            	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            	response.getOutputStream().close();
           }
        }
    	catch (Throwable e) {
    		log.error("GET failed, messageId=" + messageIdStr + ", streamId=" + streamIdStr + ", cancel=" + cancelStr, e);
    		int status = HttpServletResponse.SC_BAD_REQUEST;
    		if (e instanceof FileNotFoundException) {
    			status = HttpServletResponse.SC_NOT_FOUND;
    		}
           	response.setStatus(status);
        	response.getOutputStream().close();
    	}
        finally {
        	NDC.pop();
        	NDC.remove();
        }
      	
		if (log.isDebugEnabled()) log.debug(")doGet");
	}

	protected void doPostMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (log.isDebugEnabled()) log.debug("doPostMessage(");
		
		if (log.isDebugEnabled()) log.debug("read message");
        InputStream is = request.getInputStream();
        ByteBuffer ibuf = BWire.bufferFromStream(is);
        
        if (log.isDebugEnabled()) {
        	log.debug(BBuffer.toDetailString(ibuf));
        }

        boolean isNego = BNegotiate.isNegotiateMessage(ibuf);
        if (log.isDebugEnabled()) log.debug("isNeotiateMessage=" + isNego);
  
		if (log.isDebugEnabled()) log.debug("startAsync, timeout=" + HConstants.REQUEST_TIMEOUT_MILLIS);
		
        if (isNego) {
    	    doNegotiate(request, response, ibuf);
        }
        else {
           	doMessage(request, response, ibuf);
        }

		if (log.isDebugEnabled()) log.debug(")doPostMessage");
 	}
	
	protected void doMessage(final HttpServletRequest request, final HttpServletResponse response, final ByteBuffer ibuf) throws IOException {
   		if (log.isDebugEnabled()) log.debug("doMessage(");
   		
		HRequestContext rctxt = null;
		
		final HttpSession hsess = request.getSession(false);
		if (hsess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			return;
		}
   		if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
		
		try {
			NDC.push(hsess.getId());
			
			final HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
	   		if (log.isDebugEnabled()) log.debug("byps session=" + sess);
			if (sess == null) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

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
				   		
				   		final BSyncResult<BMessage> syncResponse = HConstants.PROCESS_MESSAGE_ASYNC ? null : new BSyncResult<BMessage>();
				   		
			    		try {
			    			if (HConstants.PROCESS_MESSAGE_ASYNC) NDC.push(hsess.getId());
			    			
			    			// ---------- execute Message ------------------
							final BServer server = sess.getServer();
							final BTransport transport = server.transport;
							transport.recv(server, msg, HConstants.PROCESS_MESSAGE_ASYNC ? asyncResponse : syncResponse);
							
				    		if (syncResponse != null) {
				    			if (log.isDebugEnabled()) log.debug("wait for result");
				    			try {
									BMessage omsg = syncResponse.getResult(HConstants.REQUEST_TIMEOUT_MILLIS);
									if (log.isDebugEnabled()) log.debug("received result=" + omsg);
									asyncResponse.setAsyncResult(omsg, null);
								} catch (Throwable e) {
									if (log.isDebugEnabled()) log.debug("wait for result failed:", e);
									asyncResponse.setAsyncResult(null, e);
								}
				    		}

						} catch (Throwable e) {
					    	if (log.isDebugEnabled()) log.debug("Failed to execute.", e);
							asyncResponse.setAsyncResult(null, e);
						}
			    		finally {
			    			
			    			sess.wireServer.activeMessages.removeWorker(header.messageId);
			    			
			    			if (HConstants.PROCESS_MESSAGE_ASYNC) {
			    				NDC.pop();
			    				NDC.remove();
			    			}
			    			
			    		}
			    		
			    	}
			    };
		    
		    	if (log.isDebugEnabled()) log.debug("start async");
			    rctxt.start(run);
		    }
		    
		}
		catch (Throwable e) {
	    	if (log.isWarnEnabled()) log.warn("Failed to process message.", e);
			HttpServletResponse resp = (HttpServletResponse)rctxt.getResponse();
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().print(e.toString());
			resp.getWriter().close();
			rctxt.complete();
		}
		finally {
			NDC.pop();
			NDC.remove();
		}

   		if (log.isDebugEnabled()) log.debug(")doMessage");
	}

	protected void doNegotiate(final HttpServletRequest request, final HttpServletResponse response, final ByteBuffer ibuf) throws ServletException {
    	if (log.isDebugEnabled()) log.debug("doNegotiate(");

		final HRequestContext rctxt = createRequestContext(request, response, HConstants.PROCESS_MESSAGE_ASYNC);

		// Erstelle neue JSESSIONID f�r Lastverteilung
		
		final HttpServletRequest req = (HttpServletRequest)rctxt.getRequest();
		if (req.isRequestedSessionIdValid()) {
			HttpSession hsess = req.getSession();
			if (log.isInfoEnabled()) log.info("Negotiate message received for active HTTP session=" + (hsess != null ? hsess.getId() : null) +", session has to be invalidated now.");
			req.getSession().invalidate();
		}
		
		final HttpSession hsess = req.getSession(true);
    	if (log.isDebugEnabled()) log.debug("new http session=" + hsess.getId());

		final HSession sess = createSession(request, response, hsess, stubRegistry);
    	if (log.isDebugEnabled()) log.debug("new byps session=" + sess);
    	if (sess == null) return;

    	sess.setTargetId(getTargetIdFactory().createTargetId());
    	
    	HSessionListener.attachBSession(hsess, sess);
    	
        final BAsyncResult<ByteBuffer> asyncResponse = new BAsyncResult<ByteBuffer>() {

			@Override
			public void setAsyncResult(ByteBuffer obuf, Throwable e) {
				if (log.isDebugEnabled()) log.debug("setAsyncResult(");
				final HttpServletResponse resp = (HttpServletResponse)rctxt.getResponse();
				try {
					if (e != null) {
						resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
						resp.getWriter().print(e.toString());
					}
					else {
						resp.setContentType("application/json");
						OutputStream os = resp.getOutputStream();
						sess.wireServer.bufferToStream(obuf, os);
					}
					
				} catch (Throwable ex) {
					if (log.isWarnEnabled()) log.warn("Failed to write negotiate result", e);
					try {
						resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
						resp.getWriter().print(e.toString());
					} catch (IOException ignored) {
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

					BProtocol protocol = server.negotiate(server.transport.getTargetId(), ibuf, asyncResponse);
					
					// Teile dem Reverse-Client das ausgehandelte Protokoll mit.
					// Server und ClientR m�ssen dasselbe Protokoll verwenden, andernfalls
					// br�uchten sie separate Sessions
					
					BClient clientR = sess.getClientR();
					if (clientR != null) {
			       		if (log.isDebugEnabled()) log.debug("clientR=" + clientR + ", set negotiated protocol=" + protocol);
						clientR.transport.setProtocol(protocol);
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
		final HRequestContext rctxt = async ? 
			new HAsyncContext(request.startAsync(request, response)) :
			new HSyncContext(request, response);
		rctxt.setTimeout(HConstants.REQUEST_TIMEOUT_MILLIS);
		return rctxt;
	}
	
	private void doPutStream(final long messageId, final long streamId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (log.isDebugEnabled()) log.debug("doPutStream(");

		final HttpSession hsess = request.getSession(false);
		if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
		if (hsess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			return;
		}
		
		final HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
		if (log.isDebugEnabled()) log.debug("byps session=" + sess);
		if (sess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		try {
			NDC.push(hsess.getId());
			
			if (log.isDebugEnabled()) log.debug("start async, timeout=" + HConstants.REQUEST_TIMEOUT_MILLIS);
			
			final HRequestContext rctxt = createRequestContext(request, response, HConstants.PROCESS_PUT_STREAM_ASYNC); 
					
	        try {
	        	sess.wireServer.activeMessages.addIncomingStream(messageId, streamId, rctxt);
	        }
	        catch (BException e) {
	        	int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	        	if (e.code == BException.CANCELED) {
	        		status = HttpServletResponse.SC_NOT_ACCEPTABLE;
	        	}
        		((HttpServletResponse)rctxt.getResponse()).setStatus(status);
        		rctxt.complete();
	        }
		}
		finally {
			NDC.pop();
			NDC.remove();
		}
		
		if (log.isDebugEnabled()) log.debug(")doPutStream");
 	}
	
	/**
	 * This function helps to check the internal state of the server.
	 * This function is for testing purposes only. The servlet init-parameter
	 * testAdapterEnabled must be true in order to use this function. 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	protected void doTestAdapter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (!testAdapterEnabled) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		final HttpSession hsess = request.getSession(false);
		if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
		if (hsess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			return;
		}
		
		final HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
		if (log.isDebugEnabled()) log.debug("byps session=" + sess);
		if (sess == null) {
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
		if (testAdapter.equals(HTestAdapter.TEMP_FILES)){
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
				} 
				catch (IOException ignored) { }
			}
			fileItem.delete();
		}
		
		@Override
		public synchronized BContentStream cloneInputStream() throws IOException {
			HIncomingStreamSync incomingStream = null;
			if (this.fileItem.isInMemory()) {
				incomingStream = new HIncomingStreamSync(
						fileItem.getContentType(), 
						fileItem.getSize(),
						streamId,
						lifetimeMillis,
						tempDir);
				incomingStream.assignBytes(fileItem.get());
			}
			else {
				HTempFile tempFile = null;
				try {
					incomingStream = new HIncomingStreamSync(
							fileItem.getContentType(), 
							fileItem.getSize(),
							streamId,
							lifetimeMillis,
							tempDir);
					tempFile = HTempFile.createTemp(tempDir, streamId);
					tempFile.getFile().delete(); // FileItem.write will move the file.
					fileItem.write(tempFile.getFile());
					incomingStream.assignFile(tempFile);
				} catch (IOException e) {
					throw e;
				} catch (Exception e) {
					throw new IOException(e);
				}
				finally {
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
		
		final HttpSession hsess = request.getSession(false);
		if (hsess == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
			return;
		}
   		if (log.isDebugEnabled()) log.debug("http session=" + (hsess != null ? hsess.getId() : null));
		
		try {
			NDC.push(hsess.getId());
			
			final HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
	   		if (log.isDebugEnabled()) log.debug("byps session=" + sess);
			if (sess == null) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

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

				HFileUploadItem uploadItem = new HFileUploadItem(formField, 
						fieldName, 
						fileName, 
						item.getContentType(), 
						item.getSize(), 
						Long.toString(streamId));
				uploadItems.add(uploadItem);
				if (log.isDebugEnabled()) log.debug("uploadItem=" + uploadItem);
				
				if (item.isFormField()) continue;
			    
			    sess.wireServer.activeMessages.addIncomingStream(streamId.longValue(), 
			    		new FileUploadItemIncomingStream(item, streamId, sess.wireServer.getTempDir()));
			    
			}
			
			makeHtmlUploadResult(hsess, request, response, uploadItems);

		}
		catch (Throwable e) {
	    	if (log.isWarnEnabled()) log.warn("Failed to process message.", e);
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	response.getWriter().print(e.toString());
	    	response.getWriter().close();
		}
		finally {
			NDC.pop();
			NDC.remove();
		}

		if (log.isDebugEnabled()) log.debug(")doHtmlUpload");
	}

	protected void makeHtmlUploadResult(HttpSession hsess, HttpServletRequest request, HttpServletResponse response, Collection<HFileUploadItem> items) throws IOException {
		response.setContentType("text/html");
		PrintWriter wr = response.getWriter();
		wr.print("<html><body>[");
		boolean first = true;
		for (HFileUploadItem item : items) {
			if (first) first = !first; else wr.print(",");
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
	
	private final Log log = LogFactory.getLog(HHttpServlet.class);
	private final BRemoteRegistry stubRegistry;
	private final HTargetIdFactory targetIdFact_use_getTargetIdFactory;
}