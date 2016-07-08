package cloudoll;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 远程响应的封装
 */
public class CloudollResponse {
    private Integer errno;
    private String errText;
    private String service;

    public String getErrText() {
        return errText;
    }

    public void setErrText(String errText) {
        this.errText = errText;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }




    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
