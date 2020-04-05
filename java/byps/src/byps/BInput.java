package byps;

import java.util.Arrays;

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
		this.idMap = new HashMap<Integer,Object>(1000000);
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
      if (putHashCode(System.identityHashCode(obj))) {

        // Get serializer object if not supplied.
        if (ser == null) {
          ser = registry.getSerializer(obj, true);
        }

        // Assign  
        ser.prepareForLazyLoading(obj, this, header.version);
      }
    }
  }
	
  private int[] hashCodes = new int[1000];
  private int hashCodesLength = 0;
  
  private boolean putHashCode(int hc) {
    
    int index = Arrays.binarySearch(hashCodes, 0, hashCodesLength, hc);
    if (index >= 0) return false;
    
    // binarySearch returns ((-insertAt) - 1) if the code is not found.
    
    int insertAt = - (index + 1);
    
    if (hashCodesLength < hashCodes.length) {
      System.arraycopy(hashCodes, insertAt, hashCodes, insertAt+1, hashCodesLength - insertAt);
      hashCodes[insertAt] = hc;
    }
    else {
      int[] newArray = new int[hashCodes.length * 2];
      System.arraycopy(hashCodes, 0, newArray, 0, insertAt);
      newArray[insertAt] = hc;
      if (insertAt < hashCodesLength) {
        System.arraycopy(hashCodes, insertAt, newArray, insertAt+1, hashCodesLength - insertAt);
      }
      hashCodes = newArray;
    }
    
    hashCodesLength++;
    return true;
  }

  
}
