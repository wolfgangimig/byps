package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_600892860 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_600892860();
	
	public JSerializer_600892860() {
		super(600892860);
	}
	
	public JSerializer_600892860(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getActor obj = (BRequest_RemoteInlineInstance_getActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getActor()));
		
		return obj;
	}
	
}
