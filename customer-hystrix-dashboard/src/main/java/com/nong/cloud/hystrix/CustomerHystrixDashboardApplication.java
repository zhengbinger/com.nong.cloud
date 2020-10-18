package com.nong.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: zhengbing
 * @date: 2020/10/19
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CustomerHystrixDashboardApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerHystrixDashboardApplication.class, args);
  }
}
