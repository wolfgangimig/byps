using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BExceptionO
    {
        public delegate String FormatMessageFnct(int code, String msg, String details, Exception cause);

        public static FormatMessageFnct FormatMessage = formatMessageDefault;

        private static string formatMessageDefault(int code, string msg, string details, Exception cause)
        {
            return "[BYPS:" + code + "]" + "[" + msg + "]" + "[" + details + "]";
        }
        

    }
}
