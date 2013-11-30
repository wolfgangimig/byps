package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

public class RemoteException extends IOException {

	private static final long serialVersionUID = 1L;

	public RemoteException() {
		super();
	}

	public RemoteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RemoteException(String arg0) {
		super(arg0);
	}

}
