using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteStreams : BStub, RemoteStreams, BSerializable {	
		
		public readonly static long serialVersionUID = 2028487863L;
		
		public BStub_RemoteStreams(BTransport transport)
			: base(transport) {}			
		
		public System.IO.Stream GetImage() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			async_GetImage(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetImage(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();			
			BAsyncResultReceiveMethod<System.IO.Stream> outerResult = new BAsyncResultReceiveMethod<System.IO.Stream>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetImage(AsyncCallback callback, object state){
			BAsyncProgModel<System.IO.Stream> _byps_ret = new BAsyncProgModel<System.IO.Stream>(callback, state);
			async_GetImage(_byps_ret);
			return _byps_ret;
		}
		public 		System.IO.Stream EndGetImage(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<System.IO.Stream>)asyncResult).Result;
		}
		
		public void SetImage(System.IO.Stream istrm) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetImage(istrm, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetImage(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();			
			req._istrm = istrm;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetImage(System.IO.Stream istrm, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetImage(istrm, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetImage(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public Dictionary<int,System.IO.Stream> GetImages() {
			BSyncResult<Dictionary<int,System.IO.Stream>> asyncResult = new BSyncResult<Dictionary<int,System.IO.Stream>>();			
			async_GetImages(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetImages(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) {
			BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();			
			BAsyncResultReceiveMethod<Dictionary<int,System.IO.Stream>> outerResult = new BAsyncResultReceiveMethod<Dictionary<int,System.IO.Stream>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetImages(AsyncCallback callback, object state){
			BAsyncProgModel<Dictionary<int,System.IO.Stream>> _byps_ret = new BAsyncProgModel<Dictionary<int,System.IO.Stream>>(callback, state);
			async_GetImages(_byps_ret);
			return _byps_ret;
		}
		public 		Dictionary<int,System.IO.Stream> EndGetImages(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Dictionary<int,System.IO.Stream>>)asyncResult).Result;
		}
		
		public void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetImages(istrms, doNotReadStreamAtKey, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();			
			req._istrms = istrms;
			req._doNotReadStreamAtKey = doNotReadStreamAtKey;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetImages(istrms, doNotReadStreamAtKey, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetImages(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void ThrowLastException() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_ThrowLastException(asyncResult);
			asyncResult.GetResult();			
		}
		public void async_ThrowLastException(BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginThrowLastException(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_ThrowLastException(_byps_ret);
			return _byps_ret;
		}
		public 		Object EndThrowLastException(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public System.IO.Stream GetTextStream() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			async_GetTextStream(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetTextStream(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();			
			BAsyncResultReceiveMethod<System.IO.Stream> outerResult = new BAsyncResultReceiveMethod<System.IO.Stream>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetTextStream(AsyncCallback callback, object state){
			BAsyncProgModel<System.IO.Stream> _byps_ret = new BAsyncProgModel<System.IO.Stream>(callback, state);
			async_GetTextStream(_byps_ret);
			return _byps_ret;
		}
		public 		System.IO.Stream EndGetTextStream(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<System.IO.Stream>)asyncResult).Result;
		}
		
		
	}
}
