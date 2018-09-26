package com.SpringCloudZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient    //if you need get appid from eureka, this annotation will be necessary
public class ZuulApplication {

      public static void main(String[] args) throws Exception {

           SpringApplication.run(ZuulApplication.class, args);
           
           
/*  you can add belows contents to configuration file. if not, all services on ereka will be added to zuul gateway.
*   you can access the service by zuulip+port/applicationID/**
*   but please attention to the applicationid will change to lower case.    
zuul:
  routes:
    SERVICEAPP1: /SERVICEAPP1/**	
            */
      }

}