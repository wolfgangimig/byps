package byps.test.api.cons;

/*
 * Serializer for byps.test.api.cons.ConfigResultOptionC
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=3

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_114832566 extends byps.BSerializer_22 {
	
	public final static BSerializer instance = new BSerializer_114832566();
	
	public BSerializer_114832566() {
		super(114832566);
	}
	
	public BSerializer_114832566(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final ConfigResultOptionC obj = (ConfigResultOptionC)obj1;		
		super.write(obj, bout1, version);		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final ConfigResultOptionC obj = (ConfigResultOptionC)(obj1 != null ? obj1 : bin.onObjectCreated(new ConfigResultOptionC()));
		
		// Read base class members
		super.read(obj, bin, version);
		
		final BBufferBin bbuf = bin.bbuf;
		
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		super.prepareForLazyLoading(obj1, bin, version);
		final ConfigResultOptionC obj = (ConfigResultOptionC)(obj1);		
		
	}
	
}
