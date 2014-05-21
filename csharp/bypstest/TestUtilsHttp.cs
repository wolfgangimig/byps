/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using byps;
using byps.test.api;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using System.Net;

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
                ServicePointManager.DefaultConnectionLimit = 1000;


                BWire wire = new HWireClient(url, flags, 120);
                BTransportFactory transportFactory = new HTransportFactoryClient(BApiDescriptor_Testser.instance, wire, 1);

                client = BClient_Testser.createClient(transportFactory);

                BSyncResult<bool> syncResult = new BSyncResult<bool>();
                client.start(BAsyncResultHelper.ToDelegate(syncResult));

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
