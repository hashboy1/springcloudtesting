package com.SpringCloudConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfigTontroller {
    //这个@Value会根据配置的配置中心地址找到git仓库对应的配置和本地服务的配置文件
    @Value("${profile}")
    private String configValue;
    @RequestMapping("testConfig")
    public String test(){
        return "读取到配置中心："+configValue;
    }
}