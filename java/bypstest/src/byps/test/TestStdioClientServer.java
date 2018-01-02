package byps.test;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import byps.BInput;
import byps.BOutput;
import byps.BSyncResult;
import byps.http.client.HHttpRequest;
import byps.stdio.client.StdioClient;
import byps.stdio.client.StdioServer;
import byps.stdio.client.StdioServletRequest;
import byps.stdio.client.StdioServletResponse;
import byps.stdio.common.SendChannel;
import byps.test.api.remote.BRequest_RemoteListTypes_getBoolean1;

public class TestStdioClientServer {

  @Test
  public void testClient() {
    StdioClient client = new StdioClient(".\\dist\\echo-program.jar");
    try {
      client.start();
      CountDownLatch cdl = new CountDownLatch(1);
      
      ByteBuffer request = ByteBuffer.wrap("requesttext".getBytes());
      
      HHttpRequest httpRequest = client.post("abc-url", request, (result, ex) -> {
        if (ex != null) {
          ex.printStackTrace();
        }
        else {
          String s = new String(result.array(), result.position(), result.remaining());
          System.out.println("result=" + s);
        }
        cdl.countDown();
      });
      
      httpRequest.run();
      
      cdl.await(10, TimeUnit.SECONDS);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      client.done();
      System.out.println("ok");
    }
  }
  
  private static class MyServlet implements StdioServer.MessageHandler {

    @Override
    public void service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
      StdioServletRequest stdioRequest = (StdioServletRequest)httpRequest;
      StdioServletResponse stdioResponse = (StdioServletResponse)httpResponse;
      ByteBuffer bbufRequest = stdioRequest.getBypsRequest().getBody();
      String requestText = new String(bbufRequest.array(), bbufRequest.position(), bbufRequest.remaining());
      ByteBuffer result = ByteBuffer.wrap((requestText + " check!").getBytes());
      stdioResponse.getBypsResponse().setBody(result);
    }

    @Override
    public void doMessage(HttpServletRequest request, HttpServletResponse response, ByteBuffer ibuf) {
      throw new UnsupportedOperationException();
    }
    
  }

  @Test
  public void testServer() {
    StdioClient client = null;
    StdioServer server = null;
    Process proc1 = null;
    Process proc2 = null;
    
    int nbOfRequests = 1000*1000;
    int nbOfThreads = 10;

    ThreadPoolExecutor tpool2 = (ThreadPoolExecutor)Executors.newFixedThreadPool(nbOfThreads);
    try {
      
      proc1 = startEchoProgram();
      proc2 = startEchoProgram();
      
      client = new StdioClient(proc2.getInputStream(), proc1.getOutputStream());
      
      MyServlet servlet = new MyServlet();
      server = new StdioServer(proc1.getInputStream(), proc2.getOutputStream(), servlet, 10);
      
      client.start();
      server.start();
      
      CountDownLatch cdl = new CountDownLatch(nbOfRequests);
      
      long t1 = System.currentTimeMillis();
      for (int i = 0; i < nbOfRequests; i++) {

        BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();    
        BOutput bout = client.transport.getOutput();
        bout.store(req);
        ByteBuffer request = bout.toByteBuffer();

        final BSyncResult<java.util.List<java.lang.Boolean>> asyncResult = new BSyncResult<java.util.List<java.lang.Boolean>>();    
        final StdioClient fclient = client;
        
        //ByteBuffer request = ByteBuffer.wrap("heydu".getBytes());
        HHttpRequest httpRequest = client.post("abc-url", request, (result, ex) -> {
          if (ex != null) {
            ex.printStackTrace();
          }
          else {
            //String s = new String(result.array(), result.position(), result.remaining());
            //System.out.println("result=" + s);
            
            try {
              BInput bin = fclient.transport.getInput(null, result);
              java.util.List<java.lang.Boolean> list = (java.util.List<java.lang.Boolean>)bin.load();
              System.out.println("list=" + list);
            } catch (Exception e) {
              e.printStackTrace();
            }
            
            
          }
          cdl.countDown();
        });
        tpool2.execute(httpRequest);
      }
      
      cdl.await(1000, TimeUnit.SECONDS);

      long t2 = System.currentTimeMillis();
      System.out.println("ms=" + (t2-t1) + ", missing=" + cdl.getCount());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (client != null) {
        client.done();
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
      if (tpool2 != null) {
        tpool2.shutdownNow();
      }
    }
  }

  private Process startEchoProgram() throws Exception {
    String javaHome = System.getProperty("java.home");
    File javaExe = new File(new File(javaHome, "bin"), "java.exe");
    ProcessBuilder pbuilder = new ProcessBuilder(
        javaExe.getAbsolutePath(),
        "-jar",
        ".\\dist\\echo-program.jar");
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
  
}
