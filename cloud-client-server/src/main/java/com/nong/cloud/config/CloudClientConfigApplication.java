package com.nong.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhengbing
 * @date: 2020/10/21
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudClientConfigApplication {
  public static void main(String[] args) {
    SpringApplication.run(CloudClientConfigApplication.class, args);
  }
}
