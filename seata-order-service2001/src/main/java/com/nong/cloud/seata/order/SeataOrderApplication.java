package com.nong.cloud.seata.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhengbing
 * @date: 2020/12/2
 * @email: mydreambing@126.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SeataOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeataOrderApplication.class, args);
  }
}
