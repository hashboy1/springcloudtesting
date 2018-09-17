package com.SpringCloudRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test() {
        return restTemplate.getForEntity("http://SERVICEAPP1/test", String.class).getBody();
    }
   
    @RequestMapping("/info")
    public String info() {
        return "Default Information";
    }
}