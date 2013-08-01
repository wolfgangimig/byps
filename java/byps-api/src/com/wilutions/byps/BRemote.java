package com.wilutions.byps;

/**
 * This interface has to be used as base for API interfaces. 
 */
public interface BRemote extends com.wilutions.byps.Remote {
	
	/**
	 * Gets the target ID.
	 * @return target ID
	 */
	BTargetId BRemote_getTargetId();
}
