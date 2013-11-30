package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BTestAdapter;


public class HTestAdapter implements BTestAdapter {
	
	public HTestAdapter(HWireClient wire) {
		this.wire = wire;
	}
	
	@Override
	public String[] getServerTempFiles() {
		String list = wire.testAdapter(HTestAdapter.TEMP_FILES, null).trim();
		return list.length() != 0 ? list.split("\n") : new String[0];
	}
	
	@Override
	public void printServerLog(String line) {
		wire.testAdapter(HTestAdapter.PRINT_LOG, new String[] {
				HTestAdapter.PRINT_LOG_LINE + "=" + line
		});
	}
	
	@Override
	public long[] getAcitveMessagesOnServer(boolean inclLongPolls) {
		String list = wire.testAdapter(HTestAdapter.ACTIVE_MESSAGES, new String[] { 
				HTestAdapter.INCL_LONG_POLLS + "=" + inclLongPolls } )
				.trim();
		if (list.length() == 0) return new long[0];
		String[] messageStrs = list.split("\n");
		long[] messageIds = new long[messageStrs.length];
		for (int i = 0; i < messageStrs.length; i++) {
			messageIds[i] = Long.parseLong(messageStrs[i].trim());
		}
		return messageIds;
	}
	
	@Override
	public void killClientConnections() {
		wire.testAdapter(HTestAdapter.KILL_CONNECTIONS, null);
	}
	
	@Override
	public void setServerAppVersion(long version) {
		wire.testAdapter(HTestAdapter.SET_SERVER_APP_VERSION, 
				new String[] { HTestAdapter.VERSION + "=" + version });
	}
	
	protected final HWireClient wire;
	
	/**
	 * Key parameter.
	 */
	public final static String KEY_PARAM = "testAdapter";
	
	/**
	 * Return IDs of active messages.
	 */
	public final static String ACTIVE_MESSAGES = "active-messages";
	
	/**
	 * Active messages including long-polls.
	 */
	public final static String INCL_LONG_POLLS = "incl-long-polls";
	
	/**
	 * Print a line into the log file of the endpoint.
	 * @see #PRINT_LOG_LINE
	 */
	public static final String PRINT_LOG = "log";
	
	/**
	 * Log line content.
	 * @see #PRINT_LOG
	 */
	public static final String PRINT_LOG_LINE = "line";
	
	/**
	 * Kill all connections.
	 * ... but do not inform the other side.
	 */
	public final static String KILL_CONNECTIONS = "kill-connections";
	
	/**
	 * Check that the servers temporary directory is empty. 
	 */
	public final static String TEMP_FILES ="check-tempdir-empty";
	
	/**
	 * Set the server application version.
	 * This is used to check the negotiation of the transport version.
	 * @see #VERSION
	 */
	public final static String SET_SERVER_APP_VERSION = "set-server-app-version";
	
	/**
	 * Version number.
	 * @see #SET_SERVER_APP_VERSION
	 */
	public final static String VERSION = "version";
	
	
}
