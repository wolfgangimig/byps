package byps.test.api;

/*
 * Serializer for java.util.List<byps.test.api.inl.Point2D>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_2064980445 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_2064980445();
	
	public JSerializer_2064980445() {
		super(2064980445);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<byps.test.api.inl.Point2D> arr = new ArrayList<byps.test.api.inl.Point2D>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			byps.test.api.inl.Point2D obj = (byps.test.api.inl.Point2D)bin.readObj(i0, false, byps.test.api.inl.JSerializer_1835035436.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<byps.test.api.inl.Point2D> arr = (java.util.List<byps.test.api.inl.Point2D>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (byps.test.api.inl.Point2D obj : arr) {
			// checkpoint byps.gen.j.PrintContext:327
			bout.writeObj(null, obj, false, byps.test.api.inl.JSerializer_1835035436.instance);
		}
		bbuf.endArray();
	}
	
}
