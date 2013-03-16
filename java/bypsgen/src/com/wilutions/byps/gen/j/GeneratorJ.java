package com.wilutions.byps.gen.j;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.Generator;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.db.ClassDB;
import com.wilutions.byps.gen.utils.Utils;

public class GeneratorJ implements Generator {
	
	Log log = LogFactory.getLog(GeneratorJ.class);

	public GeneratorJ() {
	}

	@Override
	public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
		log.debug("build(");

		pctxt = new PrintContext(classDB, props);
		
		purgeOutputDirs();

		GenApiDescriptor.generate(pctxt, classDB.getApiDescriptor());

		GenClient.generate(pctxt, classDB.getApiDescriptor());
		GenServer.generate(pctxt, classDB.getApiDescriptor());

		GenRegistry.generate(pctxt, classDB.getSerials(), BBinaryModel.MEDIUM);
		GenRegistry.generate(pctxt, classDB.getSerials(), BBinaryModel.JSON);
		
		buildSerials(classDB);
		
		buildRemotes(classDB);
		
		log.debug(")build");
	}
	
	private void buildSerials(ClassDB classDB) throws IOException {
		Collection<SerialInfo> serials = classDB.getSerials();
		for (SerialInfo serInfo : serials) {
			GenApiClass.generate(pctxt, serInfo);
			GenSerClass.generate(pctxt, serInfo, BBinaryModel.MEDIUM);
			GenSerClass.generate(pctxt, serInfo, BBinaryModel.JSON);
		}
	}

	private void buildRemotes(ClassDB classDB) throws IOException {
		Collection<RemoteInfo> remotes = classDB.getRemotes();
		for (RemoteInfo rinfo : remotes) {
			GenRemoteClass.generate(pctxt, rinfo);
			GenRemoteClassAsync.generate(pctxt, rinfo);
			GenRemoteStub.generate(pctxt, rinfo);
			GenRemoteSkeleton.generate(pctxt, rinfo);
		}		
	}
	
	private void purgeOutputDirs() throws IOException {
		Utils.purgeDirs(new File[] {
				pctxt.dirSer, pctxt.dirSerBin, pctxt.dirSerJson, pctxt.dirApi	
			},
			new String[] {".java", ".MF"}
		);
	}
	
	private PrintContext pctxt;
}
