using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BException : System.Exception
    {
        public static readonly long serialVersionUID = BRegistry.TYPEID_EXCEPTION;

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
        public const int CANCELED = 100;


        public BException(int code, string msg, Exception ex) : base(msg, ex)
        {
            this.Code = code;
            this.Details = ex != null ? ex.ToString() : "";
        }

        public BException(int code, string msg, string details) : base(msg)
        {
            this.Code = code;
            this.Details = details;
         }

        public BException(int code, string msg) : base(msg)
        {
            this.Code = code;
        }

        public override string ToString()
        {
            return "[BYPS:" + Code + "]" + "[" + base.Message + "]" + "[" + Details + "]";
        }

        public readonly int Code;
        public readonly string Details;

    }
}
