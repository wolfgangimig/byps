package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * This class provides a function for formatting exception messages. 
 * If an application requires a special error format, an object derived from 
 * BExceptionO.FormatMessageFnct can be assigned to the static member formatMessage.
 */
public class BExceptionO {
  
  /**
   * Interface with format function.
   */
  public static interface FormatMessageFnct {
    
    /**
     * Format message.
     * @param code Error code, see byps.BExceptionC
     * @param msg Error message
     * @param details Error details
     * @param cause Inner exception
     * @return Message string
     */
    public String formatMessage(int code, String msg, String details, Throwable cause);
  }

  /**
   * Public static member that holds the format function.
   */
  public static FormatMessageFnct formatMessage = new FormatMessageFnct() {
    
    public String formatMessage(int code, String msg, String details, Throwable cause) {
      StringBuilder sbuf = new StringBuilder();
      sbuf.append("[BYPS:").append(code).append("]");
      if (msg != null && msg.length() != 0) sbuf.append("[").append(msg).append("]");
      if (details != null && details.length() != 0) sbuf.append("[").append(details).append("]");
      if (cause != null) {
        String s = cause.getMessage();
        if (s == null || s.length() == 0) s = cause.toString();
        sbuf.append("[").append(s).append("]");
      }
      return sbuf.toString();
    }
  };
}
