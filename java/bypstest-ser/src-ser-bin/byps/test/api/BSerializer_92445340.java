package byps.test.api;

/*
 * Serializer for byps.test.api.cons.HebrewZ[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_92445340 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_92445340();
	
	public BSerializer_92445340() {
		super(92445340);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n0 = bbuf.getLength();
		
		// create array
		final byps.test.api.cons.HebrewZ[] arr =  new byps.test.api.cons.HebrewZ[n0];
		bin.onObjectCreated(arr);
		
		// read
		final byps.test.api.cons.HebrewZ[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final byps.test.api.cons.HebrewZ[] arr = (byps.test.api.cons.HebrewZ[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		// write
		final byps.test.api.cons.HebrewZ[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			// checkpoint byps.gen.j.PrintContext:313
			bout.writeObj(a0[i0], false, null);
		}
	}
	
}
