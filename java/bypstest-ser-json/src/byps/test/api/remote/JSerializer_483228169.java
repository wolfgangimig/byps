package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
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
public class JSerializer_483228169 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_483228169();
	
	public JSerializer_483228169() {
		super(483228169);
	}
	
	public JSerializer_483228169(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_getPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_getPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes()));
		
		return obj;
	}
	
}
