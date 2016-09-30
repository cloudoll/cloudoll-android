# cloudoll android/java 客户端

这个类库同时适用于 android，没有使用 apache 的 httpclient。

目前的版本使用的注册中心是 [cloudoll-server-rest](https://github.com/cloudoll/cloudoll-server-rest)

android 版本的是客户端直连微服务，并未使用代理，所以部署的时候应该把微服务部署在外网。

使用方法:

```java

import cloudoll.Client;

```

```java
Client client = new Client(new Config("127.0.0.1", 8801));
client.start();
String serviceName = "cloudarling";
String uri = "/open/district/children";
CloudollResponse response = client.get(serviceName, uri);
System.out.println(response.getData());
```

## API

### cloudoll.Client

* constructor(new Config(host, port, interval))

构造函数, 需要指定一个配置进去。

* start()

启动客户端,这是一个服务,会持续从注册中心下载服务列表。

在 android 中, config 的 心跳间隔(interval)不能设置得太短, 否则耗电,耗流量

* get(serviceName, uri)

GET 一个远程的的结果

* post(serviceName, uri, postData)

POST 一个远程的的结果
