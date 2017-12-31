/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

open class BSerializer {
    
    public let typeId : Int32
    
    public let inlineInstance : Bool
    
    public static let NOTHING : BSerializer = BSerializer(0)
    
    public init(_ typeId : Int32, _ inlineInstance : Bool) {
        self.typeId = typeId
        self.inlineInstance = inlineInstance
    }
    
    public init(_ typeId : Int32) {
        self.typeId = typeId
        self.inlineInstance = false
    }
    
    public func write(_ obj1 : AnyObject, _ bout : BOutput, _ version : Int64) throws {
    }

    public func read(_ obj : AnyObject, _ bin : BInput, _ version : Int64) throws -> AnyObject? {
        return nil
    }

}

// Serialize list
internal class BSerializer_12 : BSerializer {
    
    public init() {
        super.init(BRegistry.TYPEID_LIST)
    }
    
    public override func write(_ obj : AnyObject, _ bout : BOutput, _ version : Int64) throws {
        let v = obj as! [AnyObject?]
        let n : Int32 = Int32(v.count)
        bout.bbuf.putLength(n)
        for e in v {
            try bout.writeObj(e, false, BSerializer.NOTHING)
        }
    }
    
    public override func read(_ obj : AnyObject, _ bin : BInput, _ version : Int64) throws -> AnyObject? {
        let n0 : Int = Int(bin.bbuf.getLength())
        var arr = [AnyObject?]()
        for i in 0..<n0 {
            arr[i] = bin.readObj(false, BSerializer.NOTHING)
        }
        return arr as AnyObject?
    }

}

// Serialize  BContentStream
internal class BSerializer_15 : BSerializer {
    
    public init() {
        super.init(BRegistry.TYPEID_STREAM)
    }
    
    public override func write(_ obj : AnyObject, _ bout : BOutput, _ version : Int64) throws {
//        let istream : InputStream = obj as! InputStream
//        let BContentStream bstream = bout.createStreamRequest(istream)
//
//        final BOutputBin bout = ((BOutputBin) bout1);
//        final InputStream is = (InputStream) obj;
//        final BContentStream bstream = bout.createStreamRequest(is);
//        final BTargetId targetId = bstream.getTargetId();
//        final boolean withProps = bout.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;
//
//        if (withProps) {
//            bstream.getTargetId().write(bout.bbuf.getBuffer(), bout.header.bversion);
//            bout.bbuf.putLong(bstream.getContentLength());
//            bout.bbuf.putString(bstream.getContentType());
//            bout.bbuf.putInt(bstream.getAttachmentCode());
//            bout.bbuf.putString(bstream.getFileName());
//        } else {
//            bout.bbuf.putLong(targetId.getStreamId());
//        }
    }
    
    public override func read(_ obj : AnyObject, _ bin : BInput, _ version : Int64) throws -> AnyObject? {
        let n0 : Int = Int(bin.bbuf.getLength())
        var arr = [AnyObject?]()
        for i in 0..<n0 {
            arr[i] = bin.readObj(false, BSerializer.NOTHING)
        }
        return arr as AnyObject?
    }
    
}
