package com.wilutions.byps.gen.j;

import com.wilutions.byps.gen.api.GeneratorProperties;

/**
 * Properties for Java code generation.
 */
@SuppressWarnings("serial")
public class PropertiesJ extends GeneratorProperties {
	
	/**
	 * Prefix for Java generator options.
	 */
	public final static String OPT_PREFIX = "-genj.";
	
	/**
	 * Destination directory for API classes.
	 * Optional.
	 * If not set, API classes are not generated.
	 * Usually, the API classes of the source directory are used.
	 */
	public final static String DEST_DIR_API = "-genj.dir-api";
	
	/**
	 * Destination directory for serialization classes.
	 * Optional.
	 * If not set, DEST_DIR_SER is used.
	 */
	public final static String DEST_DIR_SER_BIN = "-genj.dir-ser-bin";
	
	/**
	 * Destination directory for serialization classes of the JSON protocol.
	 * Optional.
	 * If not set, DEST_DIR_SER is used. 
	 */
	public final static String DEST_DIR_SER_Json = "-genj.dir-ser-json";
	
	/**
	 * Destination directory for serialization classes used by binary and JSON protocol.
	 * Mandatory.
	 */
	public final static String DEST_DIR_SER = "-genj.dir-ser";

	/**
	 * Generate functions hashCode and equals.
	 * Experimental, not tested.
	 */
	public final static String HASHCODE_AND_EQUALS = "-genj.hasheq";
	
	/**
	 * Constructor
	 * @param defaultProps General properties used by all code generators.
	 */
	public PropertiesJ(GeneratorProperties defaultProps) {
		super(defaultProps);
	}
	

}
