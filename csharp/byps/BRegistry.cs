using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BRegistry
    {
 	    public const int TYPEID_LIST = 12;
	    public const int TYPEID_MAP = 13;
	    public const int TYPEID_SET = 14;
	    public const int TYPEID_STREAM = 15;
	    public const int TYPEID_STUB = 16;
	    public const int TYPEID_EXCEPTION = 20;
        public const int TYPEID_VALUECLASS = 22;

        public readonly BBinaryModel bmodel;

        public BRegistry(BBinaryModel bmodel)
        {
            this.bmodel = bmodel;
        }

        public abstract BSerializer getApiSerializer(int typeId);

        public BSerializer getSerializer(int typeId)
        {
            BSerializer ser = null;
            if (!mapTypeIdToSerializer.TryGetValue(typeId, out ser))
            {
                if (ser == null)
                {
                    ser = getApiSerializer(typeId);
                    if (ser == null)
                    {
                        ser = getBuiltInSerializer(typeId);
                        if (ser == null)
                        {
                            throw new BException(BExceptionC.CORRUPT, "No serializer for typeId=" + typeId);
                        }
                    }
                    mapTypeIdToSerializer[typeId] = ser;
                }
            }
            return ser;
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
            if (!mapClassToSerializer.TryGetValue(type, out ret))
            {
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
                catch (Exception)
                {
                    throw new BException(BExceptionC.CORRUPT,
                            "No serializer for className=" + type + ". " +
                            "Only classes marked with BSerializable can be serialized as \"Object\" types. " +
                            "This error occurs e. g. if a List<Object> contains String values. String is not a BSerializable.");
                }
            }
            return ret;
        }

        private ConcurrentDictionary<int, BSerializer> mapTypeIdToSerializer = new ConcurrentDictionary<int, BSerializer>();
        private ConcurrentDictionary<Type, BSerializer> mapClassToSerializer = new ConcurrentDictionary<Type, BSerializer>();
    }
}