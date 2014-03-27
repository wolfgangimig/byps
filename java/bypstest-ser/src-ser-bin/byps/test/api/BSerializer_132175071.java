package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMap DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_132175071 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_132175071();
	
	public BSerializer_132175071() {
		super(132175071);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.Integer,java.util.List<java.lang.String>> map = new HashMap<java.lang.Integer,java.util.List<java.lang.String>>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer key = bbuf.getInt();
			java.util.List<java.lang.String> value = (java.util.List<java.lang.String>)bin.readObj(false, byps.test.api.BSerializer_2123584667.instance);
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.Integer,List<java.lang.String>> map = (Map<java.lang.Integer,List<java.lang.String>>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.Integer,java.util.List<java.lang.String>> obj : map.entrySet()) {
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putInt(obj.getKey() != null ? (Integer)obj.getKey() : 0);
			// checkpoint byps.gen.j.PrintContext:313
			bout.writeObj(obj.getValue(), false, byps.test.api.BSerializer_2123584667.instance);
		}
	}
	
}
