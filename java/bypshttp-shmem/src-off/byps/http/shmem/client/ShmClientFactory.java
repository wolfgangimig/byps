package byps.http.shmem.client;

import java.io.File;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

public class ShmClientFactory implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String fileName) {
    File clientMessageFile = new File(fileName + ".client");
    File serverMessageFile = new File(fileName + ".server");
    return new ShmClient(clientMessageFile, serverMessageFile);
  }

}
