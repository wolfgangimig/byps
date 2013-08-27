//
// Serializer for com.wilutions.byps.test.api.cons.AllTypesC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.cons
{
	
	public class BSerializer_930294276 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_930294276();
		
		public BSerializer_930294276()
			: base(930294276) {}
		
		public BSerializer_930294276(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: bool1s */ + 4			
			       /* pos=4: bool2s */ + 4			
			       /* pos=8: byte1s */ + 1			
			       /* padding */ + 1			
			       /* pos=10: char1s */ + 2			
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
			       /* pos=72: arrALL */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			AllTypesC obj = (AllTypesC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			AllTypesC obj = (AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesC()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
