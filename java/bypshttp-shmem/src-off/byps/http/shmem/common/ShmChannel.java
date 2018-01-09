package byps.http.shmem.common;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public abstract class ShmChannel {

  protected File file;
  protected FileChannel fileChannel;
  
  /**
   * First 8 bytes of the channel used for content locking and message length.
   * This range is locked when the sender writes the message or when the receive reads the message.
   */
  protected ByteBuffer bbufWriteLock = ByteBuffer.allocate(8);
  
  /**
   * Next 8 bytes of the channel used for acknowledge-tag locking.
   * This range is locked, when the receiver acknowledges that it has read the message. 
   */
  protected ByteBuffer bbufReadLock = ByteBuffer.allocate(8);
  
  /**
   * Next 8 bytes of the channel used to halt the receiver before entering receive status.
   */
  protected ByteBuffer bbufContinueLock = ByteBuffer.allocate(8);
  
  /**
   * Timeout waiting for locks.
   */
  protected long timeout = 120 * 1000;
  
  /**
   * Lock used for acknowledge.
   */
  private FileLock messageReceiveAcknowlegeLock;

  /**
   * Lock used for message content.
   */
  private FileLock messageContentLock;
  
  /**
   * Lock used to halt receiver.
   */
  private FileLock continueLock;

  /**
   * Constructor.
   * @param file File
   */
  public ShmChannel(File file) {
    this.file = file;
  }
  
  /**
   * Lock message content.
   */
  protected void lockMessageContent() throws Exception {
    if (messageContentLock == null) {
      messageContentLock = fileChannel.lock(0, 8, false);
    }
  }
  
  /**
   * Write message length into the first 8 bytes of the file.
   */
  protected void writeMessageLength(long messageLength) throws Exception {

    if (messageContentLock == null) {
      throw new IllegalStateException("Must have locked message content at this point.");
    }

    // Write message length
    bbufWriteLock.clear();
    bbufWriteLock.putLong(messageLength);
    bbufWriteLock.flip();
    fileChannel.position(0);
    while (bbufWriteLock.remaining() > 0) fileChannel.write(bbufWriteLock);
  }
  
  /**
   * Write message content beginning at file position 24.
   */
  protected void writeMessage(ByteBuffer msg) throws Exception {
    
    if (messageContentLock == null) {
      throw new IllegalStateException("Must have locked message content at this point.");
    }
    
    // Write message content
    fileChannel.position(24);
    while (msg.remaining() > 0) fileChannel.write(msg);
  }
  
  /**
   * Read message length from the first 8 bytes.
   */
  protected long readMessageLength() throws Exception {
    
    long messageLength = 0;
    if (messageContentLock == null) {
      throw new IllegalStateException("Must have locked message content at this point.");
    }

    bbufWriteLock.clear();
    fileChannel.position(0);
    while (bbufWriteLock.remaining() > 0) {
      if (fileChannel.read(bbufWriteLock) < 0) throw new IOException("Unexpected end of stream.");
    }
    bbufWriteLock.flip();
    
    messageLength = bbufWriteLock.getLong();
    return messageLength;
  }
  
  /**
   * Read message content at position 28.
   */
  protected ByteBuffer readMessage(long messageLength) throws Exception {
    
    if (messageContentLock == null) {
      throw new IllegalStateException("Must have locked message content at this point.");
    }

    ByteBuffer msg = ByteBuffer.allocate((int)messageLength);
    fileChannel.position(24);
    while (msg.remaining() > 0) {
      if (fileChannel.read(msg) < 0) throw new IOException("Unexpected end of stream.");
    }
    msg.flip();
    return msg;
  }
  
  /**
   * Write message length as an acknowledge that the message has been received.
   */
  protected void writeMessageReceiveAcknowledge(long messageLength) throws Exception {
    
    if (messageReceiveAcknowlegeLock == null) {
      throw new IllegalStateException("Must have locked acknowledge-tag at this point.");
    }

    // Tell the other side that the message has been read.
    bbufReadLock.clear();
    bbufReadLock.putLong(messageLength);
    bbufReadLock.flip();
    fileChannel.position(8);
    fileChannel.write(bbufReadLock);
  }
  
  /**
   * Unlock message content.
   */
  protected void unlockMessageContent() throws Exception {
    if (messageContentLock != null) {
      messageContentLock.release();
      messageContentLock = null;
    }
  }

  /**
   * Lock acknowledge area.
   */
  protected void lockMessageReceiveAcknowlege() throws Exception {
    if (messageReceiveAcknowlegeLock == null) {
      messageReceiveAcknowlegeLock = fileChannel.lock(8, 8, false);
    }
  }
  
  /**
   * Read message length as an acknowledge from the receiver.
   */
  protected long readMessageReceivedAcknowlege() throws Exception {
    
    if (messageReceiveAcknowlegeLock == null) {
      throw new IllegalStateException("Must have locked acknowledge-tag at this point.");
    }

    bbufReadLock.clear();
    fileChannel.position(8);
    while (bbufReadLock.remaining() > 0) {
      if (fileChannel.read(bbufReadLock) < 0) throw new IOException("Unexpected end of stream.");
    }
    bbufReadLock.flip();
    
    long ret = bbufReadLock.getLong();
    return ret;
  }
  
  /**
   * Unlock acknowledge area.
   */
  protected void unlockMessageReceiveAcknowledge() throws Exception {
    if (messageReceiveAcknowlegeLock != null) {
      messageReceiveAcknowlegeLock.release();
      messageReceiveAcknowlegeLock = null;
    }
  }

  /**
   * Lock continue area.
   */
  protected void lockContinue() throws Exception {
    if (continueLock == null) {
      continueLock = fileChannel.lock(16, 8, false);
    }
  }
  
  /**
   * Unlock continue area.
   */
  protected void unlockContinue() throws Exception {
    if (continueLock != null) {
      continueLock.release();
      continueLock = null;
    }
  }

}
