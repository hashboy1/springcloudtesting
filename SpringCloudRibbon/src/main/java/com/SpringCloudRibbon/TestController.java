package com.SpringCloudRibbon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test() {
        return restTemplate.getForEntity("http://serviceapp1/test", String.class).getBody();
    }
    
    @RequestMapping("/findemployee")
    public String findemployee(@RequestParam(value="Id",required=false) String ID) {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		 MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		 map.add("Id", ID);	 
		 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);		 
		 System.out.println("id:"+ID);
         return restTemplate.postForEntity("http://servicelogin/findEmployeeByID",request,String.class).getBody();
    }
   
    @RequestMapping("/info")
    public String info() {
        return "Default Information";
    }
}