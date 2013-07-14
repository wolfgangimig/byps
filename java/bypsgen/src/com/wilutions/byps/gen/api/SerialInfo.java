package com.wilutions.byps.gen.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SerialInfo extends TypeInfo implements Comparable<SerialInfo> {
	
	public SerialInfo(String name, List<CommentInfo> comments, String qname, String baseFullName, 
			String dims, List<TypeInfo> typeArgs, List<MemberInfo> members,
			boolean isEnum, boolean isFinal, boolean isInline) {
		super(name, qname, 
				dims != null ? dims : "", 
				typeArgs != null ? typeArgs : new ArrayList<TypeInfo>(0),
				isEnum, isFinal, isInline
		);

		if (comments == null) comments = new ArrayList<CommentInfo>(0);
		if (members == null) members = new ArrayList<MemberInfo>(0);
		if (baseFullName == null) baseFullName = "";
		
		this.baseFullName = baseFullName;
		this.members = members;
		this.comments = comments;
		
	}
	
	public SerialInfo() throws GeneratorException {
		this(null, null, null, "", null, null, null, false, false, false);
	}

	public List<MemberInfo> members;
	
	public final List<CommentInfo> comments;
	
	public final String baseFullName;
	
	public SerialInfo baseInfo;
	
	public MethodInfo methodInfo;
	
	@Override
	public int compareTo(SerialInfo o) {
		long diff = this.typeId - o.typeId;
		if (diff < 0) return -1;
		if (diff > 0) return 1;
		return 0;
	}
	
	public List<MemberInfo> getTypeMembers() {
		ArrayList<MemberInfo> arr = new ArrayList<MemberInfo>();
		if (members.size() == 0) return arr;
		for (int i = 0; i < members.size(); i++) {
			MemberInfo minfo = members.get(i);
			if (!minfo.type.isPointerType()) {
				arr.add(minfo);
			}
		}
		Collections.sort(arr);
		return arr;
	}
	
	public List<MemberInfo> getPointerMembers() {
		ArrayList<MemberInfo> arr = new ArrayList<MemberInfo>();
		if (members.size() == 0) return arr;
		for (int i = 0; i < members.size(); i++) {
			MemberInfo minfo = members.get(i);
			if (minfo.type.isPointerType()) {
				arr.add(minfo);
			}
		}
		Collections.sort(arr);
		return arr;
	}

	public boolean isResultClass() {
		return name.startsWith(MethodInfo.METHOD_RESULT_NAME_PREFIX);
	}

	public boolean isRequestClass() {
		return name.startsWith(MethodInfo.METHOD_REQUEST_NAME_PREFIX);
	}

	public boolean isStubType() {
		return name.startsWith(RemoteInfo.STUB_NAME_PREFIX);
	}

	public boolean hasTransientMember() {
		boolean hasTransientMembers = false;
		for (MemberInfo minfo : members) {
			if (minfo.isTransient) {
				hasTransientMembers = true;
				break;
			}
		}
		return hasTransientMembers;
	}
	
	public MemberInfo findMember(String memberName, String typeQName) {
		MemberInfo ret = null;
		for (MemberInfo m : members) {
			if (typeQName != null) {
				if (m.name.startsWith(memberName)) {
					ret = m;
					break;
				}
				if (memberName.endsWith("s") && 
					m.name.startsWith(memberName.substring(0, memberName.length()-2))) // mbNotes -> mbNoteMembers
				{
					ret = m;
					break;
				}
			}
			else {
				if (m.name.equals(memberName)) {
					ret = m;
					break;
				}
			}
		}
		if (ret == null && baseInfo != null) {
			ret = baseInfo.findMember(memberName, typeQName);
		}
		return ret;
	}
}
