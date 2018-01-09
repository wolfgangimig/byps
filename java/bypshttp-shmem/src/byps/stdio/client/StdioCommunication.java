package byps.stdio.client;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import byps.stdio.common.RecvChannel;
import byps.stdio.common.SendChannel;

public abstract class StdioCommunication {

  protected String programPath;
  protected Process proc;
  
  protected OutputStream system_out;
  protected InputStream system_in;
  protected SendChannel sendChannel;
  protected RecvChannel recvChannel;
  protected Thread receiverThread;
  protected volatile boolean stopEvent = false;
  
  public StdioCommunication(String programPath) {
    this.programPath = programPath;
  }
  
  public StdioCommunication(InputStream system_in, OutputStream system_out) {
    this.system_in = system_in;
    this.system_out = system_out;
  }
  
  public void done() {
    stopEvent = true;
    
    synchronized(this) {
      this.notifyAll();
    }
    
    if (sendChannel != null) {
      try {
        sendChannel.terminate();
      }
      catch (Exception ignored) {}
    }

    if (receiverThread != null) {
//      receiverThread.interrupt(); hangs sometimes
      try {
        receiverThread.join(1000);
      } catch (InterruptedException e) {}
      receiverThread = null;
    }

    synchronized(this) {
      if (sendChannel != null) {
        sendChannel.close();
        sendChannel = null;
      }
  
      if (recvChannel != null) {
        recvChannel.close();
        recvChannel = null;
      }
    }
  }
  
  public synchronized void start() throws Exception {
    ensurePeerProgram_unsync();
    receiverThread.start();
  }
  
  protected abstract void handleException(Throwable e);
  
  protected abstract void handleReceivedMessage(int messageId, int method, ByteBuffer bbuf);

  protected void ensurePeerProgram_unsync() throws Exception {
    if (sendChannel == null) {
      
      if (programPath != null && !programPath.isEmpty()) {
        startPeerProgram();
      }
      
      sendChannel = new SendChannel(system_out);
      recvChannel = new RecvChannel(system_in);

      sendChannel.open();
      recvChannel.open();
      
      receiverThread = new Thread("byps-recv") {
        public void run() {
          while (!isInterrupted() && !stopEvent) {
            try {
              ByteBuffer bbuf = recvChannel.recv();
              if (bbuf == null) {
                // Channel closed by peer.
                break;
              }
              else if (recvChannel.isTerminate()) {
                break;
              }
              else {
                int messageId = bbuf.getInt();
                int method = bbuf.getInt();
                handleReceivedMessage(messageId, method, bbuf);
              }
            }
            catch (InterruptedException e) {
              handleException(e);
              break;
            }
            catch (Exception e) {
              handleException(e);
              break;
            }
          }
        }
      };
      
    }
  }
  
  private void startPeerProgram() throws Exception {
    String javaHome = System.getProperty("java.home");
    String javaProg = System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java";
    File javaExe = new File(new File(javaHome, "bin"), javaProg);
    ProcessBuilder pbuilder = new ProcessBuilder(
        javaExe.getAbsolutePath(),
        "-jar",
        programPath);
//        ".\\dist\\echo-program.jar");
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

}
