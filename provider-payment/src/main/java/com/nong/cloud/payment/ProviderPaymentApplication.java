package com.nong.cloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nong.cloud.payment.repository")
public class ProviderPaymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProviderPaymentApplication.class, args);
  }
}
