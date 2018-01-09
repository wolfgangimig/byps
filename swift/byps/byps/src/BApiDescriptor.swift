/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public struct BApiDescriptor {
    
    /// API name.
    /// This name is used as a suffix for several generated classes,
    /// BClient_name, BServer_name, BApiDescriptor_name.
    ///
    public let name: String
    
    /// Base package.
    /// The classes generated to serialize arrays and collection types
    /// are members of this package.
    public let basePackage: String
    
    /// API interface version.
    public let version: Int64
    
    ///
    /// Reserved.
    public let uniqueObjects: Bool
    
    /// Constructor
    /// - parameters:
    ///   - name: API name
    ///   - apiPack: Base package
    ///   - version: API interface version
    ///   - uniqueObjects: Reserved
    public init(_ name : String,
         _ apiPack :String,
         _ version: Int64,
         _ uniqueObjects : Bool
    ) {
        self.name = name;
        self.basePackage = apiPack;
        self.version = version;
        self.uniqueObjects = uniqueObjects;
    }
}
