package byps.test.api.strm;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Stream1 implements Serializable {

	public InputStream is1;
	
	private String contentType;

	private InputStream[] arrStream;
	
	private List<InputStream> listStream;
	
	public Map<Integer, InputStream> mapStream;
	
	private static final long serialVersionUID = 6436953915683226753L;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream[] getArrStream() {
		return arrStream;
	}

	public void setArrStream(InputStream[] arrStream) {
		this.arrStream = arrStream;
	}

	public List<InputStream> getListStream() {
		return listStream;
	}

	public void setListStream(List<InputStream> listStream) {
		this.listStream = listStream;
	}
	
	
	

}
