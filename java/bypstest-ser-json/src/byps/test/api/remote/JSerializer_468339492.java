package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteStreams_putSharedStream
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class JSerializer_468339492 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_468339492();
	
	public JSerializer_468339492() {
		super(468339492);
	}
	
	public JSerializer_468339492(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteStreams_putSharedStream obj = (BRequest_RemoteStreams_putSharedStream)obj1;		
		bbuf.putLong("id", obj.id);
		bout.writeObj("stream",obj.stream, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteStreams_putSharedStream obj = (BRequest_RemoteStreams_putSharedStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_putSharedStream()));
		
		final BJsonObject js = bin.currentObject;
		obj.id = js.getLong("id");
		obj.stream = (java.io.InputStream)bin.readObj("stream", false, null);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_RemoteStreams_putSharedStream obj = (BRequest_RemoteStreams_putSharedStream)(obj1);		
		bin.prepareForLazyLoading(obj.stream, null);
		
	}
	
}
