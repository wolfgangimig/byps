using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.srvr
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface ClientIF : BRemote {
	
		int IncrementInt(int a);
		void IncrementInt(int a, BAsyncResult<int> asyncResult) ;
		Task<int> IncrementIntAsync(int a);
		
		IList<System.IO.Stream> GetStreams(int ctrl);
		void GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) ;
		Task<IList<System.IO.Stream>> GetStreamsAsync(int ctrl);
		
		void PutStreams(IList<System.IO.Stream> strm, int ctrl);
		void PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) ;
		Task PutStreamsAsync(IList<System.IO.Stream> strm, int ctrl);
		
		ChatStructure SendChat(ChatStructure cs);
		void SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) ;
		Task<ChatStructure> SendChatAsync(ChatStructure cs);
		
		
	}
}  // end namespace
