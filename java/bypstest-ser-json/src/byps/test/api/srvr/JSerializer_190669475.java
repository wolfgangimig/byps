package byps.test.api.srvr;

/*
 * Serializer for byps.test.api.srvr.BRequest_ServerIF_getClient
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
public class JSerializer_190669475 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_190669475();
	
	public JSerializer_190669475() {
		super(190669475);
	}
	
	public JSerializer_190669475(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)obj1;		
		bbuf.putInt("id", obj.id);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClient()));
		
		final BJsonObject js = bin.currentObject;
		obj.id = js.getInt("id");
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)(obj1);		
		
	}
	
}
