package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.String,byps.test.api.inherit.Class1>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMap DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_2058676657 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_2058676657();
	
	public BSerializer_2058676657() {
		super(2058676657);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.String,byps.test.api.inherit.Class1> map = new HashMap<java.lang.String,byps.test.api.inherit.Class1>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.String key = bbuf.getString();
			byps.test.api.inherit.Class1 value = (byps.test.api.inherit.Class1)bin.readObj(false, null);
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.String,byps.test.api.inherit.Class1> map = (Map<java.lang.String,byps.test.api.inherit.Class1>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.String,byps.test.api.inherit.Class1> obj : map.entrySet()) {
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putString(obj.getKey() != null ? (String)obj.getKey() : "");
			// checkpoint byps.gen.j.PrintContext:313
			bout.writeObj(obj.getValue(), false, null);
		}
	}
	
}
