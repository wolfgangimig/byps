package byps.stdio.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
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
  
  public StdioServer(String programPath, MessageHandler handler, int maxThreads) {
    super(programPath);
    this.handler = handler;
    this.tpool = ensureExecutor(maxThreads);
    this.transport = StdioTransport.createTransport();
  }
  
  public StdioServer(InputStream system_in, OutputStream system_out, MessageHandler handler, int maxThreads) {
    super(system_in, system_out);
    this.handler = handler;
    this.tpool = ensureExecutor(maxThreads);
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
  
  private static class AsyncMessageResult implements BAsyncResult<BHttpRequest> {
    private final StdioServer server;
    private final int method;
    private final int messageId;
    
    AsyncMessageResult(StdioServer server, int messageId, int method) {
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

    AsyncMessageResult asyncResult = new AsyncMessageResult(this, messageId, method);
    
    try {
      BHttpRequest httpRequest = StdRequest.deserializeHttpRequest(transport, request);
      
      // Wrap request object into a HttpServletRequest compatible object.
      StdioServletRequest servletRequest = new StdioServletRequest(method, httpRequest);

      // Wrap response object into a HttpServletRespnose compatible object.
      StdioServletResponse servletResponse = new StdioServletResponse(asyncResult);
      
      // Process request
      handler.handle(servletRequest, servletResponse);
      
      // Make sure the StdioServletOutputStream is closed an the OnSendResponse is fired.
      servletResponse.getOutputStream().close();
  
    } catch (Exception e) {
      
      asyncResult.setAsyncResult(null, e);
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
  
}
