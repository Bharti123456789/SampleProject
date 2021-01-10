package com.jbk.SBAssignt1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jbk.SBAssignt1.dao.SpringDao;
import com.jbk.SBAssignt1.entity.Employee;
import com.jbk.SBAssignt1.entity.Manager;



@Service
public class SpringService {
	
	@Autowired
	SpringDao springdao;
	
	//Maneger Registration Api
	public String ManagerRegistration(Manager manager) {
		String msg=springdao.ManagerRegistration(manager);
		return msg;
	}
	
	//get all maneger details	
	public List<Manager> getAllmanagerlist() {
		List<Manager> list=springdao.getAllmanagerlist();
		return list;
	}
	
	//login api
	public Manager CheckLogin(Manager manager) {
		Manager user=springdao.CheckLogin(manager);
		return user;
	}
	//get all employee list
	public List<Employee> getAllemployee() {
		List<Employee> emplist=springdao.getAllemployee();
		return emplist;
	}

}
