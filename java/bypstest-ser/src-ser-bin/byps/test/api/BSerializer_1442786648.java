package byps.test.api;

/*
 * Serializer for java.util.List<byps.test.api.refs.Node>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerList DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1442786648 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1442786648();
	
	public BSerializer_1442786648() {
		super(1442786648);
	}
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<byps.test.api.refs.Node> arr = new ArrayList<byps.test.api.refs.Node>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			byps.test.api.refs.Node obj = (byps.test.api.refs.Node)bin.readObj(false, null);
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<byps.test.api.refs.Node> arr = (java.util.List<byps.test.api.refs.Node>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (byps.test.api.refs.Node obj : arr) {
			bout.writeObj(obj, false, null);
		}
	}
	
}
