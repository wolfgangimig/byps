package byps.test.api;

/*
 * Serializer for byps.test.api.cons.AllTypesZ[][]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_81775365 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_81775365();
	
	public BSerializer_81775365() {
		super(81775365);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n1 = bbuf.getLength();
		final int n0 = bbuf.getLength();
		
		// create array
		final byps.test.api.cons.AllTypesZ[][] arr =  new byps.test.api.cons.AllTypesZ[n1][n0];
		bin.onObjectCreated(arr);
		
		// read
		final byps.test.api.cons.AllTypesZ[][] a1 = arr;
		for (int i1 = 0; i1 < n1; i1++) {
			final byps.test.api.cons.AllTypesZ[] a0 = a1[i1];
			for (int i0 = 0; i0 < n0; i0++) {
				a0[i0] = (byps.test.api.cons.AllTypesZ)bin.readObj(false, null);
			}
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final byps.test.api.cons.AllTypesZ[][] arr = (byps.test.api.cons.AllTypesZ[][])obj1;
		
		// lengths
		final int n1 = arr.length;
		final int n0 = n1!=0 ? arr[0].length : 0;
		bbuf.putLength(n1);
		bbuf.putLength(n0);
		
		// write
		final byps.test.api.cons.AllTypesZ[][] a1 = arr;
		for (int i1 = 0; i1 < n1; i1++) {
			final byps.test.api.cons.AllTypesZ[] a0 = a1[i1];
			for (int i0 = 0; i0 < n0; i0++) {
				bout.writeObj(a0[i0], false, null);
			}
		}
	}
	
}
