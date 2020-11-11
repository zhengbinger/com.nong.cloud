package com.nong.cloud.nacos.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/11/10
 * @email: mydreambing@126.com
 */
@RestController
public class EchoController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "payment/nacos/{string}")
  public String echo(@PathVariable String string) {
    return "Hello Nacos Discovery " + serverPort + "\t" + string;
  }
}
