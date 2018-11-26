package com.SpringCloudConfigClient.Controller;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCloudConfigClient.Model.Employee;
import com.SpringCloudConfigClient.Service.EmployeeService;


@RestController
public class TestConfigTontroller {

    
    @Autowired
	EmployeeService es;
    
    
    /*
    @RequestMapping("printConfig")
    public String printConfig(){

    	String returnValue="platform:"+platform;
    	returnValue+=",url:"+url;
    	returnValue+=",username:"+username;
    	returnValue+=",password:"+password;
    	returnValue+=",driverClassName:"+driverClassName;
		return returnValue;
     
    }
    */
    
    @RequestMapping("getEmployee")
   public String getEmployee(@RequestParam(value="Id",required=false) String ID) throws UnknownHostException {
    	
    	System.out.println("id:"+ID);
    	/*
    	String a=null;
    	System.out.println(a.length());
        */
        if (ID == null|| ID.equals("")) return "please input the employee ID";	
    	
    	Employee ee=es.selectUserById(ID);
        
    	/*
        DataSource dataSource = ApplicationContextProvider.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());

        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<?> resultList = jdbcTemplate.queryForList("SELECT RealName  FROM employee");
         Iterator it=resultList.iterator();
         String ee=null;
         while (it.hasNext())
         {
        	 ee=(String) it.next();
        	 System.out.println(ee);
         }
        */
    	if (ee==null) return "The employee ID doesn't exist"; 
    
    	
    	
    	return ee.toString();
    }
    
    
   

}