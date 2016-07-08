# cloudoll java 客户端

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

* get(serviceName, uri)

GET 一个远程的的结果

* post(serviceName, uri, postData)

POST 一个远程的的结果