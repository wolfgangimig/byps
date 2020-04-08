package byps.log;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * Fallback logging implementation in case no supported logging framework was
 * found. <br>
 * BYPS-16
 */
class NOPLogger implements LogFramework {

  @Override
  public void initConsole(String level) {
    // NOP
  }

  @Override
  public void initFile(String level, String file) {
    // NOP
  }

  @Override
  public void setLevel(String level) {
    // NOP
  }

}
