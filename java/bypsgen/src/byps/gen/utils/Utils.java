package byps.gen.utils;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import byps.BBinaryModel;
import byps.gen.api.MemberInfo;
import byps.gen.api.SerialInfo;

public class Utils {
  
  private final static Set<String> DO_NOT_PURGE_FILES_WITH_EXTS = new HashSet<String>(Arrays.asList(new String[] {".gitignore"}));
	
	public static int getDimCount(String dims) {
		int dimCount = 0;
		if (dims != null) {
			for (int i = 0; i < dims.length(); i++) {
				if (dims.charAt(i) == '[') dimCount++;
			}
		}
		return dimCount;
	}
	
	public static String getPackageAsSubdir(String pack) {
		return pack.replace(".", File.separator);
	}
	
	public static int computeStructSize(BBinaryModel bmodel, SerialInfo sinfo) {
		int size = 0;
		
		if (sinfo.isCollectionType()) {
		}
		else if (sinfo.isArrayType()) {
		}
		else {
			if (sinfo.baseInfo != null) {
				size = computeStructSize(bmodel, sinfo.baseInfo);
			}
			else {
				size = 8;
			}
			
			List<MemberInfo> members = sinfo.members;
			if (members != null) {
				for (MemberInfo minfo : members) {
					int memberSize = minfo.type.getMemberSize(bmodel);
					int pad = getPaddingForAlignedPosition(bmodel, size, memberSize);
					size += pad + memberSize;
				}
			}
			size += getPaddingForAlignedPosition(bmodel, size, 8);
		}
		
		return size;
	}
	
	public static int getPaddingForAlignedPosition(BBinaryModel bmodel, int pos, int align) {
		align = Math.min(bmodel.packing, align);
		int pad = 0;
		if (align > 1) {
			int d = pos & (align-1); 
			if (d != 0) {
				pad = align - d;
			}
		}
		return pad;
	}

	public static String firstCharToUpper(String s) {
		if (s != null && s.length() != 0) {
			s = s.substring(0,1).toUpperCase() + s.substring(1);
		}
		return s;
	}
	
	public static String firstCharToLower(String s) {
		if (s != null && s.length() != 0) {
			s = s.substring(0,1).toLowerCase() + s.substring(1);
		}
		return s;
	}
	
	public static void purgeDirs(File[] dirs, String[] exts) throws IOException {
		for (File dir : dirs) {
			purgeDirContents(dir, exts);
		}
	}

	public static void purgeDir(File dir, String[] exts) throws IOException {
    purgeDirContents(dir, exts);
    Files.delete(dir.toPath());
  }

  public static void purgeDirContents(File dir, String[] exts) throws IOException {
		if (dir == null || !dir.exists()) return;

		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				purgeDir(f, exts);
			}
			else {
			  
        String fext = "";
        int p = f.getName().lastIndexOf('.');
        if (p >= 0) fext = f.getName().substring(p).toLowerCase();
        
        if (!DO_NOT_PURGE_FILES_WITH_EXTS.contains(fext)) {
			  
  				if (exts != null) {
  
  				  boolean found = false;
            for (String ext : exts) {
              found = fext.endsWith(ext.toLowerCase());
              if (found) break;
            }
  	        
    				if (!found) {
    					// We do not delete other files than the generated.
    					// The generator must not delete arbitrary directories, 
    					// if there is just a mistake in the configuration.
    					throw new IOException("The generator deletes only files named with extensions \"" + Arrays.toString(exts) + "\". It does not delete the file=" + f + ". Delete this file manually.");
    				}
  				}
  				
  				Files.delete(f.toPath());
        }
			}
		}
	}

	
//	public static int getNbOfPointerMembers(SerialInfo sinfo) {
//		int ret = 0;
//		while (sinfo != null) {
//			for (MemberInfo minfo : sinfo.members) {
//				if (BRegistry.isPointerTypeId(minfo.type.typeId)) {
//					ret++;
//				}
//			}
//			sinfo = sinfo.baseInfo;
//		}
//		return ret;
//	}

}
