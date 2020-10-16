package com.nong.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@RestController
public class PaymentController {

  @Value("server.port")
  private String serverPort;

  @RequestMapping(value = "payment/consul")
  public String paymentZk() {
    return "Springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
  }
}
