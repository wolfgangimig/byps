package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_1355334613 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1355334613();
	
	public BSerializer_1355334613() {
		super(1355334613);
	}
	
	public BSerializer_1355334613(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.pointArray, false, byps.test.api.BSerializer_184101377.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray1dim()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.pointArray = (byps.test.api.inl.Point2D[])bin.readObj(false, byps.test.api.BSerializer_184101377.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)(obj1);		
		bin.prepareForLazyLoading(obj.pointArray, byps.test.api.BSerializer_184101377.instance);
		
	}
	
}
