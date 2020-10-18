package com.nong.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhengbing
 * @date: 2020/10/18
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class CustomerHystrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerHystrixApplication.class, args);
  }
}
