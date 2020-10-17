package com.nong.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
public interface LoadBalance {

  ServiceInstance instance(List<ServiceInstance> lists);
}
