/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
// using System.Linq;
using System.Text;

namespace byps
{
    public class HConstants
    {

        public readonly static int DEFAULT_BYTE_BUFFER_SIZE = 10 * 1000;
	    public readonly static long REQUEST_TIMEOUT_MILLIS = 600 * 1000L;
	    public readonly static long CLEANUP_MILLIS = 10 * 1000;
	    public readonly static long MAX_WAIT_FOR_LONGPOLL_MILLIS = 30 * 1000L; 
	    public readonly static long KEEP_MESSAGE_AFTER_FINISHED = 10L * 1000L;
	    public readonly static bool PROCESS_PUT_STREAM_ASYNC = false;
	    public readonly static bool PROCESS_LONGPOLL_ASYNC = true;
	    public readonly static bool PROCESS_MESSAGE_ASYNC = false;
	    public readonly static int INCOMING_STREAM_BUFFER = 1000 * 1000;
	    public readonly static String DEFAULT_CONTENT_TYPE = "application/octet-stream";

    }
}
