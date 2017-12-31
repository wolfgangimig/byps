/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/// This class defines protocol details.
public struct BBinaryModel {
    
   
    /// Size of pointers (object IDs) in bytes.
    /// The value is 4 in binary streams.
    /// This member has no meaning in JSON streams.
    public let pointerSize : Int32
   
    /// Size of type IDs in bytes.
    /// The value is 4 in binary streams.
    /// This member has no meaning in JSON streams.
    public let typeIdSize : Int32
   
    /// Size of array and string lengths in bytes.
    /// The value is 4 in binary streams.
    /// This member has no meaning in JSON streams.
    public let lengthSize : Int32
   
    /// Reserved.
    public let packing : Int32
    
    /// Private constructor
    private init(_ pointerSize : Int32, _ typeIdSize : Int32, _ lengthSize : Int32, _ packing : Int32) {
        self.pointerSize = pointerSize
        self.typeIdSize = typeIdSize
        self.lengthSize = lengthSize
        self.packing = packing
    }
    
    public static let MEDIUM : BBinaryModel = BBinaryModel(4, 4, 4, 8)
    public static let JSON : BBinaryModel = BBinaryModel(1, 1, 1, 1)
    
    public func computeArrayWireSize(_ elmSize : Int32, length : Int32) -> Int32 {
        let ret = length * elmSize
        return ret;
    }
    
    public func toString() -> String {
        if (self.pointerSize == BBinaryModel.MEDIUM.pointerSize) { return "MEDIUM" }
        if (self.pointerSize == BBinaryModel.JSON.pointerSize) { return "JSON" }
        return "Invalid binary model"
    }
    
    public func getProtocolId() -> String {
        return (self.pointerSize == BBinaryModel.MEDIUM.pointerSize) ? "S" : "J";
    }

}
