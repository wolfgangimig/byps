package byps.gen.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;

@XmlRootElement( namespace = "http://byps.wilutions.com/" ) 
@XmlAccessorType( XmlAccessType.FIELD )
public class XmlClassDB {
	
	private XmlApiDescriptor apiDesc;

	@XmlElementWrapper(name = "serials") 
    @XmlElement(name = "serial") 
	private ArrayList<XmlSerialInfo> serials;
	
	@XmlElementWrapper(name = "remotes") 
    @XmlElement(name = "remote") 
	private ArrayList<XmlRemoteInfo> remotes;
	
	public static void write(File file, ClassDB classDB) throws GeneratorException {
		FileOutputStream fos = null;
		XmlClassDB x = fromValue(classDB);
		try {
			fos = new FileOutputStream(file);

			JAXBContext context = JAXBContext.newInstance( XmlClassDB.class ); 
			Marshaller m = context.createMarshaller(); 
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.marshal( x, fos );
		}
		catch (Exception e) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "Cannot write class definitions into file=" + file;
			throw new GeneratorException(errInfo, e);
		}
		finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public static ClassDB read(File file, boolean openExisting) throws GeneratorException {
		ClassDB obj = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			JAXBContext context = JAXBContext.newInstance( XmlClassDB.class ); 
			Unmarshaller um = context.createUnmarshaller(); 
			XmlClassDB x = (XmlClassDB) um.unmarshal(fis); 
			
			obj = x.toValue();
		}
		catch (FileNotFoundException e) {
			if (openExisting) {
				ErrorInfo errInfo = new ErrorInfo();
				errInfo.msg = "Cannot read class definitions from file=" + file;
				throw new GeneratorException(errInfo, e);
			}
		}
		catch (Exception e) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "Cannot read class definitions from file=" + file;
			throw new GeneratorException(errInfo, e);
		}
		finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
		return obj;
	}
	
	private static XmlClassDB fromValue(ClassDB classDB) {
		XmlClassDB x = new XmlClassDB();
		
		x.apiDesc = XmlApiDescriptor.fromValue(classDB.getApiDescriptor());
		
		Collection<SerialInfo> serials = classDB.getSerials();
		x.serials = new ArrayList<XmlSerialInfo>(serials.size());
		for (SerialInfo s : serials) {
			if (s.isStubType()) continue;
			if (s.isBuiltInType()) continue;
			XmlSerialInfo xs = XmlSerialInfo.fromValue(classDB, s);
			x.serials.add(xs);
		}

		Collection<RemoteInfo> remotes = classDB.getRemotes();
		x.remotes = new ArrayList<XmlRemoteInfo>(remotes.size());
		for (RemoteInfo r : remotes) {
			XmlRemoteInfo xs = XmlRemoteInfo.fromValue(classDB, r);
			x.remotes.add(xs);
		}
		
		return x;
	}
	
	private ClassDB toValue() throws GeneratorException {
		ClassDB v = new ClassDB(null);
		
		v.setApiDescriptor(this.apiDesc.toValue());
		
		for (XmlSerialInfo x : serials) {
			x.toValue(this, v);
		}
		
		for (XmlRemoteInfo x : remotes) {
			x.toValue(this, v);
		}
		
		for (XmlInfo x : infosToUpdateAfterRead) {
			x.updateAfterRead(v);
		}

		return v;
	}

	void pushUpdate(XmlInfo x) {
		infosToUpdateAfterRead.add(x);		
	}
	
	@XmlTransient
	private ArrayList<XmlInfo> infosToUpdateAfterRead = new ArrayList<XmlInfo>();
	
}
