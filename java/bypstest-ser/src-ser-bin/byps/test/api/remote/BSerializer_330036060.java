package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysClass
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=3

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_330036060 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_330036060();
	
	public BSerializer_330036060() {
		super(330036060);
	}
	
	public BSerializer_330036060(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.arr2, false, byps.test.api.BSerializer_2030857950.instance);
		bout.writeObj(obj.arr3, false, byps.test.api.BSerializer_1739334652.instance);
		bout.writeObj(obj.arr4, false, byps.test.api.BSerializer_758319514.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysClass()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.arr2 = (byps.test.api.prim.PrimitiveTypes[][])bin.readObj(false, byps.test.api.BSerializer_2030857950.instance);
		obj.arr3 = (byps.test.api.prim.PrimitiveTypes[][][])bin.readObj(false, byps.test.api.BSerializer_1739334652.instance);
		obj.arr4 = (byps.test.api.prim.PrimitiveTypes[][][][])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)(obj1);		
		bin.prepareForLazyLoading(obj.arr2, byps.test.api.BSerializer_2030857950.instance);
		bin.prepareForLazyLoading(obj.arr3, byps.test.api.BSerializer_1739334652.instance);
		bin.prepareForLazyLoading(obj.arr4, byps.test.api.BSerializer_758319514.instance);
		
	}
	
}
