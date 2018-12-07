package com.wedevol.greetingclientserver.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConfiguration {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
