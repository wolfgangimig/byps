using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using com.wilutions.byps;
using com.wilutions.byps.test.api;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;

namespace bypstest
{
    public class TestUtilsHttp
    {
        public static String url = "http://localhost:6080/bypstest-srv/bypsservlet";

        public static BClient_Testser createClient()
        {
            return createClient(BWireFlags.DEFAULT);
        }

        public static BClient_Testser createClient(BWireFlags flags) 
        {
            BClient_Testser client = null;
            try
            {

                BWire wire = new HWireClient(url, flags, 120);
                BTransportFactory transportFactory = new HTransportFactoryClient(BApiDescriptor_Testser.instance, wire, 3);

                client = BClient_Testser.createClient(transportFactory);

                BSyncResult<BClient> syncResult = new BSyncResult<BClient>();
                client.start(syncResult);

                syncResult.GetResult();
            }
            catch (Exception e)
            {
                Assert.Fail(e.ToString());
            }

		    return client;
	    }

        internal static List<System.IO.Stream> makeTestStreams()
        {
            List<Stream> ret = new List<Stream>();
            ret.Add(new TestUtils.MyContentStream(0));
            ret.Add(new TestUtils.MyContentStream(1));
            ret.Add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER - 1));
            ret.Add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER));
            ret.Add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER + 1));
            ret.Add(new TestUtils.MyContentStream(HConstants.INCOMING_STREAM_BUFFER * 2));
            if (TestUtils.TEST_LARGE_STREAMS)
            {
                ret.Add(new TestUtils.MyContentStream(0x100000000L));
            }
            return ret;
        }
    }
}
