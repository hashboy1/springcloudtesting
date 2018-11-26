package com.SpringCloudConfigClient;
 
import java.sql.SQLException;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

 
@Configuration
@RefreshScope
public class DruidConfiguration {
	@Value("${spring.datasource.platform}")
    private String platform;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
	@Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
 
    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    @RefreshScope
    public DataSource dataSource(){
    	
    	String returnValue="platform:"+platform;
    	returnValue+=",url:"+url;
    	returnValue+=",username:"+username;
    	returnValue+=",password:"+password;
    	returnValue+=",driverClassName:"+driverClassName;
    	
    	System.out.println("get parameters:"+returnValue);
    	
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setDbType(platform);
        return datasource;
    }
}
