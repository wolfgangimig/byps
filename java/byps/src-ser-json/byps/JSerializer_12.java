package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Collection;

import byps.BBufferJson;
import byps.BException;
import byps.BInput;
import byps.BInputJson;
import byps.BOutput;
import byps.BOutputJson;
import byps.BRegistry;
import byps.BSerializer;

public class JSerializer_12 extends BSerializer {

	public final static BSerializer instance = new JSerializer_12();
	
	public JSerializer_12() {
		super(BRegistry.TYPEID_LIST);
	}

	protected JSerializer_12(int typeId) {
		super(typeId);
	}

	protected Object internalReadElement(final BInputJson bin, final int idx) throws BException {
		return bin.readObj(idx, false, null);
	}

	protected void internalWriteElement(final BOutputJson bout, final Object obj) throws BException {
		bout.writeObj(null, obj, false, null);
	}
	
	@SuppressWarnings("rawtypes")
	protected Collection internalCreateList(int capacity) {
		return new ArrayList(capacity);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		BInputJson bin = ((BInputJson)bin1);
				
		// lengths
		final int n0 = bin.currentObject.size();

		// create list
		final Collection arr = internalCreateList(n0);
		bin.onObjectCreated(arr);
		
		// read
		for (int i = 0; i < n0; i++) {
			final Object obj = internalReadElement(bin, i);
			arr.add(obj);
		}

		return arr;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BOutputJson bout = ((BOutputJson)bout1);
		final Collection arr = (Collection) obj1;
		final BBufferJson bbuf = bout.bbuf;

		// write
		bbuf.beginArray();
		for (final Object obj : arr) {
			internalWriteElement(bout, obj);
		}
		bbuf.endArray();

	}

}
