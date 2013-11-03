package byps;



public class BServerR {
	
	public final BTransport transport;
	public final BServer server;
  protected BLostConnectionHandler lostConnectionHandler;

	public BServerR(BTransport transport, BServer server) {
		this.transport = transport;
		this.server = server;
	}
	
	public void start() throws BException {
	}

	public void done() {
	}

  public void setLostConnectionHandler(BLostConnectionHandler lostConnectionHandler) {
    this.lostConnectionHandler = lostConnectionHandler;
  }
  

	
}
