package com.SpringCloudConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfigTontroller {
    //这个@Value会根据配置的配置中心地址找到git仓库对应的配置和本地服务的配置文件
 
    @Value("${datasource.platform}")
    private String platform;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driverClassName}")
    private String driverClassName;
    
    @RequestMapping("printConfig")
    public String printConfig(){

    	String returnValue="platform:"+platform;
    	returnValue+=",username:"+username;
    	returnValue+=",password:"+password;
    	returnValue+=",driverClassName:"+driverClassName;
		return returnValue;
    	
       
    }
}