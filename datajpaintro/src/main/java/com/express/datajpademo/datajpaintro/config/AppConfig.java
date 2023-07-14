package com.express.datajpademo.datajpaintro.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class AppConfig {
	

	@Bean
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(DataSource());
		entityManagerFactoryBean.setPackagesToScan("com.express.datajpademo.datajpaintro.entity");
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		entityManagerFactoryBean.setPersistenceUnitName("mysqlDb");
		
		return entityManagerFactoryBean;
	}

	@Bean
	DataSource DataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl("jdbc:mysql://localhost:3306/test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
		
	}
	
	@Bean
	PlatformTransactionManager transactionManager(@Autowired EntityManagerFactory entityManagerFactory) {
		
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return jpaTransactionManager;
	}

}
