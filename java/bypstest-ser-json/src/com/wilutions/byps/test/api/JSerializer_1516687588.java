﻿package com.wilutions.byps.test.api;

/*
 * Serializer for float[][][][]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1516687588 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_1516687588();
	
	public JSerializer_1516687588() {
		super(1516687588);
	}
	
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js3 = bin.currentObject;
		
		int n3 = 0, n2 = 0, n1 = 0, n0 = 0;
		n3 = js3 != null ? js3.size() : 0;
		if (n3 != 0) {
			final BJsonObject js2 = js3.getJsonObject(0);
			n2 = js2 != null ? js2.size() : 0;
			if (n2 != 0) {
				final BJsonObject js1 = js2.getJsonObject(0);
				n1 = js1 != null ? js1.size() : 0;
				if (n1 != 0) {
					final BJsonObject js0 = js1.getJsonObject(0);
					n0 = js0 != null ? js0.size() : 0;
				}
			}
		}
		
		final float[][][][] arr =  new float[n3][n2][n1][n0];
		bin.onObjectCreated(arr);
		
		// read
		final float[][][][] a3 = arr;
		for (int i3 = 0; i3 < n3; i3++) {
			final float[][][] a2 = a3[i3];
			final BJsonObject js2 = js3.getJsonObject(i3);
			for (int i2 = 0; i2 < n2; i2++) {
				final float[][] a1 = a2[i2];
				final BJsonObject js1 = js2.getJsonObject(i2);
				for (int i1 = 0; i1 < n1; i1++) {
					final float[] a0 = a1[i1];
					bin.currentObject = js1.getJsonObject(i1);
					for (int i0 = 0; i0 < n0; i0++) {
						a0[i0] = bin.currentObject.getFloat(i0);
					}
				}
			}
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final float[][][][] arr = (float[][][][])obj1;
		
		// lengths
		final int n3 = arr.length;
		final int n2 = n3!=0 ? arr[0].length : 0;
		final int n1 = n2!=0 ? arr[0][0].length : 0;
		final int n0 = n1!=0 ? arr[0][0][0].length : 0;
		
		// write
		final float[][][][] a3 = arr;
		bbuf.beginArray();
		for (int i3 = 0; i3 < n3; i3++) {
			final float[][][] a2 = a3[i3];
			bbuf.beginArray();
			for (int i2 = 0; i2 < n2; i2++) {
				final float[][] a1 = a2[i2];
				bbuf.beginArray();
				for (int i1 = 0; i1 < n1; i1++) {
					final float[] a0 = a1[i1];
					bbuf.beginArray();
					for (int i0 = 0; i0 < n0; i0++) {
						bbuf.putFloat(a0[i0]);
					}
					bbuf.endArray();
				}
				bbuf.endArray();
			}
			bbuf.endArray();
		}
		bbuf.endArray();
	}
	
}