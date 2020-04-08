package byps.log;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;

/**
 * Provides {@link LogFramework} implementation for the log4j (1) logging
 * framework. <br>
 * BYPS-16
 */
class Log4J implements LogFramework {

  private final org.apache.log4j.Logger root;

  Log4J(Logger root) {
    this.root = extractLog4jLogger(root);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initConsole(String level) {
    Properties props = new Properties();
    props.put("log4j.rootLogger", level + ", stdout");
    props.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
    props.put("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
    props.put("log4j.appender.stdout.layout.ConversionPattern", "%d{ABSOLUTE} %t %1x %-5p (%F:%L) - %m%n");
    PropertyConfigurator.configure(props);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initFile(String level, String file) {
    Properties log4j = new Properties();
    log4j.setProperty("log4j.rootLogger", level + ", FI");
    log4j.setProperty("log4j.appender.FI", "org.apache.log4j.DailyRollingFileAppender");
    log4j.setProperty("log4j.appender.FI.File", file);
    log4j.setProperty("log4j.appender.FI.DatePattern", "'.'yyyy-MM-dd");
    log4j.setProperty("log4j.appender.FI.layout", "org.apache.log4j.PatternLayout");
    log4j.setProperty("log4j.appender.FI.layout.ConversionPattern", "%d{ABSOLUTE} %t %1x %-5p (%F:%L) - %m%n");
    log4j.setProperty("log4j.appender.FI.append", "false");
    PropertyConfigurator.configure(log4j);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLevel(String level) {
    if (level.isEmpty())
      level = "INFO";
    switch (level.toUpperCase().charAt(0)) {
    case 'D': // "DEBUG":
      root.setLevel(Level.DEBUG);
      break;
    case 'I': // "INFO":
      root.setLevel(Level.INFO);
      break;
    case 'W': // "WARN":
      root.setLevel(Level.WARN);
      break;
    case 'E': // "ERROR":
    default:
      root.setLevel(Level.ERROR);
      break;
    }
  }

  /**
   * Extracts the actual log4j {@link org.apache.log4j.Logger} from the provided
   * slf4j-root-Logger. We need to do this as log4j does not provide an own
   * implementation to the slf4j logging facade.
   * 
   * @param root
   * @return {@link org.apache.log4j.Logger}
   */
  private org.apache.log4j.Logger extractLog4jLogger(Logger root) {
    Field[] fields = root.getClass().getDeclaredFields();
    for (Field f : fields) {
      if (f.getType().equals(org.apache.log4j.Logger.class)) {
        f.setAccessible(true);
        try {
          return (org.apache.log4j.Logger) f.get(root);
        } catch (Exception e) {
          e.printStackTrace();
          throw new IllegalStateException("Cannot access log4j logger", e);
        }
      }
    }
    return null;
  }
}
