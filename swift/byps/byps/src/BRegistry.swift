/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public class BRegistry {
    
    public static let TYPEID_BOOL : Int32 = 1
    public static let TYPEID_INT8 : Int32 = 2
    public static let TYPEID_INT16 : Int32 = 3
    public static let TYPEID_WCHAR : Int32 = 4
    public static let TYPEID_INT32 : Int32 = 5
    public static let TYPEID_INT64 : Int32 = 6
    public static let TYPEID_FLOAT : Int32 = 7
    public static let TYPEID_DOUBLE : Int32 = 8
    public static let TYPEID_STRING : Int32 = 10
    public static let TYPEID_LIST : Int32 = 12
    public static let TYPEID_MAP : Int32 = 13
    public static let TYPEID_SET : Int32 = 14
    public static let TYPEID_STREAM : Int32 = 15
    public static let TYPEID_STUB : Int32 = 16
    public static let TYPEID_DATE : Int32 = 17
    public static let TYPEID_VOID : Int32 = 19
    public static let TYPEID_EXCEPTION : Int32 = 20
    public static let TYPEID_OBJECT : Int32 = 21
    public static let TYPEID_VALUECLASS : Int32 = 22
    public static let TYPEID_PUBLISH_CLIENT : Int32 = 23
    public static let TYPEID_HEADER : Int32 = 30
    
    public static let TYPEID_STRING_UTF16 : Int32 = TYPEID_STRING
    
    public static let TYPEID_MIN_USER : Int32 = 64
    
    public let bmodel : BBinaryModel
    
    private var mapTypeIdToSerializer : [Int32 : BSerializer]
    private var mapClassIdToSerializer : [Int : BSerializer]
    
    public init(_ bmodel : BBinaryModel) {
        self.bmodel = bmodel
        self.mapTypeIdToSerializer = [Int32 : BSerializer]()
        self.mapClassIdToSerializer = [Int : BSerializer]()
    }
    
    public func registerClass(_ tinfo : Mirror, _ ser : BSerializer, _ typeId : Int32) {
        let subjectType : Int = ObjectIdentifier(tinfo.subjectType).hashValue
        mapTypeIdToSerializer[typeId] = ser
        mapClassIdToSerializer[subjectType] = ser
    }
    
    public func getMinTypeIdUser() -> Int32 {
        return BRegistry.TYPEID_MIN_USER
    }
    
    public func getMaxTypeIdUser() -> Int32 {
        return getMaxTypeId()
    }
    
    public func getMaxTypeId() -> Int32 {
        return Int32.max
    }
    
    private func getBuiltInSerializer(_ typeId : Int32) -> BSerializer {
//        if (typeId == TYPEID_LIST) return BSerializer_12.instance
//        if (typeId == TYPEID_MAP) return BSerializer_13.instance
//        if (typeId == TYPEID_SET) return BSerializer_14.instance
//        if (typeId == TYPEID_EXCEPTION) return BSerializer_20.instance
//        if (typeId == TYPEID_STREAM) return BSerializer_15.instance
       return BSerializer.NOTHING
    }

    public func getSerializer(_ tinfo : Mirror) throws -> BSerializer {
        let subjectType : Int = ObjectIdentifier(tinfo.subjectType).hashValue
        let serOpt : BSerializer? = mapClassIdToSerializer[subjectType]
        if let ser = serOpt { return ser }
        throw BException(BExceptionC.CORRUPT, "Missing serializer for type=" + String(describing: tinfo))
    }
    
    public func getSerializer(_ typeId : Int32) throws -> BSerializer {
        let serOpt : BSerializer? = mapTypeIdToSerializer[typeId]
        if let ser = serOpt { return ser }
        throw BException(BExceptionC.CORRUPT, "Missing serializer for typeId=" + String(typeId))
    }

}
