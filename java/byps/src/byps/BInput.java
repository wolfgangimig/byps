package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.util.HashMap;



public abstract class BInput {
	
	public final BMessageHeader header;
	public final BTransport transport;
	public final BRegistry registry;
	protected final HashMap<Integer,Object> idMap;
	protected Integer currentId;
	
	public BInput(BMessageHeader header, BTransport transport, BRegistry registry) {
		super();
		this.header = header != null ? header : new BMessageHeader();
		this.transport = transport;
		this.registry = registry;
		this.idMap = new HashMap<Integer,Object>();
	}
	
	public abstract Object load() throws BException;
	
	public Object onObjectCreated(Object obj) {
		if (currentId != null) {
			idMap.put(currentId, obj);
		}
		
    if (obj instanceof BValueClass) {
      ((BValueClass)obj).setBypsClient(transport.clientHelperToInjectInBValueClass);
    }

		return obj;
	}

	
}
