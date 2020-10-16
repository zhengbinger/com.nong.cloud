package com.nong.cloud.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: zhengbing
 * @date: 2020/10/16
 * @email: mydreambing@126.com
 */
@Controller
public class ServiceController {

  @Autowired private DiscoveryClient discoveryClient;

  @GetMapping("/zk/payment/discovery")
  public Object getService() {
    List<String> applications = discoveryClient.getServices();

    for (String service : applications) {
      System.out.println(service + "::: instance");
    }

    List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT");
    for (ServiceInstance instance : instances) {
      System.out.println(instance.getHost() + " " + instance.getPort() + " " + instance.getUri());
    }
    return this.discoveryClient;
  }
}
