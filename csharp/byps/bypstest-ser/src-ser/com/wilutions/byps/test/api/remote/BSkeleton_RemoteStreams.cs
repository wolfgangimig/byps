using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteStreams.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteStreams : BSkeleton, RemoteStreams {	
		
		public readonly static long serialVersionUID = 2028487863L;
		
		public virtual System.IO.Stream GetImage() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetImage(BAsyncResult<System.IO.Stream> asyncResult) {
			try {
				System.IO.Stream ret = GetImage();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetImage(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public System.IO.Stream EndGetImage(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetImage(System.IO.Stream istrm) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetImage(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) {
			try {
				SetImage(istrm);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetImage(System.IO.Stream istrm, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetImage(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual Dictionary<int,System.IO.Stream> GetImages() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetImages(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) {
			try {
				Dictionary<int,System.IO.Stream> ret = GetImages();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetImages(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Dictionary<int,System.IO.Stream> EndGetImages(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) {
			try {
				SetImages(istrms, doNotReadStreamAtKey);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetImages(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void ThrowLastException() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_ThrowLastException(BAsyncResult<Object> asyncResult) {
			try {
				ThrowLastException();
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginThrowLastException(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndThrowLastException(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual System.IO.Stream GetTextStream() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetTextStream(BAsyncResult<System.IO.Stream> asyncResult) {
			try {
				System.IO.Stream ret = GetTextStream();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetTextStream(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public System.IO.Stream EndGetTextStream(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
