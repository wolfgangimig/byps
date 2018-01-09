/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public class BOutput {
    
    public let bbuf : BBuffer
    
    public init() {
        self.bbuf = BBuffer()
    }
    
    public func writeObj(_ obj : AnyObject?, _ uniqueObject : Bool, _ ser : BSerializer) throws {
    
    }
    
}
