//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_862752254 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_862752254();
		
		public BSerializer_862752254()
			: base(862752254) {}
		
		public BSerializer_862752254(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: bool1s */ + 4			
			       /* pos=4: bool2s */ + 4			
			       /* pos=8: char1s */ + 2			
			       /* padding */ + 2			
			       /* pos=12: stringNull */ + 4			
			       /* pos=16: char2s */ + 2			
			       /* pos=18: short1s */ + 2			
			       /* pos=20: int1s */ + 4			
			       /* pos=24: long1s */ + 8			
			       /* pos=32: float1s */ + 4			
			       /* padding */ + 4			
			       /* pos=40: double1s */ + 8			
			       /* pos=48: string1s */ + 4			
			       /* pos=52: ALL */ + 4			
			       /* pos=56: arrInt */ + 4			
			       /* pos=60: arrInt4 */ + 4			
			       /* pos=64: arrStrings */ + 4			
			       /* pos=68: arrStrings4 */ + 4			
			       /* pos=72: arrAll */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj._bool1s);
			bbuf.putBoolean(obj._bool2s);
			bbuf.putChar(obj._char1s);
			bbuf.putChar(obj._char2s);
			bbuf.putDouble(obj._double1s);
			bbuf.putFloat(obj._float1s);
			bbuf.putInt(obj._int1s);
			bbuf.putLong(obj._long1s);
			bbuf.putShort(obj._short1s);
			bbuf.putString(obj._string1s);
			bbuf.putString(obj._stringNull);
			bout.writeObj(obj._ALL, false, null);
			bout.writeObj(obj._arrAll, false, com.wilutions.byps.test.api.BSerializer_1981543076.instance);
			bout.writeObj(obj._arrInt, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj._arrInt4, false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			bout.writeObj(obj._arrStrings, true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			bout.writeObj(obj._arrStrings4, true, com.wilutions.byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_AllTypesC()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._bool1s = bbuf.getBoolean();
			obj._bool2s = bbuf.getBoolean();
			obj._char1s = bbuf.getChar();
			obj._char2s = bbuf.getChar();
			obj._double1s = bbuf.getDouble();
			obj._float1s = bbuf.getFloat();
			obj._int1s = bbuf.getInt();
			obj._long1s = bbuf.getLong();
			obj._short1s = bbuf.getShort();
			obj._string1s = bbuf.getString();
			obj._stringNull = bbuf.getString();
			obj._ALL = (com.wilutions.byps.test.api.cons.AllTypesZ)bin.readObj(false, null);
			obj._arrAll = (com.wilutions.byps.test.api.cons.AllTypesZ[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1981543076.instance);
			obj._arrInt = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj._arrInt4 = (int[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			obj._arrStrings = (String[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			obj._arrStrings4 = (String[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
