package byps.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import byps.BApiDescriptor;
import byps.BMessageHeader;
import byps.BRegistry;
import byps.BSyncResult;
import byps.BTransportFactory;
import byps.BWire;
import byps.RemoteException;
import byps.http.HTransportFactoryClient;
import byps.stdio.client.StdioClient;
import byps.stdio.client.StdioServer;
import byps.stdio.client.StdioServletRequest;
import byps.stdio.client.StdioServletResponse;
import byps.stdio.client.StdioWireClient;
import byps.stdio.common.SendChannel;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.BRegistry_Testser;

public class TestStdioRemote {

  private static class MyServlet implements StdioServer.MessageHandler {

    @Override
    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
      StdioServletRequest stdioRequest = (StdioServletRequest)httpRequest;
      StdioServletResponse stdioResponse = (StdioServletResponse)httpResponse;
      ByteBuffer bbufRequest = stdioRequest.getBypsRequest().getBody();
      String requestText = new String(bbufRequest.array(), bbufRequest.position(), bbufRequest.remaining());
      ByteBuffer result = ByteBuffer.wrap((requestText + " check!").getBytes());
      stdioResponse.getBypsResponse().setBody(result);
    }
    
  }

  @Test
  public void testServer() {
    StdioClient httpClient = null;
    StdioServer server = null;
    Process proc1 = null;
    Process proc2 = null;
    BClient_Testser client;
    try {
      proc1 = startEchoProgram();
      proc2 = startEchoProgram();
      
      MyServlet servlet = new MyServlet();
      server = new StdioServer(proc1.getInputStream(), proc2.getOutputStream(), servlet, 10);

      server.start();

      client = createClient(proc2.getInputStream(), proc1.getOutputStream());

      int nbOfRequests = 1;
      int nbOfThreads = 1;
      CountDownLatch cdl = new CountDownLatch(nbOfRequests);
      
      ThreadPoolExecutor tpool = (ThreadPoolExecutor)Executors.newFixedThreadPool(nbOfThreads);
      long t1 = System.currentTimeMillis();
      for (int i = 0; i < nbOfRequests; i++) {
        tpool.execute(() -> {
          try {
            client.getRemoteListTypes().getBoolean1();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
      }
      
      cdl.await(10, TimeUnit.SECONDS);

      long t2 = System.currentTimeMillis();
      System.out.println("ms=" + (t2-t1) + ", missing=" + cdl.getCount());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (httpClient != null) {
        httpClient.done();
      }
      if (server != null) {
        server.done();
      }
      if (proc1 != null) {
        terminateEchoProgram(proc1);
      }
      if (proc2 != null) {
        terminateEchoProgram(proc2);
      }
    }
  }

  private Process startEchoProgram() throws Exception {
    String javaHome = System.getProperty("java.home");
    File javaExe = new File(new File(javaHome, "bin"), "java.exe");
    ProcessBuilder pbuilder = new ProcessBuilder(
        javaExe.getAbsolutePath(),
        "-jar",
        "..\\bypshttp-shmem\\dist\\echo-program.jar");
//        "d:\\temp\\log\\byps-stdout.txt",
//        "d:\\temp\\log\\byps-stderr.txt");
    Process proc = pbuilder.start();
    if (proc.waitFor(1, TimeUnit.SECONDS)) {
      int ret = proc.exitValue();
      throw new IllegalStateException("Echo program terminated " + ret);
    }
    return proc;
  }
  
  private void terminateEchoProgram(Process proc) {
    if (proc == null) return;
    
    try {
      if (!proc.waitFor(1, TimeUnit.SECONDS)) {
        SendChannel client = new SendChannel(proc.getOutputStream());
        client.open();
        client.terminate();
        
        if (proc.waitFor(10, TimeUnit.SECONDS)) {
          int ret = proc.exitValue();
          if (ret != 0) {
            System.err.println("echo-program failed: " + ret);
          }
        }
        else {
          System.err.println("echo-program cannot be terminated");
        }
        
        client.close();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static BClient_Testser createClient(InputStream system_in, OutputStream system_out) throws RemoteException {
    return createClient(system_in, system_out, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, 1);
  }

  public static BClient_Testser createClient(InputStream system_in, OutputStream system_out, int flags, int bypsVersion, long appVersion, int nbOfReverseRequests) throws RemoteException {
    
    BRegistry registry = new BRegistry_Testser();
    
    System.setProperty("http.maxConnections", "100");
    
    // Define an API descriptor with an application version from static member appVersion.
    BApiDescriptor myDesc = new BApiDescriptor(
        BApiDescriptor_Testser.instance().name,
        BApiDescriptor_Testser.instance().basePackage,
        appVersion,
        BApiDescriptor_Testser.instance().uniqueObjects
        );
    
    myDesc.addRegistry(registry);

    BWire wire = new StdioWireClient(system_in, system_out, "", flags, 120, null);
    final BTransportFactory transportFactory = new HTransportFactoryClient(myDesc, wire, nbOfReverseRequests); 
    
    BClient_Testser client = BClient_Testser.createClient(transportFactory);

    BSyncResult<Boolean> syncResult = new BSyncResult<Boolean>();
    client.start(syncResult);
    
    syncResult.getResult();
    return client;
  }

}
