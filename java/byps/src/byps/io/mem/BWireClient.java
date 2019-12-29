package byps.io.mem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BNegotiate;
import byps.BTargetId;
import byps.BWire;

public class BWireClient extends BWire {

  private BWireMemoryTransport wmt;

  public BWireClient(BWireMemoryTransport wmt) {
    super(BWire.FLAG_DEFAULT);
    this.wmt = wmt;
  }

  @Override
  public void send(final BMessage msg, final BAsyncResult<BMessage> asyncResult) {

    try {
      
      // Append message-ID to negotiate message since it is not 
      // contained in the message.
      ByteBuffer buf = msg.buf;
      if (BNegotiate.isNegotiateMessage(buf)) {
        buf.position(buf.limit());
        buf.limit(buf.capacity());
        buf.putLong(msg.header.messageId);
        buf.flip();
      }
    
      // Send message
      byte[] raw = new byte[buf.remaining()];
      buf.get(raw);
      wmt.putMessage(msg.header.messageId, raw);

      // Send streams
      if (msg.streams != null) {
        for (BContentStream istream : msg.streams) {
          final long messageId = istream.getTargetId().getMessageId();
          final long streamId = istream.getTargetId().getStreamId();
          wmt.putStream(messageId, streamId, istream);
        }
      }

      // Wait for response
      byte[] rawResponse = wmt.waitForResponse(msg.header.messageId);
      if (rawResponse != null && rawResponse.length != 0) {

        // Read response header
        buf = ByteBuffer.wrap(rawResponse);
        BMessageHeader header = new BMessageHeader();
        if (BNegotiate.isNegotiateMessage(buf)) {

          BNegotiate nego = new BNegotiate();
          nego.read(buf);

          header.messageObject = nego;
          header.messageId = msg.header.messageId;
        }
        else {
          header.read(buf);
        }
        
        BMessage responseMessage = new BMessage(header, buf, null);
        asyncResult.setAsyncResult(responseMessage, null);
      }
      else {
        asyncResult.setAsyncResult(null, null);
      }
      
    }
    catch (Throwable ex) {
      wmt.cancel(msg.header.messageId);
      asyncResult.setAsyncResult(null, ex);
    }
    
  }
  
  
  @Override
  public BContentStream getStream(long trackingId, BTargetId targetId) throws IOException {
    InputStream istream = null;
    try {
      istream = wmt.waitForStream(targetId.getMessageId(), targetId.getStreamId());
    }
    catch (InterruptedException e) {
      throw new IOException(e);
    }
    return ((BContentStream)istream);
  }
  
  @Override
  public void done() {
    wmt.done();
    super.done();
  }
}
