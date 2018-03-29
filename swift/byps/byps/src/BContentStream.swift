/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import Foundation


/// BContentStream is an InputStream with content type and content length.
/// Streams should always be transferred with a given content length. This
/// makes HTTP communication more reliable.
public class BContentStream : InputStream {
    
    private contentTypeVal : String
    private contentLengthVal : Int64
    private fileNameVal : String
    private attachmentCodeVal : Int
    
    public contentType : String {

    }
    
    /// Default content type: application/octet-stream
    public static let DEFAULT_CONTENT_TYPE = "application/octet-stream";
    
    
    /// Explicitly add this URL parameter for range requests.
    /// This parameter tells the server, that the stream should not be closed after the request.
    /// If this parameter is not set, the HTTP range request header is ignored.
    public static let URL_PARAM_ACCEPT_RANGES = "accept-ranges";
    
    
    /// Controls HTTP header Content-Disposition.
    public static let ATTACHMENT = 1;
    
    
    /// Controls HTTP header Content-Disposition.
    public static let INLINE = 2;
    
    
    /// Constructor with content type and length.
    /// - parameters:
    ///   - contentType: MIME type of stream content.
    ///   - contentLength: Number of bytes in stream.
    public init(_ contentType : String, _ contentLength : Int64) {
        self.contentType = contentType;
        self.contentLength = contentLength;
    }

}
