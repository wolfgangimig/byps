package byps.stdio.client;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class StdioServletConfig implements ServletConfig {
  
  private final Map<String, String> parameters;
  
  public StdioServletConfig(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  @Override
  public String getServletName() {
    return "stdio";
  }

  @Override
  public ServletContext getServletContext() {
    throw new UnsupportedOperationException("getServletContext");
  }

  @Override
  public String getInitParameter(String name) {
    return parameters.get(name);
  }

  @Override
  public Enumeration<String> getInitParameterNames() {
    return Collections.enumeration(parameters.keySet());
  }

}
