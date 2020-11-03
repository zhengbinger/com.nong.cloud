package com.nonng.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengbing
 * @date: 2020/10/21
 * @email: mydreambing@126.com
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value(value = "${config.info}")
    private String configInfo;

    @RequestMapping(value = "configInfo")
    public String getConfigInfo() {
        return this.configInfo;
    }
}