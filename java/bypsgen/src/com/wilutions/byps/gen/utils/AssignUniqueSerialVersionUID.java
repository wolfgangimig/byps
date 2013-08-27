package com.wilutions.byps.gen.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AssignUniqueSerialVersionUID {
	
	private final Log log = LogFactory.getLog(AssignUniqueSerialVersionUID.class);
	private final Random rand;
	private final String[] dirs;
	private final boolean inclSubDirs;
	private final static byte[] BOM_UTF8 = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
	private final static String indent = "  ";
//	private final static byte[] BOM_UTF16_LE = new byte[] { (byte)0xFF, (byte)0xFE };
//	private final static byte[] BOM_UTF16_BE = new byte[] { (byte)0xFE, (byte)0xFF };

	public AssignUniqueSerialVersionUID(String[] dirs, boolean inclSubDirs) {
		this.rand = new Random();
		this.dirs = dirs;
		this.inclSubDirs = inclSubDirs;
	}
	
	private boolean isBOM(byte[] expected, byte[] read) {
		if (expected.length > read.length) return false;
		for (int i = 0; i < expected.length; i++) {
			if (expected[i] != read[i]) return false;
		}
		return true;
	}
	
	public void processFiles() throws IOException {
		for (String dir : dirs) {
			internalProcessFiles(new File(dir), inclSubDirs);
		}
	}
	
	private void internalProcessFiles(File dir, boolean inclSubDirs) throws IOException {
		log.info("process files in dir=" + dir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if (inclSubDirs) {
					internalProcessFiles(file, inclSubDirs);
				}
			}
			else {
				processFile(file);
			}
		}
	}
	
	private void processFile(File file) throws IOException {
	
		if (!file.getName().endsWith(".java")) return; 
		if (file.getName().equals("BApi.java")) return;
		if (file.length() < 4) return;
		
		log.info("process file=" + file);
		
		String charsetName = null;
		ArrayList<String> lines = new ArrayList<String>();
		boolean writeFile = true;
		BufferedInputStream is = null;
		LineNumberReader rd = null;
		
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			
			byte[] bom = new byte[4];
			is.mark(4);
			is.read(bom); 
			is.reset();
		
			if (isBOM(BOM_UTF8, bom)) charsetName = "UTF-8";
			Reader rdtmp = charsetName != null ? new InputStreamReader(is, charsetName) : new InputStreamReader(is); 
			rd = new LineNumberReader(rdtmp);

			boolean isSerialVersionUIDDefined = false; 
			
			String line = null;
			while ((line = rd.readLine()) != null) {
				int p = line.indexOf("serialVersionUID");
				if (p >= 0) {
					
					isSerialVersionUIDDefined = true;

					boolean isValidSerialVersionUID = false;
					
					{
						String value = line.substring(p + 16);
						p = 0; 
						while (p < value.length()) {
							char ch = value.charAt(p);
							if (value.charAt(p) == '-') break;
							if (Character.isLetterOrDigit(ch)) break; 
							p++;
						}
						value = value.substring(p);
						p = 0;
						
						while (p < value.length() && 
								(Character.isDigit(value.charAt(p)) || value.charAt(p) == '-') ) p++; 
						value = value.substring(0, p);
						
						try {
							long uid = Long.parseLong(value);
							isValidSerialVersionUID = uid > 1;
						}
						catch (NumberFormatException e) {
							log.debug(e);
						}
					}
					
					if (isValidSerialVersionUID) {
						writeFile = false;
						break;
					}
					else {
						StringBuilder sbuf = makeSerialVersionUID();
						lines.add(sbuf.toString());
						
						writeFile = true;
					}
				}
				else {
					lines.add(line);
				}
			}
			
			if (!isSerialVersionUIDDefined) {
				int insertAt = -1;
				for (int i = 0; i < lines.size() && insertAt == -1; i++) {
					line = lines.get(i).trim();
					if (line.startsWith("class ") || 
						line.startsWith("public class ") ||
						line.startsWith("protected class ")) {

						while (i < lines.size()) {
							if (line.indexOf("{") >= 0) {
								insertAt = i+1;
								break;
							}
							i++;
						}
					}
					else if (line.startsWith("interface") ||
							line.startsWith("public interface ") ||
							line.startsWith("protected interface ")) {

						// Do not assign serialVersoinUID to interfaces
						writeFile = false;
						break;
					}
				}
				
				if (insertAt > 0) {
					StringBuilder sbuf = makeSerialVersionUID();
					lines.add(insertAt, sbuf.toString());
					writeFile = true;
				}
			}
			
		}
		finally {
			if (rd != null) {
				try { rd.close(); } catch (IOException e) {}
			}
			else if (is != null) {
				try { is.close(); } catch (IOException e) {}
			}
		}
		
		if (writeFile) {
			PrintWriter pr = null;
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				OutputStreamWriter wr = charsetName != null ? new OutputStreamWriter(fos, charsetName) : new OutputStreamWriter(fos);
				pr = new PrintWriter(wr);
				for (int i = 0; i < lines.size(); i++) {
					pr.println(lines.get(i));
				}
			}
			finally {
				if (pr != null) {
					pr.close(); 
				}
				else if (fos != null) {
					try { fos.close(); } catch (IOException e) {}
				}
			}
		}
	}

	private StringBuilder makeSerialVersionUID() {
		int uid = rand.nextInt();
		if (uid < 0) uid = -uid;

		StringBuilder sbuf = new StringBuilder();
		sbuf.append(indent).append("private final static long serialVersionUID = ");
		sbuf.append(uid).append("L;");
		return sbuf;
	}
	
}
