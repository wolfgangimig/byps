package byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Integer>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerList DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_181681714 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_181681714();
	
	public BSerializer_181681714() {
		super(181681714);
	}
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<java.lang.Integer> arr = new ArrayList<java.lang.Integer>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer obj = bbuf.getInt();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<java.lang.Integer> arr = (java.util.List<java.lang.Integer>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Integer obj : arr) {
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putInt(obj != null ? (Integer)obj : 0);
		}
	}
	
}
