package com.nong.cloud.order.feign.controller;

import com.nong.cloud.order.feign.service.FeignPaymentService;
import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@RestController
public class OrderFeignController {

  @Autowired private FeignPaymentService feignPaymentService;

  @GetMapping(value = "consumer/payment/feign/{id}")
  public RestResult<Payment> getPaymentById(@PathVariable("id") long id) {
    return feignPaymentService.getById(id);
  }

  @GetMapping(value = "consumer/payment/feign/timeout")
  public String paymentFeignTimeOut() {
    // open-feign 默认等待1秒
    return feignPaymentService.paymentFeignTimeOut();
  }
}
