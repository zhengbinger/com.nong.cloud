package com.nong.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhengbing
 * @date: 2020/11/11
 * @email: mydreambing@126.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(NacosConfigClientApplication.class, args);
  }
}
