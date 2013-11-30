using System;
using System.Collections.Generic;
// using System.Linq;
using System.Text;

namespace byps
{
    public class HTestAdapter : /* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
BTestAdapter
    {
        protected HWireClient wire;

        public HTestAdapter(HWireClient wire)
        {
            this.wire = wire;
        }
	    
	    public String[] getServerTempFiles() {
		    String list = wire.testAdapter(HTestAdapter.TEMP_FILES, null).Trim();
		    return list.Length != 0 ? list.Split(new char[] {'\n'}) : new String[0];
	    }
	
	    
	    public void printServerLog(String line) {
		    wire.testAdapter(HTestAdapter.PRINT_LOG, new String[] {
				    HTestAdapter.PRINT_LOG_LINE + "=" + line
		    });
	    }
	
	    
	    public long[] getAcitveMessagesOnServer() {
		    String list = wire.testAdapter(HTestAdapter.ACTIVE_MESSAGES, null).Trim();
		    if (list.Length == 0) return new long[0];
            String[] messageStrs = list.Split(new char[] { '\n' });
		    long[] messageIds = new long[messageStrs.Length];
            for (int i = 0; i < messageStrs.Length; i++)
            {
			    messageIds[i] = Convert.ToInt64(messageStrs[i].Trim());
		    }
		    return messageIds;
	    }
	
	    
	    public void killClientConnections() {
		    wire.testAdapter(HTestAdapter.KILL_CONNECTIONS, null);
	    }
	
	    
	    public void setServerAppVersion(int version) {
		    wire.testAdapter(HTestAdapter.SET_SERVER_APP_VERSION, 
				    new String[] { HTestAdapter.VERSION + "=" + version });
	    }

	    public readonly static String KEY_PARAM = "testAdapter";
	    public readonly static String ACTIVE_MESSAGES = "active-messages";
	    public static readonly String PRINT_LOG = "log";
	    public static readonly String PRINT_LOG_LINE = "line";
	    public readonly static String KILL_CONNECTIONS = "kill-connections";
	    public readonly static String TEMP_FILES ="check-tempdir-empty";
	    public readonly static String SET_SERVER_APP_VERSION = "set-server-app-version";
	    public readonly static String VERSION = "version";

    }
}
