package com.wilutions.byps.test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wilutions.byps.BRemoteRegistry;
import com.wilutions.byps.http.HFileUploadItem;
import com.wilutions.byps.http.HHttpServlet;
import com.wilutions.byps.http.HSession;
import com.wilutions.byps.http.HTestAdapter;

/**
 * Servlet implementation class BypsServlet
 */
@WebServlet(
asyncSupported=true, // mandatory: must be true
loadOnStartup=1, // optional: load servlet on startup
urlPatterns={"/bypsservlet"}, // mandatory: server URL pattern
initParams={ 
		@WebInitParam(name="testAdapterEnabled", value="true") // !! never true in production environments !!
	} 
)
public class BypsServlet extends HHttpServlet {
	private static final long serialVersionUID = 1L;
    private File tempDir = new File("c:\\temp");

    public BypsServlet() {
		// temp. Verzeichnis für Streams
		if (tempDir == null) {
			String tempDirStr = System.getProperty("java.io.tmpdir");
			if (tempDirStr != null && tempDirStr.length() != 0) {
				tempDir = new File(tempDirStr);
			}
		}   
    }
    
    @Override
    protected HSession createSession(HttpServletRequest request, HttpServletResponse response, HttpSession hsess, BRemoteRegistry stubRegistry) {
    	return new MySession(hsess, tempDir, stubRegistry);
    }
    
    @Override
	protected void makeHtmlUploadResult(HttpSession hsess, HttpServletRequest request, HttpServletResponse response, Collection<HFileUploadItem> items) throws IOException {
    	String uploadHandler = request.getParameter("uploadHandler");
    	if (uploadHandler.equals("htmlform")) {
    		super.makeHtmlUploadResult(hsess, request, response, items);
    	}
    	else if (uploadHandler.equals("blueimp")) {
    		
    		// File upload solution from Sebastian Tschan.
    		// see https://github.com/blueimp/jQuery-File-Upload/wiki/Setup
    		
    		String acceptHeader = request.getHeader("Accept");
    		if (acceptHeader != null && acceptHeader.indexOf("application/json") >= 0) {
        		response.setContentType("application/json");
    		}
    		else {
    			response.setContentType("text/html");
    		}
    		
    		PrintWriter wr = response.getWriter();
    		wr.print("{\"files\":[");
    		boolean first = true;
    		for (HFileUploadItem item : items) {
    			if (first) first = !first; else wr.println(",");
    			wr.print("{");
    			
    			wr.print("\"name\":\"");
    			wr.print(item.fileName);
    			wr.print("\",");
    			
    			wr.print("\"size\":\"");
    			wr.print(item.contentLength);
    			wr.print("\",");
    			
    			wr.print("\"streamId\":\"");
    			wr.print(item.streamId);
    			wr.print("\"");
    			
    			wr.print("}");
    		}
    		wr.print("]}");
        	response.getWriter().close();
    		
    	}
    }

    @Override
    protected long getHtmlUploadMaxSize() {
    	return super.getHtmlUploadMaxSize(); // returns -1L -> no constrain
    }
    
    /**
     * Overrides the testAdapter function in order to modify the application version.
     */
    @Override
    protected void doTestAdapter(HttpServletRequest request,
    		HttpServletResponse response) throws IOException {
    	
		if (!testAdapterEnabled) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		final String testAdapter = request.getParameter(HTestAdapter.KEY_PARAM);
		if (testAdapter == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		if (testAdapter.equals(HTestAdapter.SET_SERVER_APP_VERSION)) {
			String versionStr = request.getParameter(HTestAdapter.VERSION);
			MySession.appVersion = Integer.parseInt(versionStr);
			return;
		}
		
		super.doTestAdapter(request, response);
    }
}
