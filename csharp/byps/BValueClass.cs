using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BValueClass : BSerializable
    {
        protected long changedMembersVal;

        protected Object dbHelperVal;

        public long ChangedMembers
        {
            get { return changedMembersVal; }
            set { changedMembersVal = value; }
        }

        public virtual Object DBHelper
        {
            get { return dbHelperVal; }
            set { dbHelperVal = value; }
        }

        public bool isChangedMember(long mb)
        {
            return (changedMembersVal & mb) != 0;
        }

        public void setChangedMember(long mb)
        {
            changedMembersVal |= mb;
        }

    }
}
