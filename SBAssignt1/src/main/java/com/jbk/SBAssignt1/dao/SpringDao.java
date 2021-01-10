package com.jbk.SBAssignt1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.SBAssignt1.entity.Employee;
import com.jbk.SBAssignt1.entity.Manager;

@Repository
public class SpringDao {
	
	@Autowired
	SessionFactory sessionfactory;
	//Maneger Registration Api
	public String ManagerRegistration(Manager manager) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(manager);
		transaction.commit();
		System.out.println(manager.getFirstname()+"");
		return "Register successfully!";
	}
	//get all maneger details
	public List<Manager> getAllmanagerlist() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Manager.class);
		List<Manager> list=(List<Manager>)criteria.list();
		System.out.println(list);
		return list;
	}
	//login api
	public Manager CheckLogin(Manager manager) {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Manager.class);
		criteria.add(Restrictions.eq("email", manager.getEmail()));
		criteria.add(Restrictions.eq("password", manager.getPassword()));
		
		Manager user=(Manager) criteria.uniqueResult();
		System.out.println("user---"+user);
		
			return  user;
		}
	//get all employee
	public List<Employee> getAllemployee() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> listemp=( List<Employee>)criteria.list();

		System.out.println(listemp);
		return listemp;
	}
	

}
