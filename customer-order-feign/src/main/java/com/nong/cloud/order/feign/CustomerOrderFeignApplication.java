package com.nong.cloud.order.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerOrderFeignApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerOrderFeignApplication.class, args);
  }
}
