package com.SpringCloudEurekaClient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCloudEurekaClient.model.Employee;
import com.SpringCloudEurekaClient.service.EmployeeService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;



@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceLoginApplication {
    @Autowired
    private EurekaClient client;
    
    @Autowired
	EmployeeService es;

    public static void main(String[] args) {
        SpringApplication.run(ServiceLoginApplication.class, args);
    }

    @RequestMapping("/info")
    public String test() {
        return "test";
    }
    
    //access the service url:http://win-v3gcuom6s7g:8083/findEmployeeByID/9521
    //access the zuul    url:http://win-v3gcuom6s7g:8040/servicelogin/findEmployeeByID/9521

   
    /*
  	@RequestMapping(value = "/findEmployeeByID/{id}", method =RequestMethod.GET)
    public String testClient(@PathVariable("id") long id) {
    */
    @CrossOrigin
    @RequestMapping(value = "/findEmployeeByID")
    public String testClient(@RequestParam("Id") String ID) {
    	
    	System.out.println("id:"+ID);
    	Employee ee=es.selectUserById(ID);
    	return ee.toString();
    }
}