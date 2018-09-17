package com.SpringCloudFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RemoteClient remoteClient;

    @RequestMapping("/test")
    public String test() {
        return remoteClient.test();
    }
    
    
    @RequestMapping("/info")
    public String info() {
        return "Feign Default Information";
    }
}