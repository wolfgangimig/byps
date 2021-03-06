package byps.test.api;

/*
 * Serializer for byps.test.api.prim.PrimitiveTypes[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_2053507648 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_2053507648();
	
	public BSerializer_2053507648() {
		super(2053507648);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n0 = bbuf.getLength();
		
		// create array
		final byps.test.api.prim.PrimitiveTypes[] arr =  new byps.test.api.prim.PrimitiveTypes[n0];
		bin.onObjectCreated(arr);
		
		
		final byps.test.api.prim.PrimitiveTypes[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final byps.test.api.prim.PrimitiveTypes[] arr = (byps.test.api.prim.PrimitiveTypes[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		
		final byps.test.api.prim.PrimitiveTypes[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			// checkpoint byps.gen.j.PrintContext:340
			bout.writeObj(a0[i0], false, null);
		}
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		byps.test.api.prim.PrimitiveTypes[] arr = (byps.test.api.prim.PrimitiveTypes[])obj1;
		final int n0 = arr.length;
		
		final byps.test.api.prim.PrimitiveTypes[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			bin.prepareForLazyLoading(a0[i0], null);
		}
	}
	
}
