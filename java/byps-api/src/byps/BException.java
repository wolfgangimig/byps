package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BExceptionO;


/**
 * Exceptions of this class are thrown during serialization and communication.
 */
public class BException extends byps.RemoteException {
	
	private static final long serialVersionUID = 20L;

	
	/**
	 * Error code.
	 */
	public final int code;
	
	/**
	 * Error message.
	 */
	public final String msg;
	
	/**
	 * Second error message to supply more information.
	 */
	public final String details;
	
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 * @param ex Inner exception. The details member is set at ex.toString()
	 */
	public BException(int code, String msg, Throwable ex) {
		super("", ex);
		this.code = code;
		if (ex instanceof byps.RemoteException) {
		  if (msg != null && msg.length() != 0) {
	      this.msg = msg;
	      this.details = ex.getMessage();
		  }
		  else {
        this.msg = ex.toString();
        this.details = "";
		  }
		}
		else {
  		this.msg = msg != null ? msg : "";
  		this.details = "";
		}
	}
	
  /**
   * Constructor
   * @param code Error code
   * @param msg Error message
   * @param details More information about the error
   */
  public BException(int code, String msg, String details) {
    this.code = code;
    this.msg = msg != null ? msg : "";
    this.details = details != null ? details : "";
  }
  
  /**
   * Constructor
   * @param code Error code
   * @param msg Error message
   * @param details More information about the error
   */
  public BException(int code, String msg, String details, Throwable ex) {
    super("", ex);
    this.code = code;
    this.msg = msg != null ? msg : "";
    this.details = details != null ? details : "";
  }
  
	/**
	 * Constructor
	 * @param code Error code
	 * @param msg Error message
	 */
	public BException(int code, String msg) {
		this(code, msg, "");
	}
	
	/**
	 * Copy constructor
	 * @param rhs
	 */
	public BException(BException rhs) {
	  this(rhs.code, rhs.msg, rhs.details);
	}
	
	/**
	 * Return a String of the form [BYPS:code][message][details].
	 * @return Message string
	 */
	@Override
	public String getMessage() {
		return BExceptionO.formatMessage(code, msg, details, super.getCause());
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
	
}