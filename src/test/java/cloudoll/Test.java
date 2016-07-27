package cloudoll;

/**
 * 测试
 */
public class Test {


    public static void main(String[] a) throws Exception {

        //Client client = new Client(new Config("127.0.0.1", 8801, 60000));
        final Client client = new Client(new Config("10.163.56.176", 8801, 60000));
//        String serviceName = "cloudarling";
//        String uri = "/open/cause/find-by-code?code=REFUND_CAUSE";


        new Thread() {
            @Override
            public void run() {
                String ticket = "eyJvcGVuX2lkIjoiOTEyYzNkMjAtNDcxZi0xMWU2LTk0M2YtMDI0MmFjMTEwMDAxIiwiZXhwaXJlc19pbiI6MTQ2OTYxOTQwMSwic2lnbiI6IjkzMWMzMTdiODNmZjA4OWM2YmMzNjBjMTY4MDA5MDhhZmY5MGIzZjdhZjA3MjYwN2VhODhkZmVkNDNkZmIwYjYifQ==";
//
                String service = "cloudarling";
                String uri = "/open/account/info?ticket=" + ticket;

                for (int i = 0; i < 10; i++) {

                    CloudollResponse response = null;
                    try {
                        response = client.get(service, uri);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(response.getData());

//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }
        }.start();

        Thread.sleep(3000);
        client.start();



        String ticket = "eyJvcGVuX2lkIjoiOTEyYzNkMjAtNDcxZi0xMWU2LTk0M2YtMDI0MmFjMTEwMDAxIiwiZXhwaXJlc19pbiI6MTQ2OTYxOTQwMSwic2lnbiI6IjkzMWMzMTdiODNmZjA4OWM2YmMzNjBjMTY4MDA5MDhhZmY5MGIzZjdhZjA3MjYwN2VhODhkZmVkNDNkZmIwYjYifQ==";
//
        String service = "cloudarling";
        String uri = "/open/account/info?ticket=" + ticket;

        for (int i = 0; i < 10; i++) {

            CloudollResponse response = client.get(service, uri);
            System.out.println(response.getData());

            Thread.sleep(1000);
        }


//        String service = "cloudarling";
//        String uri = "/open/account/login";
//        Map loginInfo = new HashMap();
//        loginInfo.put("passport", "13006699866");
//        loginInfo.put("password", "111111");
//
//        for (int i = 0; i < 10; i++) {
//            CloudollResponse response = null;
//            try {
//                response = client.post(service, uri, loginInfo);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println(response);
//            Thread.sleep(1000);
//        }


    }
}
