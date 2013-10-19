using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface BioLemonService.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_BioLemonService : BSkeleton, BioLemonService {	
		
		public readonly static long serialVersionUID = 1992245333L;
		
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
		
		public virtual String Pick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree) {
			throw new NotImplementedException();
		}
		public virtual async void Pick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) {
			String ret = default(String);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Pick(sess, fromTree);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await PickAsync(sess, fromTree);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<String> PickAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree){
			return BTaskConstants<String>.NotImplemented;
		}
		
		public virtual int UseParing() {
			throw new NotImplementedException();
		}
		public virtual async void UseParing(BAsyncResult<int> asyncResult) {
			int ret = default(int);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = UseParing();
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await UseParingAsync();
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<int> UseParingAsync(){
			return BTaskConstants<int>.NotImplemented;
		}
		
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
