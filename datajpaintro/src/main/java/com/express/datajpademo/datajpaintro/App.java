package com.express.datajpademo.datajpaintro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.express.datajpademo.datajpaintro.config.AppConfig;
import com.express.datajpademo.datajpaintro.dao.StudentDAOImpl;
import com.express.datajpademo.datajpaintro.entity.Student;


public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	StudentDAOImpl studentImpl = configApplicationContext.getBean("studentDAOImpl", StudentDAOImpl.class);
    	
    	Student maven = new Student();
    	
    	maven.setName("maven");
    	maven.setAddress("bsk");
    	maven.setMobile(287619861);
    	
    	studentImpl.saveStudent(maven);
    	
    	
    	
    }
}
