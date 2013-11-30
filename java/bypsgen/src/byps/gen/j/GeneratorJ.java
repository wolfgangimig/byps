package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.Utils;

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

      GenRemoteClassAsync.generate(pctxt, rinfo, rinfo.getRemoteAsync());

      GenRemoteClassAuth.generate(pctxt, rinfo, rinfo.getRemoteAuth());
      
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
