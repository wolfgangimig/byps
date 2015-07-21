package byps.test.api;

/*
 * Serializer for java.util.Set<byps.test.api.prim.PrimitiveTypes>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerList DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_673917574 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_673917574();
	
	public BSerializer_673917574() {
		super(673917574);
	}
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final HashSet<byps.test.api.prim.PrimitiveTypes> arr = new HashSet<byps.test.api.prim.PrimitiveTypes>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			byps.test.api.prim.PrimitiveTypes obj = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.Set<byps.test.api.prim.PrimitiveTypes> arr = (java.util.Set<byps.test.api.prim.PrimitiveTypes>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (byps.test.api.prim.PrimitiveTypes obj : arr) {
			// checkpoint byps.gen.j.PrintContext:327
			bout.writeObj(obj, false, null);
		}
	}
	
}
