package com.nong.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhengbing
 * @date: 2020/10/17
 * @email: mydreambing@126.com
 */
@Component
public class MyLoadBalance implements LoadBalance {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public final int getAndIncreament() {
    int current;
    int next;
    do {
      current = this.atomicInteger.get();
      next = current >= 2147483647 ? 0 : current + 1;
    } while (!this.atomicInteger.compareAndSet(current, next));

    return next;
  }

  public ServiceInstance instance(List<ServiceInstance> lists) {
    int index = getAndIncreament() % lists.size();
    return lists.get(index);
  }
}
