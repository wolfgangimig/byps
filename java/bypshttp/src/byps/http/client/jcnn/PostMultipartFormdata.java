package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * This class provides a function to send a multipart/form-data request. 
 * BYPS-83: Solve Azure file upload problem with large POST request.
 */
public class PostMultipartFormdata {

  /**
   * Functional interface to write a stream as content of a multipart/form-data.
   */
  public static interface WriteFunction {
    void write(OutputStream os) throws IOException;
  }

  /**
   * Send a multipart/form-data request.
   * The request contains two parts. The first one contains the parameter contentDisposition. 
   * The second one, "file", contains the data written by the writeFnct.
   * @param conn HttpURLConnection
   * @param contentLength Size of the "file" data that is written by the writeFnct
   * @param contentType Content type of the "file" data
   * @param contentDisposition Content disposition information related to the "file" data 
   * @param contentEncoding "gzip" is passed for compressed JSON data
   * @param writeFnct This function writes the data of the "file" part
   * @return Response stream
   * @throws IOException
   */
  public static InputStream send(HttpURLConnection conn, 
      long contentLength, 
      String contentType, 
      String contentDisposition,
      String contentEncoding,
      WriteFunction writeFnct) throws IOException {
    
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");

    // Multipart boundary that separates the parts.
    // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type#content-type_in_html_forms
    String boundary = "pbpHt9PUtHfcQFX4fJpKC9Y4JEghB7jwyYgrPpsFgFhHTDhVtQgBD9UPuPmJ";
    conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

    // Write request body.
    try (OutputStream os = conn.getOutputStream();
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))) {
      
      // Send content disposition as multipart part "originalContentDisposition".
      if (contentDisposition != null && !contentDisposition.isEmpty()) {
        pr.write("--" + boundary + "\r\n");
        pr.write("Content-Disposition: form-data; name=originalContentDisposition;\r\n");
        pr.write("\r\n");
        pr.write(contentDisposition);
        pr.write("\r\n");
      }
      
      // Send data as multipart part "file".
      pr.write("--" + boundary + "\r\n");
      pr.write("Content-Disposition: form-data; name=file; filename=file.dat\r\n");
      pr.write("Content-Type: " + contentType + "\r\n");
      pr.write("Content-Length: " + contentLength + "\r\n");
      if (contentEncoding != null && !contentEncoding.isEmpty()) {
        pr.write("Content-Encoding: " + contentEncoding + "\r\n");
      }
      pr.write("\r\n");
      pr.flush();
      
      writePayload(os, writeFnct);

      // Finish multipart with boundary
      pr.write("\r\n");
      pr.write("--" + boundary + "--\r\n");
    }
    
    return conn.getInputStream();
  }
  
  /**
   * Call {@link WriteFunction} to write payload for "file" part.
   * @param os Request OutputStream
   * @param writeFnct This function writes the payload into the OutputStream
   * @throws IOException
   */
  private static void writePayload(OutputStream os, WriteFunction writeFnct) throws IOException {
    
    // Wrap the OutputStream into a stream the does not close the given OutputStream.
    // Otherwise the multipart request could not be finished with the boundary. 
    try (OutputStream ostreamNoClose = newOutputStreamWrapperNoClose(os)) {
      writeFnct.write(ostreamNoClose);
    }
  }
  
  /**
   * Create a stream that wraps the given OutputStream without closing it.
   * @param os OutputStream to be wrapped
   * @return Wrapper stream
   */
  private static OutputStream newOutputStreamWrapperNoClose(OutputStream os) {
    return new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        os.write(b);
      }
      @Override
      public void write(byte[] b) throws IOException {
        os.write(b);
      }
      @Override
      public void write(byte[] b, int off, int len) throws IOException {
        os.write(b, off, len);
      }
      @Override
      public void close() throws IOException {
        os.flush();
        
        // do not close
      }
    };
  }
}
