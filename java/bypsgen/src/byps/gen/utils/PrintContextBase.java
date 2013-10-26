package byps.gen.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import byps.BApiDescriptor;
import byps.BBinaryModel;
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.BRegistryForClassDB;
import byps.gen.db.ClassDB;

public class PrintContextBase {

  public PrintContextBase(ClassDB classDB, GeneratorProperties props) {
    this.classDB = classDB;
    this.apiDesc = classDB.getApiDescriptor();
    this.registry = classDB.getRegistry();
    this.apiName = apiDesc.name;
    this.apiPack = apiDesc.basePackage;
    this.props = props;
  }

  public String getSerializerClassName(TypeInfo tinfo, BBinaryModel pformat) {
    if (tinfo == null) return "";
    String s = pformat == BBinaryModel.JSON ? "JSerializer_" : "BSerializer_";
    return s + tinfo.typeId;
  }

  public String getSerializerPackage(TypeInfo tinfo) {
    if (tinfo == null) return "";
    String s = "";
    if (tinfo.typeId < registry.getMinTypeIdUser()) {
      s = "byps";
    }
    else if (tinfo.isArrayType() || tinfo.isCollectionType()) {
      s = apiPack;
    }
    else {
      s = tinfo.pack;
    }
    return s;
  }

  public String getSerializerQName(TypeInfo tinfo, BBinaryModel pformat) {
    if (tinfo == null) return "";
    return getSerializerPackage(tinfo) + "." + getSerializerClassName(tinfo, pformat);
  }

  public String getMethodSerializerClassName(TypeInfo remoteInfo, String methodName, BBinaryModel pformat) {
    return getSerializerClassName(remoteInfo, pformat) + "_" + methodName;
  }

  public void printComputeSize(CodePrinter pr, SerialInfo serInfo, BBinaryModel bmodel) throws IOException {
    int size = serInfo.baseInfo != null ? Utils.computeStructSize(bmodel, serInfo.baseInfo) : 0;

    pr.println("return 0");

    String indent = "       ";

    pr.print(indent).println("/* size of base class */ + 0");

    for (MemberInfo minfo : serInfo.members) {
      int memberSize = minfo.type.getMemberSize(bmodel);
      int pad = Utils.getPaddingForAlignedPosition(bmodel, size, memberSize);
      if (pad != 0) {
        size += pad;
        pr.print(indent).print("/* padding */ + " + pad);
        pr.println();
      }
      pr.print(indent).print("/* pos=" + size).print(": ").print(minfo.name).print(" */ + " + memberSize);
      pr.println();
      size += memberSize;
    }

    // structure size must be a multiple of its alignment
    {
      int pad = Utils.getPaddingForAlignedPosition(bmodel, size, 8);
      size += pad;
      pr.print(indent).print("/* padding up to multiple of alignment */ + " + pad + ";");
      pr.println();
    }
  }

  public boolean isGenerateChangedMembers() {
    String val = props.getProperty(GeneratorProperties.CHANGED_MEMBERS);
    return val != null && val.equalsIgnoreCase("true");
  }

  public String getElementSelectorClassName(TypeInfo tinfo) {
    String s = tinfo.name + "C";
    return s;
  }

  public String getElementSelectorName(MemberInfo minfo) {
    String s = "mb" + Utils.firstCharToUpper(minfo.name);
    return s;
  }

  public String printStringChar(char c) {
    StringBuilder sbuf = new StringBuilder();
    // if (Character.isLetterOrDigit(c)) sbuf.append(c);
    if (c == '\0') sbuf.append("\\0");
    else if (c == '\\') sbuf.append("\\\\");
    else if (c == '\t') sbuf.append("\\t");
    else if (c == '\r') sbuf.append("\\r");
    else if (c == '\n') sbuf.append("\\n");
    else if (c == '\b') sbuf.append("\\b");
    else if (c == '\"') sbuf.append("\\\"");
    else if (c == '\'') sbuf.append("\\\'");
    else if (c >= 0x20 && c <= 0x7F) sbuf.append(c);
    else {
      sbuf.append("\\u");
      String s = Integer.toHexString((int) c);
      for (int i = s.length(); i < 4; i++)
        sbuf.append("0");
      sbuf.append(s);
    }
    return sbuf.toString();
  }

  public boolean isSessionParam(RemoteInfo rinfo, MemberInfo pinfo) {
    return (rinfo != null && rinfo.authParamClassName != null && pinfo.type.qname.equals(rinfo.authParamClassName));
  }

  public void collectAllRemotesForStubOrSkeleton(RemoteInfo rinfo, HashMap<String, RemoteInfo> remotes) throws GeneratorException {
    if (remotes.containsKey(rinfo.qname)) return;
    remotes.put(rinfo.qname, rinfo);
    for (String r : rinfo.baseQNames) {
      RemoteInfo rinfoBase = classDB.getRemoteInfo(r);
      if (rinfoBase == null) {
        throw new GeneratorException("Missing interface class for " + r);
      }
      collectAllRemotesForStubOrSkeleton(rinfoBase, remotes);
    }
  }

  public ArrayList<String> getBaseQNamesForRemoteWithAuth(RemoteInfo rinfo) {
    ArrayList<String> ret = new ArrayList<String>();

    for (String baseName : rinfo.baseQNames) {
      RemoteInfo rbase = classDB.getRemoteInfo(baseName);
      RemoteInfo rbaseImpl = rbase.getRemoteAuth();
      ret.add(rbaseImpl != null ? rbaseImpl.qname : rbase.qname);
    }
    
    return ret;
  }
  
  public ArrayList<SerialInfo> getSerializersForRegistrySortedByTypeId(Iterable<SerialInfo> serInfos) {
    
    Comparator<SerialInfo> cmp = new Comparator<SerialInfo>() {

      @Override
      public int compare(SerialInfo o1, SerialInfo o2) {
        return o1.typeId - o2.typeId;
      }
      
    };
    
    ArrayList<SerialInfo> serializers = new ArrayList<SerialInfo>();
     for (SerialInfo serInfo : serInfos) {
        if (serInfo.isBuiltInType()) continue;
        if (!serInfo.isPointerType()) continue;
        int idx = Collections.binarySearch(serializers, serInfo, cmp);
        if (idx < 0) {
          idx = -(idx + 1);
          serializers.add(idx, serInfo);
        }
        else {
          // This error should have already been caught during the javadoc process. 
          throw new IllegalStateException("Serializers have same typeId, " + serInfo + ", " + serializers.get(idx));
        }
     }
   
     return serializers;
  }
  


  protected String apiName;
  public final String apiPack;
  public final BBinaryModel bmodel = BBinaryModel.MEDIUM;
  public final ClassDB classDB;
  protected final BRegistryForClassDB registry;
  protected final BApiDescriptor apiDesc;
  public final GeneratorProperties props;
}
