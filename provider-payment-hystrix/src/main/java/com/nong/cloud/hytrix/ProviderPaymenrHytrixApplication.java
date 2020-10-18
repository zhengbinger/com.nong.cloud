package com.nong.cloud.hytrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderPaymenrHytrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProviderPaymenrHytrixApplication.class, args);
  }
}
