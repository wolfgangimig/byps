/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

open class BException : Error {
    
    public let code : Int32
    
    public let message : String
        
    public init (_ code : Int32, _ message : String) {
        self.code = code;
        self.message = message;
    }
}
