package byps.http.stdio.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.stdio.common.RecvChannel;
import byps.stdio.common.SendChannel;
import byps.stdio.common.StdioChannel;

/**
 * Test communication via stdin/stdout between processes.
 * This class starts the program byps.stdio.common.EchoProgram.class
 * to simulate communication over stdin/stdout.
 */
public class TestStdio {

  int nbOfEchos = 10;
  List<EchoChannels> echoChannels = new ArrayList<>();

  private static class EchoChannels {
    private OutputStream system_out;
    private InputStream system_in;
    private SendChannel sendChannel;
    private RecvChannel recvChannel;
    private Process proc;

    void startEchoProgram() {
      try {
        String javaHome = System.getProperty("java.home");
        String javaProg = System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java";
        File javaExe = new File(new File(javaHome, "bin"), javaProg);
        String echoProgram = Paths.get(".", "build", "libs", "bypshttp-shmem-all.jar").toString();
        ProcessBuilder pbuilder = new ProcessBuilder(javaExe.getAbsolutePath(), "-jar", echoProgram);
        // "d:\\temp\\log\\byps-stdout.txt",
        // "d:\\temp\\log\\byps-stderr.txt");
        proc = pbuilder.start();
        system_out = proc.getOutputStream();
        system_in = proc.getInputStream();
        sendChannel = new SendChannel(system_out);
        sendChannel.open();
        recvChannel = new RecvChannel(system_in);
        recvChannel.open();
        if (proc.waitFor(1, TimeUnit.SECONDS)) {
          int ret = proc.exitValue();
          throw new IllegalStateException("Echo program terminated " + ret);
        }
      } catch (Exception e) {
        throw new IllegalStateException(e);
      }
    }

    void terminateEchoProgram() {
      if (proc == null) return;
      try {
        sendChannel.terminate();

        if (proc.waitFor(10, TimeUnit.SECONDS)) {
          int ret = proc.exitValue();
          if (ret != 0) {
            System.err.println("echo-program failed: " + ret);
          }
        } else {
          System.err.println("echo-program cannot be terminated");
        }
      } catch (Exception e) {
        throw new IllegalStateException(e);
      }
    }
    
    ByteBuffer send(int method, int messageId, ByteBuffer msg) throws Exception {
      sendChannel.send(method, messageId, msg);
      return recvChannel.recv();
    }
    
  }

  @Before
  public void beforeTest() throws Exception {
    for (int i = 0; i < nbOfEchos; i++) echoChannels.add(new EchoChannels());
    echoChannels.forEach(EchoChannels::startEchoProgram);
  }

  @After
  public void afterTest() throws Exception {
    echoChannels.forEach(EchoChannels::terminateEchoProgram);
  }

  @Test
  public void testSend() throws Exception {
    
    ThreadPoolExecutor tpool = (ThreadPoolExecutor) Executors.newFixedThreadPool(nbOfEchos);
    for (int i = 0; i < nbOfEchos; i++) {
      EchoChannels echo = echoChannels.get(i);
      tpool.execute(() -> {
        try {
          checkSendMessage(echo);
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      });
    }
    
    tpool.shutdown();
    
  }
  
  
  private Random rand = new Random();

  private void checkSendMessage(EchoChannels echo) throws Exception {
    long t1 = System.currentTimeMillis();

    ByteBuffer msg = ByteBuffer.allocate(255);
    for (int i = 1; i <= 100; i++) {
      msg.put((byte) rand.nextInt());
    }

    // for (int i = 0; i < 1000; i++) {
    msg.flip();
    ByteBuffer msgR = echo.send(StdioChannel.HTTP_POST, 987, msg);
    // }

    msg.flip();
    
    String th = Thread.currentThread().getName();

    System.out.println(th + " msg.length=" + msg.remaining() + ", msgR.length=" + msgR.remaining());

    int messageId = msgR.getInt();
    int method = msgR.getInt();
    System.out.println(th + " messageId=" + messageId + ", method=" + method);
    for (int i = 0; i < 100; i++) {
      byte e = msg.get();
      byte r = msgR.get();
      if (e != r) {
        System.out.println(th + " Wrong byte at " + i + ": expected=" + e + ", read=" + r);
        break;
      }
    }

    long t2 = System.currentTimeMillis();
    System.out.println(th + " time=" + (t2 - t1));
  }

}
