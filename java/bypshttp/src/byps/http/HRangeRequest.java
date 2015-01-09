package byps.http;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import byps.BContentStream;

/**
 * Range request information.
 * @see http://stackoverflow.com/questions/8293687/sample-http-range-request-session
 */
public class HRangeRequest {
  
  private boolean valid;
  private long offset;
  private long length = -1;
  private long contentLength = 0;
  
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
  public static HRangeRequest parse(HttpServletRequest request, long contentLength, boolean positionSupported) throws IOException {

    HRangeRequest ret = new HRangeRequest();

    ret.valid = positionSupported && request.getParameter(BContentStream.URL_PARAM_ACCEPT_RANGES) != null;
    ret.contentLength = contentLength;
    
    if (ret.valid) {
    
      String rangeHeader = request.getHeader("Range");
      if (rangeHeader != null) {
  
        int p = rangeHeader.indexOf("bytes=");
        if (p >= 0) {
  
          String range = rangeHeader.substring(p + 6);
          String[] beginEnd = range.split("-");
          if (beginEnd.length > 0) {
  
            ret.offset = Long.parseLong(beginEnd[0]);
            
            if (beginEnd.length > 1 && beginEnd[1].length() != 0) {
  
              long offsetEnd = Long.parseLong(beginEnd[1]);
              ret.length = offsetEnd - ret.offset + 1;
  
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
          else {
          }
  
        }
        else {
        }
      }
      
    }
    
    if (ret.length < 0) {
      ret.length = contentLength - ret.offset;
    }
    
    return ret;
  }
  
  public void setResponseHeaders(HttpServletResponse response, String etag) {
    
    if (isValid()) {
      
      // ...inform the client that we support byte ranges.
      response.setHeader("Accept-Ranges", "bytes");
    
      // IE requires to have an ETAG header in order to send range requests
      // https://social.msdn.microsoft.com/forums/ie/en-US/dc3cf477-4bd2-43a3-a36f-8be19c5a8a2c/internet-explorer-http-header-acceptranges
      response.setHeader("ETAG", "\"" + etag + "\"");
      
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

}
