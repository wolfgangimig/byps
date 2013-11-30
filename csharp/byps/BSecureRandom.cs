/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSecureRandom
    {
        public long nextLong()
        {
            byte[] buf = new byte[8];
            rand.GetBytes(buf);
            return ((long)buf[0] << 56) | ((long)buf[1] << 48) | ((long)buf[2] << 40) | ((long)buf[3] << 32) |
                ((long)buf[4] << 24) | ((long)buf[5] << 16) | ((long)buf[6] << 8) | ((long)buf[7]);
        }

        protected RNGCryptoServiceProvider rand = new RNGCryptoServiceProvider();
    }
}
