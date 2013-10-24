package byps.test.api;

/*
 * Serializer for byte[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArrayJson DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class JSerializer_1374008726 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_1374008726();
	
	public JSerializer_1374008726() {
		super(1374008726);
	}
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final byte[] arr =  new byte[n0];
		bin.onObjectCreated(arr);
		
		// read
		final byte[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bin.currentObject.getByte(i0);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final byte[] arr = (byte[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final byte[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putByte(a0[i0]);
		}
		bbuf.endArray();
	}
	
}
