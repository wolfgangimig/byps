package byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Integer>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_181681714 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_181681714();
	
	public JSerializer_181681714() {
		super(181681714);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<java.lang.Integer> arr = new ArrayList<java.lang.Integer>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer obj = bin.currentObject.getInt(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.lang.Integer> arr = (java.util.List<java.lang.Integer>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Integer obj : arr) {
			bbuf.putInt(obj != null ? (Integer)obj : 0);
		}
		bbuf.endArray();
	}
	
}
