package byps.http.shmem.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeoutException;

public class RecvChannel extends ShmChannel {
  
  public RecvChannel(File file) {
    super(file);
  }
  
  public void open() throws Exception {
    long timeoutAt = System.currentTimeMillis() + timeout;
    do {
      try {
        fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE);
        break;
      }
      catch (FileNotFoundException e) {
        if (System.currentTimeMillis() >= timeoutAt) throw e;
        Thread.sleep(1000);
      }
      catch (Exception e) {
        throw e;
      }
    }
    while (true);

    lockMessageReceiveAcknowlege();
  }
  
  public ByteBuffer recv() throws Exception {

    ByteBuffer msg = null;

    // Make sure the receive area is locked.
    lockMessageReceiveAcknowlege();

    try {

      // Wait until other side has written a message.
      long messageLength = 0;
      long timeoutAt = System.currentTimeMillis() + timeout;
      do {
        lockMessageContent();
        
        messageLength = readMessageLength();
  
        writeMessageLength(0);
  
        if (messageLength != 0) break;
        
        if (System.currentTimeMillis() >= timeoutAt) {
          throw new TimeoutException("Waiting for message timed out.");
        }
        
        Thread.sleep(1000);
      }
      while (true);

      // Read message
      msg = readMessage(messageLength);
      
      // Write acknowledge
      writeMessageReceiveAcknowledge(messageLength);
      
    }
    finally {

      // Notify other side that the message has been read.
      unlockMessageReceiveAcknowledge(); 

      // Notify other side that a new message can be written. 
      unlockMessageContent();
      
    }

    // Other side has locked continue-area until it has
    // read the message acknowledge.
    lockContinue();

    // Other side has read message acknowledge.
    unlockContinue();

    // Enter receive status.
    lockMessageReceiveAcknowlege();

    msg.flip();
    return msg;
  }
}
