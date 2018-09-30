package com.SpringCloudEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication2 {

	//access the http://localhost:8761/
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class, args);
    }
}
