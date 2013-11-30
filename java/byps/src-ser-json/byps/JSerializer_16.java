package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BInput;
import byps.BInputJson;
import byps.BOutput;
import byps.BOutputJson;
import byps.BRemote;
import byps.BSerializer;
import byps.BServerRegistry;
import byps.BTargetId;
import byps.BTransport;
import byps.RemoteException;


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
    if (targetId == null) {
      targetId = bout1.transport.getTargetId();
    }

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
