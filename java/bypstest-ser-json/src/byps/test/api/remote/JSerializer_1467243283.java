package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInline
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=3

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_1467243283 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1467243283();
	
	public JSerializer_1467243283() {
		super(1467243283);
	}
	
	public JSerializer_1467243283(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)obj1;		
		bout.writeObj("arr2",obj.arr2, false, byps.test.api.JSerializer_827767075.instance);
		bout.writeObj("arr3",obj.arr3, false, byps.test.api.JSerializer_915212229.instance);
		bout.writeObj("arr4",obj.arr4, false, byps.test.api.JSerializer_949340697.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysInline()));
		
		final BJsonObject js = bin.currentObject;
		obj.arr2 = (byps.test.api.inl.Point2D[][])bin.readObj("arr2", false, byps.test.api.JSerializer_827767075.instance);
		obj.arr3 = (byps.test.api.inl.Point2D[][][])bin.readObj("arr3", false, byps.test.api.JSerializer_915212229.instance);
		obj.arr4 = (byps.test.api.inl.Point2D[][][][])bin.readObj("arr4", false, byps.test.api.JSerializer_949340697.instance);
		
		return obj;
	}
	
}
