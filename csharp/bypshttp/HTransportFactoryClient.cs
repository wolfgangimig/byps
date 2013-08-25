using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class HTransportFactoryClient : BTransportFactory
    {

        public HTransportFactoryClient(BApiDescriptor apiDesc, BWire wire, int nbOfServerRConns)
        {
            this.transport = new BTransport(apiDesc, wire, null);
            this.nbOfServerRConns = nbOfServerRConns;
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
