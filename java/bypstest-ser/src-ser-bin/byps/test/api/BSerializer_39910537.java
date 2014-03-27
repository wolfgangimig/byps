package byps.test.api;

/*
 * Serializer for int[][][][]
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_39910537 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_39910537();
	
	public BSerializer_39910537() {
		super(39910537);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n3 = bbuf.getLength();
		final int n2 = bbuf.getLength();
		final int n1 = bbuf.getLength();
		final int n0 = bbuf.getLength();
		
		// create array
		final int[][][][] arr =  new int[n3][n2][n1][n0];
		bin.onObjectCreated(arr);
		
		// read
		final int[][][][] a3 = arr;
		for (int i3 = 0; i3 < n3; i3++) {
			final int[][][] a2 = a3[i3];
			for (int i2 = 0; i2 < n2; i2++) {
				final int[][] a1 = a2[i2];
				for (int i1 = 0; i1 < n1; i1++) {
					final int[] a0 = a1[i1];
					for (int i0 = 0; i0 < n0; i0++) {
						a0[i0] = bbuf.getInt();
					}
				}
			}
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final long version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final int[][][][] arr = (int[][][][])obj1;
		
		// lengths
		final int n3 = arr.length;
		final int n2 = n3!=0 ? arr[0].length : 0;
		final int n1 = n2!=0 ? arr[0][0].length : 0;
		final int n0 = n1!=0 ? arr[0][0][0].length : 0;
		bbuf.putLength(n3);
		bbuf.putLength(n2);
		bbuf.putLength(n1);
		bbuf.putLength(n0);
		
		// write
		final int[][][][] a3 = arr;
		for (int i3 = 0; i3 < n3; i3++) {
			final int[][][] a2 = a3[i3];
			for (int i2 = 0; i2 < n2; i2++) {
				final int[][] a1 = a2[i2];
				for (int i1 = 0; i1 < n1; i1++) {
					final int[] a0 = a1[i1];
					for (int i0 = 0; i0 < n0; i0++) {
						// checkpoint byps.gen.j.PrintContext:343
						bbuf.putInt(a0[i0]);
					}
				}
			}
		}
	}
	
}
