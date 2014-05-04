/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BRegistry
    {
 	    public const int TYPEID_LIST = 12;
	    public const int TYPEID_MAP = 13;
	    public const int TYPEID_SET = 14;
	    public const int TYPEID_STREAM = 15;
	    public const int TYPEID_STUB = 16;
        public const int TYPEID_VOID = 19;
	    public const int TYPEID_EXCEPTION = 20;
        public const int TYPEID_VALUECLASS = 22;

        public readonly BBinaryModel bmodel;

        public BRegistry(BBinaryModel bmodel)
        {
            this.bmodel = bmodel;
        }

        protected class BRegisteredSerializer
        {
            public int typeId;
            public String name;
            public BSerializer instance;
            public BRegisteredSerializer(int typeId, String name, BSerializer instance)
            {
                this.typeId = typeId;
                this.name = name;
                this.instance = instance;
            }
        }

        protected abstract BRegisteredSerializer[] getSortedSerializers();

        public BSerializer getSerializer(int typeId)
        {
            BRegisteredSerializer[] ssers = getSortedSerializers();
            int left = 0, right = ssers.Length;
            while (left <= right)
            {
                int idx = (right + left) / 2;

                BRegisteredSerializer rser = ssers[idx];
                if (rser.typeId == typeId)
                {
                    // rser.name must be the qualified assembly name. 
                    // I don't know the assembly name that contains the serializers 
                    //if (rser.instance == null)
                    //{
                    //    Type type = Type.GetType(rser.name, true);
                    //    rser.instance = (BSerializer)Activator.CreateInstance(type);
                    //}
                    return rser.instance;
                }

                if (rser.typeId < typeId) left = idx + 1;
                if (rser.typeId > typeId) right = idx - 1;
            }

            BSerializer ser = getBuiltInSerializer(typeId);
            if (ser != null) return ser;

            throw new BException(BExceptionC.CORRUPT, "No serializer for typeId=" + typeId);
        }

        private BSerializer getBuiltInSerializer(int typeId)
        {
			if (typeId == TYPEID_LIST) return BSerializer_12.instance;
			if (typeId == TYPEID_MAP) return new BSerializer_13();
			if (typeId == TYPEID_SET) return new BSerializer_14();
			if (typeId == TYPEID_EXCEPTION) return new BSerializer_20();
			if (typeId == TYPEID_STREAM) return new BSerializer_15();
    		return null;
        }

        public BSerializer getSerializer(object obj, bool throwEx)
        {
            BSerializer ret = null;
            Type type = obj.GetType();
            try
            {
                int typeId = 0;
                long longTypeId = 0;

                while (type != typeof(Object))
                {
                    if (type == typeof(Stream))
                    {
                        typeId = BRegistry.TYPEID_STREAM;
                        break;
                    }

                    FieldInfo field = type.GetField("serialVersionUID",
                        System.Reflection.BindingFlags.NonPublic |
                        System.Reflection.BindingFlags.Public |
                        System.Reflection.BindingFlags.Static);
                    if (field != null)
                    {
                        longTypeId = (long)field.GetValue(null);
                        typeId = (int)longTypeId;
                        break;
                    }

                    type = type.BaseType;
                }

                ret = getSerializer(typeId);
            }
            catch (Exception x)
            {
                if (throwEx)
                {
                    throw new BException(BExceptionC.CORRUPT,
                            "No serializer for className=" + type + ". " +
                            "Only classes marked with BSerializable can be serialized as \"Object\" types. " +
                            "This error occurs e. g. if a List<Object> contains String values. String is not a BSerializable. " + x);
                }
            }

            return ret;
        }

    }
}