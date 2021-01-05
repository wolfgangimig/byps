package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBuffer;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.io.BOutputStreamByteCount;

public class HWriteResponseHelper {

  private final static Logger log = LoggerFactory.getLogger(HWriteResponseHelper.class);
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
        else if (bex.code == BExceptionC.RESEND_LONG_POLL) {
          status = HttpServletResponse.SC_NO_CONTENT;
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
      resp.setContentType(isJson ? "application/json; charset=UTF-8" : "application/byps");
      resp.setContentLength(obuf.remaining());
      BOutputStreamByteCount osByteCount = new BOutputStreamByteCount(resp.getOutputStream());
      OutputStream os = osByteCount;
      
      if (HConstants.GZIP_CONTENT) {
        resp.setHeader("Content-Encoding", "gzip");
        os = new GZIPOutputStream(osByteCount);
      }

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
        if (log.isDebugEnabled()) log.debug("call onAfter-listener #bytes={}", osByteCount.getByteCount());
        listener.onAfterWriteHttpResponse((int)osByteCount.getByteCount());
      }
      
    }
    if (log.isDebugEnabled()) log.debug(")writeResponse");
  }

}
