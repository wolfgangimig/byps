package byps;

import java.util.Map;
import java.util.Set;

import byps.BBufferJson;
import byps.BException;
import byps.BInput;
import byps.BInputJson;
import byps.BJsonObject;
import byps.BOutput;
import byps.BOutputJson;
import byps.BRegistry;
import byps.BSerializer;

public class JSerializer_13 extends BSerializer {

	public final static BSerializer instance = new JSerializer_13();

	public JSerializer_13() {
		super(BRegistry.TYPEID_MAP);
	}
	
	public JSerializer_13(int typeId) {
		super(typeId);
	}

	protected Object internalReadKey(final BInputJson bin, final String keyName) throws BException {
		return keyName;
	}

	protected Object internalReadValue(final BInputJson bin, final BJsonObject js, final String keyName) throws BException {
		throw new IllegalStateException("Subclass must override this method.");
	}

	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, Object key, Object value) throws BException {
		String keyName = (key instanceof String) ? ((String)key) : key.toString();
		bout.writeObj(keyName, value, false, null);
	}
	
	@SuppressWarnings("rawtypes")
	protected Map internalCreateMap(final int capacity) {
		return new java.util.HashMap(capacity);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = ((BInputJson)bin1);
		final BJsonObject js = bin.currentObject;

		final Set<String> keys = js.keys();
		final java.util.Map arr = internalCreateMap(keys.size());
		bin.onObjectCreated(arr);
		
		// read
		for (String keyName : keys) {
			final Object key = internalReadKey(bin, keyName);
			final Object value = internalReadValue(bin, js, keyName);
			arr.put(key, value);
		}

		return arr;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BOutputJson bout = ((BOutputJson)bout1);
		final java.util.Map arr = (java.util.Map) obj1;
		final BBufferJson bbuf = bout.bbuf;

		// write
		bbuf.beginObject();
		for (Object e : arr.entrySet()) {
			Map.Entry obj = (Map.Entry)e;
			internalWriteKeyValue(bout, bbuf, obj.getKey(), obj.getValue());
		}
		bbuf.endObject();
	}

}
