/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public static class BTaskConstants<TResult>
    {
        static BTaskConstants()
        {
            var tcs = new TaskCompletionSource<TResult>();
            tcs.SetException(new NotImplementedException());
            NotImplemented = tcs.Task;
        }

        public static Task<TResult> NotImplemented { get; private set; }
    }

}
