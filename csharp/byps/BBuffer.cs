/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BBuffer
    {
        public static BBuffer create(BBinaryModel bmodel, ByteBuffer buf)
        {
            if (bmodel == BBinaryModel.MEDIUM)
            {
                return new BBufferBin(bmodel, buf);
            }
            throw new InvalidOperationException();
        }

        public abstract ByteBuffer getBuffer();
        public abstract void clear();

        /**
         * Format binary message in order to print it into the log file.
         * @param arr Message bytes.
         * @param limit Length of message bytes.
         * @return Buffer content as String.
         */
        private static String toDetailStringBinary(byte[] arr, int limit)
        {
            StringBuilder sbuf = new StringBuilder();
            sbuf.Append("\r\nbyte[] bytes = new byte[] {");
            int n = 0;
            int u = (limit % 16) != 0 ? (limit / 16 + 1) * 16 : limit;
            for (int i = 0; i <= u; i++, n++)
            {
                if ((n % 16) == 0)
                {
                    if (n != 0)
                    {
                        StringBuilder rbuf = new StringBuilder();
                        rbuf.Append("    // ");
                        for (int j = i - 16; j < i && j < limit; j++)
                        {
                            char c = (char)(arr[j] & 0xFF);
                            if (Char.IsLetterOrDigit(c) ||
                                c == '[' || c == ']' || c == '{' || c == '}' || c == '\"' || c == '\'' ||
                                c == ':' || c == '=' || c == ',' || c == '_' || c == '*' || c == '\\' ||
                                c == '-' || c == ' ' || c == '+' || c == '/' || c == '?')
                            {
                                rbuf.Append(c);
                            }
                            else {
                                rbuf.Append('.');
                            }
                        }
                        sbuf.Append(rbuf.ToString());
                    }
                    sbuf.Append("\r\n");
                    if (n > limit) break;
                }

                sbuf.Append(" ");
                if (i < limit)
                {
                    int c = arr[i] & 0xFF;
                    String s = c.ToString("X");
                    if (s.Length < 2) sbuf.Append("0");
                    sbuf.Append(s);
                }
                else {
                    sbuf.Append("  ");
                }
            }
            sbuf.Append("};");
            return sbuf.ToString();
        }

        /**
         * Format message data into String.
         * @return Content of the internal buffer as String.
         */
        public String toDetailString()
        {
            ByteBuffer bbuf = this.getBuffer();
            byte[] buf = bbuf.array();
            int limit = bbuf.remaining();
            return toDetailStringBinary(buf, limit);
        }
    }

}
