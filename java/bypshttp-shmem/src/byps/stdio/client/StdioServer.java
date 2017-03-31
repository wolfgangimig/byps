package byps.stdio.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import byps.BAsyncResult;
import byps.BHttpRequest;
import byps.BOutput;
import byps.BTransport;

public class StdioServer extends StdioCommunication {
  
  private final MessageHandler handler;
  private final Executor tpool;
  private final BTransport transport;
  private final Random rand = new Random();
  private final ArrayList<RequestContext> requestContexts;
  
  public StdioServer(String programPath, MessageHandler handler, int maxThreads) {
    super(programPath);
    this.handler = handler;
    this.tpool = ensureExecutor(maxThreads);
    this.requestContexts = createRequestContexts(maxThreads);
    this.transport = StdioTransport.createTransport();
  }
  
  public StdioServer(InputStream system_in, OutputStream system_out, MessageHandler handler, int maxThreads) {
    super(system_in, system_out);
    this.handler = handler;
    this.tpool = ensureExecutor(maxThreads);
    this.requestContexts = createRequestContexts(maxThreads);
    this.transport = StdioTransport.createTransport();
  }
  
  @Override
  public void done() {
    ((ThreadPoolExecutor)this.tpool).shutdown();
    super.done();
  }

  public static interface MessageHandler {
    public void handle(HttpServletRequest request, HttpServletResponse response);
  }
  
  @Override
  protected void handleException(Throwable e) {
    // FIXME
    e.printStackTrace();
  }
  
  private synchronized RequestContext allocateRequestContext(int messageId, int method, BHttpRequest httpRequest) {
    
    while (requestContexts.isEmpty()) {
      if (stopEvent) throw new IllegalStateException("Server already shut down.");
      try {
        wait(1000);
      } catch (InterruptedException e) {
        throw new IllegalStateException("Server interrupted.");
      }
    }
    
    RequestContext ctxt = requestContexts.remove(requestContexts.size()-1);
    
    ctxt.asyncResult.init(this, messageId, method);

    // Wrap request object into a HttpServletRequest compatible object.
    ctxt.servletRequest.init(method, httpRequest);

    // Wrap response object into a HttpServletRespnose compatible object.
    ctxt.servletResponse.init(ctxt.asyncResult);
    
    return ctxt;
  }
  
  private synchronized void freeRequestContext(RequestContext ctxt) {
    requestContexts.add(ctxt);
    notifyAll();
  }
  
  private static class AsyncMessageResult implements BAsyncResult<BHttpRequest> {
    private StdioServer server;
    private int method;
    private int messageId;
    
    void init(StdioServer server, int messageId, int method) {
      this.server = server;
      this.messageId = messageId;
      this.method = method;
    }
    
    public void setAsyncResult(BHttpRequest httpResponse, Throwable exception) {
        try {
          ByteBuffer response = null;
          if (exception != null) {
            BOutput bout = server.transport.getOutput();
            bout.setException(exception);
            response = bout.toByteBuffer();
          }
          else {
            response = StdRequest.serializeHttpRequest(server.transport, httpResponse);
          }
          server.sendChannel.send(method, messageId, response);
      } catch (Throwable e) {
        server.handleException(e);
      }
    }
  }

  protected void handleReceivedMessageAsync(int messageId, int method, ByteBuffer request) {
    
    RequestContext ctxt = null; 
    
    try {
      BHttpRequest httpRequest = StdRequest.deserializeHttpRequest(transport, request);
      
      ctxt = allocateRequestContext(messageId, method, httpRequest);
      
      // Process request
      handler.handle(ctxt.servletRequest, ctxt.servletResponse);
      
      // Make sure the StdioServletOutputStream is closed an the OnSendResponse is fired.
      ctxt.servletResponse.getOutputStream().close();
  
    } catch (Exception e) {
      
      if (ctxt == null) {
        ctxt = allocateRequestContext(messageId, method, new BHttpRequest());
      }
      
      ctxt.asyncResult.setAsyncResult(null, e);
    }
    finally {
      freeRequestContext(ctxt);
    }
  }
  
  @Override
  protected void handleReceivedMessage(int messageId, int method, ByteBuffer request) {
    while (!Thread.currentThread().isInterrupted() && !stopEvent) {
      try {
        tpool.execute(() -> {
          handleReceivedMessageAsync(messageId, method, request);
        });
        
        break;
      }
      catch (RejectedExecutionException e) {
        // FIXME
        System.out.println("rejected, retry");
        synchronized(this) {
          try {
            this.wait(1 + rand.nextInt(20));
          }
          catch (InterruptedException e1) {
            break;
          }
        }
      }
    }
  }

  private final static AtomicInteger threadCount = new AtomicInteger(0);
  private static Executor ensureExecutor(int maxThreads) {
    ThreadPoolExecutor tpool = (ThreadPoolExecutor)Executors.newFixedThreadPool(maxThreads, new ThreadFactory() {
      public Thread newThread(Runnable arg0) {
        return new Thread(arg0, "stdex-" + threadCount.incrementAndGet());
      }
    });
    //cachedPool.setMaximumPoolSize(maxThreads);
    return tpool;
  }
  
  private static class RequestContext {
    final StdioServletRequest servletRequest = new StdioServletRequest();
    final StdioServletResponse servletResponse = new StdioServletResponse();
    final AsyncMessageResult asyncResult = new AsyncMessageResult();
  }
  
  private static ArrayList<RequestContext> createRequestContexts(int maxThreads) {
    ArrayList<RequestContext> arr = new ArrayList<RequestContext>(maxThreads);
    for (int i = 0; i < maxThreads; i++) {
      RequestContext ctxt = new RequestContext();
      arr.add(ctxt);
    }
    return arr;
  }

}
