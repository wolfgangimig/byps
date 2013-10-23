package byps.gen.api;

import java.io.IOException;

@SuppressWarnings("serial")
public class GeneratorException extends IOException {
	
	public GeneratorException(String msg) {
		super(msg);
	}
	
	public GeneratorException(ErrorInfo errInfo) {
		super(errInfo.toString());
	}
	public GeneratorException(ErrorInfo errInfo, Throwable e) {
		super(errInfo.toString(), e);
	}
	
//	public GeneratorException(String msg, Exception e) {
//		super(msg, e);
//	}
	
}
