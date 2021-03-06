﻿//
// Serializer for java.util.List<java.util.TreeSet<java.lang.Integer>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_724129228 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_724129228();
		
		public BSerializer_724129228() 
			: base(724129228) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<HashSet<int>> arr = new List<HashSet<int>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				HashSet<int> obj = (HashSet<int>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<HashSet<int>> arr = (IList<HashSet<int>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (HashSet<int> obj in arr) {
				bout.writeObj(obj, false, byps.test.api.BSerializer_855786668.instance);
			}
		}
		
	}
} // namespace
