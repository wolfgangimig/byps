package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Character,java.lang.Float>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMap DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_94341197 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_94341197();
	
	public BSerializer_94341197() {
		super(94341197);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.Character,java.lang.Float> map = new HashMap<java.lang.Character,java.lang.Float>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Character key = bbuf.getChar();
			java.lang.Float value = bbuf.getFloat();
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.Character,java.lang.Float> map = (Map<java.lang.Character,java.lang.Float>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.Character,java.lang.Float> obj : map.entrySet()) {
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putChar(obj.getKey() != null ? (Character)obj.getKey() : ((char)0));
			// checkpoint byps.gen.j.PrintContext:332
			bbuf.putFloat(obj.getValue() != null ? (Float)obj.getValue() : 0.0f);
		}
	}
	
}
