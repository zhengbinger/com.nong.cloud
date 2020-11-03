# SpringCloud 练手项目

## Eureka  Zookeeper Consul 的异同点

## Robbin
替换负载均衡算法

## RestTemplate

## OpenFeign
声明式的 web 服务客户端，让编写web 服务客户端变得非常容易，只需要创建一个借口并添加注解即可。

OpenFeign 超时控制
```
feign:
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000
```

## Hystrix 服务降级  熔断机制
分布式系统的延迟和容错开源库

"断路器"是一种开关装置

### 服务降级
程序运行异常
请求处理超时
系统宕机
服务熔断触发服务降级
线程池/信号量打满也会导致服务降级

### 服务熔断
保险丝

当检测到服务调用响应正常之后，恢复调用链路。

### 服务限流


## Gateway  服务网关
提供统一的路由方式

### 能做什么？
反向代理  
鉴权  
流量监控  
熔断   
日志监控   
### 三大概念

路由（Route）  
断言（Predicate）  
过滤（Filter）  

## Spring Cloud Bus 使用可以实现配置的动态刷新
Spring Cloud Bus 是用来将分布式系统的节点与轻量级消息系统连接起来的框架，它整合了Java 的事件处理机制和消息中间那间功能。
Spring Cloud Bus 目前只支持 RabbitMQ 和 Kafka

### 基本原理
ConfigClient 实例都监听MQ中的同一个topic (默认是 springCloudBus)。当一个服务刷新数据的时候，它会吧这个信息烦恼歌如到Topic 中去，
这样其他监听同一个Topic的服务就能得到通知，让后去更新自身的配置

http://localhost:3344/actual/bus/refresh
http://localhost:3344/actual/bus/refresh/config-client:3355



