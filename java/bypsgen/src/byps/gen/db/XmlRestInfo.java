package byps.gen.db;

import byps.gen.api.rest.RestInfo;

public class XmlRestInfo extends RestInfo {
  
  public XmlRestInfo() {
  }

  public XmlRestInfo(RestInfo restInfo) {
    super(restInfo);
  }

  public static RestInfo toValue(XmlRestInfo restInfo) {
    return restInfo != null ? restInfo : null;
  }
  
  public static XmlRestInfo fromValue(RestInfo restInfo) {
    return restInfo != null && !restInfo.isEmpty() ? new XmlRestInfo(restInfo) : null;
  }
}
