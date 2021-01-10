package com.jbk.SBAssignt1.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.SBAssignt1.entity.Employee;
import com.jbk.SBAssignt1.entity.Manager;
import com.jbk.SBAssignt1.service.SpringService;



@CrossOrigin
@RestController
public class SpringController {

	@Autowired
	SpringService springservice;
	
	@RequestMapping("/getstring")
	public String getstring() {
		return " Welcome Spring Boot Project";
		}
	
	//Maneger Registration Api
	
		@PostMapping("/registeration")
		public String AdminRegistration(@RequestBody Manager manager){
			{
				System.out.println("username:-"+manager.getFirstname());
				String msg=springservice.ManagerRegistration(manager);
				return msg;
				}}
		
	//get all maneger details		
	@GetMapping("/getallmanager")
			public List<Manager> getAllmanager()
			{
				List<Manager> list=springservice.getAllmanagerlist();
				return list;
			}
	// manager login api
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public HashMap CheckLogin(@RequestBody  Manager manager){
	
		System.out.println("Emailid--"+manager.getEmail()+"Password"+manager.getPassword());
		Manager user=springservice.CheckLogin(manager);
		System.out.println("controller user"+user);
		HashMap hm=new HashMap();
		if (user==null) {
			hm.put("msg","Invalid User");
		} else {
			user.setPassword("*******");
			hm.put("msg","Valid User");
			hm.put("userobj",user);
		}
	return hm;
	}
// show list of employee	
	  @GetMapping("/getallemployee")
	  public List<Employee> getAllemployee()
	  {
		List<Employee> list=springservice.getAllemployee();
		return list;
	    }
	
}
