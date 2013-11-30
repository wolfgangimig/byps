package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.test.api.refs.Node;
import byps.test.api.remote.BSkeleton_RemoteReferences;

public class MyRemoteReferences extends BSkeleton_RemoteReferences {

	private Node node;

	@Override
	public Node getNode() {
		return node;
	}

	@Override
	public void setNode(Node node) {
		this.node = node;
	}
	
	
}
