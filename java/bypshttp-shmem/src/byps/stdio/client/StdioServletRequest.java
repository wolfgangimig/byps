package byps.stdio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import byps.BHttpRequest;
import byps.stdio.common.StdioChannel;

public class StdioServletRequest implements HttpServletRequest {
  
  private final int method;
  private final BHttpRequest request;
  private final StdioServletInputStream istream;

  public StdioServletRequest(int method, BHttpRequest request) {
    this.method = method;
    this.request = request;
    this.istream = new StdioServletInputStream(request.getBody());
  }
  
  public BHttpRequest getBypsRequest() {
    return request;
  }

  @Override
  public AsyncContext getAsyncContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object getAttribute(String arg0) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Enumeration<String> getAttributeNames() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getCharacterEncoding() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int getContentLength() {
    return request.getBody().remaining();
  }

  @Override
  public long getContentLengthLong() {
    return getContentLength();
  }

  @Override
  public String getContentType() {
    return request.getHeaders().get("Content-Type");
  }

  @Override
  public DispatcherType getDispatcherType() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    return istream;
  }

  @Override
  public String getLocalAddr() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getLocalName() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int getLocalPort() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Locale getLocale() {
    return Locale.getDefault();
  }

  @Override
  public Enumeration<Locale> getLocales() {
    return Collections.enumeration(Arrays.asList(getLocale()));
  }

  @Override
  public String getParameter(String key) {
    String param = "";
    String url = request.getUrl();
    String params = url.substring(url.indexOf('?')+1);
    StringTokenizer stokParams = new StringTokenizer(params, "&");
    while (stokParams.hasMoreTokens()) {
      String token = stokParams.nextToken();
      int p = token.indexOf('=');
      String paramName = p >= 0 ? token.substring(0, p) : token;
      if (paramName.equals(key)) {
        String paramValue = p >= 0 ? token.substring(p+1) : "";
        param = paramValue;
        break;
      }
    }
    return param;
  }

  @Override
  public Map<String, String[]> getParameterMap() {
    HashMap<String, String[]> map = new HashMap<>();
    String url = request.getUrl();
    String params = url.substring(url.indexOf('?')+1);
    StringTokenizer stokParams = new StringTokenizer(params, "&");
    while (stokParams.hasMoreTokens()) {
      String token = stokParams.nextToken();
      int p = token.indexOf('=');
      String paramName = p >= 0 ? token.substring(0, p) : token;
      String paramValue = p >= 0 ? token.substring(p+1) : "";
      map.put(paramName, new String[] {paramValue});
    }
    return map;
  }

  @Override
  public Enumeration<String> getParameterNames() {
    
    String url = request.getUrl();
    String params = url.substring(url.indexOf('?')+1);
    StringTokenizer stokParams = new StringTokenizer(params, "&");
    
    Enumeration<String> enumeration = new Enumeration<String>() {

      @Override
      public boolean hasMoreElements() {
        return stokParams.hasMoreTokens();
      }

      @Override
      public String nextElement() {
        String token = stokParams.nextToken();
        int p = token.indexOf('=');
        String paramName = p >= 0 ? token.substring(0, p) : token;
        return paramName;
      }
      
    };

    return enumeration;
  }

  @Override
  public String[] getParameterValues(String key) {
    return new String[] { getParameter(key) };
  }

  @Override
  public String getProtocol() {
    throw new UnsupportedOperationException();
  }

  @Override
  public BufferedReader getReader() throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getRealPath(String arg0) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getRemoteAddr() {
    return "127.0.0.1";
  }

  @Override
  public String getRemoteHost() {
    return "127.0.0.1";
  }

  @Override
  public int getRemotePort() {
    return 0;
  }

  @Override
  public RequestDispatcher getRequestDispatcher(String arg0) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getScheme() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getServerName() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int getServerPort() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServletContext getServletContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isAsyncStarted() {
    return false;
  }

  @Override
  public boolean isAsyncSupported() {
    return false;
  }

  @Override
  public boolean isSecure() {
    return false;
  }

  @Override
  public void removeAttribute(String arg0) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setAttribute(String arg0, Object arg1) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
    throw new UnsupportedOperationException();
  }

  @Override
  public AsyncContext startAsync() throws IllegalStateException {
    throw new UnsupportedOperationException();
  }

  @Override
  public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) throws IllegalStateException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean authenticate(HttpServletResponse arg0) throws IOException, ServletException {
    throw new UnsupportedOperationException();
  }

  @Override
  public String changeSessionId() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getAuthType() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getContextPath() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Cookie[] getCookies() {
    return new Cookie[0];
  }

  @Override
  public long getDateHeader(String arg0) {
    return 0;
  }

  @Override
  public String getHeader(String key) {
    return request.getHeaders().get(key);
  }

  @Override
  public Enumeration<String> getHeaderNames() {
    return Collections.enumeration(request.getHeaders().keySet());
  }

  @Override
  public Enumeration<String> getHeaders(String key) {
    List<String> list = Arrays.asList(request.getHeaders().get(key));
    return Collections.enumeration(list);
  }

  @Override
  public int getIntHeader(String key) {
    return Integer.parseInt(getHeader(key));
  }

  @Override
  public String getMethod() {
    switch(method) {
      case StdioChannel.HTTP_POST:
        return "POST";
      case StdioChannel.HTTP_PUT_STREAM:
        return "PUT";
    }
    return "GET";
  }

  @Override
  public Part getPart(String arg0) throws IOException, ServletException {
    throw new UnsupportedOperationException();
  }

  @Override
  public Collection<Part> getParts() throws IOException, ServletException {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getPathInfo() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getPathTranslated() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getQueryString() {
    String url = request.getUrl();
    return url.substring(url.indexOf('?')+1);
  }

  @Override
  public String getRemoteUser() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getRequestURI() {
    String url = request.getUrl();
    return url.substring(url.indexOf('?')+1);
  }

  @Override
  public StringBuffer getRequestURL() {
    String url = request.getUrl();
    return new StringBuffer(url);
  }

  @Override
  public String getRequestedSessionId() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getServletPath() {
    return "/";
  }

  @Override
  public HttpSession getSession() {
    return null;
  }

  @Override
  public HttpSession getSession(boolean arg0) {
    return null;
  }

  @Override
  public Principal getUserPrincipal() {
    return null;
  }

  @Override
  public boolean isRequestedSessionIdFromCookie() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isRequestedSessionIdFromURL() {
    return false;
  }

  @Override
  public boolean isRequestedSessionIdFromUrl() {
    return false;
  }

  @Override
  public boolean isRequestedSessionIdValid() {
    return false;
  }

  @Override
  public boolean isUserInRole(String arg0) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void login(String arg0, String arg1) throws ServletException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void logout() throws ServletException {
  }

  @Override
  public <T extends HttpUpgradeHandler> T upgrade(Class<T> arg0) throws IOException, ServletException {
    throw new UnsupportedOperationException();
  }

}
