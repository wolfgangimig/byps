package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_462631448 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_462631448();
	
	public JSerializer_462631448() {
		super(462631448);
	}
	
	public JSerializer_462631448(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setInt1 obj = (BRequest_RemoteSetTypes_setInt1)obj1;		
		bout.writeObj("int1",obj.int1, false, byps.test.api.JSerializer_1493282670.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setInt1 obj = (BRequest_RemoteSetTypes_setInt1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setInt1()));
		
		final BJsonObject js = bin.currentObject;
		obj.int1 = (java.util.Set<java.lang.Integer>)bin.readObj("int1", false, byps.test.api.JSerializer_1493282670.instance);
		
		return obj;
	}
	
}
