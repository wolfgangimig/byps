package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.InputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class BStreamRequest implements Serializable {
	public long streamId;
	public long messageId;
	public InputStream strm;
}
