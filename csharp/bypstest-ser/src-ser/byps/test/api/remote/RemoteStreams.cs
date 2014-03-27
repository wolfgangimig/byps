using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteStreams : BRemote {
	
		System.IO.Stream GetImage();
		void GetImage(BAsyncResult<System.IO.Stream> asyncResult) ;
		Task<System.IO.Stream> GetImageAsync();
		
		void SetImage(System.IO.Stream istrm);
		void SetImage(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) ;
		Task SetImageAsync(System.IO.Stream istrm);
		
		Dictionary<int,System.IO.Stream> GetImages();
		void GetImages(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) ;
		Task<Dictionary<int,System.IO.Stream>> GetImagesAsync();
		
		void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey);
		void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) ;
		Task SetImagesAsync(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey);
		
		void ThrowLastException();
		void ThrowLastException(BAsyncResult<Object> asyncResult) ;
		Task ThrowLastExceptionAsync();
		
		System.IO.Stream GetTextStream();
		void GetTextStream(BAsyncResult<System.IO.Stream> asyncResult) ;
		Task<System.IO.Stream> GetTextStreamAsync();
		
		
	}
}  // end namespace
