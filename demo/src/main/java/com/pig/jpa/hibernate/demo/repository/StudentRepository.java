package com.pig.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pig.jpa.hibernate.demo.entity.Course;
import com.pig.jpa.hibernate.demo.entity.Passport;
import com.pig.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class,id);
	} 
	
	public Student save(Student student) {
		if(student.getId()==null) {
			em.persist(student);   //insert
		}else {
			em.merge(student);     //update
		}
		return student;
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		 em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("G123456");
		em.persist(passport);//先建好被關聯的Passport
		Student student = new Student("Over Pig");
		student.setPassport(passport);
		em.persist(student);

	}
	
	//EntityManager & Persistence Context
	//Transaction
	
	public void someOperationToUnderstandPersistenceContext() {
		
		//Database Operation1 - Retrieve student
		Student student = em.find(Student.class,20001L);
		//Persistence Context(student)
	
		//Database Operation2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context(student,passport)
		
		//Database Operation3 - Update passport
		passport.setnumber("C654321");
		//Persistence Context(student,passport++)
		
		//Database Operation4 - Update student
	    student.setName("Big Pig - Update");
	  //Persistence Context(student++,passport++)
	}
	
	
	public void insertHardCodeStudentAndCourse() {
		Student student = new Student("Wild Pig");
		Course course = new Course("Spring IOC");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student,Course course) {
//		Student student = new Student("Wild Pig");
//		Course course = new Course("Spring IOC");
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
		em.persist(course);
	}
}
