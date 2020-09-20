package com.nong.cloud.order.controller;

import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@RestController
public class PaymentController {

  @Autowired private RestTemplate restTemplate;

  public static final String PAYMENT_URL = "http://192.168.1.4:8001/";

  @GetMapping("/consumer/payment/{id}")
  public RestResult getById(@PathVariable long id) {
    return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, RestResult.class);
  }

  @GetMapping("/consumer/payment/add")
  public RestResult save(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "payment/add", payment, RestResult.class);
  }
}
