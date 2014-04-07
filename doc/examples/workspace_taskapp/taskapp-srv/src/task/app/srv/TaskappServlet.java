package task.app.srv;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import byps.BApiDescriptor;
import byps.BServerRegistry;
import byps.http.HConfig;
import byps.http.HConfigImpl;
import byps.http.HHttpServlet;
import byps.http.HSession;

/**
 * Servlet implementation class TaskappServlet
 */
@WebServlet(

		// mandatory: must be true
		asyncSupported = true,

		// mandatory: server URL patterns
		urlPatterns = { "/testapp", "/testapptauth/auth" }
)
public class TaskappServlet extends HHttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final HConfigImpl config = new HConfigImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskappServlet() {
        super();
    }

	@Override
	protected HSession createSession(HttpServletRequest request,
			HttpServletResponse response, HttpSession hsess,
			BServerRegistry serverRegistry) {
	    String remoteUser = request.getRemoteUser();
	    return new TaskappSession(hsess, remoteUser, null, serverRegistry);
	}

	@Override
	protected BApiDescriptor getApiDescriptor() {
		return TaskappSession.apiDesc;
	}

	@Override
	protected HConfig getConfig() {
		return config;
	}


    
    
}

