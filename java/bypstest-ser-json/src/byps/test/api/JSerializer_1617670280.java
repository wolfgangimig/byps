package byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Boolean>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1617670280 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1617670280();
	
	public JSerializer_1617670280() {
		super(1617670280);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<java.lang.Boolean> arr = new ArrayList<java.lang.Boolean>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Boolean obj = bin.currentObject.getBoolean(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.lang.Boolean> arr = (java.util.List<java.lang.Boolean>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Boolean obj : arr) {
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putBoolean(obj != null ? (Boolean)obj : false);
		}
		bbuf.endArray();
	}
	
}
