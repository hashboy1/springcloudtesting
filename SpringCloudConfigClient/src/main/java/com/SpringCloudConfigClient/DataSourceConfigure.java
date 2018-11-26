package com.SpringCloudConfigClient;

import javax.sql.DataSource;


import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RefreshScope
@Configuration
public class DataSourceConfigure { 
	
  @Bean
  @RefreshScope// 刷新配置文件 
  @ConfigurationProperties("spring.datasource") // 数据源的自动配置的前缀   prefix=
  public DataSource dataSource(){ 
	System.out.println("DataSource Created！！");
    return DataSourceBuilder.create().build(); 
  } 
} 
