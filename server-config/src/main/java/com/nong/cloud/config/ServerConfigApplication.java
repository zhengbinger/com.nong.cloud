package com.nong.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: zhengbing
 * @date: 2020/10/21
 * @email: mydreambing@126.com
 */
@SpringBootApplication
@EnableConfigServer
public class ServerConfigApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerConfigApplication.class, args);
  }
}
