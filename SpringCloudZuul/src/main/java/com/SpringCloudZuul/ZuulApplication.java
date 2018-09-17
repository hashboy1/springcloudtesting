package com.SpringCloudZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

      public static void main(String[] args) throws Exception {

           SpringApplication.run(ZuulApplication.class, args);

      }

}