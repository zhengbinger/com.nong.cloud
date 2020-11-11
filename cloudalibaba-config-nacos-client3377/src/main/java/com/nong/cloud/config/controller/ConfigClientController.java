package com.nong.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/11/11
 * @email: mydreambing@126.com
 */
@RestController
@RefreshScope
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping(value = "/config/info")
  public String getConfigInfo() {
    return configInfo;
  }
}
