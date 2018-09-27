package com.SpringCloudHystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;




//access: http://127.0.0.1:3334/hystrix
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
