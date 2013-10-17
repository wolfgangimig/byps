using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteStreams : BStub, RemoteStreams, BSerializable {	
		
		public readonly static long serialVersionUID = 2028487863L;
		
		public BStub_RemoteStreams(BTransport transport)
			: base(transport) {}			
		
		public System.IO.Stream GetImage() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetImageAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetImageAsync(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();			
			BAsyncResultReceiveMethod<System.IO.Stream> outerResult = new BAsyncResultReceiveMethod<System.IO.Stream>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetImage(AsyncCallback callback, object state){
			BAsyncProgModel<System.IO.Stream> _byps_ret = new BAsyncProgModel<System.IO.Stream>(callback, state);
			GetImageAsync(_byps_ret);
			return _byps_ret;
		}
		public System.IO.Stream EndGetImage(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<System.IO.Stream>)asyncResult).Result;
		}
		public async Task<System.IO.Stream> GetImageTask() {
			return await Task<System.IO.Stream>.Factory.FromAsync(BeginGetImage, EndGetImage, null);
		}
		
		public void SetImage(System.IO.Stream istrm) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetImageAsync(istrm, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetImageAsync(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();			
			req._istrm = istrm;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetImage(System.IO.Stream istrm, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetImageAsync(istrm, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetImage(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetImageTask(System.IO.Stream istrm) {
			await Task.Factory.FromAsync(BeginSetImage, EndSetImage, istrm, null);
		}
		
		public Dictionary<int,System.IO.Stream> GetImages() {
			BSyncResult<Dictionary<int,System.IO.Stream>> asyncResult = new BSyncResult<Dictionary<int,System.IO.Stream>>();			
			GetImagesAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetImagesAsync(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) {
			BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();			
			BAsyncResultReceiveMethod<Dictionary<int,System.IO.Stream>> outerResult = new BAsyncResultReceiveMethod<Dictionary<int,System.IO.Stream>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetImages(AsyncCallback callback, object state){
			BAsyncProgModel<Dictionary<int,System.IO.Stream>> _byps_ret = new BAsyncProgModel<Dictionary<int,System.IO.Stream>>(callback, state);
			GetImagesAsync(_byps_ret);
			return _byps_ret;
		}
		public Dictionary<int,System.IO.Stream> EndGetImages(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Dictionary<int,System.IO.Stream>>)asyncResult).Result;
		}
		public async Task<Dictionary<int,System.IO.Stream>> GetImagesTask() {
			return await Task<Dictionary<int,System.IO.Stream>>.Factory.FromAsync(BeginGetImages, EndGetImages, null);
		}
		
		public void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetImagesAsync(istrms, doNotReadStreamAtKey, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetImagesAsync(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();			
			req._istrms = istrms;
			req._doNotReadStreamAtKey = doNotReadStreamAtKey;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetImagesAsync(istrms, doNotReadStreamAtKey, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetImages(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetImagesTask(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey) {
			await Task.Factory.FromAsync(BeginSetImages, EndSetImages, istrms, doNotReadStreamAtKey, null);
		}
		
		public void ThrowLastException() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			ThrowLastExceptionAsync(asyncResult);
			asyncResult.GetResult();			
		}
		public void ThrowLastExceptionAsync(BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginThrowLastException(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			ThrowLastExceptionAsync(_byps_ret);
			return _byps_ret;
		}
		public Object EndThrowLastException(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task ThrowLastExceptionTask() {
			await Task.Factory.FromAsync(BeginThrowLastException, EndThrowLastException, null);
		}
		
		public System.IO.Stream GetTextStream() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetTextStreamAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetTextStreamAsync(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();			
			BAsyncResultReceiveMethod<System.IO.Stream> outerResult = new BAsyncResultReceiveMethod<System.IO.Stream>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetTextStream(AsyncCallback callback, object state){
			BAsyncProgModel<System.IO.Stream> _byps_ret = new BAsyncProgModel<System.IO.Stream>(callback, state);
			GetTextStreamAsync(_byps_ret);
			return _byps_ret;
		}
		public System.IO.Stream EndGetTextStream(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<System.IO.Stream>)asyncResult).Result;
		}
		public async Task<System.IO.Stream> GetTextStreamTask() {
			return await Task<System.IO.Stream>.Factory.FromAsync(BeginGetTextStream, EndGetTextStream, null);
		}
		
		
	}
}
