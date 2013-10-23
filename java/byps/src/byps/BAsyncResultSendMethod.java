package byps;

import byps.BAsyncResult;

/**
 * This class connects a BMethodResult to a BAsyncResult.
 * Objects of this class are used in the generated BRequest classes.
 *
 * @param <T> The method's result type.
 */
public class BAsyncResultSendMethod<T> implements BAsyncResult<T> {

	private BAsyncResult<Object> innerResult;
	BMethodResult<T> methodResult;

	public BAsyncResultSendMethod(BAsyncResult<Object> innerResult, BMethodResult<T> methodResult) {
		this.innerResult = innerResult;
		this.methodResult = methodResult;
	}

	@Override
	public void setAsyncResult(T obj, Throwable e) {
		methodResult.result = obj;
		innerResult.setAsyncResult(methodResult, e);
	}

}
