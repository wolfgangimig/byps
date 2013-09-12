using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public interface ClientIF : BRemote
	{
		int IncrementInt(int a);
		void IncrementIntAsync(int a, BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginIncrementInt(int a, AsyncCallback callback, object state);
		int EndIncrementInt(IAsyncResult asyncResult);
		
		IList<System.IO.Stream> GetStreams(int ctrl);
		void GetStreamsAsync(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) ;
		IAsyncResult BeginGetStreams(int ctrl, AsyncCallback callback, object state);
		IList<System.IO.Stream> EndGetStreams(IAsyncResult asyncResult);
		
		void PutStreams(IList<System.IO.Stream> strm, int ctrl);
		void PutStreamsAsync(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginPutStreams(IList<System.IO.Stream> strm, int ctrl, AsyncCallback callback, object state);
		Object EndPutStreams(IAsyncResult asyncResult);
		
		ChatStructure SendChat(ChatStructure cs);
		void SendChatAsync(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) ;
		IAsyncResult BeginSendChat(ChatStructure cs, AsyncCallback callback, object state);
		ChatStructure EndSendChat(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
