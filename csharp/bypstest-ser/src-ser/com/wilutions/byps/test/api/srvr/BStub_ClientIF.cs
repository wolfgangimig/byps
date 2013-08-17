using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BStub_ClientIF : BStub, ClientIF, BSerializable {	
		
		public readonly static long serialVersionUID = 1784257353L;
		
		public BStub_ClientIF(BTransport transport)
			: base(transport) {}			
		
		public int IncrementInt(int a) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_IncrementInt(a, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_IncrementInt(int a, BAsyncResult<int> asyncResult) {
			BRequest_ClientIF_incrementInt req = new BRequest_ClientIF_incrementInt();			
			req._a = a;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginIncrementInt(int a, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_IncrementInt(a, _byps_ret);
			return _byps_ret;
		}
		public 		int EndIncrementInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		public IList<System.IO.Stream> GetStreams(int ctrl) {
			BSyncResult<IList<System.IO.Stream>> asyncResult = new BSyncResult<IList<System.IO.Stream>>();			
			async_GetStreams(ctrl, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			BRequest_ClientIF_getStreams req = new BRequest_ClientIF_getStreams();			
			req._ctrl = ctrl;
			BAsyncResultReceiveMethod<IList<System.IO.Stream>> outerResult = new BAsyncResultReceiveMethod<IList<System.IO.Stream>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetStreams(int ctrl, AsyncCallback callback, object state){
			BAsyncProgModel<IList<System.IO.Stream>> _byps_ret = new BAsyncProgModel<IList<System.IO.Stream>>(callback, state);
			async_GetStreams(ctrl, _byps_ret);
			return _byps_ret;
		}
		public 		IList<System.IO.Stream> EndGetStreams(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<System.IO.Stream>>)asyncResult).Result;
		}
		
		public void PutStreams(IList<System.IO.Stream> strm, int ctrl) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_PutStreams(strm, ctrl, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) {
			BRequest_ClientIF_putStreams req = new BRequest_ClientIF_putStreams();			
			req._strm = strm;
			req._ctrl = ctrl;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPutStreams(IList<System.IO.Stream> strm, int ctrl, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_PutStreams(strm, ctrl, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndPutStreams(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ChatStructure SendChat(ChatStructure cs) {
			BSyncResult<ChatStructure> asyncResult = new BSyncResult<ChatStructure>();			
			async_SendChat(cs, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) {
			BRequest_ClientIF_sendChat req = new BRequest_ClientIF_sendChat();			
			req._cs = cs;
			BAsyncResultReceiveMethod<ChatStructure> outerResult = new BAsyncResultReceiveMethod<ChatStructure>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendChat(ChatStructure cs, AsyncCallback callback, object state){
			BAsyncProgModel<ChatStructure> _byps_ret = new BAsyncProgModel<ChatStructure>(callback, state);
			async_SendChat(cs, _byps_ret);
			return _byps_ret;
		}
		public 		ChatStructure EndSendChat(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ChatStructure>)asyncResult).Result;
		}
		
		
	}
}
