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

        protected String contentTypeVal;
        protected long contentLengthVal;
        protected String fileNameVal;
        protected bool attachmentVal;
        protected BTargetId targetIdVal = BTargetId.ZERO;
        protected bool propertiesValid;

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
                return contentTypeVal;
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
                return fileNameVal;
            }
            set
            {
                fileNameVal = value;
            }
        }

        public virtual bool IsAttachment
        {
            get
            {
                return attachmentVal;
            }
            set
            {
                attachmentVal = true;
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

        public virtual void copyProperties(BContentStream rhs)
        {
            if (hasValidProperties()) return;
            if (!rhs.hasValidProperties()) return;
            contentTypeVal = rhs.ContentType;
            contentLengthVal = rhs.ContentLength;
            fileNameVal = rhs.FileName;
            attachmentVal = rhs.IsAttachment;
            targetIdVal = rhs.TargetId;
            propertiesValid = true;
        }

        public virtual bool hasValidProperties()
        {
            return propertiesValid;
        }

        public virtual void setPropertiesValid(bool b)
        {
            propertiesValid = b;
        }
    }

}
