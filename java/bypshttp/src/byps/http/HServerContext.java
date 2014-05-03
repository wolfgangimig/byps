package byps.http;

import byps.BServerRegistry;

public interface HServerContext {

  public HConfig getConfig();
  public BServerRegistry getServerRegistry();
  public HServerListener getListener();
  public HActiveMessages getActiveMessages();
  
}
