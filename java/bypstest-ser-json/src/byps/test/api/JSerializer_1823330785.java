package byps.test.api;

/*
 * Serializer for java.util.List<java.util.List<byps.test.api.inl.Point2D>>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1823330785 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1823330785();
	
	public JSerializer_1823330785() {
		super(1823330785);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<List<byps.test.api.inl.Point2D>> arr = new ArrayList<List<byps.test.api.inl.Point2D>>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.util.List<byps.test.api.inl.Point2D> obj = (java.util.List<byps.test.api.inl.Point2D>)bin.readObj(i0, false, byps.test.api.JSerializer_2064980445.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.util.List<byps.test.api.inl.Point2D>> arr = (java.util.List<java.util.List<byps.test.api.inl.Point2D>>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.util.List<byps.test.api.inl.Point2D> obj : arr) {
			bout.writeObj(null, obj, false, byps.test.api.JSerializer_2064980445.instance);
		}
		bbuf.endArray();
	}
	
}
