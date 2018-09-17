package com.SpringCloudFeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SERVICEAPP1")
public interface RemoteClient {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String test();
}