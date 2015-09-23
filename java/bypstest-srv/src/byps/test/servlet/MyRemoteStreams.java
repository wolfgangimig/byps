package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.RemoteException;
import byps.test.api.remote.BSkeleton_RemoteStreams;

public class MyRemoteStreams extends BSkeleton_RemoteStreams {
	
	private Log log = LogFactory.getLog(MyRemoteStreams.class);
	private volatile BContentStream imageStream;
	private volatile Map<Integer, ByteBuffer> mapStreamBytes;
	private volatile BException lastException;
	
	void done() {
		closeImageStream();
	}

	protected void closeImageStream() {
		if (imageStream != null) {
			try {
				imageStream.close();
			} catch (IOException e) {
			}
			imageStream = null;
		}
	}
	
	@Override
	public void setImage(InputStream istrm) throws RemoteException {
		if (log.isDebugEnabled()) log.debug("setImage(" + istrm);
		closeImageStream();
		if (istrm != null) {
			try {
				// Clone the stream to be able to store it in a member variable
		    if (log.isDebugEnabled()) log.debug("materialize stream ...");
				imageStream = BContentStream.materialize(istrm);
        if (log.isDebugEnabled()) log.debug("materialize stream OK");
	     } catch (BException e) {
	        log.error("Exception=", e);
	        throw e;
	    }
			catch (Throwable e) {
        log.error("Exception=", e);
        throw new BException(BExceptionC.IOERROR, "", e);
      }
		}
		if (log.isDebugEnabled()) log.debug(")setImage");
	}
	
	@Override
	public InputStream getImage() throws RemoteException {
		if (log.isDebugEnabled()) log.debug("getImage()=" + imageStream);
		try {
      BContentStream ret = imageStream.cloneStream();
      return ret;
    } catch (IOException e) {
      throw new RemoteException("Failed to clone stream.", e);
    }
	}

	@Override
	public TreeMap<Integer, InputStream> getImages() throws RemoteException	 {
		if (log.isDebugEnabled()) log.debug("getImages(");
		Map<Integer, ByteBuffer> mapStreamBytes = this.mapStreamBytes;
		if (mapStreamBytes == null) return null;
		TreeMap<Integer, InputStream> map = new TreeMap<Integer, InputStream>();
		for (Integer k : mapStreamBytes.keySet()) {
			ByteBuffer buf = mapStreamBytes.get(k);
			InputStream istrm = new ByteArrayInputStream(buf.array(), buf.position(), buf.remaining());
			map.put(k, istrm);
		}
		if (log.isDebugEnabled()) log.debug(")getImages=" + map);
		return map;
	}

	@Override
	public void setImages(Map<Integer, InputStream> istrms, int doNotReadStreamAtKey) throws RemoteException {
		if (log.isDebugEnabled()) log.debug("setImages(");
		lastException = null;
		mapStreamBytes = new HashMap<Integer, ByteBuffer>(istrms.size());
		for (Integer k : istrms.keySet()) {
			
			// see TestRemoteStreams.testRemoteStreamsCloseStreamAfterSend
			if (k == doNotReadStreamAtKey) {
				if (log.isDebugEnabled()) log.debug("skip stream at key=" + k);
				continue;
			}
			
			InputStream istrm = istrms.get(k);
			if (log.isDebugEnabled()) log.debug("read stream[" + k + "]=" + istrm);
			try {
				ByteBuffer buf = BWire.bufferFromStream(istrm);
				if (log.isDebugEnabled()) log.debug("read buf=" + buf);
				mapStreamBytes.put(k, buf);
			} catch (BException e) {
				if (log.isDebugEnabled()) log.debug("received exception=" + e);
				lastException = e;
				throw e;
			} catch (Throwable e) { // If the underlying message is canceled an this istrm is closed, a NPE can occur deep inside CoyoteInputStream.
				if (log.isDebugEnabled()) log.debug("received exception=" + e);
				lastException = new BException(BExceptionC.IOERROR, "", e);
				throw lastException;
			}
		}
		if (log.isDebugEnabled()) log.debug(")setImages");
	}

	@Override
	public void throwLastException() throws RemoteException {
		if (lastException != null) throw lastException;
	}
	
	@Override
	public InputStream getTextStream() throws RemoteException {
		final String text = "text-stream euro=€";
		return new BContentStreamWrapper() {
			@Override
			protected InputStream openStream() throws IOException {
				return new ByteArrayInputStream(text.getBytes("UTF-8"));
			}
			@Override
			public String getContentType() {
				return "text/plain; charset=utf-8";
			}
			@Override 
			public String getContentDisposition() {
			  return "attachment; filename=\"text*stream €\"";
			}
		};
		
	}
	
	
	/**
	 * Define stream class that has invalid properties unless it is opened. 
	 *
	 */
	private static class StreamWithDeferedProperties extends BContentStream {
	  
	  private volatile boolean isOpen = false;
	  private int rc = 5;

    @Override
    public int read() throws IOException {
      return rc < 0 ? -1 : (--rc);
    }
    
    @Override
    public void ensureProperties() {
      isOpen = true;
    }

    @Override
    public String getContentType() {
      return isOpen ? "application/mycontentype" : null;
    }

    @Override
    public long getContentLength() {
      return isOpen ? 5 : -1;
    }

    @Override
    public int getAttachmentCode() {
      return isOpen ? ATTACHMENT : 0;
    }

    @Override
    public String getFileName() {
      return isOpen ? "myfilename" : null;
    }
    
	}
	
	@Override
	public InputStream getStreamDeferedProperies() throws RemoteException {
	  return new StreamWithDeferedProperties();
	}
	
	@Override
	public void setStreamDoNotMaterialize(InputStream stream) throws RemoteException {
	  closeImageStream();
	  imageStream = (BContentStream)stream;
	}
	
	@Override
	public InputStream getStreamDoNotClone() throws RemoteException {
	  return imageStream;
	}
	
	@Override
	public InputStream getVideoCheckSupportByteRange() throws RemoteException {
	  BContentStream stream = null;
    try {
      stream = new BContentStreamWrapper(new java.io.File("d:/temp/bypssrv-data/video.mp4"));
    }
    catch (FileNotFoundException e) {
      throw new BException(BExceptionC.INTERNAL, e.toString());
    }
	  return stream;
	}
}
