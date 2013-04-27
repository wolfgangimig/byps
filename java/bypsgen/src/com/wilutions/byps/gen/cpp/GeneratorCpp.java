package com.wilutions.byps.gen.cpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.Generator;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.ClassDB;

public class GeneratorCpp implements Generator {
	
	public GeneratorCpp() {
	}
	
	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		
		pctxt = new PrintContext(classDB, props);
		printSerials(classDB.getSerials());
		printRemotes(classDB.getRemotes());
		GenRegistry.generate(pctxt, classDB.getSerials(), BBinaryModel.MEDIUM);
		GenClient.generate(pctxt, classDB.getApiDescriptor());
		GenServer.generate(pctxt, classDB.getApiDescriptor());
		pctxt.close();
	}
	
	private void printRemotes(Collection<RemoteInfo> remotes) throws IOException {
		for (RemoteInfo rinfo : remotes) {
			GenApiClassFwd.generate(pctxt, rinfo);
		}
		
		for (RemoteInfo rinfo : remotes) {
			GenRemoteClass.generate(pctxt, rinfo);
			GenRemoteSkeleton.generate(pctxt, rinfo);
			GenRemoteStub.generate(pctxt, rinfo);
		}
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
		if (sinfo.isInline) {
			for (int i = 0; i < arr.size(); i++) {
				SerialInfo sinfo2 = arr.get(i);
				if (!sinfo2.isInline || isUsedBy_SerialInfo(sinfo, sinfo2)) {
					return i;
				}
			}
		}
		return arr.size();
	}
	
	protected void printSerials(Collection<SerialInfo> serials) throws IOException {
		
		// Klassen so sortieren, dass die Inline-Klassen zuerst kommen.
		// Dabei muss eine Inline-Klasse, die in einer anderen verwendet wird,
		// vor der anderen einsortiert werden.
		ArrayList<SerialInfo> arr = new ArrayList<SerialInfo>(serials.size());
		for (SerialInfo sinfo : serials) {
			int idx = findInsertPosForSerialInfo(sinfo, arr);
			arr.add(idx, sinfo);
		}
		
		for (SerialInfo sinfo : arr) {
			GenApiClassFwd.generate(pctxt, sinfo);
		}
		
		for (SerialInfo sinfo : arr) {
			GenApiClass.generate(pctxt, sinfo);
		}
	}
	
	private PrintContext pctxt;
}
