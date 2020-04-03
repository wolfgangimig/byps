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

	/**
	 * Assign the current BClient object to the given object.
	 * @param obj Object to be prepared
	 * @param ser Serializer for the object or null
	 * @throws BException
	 */
  public void prepareForLazyLoading(Object obj, BSerializer ser) throws BException {

    if (obj != null) {

      // Memorize the object to avoid recursion.
      Integer dummyValue = Integer.valueOf(0);
      if (idMap.putIfAbsent(System.identityHashCode(obj), dummyValue) == null) {

        // Get serializer object if not supplied.
        if (ser == null) {
          ser = registry.getSerializer(obj, true);
        }

        // Assign  
        ser.prepareForLazyLoading(obj, this, header.version);
      }
    }
  }
	
}
