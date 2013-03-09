﻿package com.wilutions.byps.test.api;

/*
 * Serializer for short[][][][]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1859644668 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_1859644668();
	
	public JSerializer_1859644668() {
		super(1859644668);
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
		
		final short[][][][] arr =  new short[n3][n2][n1][n0];
		bin.onObjectCreated(arr);
		
		// read
		final short[][][][] a3 = arr;
		for (int i3 = 0; i3 < n3; i3++) {
			final short[][][] a2 = a3[i3];
			final BJsonObject js2 = js3.getJsonObject(i3);
			for (int i2 = 0; i2 < n2; i2++) {
				final short[][] a1 = a2[i2];
				final BJsonObject js1 = js2.getJsonObject(i2);
				for (int i1 = 0; i1 < n1; i1++) {
					final short[] a0 = a1[i1];
					bin.currentObject = js1.getJsonObject(i1);
					for (int i0 = 0; i0 < n0; i0++) {
						a0[i0] = bin.currentObject.getShort(i0);
					}
				}
			}
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final short[][][][] arr = (short[][][][])obj1;
		
		// lengths
		final int n3 = arr.length;
		final int n2 = n3!=0 ? arr[0].length : 0;
		final int n1 = n2!=0 ? arr[0][0].length : 0;
		final int n0 = n1!=0 ? arr[0][0][0].length : 0;
		
		// write
		final short[][][][] a3 = arr;
		bbuf.beginArray();
		for (int i3 = 0; i3 < n3; i3++) {
			final short[][][] a2 = a3[i3];
			bbuf.beginArray();
			for (int i2 = 0; i2 < n2; i2++) {
				final short[][] a1 = a2[i2];
				bbuf.beginArray();
				for (int i1 = 0; i1 < n1; i1++) {
					final short[] a0 = a1[i1];
					bbuf.beginArray();
					for (int i0 = 0; i0 < n0; i0++) {
						bbuf.putShort(a0[i0]);
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