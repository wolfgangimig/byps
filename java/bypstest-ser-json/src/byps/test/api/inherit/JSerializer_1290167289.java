package byps.test.api.inherit;

/*
 * Serializer for byps.test.api.inherit.BRequest_FruitService_squeeze
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
public class JSerializer_1290167289 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1290167289();
	
	public JSerializer_1290167289() {
		super(1290167289);
	}
	
	public JSerializer_1290167289(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_FruitService_squeeze obj = (BRequest_FruitService_squeeze)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_FruitService_squeeze()));
		
		return obj;
	}
	
}
