package com.wilutions.byps;

import java.util.HashMap;

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
	private final HashMap<BBinaryModel, BRegistry> registries = new HashMap<BBinaryModel, BRegistry>();
	
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
		registries.put(registry.bmodel, registry);
		return this;
	}
	
	public BRegistry getRegistry(BBinaryModel protocol) {
		BRegistry ret = registries.get(protocol);
		if (ret == null) {
			throw new IllegalStateException("No registry for protocol=" + protocol);
		}
		return ret;
	}
	
	public String getProtocolIds() {
		StringBuilder sbuf = new StringBuilder();
		for (BBinaryModel p : registries.keySet()) sbuf.append(p.getProtocolId());
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
