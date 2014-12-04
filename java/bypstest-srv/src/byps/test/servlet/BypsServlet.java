package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.http.HConfig;
import byps.http.HConfigImpl;
import byps.http.HFileUploadItem;
import byps.http.HHttpServlet;
import byps.http.HSession;
import byps.http.HTestAdapter;
import byps.test.api.BApiDescriptor_Testser;

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
  protected HSession createSession(HttpSession hsess, String remoteUser) {
    if (log.isDebugEnabled()) log.debug("createSession(");
    if (log.isDebugEnabled()) log.debug("remoteUser=" + remoteUser);
    
    HSession sess = new MySession(hsess, remoteUser, this);
    if (log.isDebugEnabled()) log.debug(")createSession=" + sess);
    return sess;
  }

  @Override
  protected void makeHtmlUploadResult(HttpServletRequest request, HttpServletResponse response,
      Collection<HFileUploadItem> items) throws IOException {
    String uploadHandler = request.getParameter("uploadHandler");
    if (uploadHandler.equals("htmlform")) {
      super.makeHtmlUploadResult(request, response, items);
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
    return BApiDescriptor_Testser.instance();
  }

  @Override
  public HConfig getConfig() {
    return config;
  }
  
  @Override
  protected void initializationFinished() {
  }
  
  private final Log log = LogFactory.getLog(BypsServlet.class);
  private final HConfigImpl config = new HConfigImpl();

}
