package byps.stdio.common;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class RecvChannel extends StdioChannel {
  
  private InputStream istream;
  private ReadableByteChannel ichannel;
  private boolean terminate;
  
  public RecvChannel(InputStream istream) {
    this.istream = istream;
  }
  
  public void open() throws Exception {
    ichannel = Channels.newChannel(istream);
  }
  
  public void close() {
    ichannel = null;
  }
  
  public ByteBuffer recv() throws Exception {
    
    messageHeader.clear();
    ichannel.read(messageHeader);
    messageHeader.flip();
    
    if (messageHeader.remaining() == 0) throw new Exception("Disconnected by peer.");
    
    int version = messageHeader.getInt();
    if (version != VERSION) throw new Exception("Version mismatch.");

    int method = messageHeader.getInt();

    int length = messageHeader.getInt();
    terminate = length < 0;
    
    int messageId = messageHeader.getInt();
        
    ByteBuffer msg = null;
    if (!terminate) {
      msg = ByteBuffer.allocate(length + 8); // + messageId + method
      msg.putInt(messageId);
      msg.putInt(method);
      while(msg.hasRemaining()) ichannel.read(msg);
      msg.flip();
    }
    return msg;
  }
  
  public boolean isTerminate() {
    return terminate;
  }
}
