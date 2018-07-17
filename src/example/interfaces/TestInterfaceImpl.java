package example.interfaces;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;


/**
 * @Author: XieLiang
 * @Date : 2018/7/16
 * @Comment :
 */
@WebService
public class TestInterfaceImpl implements TestInterface {
    @Override
    @WebMethod
    public String getName(String userName) {
        System.out.println("from client:" +userName);
        String jjSize ;
        if("Blue".equals(userName)){
            jjSize = "15cm";
        }else{
            jjSize = "1cm";
        }
        System.out.println("to client:" +jjSize);
        return jjSize;
    }

    public static void main(String[] args) {
        /** 发送webservice服务
          * 使用Endpoint.publish(String address, Object implementor)发布服务
          * address: 服务地址
          * implementor: 实现类
          **/
        Endpoint.publish("http://localhost:8081/TestService",new TestInterfaceImpl());
    }
}
