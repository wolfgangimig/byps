package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import byps.BBinaryModel;
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;

public class GeneratorCpp implements Generator {

  public GeneratorCpp() {
  }

  @Override
  public void build(ClassDB classDB, GeneratorProperties props) throws IOException {

    pctxt = new PrintContext(classDB, props);
    printForwardDecls(classDB.getSerials(), classDB.getRemotes());
    printSerials(classDB.getSerials());
    printRemotes(classDB.getRemotes());
    GenRegistry.generate(pctxt, classDB.getSerials(), BBinaryModel.MEDIUM);
    GenApiDescriptor.generate(pctxt, classDB.getApiDescriptor());
    GenClient.generate(pctxt, classDB.getApiDescriptor());
    GenServer.generate(pctxt, classDB.getApiDescriptor());
    pctxt.close();
  }

  private void printRemotes(Collection<RemoteInfo> remotes) throws IOException {
    
    ArrayList<RemoteInfo> sarr = sortRemotesByInheritance(remotes);
    
    for (RemoteInfo rinfo : sarr) {
      GenRemoteClass.generate(pctxt, rinfo.getRemoteNoAuth());
      GenRemoteClassAuth.generate(pctxt, rinfo.getRemoteAuth());
      GenRemoteSkeleton.generate(pctxt, rinfo);
      GenRemoteStub.generate(pctxt, rinfo);
    }
  }
  
  private ArrayList<RemoteInfo> sortRemotesByInheritance(Collection<RemoteInfo> arr) {
    ArrayList<RemoteInfo> sarr = new ArrayList<RemoteInfo>();
    for (RemoteInfo r : arr) {
      int inserIdx = sarr.size();
      for (int i = 0; i < sarr.size(); i++) {
        RemoteInfo rs = sarr.get(i);
        if (rs.baseQNames.contains(r.qname)) {
          inserIdx = i;
          break;
        }
      }
      sarr.add(inserIdx, r);
    }
    return sarr;
  }

  private ArrayList<SerialInfo> sortSerialsByInheritance(Collection<SerialInfo> arr) {
    ArrayList<SerialInfo> sarr = new ArrayList<SerialInfo>();
    for (SerialInfo s : arr) {
      int inserIdx = sarr.size();
      for (int i = 0; i < sarr.size(); i++) {
        SerialInfo ss = sarr.get(i);
        if (ss.baseFullName.equals(s.qname)) {
          inserIdx = i;
          break;
        }
      }
      sarr.add(inserIdx, s);
    }
    return sarr;
  }

  private boolean isUsedBy_TypeInfo(TypeInfo tinfo, TypeInfo tinfo2) {
    if (tinfo.toString().equals(tinfo2.toString())) return true;
    for (TypeInfo tinfoArg : tinfo2.typeArgs) {
      if (tinfoArg.toString().equals(tinfo2.toString())) return true;
    }
    return false;
  }

  private boolean isUsedBy_SerialInfo(SerialInfo sinfo, SerialInfo sinfo2) {
    if (isUsedBy_TypeInfo(sinfo, sinfo2)) return true;
    for (MemberInfo minfo : sinfo2.members) {
      if (isUsedBy_TypeInfo(minfo.type, sinfo2)) return true;
    }
    return false;
  }

  private int findInsertPosForSerialInfo(SerialInfo sinfo, ArrayList<SerialInfo> arr) {
    int idx = 0;
    if (sinfo.isEnum){
      idx = 0;
    }
    else if (sinfo.isInline) {
      for (int i = 0; i < arr.size(); i++) {
        SerialInfo sinfo2 = arr.get(i);
        if (!sinfo2.isInline || isUsedBy_SerialInfo(sinfo, sinfo2)) {
          idx = i;
          break;
        }
      }
    }
    else {
      idx = arr.size();
    }
    return idx;
  }
  
  protected void printForwardDecls(Collection<SerialInfo> serials, Collection<RemoteInfo> remotes) throws IOException {
    ArrayList<TypeInfo> all = new ArrayList<TypeInfo>();
    all.addAll(serials);
    all.addAll(remotes);
    for (RemoteInfo rinfo : remotes) {
      RemoteInfo rauthInfo = rinfo.getRemoteAuth();
      if (rauthInfo != null) all.add(rauthInfo);
    }
    GenApiClassFwd.generate(pctxt, all);
  }

  protected void printSerials(Collection<SerialInfo> serials) throws IOException {

    // Put base classes before child classes.
    ArrayList<SerialInfo> sarr = sortSerialsByInheritance(serials);
    
    // Klassen so sortieren, dass die Inline-Klassen zuerst kommen.
    // Dabei muss eine Inline-Klasse, die in einer anderen verwendet wird,
    // vor der anderen einsortiert werden.
    ArrayList<SerialInfo> arr = new ArrayList<SerialInfo>(sarr.size());
    for (SerialInfo sinfo : sarr) {
      int idx = findInsertPosForSerialInfo(sinfo, arr);
      arr.add(idx, sinfo);
    }

    for (SerialInfo sinfo : arr) {
      GenApiClass.generate(pctxt, sinfo);
    }
  }

  private PrintContext pctxt;
}
