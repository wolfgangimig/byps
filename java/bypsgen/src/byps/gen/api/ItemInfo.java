package byps.gen.api;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ItemInfo {
	
	public final String name;

	@XmlElementWrapper(name = "comments") 
    @XmlElement(name = "comment") 
	public final Collection<CommentInfo> comments;
	
	public ItemInfo(String name, Collection<CommentInfo> comments) {
		this.name = name;
		this.comments = comments;
	}
	
	public ItemInfo() {
		this(null,null);
	}
	
	public String toString() {
	  return name;
	}
}
