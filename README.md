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
