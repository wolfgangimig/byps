using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BExceptionC
    {
	    public const int NO_SERIALIZER = 1;
        public const int CORRUPT = 8;
        public const int INTERNAL = 3;
        public const int SERVICE_NOT_IMPLEMENTED = 11;
        public const int TIMEOUT = 13;
        public const int REMOTE_ERROR = 10;
        public const int IOERROR = 14;
        public const int TOO_MANY_REQUESTS = 15;
        public const int NO_REVERSE_CONNECTIONS = 16;
        public const int UNSUPPORTED_METHOD = 17;
        public const int CANCELED = 19;
        public const int AUTHENTICATION_REQUIRED = 18;
    }
}
