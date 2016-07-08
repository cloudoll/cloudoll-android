package cloudoll;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 */
public class Test {


    public static void main(String[] a) throws IOException, CloudollException {

        Client client = new Client(new Config("127.0.0.1", 8801));
        client.start();
//        String serviceName = "mall.service.customer";
//        String uri = "/open/cause/find-by-code?code=REFUND_CAUSE";
//        String ticket = "eyJvcGVuX2lkIjoiMmZhNjFlNjgtNDI5Yy0xMWU2LWE5MTYtMDI0MmMwYTgwMDA1IiwiZXhwaXJlc19pbiI6MTQ2Nzk1ODg2NCwic2lnbiI6ImM4MzNmZWUzNTg1YWEzM2IwZDdmNTE5YWQzZmU5OTgxZjNjM2FhZDY5Y2YwNjg4MTI1ZjBkMzFhMGFjNTdjZDcifQ==";
//
//        String service = "cloudarling";
//        String uri = "/open/account/info?ticket=" + ticket;
//        CloudollResponse response = client.get(service, uri);
//        System.out.println(response.getData());


        String service = "cloudarling";
        String uri = "/open/account/login";
        Map loginInfo = new HashMap();
        loginInfo.put("passport", "13006699866");
        loginInfo.put("password", "111111");

        CloudollResponse response = null;
        response = client.post(service, uri, loginInfo);
        System.out.println(response);


    }
}
