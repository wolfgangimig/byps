package com.wilutions.byps;

import java.util.ArrayList;

/**
 * This class describes a generated API.
 * The member values are taken from the BApi class in the 
 * interface definition folder (ILF). BApi describes the IDF and 
 * defines among others the name of the API.
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
	 * The interface version defined in the BApi class of the IDF.
	 */
	public final int version;
	
	/**
	 * Reserved.
	 */
	public final BBinaryModel bmodel;
	
	/**
	 * Reserved.
	 */
	public final boolean uniqueObjects;
	
	/**
	 * Registry of serialization classes.
	 */
	private final ArrayList<BRegistry> registries = new ArrayList<BRegistry>(2);
	
	private String protocols;
	
	public BApiDescriptor( 
			String name, String apiPack,
			BBinaryModel bmodel,
			int version,
			boolean uniqueObjects,
			String protocol,
			BRegistry registry
			) {
		super();
		this.name = name;
		this.basePackage = apiPack;
		this.version = version;
		this.bmodel = bmodel;
		this.uniqueObjects = uniqueObjects;
		this.protocols = protocol;
		this.registries.add(registry);
	}
	
	public void addProtocol(String protocol, BRegistry registry) {
		protocols += protocol;
		registries.add(registry);
	}
	
	public BRegistry getRegistry(BBinaryModel bmodel) {
		for (final BRegistry reg : registries) {
			if (bmodel == reg.bmodel) return reg;
		}
		throw new IllegalStateException("No registry for binary model=" + bmodel);
	}
	
	public BRegistry getRegistry() {
		return getRegistry(this.bmodel);
	}
	
	public String getProtocols() {
		return protocols;
	}
	
	@Override
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[name=").append(name).append(",package=").append(basePackage);
		sbuf.append(",version=").append(version).append(",binaryModel=").append(bmodel);
		sbuf.append(",uniqueObjects=").append(uniqueObjects);
		sbuf.append("]");
		return sbuf.toString();
	}
}
