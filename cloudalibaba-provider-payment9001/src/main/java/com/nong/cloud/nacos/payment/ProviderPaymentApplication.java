package com.nong.cloud.nacos.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhengbing
 * @date: 2020/11/10
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProviderPaymentApplication.class, args);
  }
}
