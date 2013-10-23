using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BValueClass : BSerializable
    {
        protected long _changedMembers;

        public long ChangedMembers
        {
            get { return _changedMembers; }
            set { _changedMembers = value; }
        }

        public bool isChangedMember(long mb)
        {
            return (_changedMembers & mb) != 0;
        }

        public void setChangedMember(long mb)
        {
            _changedMembers |= mb;
        }

    }
}
