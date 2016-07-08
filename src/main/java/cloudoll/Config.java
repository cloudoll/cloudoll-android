package cloudoll;

/**
 * 配置
 */
public class Config {

    public Config(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Config(String host, Integer port, Integer heartBeat) {
        this.host = host;
        this.port = port;
        this.heartBeat = heartBeat;
    }

    /**
     * 地址
     */
    private String host;

    /**
     * 端口
     */
    private Integer port;

    /**
     * heard time
     */
    private Integer heartBeat = 8000;

    /***
     * time out  超时时间
     */
    private Integer timeOut = 5000;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Integer heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}
