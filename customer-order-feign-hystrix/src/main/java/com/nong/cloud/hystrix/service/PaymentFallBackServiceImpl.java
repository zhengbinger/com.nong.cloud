package com.nong.cloud.hystrix.service;

import org.springframework.stereotype.Component;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@Component
public class PaymentFallBackServiceImpl implements PaymentHystrixService {

  public String payementInfoOk(long id) {
    return "----- paymentFallbackService OK  fall back -----";
  }

  public String payementInfoTimeOut(long id) {
    return "----- paymentFallbackService error  fall back -----";
  }
}
