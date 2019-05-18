package com.pig.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pig.jpa.hibernate.demo.entity.Course;
import com.pig.jpa.hibernate.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
	} 
	
	public Course save(Course course) {
		if(course.getId()==null) {
			em.persist(course);   //insert
		}else {
			em.merge(course);     //update
		}
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		 em.remove(course);
	}
	
	public void playWithEntityManager() {
		
		Course course1 = new Course("Web Service in 100 steps");
		em.persist(course1);

		
		Course course2 = findById(10002L);
		course2.setName("Spring Boot 50 steps - Update!!");
		

	}

	public void addHardcodeReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}",course.getReviews());
		//add 2 reviews to it
		Review review1 = new Review("5", "Great Hand-on Stuff.");  //注意目前建構子未注入course
		Review review2 = new Review("5", "Hatsoff.");              //注意目前建構子未注入course
		
		//setting the relationship
		course.addReview(review1); //記得course(id,name,List<Review>(容納複數個review),lastUpdateDate,createdDate)
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		
		//save it to database
		em.persist(review1);
		em.persist(review2);
		
	}
	
	public void addReviewsForCourse(Long courseId,List<Review> reviews) {
		//get the course 10003
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}",course.getReviews());

		for(Review review:reviews) {
		//setting the relationship
		course.addReview(review); //記得course(id,name,List<Review>(容納複數個review),lastUpdateDate,createdDate)
		review.setCourse(course);

		//save it to database
		em.persist(review);
	
		}
		
	}
}
