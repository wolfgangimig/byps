using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public interface BTestAdapter
    {
        String[] getServerTempFiles();
        void printServerLog(String line);
        long[] getAcitveMessagesOnServer();
        void killClientConnections();
        void setServerAppVersion(int version);
    }
}
