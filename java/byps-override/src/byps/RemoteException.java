package byps;

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
