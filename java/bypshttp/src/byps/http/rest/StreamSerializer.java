package byps.http.rest;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BTargetId;
import byps.BTransport;
import byps.BWire;
import byps.http.HSession;

/**
 * Serialize an InputStream to be returned from a REST call.  
 *
 * The InputStream element is serialized as an object as follows:
 * <pre><code>
 * {
 *   "url" : "?serverid=...&messageid=...&streamid=..."
 * }
 * </code></pre>
 * 
 * The client can read this stream once by sending a GET request to .../rest/ + url.
 */
class StreamSerializer implements JsonSerializer<InputStream> {
  
  private static final Logger log = LoggerFactory.getLogger(StreamSerializer.class);
  
  /**
   * BYPS wire object.
   */
  final BWire wire;
  
  /**
   * BYPS transport object.
   */
  final BTransport transport;

  /**
   * Constructor.
   * @param sess BYPS session
   */
  StreamSerializer(HSession sess) {
    transport = sess.getServer().getTransport();
    wire = transport.getWire();
  }

  @Override
  public JsonElement serialize(InputStream src, Type typeOfSrc, JsonSerializationContext context) {
    if (log.isDebugEnabled()) log.debug("serialize({}", src);
    
    // Provide the stream as BContentStream
    BContentStream bstream = null;
    if (src instanceof BContentStream) {
      bstream = (BContentStream)src;
    }
    else {
      bstream = new BContentStreamWrapper(src);
    }
    
    // Create a BTargetId to be able to manage the stream in HActiveMessages
    int serverId = transport.getConnectedServerId();
    long messageId = 0;
    long streamId = transport.getWire().makeMessageId();
    BTargetId targetId = new BTargetId(serverId, messageId, streamId);
    bstream.setTargetId(targetId);
    
    // Add the stream to the outgoing streams in HActiveMessages
    long trackingId = streamId;
    wire.putStreams(trackingId, Arrays.asList(bstream), null);
    
    // Create a JSON object with the URL to download the stream
    JsonObject obj = new JsonObject();
    obj.addProperty("url", "?serverid=" + serverId + "&messageid=" + messageId + "&streamid=" + streamId);

    if (log.isDebugEnabled()) log.debug(")serialize={}", obj);
    return obj;
  }
  
}

