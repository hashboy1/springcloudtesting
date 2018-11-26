package com.SpringCloudConfigClient.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SpringCloudConfigClient.Model.Employee;






/**
 * 功能概要：User的DAO类

 */
@Mapper
public interface EmployeeDao {

	 Employee selectEmployeeByNo(String EmployeeNo);
	
	  

}
