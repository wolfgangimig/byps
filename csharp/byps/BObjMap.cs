/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BObjMap
    {
        public BObjMap()
        {
        }

        public void put(Object obj, int id)
        {
            Key key = new Key(obj);
            map[key] = id;
        }

        public int get(Object obj)
        {
            int id = 0;
            inst.obj = obj;
            map.TryGetValue(inst, out id);
            return id;
        }

        private class Key
        {
            public Object obj;
            public Key(Object obj)
            {
                this.obj = obj;
            }
            public override int GetHashCode()
            {
                return RuntimeHelpers.GetHashCode(obj);
            }
            public override bool Equals(object otherKey)
            {
                return this.obj == ((Key)otherKey).obj;
            }
            public override string ToString()
            {
                return Convert.ToString(GetHashCode());
            }
        };

        public void clear()
        {
            map.Clear();
        }
        
        private Dictionary<Key, int> map = new Dictionary<Key, int>();
        private Key inst = new Key(null);

     }
}
