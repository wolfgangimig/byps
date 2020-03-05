package byps.log;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * Internal interface that abstracts configuration of logging frameworks. <br>
 * BYPS-16
 */
interface LogFramework {

  /**
   * @see LogConfigurator#initConsole(String)
   */
  void initConsole(String level);

  /**
   * @see LogConfigurator#initFile(String, String)
   */
  void initFile(String level, String file);

  /**
   * @see LogConfigurator#setLevel(String)
   */
  void setLevel(String level);
}
