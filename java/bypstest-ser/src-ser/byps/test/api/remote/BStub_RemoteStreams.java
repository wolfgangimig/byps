package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import byps.*;

// checkpoint byps.gen.j.GenRemoteStub:164
public class BStub_RemoteStreams extends BStub implements RemoteStreamsAsync, java.io.Serializable {
	
	// checkpoint byps.gen.j.GenRemoteStub:145
	public final static long serialVersionUID = 1043578866L;
	
	public BStub_RemoteStreams(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.io.InputStream getImage() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<java.io.InputStream> asyncResult = new BSyncResult<java.io.InputStream>();		
		getImage(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getImage(final BAsyncResult<java.io.InputStream> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setImage(java.io.InputStream istrm) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		setImage(istrm, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setImage(java.io.InputStream istrm, final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();		
		req.istrm = istrm;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.util.TreeMap<java.lang.Integer,java.io.InputStream> getImages() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult = new BSyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>>();		
		getImages(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getImages(final BAsyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey) throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		setImages(istrms, doNotReadStreamAtKey, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey, final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();		
		req.istrms = istrms;
		req.doNotReadStreamAtKey = doNotReadStreamAtKey;
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public void throwLastException() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		throwLastException(asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void throwLastException(final BAsyncResult<Object> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();		
		transport.sendMethod(req, asyncResult);
	}
	
	// checkpoint byps.gen.j.PrintContext:359
	public java.io.InputStream getTextStream() throws RemoteException {
		// checkpoint byps.gen.j.GenRemoteStub:46
		final BSyncResult<java.io.InputStream> asyncResult = new BSyncResult<java.io.InputStream>();		
		getTextStream(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint byps.gen.j.PrintContext:403
	public void getTextStream(final BAsyncResult<java.io.InputStream> asyncResult) {
		// checkpoint byps.gen.j.GenRemoteStub:113
		BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();		
		transport.sendMethod(req, asyncResult);
	}
	
	
}
