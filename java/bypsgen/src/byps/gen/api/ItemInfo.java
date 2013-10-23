package byps.gen.api;

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
