package byps.stdio.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/**
 * Program that sends received bytes from stdin to stdout.
 * Compile this program as a runnable jar, e.g. use make-echoprogram.xml 
 *
 */
public class EchoProgram {
  
  private final static int ERROR_IO = 1;
  private final static int ERROR_REDIRECT_STDOUT = 2;
  private final static int ERROR_REDIRECT_STDERR = 3;
  

  public static void main(String[] args) {
    int ret = 0;

    SendChannel send = new SendChannel(System.out);
    RecvChannel recv = new RecvChannel(System.in);

    redirectStdout(args);
    redirectStderr(args);
   
    try {
      System.out.println("send.open");
      send.open();
      System.out.println("send.recv");
      recv.open();
      
      ByteBuffer msg = null;
      while (true) {
        System.out.println("recv...");
        msg = recv.recv();
        System.out.println("recv msg=" + msg);
        if (msg == null) break;
        int messageId = msg.getInt();
        int method = msg.getInt();
        send.send(method, messageId, msg);
      }
      
      System.out.println("send.terminate");
      send.terminate();
    }
    catch (Exception e) {
      ret = ERROR_IO;
      e.printStackTrace();
    }
    finally {
      System.out.println("send.close");
      send.close();
      System.out.println("recv.close");
      recv.close();
    }
    
    System.out.println("exit " + ret);
    System.exit(ret);
  }

  private static void redirectStdout(String[] args) {
    try {
      File stdoutFile = null;
      if (args.length >= 1) {
        stdoutFile = new File(args[0]);
      }
      else {
          stdoutFile = File.createTempFile("byps-stdout", ".txt");
      }
      
      PrintStream ostreamFile = new PrintStream(new FileOutputStream(stdoutFile));
      System.setOut(ostreamFile);
      
    } catch (IOException e) {
      System.exit(ERROR_REDIRECT_STDOUT);
    }
  }

  private static void redirectStderr(String[] args) {
    try {
      File stderrFile = null;
      if (args.length >= 2) {
        stderrFile = new File(args[1]);
      }
      else {
        stderrFile = File.createTempFile("byps-stderr", ".txt");
      }
      
      PrintStream ostreamFile = new PrintStream(new FileOutputStream(stderrFile));
      System.setErr(ostreamFile);
      
    } catch (IOException e) {
      System.exit(ERROR_REDIRECT_STDERR);
    }
  }
}
