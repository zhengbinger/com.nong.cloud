package com.nong.cloud.order.controller;

import com.nong.cloud.order.lb.MyLoadBalance;
import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@RestController
public class PaymentController {

  @Autowired RestTemplate restTemplate;

  @Autowired private DiscoveryClient discoveryClient;

  @Autowired private MyLoadBalance myLoadBalance;

  //  public static final String PAYMENT_URL = "http://192.168.1.4:8001/";
  public static final String PAYMENT_URL = "http://PROVIDER-PAYMENT/";

  @GetMapping("/consumer/payment/{id}")
  public RestResult getById(@PathVariable long id) {
    return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, RestResult.class);
  }

  @GetMapping("/consumer/payment/add")
  public RestResult save(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "payment/add", payment, RestResult.class);
  }

  @GetMapping("/consumer/payment/entity/{id}")
  public RestResult getByIdEntity(@PathVariable long id) {
    ResponseEntity<RestResult> entity =
        restTemplate.getForEntity(PAYMENT_URL + "payment/" + id, RestResult.class);
    if (entity.getStatusCode().is2xxSuccessful()) {
      return entity.getBody();
    } else {
      return RestResult.fail(444, "操作失败");
    }
  }

  @GetMapping("/consumer/payment/entity/add")
  public RestResult saveEntity(Payment payment) {
    ResponseEntity<RestResult> entity =
        restTemplate.postForEntity(PAYMENT_URL + "payment/add", payment, RestResult.class);
    if (entity.getStatusCode().is2xxSuccessful()) {
      return entity.getBody();
    } else {
      return RestResult.fail(444, "操作失败");
    }
  }

  @GetMapping(value = "consumer/payment/lb")
  public String getPaymentUrlLoadBalance() {
    List<ServiceInstance> list = discoveryClient.getInstances("PROVIDER-PAYMENT");

    if (null != list && list.size() > 0) {
      ServiceInstance serviceInstance = myLoadBalance.instance(list);
      URI uri = serviceInstance.getUri();
      return restTemplate.getForObject(uri + "payment/lb", String.class);
    }
    return null;
  }

  @GetMapping(value = "consumer/payment/zipkin")
  public String paymentZipkin() {
    List<ServiceInstance> list = discoveryClient.getInstances("PROVIDER-PAYMENT");

    if (null != list && list.size() > 0) {
      ServiceInstance serviceInstance = myLoadBalance.instance(list);
      URI uri = serviceInstance.getUri();
      return restTemplate.getForObject(uri + "payment/zipkin", String.class);
    }
    return null;
  }
}
