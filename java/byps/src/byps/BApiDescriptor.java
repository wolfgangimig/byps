package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */


/**
 * This class describes a generated API.
 * The member values are taken from the BApi class that has to be defined
 * in one of the packages of the API.
 * The BApi class defines the interface name and the interface version.
 * The generator creates a class named BApiDescriptor_name which 
 * holds a singleton object of type BApiDescriptor.   
 */
public class BApiDescriptor {
	
	/**
	 * API name.
	 * This name is used as a suffix for several generated classes, 
	 * BClient_name, BServer_name, BApiDescriptor_name.
	 * 
	 */
	public final String name;
	
	/**
	 * Base package.
	 * The classes generated to serialize arrays and collection types
	 * are members of this package. 
	 */
	public final String basePackage;
	
	/**
	 * API interface version.
	 */
	public final long version;
	
	/**
	 * Reserved.
	 */
	public final boolean uniqueObjects;
	
	/**
	 * Registry of serialization classes.
	 */
	private final BRegistryCollection binaryRegistry = new BRegistryCollection(BBinaryModel.MEDIUM);
	private final BRegistryCollection jsonRegistry = new BRegistryCollection(BBinaryModel.JSON);
	
	public BApiDescriptor( 
			String name, String apiPack,
			long version,
			boolean uniqueObjects
			) {
		super();
		this.name = name;
		this.basePackage = apiPack;
		this.version = version;
		this.uniqueObjects = uniqueObjects;
	}
	
	/**
	 * Add a serialization protocol.
	 * @param protocol Protocol specifier. 
	 * @param registry
	 * @see BNegotiate#BINARY_STREAM
	 * @see BNegotiate#JSON
	 */
	public BApiDescriptor addRegistry(BRegistry registry) {
	  if (registry != null) {
  	  if (binaryRegistry.bmodel == registry.bmodel) {
  	    binaryRegistry.add(registry);
  	  }
  	  else {
  	    jsonRegistry.add(registry);
  	  }
	  }
		return this;
	}
	
	public BRegistry getRegistry(BBinaryModel protocol) {
	  BRegistry ret = null;
	  if (protocol == binaryRegistry.bmodel) {
	    ret = binaryRegistry;
	  }
	  else if (protocol == jsonRegistry.bmodel) {
	    ret = jsonRegistry;
	  }
		if (ret == null) {
			throw new IllegalStateException("No registry for protocol=" + protocol);
		}
		return ret;
	}
	
	public String getProtocolIds() {
		StringBuilder sbuf = new StringBuilder();
		// First: optimized binary protocol
    if (!binaryRegistry.isEmpty()) sbuf.append(BBinaryModel.MEDIUM.getProtocolId());
    // Last: fallback to JSON
    if (!jsonRegistry.isEmpty()) sbuf.append(BBinaryModel.JSON.getProtocolId());
		return sbuf.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[name=").append(name).append(",package=").append(basePackage);
		sbuf.append(",version=").append(version);
		sbuf.append(",uniqueObjects=").append(uniqueObjects);
		sbuf.append("]");
		return sbuf.toString();
	}
}
