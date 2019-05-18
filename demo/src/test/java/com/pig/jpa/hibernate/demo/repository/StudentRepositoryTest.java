package com.pig.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pig.jpa.hibernate.demo.DemoApplication;
import com.pig.jpa.hibernate.demo.entity.Passport;
import com.pig.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student ->{}", student);
		logger.info("passport ->{}", student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport ->{}", passport);
		logger.info("student ->{}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourse() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}",student);
		logger.info("course -> {}",student.getCourses());
		
	}

	@Test
	public void someOperationToUnderstandPersistenceContext() {
		repository.someOperationToUnderstandPersistenceContext();
	}
}
