package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setByte1
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
public class JSerializer_47373943 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_47373943();
	
	public JSerializer_47373943() {
		super(47373943);
	}
	
	public JSerializer_47373943(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)obj1;		
		bout.writeObj("byte1",obj.byte1, false, byps.test.api.JSerializer_1059148284.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setByte1()));
		
		final BJsonObject js = bin.currentObject;
		obj.byte1 = (java.util.List<java.lang.Byte>)bin.readObj("byte1", false, byps.test.api.JSerializer_1059148284.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)(obj1);		
		
	}
	
}
