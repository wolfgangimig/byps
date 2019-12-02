/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BValueClass : BSerializable
    {
        public static readonly long serialVersionUID = 22L;		

        protected long changedMembersVal;

        protected Object dbHelperVal;

        public BValueClass()
        {
        }

        public BValueClass(BValueClass rhs)
        {
            changedMembersVal = rhs.changedMembersVal;
            dbHelperVal = rhs.dbHelperVal;
        }

        public long changedMembers
        {
            get { return changedMembersVal; }
            set { changedMembersVal = value; }
        }

        public virtual Object dbHelper
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
