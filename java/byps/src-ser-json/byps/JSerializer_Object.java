package byps;

import java.nio.BufferUnderflowException;

import byps.BBufferJson;
import byps.BException;
import byps.BInput;
import byps.BInputJson;
import byps.BOutput;
import byps.BOutputJson;
import byps.BSerializer;

public abstract class JSerializer_Object extends BSerializer {
	
	protected JSerializer_Object(int typeId, boolean inlineInstance) {
		super(typeId, inlineInstance);
	}

	protected JSerializer_Object(int typeId) {
		this(typeId, false);
	}

	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputJson bout = (BOutputJson)bout1;
		final BBufferJson bbuf = (BBufferJson)bout.bbuf;
		bbuf.beginObject();
		if (!inlineInstance) {
			bbuf.putInt("_typeId", typeId);
		}
		internalWrite(obj1, bout, bbuf);
		bbuf.endObject();
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException, BufferUnderflowException {
		final BInputJson bin = (BInputJson)bin1;
		return internalRead(obj1, bin);
	}

	protected void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		// BResult_ classes do not need a write function
	}

	protected abstract Object internalRead(final Object obj1, final BInputJson bin) throws BException;
}
