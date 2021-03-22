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
		
		/// <summary>
		/// Return a large video stream to be able to test that byte ranges are correctly handled.
		/// </summary>
		/// <remarks>
		/// This functionality is currently only tested in the JSON API by TestVideoCheckSupportByteRange.html.
		/// </remarks>
		System.IO.Stream GetVideoCheckSupportByteRange();
		void GetVideoCheckSupportByteRange(BAsyncResult<System.IO.Stream> asyncResult) ;
		/// <summary>
		/// Return a large video stream to be able to test that byte ranges are correctly handled.
		/// </summary>
		/// <remarks>
		/// This functionality is currently only tested in the JSON API by TestVideoCheckSupportByteRange.html.
		/// </remarks>
		Task<System.IO.Stream> GetVideoCheckSupportByteRangeAsync();
		
		/// <summary>
		/// Return stream without properties.
		/// </summary>
		/// <remarks>
		/// The properties must be made explicitly available on the client-side by calling
		/// BContentStream.ensureProperties()
		/// </remarks>
		System.IO.Stream GetStreamDeferedProperies();
		void GetStreamDeferedProperies(BAsyncResult<System.IO.Stream> asyncResult) ;
		/// <summary>
		/// Return stream without properties.
		/// </summary>
		/// <remarks>
		/// The properties must be made explicitly available on the client-side by calling
		/// BContentStream.ensureProperties()
		/// </remarks>
		Task<System.IO.Stream> GetStreamDeferedProperiesAsync();
		
		/// <summary>
		/// Stores a stream reference but does not create an internal copy (does not materialize)
		/// </summary>
		void SetStreamDoNotMaterialize(System.IO.Stream stream);
		void SetStreamDoNotMaterialize(System.IO.Stream stream, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Stores a stream reference but does not create an internal copy (does not materialize)
		/// </summary>
		Task SetStreamDoNotMaterializeAsync(System.IO.Stream stream);
		
		/// <summary>
		/// Return stream, do not call BContentStream.cloneStream().
		/// </summary>
		System.IO.Stream GetStreamDoNotClone();
		void GetStreamDoNotClone(BAsyncResult<System.IO.Stream> asyncResult) ;
		/// <summary>
		/// Return stream, do not call BContentStream.cloneStream().
		/// </summary>
		Task<System.IO.Stream> GetStreamDoNotCloneAsync();
		
		/// <summary>
		/// Store a stream reference shared by several clients.
		/// </summary>
		/// <remarks>
		/// BYPS-48
		/// </remarks>
		void PutSharedStream(long id, System.IO.Stream stream);
		void PutSharedStream(long id, System.IO.Stream stream, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Store a stream reference shared by several clients.
		/// </summary>
		/// <remarks>
		/// BYPS-48
		/// </remarks>
		Task PutSharedStreamAsync(long id, System.IO.Stream stream);
		
		/// <summary>
		/// Get a shared stream previously sent by {@link #putSharedStream(long, InputStream)}.
		/// </summary>
		/// <remarks>
		/// BYPS-48
		/// </remarks>
		System.IO.Stream GetSharedStream(long id);
		void GetSharedStream(long id, BAsyncResult<System.IO.Stream> asyncResult) ;
		/// <summary>
		/// Get a shared stream previously sent by {@link #putSharedStream(long, InputStream)}.
		/// </summary>
		/// <remarks>
		/// BYPS-48
		/// </remarks>
		Task<System.IO.Stream> GetSharedStreamAsync(long id);
		
		
	}
}  // end namespace
