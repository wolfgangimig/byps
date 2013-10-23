package byps;

import byps.BAsyncResult;

/**
 * This class wraps a BMethodResult object into an BAsyncResult.
 * Objects of this class are used in generated stubs.
 *
 * @param <T> The method's result type.
 */
public class BAsyncResultReceiveMethod<T> implements BAsyncResult<BMethodResult<T>> {
	
	private final BAsyncResult<T> innerResult;
	
	/**
	 * Constructor
	 * @param innerResult BAsyncResult object or null, if the caller is not interested in the result.
	 */
	public BAsyncResultReceiveMethod(BAsyncResult<T> innerResult) {
		this.innerResult = innerResult;
	}
	
	@Override
	public void setAsyncResult(BMethodResult<T> methodResult, Throwable e)  {
    if (innerResult != null) {
  		T result = methodResult != null ? methodResult.result : null;
  		innerResult.setAsyncResult(result, e);
    }
	}
	
}
