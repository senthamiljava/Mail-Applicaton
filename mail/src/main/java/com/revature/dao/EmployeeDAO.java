package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public List<Employee> getApprovedEmail(int status)
	{
		String sql="SELECT EMAIL_ID,NAME FROM EMPLOYEES WHERE ID IN(SELECT EMP_ID FROM  EMPLOYEE_LEAVE_DETAILS WHERE STATUS_ID=?)";
		List<Employee> mail=jdbcTemplate.query(sql,new Object[]{status},(rse,rows)->
		{
			Employee employee=new Employee();
			employee.setEmail(rse.getString(1));
			employee.setName(rse.getString(2));
			return employee;
		});
		return mail;
	}
	
	public List<Employee> getAllEmployeeEmail()
	{
		String sql="SELECT EMAIL_ID FROM EMPLOYEES";
		List<Employee> mail=jdbcTemplate.query(sql,(rse,rows)->
		{
			Employee employee=new Employee();
			employee.setEmail(rse.getString(1));
			return employee;
		});
		return mail;
	}
}
