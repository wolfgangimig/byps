﻿//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInline
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1467243283 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1467243283();
		
		public BSerializer_1467243283()
			: base(1467243283) {}
		
		public BSerializer_1467243283(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, byps.test.api.BSerializer_827767075.instance);
			bout.writeObj(obj._arr3, false, byps.test.api.BSerializer_915212229.instance);
			bout.writeObj(obj._arr4, false, byps.test.api.BSerializer_949340697.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysInline()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (byps.test.api.inl.Point2D[,])bin.readObj(false, byps.test.api.BSerializer_827767075.instance);
			obj._arr3 = (byps.test.api.inl.Point2D[,,])bin.readObj(false, byps.test.api.BSerializer_915212229.instance);
			obj._arr4 = (byps.test.api.inl.Point2D[,,,])bin.readObj(false, byps.test.api.BSerializer_949340697.instance);
			
			return obj;
		}
		
	}
} // namespace