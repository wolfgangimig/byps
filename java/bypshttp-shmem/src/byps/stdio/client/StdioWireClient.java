package byps.stdio.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;

import byps.http.HWireClient;

public class StdioWireClient extends HWireClient {

  public StdioWireClient(InputStream system_in, OutputStream system_out, String url, int flags, int timeoutSeconds, Executor threadPool) {
    super(createStdioClient(system_in, system_out), url, flags, timeoutSeconds, threadPool);
  }

  private static StdioClient createStdioClient(InputStream system_in, OutputStream system_out) {
    StdioClient httpClient = new StdioClient(system_in, system_out);
    try {
      httpClient.start();
    } catch (Exception e) {
      throw new IllegalStateException("Cannot start StdioClient", e);
    }
    return httpClient;
  }

}
