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
