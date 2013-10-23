package byps;

public class BExceptionO {

  public final static String formatMessage(int code, String msg, String details, Throwable cause) {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("[ELOIX:").append(code).append("]");
    if (msg != null && msg.length() != 0) sbuf.append("[").append(msg).append("]");
    if (details != null && details.length() != 0) sbuf.append("[").append(details).append("]");
    if (cause != null) {
      String s = cause.getMessage();
      if (s == null || s.length() == 0) s = cause.toString();
      sbuf.append("[").append(s).append("]");
    }
    return sbuf.toString();
  }
  
}
