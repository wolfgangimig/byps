package byps.http.shmem.common;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeoutException;

public class SendChannel extends ShmChannel {
  
  public SendChannel(File file) {
    super(file);
  }
  
  public void open() throws Exception {
    fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
    ByteBuffer bbuf = ByteBuffer.wrap(new byte[24]);
    fileChannel.write(bbuf); 
    lockMessageContent();
  }
  
  public void close() throws Exception {
    if (fileChannel != null) {
      fileChannel.close();
    }
  }
  
  public void send(ByteBuffer msg) throws Exception {

    if (msg.remaining() == 0) {
      throw new IOException("Empty messages cannot be transferred.");
    }

    // Lock message content area.
    lockMessageContent();

    // After the receiver has read the message, it has to wait  
    // until we have read the message-acknowledge.  
    lockContinue();

    // Write message data
    writeMessageLength(msg.remaining());
    writeMessage(msg);

    // Release the write-lock on which the receiver is waiting.
    unlockMessageContent();
    
    // The receiver reads the message here...
    //
    
    // Wait until the receiver has read the message.
    boolean messageReadAcknowlege = false;
    long timeoutAt = System.currentTimeMillis() + timeout;
    do {
      lockMessageReceiveAcknowlege();
      
      // Read acknowledge from receiver
      messageReadAcknowlege = readMessageReceivedAcknowlege() != 0;
      
      writeMessageReceiveAcknowledge(0);
      
      unlockMessageReceiveAcknowledge();
      
      if (messageReadAcknowlege) break;
      
      if (System.currentTimeMillis() > timeoutAt) {
        throw new TimeoutException("Waiting for receive timed out.");
      }
      Thread.sleep(1000);
    }
    while (true);
    
    // Acquire content-lock again. 
    lockMessageContent(); 

    // We have read the acknowledge.
    // The receiver can enter receive status.
    unlockContinue();

  }
}
