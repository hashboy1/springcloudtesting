package com.SpringCloudConfigClient;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@RefreshScope
//@ConfigurationProperties(prefix="spring.datasource")
//@PropertySource("classpath:application.yaml")
public class AutoConfig {
    //这个@Value会根据配置的配置中心地址找到git仓库对应的配置和本地服务的配置文件
    @Value("${datasource.platform}")
    private String platform;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
	@Value("${datasource.password}")
    private String password;
    @Value("${datasource.driverClassName}")
    private String driverClassName;
    private DataSource datasource;
    
    AutoConfig()
    {
    	String returnValue="platform:"+platform;
	returnValue+=",url:"+url;
	returnValue+=",username:"+username;
	returnValue+=",password:"+password;
	returnValue+=",driverClassName:"+driverClassName;
	
	System.out.println("get parameters:"+returnValue);
    	
    	
    }
    
}
