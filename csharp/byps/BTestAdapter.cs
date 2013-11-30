/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
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
