﻿/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bypstest
{
    class MyMap<K,V> : Dictionary<K,V>
    {
        public MyMap<K, V> add(K key, V value)
        {
            this[key] = value;
            return this;
        }

    }
}
