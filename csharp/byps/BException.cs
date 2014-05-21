/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BException : IOException
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
            return BExceptionO.FormatMessage(Code, base.Message, Details, null);
        }

        public readonly int Code;
        public readonly string Details;

    }
}
