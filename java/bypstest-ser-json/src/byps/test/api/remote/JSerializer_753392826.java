package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setString1
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
public class JSerializer_753392826 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_753392826();
	
	public JSerializer_753392826() {
		super(753392826);
	}
	
	public JSerializer_753392826(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setString1 obj = (BRequest_RemoteSetTypes_setString1)obj1;		
		bout.writeObj("string1",obj.string1, false, byps.test.api.JSerializer_1888799711.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setString1 obj = (BRequest_RemoteSetTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setString1()));
		
		final BJsonObject js = bin.currentObject;
		obj.string1 = (java.util.Set<java.lang.String>)bin.readObj("string1", false, byps.test.api.JSerializer_1888799711.instance);
		
		return obj;
	}
	
}