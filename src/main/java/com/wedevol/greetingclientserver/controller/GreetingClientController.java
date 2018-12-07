package com.wedevol.greetingclientserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.wedevol.greetingclientserver.configuration.RibbonHelloConfiguration;

/**
 * Greeting Client REST Controller
 * 
 * @author charz
 *
 */
@RestController
@RibbonClient(name = "say-hello-server", configuration = RibbonHelloConfiguration.class)
public class GreetingClientController {

  protected static final Logger logger = LoggerFactory.getLogger(GreetingClientController.class);

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/hi")
  @ResponseStatus(HttpStatus.OK)
  public String hi(@RequestParam(value = "name", defaultValue = "Charz") String name) {
    final String greeting = this.restTemplate.getForObject("http://say-hello-server/greetingserver/greeting", String.class);
    return String.format("%s, %s!", greeting, name);
  }

}
