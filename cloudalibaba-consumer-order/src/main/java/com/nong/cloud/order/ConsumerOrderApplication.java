package com.nong.cloud.order;

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
public class ConsumerOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerOrderApplication.class, args);
  }
}
