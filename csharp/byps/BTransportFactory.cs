using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public interface BTransportFactory
    {
        BTransport createClientTransport();
        BTransport createServerTransport();
        BClient createClientR(BClient client);
        BServerR createServerR(BServer server);
    }

}
