package com.nong.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhengbing
 * @date: 2020/10/20
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudGatewayApplication.class, args);
  }
}
