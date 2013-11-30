package byps.gen.utils;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
	
	
	@Override
	public String format(LogRecord record) {
		StringBuffer buf = new StringBuffer(1000);
		
		buf.append(dateFormat.format(new Date(System.currentTimeMillis())));
		buf.append("\t");
		
		buf.append(record.getLevel());
		buf.append("\t");
		
		buf.append(record.getLoggerName());
		buf.append("\t");
		
		buf.append(super.formatMessage(record));
		buf.append((char)Character.LINE_SEPARATOR);
		
		Throwable t = record.getThrown();
		if (t != null) {
			StringWriter swr = new StringWriter();
			PrintWriter wr = new PrintWriter(swr);
			t.printStackTrace(wr);
			wr.flush();
			buf.append(swr.toString());
		}
		
		return buf.toString();
	}

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
}
