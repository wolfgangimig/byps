package byps.stdio.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import byps.BAsyncResult;
import byps.BHttpRequest;

public class StdioServletResponse implements HttpServletResponse {
  
  private final StdioServletOutputStream ostream;
  private final BHttpRequest response = new BHttpRequest();
  private final BAsyncResult<BHttpRequest> asyncResult;
  private volatile int status;
  private volatile String statusMessage;
  private volatile PrintWriter writer;
  
  public static interface OnSendResponse {
    public void handle(BHttpRequest response);
  }
  
  public StdioServletResponse(BAsyncResult<BHttpRequest> asyncResult) {
    this.asyncResult = asyncResult;
    
    // Initialize ServletOutputStream. Pass a handler for 
    // the OnClose event that assigns the stream buffer to 
    // the response body.
    ostream = new StdioServletOutputStream((bbuf) -> {
      
      // If response body not already set by getBypsResponse().setBody()...
      if (response.getBody() == null) {
        
        // Assign the bytes written into the ServletOutputStream. 
        response.setBody(bbuf);
      }
      
      this.asyncResult.setAsyncResult(response, null);
    });
  }

  public BHttpRequest getBypsResponse() {
    return response;
  }
  
  @Override
  public void flushBuffer() throws IOException {
  }

  @Override
  public int getBufferSize() {
    return 10000;
  }

  @Override
  public String getCharacterEncoding() {
    return null;
  }

  @Override
  public String getContentType() {
    return null;
  }

  @Override
  public Locale getLocale() {
    return Locale.getDefault();
  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    return ostream;
  }

  @Override
  public PrintWriter getWriter() throws IOException {
    if (writer == null) writer = new PrintWriter(ostream);
    return writer;
  }

  @Override
  public boolean isCommitted() {
    return false;
  }

  @Override
  public void reset() {
    ostream.toByteBuffer().clear();
  }

  @Override
  public void resetBuffer() {
    ostream.toByteBuffer().clear();
  }

  @Override
  public void setBufferSize(int arg0) {
  }

  @Override
  public void setCharacterEncoding(String arg0) {
  }

  @Override
  public void setContentLength(int len) {
    setContentLengthLong(len);
  }

  @Override
  public void setContentLengthLong(long arg0) {
    addHeader("Content-Length", Long.toString(arg0));
  }

  @Override
  public void setContentType(String arg0) {
    addHeader("Content-Type", arg0);
  }

  @Override
  public void setLocale(Locale arg0) {
    
  }

  @Override
  public void addCookie(Cookie arg0) {
    addHeader("Set-Cookie", arg0.toString());
  }

  @Override
  public void addDateHeader(String arg0, long arg1) {
    
  }

  @Override
  public void addHeader(String arg0, String arg1) {
    setHeader(arg0, arg1);
  }

  @Override
  public void addIntHeader(String arg0, int arg1) {
    addHeader(arg0, Integer.toString(arg1));
  }

  @Override
  public boolean containsHeader(String arg0) {
    return getHeader(arg0) != null;
  }

  @Override
  public String encodeRedirectURL(String arg0) {
    return arg0;
  }

  @Override
  public String encodeRedirectUrl(String arg0) {
    return arg0;
  }

  @Override
  public String encodeURL(String arg0) {
    return arg0;
  }

  @Override
  public String encodeUrl(String arg0) {
    return arg0;
  }

  @Override
  public String getHeader(String arg0) {
    return response.getHeaders() != null ? response.getHeaders().get(arg0) : null;
  }

  @Override
  public Collection<String> getHeaderNames() {
    return response.getHeaders() != null ? response.getHeaders().keySet() : new ArrayList<String>(0);
  }

  @Override
  public Collection<String> getHeaders(String arg0) {
    return Arrays.asList(getHeader(arg0));
  }

  @Override
  public int getStatus() {
    return 0;
  }

  @Override
  public void sendError(int arg0) throws IOException {
  }

  @Override
  public void sendError(int arg0, String arg1) throws IOException {
  }

  @Override
  public void sendRedirect(String arg0) throws IOException {
  }

  @Override
  public void setDateHeader(String arg0, long arg1) {
  }

  @Override
  public void setHeader(String arg0, String arg1) {
    if (response.getHeaders() == null) response.setHeaders(new HashMap<String,String>());
    response.getHeaders().put(arg0, arg1);
  }

  @Override
  public void setIntHeader(String arg0, int arg1) {
    setHeader(arg0, Integer.toString(arg1));
  }

  @Override
  public void setStatus(int arg0) {
    status = arg0;
  }

  @Override
  public void setStatus(int arg0, String arg1) {
    status = arg0;
    statusMessage = arg1;
  }


}
