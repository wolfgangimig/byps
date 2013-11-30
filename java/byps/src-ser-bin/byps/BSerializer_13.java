package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Map;

import byps.BException;
import byps.BInput;
import byps.BInputBin;
import byps.BOutput;
import byps.BOutputBin;
import byps.BRegistry;
import byps.BSerializer;

public class BSerializer_13 extends BSerializer {

	public final static BSerializer instance = new BSerializer_13();

	public BSerializer_13() {
		super(BRegistry.TYPEID_MAP);
	}
	
	public BSerializer_13(int typeId) {
		super(typeId);
	}

	protected Object internalReadKey(final BInputBin bin) throws BException {
		return bin.readObj(false, null);
	}

	protected Object internalReadValue(final BInputBin bin) throws BException {
		return bin.readObj(false, null);
	}

	protected void internalWriteKeyValue(final BOutputBin bout, Object key, Object value) throws BException {
		bout.writeObj(key, false, null);
		bout.writeObj(value, false, null);
	}

	@SuppressWarnings("rawtypes")
	protected Map internalCreateMap(final int capacity) {
		return new java.util.HashMap(capacity);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = ((BInputBin)bin1);
		// lengths
		final int n0 = bin.bbuf.getLength();

		// create list
		final java.util.Map arr = internalCreateMap(n0);
		bin.onObjectCreated(arr);

		// read
		for (int i = 0; i < n0; i++) {
			final Object key = internalReadKey(bin);
			final Object value = internalReadValue(bin);
			arr.put(key, value);
		}

		return arr;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		final java.util.Map arr = (java.util.Map) obj1;

		// lengths
		final int n0 = arr.size();
		bout.bbuf.putLength(n0);

		// write
		for (Object e : arr.entrySet()) {
			Map.Entry obj = (Map.Entry)e;
			internalWriteKeyValue(bout, obj.getKey(), obj.getValue());
		}

	}

}
