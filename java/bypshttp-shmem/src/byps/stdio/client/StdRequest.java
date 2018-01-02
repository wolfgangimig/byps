package byps.stdio.client;

import java.nio.ByteBuffer;

import byps.BException;
import byps.BHttpRequest;
import byps.BInput;
import byps.BOutput;
import byps.BTransport;
import byps.http.client.HHttpRequest;

public class StdRequest implements HHttpRequest {
  
  protected int timeoutSeconds;
  protected String url;
  protected BTransport transport;
  
  public StdRequest(BTransport transport) {
    this("", transport);
  }

  public StdRequest(String url, BTransport transport) {
    this.url = url;
    this.transport = transport;
  }
  
  @Override
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds) {
    timeoutSeconds = Math.max(connectTimeoutSeconds, sendRecvTimeoutSeconds);
  }

  @Override
  public void cancel() {
  }

  @Override
  public boolean isCancelled() {
    return false;
  }
  
  @Override
  public void run() {
    // Must be implemented by subclass
    throw new UnsupportedOperationException();
  }

  protected BHttpRequest makeHttpRequest() {
    BHttpRequest request = new BHttpRequest();
    request.setUrl(url);
    return request;
  }
  
  protected BOutput getOutput() throws BException {
    BOutput bout = transport.getOutput();
    return bout;
  }

  protected static ByteBuffer serializeHttpRequest(BTransport transport, BHttpRequest request) throws BException {
    BOutput bout = transport.getOutput();
    bout.store(request);
    ByteBuffer msg = bout.toByteBuffer();
    return msg;
  }

  protected static BHttpRequest deserializeHttpRequest(BTransport transport, ByteBuffer bbuf) throws BException {
    BInput bin = transport.getInput(null, bbuf); // hier einen BMessageHeader übergeben?
    BHttpRequest response = (BHttpRequest)bin.load();
    return response;
  }
  
  

}
