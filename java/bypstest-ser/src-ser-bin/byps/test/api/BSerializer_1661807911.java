package byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Character>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerList DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1661807911 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1661807911();
	
	public BSerializer_1661807911() {
		super(1661807911);
	}
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<java.lang.Character> arr = new ArrayList<java.lang.Character>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Character obj = bbuf.getChar();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<java.lang.Character> arr = (java.util.List<java.lang.Character>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Character obj : arr) {
			// checkpoint byps.gen.j.PrintContext:359
			bbuf.putChar(obj != null ? (Character)obj : ((char)0));
		}
	}
	
}
