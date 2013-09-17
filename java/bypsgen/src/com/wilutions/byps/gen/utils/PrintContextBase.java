package com.wilutions.byps.gen.utils;

import java.io.IOException;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.ParamInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.BRegistryForClassDB;
import com.wilutions.byps.gen.db.ClassDB;

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
			s = "com.wilutions.byps";
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
				pr.print(indent).print("/* padding */ + "+pad);
				pr.println();
			}
			pr.print(indent).print("/* pos=" + size).print(": ").print(minfo.name).print(" */ + "+memberSize);
			pr.println();
			size += memberSize;
		}
		
		// structure size must be a multiple of its alignment
		{
			int pad = Utils.getPaddingForAlignedPosition(bmodel, size, 8);
			size += pad;
			pr.print(indent).print("/* padding up to multiple of alignment */ + "+pad + ";");
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
		StringBuilder sbuf= new StringBuilder();
		//if (Character.isLetterOrDigit(c)) sbuf.append(c);
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
			String s = Integer.toHexString((int)c);
			for (int i = s.length(); i < 4; i++) sbuf.append("0");
			sbuf.append(s);
		}
		return sbuf.toString();
	}	
	
	public boolean isSessionParam(RemoteInfo rinfo, MemberInfo pinfo ) {
    return (rinfo != null && rinfo.authParamClassName != null && pinfo.type.qname.equals(rinfo.authParamClassName));
	}
	
  public RemoteInfo getRemoteBaseForStub(RemoteInfo rinfo) throws GeneratorException {
    RemoteInfo baseRemote = rinfo.getRemoteAuth();
    if (baseRemote == null) baseRemote = rinfo;
    return baseRemote;
  }

  public RemoteInfo getRemoteBaseForSkeleton(RemoteInfo rinfo) throws GeneratorException {
    RemoteInfo baseRemote = rinfo.getRemoteNoAuth();
    return baseRemote;
  }

	
	protected String apiName;
	public final String apiPack;
	public final BBinaryModel bmodel = BBinaryModel.MEDIUM;
	public final ClassDB classDB;
	protected final BRegistryForClassDB registry;
	protected final BApiDescriptor apiDesc;
	public final GeneratorProperties props;
}
