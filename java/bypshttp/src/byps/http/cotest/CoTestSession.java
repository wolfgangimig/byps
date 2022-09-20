package byps.http.cotest;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BApiDescriptor;
import byps.BServer;
import byps.BTransportFactory;
import byps.http.HServerContext;
import byps.http.HSession;
import jakarta.servlet.http.HttpSession;

public class CoTestSession extends HSession {
  
  private final BServer server;
  
  public CoTestSession(HttpSession hsess, String remoteUser, HServerContext serverContext) {
    super(hsess, remoteUser, serverContext);
    if (log.isDebugEnabled()) log.debug("MySession(");
    
    setSessionAuthenticated();
    
    BApiDescriptor myDesc = CoTestProcess.getGlobalServerInstance().getApiDesc();
    BTransportFactory transportFactory = getTransportFactory(myDesc);
    
    // BServer_Testser.createServer
    try {
      String className = myDesc.basePackage + ".BServer_" + myDesc.name;
      Class<?> serverClass = Class.forName(className);
      Method m = serverClass.getMethod("createServer", BTransportFactory.class);
      server = (BServer)m.invoke(null, transportFactory);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }

    //TestCompatibleApi_Testser.addRemotes(server);
    try {
      String className = myDesc.basePackage + ".TestCompatibleApi_" + myDesc.name;
      Class<?> serverClass = Class.forName(className);
      Method m = serverClass.getMethod("addRemotes", BServer.class);
      m.invoke(null, server);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }

    if (log.isDebugEnabled()) log.debug(")MySession");
  }
  
  @Override
  public BServer getServer() {
    return server;
  }

  private final Logger log = LoggerFactory.getLogger(CoTestSession.class);
}

