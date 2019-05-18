package com.pig.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pig.jpa.hibernate.demo.DemoApplication;
import com.pig.jpa.hibernate.demo.entity.Course;
import com.pig.jpa.hibernate.demo.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class,50001L);
		logger.info("{}",review.getCourse());
	}
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course=repository.findById(10001L);
		logger.info("{}",course.getReviews());
	}
	
	@Test
	public void findById_basic() {
		Course course=repository.findById(10002L);
		assertEquals("Spring Boot 50 steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		//SELECT的測試
		Course course = repository.findById(100001L	);
		assertEquals("Spring JPA Course", course.getName());
		
		//UPDATE的測試
		course.setName("Spring JPA Course - Update");
		repository.save(course);
		//Check value
		Course courseAfterUpdate = repository.findById(100001L);
		assertEquals("Spring JPA Course - Update", courseAfterUpdate.getName());
	}
}
