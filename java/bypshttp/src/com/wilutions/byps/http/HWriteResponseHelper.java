package com.wilutions.byps.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBuffer;
import com.wilutions.byps.BException;
import com.wilutions.byps.BMessageHeader;

public class HWriteResponseHelper {
	
	private final Log log = LogFactory.getLog(HWriteResponseHelper.class);
	
	public HWriteResponseHelper() {
	}
	
	public void writeResponse(ByteBuffer obuf, Throwable e, HttpServletResponse resp, boolean isAsync) throws IOException {
		if (log.isDebugEnabled()) log.debug("writeResponse(" + obuf + ", exception=" + e + ", resp=" + resp);
		
		if (resp == null) {
			if (log.isDebugEnabled()) log.debug(")writeResponse timeout");
			return; // timeout
		}
		if (e != null) {
			int status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			if (e instanceof BException) {
				BException bex = (BException)e;
				if (bex.code == BException.CANCELED) {
					status = HttpServletResponse.SC_NOT_ACCEPTABLE;
				}
			}
			
			log.warn("send status=" + status, e);
			resp.setStatus(status);
			
			PrintWriter wr = resp.getWriter();
			String errmsg = e.toString(); //(e instanceof BException) ? ((BException)e).msg : e.toString();
			wr.print(errmsg);
			wr.close();
		}
		else {
			if (log.isDebugEnabled()) log.debug("copy to servlet output");
			boolean isJson = BMessageHeader.detectProtocol(obuf) == BMessageHeader.MAGIC_JSON;
			resp.setContentType(isJson ? "application/json" : "application/byps");
			resp.setContentLength(obuf.remaining());
			OutputStream os = resp.getOutputStream();
			
			if (log.isDebugEnabled()) {
				log.debug("buffer: \r\n" + BBuffer.toDetailString(obuf));
			}
			
			if (isAsync) {
				
				// Tomcat does not throw an IOException in asynchronous requests, if the client
				// has closed the socket. Somewhere on stackoverflow.com I found a hack 
				// to workaround this bug. The workaround splits the message into two
				// parts and calls flush() after each part. The second flush throws the 
				// expected exception. But the author of this workaround mentioned, that
				// it does not work in all cases - and I confirm to him.
				// http://stackoverflow.com/questions/7124508/how-to-properly-detect-a-client-disconnect-in-servlet-spec-3
				int pos = obuf.position(), len = obuf.remaining() / 2;
				os.write(obuf.array(), pos, len);
				os.flush();
				os.write(obuf.array(), pos + len, obuf.remaining() - len);
				os.flush();
			}
			else {
				os.write(obuf.array(), obuf.position(), obuf.remaining());
			}
			
			os.close();
		}
		if (log.isDebugEnabled()) log.debug(")writeResponse");
	}
	

}
