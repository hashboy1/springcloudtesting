package com.SpringCloudEurekaClient;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

import javax.validation.Valid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
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

import com.SpringCloudEurekaClient.cache.MybatisRedisCache;
import com.SpringCloudEurekaClient.model.Employee;
import com.SpringCloudEurekaClient.model.Person;
import com.SpringCloudEurekaClient.service.EmployeeService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = {"com.SpringCloudEurekaClient.dao"})
public class ServiceLoginApplication {
    @Autowired
    private EurekaClient client;
    @Autowired
    private Person pr;
    
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
    @HystrixCommand(fallbackMethod = "testConsumerError")
    public String testClient(@RequestParam(value="Id",required=false) String ID) throws UnknownHostException {
    	
    	System.out.println("id:"+ID);
    	/*
    	String a=null;
    	System.out.println(a.length());
        */
        if (ID == null|| ID.equals("")) return "please input the employee ID";	
    	
    	Employee ee=es.selectUserById(ID);
    	if (ee==null) return "The employee ID doesn't exist"; 
    	System.out.println("cache size:"+MybatisRedisCache.getCacheSize());
    	
    	
    	return ee.toString()+"+"+pr.toString()+"+ip:"+getHostIp();
    }
    
    
    //the parameters and return value of hystrix function must is the same with the original function
    public String testConsumerError(String ID)
    {
    	//System.out.println("Service isn't available");
    	return "Service is unavailable";
    	
    }
    
    private static String getHostIp(){
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
           while (allNetInterfaces.hasMoreElements()){
                 NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
               while (addresses.hasMoreElements()){
                    InetAddress ip = (InetAddress) addresses.nextElement();
                   if (ip != null 
                          && ip instanceof Inet4Address
                          && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                           && ip.getHostAddress().indexOf(":")==-1){
                      System.out.println("本机的IP = " + ip.getHostAddress());
                       return ip.getHostAddress();
                    } 
               }
            }
        }catch(Exception e){
           e.printStackTrace();
         }
        return null;
     }
    
}