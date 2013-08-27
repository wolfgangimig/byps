package com.wilutions.byps;

/**
 * This interface provides functions used in the test suite.
 * An object implementing this interface is available by the {@link BWire#getTestAdapter()} function.
 */
public interface BTestAdapter {

	/**
	 * Return the list of files in the temporary directory of the server.
	 * @return
	 */
	String[] getServerTempFiles();
	
	/**
	 * Print a line into the server log file.
	 * @param line
	 */
	void printServerLog(String line);
	
	/**
	 * Return the IDs of the currently active messages on the server.
	 * @param inclLongPolls
	 * @return
	 */
	long[] getAcitveMessagesOnServer(boolean inclLongPolls);
	
	/**
	 * Kill all connections opened by wire that owns this object. 
	 */
	void killClientConnections();
	
	/**
	 * Set the servers application version.
	 * This is used to check that client and server classes can have different versions.
	 * @param version
	 */
	void setServerAppVersion(long version);
	
}
