package com.wilutions.byps;

import java.io.InputStream;


public class BStreamRequest implements BSerializable {
	public long streamId;
	public long messageId;
	public InputStream strm;
}
