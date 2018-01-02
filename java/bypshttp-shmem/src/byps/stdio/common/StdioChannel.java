package byps.stdio.common;

import java.nio.ByteBuffer;

public abstract class StdioChannel {

  public final static int VERSION = 1;
  
  public final static int HTTP_GET = 1;
  public final static int HTTP_POST = 2;
  public final static int HTTP_GET_STREAM = 3;
  public final static int HTTP_PUT_STREAM = 4;

  protected ByteBuffer messageHeader = ByteBuffer.allocate(16);

}
