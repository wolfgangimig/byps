package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Collection;
import java.util.HashSet;

import byps.BException;
import byps.BInput;
import byps.BRegistry;
import byps.BSerializer;

public class BSerializer_14 extends BSerializer_12 {

	public final static BSerializer instance = new BSerializer_14();

	public BSerializer_14() {
		super(BRegistry.TYPEID_SET);
	}

	public BSerializer_14(int typeId) {
		super(typeId);
	}

	@Override
	public Collection<Object> internalCreate(final BInput bin1) throws BException {
		return new HashSet<Object>();
	}
	
	
}