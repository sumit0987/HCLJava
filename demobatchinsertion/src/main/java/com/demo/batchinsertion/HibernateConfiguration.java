package com.demo.batchinsertion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Autowired
	DataSource dataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionbean = new LocalSessionFactoryBean();
		localSessionbean.setDataSource(dataSource);
		localSessionbean.setPackagesToScan("com.demo.batchinsertion.entity");
		localSessionbean.setHibernateProperties(hibernateProperties());
		return localSessionbean;
	}
	
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
