package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DMap
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
public class JSerializer_646661333 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_646661333();
	
	public JSerializer_646661333() {
		super(646661333);
	}
	
	public JSerializer_646661333(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getPoint2DMap obj = (BRequest_RemoteInlineInstance_getPoint2DMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DMap()));
		
		return obj;
	}
	
}
