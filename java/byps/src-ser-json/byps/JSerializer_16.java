package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */


/**
 * Serialize BRemote
 */

public class JSerializer_16 extends BSerializer {

	public JSerializer_16(int typeId) {
		super(typeId);
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputJson bout = ((BOutputJson)bout1);
		final BBufferJson bbuf = bout.bbuf;
		final BRemote remote = (BRemote)obj;
		BTargetId targetId = remote.BRemote_getTargetId();
		
    final BServerRegistry rreg = bout1.transport.getServerRegistry();
    if (rreg != null) {
      // server side
      if (bout1.header.bversion >= BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID) {
        try {
          targetId = rreg.encryptTargetId(targetId, true);
        } catch (RemoteException e) {
          throw new BException(BExceptionC.INTERNAL, e.toString(), e);
        }
      }
    }

    bbuf.beginObject();
		bbuf.putInt("_typeId", typeId);
		bbuf.putString("targetId", targetId.toString(bout1.header.bversion));
		bbuf.endObject();
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = ((BInputJson)bin1);
		BRemote remote = null;
		BTargetId targetId = BTargetId.parseString(bin.currentObject.getString("targetId"));
		
		final BServerRegistry rreg = bin.transport.getServerRegistry();
		if (rreg != null) {
			try {
        if (bin1.header.bversion >= BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID) {
          targetId = rreg.encryptTargetId(targetId, false);
        }
				remote = rreg.getRemote(targetId, typeId);
			}
			catch (BException e) {
				throw e;
			}
			catch (RemoteException e) {
				throw new BException(BExceptionC.INTERNAL, e.toString(), e);
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
