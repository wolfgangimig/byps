package byps.http.stdio.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.stdio.client.StdioClient;
import byps.stdio.common.RecvChannel;
import byps.stdio.common.SendChannel;
import byps.stdio.common.StdioChannel;

/**
 * Test communication via stdin/stdout between processes.
 * This class starts the program byps.stdio.common.EchoProgram.class
 * to simulate communication over stdin/stdout.
 */
public class TestStdio {
  
  private OutputStream system_out;
  private InputStream system_in;
  private Process proc;
  
  private void startEchoProgram() throws Exception {
    String javaHome = System.getProperty("java.home");
    File javaExe = new File(new File(javaHome, "bin"), "java.exe");
    ProcessBuilder pbuilder = new ProcessBuilder(
        javaExe.getAbsolutePath(),
        "-jar",
        ".\\dist\\echo-program.jar");
//        "d:\\temp\\log\\byps-stdout.txt",
//        "d:\\temp\\log\\byps-stderr.txt");
    proc = pbuilder.start();
    system_out = proc.getOutputStream();
    system_in = proc.getInputStream();
    if (proc.waitFor(1, TimeUnit.SECONDS)) {
      int ret = proc.exitValue();
      throw new IllegalStateException("Echo program terminated " + ret);
    }
  }
  
  private void terminateEchoProgram() throws Exception {
    if (proc == null) return;
    
    SendChannel client = new SendChannel(system_out);
    client.open();
    client.terminate();
    
    if (proc.waitFor(10, TimeUnit.SECONDS)) {
      int ret = proc.exitValue();
      if (ret != 0) {
        System.err.println("echo-program failed: " + ret);
      }
    }
    else {
      System.err.println("echo-program cannot be terminated");
    }
  }
  
  @Before
  public void beforeTest() throws Exception {
    startEchoProgram(); 
  }

  @After
  public void afterTest() throws Exception {
    terminateEchoProgram(); 
  }

  @Test
  public void testSend() throws Exception {
    
    SendChannel client = new SendChannel(system_out);
    RecvChannel server = new RecvChannel(system_in);

    client.open();
    server.open();
    
    long t1 = System.currentTimeMillis();
    
    ByteBuffer msg = ByteBuffer.allocate(255);
    for (int i = 1; i <= 100; i++) {
      msg.put((byte)i);
    }

    //for (int i = 0; i < 1000; i++) {
      msg.flip();
      client.send(StdioChannel.HTTP_POST, 987, msg);
      ByteBuffer msgR = server.recv();
    //}
    
    msg.flip();
    
    System.out.println("msg.length=" + msg.remaining() + ", msgR.length=" + msgR.remaining());
    
    int messageId = msgR.getInt();
    int method = msgR.getInt();
    System.out.println("messageId=" + messageId + ", method=" + method);
    for (int i = 0; i < 100; i++) {
      byte e = msg.get();
      byte r = msgR.get();
      if (e != r) {
        System.out.println("Wrong byte at " + i + ": expected=" + e + ", read=" + r);
      }
    }
    
    long t2 = System.currentTimeMillis();
    System.out.println("time=" + (t2-t1));

    client.terminate();
    client.close();
    server.close();
  }

}
