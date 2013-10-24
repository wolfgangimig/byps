//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_677876863 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_677876863();
		
		public BSerializer_677876863()
			: base(677876863) {}
		
		public BSerializer_677876863(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj._b);
			bbuf.putChar(obj._c);
			bbuf.putDouble(obj._d);
			bbuf.putFloat(obj._f);
			bbuf.putInt(obj._i);
			bbuf.putLong(obj._l);
			bbuf.putShort(obj._s);
			bbuf.putString(obj._str);
			bout.writeObj(obj._o, false, null);
			bout.writeObj(obj._pt, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_sendAllTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._b = bbuf.getBoolean();
			obj._c = bbuf.getChar();
			obj._d = bbuf.getDouble();
			obj._f = bbuf.getFloat();
			obj._i = bbuf.getInt();
			obj._l = bbuf.getLong();
			obj._s = bbuf.getShort();
			obj._str = bbuf.getString();
			obj._o = (Object)bin.readObj(false, null);
			obj._pt = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
