package matlab.engine.remote.example;

import matlab.engine.remote.common.Server;
import matlab.engine.remote.common.ServerFactory;
import matlab.engine.remote.service.MatlabEngineServiceImpl;


/**
 * @author wangjie
 */
public class RPCEngineServerExamples {
    /**
     * 需要在启动参数中添加库路径，例如：-Djava.library.path=matlabroot/bin/glnxa64
     * <p>
     * https://ww2.mathworks.cn/help/matlab/matlab_external/setup-environment.html
     * -Djava.library.path=/Users/wangjie/Applications/MATLAB_R2022a.app/bin/maci64
     */
    public static void main(String[] args) throws Exception {
        MatlabEngineServiceImpl service = new MatlabEngineServiceImpl();
        Server<MatlabEngineServiceImpl> server = ServerFactory.createRPCServer(10992, service);
        server.start();
    }
}
