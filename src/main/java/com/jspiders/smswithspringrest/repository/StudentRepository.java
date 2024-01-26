package com.jspiders.smswithspringrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.smswithspringrest.pojo.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public Student addStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
		
	}
	
	public List<Student> getAllStudent() {
		Query query=entityManager.createQuery("SELECT student FROM Student student");
		return query.getResultList();
	}
	
	public Student getStudentById(long id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student student=entityManager.find(Student.class, id);
		entityTransaction.commit();
		return student;
	}
	
	public Student deleteStudent(long id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student=getStudentById(id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
		
	}

}
