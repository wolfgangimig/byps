package byps.gen.api;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ItemInfo {
	
	public final String name;

	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public final List<CommentInfo> comments;
	
	public ItemInfo(String name, List<CommentInfo> comments) {
		this.name = name;
		this.comments = comments;
	}
	
	public ItemInfo() {
		this(null,null);
	}
}
