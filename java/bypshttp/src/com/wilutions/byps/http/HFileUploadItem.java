package com.wilutions.byps.http;


public class HFileUploadItem {
	
	public final String fieldName;
	public final String fileName;
	public final String contentType;
	public final long contentLength;
	public final boolean formField;
	
	/**
	 * Stream ID to be returned.
	 */
	public final String streamId;
	
	public HFileUploadItem(boolean formField, String fieldName, String fileName, String contentType, long contentLength, String streamId) {
		this.formField = formField;
		this.fieldName = fieldName;
		this.fileName = fileName;
		this.contentType = contentType;
		this.contentLength = contentLength;
		this.streamId = streamId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[fieldName=");
		builder.append(fieldName);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", contentType=");
		builder.append(contentType);
		builder.append(", contentLength=");
		builder.append(contentLength);
		builder.append(", formField=");
		builder.append(formField);
		builder.append(", streamId=");
		builder.append(streamId);
		builder.append("]");
		return builder.toString();
	}
	
}
