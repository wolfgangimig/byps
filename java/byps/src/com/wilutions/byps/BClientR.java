package com.wilutions.byps;

public class BClientR {
	
	public final BClient client;
	
	public BClientR(BTransport transport, final BClient client) {
		this.client = new MyClient(transport, client);
	}
	
	protected class MyClient extends BClient {
		final BClient innerClient;
		public MyClient(BTransport transport, BClient innerClient) {
			super(transport, null);
			this.innerClient = innerClient;
		}

		@Override
		public BRemote getStub(int remoteId) {
			return innerClient.getStub(remoteId);
		}
		
	}
}
