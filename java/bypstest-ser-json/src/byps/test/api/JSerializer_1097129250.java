package byps.test.api;

/*
 * Serializer for long[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArrayJson DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class JSerializer_1097129250 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_1097129250();
	
	public JSerializer_1097129250() {
		super(1097129250);
	}
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final long[] arr =  new long[n0];
		bin.onObjectCreated(arr);
		
		// read
		final long[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bin.currentObject.getLong(i0);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final long[] arr = (long[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final long[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			// checkpoint byps.gen.j.PrintContext:343
			bbuf.putLong(a0[i0]);
		}
		bbuf.endArray();
	}
	
}
