package com.SpringCloudSwagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableHystrix
@RestController
public class SwaggerClient
{
	//http://win-v3gcuom6s7g:8089/swagger-ui.html	
	public static void main( String[] args )
    {
    	SpringApplication.run(SwaggerClient.class, args);
    }
    
    @RequestMapping(value="info",method=RequestMethod.GET)
    @ApiOperation(value="/info",notes="information")
    public String test() {
        return "test";
    }
}



