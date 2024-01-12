package byps.log;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class abstracts the logger configuration. <br>
 * BYPS-16
 */
public class LogConfigurator {

  private static final LogFramework log;
  static {
    Logger root = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    String loggerName = root.getClass().getName();
    if (loggerName.equals("ch.qos.logback.classic.Logger"))
      log = new Logback(root);
    else
      log = new NOPLogger();
  }

  private LogConfigurator() {
  }

  /**
   * Initialize the underlying logging framework. The output will be logged to
   * STDOUT, existing configurations will be overridden.
   * 
   * @param level
   *          String Must be one of "TRACE", "DEBUG", "INFO", "WARN", "ERROR",
   *          "FATAL" or "OFF"
   */
  public static void initConsole(String level) {
    log.initConsole(level);
  }

  /**
   * Initialize the underlying logging framework. The output will be logged to
   * STDOUT, existing configurations will be overridden.
   * 
   * @param level
   *          String Must be one of "TRACE", "DEBUG", "INFO", "WARN", "ERROR",
   *          "FATAL" or "OFF"
   * @param file
   *          String representing a path to a file. The caller of this function
   *          must ensure that the value is valid.
   */
  public static void initFile(String level, String file) {
    log.initFile(level, file);
  }

  /**
   * Switches the level of the root logger at runtime.
   * 
   * @param level
   *          String Must be one of "TRACE", "DEBUG", "INFO", "WARN", "ERROR",
   *          "FATAL" or "OFF"
   */
  public static void setLevel(String level) {
    log.setLevel(level);
  }
}
