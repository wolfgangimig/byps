package byps.stdio.client;

import java.util.Map;

import byps.http.HConfig;
import byps.http.HConfigImpl;
import byps.http.HHttpServlet;
import byps.http.HRequestContext;
import byps.http.HSyncContext;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A base servlet class for STDIO communication. 
 *
 */
public abstract class StdioServlet extends HHttpServlet {
  
  private static final long serialVersionUID = 8258207507942829770L;
  private final HConfigImpl config = new HConfigImpl();
  private final StdioServletConfig servletConfig;
  
  public StdioServlet(Map<String, String> parameters) {
    this.servletConfig = new StdioServletConfig(parameters);
  }
  
  @Override
  public ServletConfig getServletConfig() {
    return servletConfig;
  }

  @Override
  public HConfig getConfig() {
    return config;
  }

  @Override
  protected HRequestContext createRequestContext(HttpServletRequest request,
      HttpServletResponse response, boolean async) {
    return new HSyncContext(request, response);
  }

}
