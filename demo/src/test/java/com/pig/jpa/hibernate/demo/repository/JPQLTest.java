package com.pig.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pig.jpa.hibernate.demo.DemoApplication;
import com.pig.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class JPQLTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		//課程說此resultlist內包含的物件尚不為Course物件，而是Row type
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultlist = query.getResultList();
		logger.info("jpql_basic:select c from Course c ->{}",resultlist);
		//不過我用下面這行證明確實是Course物件
		logger.info("jpql_basic:type of list inside -> {}",resultlist.get(0) instanceof  Course);
	}
	
	@Test
	public void jpql_typed() {
		//強制限定回傳之物件種類
		TypedQuery<Course> query= em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> resultlist=query.getResultList();
		logger.info("jpql_typed:select c from Course c ->{}",resultlist);
	}
	
	@Test
	public void jpql_where() {
		//WHERE條件
		TypedQuery<Course> query= em.createNamedQuery("query_get_Spring_MVC_100_steps",Course.class);
		List<Course> resultlist=query.getResultList();
		logger.info("jpql_where:select c from Course c ->{}",resultlist);
	}

}
