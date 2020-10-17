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
