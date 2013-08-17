using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteStreams : BRemote
	{
		System.IO.Stream GetImage();
		void async_GetImage(BAsyncResult<System.IO.Stream> asyncResult) ;
		IAsyncResult BeginGetImage(AsyncCallback callback, object state);
		System.IO.Stream EndGetImage(IAsyncResult asyncResult);
		
		void SetImage(System.IO.Stream istrm);
		void async_SetImage(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetImage(System.IO.Stream istrm, AsyncCallback callback, object state);
		Object EndSetImage(IAsyncResult asyncResult);
		
		Dictionary<int,System.IO.Stream> GetImages();
		void async_GetImages(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) ;
		IAsyncResult BeginGetImages(AsyncCallback callback, object state);
		Dictionary<int,System.IO.Stream> EndGetImages(IAsyncResult asyncResult);
		
		void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey);
		void async_SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, AsyncCallback callback, object state);
		Object EndSetImages(IAsyncResult asyncResult);
		
		void ThrowLastException();
		void async_ThrowLastException(BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginThrowLastException(AsyncCallback callback, object state);
		Object EndThrowLastException(IAsyncResult asyncResult);
		
		System.IO.Stream GetTextStream();
		void async_GetTextStream(BAsyncResult<System.IO.Stream> asyncResult) ;
		IAsyncResult BeginGetTextStream(AsyncCallback callback, object state);
		System.IO.Stream EndGetTextStream(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
