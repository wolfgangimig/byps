package com.wilutions.byps.test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BException;
import com.wilutions.byps.BServerRegistry;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.http.HConfigImpl;
import com.wilutions.byps.http.HConfig;
import com.wilutions.byps.http.HFileUploadItem;
import com.wilutions.byps.http.HHttpServlet;
import com.wilutions.byps.http.HSession;
import com.wilutions.byps.http.HTestAdapter;
import com.wilutions.byps.test.api.BApiDescriptor_Testser;
import com.wilutions.byps.test.api.BClient_Testser;

/**
 * Servlet implementation class BypsServlet
 */

@WebServlet(

// mandatory: must be true
asyncSupported = true,

// optional: load servlet on startup
loadOnStartup = 1,

// mandatory: server URL pattern
// The second pattern is used for authentication. It has to point to a different directory,
// because some browsers initiate the HTTP authentication handshake in each request. By convention,
// see HWireClient.getServletPathForNegotiationAndAuthentication(), the serlet path is 
// [servlet-name]auth/auth.
urlPatterns = { "/bypsservlet", "/bypsservletauth/auth" },

// never true in production environments
initParams = { @WebInitParam(name = "testAdapterEnabled", value = "true") 

})
public class BypsServlet extends HHttpServlet {
  private static final long serialVersionUID = 1L;
  private File tempDir = new File("d:\\temp\\bypssrv");

  public BypsServlet() {
    // temp. Verzeichnis für Streams
    if (tempDir == null) {
      String tempDirStr = System.getProperty("java.io.tmpdir");
      if (tempDirStr != null && tempDirStr.length() != 0) {
        tempDir = new File(tempDirStr);
      }
    }
    tempDir.mkdirs();
  }

  @Override
  public void init() throws ServletException {
    super.init();

    String logLevel = config.getValue("bypshttp.log.level", "WARN");
    String logFile = config.getValue("bypshttp.log.file", null);

    if (logFile != null) {
      logFile = logFile.replace('/', File.separatorChar);
      // Properties props = new Properties();
      // props.put("log4j.rootLogger=", logLevel + ", FI");
      // props.put("log4j.appender.FI.File", logFile);
      // props.put("log4j.appender.FI",
      // "org.apache.log4j.DailyRollingFileAppender");
      // props.put("log4j.appender.FI.DatePattern", "'.'yyyy-MM-dd");
      // props.put("log4j.appender.FI.layout",
      // "org.apache.log4j.PatternLayout");
      // props.put("log4j.appender.FI.layout.ConversionPattern",
      // "%d{ABSOLUTE} %t %1x %-5p (%F:%L) - %m%n");
      // props.put("log4j.appender.FI.append", "false");
      // PropertyConfigurator.configure(props);

      Logger rootLogger = Logger.getRootLogger();
      Appender ap = rootLogger.getAppender("FI");
      if (ap != null) {
        FileAppender fap = (FileAppender) ap;
        fap.setFile(logFile);
        fap.activateOptions();
      }

      if (logLevel.equalsIgnoreCase("DEBUG")) rootLogger.setLevel(Level.DEBUG);
      if (logLevel.equalsIgnoreCase("INFO")) rootLogger.setLevel(Level.INFO);
      if (logLevel.equalsIgnoreCase("WARN")) rootLogger.setLevel(Level.WARN);
      if (logLevel.equalsIgnoreCase("ERROR")) rootLogger.setLevel(Level.ERROR);
      
      if (log.isDebugEnabled()) log.debug("Logger opened.");
    }
  }

  @Override
  protected HSession createSession(HttpServletRequest request, HttpServletResponse response, HttpSession hsess,
      BServerRegistry stubRegistry) {
    if (log.isDebugEnabled()) log.debug("createSession(");
    String remoteUser = request.getRemoteUser();
    if (log.isDebugEnabled()) log.debug("remoteUser=" + remoteUser);
    
    HSession sess = new MySession(hsess, remoteUser, tempDir, stubRegistry);
    if (log.isDebugEnabled()) log.debug(")createSession=" + sess);
    return sess;
  }

  @Override
  protected void makeHtmlUploadResult(HttpSession hsess, HttpServletRequest request, HttpServletResponse response,
      Collection<HFileUploadItem> items) throws IOException {
    String uploadHandler = request.getParameter("uploadHandler");
    if (uploadHandler.equals("htmlform")) {
      super.makeHtmlUploadResult(hsess, request, response, items);
    }
    else if (uploadHandler.equals("blueimp")) {

      // File upload solution from Sebastian Tschan.
      // see https://github.com/blueimp/jQuery-File-Upload/wiki/Setup

      String acceptHeader = request.getHeader("Accept");
      if (acceptHeader != null && acceptHeader.indexOf("application/json") >= 0) {
        response.setContentType("application/json");
      }
      else {
        response.setContentType("text/html");
      }

      PrintWriter wr = response.getWriter();
      wr.print("{\"files\":[");
      boolean first = true;
      for (HFileUploadItem item : items) {
        if (first) first = !first;
        else
          wr.println(",");
        wr.print("{");

        wr.print("\"name\":\"");
        wr.print(item.fileName);
        wr.print("\",");

        wr.print("\"size\":\"");
        wr.print(item.contentLength);
        wr.print("\",");

        wr.print("\"streamId\":\"");
        wr.print(item.streamId);
        wr.print("\"");

        wr.print("}");
      }
      wr.print("]}");
      response.getWriter().close();

    }
  }

  @Override
  protected long getHtmlUploadMaxSize() {
    return super.getHtmlUploadMaxSize(); // returns -1L -> no constrain
  }

  /**
   * Overrides the testAdapter function in order to modify the application
   * version.
   */
  @Override
  protected void doTestAdapter(HttpServletRequest request, HttpServletResponse response) throws IOException {

    if (!config.isTestAdapterEnabled()) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    final String testAdapter = request.getParameter(HTestAdapter.KEY_PARAM);
    if (testAdapter == null) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    if (testAdapter.equals(HTestAdapter.SET_SERVER_APP_VERSION)) {
      String versionStr = request.getParameter(HTestAdapter.VERSION);
      MySession.appVersion = Integer.parseInt(versionStr);
      return;
    }

    super.doTestAdapter(request, response);
  }

  @Override
  protected BApiDescriptor getApiDescriptor() {
    return BApiDescriptor_Testser.instance;
  }

  @Override
  public BClient createForwardClientToOtherServer(BTransport transport) throws BException {
    return BClient_Testser.createClientR(transport);
  }
  
  @Override
  protected HConfig getConfig() {
    return config;
  }
  
  private final Log log = LogFactory.getLog(BypsServlet.class);
  private final HConfigImpl config = new HConfigImpl();

}
