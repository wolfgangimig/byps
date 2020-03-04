package byps;

public class BStub implements BRemote {

	public final BTransport transport;
	
  protected BStub() {
	  throw new UnsupportedOperationException();
	}
	
	public BStub(BTransport transport) {
		this.transport = transport;
	}
	
	@Override
	public BTargetId BRemote_getTargetId() {
		return transport.getTargetId();
	}

}
