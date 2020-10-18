package com.nong.cloud.hytrix.controller;

import com.nong.cloud.hytrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@Slf4j
@RestController
public class PaymentController {

  @Autowired private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "payment/hystrix/ok/{id}")
  public String payementInfo_Ok(@PathVariable("id") long id) {
    return paymentService.success(id);
  }

  @GetMapping(value = "payment/hystrix/timeout/{id}")
  public String payementInfo_TimeOut(@PathVariable("id") long id) {
    log.info(id + "");
    return paymentService.paymentInfo_TimeOut(id);
  }

  @GetMapping(value = "payment/circuit/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") long id) {
    log.info(id + " 进入熔断接口！！！");
    return paymentService.paymentCircuitBreaker(id);
  }
}
