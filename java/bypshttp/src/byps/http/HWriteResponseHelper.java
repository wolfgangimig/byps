package byps.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBuffer;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;

public class HWriteResponseHelper {

  private final Log log = LogFactory.getLog(HWriteResponseHelper.class);
  private HServerListener listener;

  public HWriteResponseHelper(HServerListener listener) {
    this.listener = listener;
  }

  public void writeResponse(ByteBuffer obuf, Throwable e, HttpServletResponse resp, boolean isAsync) throws IOException {
    if (log.isDebugEnabled()) log.debug("writeResponse(" + obuf + ", exception=" + e + ", resp=" + resp);

    if (resp == null) {
      if (log.isDebugEnabled()) log.debug(")writeResponse timeout");
      return; // timeout
    }
    
    if (listener != null) {
      if (log.isDebugEnabled()) log.debug("call onBefore-listener");
      if (listener.onBeforeWriteHttpResponse(obuf, e, resp, isAsync)) {
        if (log.isDebugEnabled()) log.debug(")writeResponse, onBefore-listener has written the response.");
      }
    }

    if (e != null) {
      
      int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
      if (e instanceof BException) {
        BException bex = (BException) e;
        if (bex.code == BExceptionC.CANCELLED) {
          status = HttpServletResponse.SC_NOT_ACCEPTABLE;
        }
        else if (bex.code == BExceptionC.TIMEOUT) {
          status = HttpServletResponse.SC_REQUEST_TIMEOUT;
        }
      }
      
      if (status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
        log.warn("Responding server error.", e);
      }

      resp.setStatus(status);

      PrintWriter wr = resp.getWriter();
      String errmsg = e.toString(); // (e instanceof BException) ?
                                    // ((BException)e).msg : e.toString();
      wr.print(errmsg);
      wr.close();
      
    } else {
      
      if (log.isDebugEnabled()) log.debug("copy to servlet output");
      boolean isJson = BMessageHeader.detectProtocol(obuf) == BMessageHeader.MAGIC_JSON;
      resp.setContentType(isJson ? "application/json" : "application/byps");
      resp.setContentLength(obuf.remaining());
      OutputStream os = resp.getOutputStream();

      if (log.isDebugEnabled()) {
        log.debug("buffer: \r\n" + BBuffer.toDetailString(obuf));
      }

      if (isAsync) {

        // Tomcat does not throw an IOException in asynchronous requests, if the
        // client
        // has closed the socket. Somewhere on stackoverflow.com I found a hack
        // to workaround this bug. The workaround splits the message into two
        // parts and calls flush() after each part. The second flush throws the
        // expected exception. But the author of this workaround mentioned, that
        // it does not work in all cases - and I confirm to him.
        // http://stackoverflow.com/questions/7124508/how-to-properly-detect-a-client-disconnect-in-servlet-spec-3
        int pos = obuf.position(), len = obuf.remaining() / 2;
        os.write(obuf.array(), pos, len);
        os.flush();
        os.write(obuf.array(), pos + len, obuf.remaining() - len);
        os.flush();
      } else {
        os.write(obuf.array(), obuf.position(), obuf.remaining());
      }

      os.close();
      
      if (listener != null) {
        if (log.isDebugEnabled()) log.debug("call onAfter-listener");
        listener.onAfterWriteHttpResponse(obuf.remaining());
      }
      
    }
    if (log.isDebugEnabled()) log.debug(")writeResponse");
  }

}
