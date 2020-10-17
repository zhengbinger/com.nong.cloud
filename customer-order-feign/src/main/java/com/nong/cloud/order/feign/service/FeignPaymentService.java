package com.nong.cloud.order.feign.service;

import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@Component
@FeignClient(value = "PROVIDER-PAYMENT")
public interface FeignPaymentService {

  @GetMapping("payment/{id}")
  RestResult<Payment> getById(@PathVariable("id") long id);

  @GetMapping(value = "payment/feign/timeout")
  String paymentFeignTimeOut();
}
