package com.nong.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author: zhengbing
 * @date: 2020/10/20
 * @email: mydreambing@126.com
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

  Logger log = LoggerFactory.getLogger(MyLogGatewayFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("MyLogGatewayFilter======================{}", new Date());
    String username = exchange.getRequest().getQueryParams().getFirst("username");
    if (null == username) {
      log.info("*** 非法用户登入 ***  {}", new Date());
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
