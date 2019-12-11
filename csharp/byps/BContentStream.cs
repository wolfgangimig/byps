/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace byps
{
    public abstract class BContentStream : Stream
    {
        public readonly static String DEFAULT_CONTENT_TYPE = "application/octet-stream";
        public readonly static int ATTACHMENT = 1;
        public readonly static int INLINE = 2;

        protected String contentTypeVal;
        protected long contentLengthVal;
        protected String fileNameVal;
        protected int attachmentCodeVal;
        protected BTargetId targetIdVal = BTargetId.ZERO;

        public BContentStream(String contentType, long contentLength)
        {
            this.contentTypeVal = contentType;
            this.contentLengthVal = contentLength;
        }

        public BContentStream()
        {
            this.contentTypeVal = DEFAULT_CONTENT_TYPE;
            this.contentLengthVal = -1L;
        }

        public BContentStream(BContentStream rhs, long lifetimeMillis)
        {
            copyProperties(rhs);
        }

        public virtual String ContentType
        {
            get
            {
                return contentTypeVal != null ? contentTypeVal : "";
            }
            set
            {
                contentTypeVal = value;
            }
        }

        public virtual long ContentLength
        {
            get
            {
                return contentLengthVal;
            }
            set
            {
                contentLengthVal = value;
            }
        }

        public virtual String FileName
        {
            get
            {
                return fileNameVal != null ? fileNameVal : "";
            }
            set
            {
                fileNameVal = value;
            }
        }

        public virtual int AttachmentCode
        {
            get
            {
                return attachmentCodeVal;
            }
            set
            {
                attachmentCodeVal = value;
            }
        }

        public virtual BTargetId TargetId
        {
            get
            {
                return targetIdVal;
            }
            set
            {
                targetIdVal = value;
            }
        }

        public virtual String ContentDisposition
        {
            get
            {
                StringBuilder sbuf = new StringBuilder();
                sbuf.Append( AttachmentCode == ATTACHMENT ? "attachment;" : "inline;" );
                String fileName = FileName;
                if (fileName != null && fileName.Length != 0) {
                  sbuf.Append(" filename=");
                  bool q = fileName.IndexOf(' ') >= 0;
                  if (q) sbuf.Append("\"");
                  sbuf.Append(fileName);
                  if (q) sbuf.Append("\"");
                }
                return sbuf.ToString();
            }

            set
            {
                String fileName = "";
                int attcode = 0;
                if (value != null && value.Length != 0)
                {
                    value = value.Trim();
                    attcode = value.IndexOf("attachment;") >= 0 ? ATTACHMENT : INLINE;
                    int p = value.IndexOf("filename=");
                    if (p >= 0)
                    {
                        fileName = value.Substring(p + "filename=".Length).Trim();
                        if (fileName.StartsWith("\""))
                        {
                            fileName = fileName.Substring(1);
                            if (fileName.EndsWith("\""))
                            {
                                fileName = fileName.Substring(0, fileName.Length - 1);
                            }
                        }
                    }
                }
                attachmentCodeVal = attcode;
                fileNameVal = fileName;
            }
        }

        public virtual void copyProperties(BContentStream rhs)
        {
            contentTypeVal = rhs.ContentType;
            contentLengthVal = rhs.ContentLength;
            fileNameVal = rhs.FileName;
            attachmentCodeVal = rhs.AttachmentCode;
            targetIdVal = rhs.TargetId;
        }

        public virtual void ensureProperties()
        {
        }
     }

}
