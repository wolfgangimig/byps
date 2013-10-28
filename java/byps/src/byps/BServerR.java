package byps;



public class BServerR {
	
	public final BTransport transport;
	public final BServer server;
  protected BAsyncResult<Object> lostConnectionHandler;

	public BServerR(BTransport transport, BServer server) {
		this.transport = transport;
		this.server = server;
	}
	
	public void start() throws BException {
	}

	public void done() {
	}

  public void setLostConnectionHandler(BAsyncResult<Object> lostConnectionHandler) {
    this.lostConnectionHandler = lostConnectionHandler;
  }
  

	
}
