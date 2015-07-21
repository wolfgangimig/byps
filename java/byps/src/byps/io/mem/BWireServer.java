package byps.io.mem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import byps.BAsyncResult;
import byps.BBufferJson;
import byps.BContentStream;
import byps.BException;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BNegotiate;
import byps.BServer;
import byps.BTargetId;
import byps.BTransport;
import byps.BWire;

public class BWireServer extends BWire {

  private BWireMemoryTransport wmt;
  private BServer server;
  private ThreadPoolExecutor tpool;
  private volatile boolean stopped;
  private final static int THREAD_COUNT = 1;

  public BWireServer(BWireMemoryTransport wmt) {
    super(BWire.FLAG_DEFAULT);
    this.wmt = wmt;
    this.tpool = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_COUNT);
    
    for (int i = 0; i < THREAD_COUNT; i++) {
      tpool.execute(new Processor());
    }
  }
  
  public void setServer(BServer server) {
    this.server = server;
  }
  
  private class Processor implements Runnable {
    public void run() {
      
      try {
        while (!stopped) {

          try {
            byte[] raw = wmt.waitForMessage();
            
            // Read response header
            ByteBuffer buf = ByteBuffer.wrap(raw);
            final BMessageHeader header = new BMessageHeader();
            if (BNegotiate.isNegotiateMessage(buf)) {
  
              BNegotiate nego = new BNegotiate();
              nego.read(buf);
              
              // BNegotiate.read does not read the final ']' 
              BBufferJson bjson = new BBufferJson(buf);
              bjson.nextExpectedJsonChar(']', true);
  
              header.messageObject = nego;
              
              // Message-ID has been appended to the negotiate message.
              header.messageId = buf.getLong();
              
              buf.reset();
              try {
                server.negotiate(nego.targetId, buf, new BAsyncResult<ByteBuffer>() {

                  public void setAsyncResult(ByteBuffer result, Throwable exception) {
                    byte[] raw = new byte[result.remaining()];
                    result.get(raw);
                    wmt.putResponse(header.messageId, raw);
                  }
                  
                });
              }
              catch (Throwable e) {
                e.printStackTrace();
              }
              
            }
            else {
              header.read(buf);
              BMessage msg = new BMessage(header, buf, null);
              
              BTransport transport = server.getTransport();
              transport.recv(server, msg, new BAsyncResult<BMessage>() {
  
                public void setAsyncResult(BMessage result, Throwable exception) {
                  byte[] raw = new byte[result.buf.remaining()];
                  result.buf.get(raw);
                  wmt.putResponse(result.header.messageId, raw);
                }
              });
            }
            
          }
          catch (BException e) {
            if (stopped) break;
            e.printStackTrace();
          }
        }
      }
      catch (Exception e) {
      }
    }
  }    

  @Override
  public void send(final BMessage msg, final BAsyncResult<BMessage> asyncResult) {
    throw new UnsupportedOperationException();
  }

  @Override
  public BContentStream getStream(BTargetId targetId) throws IOException {
    InputStream istream = null;
    try {
      istream = wmt.waitForStream(targetId.getMessageId(),
          targetId.getStreamId());
    }
    catch (InterruptedException e) {
      throw new IOException(e);
    }
    return ((BContentStream) istream);
  }

  @Override
  public void done() {

    wmt.done();

    stopped = true;
    
    try {
      tpool.shutdown();
      tpool.awaitTermination(10, TimeUnit.SECONDS);
    }
    catch (InterruptedException e) {
    }
    
    super.done();
  }
}
