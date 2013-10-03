using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface BioFruitService.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_BioFruitService : BSkeleton, BioFruitService {	
		
		public readonly static long serialVersionUID = 1881829396L;
		
		public virtual String Grow() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GrowAsync(BAsyncResult<String> asyncResult) {
			try {
				String ret = Grow();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult("", e);
			}
		}
		public IAsyncResult BeginGrow(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public String EndGrow(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual bool Certify(String param) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void CertifyAsync(String param, BAsyncResult<bool> asyncResult) {
			try {
				bool ret = Certify(param);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(false, e);
			}
		}
		public IAsyncResult BeginCertify(String param, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public bool EndCertify(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual String Squeeze() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SqueezeAsync(BAsyncResult<String> asyncResult) {
			try {
				String ret = Squeeze();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult("", e);
			}
		}
		public IAsyncResult BeginSqueeze(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public String EndSqueeze(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
