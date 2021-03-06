package cloudoll;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 调用远程方法
 */
public class Client {

    private boolean isStart = false;
    private Config config;

    /**
     * cloudeer 注册服务的配置
     */
    public Client(Config config) {
        this.config = config;
    }

    /**
     * 启动心跳服务
     */
    public void start() {
        if (isStart) {
            throw new RuntimeException("已经启动客户端 请勿重复启动!");
        }
        isStart = true;
        // 启动心跳线程
        new HeartThread(config).start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 如果没有找到 那么 就等待3秒 心跳去 取就好了 没必要阻塞
    }

    private Object getHosts(String serviceName) {
        Map cloudollConfig = (Map) App.getApplicationValue(App.CLOUDOLL_CONFIG);
        if (cloudollConfig == null) {
            throw new NullPointerException("服务 host 加载失败，请先执行 start, 或者校对register服务器地址!");
        }
        return cloudollConfig.get(serviceName);
    }

    private List<Host> getHosts(Object obj) {
        if (obj == null) {
            throw new NullPointerException("没有找到所指定的服务!");
        } else {
            return JSONArray.parseArray(((Map) obj).get("hosts").toString(), Host.class);
        }
    }

    private Host extract(List<Host> hosts) {
        Random rand = new Random();
        return hosts.get(rand.nextInt(hosts.size()));
    }

    /***
     * 从 serviceName 中抽随机抽取一个 host
     */
    private Host getHost(String serviceName) {
        Object hostsObject = getHosts(serviceName);
        return this.extract(getHosts(hostsObject));
    }

    /**
     * @
     */
    public CloudollResponse post(String serviceName, String uri, Object param) throws IOException, CloudollException, Exception {
        String param_ = JSONObject.toJSONString(param);
        Host host = this.getHost(serviceName);
        String url = "http://" + host.getHost() + ":" + host.getPort() + host.getBaseUri() + (uri.startsWith("/") ? uri : "/" + uri);

        String stringResponse = HttpClient.postJson(url, param_);
        CloudollResponse rtn = JSONObject.parseObject(stringResponse, CloudollResponse.class);
        if (rtn.getErrno() != 0) {
            throw new CloudollException(rtn.getErrText(), rtn.getErrno(), rtn.getService());
        }
        return rtn;
    }

    public CloudollResponse get(String serviceName, String uri) throws IOException, CloudollException, Exception {
        Host host = this.getHost(serviceName);
        String url = "http://" + host.getHost() + ":" + host.getPort() + host.getBaseUri() + (uri.startsWith("/") ? uri : "/" + uri);

        String stringResponse = HttpClient.get(url);
        CloudollResponse rtn = JSONObject.parseObject(stringResponse, CloudollResponse.class);
        if (rtn.getErrno() != 0) {
            throw new CloudollException(rtn.getErrText(), rtn.getErrno(), rtn.getService());
        }
        return rtn;
    }
}
