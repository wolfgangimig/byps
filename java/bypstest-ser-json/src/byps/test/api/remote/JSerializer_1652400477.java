package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteStreams_getSharedStream
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class JSerializer_1652400477 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1652400477();
	
	public JSerializer_1652400477() {
		super(1652400477);
	}
	
	public JSerializer_1652400477(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteStreams_getSharedStream obj = (BRequest_RemoteStreams_getSharedStream)obj1;		
		bbuf.putLong("id", obj.id);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteStreams_getSharedStream obj = (BRequest_RemoteStreams_getSharedStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getSharedStream()));
		
		final BJsonObject js = bin.currentObject;
		obj.id = js.getLong("id");
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_RemoteStreams_getSharedStream obj = (BRequest_RemoteStreams_getSharedStream)(obj1);		
		
	}
	
}
