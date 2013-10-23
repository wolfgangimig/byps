package byps.gen.js;

import byps.gen.api.MemberInfo;

public class CustomControlIX extends CustomControl {

  public boolean isIgnoreMember(MemberInfo minfo) {
    if (super.isIgnoreMember(minfo)) return true;
    return minfo.name.equals("changedMembers");
  }

  
}
