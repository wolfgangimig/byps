package byps.test.api.srvr;

/*
 * Serializer for byps.test.api.srvr.BRequest_ServerIF_setPartner
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
public class JSerializer_1332497686 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1332497686();
	
	public JSerializer_1332497686() {
		super(1332497686);
	}
	
	public JSerializer_1332497686(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)obj1;		
		bout.writeObj("client",obj.client, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_setPartner()));
		
		final BJsonObject js = bin.currentObject;
		obj.client = (byps.test.api.srvr.ClientIF)bin.readObj("client", false, null);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)(obj1);		
		bin.prepareForLazyLoading(obj.client, null);
		
	}
	
}
