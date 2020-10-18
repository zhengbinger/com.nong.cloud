package com.nong.cloud.hytrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@Service
public class PaymentService {

  public String success(long id) {
    return "线程池：" + Thread.currentThread().getName() + " \t id:" + id + "\tO(∩_∩)O哈哈~";
  }

  @HystrixCommand(
      fallbackMethod = "paymentInfo_TimeOutHandler",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
      })
  public String paymentInfo_TimeOut(long id) {
    //    int age = 10 / 0;
    try {
      TimeUnit.MICROSECONDS.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return "线程池：" + Thread.currentThread().getName() + " \t id:" + id + "\t出错啦";
  }

  public String paymentInfo_TimeOutHandler(long id) {

    return "线程池：" + Thread.currentThread().getName() + " \t id:" + id + "\t出错啦,服务降级返回！";
  }

  /** 服务熔断 */
  @HystrixCommand(
      fallbackMethod = "paymentCricuitBreakerFallback",
      commandProperties = {
        @HystrixProperty(name = "cricuitBreaker.enabled", value = "true"),
        @HystrixProperty(name = "cricuitBreaker.requestVolumeThreshold", value = "10"),
        @HystrixProperty(name = "cricuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        @HystrixProperty(name = "cricuitBreaker.errorThresholdPercentage", value = "60"),
      })
  public String paymentCricuitBreaker(@PathVariable("id") long id) {
    if (id < 0) {
      throw new RuntimeException("****** id 不能负数");
    }
    String serialNumbner = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + "\t 调用成功，流水号是：" + serialNumbner;
  }

  public String paymentCricuitBreakerFallback(@PathVariable("id") long id) {
    return "出现熔断！！！";
  }
}
