package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.util.Collection;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

public interface HConfig {

  int getMyServerId();

  void init(ServletConfig servletConfig) throws ServletException;

  boolean isTestAdapterEnabled();

  Collection<Integer> getServerIds();

  String getServerUrl(Integer serverId);

  public String getValue(String key, String defaultValue);

  public int getValue(String key, int defaultValue);

  public boolean getValue(String key, boolean defaultValue);
  
  public File getTempDir();
}
