package cloudoll;

import com.alibaba.fastjson.JSONObject;

/**
 * 心跳线程
 */
class HeartThread extends Thread {

    /**
     * 配置
     */
    private Config config;

    HeartThread(Config config) {
        this.config = config;
    }

    @Override
    public void run() {
        String loadConfigUrl = "http://" + this.config.getHost() + ":" + this.config.getPort() + "/load-config";
        try {
            String response = getConfig(loadConfigUrl);
            CloudollResponse closeableHttpResponse = JSONObject.parseObject(response, CloudollResponse.class);
            //System.out.println(this.config.getHost() + "-TIME:" + System.currentTimeMillis());
            if (closeableHttpResponse.getErrno() != 0) {
                throw new RuntimeException("从" + loadConfigUrl + "获取服务器信息失败");
            } else {
                App.addApplication(App.CLOUDOLL_CONFIG, closeableHttpResponse.getData());
            }
        } catch (Exception e) {
            System.out.println("cloudoll 加载 config 的心跳异常 ->" + e.getMessage());
        } finally {
            try {
                sleep(config.getHeartBeat());
                this.run();// 直接递归就行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getConfig(String loadConfigUrl) throws Exception {
        return HttpClient.get(loadConfigUrl);
    }
}
