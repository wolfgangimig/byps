package byps;

import java.util.Collection;
import java.util.HashSet;

import byps.BRegistry;
import byps.BSerializer;

public class JSerializer_14 extends JSerializer_12 {

	public final static BSerializer instance = new JSerializer_14();

	public JSerializer_14() {
		super(BRegistry.TYPEID_SET);
	}

	public JSerializer_14(int typeId) {
		super(typeId);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Collection internalCreateList(int capacity) {
		return new HashSet(capacity);
	}
	
}