package com.wilutions.byps;


/**
 * Serialize Stubs
 */

public class BSerializer_16 extends BSerializer {

	public BSerializer_16(int typeId) {
		super(typeId);
	}

	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 8;
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		final BRemote remote = (BRemote)obj;
		final BTargetId targetId = remote.BRemote_getTargetId();
		targetId.write(bout.bbuf.getBuffer());
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		BInputBin bin = ((BInputBin)bin1);
		BRemote remote = null;
		final BTargetId targetId = BTargetId.read(bin.bbuf.getBuffer());
		final BServerRegistry rreg = bin.transport.serverRegistry;
		if (rreg != null) {
			try {
				remote = rreg.getRemote(targetId, typeId);
			}
			catch (BException e) {
				throw e;
			}
			catch (RemoteException e) {
				throw new BException(BException.INTERNAL, e.toString(), e);
			}
		}
		else {
			final BTransport transport = new BTransport(bin.transport, targetId);
			remote = internalCreate(transport);
			bin.onObjectCreated(remote);
		}
		return remote;
	}

	protected BRemote internalCreate(final BTransport transport) throws BException {
		return null; // must be implemented by subclass
	}
}
