package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */



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
