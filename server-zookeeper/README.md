## Spring Cloud Zookeeper 作为服务注册中心
Zookeeper 使用 临时节点作为服务节点

zookeeper 配置注册中心
```
spring: 
  cloud:
    zookeeper:
      connect-string: localhost:2181
```