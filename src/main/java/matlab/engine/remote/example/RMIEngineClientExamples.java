package matlab.engine.remote.example;

import matlab.engine.remote.api.MatlabEngineService;
import matlab.engine.remote.common.Client;
import matlab.engine.remote.common.ClientFactory;

import java.util.Arrays;

/**
 * @author wangjie
 */
public class RMIEngineClientExamples {
    public static void main(String[] args) throws Exception {
        Client client = ClientFactory.createRMIClient("127.0.0.1", 10991);
        MatlabEngineService service = client.get(MatlabEngineService.class);

        // 调用matlab函数
        if (true) {
            double[] x = {2.0, 4.0, 6.0};
            double[] res = service.feval("sqrt", (Object) x);
            for (double e : res) {
                System.out.println(e);
            }
        }

        // 调用自定义函数
        if (true) {
            double[] x = new double[]{1.0, 2.0, 3.0, 1.0};
            double[] res = service.feval("mfft", (Object) x, 4.0);
            for (double e : res) {
                System.out.println(e);
            }
        }

        // 调用matlab脚本
        String scripts = "y=0:1024-1;s=sin(2.0*pi*y*100.0/1000.0);fx=abs(fft(s));";
        service.eval(scripts);

        // 获取变量
        double[] fx = service.getVariable("fx");
        System.out.println(Arrays.toString(fx));
    }
}
