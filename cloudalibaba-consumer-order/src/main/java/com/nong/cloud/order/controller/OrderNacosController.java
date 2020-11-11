package com.nong.cloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhengbing
 * @date: 2020/11/11
 * @email: mydreambing@126.com
 */
@RestController
public class OrderNacosController {

  @Autowired private RestTemplate restTemplate;

  @Value("${service-url.nacos-user-service}")
  private String serviceUrl;

  @GetMapping(value = "consumer/payment/nacos/{string}")
  public String paymentInfno(@PathVariable("string") String string) {
    return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + string, String.class);
  }
}
