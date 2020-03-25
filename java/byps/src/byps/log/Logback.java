package byps.log;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.IOException;

import org.slf4j.Logger;

import byps.io.ByteArrayInputStream;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * Provides {@link LogFramework} implementation for the logback (1) logging
 * framework. <br>
 * BYPS-16
 */
class Logback implements LogFramework {

  private final ch.qos.logback.classic.Logger root;

  Logback(Logger root) {
    this.root = (ch.qos.logback.classic.Logger) root;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initConsole(String level) {

    StringBuilder config = new StringBuilder();
    config.append("<configuration>").append(System.lineSeparator());
    config.append("  <appender name=\"STDOUT\" class=\"ch.qos.logback.core.ConsoleAppender\">")
        .append(System.lineSeparator());
    config.append("    <encoder>").append(System.lineSeparator());
    config.append("      <pattern>%d{HH:mm:ss.SSS} %-5level %-60(%thread %X{NDC} \\(%logger{0}.java:%L\\)) - %msg%n</pattern>")
        .append(System.lineSeparator());
    config.append("    </encoder>").append(System.lineSeparator());
    config.append("  </appender>").append(System.lineSeparator());

    config.append("  <root level=\"").append(level).append("\">").append(System.lineSeparator());
    config.append("    <appender-ref ref=\"STDOUT\" />").append(System.lineSeparator());
    config.append("  </root>").append(System.lineSeparator());
    config.append("</configuration>").append(System.lineSeparator());

    configure(config.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initFile(String level, String file) {
    StringBuilder config = new StringBuilder();
    config.append("<configuration>").append(System.lineSeparator());
    config.append("  <appender name=\"FILE\" class=\"ch.qos.logback.core.FileAppender\">")
        .append(System.lineSeparator());
    config.append("    <file>").append(file).append("</file>").append(System.lineSeparator());
    config.append("    <append>false</append>");
    config.append("    <encoder>").append(System.lineSeparator());
    config.append("      <pattern>%d{HH:mm:ss.SSS} %-5level %-60(%thread %X{NDC} \\(%logger{0}.java:%L\\)) - %msg%n</pattern>")
        .append(System.lineSeparator());
    config.append("    </encoder>").append(System.lineSeparator());
    config.append("  </appender>").append(System.lineSeparator());

    config.append("  <root level=\"").append(level).append("\">").append(System.lineSeparator());
    config.append("    <appender-ref ref=\"FILE\" />").append(System.lineSeparator());
    config.append("  </root>").append(System.lineSeparator());
    config.append("</configuration>").append(System.lineSeparator());

    configure(config.toString());
  }

  /**
   * Configures logback with the given configuration.
   * 
   * @param configuration
   *          String representation of the contents actually belonging into a
   *          logback.xml file.
   */
  private void configure(String configuration) {
    JoranConfigurator jc = new JoranConfigurator();
    jc.setContext(root.getLoggerContext());
    root.getLoggerContext().reset();
    try (ByteArrayInputStream in = new ByteArrayInputStream(configuration.getBytes())) {
      jc.doConfigure(in);
    } catch (IOException | JoranException e) {
      e.printStackTrace();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLevel(String level) {
    if (root != null) {
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
  }

}
