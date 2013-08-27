package com.wilutions.byps;


/**
 * Serialize BRemote
 */

public class JSerializer_16 extends BSerializer {

	public JSerializer_16(int typeId) {
		super(typeId);
	}

	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0;
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputJson bout = ((BOutputJson)bout1);
		final BBufferJson bbuf = bout.bbuf;
		final BRemote remote = (BRemote)obj;
		final BTargetId targetId = remote.BRemote_getTargetId();
		bbuf.beginObject();
		bbuf.putInt("_typeId", typeId);
		bbuf.putString("targetId", targetId.toString());
		bbuf.endObject();
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = ((BInputJson)bin1);
		BRemote remote = null;
		final BTargetId targetId = BTargetId.parseString(bin.currentObject.getString("targetId"));
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
