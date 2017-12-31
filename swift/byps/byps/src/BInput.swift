/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public class BInput {
    
    public let bbuf : BBuffer
    
    public init() {
        self.bbuf = BBuffer()
    }

    public func onObjectCreated(_ obj : AnyObject) {
        
    }
    
    public func readObj(_ uniqueObject : Bool, _ ser : BSerializer) -> AnyObject? {
        return nil
    }
}
