package com.nong.cloud.order.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLever() {
    return Logger.Level.FULL;
  }
}
