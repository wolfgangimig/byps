package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletResponse;

/**
 * This interface listens on several events triggered in the HHttpServlet.
 * 
 */
public interface HServerListener {

  /**
   * This function is called before the response is sent.
   * 
   * @param obuf Bytes to send.
   * @param e Exception or null, if no error has occurred in HHttpServlet. But there might be an application error contained in obuf.
   * @param resp Servlet response.
   * @param isAsync true, if the request was processed asynchronously.
   * @return false, to process the default behavior. true, if the response has
   *         been written in the function and HHttpServlet should not do
   *         anything more.
   * @throws IOException
   */
  public boolean onBeforeWriteHttpResponse(ByteBuffer obuf, Throwable e, HttpServletResponse resp, boolean isAsync) throws IOException;

  /**
   * This function is called after the response bytes have been sent.
   * This function is not called, if an exception was passed to onBeforeWriteHttpResponse. 
   * @param nbOfBytesWritten Number of bytes written to the output stream.
   */
  public void onAfterWriteHttpResponse(int nbOfBytesWritten);
}
