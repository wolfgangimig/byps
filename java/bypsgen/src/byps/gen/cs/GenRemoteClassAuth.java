package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import byps.gen.api.GeneratorException;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

public class GenRemoteClassAuth extends GenRemoteClass {

  static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
    //log.debug(GeneratorJ.class.getName(), "generate");
    if (rinfo != null) {
      log.info("generate " + rinfo.qname);
      CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, "", false);
      new GenRemoteClassAuth(pctxt, rinfo,  pr).generate();
      pr.close();
    }
    //log.debug(GeneratorJ.class.getName(), "generate");
  }
  
  private GenRemoteClassAuth(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
    super(pctxt, rinfo, pr);
  }

  protected String getBaseRemote() {
    return null;
  }
  
  protected RemoteInfo getBaseRemoteInfo(RemoteInfo rinfoBase) throws GeneratorException {
    RemoteInfo rinfoAuth = rinfoBase.getRemoteAuth();
    if (rinfoAuth == null) {
      throw new GeneratorException("Interface " + rinfoBase.qname + " must also be tagged with @BSessionParamType because the derived interface " + rinfo.qname + " is tagged.");
    }
    return rinfoAuth;
  }

}
