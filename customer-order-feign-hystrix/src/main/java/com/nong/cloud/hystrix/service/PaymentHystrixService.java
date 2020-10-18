package com.nong.cloud.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@Component
@FeignClient(value = "PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentFallBackServiceImpl.class)
public interface PaymentHystrixService {

  @GetMapping(value = "payment/hystrix/ok/{id}")
  String payementInfoOk(@PathVariable("id") long id);

  @GetMapping(value = "payment/hystrix/timeout/{id}")
  String payementInfoTimeOut(@PathVariable("id") long id);
}
