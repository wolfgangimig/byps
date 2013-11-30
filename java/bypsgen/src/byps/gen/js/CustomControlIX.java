package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.MemberInfo;

public class CustomControlIX extends CustomControl {

  public boolean isIgnoreMember(MemberInfo minfo) {
    if (super.isIgnoreMember(minfo)) return true;
    return minfo.name.equals("changedMembers");
  }

  
}
