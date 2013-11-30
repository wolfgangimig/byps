package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

public class CustomControl {

  public GenApiClass createGenApiClass(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
    return new GenApiClass(pctxt, serInfo, pr);
  }
  
  public GenConstClass createGenConstClass(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
    return new GenConstClass(pctxt, serInfo, pr);
  }
  
  public GenConstObject createGenConstObject(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
    return new GenConstObject(pctxt, serInfo, pr);
  }
  
  public boolean isIgnoreMember(MemberInfo minfo) {
    return minfo.isTransient;
  }
  
  public static CustomControl instance = new CustomControl();
}
