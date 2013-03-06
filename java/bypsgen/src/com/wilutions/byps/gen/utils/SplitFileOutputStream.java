package com.wilutions.byps.gen.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;

public abstract class SplitFileOutputStream extends OutputStream {
	
	public SplitFileOutputStream(File dir, String fileNameFormat, int maxFileSize) throws IOException {
		this.dir = dir;
		this.maxFileSize = maxFileSize;
		this.fileNameFormat = fileNameFormat;
		this.bos = new ByteArrayOutputStream();
		onOpenedSplitFile();
	}
	
	@Override
	public void write(int b) throws IOException {
		bos.write(b);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		bos.write(b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		bos.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		if (bos.size() >= maxFileSize) {
			internalFlush();
		}
	}
	
	@Override
	public void close() throws IOException {
		internalFlush();
	}
	
	private void internalFlush() throws IOException {

		String fname = MessageFormat.format(fileNameFormat, ++fileCount);
		File splitFile = new File(dir, fname);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(splitFile);
			bos.writeTo(fos);
		}
		finally {
			if (fos != null) fos.close();
		}
		bos.reset();
		
		onClosedSplitFile(splitFile);
	}
	
	public abstract void onOpenedSplitFile() throws IOException ;
	public abstract void onClosedSplitFile(File closedFile);
		
	private File dir;
	private int maxFileSize;
	private String fileNameFormat;
	private ByteArrayOutputStream bos;
	private int fileCount;
}
