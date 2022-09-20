package byps.http.cotest;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import byps.BApiDescriptor;
import byps.http.HConfig;
import byps.http.HConfigImpl;
import byps.http.HHttpServlet;
import byps.http.HSession;
import byps.http.HTestAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class 
 */
public class CoTestServlet extends HHttpServlet {

    private static final long serialVersionUID = 1L;
    
    public CoTestServlet() {
    }

    @Override
    protected HSession createSession(HttpSession hsess, String remoteUser) {
      HSession sess = new CoTestSession(hsess, remoteUser, this);
      return sess;
    }

    @Override
    protected BApiDescriptor getApiDescriptor() {
      return CoTestProcess.getGlobalServerInstance().getApiDesc();
    }
    
    @Override
    public HConfig getConfig() {
      return config;
    }
    
    @Override
    protected void initializationFinished() {
    }
    
    /**
     * Overrides the testAdapter function in order to modify the application
     * version.
     */
    @Override
    protected void doTestAdapter(HttpServletRequest request, HttpServletResponse response) throws IOException {
      final String testAdapter = request.getParameter(HTestAdapter.KEY_PARAM);
      if (testAdapter != null) {
        new Thread() {
          public void run() {
            CoTestProcess.getGlobalServerInstance().stopHttpServer();
          }
        }.start();
      }
      else {
        super.doTestAdapter(request, response);
      }
    }
    
    private final HConfigImpl config = new HConfigImpl();

}
