package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */


/**
 * Serialize Stubs
 */

public class BSerializer_16 extends BSerializer {

	public BSerializer_16(int typeId) {
		super(typeId);
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		final BRemote remote = (BRemote)obj;
		BTargetId targetId = remote.BRemote_getTargetId();
		
    final BServerRegistry rreg = bout1.transport.getServerRegistry();
    if (rreg != null) {
      // server side
      if (bout1.header.bversion >= BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID) {
        try {
          targetId = targetId.bindCopyToRemote(typeId);
          targetId = rreg.encryptTargetId(targetId, true);
        } catch (RemoteException e) {
          throw new BException(BExceptionC.INTERNAL, e.toString(), e);
        }
      }
    }
    
    bout.bbuf.putTargetId(targetId, bout1.header.bversion);
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		BInputBin bin = ((BInputBin)bin1);
		BRemote remote = null;
    BTargetId targetId = bin.bbuf.getTargetId(bin1.header.bversion);
		
		final BServerRegistry rreg = bin.transport.getServerRegistry();
		if (rreg != null) {
	    // server side
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
      // client side, or forward client on server side
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
