package com.nong.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentConsul {

  public static void main(String[] args) {
    SpringApplication.run(ProviderPaymentConsul.class, args);
  }
}
