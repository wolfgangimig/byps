package byps.test.api.cons;

/*
 * Serializer for byps.test.api.cons.AllTypesC
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=18

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_930294276 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_930294276();
	
	public BSerializer_930294276() {
		super(930294276);
	}
	
	public BSerializer_930294276(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final AllTypesC obj = (AllTypesC)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final AllTypesC obj = (AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesC()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		
		return obj;
	}
	
}
