package com.jbk.SBAssignt1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jbk.SBAssignt1.entity.Employee;
import com.jbk.SBAssignt1.entity.Manager;


@Configuration
public class SpringConfig {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setAnnotatedClasses(Employee.class,Manager.class);
		return sessionFactory;
	}
}
