package byps.gen.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class SplitFileOutputStream extends OutputStream {
	
	public SplitFileOutputStream(File dir, String fileNameFormat, int maxFileSize) throws IOException {
		this.dir = dir;
		this.maxFileSize = maxFileSize;
		this.fileNameFormat = fileNameFormat;
		ensureOpen();
	}
	
	@Override
	public void write(int b) throws IOException {
		ensureOpen();
		bos.write(b);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		ensureOpen();
		bos.write(b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		ensureOpen();
		bos.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		internalFlushIfFull();
	}
	
	@Override
	public void close() throws IOException {
		internalFlush();
	}
	
	private void internalFlushIfFull() throws IOException {
		if (bos != null) {
			int bos_size = bos.size();
			if (bos_size >= maxFileSize) {
				internalFlush();
			}
		}
	}
	
	private void internalFlush() throws IOException {

		String fname = String.format(fileNameFormat, ++fileCount);
		File splitFile = new File(dir, fname);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(splitFile);
			bos.writeTo(fos);
		}
		finally {
			if (fos != null) fos.close();
		}
		bos = null;
		
		onClosedSplitFile(splitFile);
	}
	
	private void ensureOpen() throws IOException {
		if (bos != null) return;
		bos = new ByteArrayOutputStream();
		onOpenedSplitFile();
	}
	
	public abstract void onOpenedSplitFile() throws IOException ;
	public abstract void onClosedSplitFile(File closedFile);
		
	private File dir;
	private int maxFileSize;
	private String fileNameFormat;
	private ByteArrayOutputStream bos;
	private int fileCount;
}
