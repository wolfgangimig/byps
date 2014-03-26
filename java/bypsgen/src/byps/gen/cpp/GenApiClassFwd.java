package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

class GenApiClassFwd {
	
	static Log log = LogFactory.getLog(GenApiClassFwd.class);
	
	enum EForwardMode { NOTHING, PUBLIC, PRIVATE };
	
	private static EForwardMode getForwardDeclMode(TypeInfoCpp tinfoCpp) {
	  TypeInfo tinfo = tinfoCpp.tinfo;
	  EForwardMode ret = EForwardMode.NOTHING;
    SerialInfo serInfo = (tinfo instanceof SerialInfo) ? (SerialInfo)tinfo : null;
	  
    if (tinfo.isBuiltInType()) {
      // Für int, long, java.lang.String, java.lang.Object, java.util.Map, usw.
      // werden keine Forward-Decl benötigt
    }
    else if (tinfo.isInline || tinfo.isEnum) {
      
    }
    else if (tinfo.isExceptionType()) {
      
    }
    else if (tinfo.isAnyType()) {
      
    }
    else if (tinfo.isByteArray1dim()) {
      
    }
    else if (tinfo.isCollectionType()) {
      if (tinfoCpp.isSimpleNameAvailable()) {
        ret = EForwardMode.PUBLIC;
      }
    }
    else if (serInfo != null && serInfo.isResultClass()) {
      // kein shared_ptr benötigt 
    }
    else if (serInfo != null && serInfo.isRequestClass()) {
      ret = EForwardMode.PRIVATE;
    }
    else {
      ret = EForwardMode.PUBLIC;
    }
    
    return ret;
	}
	
	static void generate(PrintContext pctxt, Collection<? extends TypeInfo> tinfos) throws IOException {
	  new GenApiClassFwd(pctxt, tinfos).generate();
	}

	private GenApiClassFwd(PrintContext pctxt, Collection<? extends TypeInfo> tinfos) {
		this.pctxt = pctxt;

		mapPublicTypeInfos = splitSerialsIntoNamespaces(pctxt, tinfos);
//		arrPrivateTypeInfos = getSerialsForPrivateForwardDefs(pctxt, tinfos);
		
	}

  private void generate() throws IOException {
    generatePublicForwardDefs();
//    generatePrivateForwardDefs();
  }    
	
//	private void generatePrivateForwardDefs() throws IOException {
//    CodePrinter pr = pctxt.getPrImplAllH();
//
//	  for (TypeInfo sinfo : arrPrivateTypeInfos) {
//	    TypeInfoCpp cppInfo = new TypeInfoCpp(sinfo, pctxt.apiPack);
//	    pr.println(cppInfo.namespaceBegin);
//	    printForwardTypedefSerInfo(pr, cppInfo);
//	    pr.println(cppInfo.namespaceEnd);
//	  }
//	  
//	}

	private void generatePublicForwardDefs() throws IOException {
	
    CodePrinter pr = pctxt.getPrApiAllH();

	  // Sort namespaces
	  ArrayList<String> namespaceNames = new ArrayList<String>(mapPublicTypeInfos.keySet());
	  Collections.sort(namespaceNames);
	  
    // Loop over namespace names 
	  String prevNs = "";
	  for (String ns : namespaceNames) {
	    
	    // make c++ namespace
	    String cppNs = ns.replaceAll("\\.",  "::");
	    String printNs = cppNs;
	    
      // close namespace blocks until namespace is a sub-namespace of the previous.  
      while (prevNs.length() != 0 && cppNs.indexOf(prevNs) == -1) {
        pr.endBlock();
        pr.print("} // ").println(prevNs);
        int p = prevNs.lastIndexOf("::");
        prevNs = p != -1 ? prevNs.substring(0, p) : "";
      }

      // if next namespace is a sub-namespace of the previous,
      // print only namespace levels relative to it.
	    if (prevNs.length() != 0 && cppNs.indexOf(prevNs) == 0) {
	      printNs = cppNs.substring(prevNs.length());
	    }
	    else {
	      printNs = cppNs;
	    }

	    // print namespace levels
	    pr.println();
	    pr.print("//").line();
	    pr.print("// Forward Definitions for Namespace ").println(cppNs);
      pr.print("//").line();
      pr.println();
	    
	    StringTokenizer stok = new StringTokenizer(printNs, ":");
	    while (stok.hasMoreTokens()) {
	      String tok = stok.nextToken(); 
	      if (tok.length() == 0) continue;
	      pr.print("namespace ").print(tok).println(" {");
	      pr.println();
	      pr.beginBlock();
	    }
	    
      for (TypeInfo tinfo : mapPublicTypeInfos.get(ns)) {
        printForwardTypedef(pr, tinfo);
        pr.println();
      }
	    
      prevNs = cppNs;
	  }
	  
    // close namespace blocks   
    while (prevNs.length() != 0) {
      pr.endBlock();
      pr.print("} // ").println(prevNs);
      int p = prevNs.lastIndexOf("::");
      prevNs = p != -1 ? prevNs.substring(0, p) : "";
    }

	}
	
	private void printForwardTypedef(CodePrinter pr, TypeInfo tinfo) {
    TypeInfoCpp cppInfo = new TypeInfoCpp(tinfo, pctxt.apiPack);
	  if (cppInfo.tinfo.isArrayType() || cppInfo.tinfo.isCollectionType()) {
	    printForwardTypedefCollection(pr, cppInfo);
	  }
	  else {
	    printForwardTypedefSerInfo(pr, cppInfo);
	  }
	}
	
	private void printForwardTypedefSerInfo(CodePrinter pr, TypeInfoCpp cppInfo) {
    String className = cppInfo.getClassName(cppInfo.tinfo.pack);
    String pclassName = cppInfo.getTypeName(cppInfo.tinfo.pack);

    pr.print("// ").println(cppInfo.tinfo.toString());  
    pr.print("class ").print(className).println("; ");
  
    boolean declPtrClass = true;
    if ((cppInfo.tinfo instanceof SerialInfo)) {
      declPtrClass = !((SerialInfo)cppInfo.tinfo).isRequestClass();
    }
    if (declPtrClass) {
      pr.print("typedef byps_ptr< ").print(className).print(" > ").print(pclassName).println("; ");
    }
  }

  private void printForwardTypedefCollection(CodePrinter pr, TypeInfoCpp cppInfo) {
    
    String className = cppInfo.getClassName(null); // == BArray1< PBackupProfile >
    String pclassName = cppInfo.getTypeName(null); // == PArrayBackupProfile 
    
    String arrayName = cppInfo.makeSimpleCollectionClass(); // == BArrayBackupProfile

    pr.print("// ").println(cppInfo.tinfo.toString());  
    pr.print("typedef ").print(className).print(" ").print(arrayName).println(";");
    pr.print("typedef byps_ptr< ").print(arrayName).print(" > ").print(pclassName).println(";");
  }

  
  private static ArrayList<TypeInfo> sortSerials_ArraysAndCollectionsLast(Collection<TypeInfo> arr) {
    ArrayList<TypeInfo> serials = new ArrayList<TypeInfo>();
    ArrayList<TypeInfo> arrays = new ArrayList<TypeInfo>();
    ArrayList<TypeInfo> collections = new ArrayList<TypeInfo>();
    
    for (TypeInfo s : arr) {
      if (s.isArrayType()) arrays.add(s);
      else if (s.isCollectionType()) collections.add(s);
      else serials.add(s);
    }
    
    ArrayList<TypeInfo> all = new ArrayList<TypeInfo>();
    all.addAll(serials);
    all.addAll(arrays);
    all.addAll(collections);
    return all;
  }
  
  private static Map< String, ArrayList<TypeInfo> > splitSerialsIntoNamespaces(PrintContext pctxt, Collection<? extends TypeInfo> arr) {

    // Split classes into map. Package name is used as map key.
    Map< String, ArrayList<TypeInfo> > map = new HashMap< String, ArrayList<TypeInfo> >();
    for (TypeInfo s : arr) {
      
      TypeInfoCpp tinfoCpp = new TypeInfoCpp(s, pctxt.apiPack);
      if (getForwardDeclMode(tinfoCpp) != EForwardMode.PUBLIC) continue;

      String pack = tinfoCpp.getCppPackage();
      
      ArrayList<TypeInfo> nsarr = map.get(pack);
      if (nsarr == null) {
        nsarr = new ArrayList<TypeInfo>();
        map.put(pack, nsarr);
      }
      
      nsarr.add(s);
    }
    
    // Sort classes so that arrays and collections are the last items in the lists.
    Map< String, ArrayList<TypeInfo> > mapArrsLast = new HashMap< String, ArrayList<TypeInfo> >();
    for (String pack : map.keySet()) {
      ArrayList<TypeInfo> nsarr = map.get(pack);
      nsarr = sortSerials_ArraysAndCollectionsLast(nsarr);
      mapArrsLast.put(pack, nsarr);
    }
    
    return mapArrsLast;
  }

//  private static ArrayList<TypeInfo> getSerialsForPrivateForwardDefs(PrintContext pctxt, Collection<? extends TypeInfo> serials) {
//    ArrayList<TypeInfo> arr = new ArrayList<TypeInfo>(serials.size());
//    for (TypeInfo s : serials) {
//      TypeInfoCpp tinfoCpp = new TypeInfoCpp(s, pctxt.apiPack);
//      if (getForwardDeclMode(tinfoCpp) == EForwardMode.PRIVATE) {
//        arr.add(s);
//      }
//    }
//    return arr;
//  }
  
  Map<String, ArrayList<TypeInfo>> mapPublicTypeInfos;
//  ArrayList<TypeInfo> arrPrivateTypeInfos;
	private final PrintContext pctxt;
	
}
