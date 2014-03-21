/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
// using System.Linq;
using System.Text;
// using System.Threading.Tasks;

namespace byps
{
    public class HTransportFactoryClient : BTransportFactory
    {

        public HTransportFactoryClient(BApiDescriptor apiDesc, BWire wire, int nbOfServerRConns)
        {
            this.transport = new BTransport(apiDesc, wire, null);
            this.nbOfServerRConns = nbOfServerRConns;

            // By default, .NET allows only 2 connections per server.
            // This is not sufficient when sending stream requests. 
            // In this case we need 1 + nbOfServerRConns + number-of-streams connections.
            // Assume here that a requests does not send more than 10 streams. If more streams 
            // should be sent, the .NET option has to be increased.
            int nbConns = 1 + nbOfServerRConns + 10;
            if (System.Net.ServicePointManager.DefaultConnectionLimit < nbConns)
            {
                System.Net.ServicePointManager.DefaultConnectionLimit = nbConns;
            }
        }

        public BTransport createClientTransport()
        {
            return transport;
        }

        public BTransport createServerTransport()
        {
            return transport;
        }

        public BClient createClientR(BClient client)
        {
            return null;
        }

        public BServerR createServerR(BServer server)
        {
            if (nbOfServerRConns == 0) return null;
            return new HServerR(transport, server, nbOfServerRConns);
        }

        protected readonly BTransport transport;
        protected readonly int nbOfServerRConns;
    }
}
