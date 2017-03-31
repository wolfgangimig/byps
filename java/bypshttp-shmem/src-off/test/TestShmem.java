package byps.http.shmem.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

import org.junit.Test;

import byps.http.shmem.common.RecvChannel;
import byps.http.shmem.common.SendChannel;

public class TestShmem {
  
  @Test
  public void testSend() throws Exception {
    File file = new File("D:\\shmem.dat");
    try  {
      SendChannel client = new SendChannel(file);
      
      client.open();
      
      ByteBuffer msg = ByteBuffer.allocate(50);
      msg.put("Nachricht ABCDF1234".getBytes());
      msg.flip();
      client.send(msg);
      
      msg.clear();
      msg.put("Nachricht 123".getBytes());
      msg.flip();
      client.send(msg);
      
    }
    finally {
    }
  }

  @Test
  public void testRecv() throws Exception {
    File file = new File("D:\\shmem.dat");
    try  {
      RecvChannel server = new RecvChannel(file);
      server.open();

      ByteBuffer msgR = server.recv();
      String textR = new String(msgR.array());
      System.out.println("textR=" + textR);
      
      msgR = server.recv();
      textR = new String(msgR.array());
      System.out.println("textR=" + textR);

    }
    finally {
    }

  }
}
