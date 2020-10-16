package com.nong.cloud.zk.controller;

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
public class ZkController {

  @Autowired private RestTemplate restTemplate;

  private static final String URL = "http://provider-payment-zk";

  @RequestMapping(value = "consumer/payment/zk")
  public String paymentInfo() {
    return restTemplate.getForObject(URL + "/payment/zk", String.class);
  }
}
