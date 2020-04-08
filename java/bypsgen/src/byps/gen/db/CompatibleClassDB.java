package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BVersioning;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberAccess;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;


public class CompatibleClassDB {
	
	public CompatibleClassDB(ClassDB prevClassDB, ClassDB classDB) {
		super();
		this.prevClassDB = prevClassDB;
		this.classDB = classDB;
	}
	
	public boolean ensureCompatible() throws GeneratorException {
		////log.debug(CompatibleClassDB.class.getName(), "ensureCompatible");
		CompatibilityViolations viols = new CompatibilityViolations();
		
		if (prevClassDB != null) {
		  
		  if (prevClassDB.getApiDescriptor().version > classDB.getApiDescriptor().version) {
		    String sverP = BVersioning.longToString(prevClassDB.getApiDescriptor().version);
		    String sver = BVersioning.longToString(classDB.getApiDescriptor().version);
		    viols.add("BApi.VERSION=" + sver + " must be greater or equal to previsious version=" + sverP);
		  }
			
			ensureCompatibleSerInfos(viols);
			
      ensureCompatibleRemoteInfos(viols);
      
			for (CompatibilityViolation viol : viols) {
				log.error(viol.msg);
				System.out.println(viol.msg);
			}
		}
		
		boolean ret = viols.size() == 0;
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatible", ret);
		return ret;
	}
	
	private void ensureCompatibleRemoteInfos(CompatibilityViolations viols) throws GeneratorException {
    Collection<RemoteInfo> rinfos = classDB.getRemotes(); 
    
    for (RemoteInfo rinfo : rinfos) {
      String fullName = rinfo.toString();
      RemoteInfo rinfoP = prevClassDB.getRemoteInfo(fullName);

      if (rinfoP != null) {
        ensureCompatibleRemoteInfo(rinfoP, rinfo, viols);
      }
      else {
        checkSinceOfNewMember(rinfo.qname, rinfo.name, rinfo.since, viols);
      }
    }
  }

  private void ensureCompatibleRemoteInfo(RemoteInfo rinfoP, RemoteInfo rinfo, CompatibilityViolations viols) throws GeneratorException {
    
    for (MethodInfo minfoP : rinfoP.methods) {
      
      MethodInfo minfo = null;
      for (MethodInfo m : rinfo.methods) {
        if (minfoP.name.equals(m.name)) {
          minfo = m;
          break;
        }
      }
      
      if (minfo != null) {
        if (!ensureCompatibleMethodInfo(minfoP, minfo, viols)) {
          break;
        }
      }
      else {
        viols.add("Missing method " + minfoP);
        break;
      }
    }

    for (MethodInfo minfo : rinfo.methods) {
      
      MethodInfo minfoP = null;
      for (MethodInfo m : rinfoP.methods) {
        if (minfo.name.equals(m.name)) {
          minfoP = m;
          break;
        }
      }
      
      if (minfoP == null) {
        checkSinceOfNewMember(rinfo.qname, minfo.name, minfo.since, viols);
      }
    
    }
  }

  private void ensureCompatibleSerInfos(CompatibilityViolations viols) throws GeneratorException {
		
	  Collection<SerialInfo> sinfos = classDB.getSerials(); 

		for (SerialInfo sinfo : sinfos) {

		  // Result and request classes need not to be checked,
		  // since the method definitions are checked.
		  if (sinfo.isResultClass()) continue;
		  if (sinfo.isRequestClass()) continue;
		  if (sinfo.isStubType()) continue;
		  
		  // Collection classes or arrays need not to be checked,
		  // because they do not change.
		  if (sinfo.isCollectionType()) continue;
		  if (sinfo.isArrayType()) continue;
		  
			String fullName = sinfo.toString();
			SerialInfo sinfoP = prevClassDB.getSerInfo(fullName);
			
			if (sinfoP != null) {
				ensureCompatibleSerInfo(sinfoP, sinfo, viols);
			}
			else {
        checkSinceOfNewMember(sinfo.qname, sinfo.name, sinfo.since, viols);
			}
		}
		
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatibleSerInfos");
	}
	
  /**
   * Check whether the given SerialInfo objects are compatible.
   * @param sinfoP SerialInfo object from previous API version.
   * @param sinfo SerialInfo object from current API version
   * @param viols List of violations.
   * @return true, if the objects are compatible
   * @throws GeneratorException
   */
	private boolean ensureCompatibleSerInfo(SerialInfo sinfoP, SerialInfo sinfo, CompatibilityViolations viols) throws GeneratorException {
		boolean ret = true;
		
    if (sinfoP.isEnum != sinfo.isEnum){
      viols.add(sinfoP.qname + ": class cannot be converted to enum and vice versa.");
    }
		
		// typeId changed?
		if (sinfoP.typeId != sinfo.typeId){
      viols.add(sinfoP.qname + ": modified serialVersionUID ( & 0xFFFFFFFF), previsious=" + sinfoP.typeId + ", current=" + sinfo.typeId);
		}
		
		// Base class changed?
		if (!sinfoP.baseFullName.equals(sinfo.baseFullName)) {
			viols.add(sinfoP.qname + ": modified base class, previsious=" + sinfoP.baseFullName + ", current=" + sinfo.baseFullName);
		}
		
		if (sinfoP.isEnum) {
		  
	    // The old members must be at the same position
		  // BYPS-13: Only enum constants are taken into account. Other members are ignored, since they are not serialized.
		  
		  List<MemberInfo> enumConstantsP = sinfoP.members.stream().filter(m -> m.isFinal && m.isStatic).collect(Collectors.toList());  
		  List<MemberInfo> enumConstants = sinfo.members.stream().filter(m -> m.isFinal && m.isStatic).collect(Collectors.toList());  
	    for (int i = 0; i < enumConstantsP.size(); i++) {
	      
	      MemberInfo minfoP = enumConstantsP.get(i);
	      MemberInfo minfo = i < enumConstants.size() ? enumConstants.get(i) : null;
	      
	      if (minfo == null) {
	        viols.add(sinfoP.qname + ": missing member " + minfoP.name);
	      }
	      else if (!minfoP.name.equals(minfo.name)) {
	        viols.add(sinfoP.qname + ": missing member " + minfoP.name + " at position " + (i+1) + " (ordinal value=" + i + ").");
	      }
  	      
	    }
		}
		else {
  		// The old members must still be defined in the new class
  		for (int i = 0; i < sinfoP.members.size(); i++) {
  			MemberInfo minfoP = sinfoP.members.get(i);
  			
  			// Find member in new class
  			MemberInfo minfo = null;
  			for (MemberInfo m : sinfo.members) {
  			  if (m.name.equals(minfoP.name)) {
  			    minfo = m; 
  			    break;
  			  }
  			}
  
  			if (minfo != null) {
  			  // Compare type, transient state etc.
  				ensureCompatibleMemberInfo(sinfo.qname, minfoP, minfo, viols);
  			}
  			else {
  				viols.add(sinfoP.qname + ": missing member " + minfoP.name);
  			}
  		}
		}
		
		// The new members must have a since tag  
    for (int i = 0; i < sinfo.members.size(); i++) {
      MemberInfo minfo = sinfo.members.get(i);
      
      // Find member in new class
      MemberInfo minfoP = null;
      for (MemberInfo m : sinfoP.members) {
        if (m.name.equals(minfo.name)) {
          minfoP = m; 
          break;
        }
      }

      if (minfoP == null) {
        checkSinceOfNewMember(sinfo.qname, minfo.name, minfo.since, viols);
      }
    }
				
		return ret;
	}
	
	private void checkSinceOfNewMember(String qname, String memberName, long since, CompatibilityViolations viols) {
    long verP = prevClassDB.getApiDescriptor().version;
    long ver = classDB.getApiDescriptor().version;
    
    if (verP == ver) {
      viols.add(qname + ": member " + memberName + " added but API version not incremented.");
    }
    else if (since == 0) {
      viols.add(qname + ": missing @since tag for " + memberName + ". Value " + BVersioning.longToString(ver) + " is expected.");
    }
    else if (since <= verP) {
      viols.add(qname + ": @since tag for " + memberName + ", value=" + BVersioning.longToString(since) + ", must be newer version than previsous API version=" + BVersioning.longToString(verP));
    }
    else if (since > ver) {
      viols.add(qname + ": @since tag for " + memberName + ", value=" + BVersioning.longToString(since) + ", must be less or equal to current API version=" + BVersioning.longToString(ver));
    }
	}
	
	private void addMessageWrongMemberProps(String serialQName, String memberName, String propStr, String npropStr, boolean expected, boolean found, CompatibilityViolations viols) {
		StringBuilder msg = new StringBuilder();
		msg.append(serialQName).append(": wrong ").append(memberName)
		   .append(" - found: ")
		   .append((found) ? propStr : npropStr)
		   .append(" - expected: ")
		   .append((expected) ? propStr : npropStr);
		String s = msg.toString();
		viols.add(s);
	}
	
	private boolean ensureCompatibleMemberInfo(String serialQName, MemberInfo minfoP, MemberInfo minfo, CompatibilityViolations viols) throws GeneratorException {
		boolean ret = true;

		if (!minfoP.name.equals(minfo.name)) {
			viols.add(serialQName + ": expected member " + minfoP.name + " but found " + minfo.name);
			ret = false;
		}
    else if (minfoP.isTransient != minfo.isTransient) {
      addMessageWrongMemberProps(serialQName, minfoP.name, "transient", "non-transient", minfoP.isTransient, minfo.isTransient, viols);
    }
    else if (minfoP.isStatic != minfo.isStatic) {
      addMessageWrongMemberProps(serialQName, minfoP.name, "static", "non-static", minfoP.isStatic, minfo.isStatic, viols);
    }
    else if (minfoP.isFinal != minfo.isFinal) {
      addMessageWrongMemberProps(serialQName, minfoP.name, "final", "non-final", minfoP.isFinal, minfo.isFinal, viols);
    }
		else if ((minfoP.access == MemberAccess.PUBLIC) != (minfo.access == MemberAccess.PUBLIC)) {
			addMessageWrongMemberProps(serialQName, minfoP.name, "public", "non-public", 
					minfoP.access == MemberAccess.PUBLIC, 
					minfo.access == MemberAccess.PUBLIC, 
					viols);
		}
		else if (!minfoP.type.toString().equals(minfo.type.toString())) {
			addMessageWrongMemberProps(serialQName, minfoP.name, 
					minfoP.type.toString(), 
					minfo.type.toString(), 
					true, false, viols);
		}

		return ret;
	}

	private void addMessageWrongMethodParams(String methodQName, String paramKind, String paramName, String propStr, String npropStr, boolean expected, boolean found, CompatibilityViolations viols) {
		StringBuilder msg = new StringBuilder();
		msg.append(methodQName).append(": wrong ").append(paramKind).append(" ").append(paramName)
		   .append(" - found: ")
		   .append((found) ? propStr : npropStr)
		   .append(" - expected: ")
		   .append((expected) ? propStr : npropStr);
		String s = msg.toString();
		viols.add(s);
	}
	
	private boolean ensureCompatibleMethodInfo(MethodInfo minfoP, MethodInfo minfo, CompatibilityViolations viols) throws GeneratorException {
		boolean ret = true;
		String qname = minfo.getQName();
		
		for (int i = 0; i < Math.max(minfo.requestInfo.members.size(), minfoP.requestInfo.members.size()); i++) {
			if (i >= minfoP.requestInfo.members.size()) {
				MemberInfo pinfo = minfo.requestInfo.members.get(i);
				viols.add(qname + ": obsolete parameter " + pinfo.name);
				break;
			}
			else if (i >= minfo.requestInfo.members.size()) {
				MemberInfo pinfoP = minfoP.requestInfo.members.get(i);
				viols.add(qname + ": missing parameter " + pinfoP.name);
				break;
			}
			else {
				MemberInfo pinfoP = minfoP.requestInfo.members.get(i);
				MemberInfo pinfo = minfo.requestInfo.members.get(i);
				if (!ensureCompatibleParmInfo(qname, pinfoP, pinfo, viols)) break;
			}
			
		}
		
		if (!minfoP.resultInfo.toString().equals(minfo.resultInfo.toString())) {
			addMessageWrongMethodParams(qname, "return", "value", 
					minfoP.resultInfo.toString(), 
					minfo.resultInfo.toString(), 
					true, false, viols);
		}
		
    MemberInfo returnInfoP = minfoP.resultInfo.members.get(0);
    MemberInfo returnInfo = minfo.resultInfo.members.get(0);
    
    if (!returnInfoP.toString().equals(returnInfo.toString())) {
      addMessageWrongMethodParams(qname, "return", "value", 
          returnInfoP.toString(), 
          returnInfo.toString(), 
          true, false, viols);
    }

		return ret;
	}

	private boolean ensureCompatibleParmInfo(String methodQName, MemberInfo pinfoP, MemberInfo pinfo, CompatibilityViolations viols) throws GeneratorException {
		boolean ret = true;
		
		if (!pinfoP.type.toString().equals(pinfo.type.toString())) {
			addMessageWrongMethodParams(methodQName, "parameter", pinfo.name, 
					pinfoP.type.toString(), 
					pinfo.type.toString(), 
					true, false, viols);
		}

		return ret;
	}

	private Logger log = LoggerFactory.getLogger(CompatibleClassDB.class.getName());
	private ClassDB prevClassDB;
	private ClassDB classDB;
}
