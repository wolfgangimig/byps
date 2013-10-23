package byps.http;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * WebSocket Servlet 
 *
 */
public class WsServlet extends WebSocketServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7678311509383814277L;

	@Override
	protected StreamInbound createWebSocketInbound(String subProtocol,
			HttpServletRequest request) {
		return null;
	}
}
