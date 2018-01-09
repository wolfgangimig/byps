//
// Serializer for byps.test.api.prim.PrimitiveTypes[][][][]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_758319514 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_758319514();
		
		public BSerializer_758319514() : 
			base(758319514) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n3 = bbuf.getLength();
			int n2 = bbuf.getLength();
			int n1 = bbuf.getLength();
			int n0 = bbuf.getLength();
			
			// create array
			byps.test.api.prim.PrimitiveTypes[,,,] arr =  new byps.test.api.prim.PrimitiveTypes[n3,n2,n1,n0];
			
			// read
			for (int i3 = 0; i3 < n3; i3++) {
				for (int i2 = 0; i2 < n2; i2++) {
					for (int i1 = 0; i1 < n1; i1++) {
						for (int i0 = 0; i0 < n0; i0++) {
							arr[i3,i2,i1,i0] = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
						}
					}
				}
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			byps.test.api.prim.PrimitiveTypes[,,,] arr = (byps.test.api.prim.PrimitiveTypes[,,,])obj1;
			
			// lengths
			int n3 = arr.GetLength(0);
			int n2 = arr.GetLength(1);
			int n1 = arr.GetLength(2);
			int n0 = arr.GetLength(3);
			bbuf.putLength(n3);
			bbuf.putLength(n2);
			bbuf.putLength(n1);
			bbuf.putLength(n0);
			
			// write
			for (int i3 = 0; i3 < n3; i3++) {
				for (int i2 = 0; i2 < n2; i2++) {
					for (int i1 = 0; i1 < n1; i1++) {
						for (int i0 = 0; i0 < n0; i0++) {
							bout.writeObj(arr[i3,i2,i1,i0], false, null);
						}
					}
				}
			}
		}
		
	}
} // namespace
