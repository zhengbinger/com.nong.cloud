package com.nonng.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhengbing
 * @date: 2020/11/3
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }
}
