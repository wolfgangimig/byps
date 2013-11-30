package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import byps.gen.api.GeneratorException;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

public class GenRemoteClassAuth extends GenRemoteClassAsync {

  static void generate(PrintContext pctxt, RemoteInfo rinfo, RemoteInfo rinfoAsync) throws IOException {
    if (rinfoAsync == null) return;
    
    log.info("generate " + rinfoAsync.qname);
    CodePrinter pr = pctxt.getPrinterForApiClass(rinfoAsync, "", true);
    new GenRemoteClassAuth(pctxt, rinfo, rinfoAsync, pr).generate();
    pr.close();

    // log.debug(GeneratorJ.class.getName(), "generate");
  }


  private GenRemoteClassAuth(PrintContext pctxt, RemoteInfo rinfoBase, RemoteInfo rinfoAsync, CodePrinter pr) {
    super(pctxt, rinfoBase, rinfoAsync, pr);
  }

  protected String getBaseRemote() {
    return null;
  }
  
  protected RemoteInfo getBaseRemoteInfo(RemoteInfo rinfo) throws GeneratorException {
    RemoteInfo rinfoAuth = rinfo.getRemoteAuth();
    if (rinfoAuth == null) {
      throw new GeneratorException("Interface " + rinfo.qname + " must also be tagged with @BSessionParamType because the derived interface " + rinfoAsync.qname + " is tagged.");
    }
    return rinfoAuth;
  }

}
