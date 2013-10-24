using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
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
		
		public readonly static long serialVersionUID = 363642571L;
		
		public virtual bool Certify(String param) {
			throw new NotImplementedException();
		}
		public virtual async void Certify(String param, BAsyncResult<bool> asyncResult) {
			bool ret = default(bool);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Certify(param);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await CertifyAsync(param);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<bool> CertifyAsync(String param){
			return BTaskConstants<bool>.NotImplemented;
		}
		
		public virtual String Grow() {
			throw new NotImplementedException();
		}
		public virtual async void Grow(BAsyncResult<String> asyncResult) {
			String ret = default(String);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Grow();
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await GrowAsync();
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<String> GrowAsync(){
			return BTaskConstants<String>.NotImplemented;
		}
		
		public virtual String Squeeze() {
			throw new NotImplementedException();
		}
		public virtual async void Squeeze(BAsyncResult<String> asyncResult) {
			String ret = default(String);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Squeeze();
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await SqueezeAsync();
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<String> SqueezeAsync(){
			return BTaskConstants<String>.NotImplemented;
		}
		
		
	}
}
