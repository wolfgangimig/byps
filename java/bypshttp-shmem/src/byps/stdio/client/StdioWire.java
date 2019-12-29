package byps.stdio.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BMessage;
import byps.BWire;
import byps.stdio.common.StdioChannel;

public class StdioWire extends BWire {

  StdioClient client;
  
  public StdioWire(InputStream system_in, OutputStream system_out, int flags) {
    super(flags);
    client = new StdioClient(system_in, system_out);
  }

  @Override
  public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    client.send(StdioChannel.HTTP_POST, msg.buf, new BAsyncResult<ByteBuffer>() {
      public void setAsyncResult(ByteBuffer result, Throwable exception) {
      }
    });
  }
  
}
