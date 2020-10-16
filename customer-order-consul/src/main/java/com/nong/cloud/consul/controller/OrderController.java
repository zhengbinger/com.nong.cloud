package com.nong.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@RestController
public class OrderController {

  @Autowired private RestTemplate restTemplate;

  private static final String URL = "http://provider-payment-consul";

  @RequestMapping(value = "consumer/payment/consul")
  public String paymentInfo() {
    return restTemplate.getForObject(URL + "/payment/consul", String.class);
  }
}
