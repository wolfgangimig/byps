using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.srvr
{
	
	public class BStub_ClientIF : BStub, ClientIF, BSerializable {	
		
		public readonly static long serialVersionUID = 2049072174L;
		
		public BStub_ClientIF(BTransport transport)
			: base(transport) {}			
		
		public int IncrementInt(int a) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			IncrementInt(a, BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void IncrementInt(int a, BAsyncResult<int> asyncResult) {
			BRequest_ClientIF_incrementInt req = new BRequest_ClientIF_incrementInt();			
			req._a = a;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> IncrementIntAsync(int a){
			BRequest_ClientIF_incrementInt req = new BRequest_ClientIF_incrementInt();			
			req._a = a;
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		public IList<System.IO.Stream> GetStreams(int ctrl) {
			BSyncResult<IList<System.IO.Stream>> asyncResult = new BSyncResult<IList<System.IO.Stream>>();			
			GetStreams(ctrl, BAsyncResultHelper.ToDelegate<IList<System.IO.Stream>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			BRequest_ClientIF_getStreams req = new BRequest_ClientIF_getStreams();			
			req._ctrl = ctrl;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<System.IO.Stream>> GetStreamsAsync(int ctrl){
			BRequest_ClientIF_getStreams req = new BRequest_ClientIF_getStreams();			
			req._ctrl = ctrl;
			Task<IList<System.IO.Stream>> task = Task<IList<System.IO.Stream>>.Factory.FromAsync(transport.BeginSend<IList<System.IO.Stream>>, transport.EndSend<IList<System.IO.Stream>>, req, null);
			return await task;
		}
		
		public void PutStreams(IList<System.IO.Stream> strm, int ctrl) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			PutStreams(strm, ctrl, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) {
			BRequest_ClientIF_putStreams req = new BRequest_ClientIF_putStreams();			
			req._strm = strm;
			req._ctrl = ctrl;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task PutStreamsAsync(IList<System.IO.Stream> strm, int ctrl){
			BRequest_ClientIF_putStreams req = new BRequest_ClientIF_putStreams();			
			req._strm = strm;
			req._ctrl = ctrl;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ChatStructure SendChat(ChatStructure cs) {
			BSyncResult<ChatStructure> asyncResult = new BSyncResult<ChatStructure>();			
			SendChat(cs, BAsyncResultHelper.ToDelegate<ChatStructure>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) {
			BRequest_ClientIF_sendChat req = new BRequest_ClientIF_sendChat();			
			req._cs = cs;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<ChatStructure> SendChatAsync(ChatStructure cs){
			BRequest_ClientIF_sendChat req = new BRequest_ClientIF_sendChat();			
			req._cs = cs;
			Task<ChatStructure> task = Task<ChatStructure>.Factory.FromAsync(transport.BeginSend<ChatStructure>, transport.EndSend<ChatStructure>, req, null);
			return await task;
		}
		
		
	}
}
