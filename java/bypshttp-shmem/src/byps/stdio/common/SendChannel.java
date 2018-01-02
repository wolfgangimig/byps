package byps.stdio.common;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

public class SendChannel extends StdioChannel {
  
  private OutputStream ostream;
  private WritableByteChannel ochannel;
  
  public SendChannel(OutputStream ostream) {
    this.ostream = ostream;
  }
  
  public void open() throws Exception {
    ochannel = Channels.newChannel(ostream);
  }
  
  public void close() {
    ochannel = null;
  }
  
  private void header_unsync(int method, int messageId, int length) throws Exception {
    messageHeader.clear();
    messageHeader.putInt(VERSION);
    messageHeader.putInt(method);
    messageHeader.putInt(length);
    messageHeader.putInt(messageId);
    messageHeader.flip();
    ochannel.write(messageHeader);
  }
  
  public synchronized void send(int method, int messageId, ByteBuffer msg) throws Exception {
    header_unsync(method, messageId, msg.remaining());
    ochannel.write(msg);
    ostream.flush();
  }
  
  public synchronized void terminate() throws Exception {
    header_unsync(HTTP_GET, 0, -1);
    ostream.flush();
  }
}
