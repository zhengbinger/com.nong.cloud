package com.nong.cloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nong.cloud.hystrix.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class OrderHystrixController {

  @Autowired private PaymentHystrixService paymentHystrixService;

  @GetMapping(value = "consumer/payment/hystrix/ok/{id}")
  public String payementInfoOk(@PathVariable("id") long id) {
    return paymentHystrixService.payementInfoOk(id);
  }

  //  @HystrixCommand(
  //      fallbackMethod = "paymentInfoTimeOutHandler",
  //      commandProperties = {
  //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value =
  // "1500")
  //      })
  @HystrixCommand
  @GetMapping(value = "consumer/payment/hystrix/timeout/{id}")
  public String payementInfoTimeOut(@PathVariable("id") long id) {
    int age = 10 / 0;
    return paymentHystrixService.payementInfoTimeOut(id);
  }

  public String paymentInfoTimeOutHandler(@PathVariable("id") long id) {
    return "消费者80，支付系统繁忙，请稍后再重试！！！";
  }

  public String paymentGlobalFallBackMethod() {
    return "Global 异常处理，系统异常，请稍后重试。";
  }
}
