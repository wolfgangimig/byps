package byps.test.api;

/*
 * Serializer for float[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_766441794 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_766441794();
	
	public BSerializer_766441794() {
		super(766441794);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n0 = bbuf.getLength();
		
		// create array
		final float[] arr =  new float[n0];
		bin.onObjectCreated(arr);
		
		
		final float[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bbuf.getFloat();
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final float[] arr = (float[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		
		final float[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			// checkpoint byps.gen.j.PrintContext:370
			bbuf.putFloat(a0[i0]);
		}
	}
	
}
