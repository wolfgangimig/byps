package byps.gen.cpp;

import java.io.IOException;

import byps.gen.api.GeneratorException;
import byps.gen.api.RemoteInfo;
import byps.gen.doclet.BConvert;

public class GenRemoteClassAuth extends GenRemoteClass {

  static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
    //log.debug(GeneratorJ.class.getName(), "generate");
    if (rinfo != null) {
      log.info("generate " + rinfo.qname);
      new GenRemoteClassAuth(pctxt, rinfo).generate();
    }
    //log.debug(GeneratorJ.class.getName(), "generate");
  }
  
  private GenRemoteClassAuth(PrintContext pctxt, RemoteInfo rinfo) {
    super(pctxt, rinfo);
  }

  protected String getBaseRemote() {
    return null;
  }
  
  @Override
  protected RemoteInfo getBaseRemoteInfo(RemoteInfo rinfoBase) throws GeneratorException {
    RemoteInfo rinfoAuth = rinfoBase.getRemoteAuth();
    return rinfoAuth;
  }

}
