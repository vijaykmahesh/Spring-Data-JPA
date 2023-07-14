
package com.express.datajpademo.datajpaintro.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.express.datajpademo.datajpaintro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentDAOImpl {

	@PersistenceContext(name = "mysqlDb")
	EntityManager entityManager;

	@Transactional
	public void saveStudent(Student student) {

		entityManager.persist(student);

		System.out.println("record inserted");

	}

}
