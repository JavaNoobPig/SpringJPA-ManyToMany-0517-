package com.pig.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pig.jpa.hibernate.demo.entity.Course;
import com.pig.jpa.hibernate.demo.entity.Review;
import com.pig.jpa.hibernate.demo.entity.Student;
import com.pig.jpa.hibernate.demo.repository.CourseRepository;
import com.pig.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.saveStudentWithPassport();
//		repository.playWithEntityManager();
//		courseRepository.addHardcodeReviewsForCourse();
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5","Great Hand-on Stuff."));
//		reviews.add(new Review("5","Hatsoff."));
//
//		courseRepository.addReviewsForCourse(10003L, reviews);
		
//		studentRepository.insertHardCodeStudentAndCourse();
		studentRepository.insertStudentAndCourse(new Student("Wild Pig"),new Course("Spring IOC"));
	}

}
