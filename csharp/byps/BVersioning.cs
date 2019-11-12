/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BVersioning
    {
        public static long stringToLong(String sver)
        {
            long ver = 0;
            if (sver != null && sver.Length != 0)
            {
                List<String> arr = new List<String>(sver.Split(new char[] { '.' }));
                while (arr.Count < 4) arr.Add("0");
                for (int i = 0; i < arr.Count; i++)
                {
                    ver *= 10000;
                    if (i == arr.Count - 1) ver *= 100;
                    if (arr[i].Length != 0)
                    {
                        ver += Convert.ToInt32(arr[i]);
                    }
                }
            }
            return ver;
        }

        public static String longToString(long nver)
        {
            StringBuilder sbuf = new StringBuilder();
            for (int i = 0; i < 4; i++)
            {
                int ndigits = (i == 0) ? 1000000 : 10000;
                int pver = (int)(nver % ndigits);

                if (i != 0) sbuf.Insert(0, '.');
                sbuf.Insert(0, pver);

                nver /= ndigits;
            }
            return sbuf.ToString();
        }

    }
}
