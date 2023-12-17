package byps.stdio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import byps.BHttpRequest;
import byps.stdio.common.StdioChannel;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpUpgradeHandler;
import jakarta.servlet.http.Part;

public class StdioServletRequest implements HttpServletRequest {
  
  private final StdioHttpSession httpSession;
  private final int method;
  private final BHttpRequest request;
  private final StdioServletInputStream istream;

  public StdioServletRequest(StdioHttpSession httpSession, int method, BHttpRequest request) {
    this.httpSession = httpSession;
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
    return getHeader("Content-Type");
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
    String param = null;
    if (method == StdioChannel.HTTP_POST) {
    }
    else {
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
          param = decodeUrlParam(param);
          break;
        }
      }
    }
    return param;
  }

  private String decodeUrlParam(String param) {
    try {
      param = URLDecoder.decode(param, "UTF-8");
    } catch (UnsupportedEncodingException e) {}
    return param;
  }

  @Override
  public Map<String, String[]> getParameterMap() {
    Map<String, String[]> map = Collections.emptyMap();
    if (method == StdioChannel.HTTP_POST) {
    }
    else {
      map = new HashMap<String, String[]>();
      String url = request.getUrl();
      String params = url.substring(url.indexOf('?')+1);
      StringTokenizer stokParams = new StringTokenizer(params, "&");
      while (stokParams.hasMoreTokens()) {
        String token = stokParams.nextToken();
        int p = token.indexOf('=');
        String paramName = p >= 0 ? token.substring(0, p) : token;
        String paramValue = p >= 0 ? token.substring(p+1) : "";
        paramValue = decodeUrlParam(paramValue);
        map.put(paramName, new String[] {paramValue});
      }
    }
    return map;
  }

  @Override
  public Enumeration<String> getParameterNames() {
    
    String url = request.getUrl();
    String params = url.substring(url.indexOf('?')+1);
    final StringTokenizer stokParams = new StringTokenizer(params, "&");
    
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
    return internalGetHeaders().get(key);
  }

  @Override
  public Enumeration<String> getHeaderNames() {
    return Collections.enumeration(internalGetHeaders().keySet());
  }

  @Override
  public Enumeration<String> getHeaders(String key) {
    List<String> list = Arrays.asList(internalGetHeaders().get(key));
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
    return null;
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
    return getSession(false);
  }

  @Override
  public HttpSession getSession(boolean createIfNotExist) {
    return httpSession;
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

  private Map<String,String> internalGetHeaders() {
    Map<String,String> ret = request.getHeaders();
    return ret != null ? ret : EMPTY_HEADERS;
  }
  
  private final static Map<String,String> EMPTY_HEADERS = new HashMap<String,String>(0);

  @Override
  public String getRequestId() {
    return null;
  }

  @Override
  public String getProtocolRequestId() {
    return null;
  }

  @Override
  public ServletConnection getServletConnection() {
    return null;
  }
}
