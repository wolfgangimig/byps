using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteStreams : BStub, RemoteStreams, BSerializable {	
		
		public readonly static long serialVersionUID = 1043578866L;
		
		public BStub_RemoteStreams(BTransport transport)
			: base(transport) {}			
		
		public virtual System.IO.Stream GetImage() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetImage(BAsyncResultHelper.ToDelegate<System.IO.Stream>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetImage(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<System.IO.Stream> GetImageAsync(){
			BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();			
			Task<System.IO.Stream> task = Task<System.IO.Stream>.Factory.FromAsync(transport.BeginSend<System.IO.Stream>, transport.EndSend<System.IO.Stream>, req, null);
			return await task;
		}
		
		public virtual void SetImage(System.IO.Stream istrm) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetImage(istrm, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetImage(System.IO.Stream istrm, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();			
			req.istrmValue = istrm;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetImageAsync(System.IO.Stream istrm){
			BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();			
			req.istrmValue = istrm;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual Dictionary<int,System.IO.Stream> GetImages() {
			BSyncResult<Dictionary<int,System.IO.Stream>> asyncResult = new BSyncResult<Dictionary<int,System.IO.Stream>>();			
			GetImages(BAsyncResultHelper.ToDelegate<Dictionary<int,System.IO.Stream>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetImages(BAsyncResult<Dictionary<int,System.IO.Stream>> asyncResult) {
			BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Dictionary<int,System.IO.Stream>> GetImagesAsync(){
			BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();			
			Task<Dictionary<int,System.IO.Stream>> task = Task<Dictionary<int,System.IO.Stream>>.Factory.FromAsync(transport.BeginSend<Dictionary<int,System.IO.Stream>>, transport.EndSend<Dictionary<int,System.IO.Stream>>, req, null);
			return await task;
		}
		
		public virtual void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetImages(istrms, doNotReadStreamAtKey, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetImages(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();			
			req.istrmsValue = istrms;
			req.doNotReadStreamAtKeyValue = doNotReadStreamAtKey;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetImagesAsync(IDictionary<int,System.IO.Stream> istrms, int doNotReadStreamAtKey){
			BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();			
			req.istrmsValue = istrms;
			req.doNotReadStreamAtKeyValue = doNotReadStreamAtKey;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void ThrowLastException() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			ThrowLastException(BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void ThrowLastException(BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task ThrowLastExceptionAsync(){
			BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();			
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual System.IO.Stream GetTextStream() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetTextStream(BAsyncResultHelper.ToDelegate<System.IO.Stream>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetTextStream(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<System.IO.Stream> GetTextStreamAsync(){
			BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();			
			Task<System.IO.Stream> task = Task<System.IO.Stream>.Factory.FromAsync(transport.BeginSend<System.IO.Stream>, transport.EndSend<System.IO.Stream>, req, null);
			return await task;
		}
		
		public virtual System.IO.Stream GetVideoCheckSupportByteRange() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetVideoCheckSupportByteRange(BAsyncResultHelper.ToDelegate<System.IO.Stream>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetVideoCheckSupportByteRange(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getVideoCheckSupportByteRange req = new BRequest_RemoteStreams_getVideoCheckSupportByteRange();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<System.IO.Stream> GetVideoCheckSupportByteRangeAsync(){
			BRequest_RemoteStreams_getVideoCheckSupportByteRange req = new BRequest_RemoteStreams_getVideoCheckSupportByteRange();			
			Task<System.IO.Stream> task = Task<System.IO.Stream>.Factory.FromAsync(transport.BeginSend<System.IO.Stream>, transport.EndSend<System.IO.Stream>, req, null);
			return await task;
		}
		
		public virtual System.IO.Stream GetStreamDeferedProperies() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetStreamDeferedProperies(BAsyncResultHelper.ToDelegate<System.IO.Stream>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetStreamDeferedProperies(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getStreamDeferedProperies req = new BRequest_RemoteStreams_getStreamDeferedProperies();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<System.IO.Stream> GetStreamDeferedProperiesAsync(){
			BRequest_RemoteStreams_getStreamDeferedProperies req = new BRequest_RemoteStreams_getStreamDeferedProperies();			
			Task<System.IO.Stream> task = Task<System.IO.Stream>.Factory.FromAsync(transport.BeginSend<System.IO.Stream>, transport.EndSend<System.IO.Stream>, req, null);
			return await task;
		}
		
		public virtual void SetStreamDoNotMaterialize(System.IO.Stream stream) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetStreamDoNotMaterialize(stream, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetStreamDoNotMaterialize(System.IO.Stream stream, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteStreams_setStreamDoNotMaterialize req = new BRequest_RemoteStreams_setStreamDoNotMaterialize();			
			req.streamValue = stream;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetStreamDoNotMaterializeAsync(System.IO.Stream stream){
			BRequest_RemoteStreams_setStreamDoNotMaterialize req = new BRequest_RemoteStreams_setStreamDoNotMaterialize();			
			req.streamValue = stream;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual System.IO.Stream GetStreamDoNotClone() {
			BSyncResult<System.IO.Stream> asyncResult = new BSyncResult<System.IO.Stream>();			
			GetStreamDoNotClone(BAsyncResultHelper.ToDelegate<System.IO.Stream>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetStreamDoNotClone(BAsyncResult<System.IO.Stream> asyncResult) {
			BRequest_RemoteStreams_getStreamDoNotClone req = new BRequest_RemoteStreams_getStreamDoNotClone();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<System.IO.Stream> GetStreamDoNotCloneAsync(){
			BRequest_RemoteStreams_getStreamDoNotClone req = new BRequest_RemoteStreams_getStreamDoNotClone();			
			Task<System.IO.Stream> task = Task<System.IO.Stream>.Factory.FromAsync(transport.BeginSend<System.IO.Stream>, transport.EndSend<System.IO.Stream>, req, null);
			return await task;
		}
		
		
	}
}
