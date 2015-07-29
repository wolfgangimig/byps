package byps.http.cotest;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.LogLevel;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BSyncResult;
import byps.BTransportFactory;
import byps.BWire;
import byps.http.HTransportFactoryClient;
import byps.http.HWireClient;

/**
 * Main class for compatibility test process.
 * This class starts either a HTTP server or a HTTP client.
 * The server 
 *
 */
public class CoTestProcess {

  public final static boolean APP_TYPE_SERVER = true;
  public final static boolean APP_TYPE_CLIENT = false;
  public final static boolean OTHER_PROCESS = true;
  public final static boolean THIS_PROCESS = false;
  
  public CoTestProcess(CoTestParams params) {
    this.params = params;
  }
  
  public static void startServer(CoTestParams params, boolean otherProcess) throws Exception {
    if (otherProcess) {
      startServerInOtherProcess(params);
    }
    else {
      startServerInThisProcess(params);
    }
  }

  public static void startClient(CoTestParams params, boolean otherProcess) throws Exception {
    if (otherProcess) {
      startClientInOtherProcess(params);
    }
    else {
      startClientInThisProcess(params);
    }
  }

  public static void main(String[] args) {

//    // Log to stdout 
//    Properties log4jConsole = new Properties();
//    log4jConsole.setProperty("log4j.rootLogger", "info, A1");
//    log4jConsole.setProperty("log4j.appender.A1",
//                             "org.apache.log4j.ConsoleAppender");
//    log4jConsole.setProperty("log4j.appender.A1.layout",
//                             "org.apache.log4j.PatternLayout");
//    log4jConsole.setProperty("log4j.appender.FI.layout.ConversionPattern",
//                             "%d{ABSOLUTE} %1x %-5p (%F:%L) - %m%n");
//    PropertyConfigurator.configure(log4jConsole);    
    
    try {
      int port = 0;
      String surl = "";
      String apiDescClassName = "";
      boolean appType = APP_TYPE_SERVER;
      String logFile = "";
      
      {
        for (int i = 0; i < args.length; i++) {
          System.out.println("args[" + i + "]=" + args[i]);
        }
      }
      
      int i = 0;
      while (i < args.length) {
        
        if (args[i].equals("-api")) {
          i++;
          if (i >= args.length) throw new IllegalStateException("Missing api descriptor class name");
          apiDescClassName = args[i];
        }
        else if (args[i].equals("-port")) {
          i++;
          if (i >= args.length) throw new IllegalStateException("Missing port value");
          port = Integer.parseInt(args[i]);
        }
        else if (args[i].equals("-url")) {
          i++;
          if (i >= args.length) throw new IllegalStateException("Missing url value");
          surl = args[i];
        }
        else if (args[i].equals("-server")) {
          appType = APP_TYPE_SERVER;
        }
        else if (args[i].equals("-client")) {
          appType = APP_TYPE_CLIENT;
        }
        else if (args[i].equals("-logFile")) {
          i++;
          if (i >= args.length) throw new IllegalStateException("Missing logfile value");
          logFile = args[i];
        }
        
        i++;
      }
      
      if (apiDescClassName.length() == 0) throw new IllegalStateException("Missing API descriptor class name.");
      CoTestParams params = new CoTestParams();
      params.initProcessSite(apiDescClassName, port, surl, logFile);
      CoTestProcess main = new CoTestProcess(params);
      
      if (appType == APP_TYPE_SERVER) {
        
        // Start HTTP server
        if (port == 0) throw new IllegalStateException("Missing port");
        System.out.println("start HTTP server");
        main.startHttpServer(true);
        System.out.println("HTTP server stopped");
      }
      else {
        
        // Create client
        if (surl.length() == 0) throw new IllegalStateException("Missing url");
        System.out.println("start client");
        final BClient client = main.startClient();

        System.out.println("start tests");
        main.runTestAndCleanup(client);
      }
      
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("finished");
  }
  
  private void runTestAndCleanup(final BClient client) throws Exception {
    log.info("runTest(" + client);
    final String url = params.getUrl();
    
    // Test runner result object: stop client and kill server
    BSyncResult<Boolean> result = new BSyncResult<Boolean>() {
      public void setAsyncResult(Boolean result, Throwable e) {
        log.info("stop client");
        client.done();
        log.info("kill server");
        killServer(url);
        super.setAsyncResult(result, e);
      }
    };
    
    // Run test
    log.info("run...");
    params.getTestRunnable().run(client, result);
    
    log.info("await finished...");
    result.getResult(100*1000);
    
    log.info(")runTest");
  }
  
  private static void killServer(String url) {
    for (int i = 0; i < 10; i++) {
      try {
        URL ourl = new URL(url + "?testAdapter=kill");
        URLConnection conn = ourl.openConnection();
        InputStream istream = conn.getInputStream();
        while (istream.read() != -1) {}
        istream.close();
        Thread.sleep(1000);
      }
      catch (Exception e) {
        log.info("assume server stopped: " + e);
        break;
      }
    }
  }

  private BClient startClient() throws Exception {
    log.info("startClient(");
    String url = params.getUrl();
    BApiDescriptor apiDesc = params.getApiDesc();
    log.info("url=" + url + ", apiDesc=" + apiDesc);
    
    BWire wire = new HWireClient(url, 0, 600, null);
    final BTransportFactory transportFactory = new HTransportFactoryClient(apiDesc, wire, 0); 
    
    //BClient_Testser.createClient(transportFactory);
    BClient client = null;
    {
      log.info("BClient.createClient");
      Class<?> serverClass = Class.forName(apiDesc.basePackage + ".BClient_" + apiDesc.name);
      Method m = serverClass.getMethod("createClient", BTransportFactory.class);
      client = (BClient)m.invoke(null, transportFactory);
    }

    int retries = 100;
    for (int i = 0; i < retries; i++) {
      Thread.sleep(1000);
      try {
        log.info("client.start");
        BSyncResult<Boolean> syncResult = new BSyncResult<Boolean>();
        client.start(syncResult);
        syncResult.getResult();
        break;
      }
      catch (Exception e) {
        log.info("client.start failed, e=" + e);
        if (i == retries-1) throw e;
      }
    }

    log.info(")startClient=" + client);
    return client;
  }

  private void startHttpServer(boolean waitForStop) throws Exception {
    log.info("startHttpServer(wait=" + waitForStop);
    globalServerInstance = this;
    
    int port = params.getPort();
    log.info("start at port " + port);
    DeploymentInfo servletBuilder = Servlets
        .deployment()
        .setClassLoader(CoTestServlet.class.getClassLoader())
        .setContextPath("/comptest")
        .setDeploymentName("comptest.war")
        .addServlets(
            Servlets.servlet("TestServlet", CoTestServlet.class)
                .addInitParam("testAdapterEnabled", "true")
                .addMapping("/bypsservlet").addMapping("/bypsservletauth/auth"));

    DeploymentManager manager = Servlets.defaultContainer().addDeployment(
        servletBuilder);
    manager.deploy();
    PathHandler path = Handlers.path(Handlers.redirect("/comptest"))
        .addPrefixPath("/comptest", manager.start());

    server = Undertow.builder().addHttpListener(port, "localhost")
        .setHandler(path).build();
    server.start();

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

  private static void startClientInOtherProcess(CoTestParams params) throws Exception {
    CoTestProcess main = new CoTestProcess(params);
    final Process process = main.startOtherProcess(CoTestProcess.APP_TYPE_CLIENT);
    process.waitFor(100, TimeUnit.SECONDS);
  }

  private void attachStdStreams(final Process process) {
    final StringBuilder stdoutBuf = new StringBuilder();
    readStreamInBackground(process.getInputStream(), stdoutBuf, LogLevel.INFO);
    final StringBuilder stderrBuf = new StringBuilder();
    readStreamInBackground(process.getErrorStream(), stderrBuf, LogLevel.ERROR);
  }
  
  private void readStreamInBackground(final InputStream istream, final StringBuilder sbuf, final LogLevel level) {
    Thread thread = new Thread() {
      public void run() {
        InputStream is = istream;
        Reader rd = null;
        try {
          rd = new InputStreamReader(is);
          char[] buf = new char[1000];
          int len = -1;
          while ((len = rd.read(buf)) != -1) {
            String s = new String(buf, 0, len);
            if (level == LogLevel.ERROR) {
              log.error("other process: " + s);
            }
            else {
              log.info("other process: " + s);
            }
            sbuf.append(s);
          }
        } catch (Throwable ignroed) {
        } finally {
          if (rd != null) {
            try {
              rd.close();
            } catch (IOException ignored) {
            }
          }
        }
      }
    };
    thread.start();
  }

  private Process startOtherProcess(boolean appType) throws Exception {
    log.info("startOtherProcess(" + (appType == CoTestProcess.APP_TYPE_SERVER ? "-server" : "-client"));
    
    String bypstest_jar =  params.getBypstest_jar();
    int port = params.getPort();
    String url = params.getUrl();
    String apiDescClassName = params.getApiDescClassName();
    String appTypeParam = appType == CoTestProcess.APP_TYPE_SERVER ? "-server" : "-client";

    // Make log file name, e.g.: d:/temp/log/jclient-server.log
    String logFileOther = params.getLogFileOther();
    {
      int p = logFileOther.lastIndexOf('.');
      if (p >= 0) {
        logFileOther = logFileOther.substring(0, p);
      }
      logFileOther += appTypeParam + ".log";
    }

    String classpathSeparator = System.getProperty("path.separator");
    String cp = System.getProperty("java.class.path");
    
    // Strip non-jars from classpath (e.g. byps/bin, bypshttp/bin...)
    // All byps classes have to be loaded from bypstest_jar.
    {
      String[] cpelms = cp.split(classpathSeparator);
      StringBuilder ncp = new StringBuilder();
      for (String s : cpelms) {
        if (s.toLowerCase().endsWith(".jar")) {
          if (ncp.length() != 0) ncp.append(classpathSeparator);
          ncp.append(s);
        }
      }
      cp = ncp.toString();
    }
    
    String classPath = bypstest_jar + ";" + cp;
    classPath = classPath.replace(';', classpathSeparator.charAt(0));
    
    File javaHome = new File(System.getProperty("java.home"));
    String javaExe = (new File(new File(javaHome, "bin"), "java")).toString();
    
    String [] args = new String[] {
        javaExe,
        "-classpath", classPath,
        CoTestProcess.class.getName(),
        "-port", Integer.toString(port),
        "-url", url,
        "-api", apiDescClassName,
        "-logFile", logFileOther,  
        appTypeParam
    };
    
    log.info("ProcessBuilder.start, args=" + Arrays.toString(args));
    Process process =  new ProcessBuilder(args).start();

    attachStdStreams(process);

    log.info(")startOtherProcess=" + process);
    return process;
  }
  
  private static void startServerInOtherProcess(CoTestParams params) throws Exception {
    log.info("startServerInOtherProcess(");
    final CoTestProcess main = new CoTestProcess(params);
    final CountDownLatch serverRunning = new CountDownLatch(1);
    final Exception[] refException = new Exception[1];
    
    new Thread() {
      public void run() {
        try {
          Process p = null;
          try {
            p = main.startOtherProcess(CoTestProcess.APP_TYPE_SERVER);
          }
          finally {
            serverRunning.countDown();
          }
          p.waitFor(100, TimeUnit.SECONDS);
        }
        catch (Exception e) {
          refException[0] = e;
          e.printStackTrace();
        }
      }
    }.start();

    log.info("await server running...");
    serverRunning.await();
    log.info("await server running");
    
    if (refException[0] != null) throw refException[0];
    
    log.info(")startServerInOtherProcess");
  }
  
  private static void startServerInThisProcess(CoTestParams params) throws Exception {
    log.info("startServerInThisProcess(" + params);
    CoTestProcess main = new CoTestProcess(params);
    main.startHttpServer(false);
    log.info(")startServerInThisProcess");
  }
  
  private static void startClientInThisProcess(CoTestParams params) throws Exception {
    log.info("startClientInThisProcess(" + params);
    CoTestProcess main = new CoTestProcess(params);
    BClient client = main.startClient();
    main.runTestAndCleanup(client);
    log.info(")startClientInThisProcess");
  }
  
  public BApiDescriptor getApiDesc() {
    return params.getApiDesc();
  }

  public static CoTestProcess getGlobalServerInstance() {
    return globalServerInstance;
  }

  private final static Log log = LogFactory.getLog(CoTestProcess.class);
  private volatile Undertow server;
  private CountDownLatch serverStopped = new CountDownLatch(1);
  private CoTestParams params;
  private static CoTestProcess globalServerInstance;
  
}
