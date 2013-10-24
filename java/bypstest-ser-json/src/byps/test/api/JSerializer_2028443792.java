package byps.test.api;

/*
 * Serializer for java.util.Set<java.lang.Short>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_2028443792 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_2028443792();
	
	public JSerializer_2028443792() {
		super(2028443792);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final HashSet<java.lang.Short> arr = new HashSet<java.lang.Short>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Short obj = bin.currentObject.getShort(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.Set<java.lang.Short> arr = (java.util.Set<java.lang.Short>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Short obj : arr) {
			bbuf.putShort(obj != null ? (Short)obj : ((short)0));
		}
		bbuf.endArray();
	}
	
}
