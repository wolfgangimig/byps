package byps.test.api.cons;

import byps.BValueClass;

/**
 * Zum Prüfen von BYPS-57.
 * @since 796.0.0.0
 *
 */
public class ConfigResultOptionC  extends BValueClass {
  private final static long serialVersionUID = 114832566L;

  public static final ConfigResultOption DEFAULT_1 = new ConfigResultOption();
  
  public static final ConfigResultOption DEFAULT_2 = new ConfigResultOption("default2");
  
  public static final ConfigResultOption DEFAULT_3 = new ConfigResultOption(GroupingType.LEGACY, "default3");
  
}
