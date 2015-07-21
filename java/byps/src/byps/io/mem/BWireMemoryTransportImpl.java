package byps.io.mem;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;

public class BWireMemoryTransportImpl {

  public synchronized void putMessage(long messageId, byte[] buf) {
    
    if (cancelledMessages.get(messageId) != null) throw new IllegalStateException("Message has been cancelled");
    if (stopped) throw new IllegalStateException("Stopped");
      
    MyMessage msg = new MyMessage();
    msg.messageId = messageId;
    msg.raw = buf;
    messages.put(messageId, msg);
    this.notifyAll();
  }

  public synchronized byte[] waitForMessage() throws InterruptedException {
    MyMessage msg = null;

    do {

      if (stopped) throw new IllegalStateException("Stopped");

      while (messages.size() == 0) {

        if (stopped) throw new IllegalStateException("Stopped");

        this.wait(10 * 1000);
      }

      Map.Entry<Long, MyMessage> entry = messages.entrySet().iterator().next();
      msg = entry.getValue();
      messages.remove(msg.messageId);
      
    } while (cancelledMessages.get(msg.messageId) != null);
    
    return msg.raw;
  }
  
  public synchronized void cancel(long messageId) {
    
    maybeCleanupCancelledMessages();
    
    cancelledMessages.put(messageId, System.currentTimeMillis());
    this.notifyAll();
  }
  
  public synchronized void done() {
    stopped = true;
    this.notifyAll();
  }

  public synchronized void putStream(long messageId, long streamId, InputStream istream) {

    if (cancelledMessages.get(messageId) != null) throw new IllegalStateException("Message has been cancelled");
    if (stopped) throw new IllegalStateException("Stopped");
    
    MyStream mstream = new MyStream();
    mstream.istream = istream;
    mstream.messageId = messageId;
    mstream.streamId = streamId;
    streams.put(streamId, mstream);
    this.notifyAll();
  }

  public synchronized InputStream waitForStream(long messageId, long streamId)
      throws InterruptedException {
    MyStream ret = null;
    
    while (true) {
      
      if (cancelledMessages.get(messageId) != null) throw new IllegalStateException("Message has been cancelled");
      if (stopped) throw new IllegalStateException("Stopped");

      ret = streams.remove(streamId);
      if (ret != null) break;
      
      this.wait(10 * 1000);
    }
    
    return ret != null ? ret.istream : null;
  }

  public synchronized void putResponse(long messageId, byte[] buf) {

    if (cancelledMessages.get(messageId) != null) throw new IllegalStateException("Message has been cancelled");
    if (stopped) throw new IllegalStateException("Stopped");

    MyMessage msg = new MyMessage();
    msg.messageId = messageId;
    msg.raw = buf;
    responses.put(messageId, msg);
    this.notifyAll();
  }

  public synchronized byte[] waitForResponse(long messageId)
      throws InterruptedException {
    MyMessage msg = null;

    while (true) {
      
      if (cancelledMessages.get(messageId) != null) throw new IllegalStateException("Message has been cancelled");
      if (stopped) throw new IllegalStateException("Stopped");

      msg = responses.remove(messageId);
      if (msg != null) break;
      
      this.wait(10 * 1000);
    }
    
    return msg != null ? msg.raw : null;
  }

  private void maybeCleanupCancelledMessages() {
    if (cancelledMessages.size() > MAX_CANCELLED_MESSAGES) {
      
      ArrayList<Map.Entry<Long,Long>> timeToMessageId = new ArrayList<Map.Entry<Long,Long>>();
      for (Map.Entry<Long,Long> e : cancelledMessages.entrySet()) {
        timeToMessageId.add(e);
      }

      Collections.sort(timeToMessageId, new Comparator<Map.Entry<Long,Long>>() {
        public int compare(Entry<Long, Long> o1, Entry<Long, Long> o2) {
          long v = (long)o1.getValue() - (long)o2.getValue();
          if (v > 0) return 1;
          if (v < 0) return -1;
          return 0;
        }
      });
      
      for (int i = timeToMessageId.size()-1; i >= MAX_CANCELLED_MESSAGES; i--) {
        Map.Entry<Long,Long> e = timeToMessageId.get(i);
        cancelledMessages.remove(e.getKey());
      }
    }
  }

  private static class MyMessage {
    long messageId;
    byte[] raw;
  }

  private HashMap<Long, MyMessage> messages = new HashMap<Long, MyMessage>();
  private HashMap<Long, MyMessage> responses = new HashMap<Long, MyMessage>();
  
  private static class MyStream {
    @SuppressWarnings("unused")
    long messageId;
    @SuppressWarnings("unused")
    long streamId;
    InputStream istream;
  }
  
  private HashMap<Long, MyStream> streams = new HashMap<Long, MyStream>();

  private final static int MAX_CANCELLED_MESSAGES = 1000;
  private HashMap<Long, Long> cancelledMessages = new HashMap<Long, Long>();

  private boolean stopped;
}
