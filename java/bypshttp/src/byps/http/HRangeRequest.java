package byps.http;

import java.io.IOException;

import byps.BContentStream;
import byps.BTargetId;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Range request information.
 * @see http://stackoverflow.com/questions/8293687/sample-http-range-request-session
 */
public class HRangeRequest {
  
  private boolean valid;
  private String rangeHeader;
  private long offset;
  private long length = -1;
  private long contentLength = 0;
  private BTargetId targetId = BTargetId.ZERO;
  
  /**
   * Parse request header "Range:".
   * The function checks first, if the request parameter "accept-ranges" is passed. 
   * This parameter has to be explicitly appended to the URL. 
   * @param request Servlet request
   * @param contentLength Content length of stream to be sent.
   * @param positionSupported Stream supports random access - resp. BContentStream#position(long)
   * @return HRangeRequest object.
   * @throws IOException 
   */
  public HRangeRequest(HttpServletRequest request) throws IOException {
    valid = request.getParameter(BContentStream.URL_PARAM_ACCEPT_RANGES) != null;
    rangeHeader = request.getHeader("Range");
  }
  
  public void evaluateByteRange(BContentStream stream) throws IOException {
    
    // If the given stream object is a BContentStreamWrapper, make sure that ensureStream has been called.
    // Otherwise the stream.getContentLength() might return a wrong value.
    stream.available();
    
    targetId = stream.getTargetId();
    contentLength = stream.getContentLength();
    
    valid &= stream.positionSupported();
    if (valid && rangeHeader != null) {
      
      int p = rangeHeader.indexOf("bytes=");
      if (p >= 0) {

        String range = rangeHeader.substring(p + 6);
        String[] beginEnd = range.split("-");
        if (beginEnd.length > 0) {

          offset = Long.parseLong(beginEnd[0]);
          
          if (beginEnd.length > 1 && beginEnd[1].length() != 0) {

            long offsetEnd = Long.parseLong(beginEnd[1]);
            length = offsetEnd - offset + 1;

            // Header "Range: 0-123/124":
            // -> return 206, Content-Type, Content-Length, Accept-Ranges,
            // Content-Range: bytes 0-123/124
            // and data.
          }
          else {

            // Header "Range: 0-":
            // -> return 206, Content-Type, Content-Length, Accept-Ranges,
            // Content-Range: bytes 0-123/124

          }
        }
      }
    }
    
    if (length < 0) {
      length = contentLength - offset;
    }
    
  }
  
  public void setResponseHeaders(HttpServletResponse response) {
    
    if (isValid()) {
      
      // ...inform the client that we support byte ranges.
      response.setHeader("Accept-Ranges", "bytes");
    
      // IE requires to have an ETAG header in order to send range requests
      // https://social.msdn.microsoft.com/forums/ie/en-US/dc3cf477-4bd2-43a3-a36f-8be19c5a8a2c/internet-explorer-http-header-acceptranges
      response.setHeader("ETAG", "\"" + targetId.toString() + "\"");
      
      // Content-Range header. 
      response.setHeader("Content-Range", "bytes " + offset + "-" + (offset + length - 1) + "/" + contentLength);
      
    }

    // Content-Length: for range requests, this header returns the #bytes in the range.
    response.setHeader("Content-Length", Long.toString(length));
    
    // Return Status 200 if entire stream is read.
    // Return Status 206 if a byte range is returned.
    response.setStatus(contentLength == length ? HttpServletResponse.SC_OK : HttpServletResponse.SC_PARTIAL_CONTENT);
    
  }
  
  
  public long getOffset() {
    return offset;
  }
  
  public long getLength() {
    return length;
  }
  
  public boolean isValid() {
    return valid;
  }

  public String toString() {
    String ret = "";
    if (valid) {
      ret = "[contentLength=" + contentLength + ", offset=" + offset + ", length=" + length + "]";
    }
    else {
      ret = "[invalid]";
    }
    return ret;
  }
}
