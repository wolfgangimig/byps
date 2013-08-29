package com.wilutions.byps.gen.js;

import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

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
