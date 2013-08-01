package com.wilutions.byps;

import java.io.InputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class BStreamRequest implements Serializable {
	public long streamId;
	public long messageId;
	public InputStream strm;
}
