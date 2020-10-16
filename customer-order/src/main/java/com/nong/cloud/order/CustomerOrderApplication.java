package com.nong.cloud.order;

import com.nong.cloud.myrule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "PROVIDER-PAYMENT", configuration = MyRibbonRule.class)
public class CustomerOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerOrderApplication.class, args);
  }

  /**
   * 实现客户端负载均衡 采用默认算法 轮训
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
