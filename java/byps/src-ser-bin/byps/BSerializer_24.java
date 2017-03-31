package byps;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class BSerializer_24 extends BSerializer {

  public final static BSerializer instance = new BSerializer_24();
  
  public BSerializer_24() {
    super(BRegistry.TYPEID_HTTP_REQUEST);
  }

  public BSerializer_24(int typeId) {
    super(typeId);
  }

  public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
    final BInputBin bin = (BInputBin) bin1;
    final BBufferBin bbuf = bin.bbuf;
    
    BHttpRequest httpRequest = new BHttpRequest();
    bin.onObjectCreated(httpRequest);

    // Read map of headers
    {
      int n = bbuf.getLength();
      if (n > 0) {
        final HashMap<java.lang.String, java.lang.String> map = new HashMap<java.lang.String, java.lang.String>();
        bin.onObjectCreated(map);
        for (int i0 = 0; i0 < n; i0++) {
          java.lang.String key = bbuf.getString();
          java.lang.String value = bbuf.getString();
          map.put(key, value);
        }
        httpRequest.headers = map;
      }
    }
    
    httpRequest.url = bbuf.getString();
    httpRequest.offset = bbuf.getLong();
    httpRequest.length = bbuf.getLong();
    
    int nbOfBytes = bbuf.getInt();
    byte[] bytes = new byte[nbOfBytes];
    bbuf.getArrayByte(bytes);
    httpRequest.body = ByteBuffer.wrap(bytes);
    
    return httpRequest;
  }

  public void write(Object obj1, BOutput bout1, final long version) throws BException {
    BOutputBin bout = (BOutputBin) bout1;
    BBufferBin bbuf = bout.bbuf;
    
    BHttpRequest httpRequest = (BHttpRequest)obj1;

    // Write map of headers
    Map<java.lang.String, java.lang.String> map = httpRequest.headers;
    {
      int n = map != null ? map.size() : 0;
      bbuf.putLength(n);
      if (n != 0) {
        for (Map.Entry<java.lang.String, java.lang.String> obj : map.entrySet()) {
          bbuf.putString(obj.getKey() != null ? (String) obj.getKey() : "");
          bbuf.putString(obj.getValue() != null ? (String) obj.getValue() : "");
        }
      }
    }
        
    bbuf.putString(httpRequest.url);
    bbuf.putLong(httpRequest.offset);
    bbuf.putLong(httpRequest.length);
    
    if (httpRequest.body != null) {
      bbuf.putInt(httpRequest.body.remaining());
      bbuf.putByteBuffer(httpRequest.body);
    }
    else {
      bbuf.putInt(0);
    }
  }

}
