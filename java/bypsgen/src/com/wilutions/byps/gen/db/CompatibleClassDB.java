package com.wilutions.byps.gen.db;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.SerialInfo;


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
			
			ensureCompatibleSerInfos(viols);
			
			ensureCompatibleMethodInfos(viols);
			
			for (CompatibilityViolation viol : viols) {
				log.error(viol.msg);
			}
		}
		
		boolean ret = viols.size() == 0;
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatible", ret);
		return ret;
	}
	
	private void ensureCompatibleSerInfos(CompatibilityViolations viols) throws GeneratorException {
		////log.debug(CompatibleClassDB.class.getName(), "ensureCompatibleSerInfos");
		Collection<SerialInfo> sinfos = classDB.getSerials(); 
		//log.debug("#serials=" + sinfos.size());
		for (SerialInfo sinfo : sinfos) {
			String fullName = sinfo.toString();
			SerialInfo sinfoP = prevClassDB.getSerInfo(fullName);
			//log.debug("sinfo.qname=" + qname + ", sinfoP=" + sinfoP);
			if (sinfoP != null) {
				int n1 = viols.size();
				if (!ensureCompatibleSerInfo(sinfoP, sinfo, viols)) {
					break;
				}
				int n2 = viols.size();
				if (n1 == n2) {
					//log.info(sinfo.qname + " is compatible");
				}
				else {
					//log.info(sinfo.qname + " is incompatible, see errors below");
				}
			}
			else {
				//log.info(sinfo.qname + " is new");
			}
		}
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatibleSerInfos");
	}
	
	private boolean ensureCompatibleSerInfo(SerialInfo sinfoP, SerialInfo sinfo, CompatibilityViolations viols) throws GeneratorException {
		////log.debug(CompatibleClassDB.class.getName(), "ensureCompatibleSerInfo");
		boolean ret = true;
		
		if (!sinfoP.baseFullName.equals(sinfo.baseFullName)) {
			viols.add(sinfoP.qname + ": modified base class, previsious=" + sinfoP.baseFullName + ", current=" + sinfo.baseFullName);
		}

		//log.debug("#members=" + sinfoP.members.size());
		for (int i = 0; i < sinfoP.members.size(); i++) {
			MemberInfo minfoP = sinfoP.members.get(i);
			//log.debug("minfoP.name=" + minfoP.name);
			
			if (i < sinfo.members.size()) {
				MemberInfo minfo = sinfo.members.get(i);
				if (!ensureCompatibleMemberInfo(sinfo.qname, minfoP, minfo, viols)) break;
			}
			else {
				viols.add(sinfoP.qname + ": missing member " + minfoP.name);
				break;
			}
		}
				
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatibleSerInfo", ret);
		return ret;
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
//		else if ((minfoP.access == MemberAccess.PRIVATE) != (minfo.access == MemberAccess.PRIVATE)) {
//			addMessageWrongMemberProps(serialQName, minfoP.name, "private", "non-private", 
//					minfoP.access == MemberAccess.PRIVATE, 
//					minfo.access == MemberAccess.PRIVATE, 
//					viols);
//		}
		else if (!minfoP.type.toString().equals(minfo.type.toString())) {
			addMessageWrongMemberProps(serialQName, minfoP.name, 
					minfoP.type.toString(), 
					minfo.type.toString(), 
					true, false, viols);
		}

		return ret;
	}

	private void ensureCompatibleMethodInfos(CompatibilityViolations viols) throws GeneratorException {
		////log.debug(CompatibleClassDB.class.getName(), "ensureCompatibleMethodInfos");
		Collection<MethodInfo> minfos = classDB.getMethods();
		//log.debug("#methods=" + minfos.size());
		for (MethodInfo minfo : minfos) {
			String qname = minfo.getQName();
			MethodInfo minfoP = prevClassDB.getMethodInfo(qname);
			//log.debug("minfo.qname=" + qname + ", minfoP=" + minfoP);
			if (minfoP != null) {
				int n1 = viols.size();
				if (!ensureCompatibleMethodInfo(minfoP, minfo, viols)) {
					break;
				}
				int n2 = viols.size();
				if (n1 == n2) {
					//log.info(qname + " is compatible");
				}
				else {
					//log.info(qname + " is incompatible, see errors below");
				}
			}
			else {
				//log.info(qname + " is new");
			}
		}
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatibleMethodInfos");
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
		////log.debug(CompatibleClassDB.class.getName(), "ensureCompatibleMethodInfo", minfo);
		boolean ret = true;
		String qname = minfo.getQName();
		
		//log.debug("#params=" + minfoP.requestInfo.members.size());
		
		for (int i = 0; i < Math.max(minfo.requestInfo.members.size(), minfoP.requestInfo.members.size()); i++) {
			if (i >= minfoP.requestInfo.members.size()) {
				MemberInfo pinfo = minfo.requestInfo.members.get(i);
				viols.add(qname + ": disturbing parameter " + pinfo.name);
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
			
			MemberInfo pinfoP = minfoP.requestInfo.members.get(i);
			//log.debug("pinfoP.name=" + pinfoP.name);

		}

		if (!minfoP.resultInfo.toString().equals(minfo.resultInfo.toString())) {
			addMessageWrongMethodParams(qname, "return", "value", 
					minfoP.resultInfo.toString(), 
					minfo.resultInfo.toString(), 
					true, false, viols);
		}
		
		//log.exiting(CompatibleClassDB.class.getName(), "ensureCompatibleMethodInfo", ret);
		return ret;
	}

	private boolean ensureCompatibleParmInfo(String methodQName, MemberInfo pinfoP, MemberInfo pinfo, CompatibilityViolations viols) throws GeneratorException {
		boolean ret = true;
		boolean dummy = false;
		
		if (dummy) {
		}
//		else if (!pinfoP.name.equals(pinfo.name)) {
//			viols.add(methodQName + ": expected parameter " + pinfoP.name + " but found " + pinfo.name);
//			ret = false;
//		}
		else if (!pinfoP.type.toString().equals(pinfo.type.toString())) {
			addMessageWrongMethodParams(methodQName, "parameter", pinfo.name, 
					pinfoP.type.toString(), 
					pinfo.type.toString(), 
					true, false, viols);
		}

		return ret;
	}

	private Log log = LogFactory.getLog(CompatibleClassDB.class.getName());
	private ClassDB prevClassDB;
	private ClassDB classDB;
}
