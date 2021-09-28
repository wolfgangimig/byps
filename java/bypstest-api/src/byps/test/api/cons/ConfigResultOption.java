package byps.test.api.cons;

import byps.BValueClass;

/**
 * Zum Prüfen von BYPS-57.
 * @since 796.0.0.0
 *
 */
public class ConfigResultOption extends BValueClass {
  private final static long serialVersionUID = 1292137034L;
  
  protected GroupingType groupingType;
  
  protected String string1;

  public ConfigResultOption() {
    this.groupingType = GroupingType.BY_KEY;
  }

  public ConfigResultOption(String string1) {
    super();
    this.groupingType = GroupingType.BY_KEY;
    this.string1 = string1;
  }

  public ConfigResultOption(GroupingType groupingType, String string1) {
    super();
    this.groupingType = groupingType;
    this.string1 = string1;
  }

  public GroupingType getGroupingType() {
    return groupingType;
  }

  public void setGroupingType(GroupingType groupingType) {
    this.groupingType = groupingType;
  }

  public String getString1() {
    return string1;
  }

  public void setString1(String string1) {
    this.string1 = string1;
  }
  
  
  
}
