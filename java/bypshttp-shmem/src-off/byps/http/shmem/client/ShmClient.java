package byps.http.shmem.client;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class ShmClient implements HHttpClient {
  
  public ShmClient(File clientMessageFile, File serverMessageFile) {
    
  }

  @Override
  public void done() {
    // TODO Auto-generated method stub

  }

  @Override
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest getStream(String url, BAsyncResult<BContentStream> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void clearHttpSession() {
    // TODO Auto-generated method stub

  }

}
