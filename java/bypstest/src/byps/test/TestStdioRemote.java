package byps.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.Servlet;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BApiDescriptor;
import byps.BAsyncResult;
import byps.BMessageHeader;
import byps.BRegistry;
import byps.BSyncResult;
import byps.BTransportFactory;
import byps.BWire;
import byps.RemoteException;
import byps.http.HHttpServlet;
import byps.http.HSession;
import byps.http.HTransportFactoryClient;
import byps.http.client.HHttpRequest;
import byps.stdio.client.StdioClient;
import byps.stdio.client.StdioServer;
import byps.stdio.client.StdioServlet;
import byps.stdio.client.StdioWireClient;
import byps.stdio.common.SendChannel;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.BRegistry_Testser;
import byps.test.servlet.BypsServlet;
import byps.test.servlet.MySession;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.InstanceHandle;

/**
 * Compare execution performance of HTTP communication to STDIO communication to in-process communication.
 *
 */
public class TestStdioRemote {

  /**
   * Execute JAR task of bypshttp-shmem (resp. main project bypstest-srv) to get this program:
   */
  private final static String ECHO_PROGRAM_JAR = "../bypshttp-shmem/build/libs/bypshttp-shmem-all.jar";

  private final static Logger log = LoggerFactory.getLogger(TestStdioRemote.class);
  private volatile Undertow server;
  private CountDownLatch serverStopped = new CountDownLatch(1);
  private Servlet bypsServlet; 

  @Before
  public void setUp() {
    try {
      startHttpServer(false);
    } catch (Exception e) {
      log.error("Failed to start server", e);
      TestUtils.assertTrue(log, "Failed to start server", false);
    }
  }
  
  @After
  public void tearDown() {
    stopHttpServer();
  }
  
  /**
   * The test {@link #testStdioCommunication()} requires a helper program
   * that echos the stdin data to stdout. 
   * Make sure, that this program works.
   */
  @Test
  public void testClient() {
    StdioClient client = new StdioClient(ECHO_PROGRAM_JAR);
    try {
      client.start();
      final CountDownLatch cdl = new CountDownLatch(1);
      
      ByteBuffer request = ByteBuffer.wrap("requesttext".getBytes());
      
      HHttpRequest httpRequest = client.post(3, "abc-url", request, new BAsyncResult<ByteBuffer>() {
        public void setAsyncResult(ByteBuffer result, Throwable ex){
          if (ex != null) {
            ex.printStackTrace();
          }
          else {
            String s = new String(result.array(), result.position(), result.remaining());
            System.out.println("result=" + s);
          }
          cdl.countDown();
        }
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
  

  /**
   * In-process communication.
   * Client and server communicate via PipedIn/OutputStreams.
   */
  @Test
  public void testPipeCommunicationInProcess() {
    StdioClient httpClient = null;
    StdioServer server = null;
    BClient_Testser client;
    Map<String, String> servletParams = new HashMap<>();
    HHttpServlet stdioServlet = new StdioBypsServlet(servletParams);
    try {
      stdioServlet.init();
      
      int bufferSize = 100000;
      PipedOutputStream pipe1_out = new PipedOutputStream();
      PipedInputStream pipe1_in = new PipedInputStream(pipe1_out, bufferSize);

      PipedOutputStream pipe2_out = new PipedOutputStream();
      PipedInputStream pipe2_in = new PipedInputStream(pipe2_out, bufferSize);

      server = new StdioServer(pipe1_in, pipe2_out, stdioServlet, 10);

      server.start();

      client = createClient(pipe2_in, pipe1_out);

      int nbOfRequests = 100000;
      int nbOfThreads = 1;
      invokeMethod(client, nbOfRequests, nbOfThreads);
      
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
    }
  }
  
  private static class StdioBypsServlet extends StdioServlet {
    private static final long serialVersionUID = 529332757773852251L;

    public StdioBypsServlet(Map<String, String> parameters) {
      super(parameters);
    }

    @Override
    protected HSession createSession(HttpSession hsess, String remoteUser) {
      if (log.isDebugEnabled()) log.debug("createSession(");
      if (log.isDebugEnabled()) log.debug("remoteUser=" + remoteUser);
      
      HSession sess = new MySession(hsess, remoteUser, this);
      if (log.isDebugEnabled()) log.debug(")createSession=" + sess);
      return sess;
    }

    @Override
    protected BApiDescriptor getApiDescriptor() {
      return BApiDescriptor_Testser.instance();
    }
    
    
  }

  /**
   * Test communication via STDIO.
   * 
   */
  @Test
  public void testStdioCommunication() {
    StdioServer stdioServer = null;
    Process proc1 = null;
    Process proc2 = null;
    BClient_Testser client = null;
    
    Map<String, String> servletParams = new HashMap<>();
    HHttpServlet stdioServlet = new StdioBypsServlet(servletParams);
    try {
      stdioServlet.init();
      
      // Start helper programs that echo their stdin to stdout.
      // This programs allows to have the client side and server side in this test.
      proc1 = startEchoProgram();
      proc2 = startEchoProgram();
      
      // Server side reads from proc1 and writes to proc2.
      stdioServer = new StdioServer(proc1.getInputStream(), proc2.getOutputStream(), stdioServlet, 10);

      stdioServer.start();

      // Client side reads from proc2 and writes to proc1.
      client = createClient(proc2.getInputStream(), proc1.getOutputStream());

//      client.getRemoteListTypes().setBoolean1(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
//      List<Boolean> list = client.getRemoteListTypes().getBoolean1();
//      System.out.println("list=" + list);

      int nbOfRequests = 10;
      int nbOfThreads = 10;
      invokeMethod(client, nbOfRequests, nbOfThreads);
      
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (client != null) {
        client.done();
      }
      if (stdioServer != null) {
        stdioServer.done();
      }
      if (proc1 != null) {
        terminateEchoProgram(proc1);
      }
      if (proc2 != null) {
        terminateEchoProgram(proc2);
      }
    }
  }

  
  /**
   * Test communication via TCP.
   */
  @Test
  public void testTcpCommunication() {
    BClient_Testser client = null;
    try {
      int nbOfRequests = 100000;
      int nbOfThreads = 10;
      
      client = TestUtilsHttp.createClient();
      invokeMethod(client, nbOfRequests, nbOfThreads);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (client != null) {
        client.done();
      }
    }
  }


  private void invokeMethod(final BClient_Testser client, int nbOfRequests, int nbOfThreads) throws InterruptedException {
    final CountDownLatch cdl = new CountDownLatch(nbOfRequests);
    ThreadPoolExecutor tpool = (ThreadPoolExecutor)Executors.newFixedThreadPool(nbOfThreads);
    long t1 = System.currentTimeMillis();
    for (int i = 0; i < nbOfRequests; i++) {
      tpool.execute(new Runnable() {
        public void run() {
          try {
            client.getRemoteListTypes().setBoolean1(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
            List<Boolean> list = client.getRemoteListTypes().getBoolean1();
            if (cdl.getCount() == 1) System.out.println("list=" + list);
          } catch (Exception e) {
            e.printStackTrace();
          }
          finally {
            cdl.countDown();
          }
        }
      });
    }
    
    cdl.await(100, TimeUnit.SECONDS);

    long t2 = System.currentTimeMillis();
    System.out.println("ms=" + (t2-t1) + ", missing=" + cdl.getCount());
  }

  private Process startEchoProgram() throws Exception {
    String javaHome = System.getProperty("java.home");
    String javaProg = System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java";
    File javaExe = new File(new File(javaHome, "bin"), javaProg);
    ProcessBuilder pbuilder = new ProcessBuilder(
        javaExe.getAbsolutePath(),
        "-jar",
        ECHO_PROGRAM_JAR);
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
    return createClient(system_in, system_out, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_CURRENT, BApiDescriptor_Testser.VERSION, 0);
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

  private void startHttpServer(boolean waitForStop) throws Exception {
    log.info("startHttpServer(wait=" + waitForStop);
    
    int port = 12146;
    log.info("start at port " + port);
    DeploymentInfo servletBuilder = Servlets
        .deployment()
        .setClassLoader(BypsServlet.class.getClassLoader())
        .setContextPath("/stdio")
        .setDeploymentName("stdio.war")
        .addServlets(
            Servlets.servlet("BypsServlet", BypsServlet.class)
                .addInitParam("testAdapterEnabled", "true")
                .addMapping("/bypsservlet").addMapping("/bypsservletauth/auth"));

    DeploymentManager manager = Servlets.defaultContainer().addDeployment(
        servletBuilder);
    manager.deploy();
    PathHandler path = Handlers.path(Handlers.redirect("/stdio"))
        .addPrefixPath("/stdio", manager.start());

    server = Undertow.builder().addHttpListener(port, "localhost")
        .setHandler(path).build();
    server.start();
    
    InstanceHandle<? extends Servlet> servletHandle = manager.getDeployment().getServlets().getManagedServlet("BypsServlet").getServlet();
    bypsServlet = servletHandle.getInstance();

    if (waitForStop) {
      boolean isTimedout = serverStopped.await(100, TimeUnit.SECONDS);
      if (!isTimedout) {
        log.error("timeout");
        server.stop();
      }
    }
    log.info(")startHttpServer");
  }

  // Called from CoTestServlet
  void stopHttpServer() {
    if (server != null) {
      server.stop();
      serverStopped.countDown();
    }
  }    
  

}
