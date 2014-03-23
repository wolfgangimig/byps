package task.app;

import java.io.Serializable;

public class Token implements Serializable {

	private static final long serialVersionUID = 8555137564008202878L;

	protected String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
