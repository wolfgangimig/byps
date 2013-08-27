﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.TreeSet<java.lang.Character>
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerList DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_936607009 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_936607009();
	
	public BSerializer_936607009() {
		super(936607009);
	}
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final TreeSet<java.lang.Character> arr = new TreeSet<java.lang.Character>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Character obj = bbuf.getChar();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, final long version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.TreeSet<java.lang.Character> arr = (java.util.TreeSet<java.lang.Character>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Character obj : arr) {
			bbuf.putChar(obj != null ? (Character)obj : ((char)0));
		}
	}
	
}
