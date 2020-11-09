package com.nong.cloud.payment.controller;

import com.nong.cloud.payment.service.PaymentService;
import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@RestController
public class PaymentController {

  @Autowired private PaymentService paymentService;

  @Autowired private DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/payment/get/{id}")
  public RestResult<Payment> getById(@PathVariable long id) {
    return new RestResult(200, serverPort, paymentService.getByPrimaryKey(id));
  }

  @PostMapping("/payment/add")
  public RestResult addPayment(@RequestBody Payment payment) {
    int add = paymentService.save(payment);
    if (add > 0) {
      return RestResult.success(add);
    } else {
      return RestResult.fail(100, "新增失败");
    }
  }

  @GetMapping("/payment/discovery")
  public Object getService() {
    List<String> applications = discoveryClient.getServices();

    StringBuffer results = new StringBuffer();
    for (String service : applications) {
      System.out.println(service + "::: instance");
    }

    List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT");
    for (ServiceInstance instance : instances) {
      System.out.println(instance.getHost() + " " + instance.getPort() + " " + instance.getUri());
    }
    return this.discoveryClient;
  }

  @GetMapping(value = "/payment/lb")
  public String getPaymentLB() {
    return serverPort;
  }

  @GetMapping(value = "/payment/feign/timeout")
  public String paymentFeignTimeOut() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return serverPort;
  }

  @GetMapping("/payment/zipkin")
  public String paymentZipkin() {
    return "hi  zipkin  im  payment   provider";
  }
}
