package com.SpringCloudConfigClient;




import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
 
@SpringBootApplication
//@EnableAutoConfiguration
//@MapperScan(basePackages = {"com.SpringCloudConfigClient.dao"})
public class ConfigClientApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

  
    
    
}