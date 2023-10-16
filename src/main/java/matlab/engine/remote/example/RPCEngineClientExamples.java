package matlab.engine.remote.example;

import matlab.engine.remote.api.MatlabEngineService;
import matlab.engine.remote.common.Client;
import matlab.engine.remote.common.ClientFactory;

/**
 * @author wangjie
 */
public class RPCEngineClientExamples {
    public static void main(String[] args)throws Exception {
        Client client = ClientFactory.createRPCClient("127.0.0.1", 10992);
        MatlabEngineService service = client.get(MatlabEngineService.class);

        double[] x = {2.0, 4.0, 6.0};
        double[] res = service.feval("sqrt", x);
        for (double e : res) {
            System.out.println(e);
        }
    }
}
