package com.nong.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerOrderConsulApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerOrderConsulApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
